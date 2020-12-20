package giocoDadi;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
			
			Scanner sc = new Scanner (System.in); 
			Dado[] dado = new Dado [5];
			Gioco gioco = new Gioco();
			String nomeUtente;
			String lancio;
			int ciclo = 0;
			int giocatore; // (0= Pc 1= Utente)
	
			for(int i=0; i<dado.length; i++) 
				dado[i] = new Dado (6);
			
			System.out.print("**************Benvenuto**************\n"
					+ "Come ti chiami? ");
			nomeUtente=sc.next();
			
			System.out.println("\nChi inizia per prima, pari o dispari?");		
			giocatore=gioco.inizio(sc.next(), dado);	
			
			if(giocatore == 1) 
				System.out.println("Bene hai vinto, inizia te!");
			
			else
				System.out.println("Mi spiace hai perso, inizio io!");
			
			
			do {
				
				if(giocatore == 1) {
					System.out.println("\n**Tocca a "+nomeUtente+"**"
							+ "\nPremi qualsiasi carattere per lanciare");
					lancio = sc.next();
				}
				
				else
					System.out.println("\n**Tocca a PC**");
				
				System.out.print("Sono usciti i numeri: ");
				for(int i=0; i<dado.length; i++)
					System.out.print(dado[i].lancio()+" ");
				System.out.println();
				
				gioco.setPunti(dado,giocatore);
				
				System.out.println(gioco.risultato(dado));
				
				if(giocatore == 1) {
					System.out.println("Hai ottenuto "+gioco.getPunti()+" punti!\n");
					giocatore=0;
				}
				
				else {
					System.out.println("Ho ottenuto "+gioco.getPunti()+" punti!\n");
					giocatore=1;
				}
				
				ciclo++;
				
			}while(ciclo<20); // 10 lanci a testa
				
			if(gioco.getPuntiGiocatore(0) > gioco.getPuntiGiocatore(1)) 
				System.out.println("Mi spiace, ti sei fatto battere da un computer...");
		
			else
				System.out.println("Complimenti, hai vinto!!!");
			
			System.out.println("Computer= "+gioco.getPuntiGiocatore(0)+" punti\n"+nomeUtente+"= "+gioco.getPuntiGiocatore(1)+" punti");
				
		}

}
