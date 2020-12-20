/*Metodi:
 * postoLibero= Restituisce con un int la posizione del parcheggio vuoto, se tutti i parcheggi sono pieni restituisce -1
 * autoEstitente= Restituisce con un boolean true, se la targa della macchina inserita è già presente nel parcheggio, false se la targa della mia macchina non è presente nel parcheggio
 * posAuto= Restituisce la posizione nel parcheggio della macchina di cui abbiamo passato la targa
 * autoEntra= Passiamo una variabile tipo auto che verrà memorizzata all'interno di un oggetto di tipo Auto parcheggio di posizione libera (parcheggio[pos])
 * autoEsce= Restituisce un boolean true, se la macchina della targa che passiamo viene rimossa dal parcheggio, false se non trova la macchina senza poterla rimuovere dal parcheggio
 * visualizzaPostiLiberi= Stampa tutti i parcheggi liberi
 * datiMacchina= Stampa tutti i dati della macchina di cui passiamo la targa
 */

package garage;

public class Garage {
	
	private Auto[] parcheggio;
	private int pos; //posizione/parcheggio libero nel garage
	private int i; //indice per i vettori
	
	public Garage(int parcheggi) {
		this.parcheggio= new Auto[parcheggi];
		for(i=0;i<parcheggi; i++) { //in base al numero di parcheggi il for crea gli oggetti di indice i (es. 10 parcheggi = 10 oggetti)
			this.parcheggio[i]= new Auto(null, null, null, null);
		}
		
	}
	
	public int postoLibero() {
		
		for(pos=0; pos<parcheggio.length; pos++) {
			
			if(this.parcheggio[pos].getTarga()==null) 
				return pos;
		}
		return -1;
		
	}
	
	public boolean autoEsistente(String targa) {
	
		for(i=0; i<parcheggio.length; i++) {
			
			 {
				if(targa.equals(this.parcheggio[i].getTarga())) {
					return true;
				}
			}		
		}
		
	    return false;
		
	}
	
	public int posAuto(String targa) {
			
		for(i=0; i<parcheggio.length; i++) {
					
			if(targa.equals(this.parcheggio[i].getTarga())) {
					return i+1;	
				}
		    }
	    return -1;

		}
	
	public void autoEntra(Auto auto) {
		
		postoLibero();
		this.parcheggio[pos].setTarga(auto.getTarga());
		this.parcheggio[pos].setMarca(auto.getMarca());
		this.parcheggio[pos].setModello(auto.getModello());
		this.parcheggio[pos].setCf(auto.getCf());
	}
	
	public boolean autoEsce(String targa) {
		
		for(i=0; i<parcheggio.length; i++) {
			
			if(targa.equals(this.parcheggio[i].getTarga())) {		
					parcheggio[i].cancellaDati();
					return true;		
			}
		}
		
		return false;
	}
	
	public void visualizzaPostiLiberi() {
		
		for(i=0; i<parcheggio.length; i++) {
			
			if(this.parcheggio[i].getTarga()==null)
				System.out.println(i+1);
		}
	}
	
	public void datiMacchina(String targa) {
		
		for(i=0; i<parcheggio.length; i++) {
			
			if(targa.equals(this.parcheggio[i].getTarga())) {
				
					System.out.println("Parcheggio: "+(i+1));
					System.out.println("targa: "+this.parcheggio[i].getTarga());
					System.out.println("Marca: "+this.parcheggio[i].getMarca());
					System.out.println("Modello: "+this.parcheggio[i].getModello());
					System.out.println("CF Proprietario: "+this.parcheggio[i].getCf());
					break;
			}
		}
	}
	
}