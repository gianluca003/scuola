/* Metodi public:  
 * chiamata(String) = Passiamo il numero del destinatario e avvia i metodi chiamataEffettuata, minuti, setRegistro per simulare la chiamata e assegna al creditoI il valore del credito residuo
 * getMinuti() =  Restituisce con un tipo String il tempo trascorso durante una chiamata
 * getRegistro() = Restituisce con un tipo String il registro delle chiamate effettuate
 * controlloCredito() = Restituisce un boolean in cui con vero indica la presenza di soldi nell'oggetto, falso il valore del credito pari a zero
 * setCredito(float) = Passiamo con un float la cifra che vogliamo caricare/settare nel credito
 * getCredito() = Restituisce con un float il valore del credito residuo
 * setTariffa(float, int) = Settiamo la tariffa passando con un float il valore dei centesimi al secondo che spenderemo, con int il valore dello scatto alla risposta
 * getChiamateEffettuate() = Restituisce con un int il numero di chiamate effettuate 
 * myTariffa() = Restituisce con un tipo String il nostro piano tariffario
 * getMyNumero() = Restituisce con un tipo String il nostro numero di telefono
 * 
 * Metodi private:
 * setMinuti() = Esegue il conto del tempo stampandolo a video sottraendo per ogni secondo che passa il costo della tariffa
 * setRegistro() = Setta il registro delle chiamate facendo scalare tutti gli elementi del vettore di stringhe di un posto, aggiungendo infine nella posizione 0 del vettore l'ultima chiamata effettuata
 * setChiamateEffettuate() = Incrementa il valore della variabile int chiamataEffettuata, ogni volta che facciamo una chiamata
 */

package sim;

import  java.util.Date;

public class SIM {

	private Date s; //oggetto s di tipo Date
	private float sc; //prende il valore del secondo corrente che verrà confrontato con sec (sc prende sempre il valore del secondo corrente  rischiando di avere un tot. di secondi uguali, questa variabile sarà di riferimento)
	private int sec; //secondo della chiamata che si incrementa ogni secondo corrente che passa
	private int min; //registra i minuti passati nella chiamata
	private boolean fm; //flag minuti, sara true solo per il primo ciclo del while per decrementare di scattoRisposta il creditp
	
	private String numero; //numero dell'utente
	private String numeroD; //numero destinatario
	
	private int chimateEffettuate; //numero delle volte che l'utente fa una chiamata
	private String[] registro;  //Vettore che registra le chiamate il tempo e i soldi spesi 
	
	private float creditoI; //credito iniziale (lo uso per calcolare il credito speso facendo credito iniziale - credito resiudo)
	private float credito;  //credito residuo
	
	private int scattoRisposta; 
	private float tariffa; //centesimi spesi al secondo
	
	public SIM(String numero, int credito, float tariffa, int scattoRisposta, int registro) { //costruttore
	
		this.numero = numero;
		setCredito(credito);
		this.tariffa=tariffa;
		this.registro = new String[registro];
		this.scattoRisposta= scattoRisposta;
	}
	
	
	public void chiamata(String numeroD) { //chiamata
		this.numeroD=numeroD;
			setChiamateEffettuate();
			setMinuti();
			setRegistro();
			this.creditoI=this.credito;
	}
	
	
	private void setMinuti() { //setMinuti
			fm=true;
			this.min=0;
			this.sec=0;
			
			if(getCredito()>scattoRisposta) //se il credito è maggiore del costo dello scatto alla risposta
				while(this.credito>this.tariffa) { //fin quando il credito è maggiore del valore della tariffa (se è minore, la tariffa non può essere pagata)
					s=new Date(); //crea sempre l'oggetto per far cambiare il valore dei secondi correnti(ogni volta che viene chiamato l'oggetto, 
					//il secondo corrente cambia, se lo chiamo solo una volta il valore del secondo corrente rimane costante)
					
					if(fm) {   //vale solo durante il primo ciclo
						this.credito-=this.scattoRisposta;
						fm=false;
					}
					
					if(sc!=s.getSeconds()) { //se il valore di sc(*) è diverso dal valore corrente
						this.sec+=1;
						this.credito=(float)(Math.round(this.credito*100.0)/100.0)-this.tariffa; //cast di float prendendo solo due decimali
						
						if(sec==59) {
							this.min+=1;
							this.sec=0;
						}
						System.out.println(this.min+":"+this.sec);
					}	
					sc=s.getSeconds(); 	//(*)prende per un tot. di cicli lo stesso secondo corrente a causa della velocita' di esecuzione
				}
	}
	
	
	public String getMinuti() { //getMinuti
		return this.min+":"+this.sec;
	}
	
	
	private void setRegistro() {  //setElencoTelefonate

		for(int i=(this.registro.length-1); i>0; i--) //fa scalare di una posizione ogni chiamata effettuata
			this.registro[i]=this.registro[i-1]; 
		this.registro[0]= "Chiamata effettuata a "+this.numeroD+" durata "+getMinuti()+" minuti "+" spendendo € "+(float)(Math.round((this.creditoI-this.credito)*100.0)/100.0);
	}
	
	 
	public void getRegistro() { //getElencoTelefonate
			
			for(int i=0;i<registro.length;i++)
				System.out.println(this.registro[i]);
	}
	
	
	public boolean controlloCredito() {  //controlloCredito
		
		if(this.credito>0)
			return true;
		else 
			return false;
	}
	
	
	public boolean setCredito(float credito) { //setCredito
		
		if(credito<=10 && credito>0) {
			this.credito+=credito;
			this.creditoI=this.credito;
			return true;
		}
		else
			return false;	
	}
	
	
	public float getCredito() { //getCredito
		
		return (float)(Math.round((this.credito)*100.0)/100.0); 
	}
	
	
	public void setTariffa(float tariffa, int scattoRisposta) {//setTariffa
		this.tariffa=tariffa;
		this.scattoRisposta=scattoRisposta;
	}
	
	private void setChiamateEffettuate() { //setChiamateEffettuate
		this.chimateEffettuate++;
	}
	
	public int getChiamateEffettuate() { //getChiamateEffettuate
		return this.chimateEffettuate;
	}
	
	public String myTariffa() { //myTariffa
		return "€ "+scattoRisposta+" scatto alla risposta + "+tariffa+"cent./s";
	}
	
	public String getMyNumero() { //getMyNumero
		return this.numero;
	}
}

