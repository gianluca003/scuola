package garage;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		Garage parcheggio = new Garage(10); //oggetto garage che contiene 10 parcheggi
		Auto auto = new Auto(null,null,null,null);
		String targa;  //targa
		String cf; //codice fiscale
		int opzione;
		boolean f=true;
		
		do {
			System.out.println("\nBenvenuto nel nostro garage:\n"
					+ "1)Aggiungi la tua macchina\n"
					+ "2)Ritira la tua macchina\n"
					+ "3)Trova la mia macchina\n"
					+ "4)Visualizza i posti liberi\n"
					+ "5)Esci\n");
			
			if(!sc.hasNextInt()) {
				System.err.println("Devi scrivere un numero");
				sc.nextLine();
			}
			
			else {
				opzione=sc.nextInt();
				
				switch(opzione) {
				
				case 1:
					if(parcheggio.postoLibero()==-1) {
						System.err.println("Ci spiace ma non ci sono parcheggi disponibiili al momento");
					}
					
					else {
						System.out.println("Inserisci i dati della macchina:");
						System.out.print("\n--Targa (xx.xxxxx): "); 
						targa=sc.next();
						
						if(targa.length()!=8) {
							System.err.println("La targa deve contenere 7 caratteri (escluso il punto)");
							targa=null;
						}
						
						else {
							
							auto.setTarga(targa);
							System.out.print("\n--Marca: "); auto.setMarca(sc.next());
							System.out.print("\n--Modello: "); auto.setModello(sc.next());
							System.out.print("\n--Codice Fiscale (16 caratteri): "); 
							cf=sc.next();
							
							if(cf.length()!=16) {
								System.err.println("Il codice fiscale deve contenere 16 caratteri alfanumerici");
								auto.cancellaDati();
							}
							
							else {
								
								auto.setCf(cf);
								
								if(parcheggio.autoEsistente(targa)) {
									
									System.err.println("La targa "+targa+" risulta già registrata");
								}
								
								else {
									
									System.out.println("\nOperazione effettuata con successo!");
									parcheggio.autoEntra(auto); 	
								}
							}
						}
					}	
					break;
					
				case 2:
					System.out.println("Inserisci la targa della macchina che vuoi ritirare");
					targa=sc.next();
					
					System.out.println();
					if(!parcheggio.autoEsistente(targa)) {
						
						System.err.println("Non siamo riusciti a trovare la macchina con la targa "+targa+", assicurati di averla inserita correttamente");
						targa=null;
					}
					
					else {
						System.out.println("La seguente macchina è stata rimossa:");
						parcheggio.datiMacchina(targa);
						parcheggio.autoEsce(targa);
						
					}
					break;
					
				case 3:
					System.out.println("Inserire la targa della macchina di cui vuoi sapere il numero del parcheggio");
					targa=sc.next();
					
					if(parcheggio.posAuto(targa)==-1) {
						
						System.err.println("Non siamo riusciti a trovare la macchina con la targa "+targa+", assicurati di averla inserita correttamente");
						targa=null;
					}
					
					else {
						System.out.println("La macchina si trova nel parcheggio numero "+parcheggio.posAuto(targa));
					}
					break;
					
				case 4:
					
					if(parcheggio.postoLibero()==-1) {
						System.err.println("Al momento non ci sono parcheggi disponibili");
					}
					
					else {
						System.out.println("\nPosti liberi:");
						parcheggio.visualizzaPostiLiberi();
					}
					break;	
				  
			    case 5:
				    f=false;
				    System.out.println("Alla prossima!");
				    break;
				   
				     default:
					     System.err.println("Non esiste l'opzione "+opzione);		  
				}
			}
			
		}while(f);
	}	
}
