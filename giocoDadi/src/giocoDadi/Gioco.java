
package giocoDadi;

public class Gioco {
	
	private int contatoreTr; // mi serve per capire se l'utente ha fatto tris (contatore = 3)
	private int contatorePo; // mi serve per capire se l'utente ha fatto pocker (contatore = 5) 
	private int contatoreSc; // mi serve per capire se l'utente ha fatto scala (scala = 5)
	private int nP;   //numero Precedente per la scala
	private int punti;
	private int puntiUtente;
	private int puntiPc;
	private Dado scambio;// memorizza il dado di cui deve cambiare la posizione per ordinare il vettore "dado" in ordine crescente
	private int i;
	private int y;
	
	public Gioco() {
	}
	
	public int inizio (String inizio, Dado[] dado) {
		
		dado[0].lancio();
		
		if(dado[0].leggi()%2 == 0 && inizio.equals("pari") || dado[0].leggi()%2 != 0 && inizio.equals("dispari")) {
			System.out.println(dado[0].leggi());
			return 1;
		}
			
		
		else {
			System.out.println(dado[0].leggi());
			return 0;
		}
	}	
	
	private void ordinaNumeri(Dado[] dado) {
		
		for(this.i=0; this.i<dado.length; this.i++) {
			for(this.y=this.i; this.y<dado.length; this.y++) {
				
				if(dado[i].leggi() > dado[y].leggi()) {
					this.scambio = dado[i];
					dado[i] = dado[y];
					dado[y] = this.scambio; 
				}
			}
		}
	}
	
	public void setPunti(Dado[] dado, int giocatore){
		
		ordinaNumeri(dado);				//prima ordiniamo i numeri per poterli gestire meglio
		this.contatorePo=dado.length;	//contatore pocker = numero dei dadi (es. 5 dadi, contatorePo=5)
		this.contatoreSc=0;				// uguale a 0 perché ogni volta che chiamo il metodo il contatore parte da 0
		this.nP=dado[0].leggi()-1;      //assume il valore della prima casella di 0 -1 per confrontare lo stesso vale all'interno dell'if (mi serve solo la prima volta) *
		this.contatoreTr=0;             // uguale a 0 perché ogni volta che chiamo il metodo il contatore parte da 0
		
		for(this.i=0; this.i<dado.length; this.i++) {
							
				if(dado[i].leggi() != dado[0].leggi())   //se il dado[i] è diverso al primo numero allora non è pocker allora si decrementa per indicare ceh non si tratta di un pocker (il pocker parte col contatore = 5, pocker se non varia in questa istruzione rimane 5, quindi tutti i numeri sono uguali e non sono stati decrementati)
					this.contatorePo--;					// indicare che non si tratta di un pocker (il pocker parte col contatore = 5, pocker se non varia in questa istruzione rimane 5, quindi tutti i numeri sono uguali e non sono stati decrementati)
			
				if(dado[i].leggi() == dado[2].leggi())     //se il numero di dado[i] è uguale a dado.length/2 oppure a 2 allora incrementa il contatore Tris (la meta di 4 è due, in quel punto ci sarà sicuramente il numero ripetuto tre volte)
					this.contatoreTr++;
			
				if(dado[i].leggi()-1 == this.nP)  //* se il numero del dado-1 è uguale al numero precedente, allora sono in scala
					this.contatoreSc++;
				 
				this.nP=dado[i].leggi();    //numero Precedente assume il valore del dado attuale
		}

		if (this.contatorePo == 5)
			this.punti = 30 * dado[0].leggi();
		
		else if (this.contatoreTr >= 3)       //maggiore uguale perché ci posso essere 4 numeri uguali (es. 1 1 1 1 3)
			this.punti = 3 * dado[2].leggi();
		
		else if (this.contatoreSc == 5) {
			
			if (dado[0].leggi() == 1)
				this.punti=25;
			
			else
				this.punti=28;	
		}
		
		else
			this.punti = 0;
		
		if(giocatore == 0)						//assegnamo i punti al giocatore che ha lanciato i dadi
			this.puntiPc += this.punti;
		else
			this.puntiUtente += this.punti;
	}
	
	public String risultato(Dado[] dado) {
		
		if (this.contatorePo == 5)
			return "Pocker!!!";
		
		else if (this.contatoreTr == 3)
			return "Tris!";
		
		else if (this.contatoreSc == 5) 
			return "Scala!";
		
		else 
			return "nulla...";
	}
	
	public int getPunti () {
				return this.punti;
	}
	
	public int getPuntiGiocatore (int giocatore) {
		
		if(giocatore == 0)
			return this.puntiPc;
		else
			return this.puntiUtente;
	}
	
}
