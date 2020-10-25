package controlloData;

public class MyData {
	
	private int giorno;
	private int mese;
	private int anno;
	private String formato;
	boolean flag = false;
	
	public void setGiorno(int giorno) {
		
			if(!flag) {
				
				switch (mese) {
				
				case 1:
				case 3:
				case 5:
				case 7:
				case 8:
		    	case 10:
				case 12: 
						if(giorno<=31 && giorno>0)
							this.giorno = giorno;
						
						else {
							System.err.println("Non esiste il giorno "+giorno+" nel mese indicato");
							flag=true;
						}
							break;
				
				case 4:
				case 6:
				case 9:
				case 11: 
						if(giorno<=30 && giorno>0)
							this.giorno = giorno;
						
						else {
							System.err.println("Non esiste il giorno "+giorno+" nel mese indicato");
							flag=true;
						}
							break;
				
				case 2: 
						if(giorno<=28 && giorno>0)
							this.giorno = giorno;
						
						else {
							System.err.println("Non esiste il giorno "+giorno+" nel mese indicato");
							flag=true;
						}
							break;	
				}
			}
	}
	
	public int getGiorno() {
		return giorno;
	}
		
	public void setMese(int mese) {
		
		if(mese>0 && mese<13)
			this.mese = mese;
		
		else {
			System.err.println("Non esisiste questo mese"); 
			flag=true;
		}
			
	}
	
	public int getMese() {
		return mese;
	}
	
	public void setAnno(int anno) {
		
		if(!flag) {
			
			if(anno<=9999)
				this.anno = anno;
			
			else {
				System.err.println("Non puoi scrivere un anno maggiore del 2020");
				flag=true;
			}
		}
			 
	}
	
	public int getAnno() {
		return anno;
	}
	
	public void setFormato(String formato) {
		
		if(formato.contentEquals("it") || formato.contentEquals("en"))
			this.formato = formato;
	}
	
	public String toString() {
		
		if(formato.contains("it"))
			return (this.giorno+"/"+this.mese+"/"+this.anno);
		
		else if(formato.contains("en"))
			return (this.mese+"/"+this.giorno+"/"+this.anno);
		
		else
			return("Questo formato non e' disponibile");			
	}
}
