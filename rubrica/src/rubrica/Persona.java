package rubrica;

public class Persona {
	
	private String nome;
	private String cognome;
	private String indirizzo;
	private String citta;
	
	private String numero;

	public Persona(){
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCognome() {
		return cognome;
	}
	
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	public String getIndirizzo() {
		return indirizzo;
	}
	
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}


	public String toString() {
		return "Nome= " + nome + ", Cognome= " + cognome + ", Indirizzo= " + indirizzo + ", Numero= " + numero+", Citta= "+citta;
	}
}
