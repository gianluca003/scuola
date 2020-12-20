/*Metodi:
 * set e get di tutti gli attributi
 * toString= Passiamo tutti i valori degli attributi attraverso uno String
 * cancellaDati= Assegna a tutti gli attributi il valore di null
 */
package garage;

public class Auto {
	
	private String targa;
	private String marca;
	private String modello;
	private String cf;
	
	public Auto(String targa, String marca, String modello, String cf) {
		
		this.targa=targa;
		this.marca=marca;
		this.modello=modello;
		this.cf=cf;
	}

	public String getTarga() {
		return targa;
	}

	public void setTarga(String targa) {
		this.targa = targa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public String getCf() {
		return cf;
	}

	public void setCf(String cf) {
		this.cf = cf;
	}
	
	public void cancellaDati() {
		
		this.targa=null;
		this.marca=null;
		this.modello=null;
		this.cf=null;
	}
	
	public String toString() {
		return "Auto [targa=" + targa + ", marca=" + marca + ", modello=" + modello + ", cf=" + cf + "]";
	}

}
