/*
 * Programma che esegue un metodo della classe SIM tramite oggetto creato nel main, scelto in un menù gestito da uno switch 
 * creato nella classe principale.
 */


package sim;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		SIM sim = new SIM ("+39 3"+(int)(Math.random()*1000000000), 0, (float) 0.4, 1, 10); //"+39 3"per assegnare un generico iniziale del numero, 0 euro accreditati, 0.4 cent./s, 1 scatto alla risposta, 10 spazio registro chiamate
		int opzione;
		String numeroD; //numero destinatario 
		int tariffa; //opzione della tariffa scelta
		boolean f=true; //fa ripetere il ciclo fin quando non si sceglie l'opzione 9 
		
		System.out.println("Benvenuto, ti sono stati accreditati € 0 sul tuo nuovo numero: "+sim.getMyNumero()+"");
		
		do {
			System.out.println("\nScegli un opzione:\n"
					+ "1)Chiamata         2)Ricarica\n"
					+ "3)Credito Residuo  4)Registro telefonate\n"
					+ "5)Il mio numero    6)Cambia tariffa\n"
					+ "7)La mia Tariffa   8)Numero chiamate effettuate\n"
					+ "9)Spegni\n");
			
			if(!sc.hasNextInt())
			{
				System.err.println("Devi inserire un numero");
				sc.nextLine();
			}
			else {
				
				opzione=sc.nextInt();
				
				switch(opzione) {
				
				case 1: 
					if(sim.controlloCredito()) { //se il credito è superiore a zero 
						System.out.println("\nDigita il numero che vuoi chiamare");
						numeroD=sc.next();
						System.out.println("\nChiamo a "+numeroD+"\n"+"tempo trascorso:");
						sim.chiamata(numeroD);
						System.err.println("Credito esaurito");		
						System.out.println("Chiamata terminata \n(Controlla il credito residuo premendo '3')");
					}
					else 
						System.err.println("Credito insufficiente");
					break;
					                   
				case 2: 
					System.out.print("\nDigita l'importo della ricarica (max. € 10) \n€");
					if(sim.setCredito(sc.nextFloat())) 
						System.out.println("Ricarica avvenuta con successo!");
						
					else
						System.err.println("Non puoi ricaricare la sim con un importo superiore a € 10 o minore di € 0");	
					break;
					
				case 3: 
					System.out.println("\nIl tuo credito residuo è di € "+sim.getCredito());
					break;
					
				case 4:
					System.out.println("\nUltime telefonate:");
					sim.getRegistro();
					break;
					
				case 5:
					System.out.println("\nIl tuo numero è: "+sim.getMyNumero());
					break;
					
				case 6:
					System.out.println("\nTariffe (seleziona la tariffa a cui è interessato):\n"
							+ "1) €1 Scatto alla Risposta + 0.40cent./s\n"
							+ "2) €3 Scatto alla Risposta + 0.20cent./s\n"
							+ "3) €5 Scatto alla Risposta + 0.10cent./s\n"
							+ "4) Indietro");
					tariffa=sc.nextInt();
					
					switch(tariffa) {
					case 1: sim.setTariffa((float)0.4, 1); System.out.println("Operazione eseguita con successo!"); break;
					case 2: sim.setTariffa((float)0.2, 3); System.out.println("Operazione eseguita con successo!"); break;
					case 3: sim.setTariffa((float)0.1, 5); System.out.println("Operazione eseguita con successo!"); break;
					case 4:break;
						default:
							System.err.println("Mi spiace non esiste la tariffa "+tariffa);  
					}break;
					
				case 7:
					System.out.println("\nLa sua tariffa è di "+sim.myTariffa());
					break;
					
				case 8:
					System.out.println("\nHai effettuato "+sim.getChiamateEffettuate()+" chiamate");
					break;
					
				case 9:
					System.out.println("\nGrazie per aver usufruito del nostro servizio!");
					f=false;
					break;
					
				default:
					System.err.println("non esiste l'opzione "+opzione);
				} 
			}
		}while(f);
	}
}
