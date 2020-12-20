package dado;

import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int facce;
		Dado dado;
		int opzione=3;
		boolean f; //flag facce
		boolean loop = true;
		
		do {
			System.out.println("Quante facce vuoi nel dado? (6-120)");
			facce=sc.nextInt();
			
			if(facce<6 || facce>120){
				
				System.err.println("Il dado puo' avere minimo 6 facce massimo 120");
				f=true;
			}
			
			else
				
				f=false;
			
					
		}while(f);
		
		dado= new Dado(facce);
	
		do {
			
			System.out.println("\nDado:\n"
					+ "1) Lancia\n"
					+ "2) Leggi\n"
					+ "3) Esci");
			
			opzione=sc.nextInt();
				
				switch(opzione) {
	
				case 1:
					System.out.println("E' uscito il numero: "+dado.lancio());
					break;
					
				case 2:
					System.out.println("Numero: "+dado.leggi());
					break;
					
				case 3:
					System.out.println("Alla prossima!");
					loop=false;
					break;
					
					default:
						System.out.println("Non esiste l'opzione "+opzione);
				}

		}while(loop);
	}
}
