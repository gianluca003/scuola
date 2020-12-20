package rubrica;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		Persona p = new Persona();
		Rubrica r = new Rubrica(100);
		int opzione;
		String dato;
		int filtroRubrica=1;
		boolean loopRubrica=true;
		boolean loopMenu=true;
		
		do {
			System.out.println("\n+-------------RUBRICA-------------+\n"
					         + "|");
			if(r.rubricaVuota())
				
		    System.out.println("| Non ci sono ancora contatti!    ");
			else
				r.stampaRubrica(filtroRubrica);
			System.out.println("|                                 ");
			System.out.println("|                         1) Menu'");
			System.out.println("|                         2) Esci ");
			System.out.println("+---------------------------------+\n");
			
			if(!sc.hasNextInt()) {
				System.err.println("Puoi inserire solamente le due opzioni che trovi in basso a destra!");
				sc.nextLine();
			}
			
			else {
				
				opzione=sc.nextInt();
				
				switch(opzione) {
				
				case 1:
						loopMenu=true;
						
						System.out.println("+--------------MENU'--------------+\n"
								 + "|1) Inserisci contatto            |\n"
								 + "|2) Rimuovi contatto              |\n"
								 + "|3) Cerca contatto                |\n"
								 + "|4) Filtri rubrica                |\n"
								 + "|5) Indietro                      |\n"
								 + "+---------------------------------+");
						do {
							
							System.out.println("\n---> Scegli un opzione del menu':");
							
							if(!sc.hasNextInt()) {
								System.err.println("Devi inserire un opzione da 1 a 4!");
								sc.nextLine();
							}
							
							else {
								opzione=sc.nextInt();
								
								switch(opzione) {
								
								case 1:
									System.out.println("---------------------------------------------------------------");
									System.out.print("Nome: ");p.setNome(sc.next());
									System.out.print("Cognome: ");p.setCognome(sc.next());
									sc.nextLine();//pulisce il buffer
									System.out.print("Citta: "); p.setCitta(sc.nextLine());
									System.out.print("Indirizzo: ");p.setIndirizzo(sc.nextLine());
									System.out.print("Numero: ");p.setNumero(sc.next());
									System.out.println();
									
									if(r.spazioLibero() != -1) {  //controlliamo che la rubrica non sia piena
										
										if(!r.cercaNumero(p.getNumero())) {   //controlliamo se il numero è gia presente all'interno della rubrica
											r.inserisci(p); 
										System.out.println("Contatto registrato!");
										}
										
										else {
											System.err.println("Numero già registrato!");
										}
									}
									else 
										System.err.println("La tua rubrica è piena!");
									break;
									
								case 2:
									System.out.println("---------------------------------------------------------------");
									System.out.print("Inserisci un informazione del contatto che desideri rimuovere: "); 
									sc.nextLine();
									dato=sc.nextLine();
									System.out.println();
									
									if(r.numeroCercaDato(dato)==0)   //Cerchiamo il contatto e il numero di contatti che l'utente desidera rimuovere passando un informazione
										System.err.println("Non abbiamo trovato alcun risultato con l'informazione '"+dato+"'");
									
									else {
										System.out.println("Sono stati trovati "+r.numeroCercaDato(dato)+" risultati correlati al dato '"+dato+"':");
										
										r.stampaCercaDato(dato);
										System.out.println("\nInserisci l'opzione del contatto che desideri rimuovere *ATTENZIONE se scrivi un opzione non presente rischi di rimuovere un altro contatto*");
										System.out.println("[Scrivi 0 per tornare indietro]");
										
										if(!sc.hasNextInt()) {  //controlliamo che l'utente non inserisca un opzione diverso da un numero int 
											System.err.println("Devi inserire un numero");
											sc.nextLine();
										}
										
										else {
											opzione=sc.nextInt();
											
											if(opzione!=0) {  //se l'utente inserisce 0 significa che non vuole più rimuovere nessuno e che desidera tornare alla schermata iniziale
												r.rimuovi(opzione);	
											System.out.println("Contatto rimosso!");
											}
										}	
									}
									break;
									
								case 3:
									System.out.println("---------------------------------------------------------------");
									System.out.print("Inserisci un informazione del contatto che desideri cercare: "); 
									sc.nextLine();
									dato=sc.nextLine();
									System.out.println();
									
									if(r.numeroCercaDato(dato)==0)   //Cerchiamo il contatto e il numero di contatti che l'utente desidera trovare passando un informazione
										System.err.println("Non abbiamo trovato alcun risultato con l'informazione '"+dato+"'");
									
									else {
										System.out.println("Sono stati trovati "+r.numeroCercaDato(dato)+" risultati correlati al dato '"+dato+"':");
										r.stampaCercaDato(dato);
									}
									break;
									
								case 4:
									System.out.println("Inserisci l'opzione del filtro che vuoi applicare alla rubrica\n"
											+ "1) Tutte le informazioni\n"
											+ "2) Nome e Cognome\n"
											+ "3) Nome e Citta'\n"
											+ "4) Nome e Indirizzo\n"
											+ "5) Nome e Numero\n"
											+ "6) Indietro");
									
									if(!sc.hasNextInt()) {
										System.err.println("Devi inserire un numero intero");
										sc.nextLine();
									}
									
									else {
										
										opzione=sc.nextInt();
										
										switch (opzione) {
										case 1:
											filtroRubrica=1; System.out.println("Filtro applicato!"); break;
										case 2:
											filtroRubrica=2; System.out.println("Filtro applicato!"); break;
										case 3:
											filtroRubrica=3; System.out.println("Filtro applicato!"); break;
										case 4:
											filtroRubrica=4; System.out.println("Filtro applicato!"); break;
										case 5:
											filtroRubrica=5; System.out.println("Filtro applicato!"); break;
										case 6:
											break;
											
											default: System.out.println("Mi spiace ma non è possibile applicare il filtro sceltro, assicurati di aver scelto l'opzione corretta!");
										}
									}
									break;
									
								case 5:
									loopMenu=false;
									break;
									
									default:
										System.err.println("Devi inserire un opzione da 1 a 4!");
								}
							}
						}while(loopMenu);
					break;
					
				case 2:
					System.out.println("Sei sicuro di voler uscire? (si - no)");
					if(sc.next().equalsIgnoreCase("si"))
					loopRubrica = false;
					break;
					
					default: System.err.println("Puoi inserire solamente le due opzioni che trovi in basso a destra!");
				}
			}
		}while(loopRubrica);
		
		sc.close();
		System.out.println("\nD'accordo, alla prossima!");
	}
}
