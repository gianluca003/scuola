package rubrica;

public class Rubrica {
	
	private Persona[] rubrica;
	private int i, y;
	private int spazioLibero;
	private String scambio;
	
	public Rubrica(int spazio){
		
		this.rubrica = new Persona[spazio];
		for(i=0; i<spazio; i++)
			this.rubrica[i] = new Persona();
	}
	
	public int spazioLibero() {
		
		for(i=0; i<rubrica.length; i++) {
			if(rubrica[i].getNumero() == null) {
				return this.i; 
			}
		}
		return -1;
	}
	
	public boolean rubricaVuota() {
		
		for(i=0; i<rubrica.length; i++) {
			if(rubrica[i].getNome() != null)
				return false;
		}
		return true;
	}
	
	private void ordina() {
		
		for(i=0; i<rubrica.length; i++) {
			for(y=i; y<rubrica.length; y++) {
				
				if(rubrica[i].getNome() != null && rubrica[y].getNome() != null) {
					if(rubrica[i].getNome().compareToIgnoreCase(rubrica[y].getNome()) > 0) {
						
						this.scambio = rubrica[i].getNome();
						rubrica[i].setNome(rubrica[y].getNome());
						rubrica[y].setNome(this.scambio);
						
						this.scambio = rubrica[i].getCognome();
						rubrica[i].setCognome(rubrica[y].getCognome());
						rubrica[y].setCognome(this.scambio);
						
						this.scambio = rubrica[i].getCitta();
						rubrica[i].setCitta(rubrica[y].getCitta());
						rubrica[y].setCitta(this.scambio);
						
						this.scambio = rubrica[i].getIndirizzo();
						rubrica[i].setIndirizzo(rubrica[y].getIndirizzo());
						rubrica[y].setIndirizzo(this.scambio);
						
						this.scambio = rubrica[i].getNumero();
						rubrica[i].setNumero(rubrica[y].getNumero());
						rubrica[y].setNumero(this.scambio);						
					}
				}
			}
		}
	}
	
	public void inserisci(Persona p) {
		
		this.spazioLibero = spazioLibero();
		
		if(spazioLibero != -1)
			
			this.rubrica[this.spazioLibero].setNome(p.getNome());
			this.rubrica[this.spazioLibero].setCognome(p.getCognome());
			this.rubrica[this.spazioLibero].setIndirizzo(p.getIndirizzo());
			this.rubrica[this.spazioLibero].setNumero(p.getNumero());
			this.rubrica[this.spazioLibero].setCitta(p.getCitta());
		
		ordina();
	}
	
	public void rimuovi(int pos) {
		
		for(pos--, i=0; i<rubrica.length; i++) {  //poss- perchè quando stampiamo l'elenco facciamo i+1 per evitare lo 0
			if(i == pos) {
				
				this.rubrica[i].setNome(null);
				this.rubrica[i].setCognome(null);
				this.rubrica[i].setIndirizzo(null);
				this.rubrica[i].setNumero(null);
				this.rubrica[i].setCitta(null);
			}	
		}
	}
	
	public boolean cercaNumero(String n) {
		
		for(i=0, y=0; i<this.rubrica.length; i++) {
			
			if(rubrica[i].getNome() != null) {
				if(n.equals(rubrica[i].getNumero()))
					return true;
			}
		}	
		return false;
	}
	
	public int numeroCercaDato(String dato) {
			
			for(i=0, y=0; i<this.rubrica.length; i++) {
				
				if(rubrica[i].getNome() != null) {
					if(rubrica[i].getNome().equalsIgnoreCase(dato) || rubrica[i].getCognome().equalsIgnoreCase(dato)  || rubrica[i].getIndirizzo().equalsIgnoreCase(dato)  || rubrica[i].getNumero().equalsIgnoreCase(dato) || rubrica[i].getCitta().equalsIgnoreCase(dato)) 
						y++;
				}
			}	
			return y;
		}
	
	public void stampaCercaDato(String dato) {
		
		for(i=0; i<this.rubrica.length; i++) {
			
			if(rubrica[i].getNome() != null) {
				if(rubrica[i].getNome().equalsIgnoreCase(dato) || rubrica[i].getCognome().equalsIgnoreCase(dato) || rubrica[i].getIndirizzo().equalsIgnoreCase(dato) || rubrica[i].getNumero().equalsIgnoreCase(dato) || rubrica[i].getCitta().equalsIgnoreCase(dato)) 
					System.out.println(i+1+") "+rubrica[i]);	
			}
		}
	
	}
	
	public void stampaRubrica(int filtro) {
		
		for(i=0; i<rubrica.length; i++) {
			
			if(rubrica[i].getNome() != null) {
				
				System.out.println("|--"+this.rubrica[i].getNome().toUpperCase().charAt(0));
				
				switch(filtro) { //case 1: stampa tutte le informazioni - case 2: solo nome e cognome  - case 3 : solo nome e indirizzo - case 4: solo nome e  numero
				
				case 1:
					
					for(y=i; rubrica[y].getNome() != null && this.rubrica[y].getNome().toUpperCase().charAt(0) == this.rubrica[i].getNome().toUpperCase().charAt(0); y++)
						System.out.println("| "+rubrica[y]);
					break;
					
				case 2:
					for(y=i; rubrica[y].getNome() != null && this.rubrica[y].getNome().toUpperCase().charAt(0) == this.rubrica[i].getNome().toUpperCase().charAt(0); y++)
						System.out.println("| Nome: "+rubrica[y].getNome()+" Cognome: "+rubrica[y].getCognome());
					break;
					
				case 3:
					for(y=i; rubrica[y].getNome() != null && this.rubrica[y].getNome().toUpperCase().charAt(0) == this.rubrica[i].getNome().toUpperCase().charAt(0); y++)
						System.out.println("| Nome: "+rubrica[y].getNome()+" Citta': "+rubrica[y].getCitta());
					break;
					
				case 4:
					for(y=i; rubrica[y].getNome() != null && this.rubrica[y].getNome().toUpperCase().charAt(0) == this.rubrica[i].getNome().toUpperCase().charAt(0); y++)
						System.out.println("| Nome: "+rubrica[y].getNome()+" Indirizzo: "+rubrica[y].getIndirizzo());
					break;
					
				case 5:
					for(y=i; rubrica[y].getNome() != null && this.rubrica[y].getNome().toUpperCase().charAt(0) == this.rubrica[i].getNome().toUpperCase().charAt(0); y++)
						System.out.println("| Nome: "+rubrica[y].getNome()+" Numero: "+rubrica[y].getNumero());
					break;
				}
				i=y-1; 
			}
		}
	}
}
