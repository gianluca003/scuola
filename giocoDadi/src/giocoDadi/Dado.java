package giocoDadi;

public class Dado {
	
	private int facce;
	private int n;
	
	public Dado(int facce) {
		
		if(facce>=6 || facce<=120)
			this.facce = facce;
		else
			this.facce = 0;
	}
	
	public int lancio() {

		n = (int)((Math.random()*facce)+1); 
		
		return n;
	}
	
	public int leggi() {
		return n;
	}
	
}
