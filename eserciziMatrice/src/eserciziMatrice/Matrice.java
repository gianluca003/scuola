package eserciziMatrice;

import java.util.Scanner;

public class Matrice {
	
	public static int controlloRighe(int m1[][], int m2[][]) {    					//metodo che assegna le righe e controlla che esistano all'interno delle matrici
		
		Scanner sc = new Scanner(System.in);
		int r;
		boolean f=false;
		
		do {
			System.out.println("\nDammi il numero della riga della matrice");
			r=sc.nextInt();
			
			if(r<0 || r>m1.length-1 || r>m2.length-1) {
				System.err.println("Non esiste questa riga");
				sc.nextLine();
				f=true;
			}
			
			else
				f=false;
			 
		}while(f);
		
		System.out.println();
		return (r);
		
	}
	
	public static void riempiMatrice(int m1[][], int m2[][]) {     			//metodo che riempie le due matrici con numeri casuali
		
		int i,j;
		
		for(i=0; i<m1.length; i++) 
			for(j=0; j<m1[0].length; j++) 
				m1[i][j] = (int) (Math.random()*50);
		
		for(i=0; i<m2.length; i++) 
			for(j=0; j<m2[0].length; j++) 
				m2[i][j] = (int) (Math.random()*50);
	}
	
	
	public static void stampaMatrice(int m1[][], int m2[][]) {  				 //metodo che stampa le due matrici
		
		System.out.println("\nPrima Matrice:");
		for(int i[]: m1) {
			for(int y: i)
				System.out.print(y+" ");
			System.out.println();
		}
		
		System.out.println();
		System.out.println("Seconda Matrice:");
		
		for(int i[]: m2) {
			for(int y: i)
				System.out.print(y+" ");
			System.out.println();
		}
		
		
	}
	
	
	public static void calcMinMax(int m1[][], int m2[][], int r1, int r2) {  				 //metodo che trova il minino e il massimo delle matrici
		
		int i;
		int imx1=0, imx2=0, ymn1=0, ymn2=0;   //imx= indice del valore massimo della matrice  ymn=indice valore minimo della matrice
		int min1, max1=0;  //min = valore minimo della riga scelta della matrice max= valore massimo della riga scelta della matrice
		int min2, max2=0;
		
		min1=m1[r1][0];   //assegnamo come numero piu' piccolo, il primo numero della riga
		min2=m2[r2][0];
		
		for(i=0; i<m1[r1].length; i++) {   //cerca il max e il min della riga scelta nel primo vettore
			
			if(max1<m1[r1][i]) {
				max1= m1[r1][i];
				imx1=i;
			}
			
			if(min1>m1[r1][i]) {
				min1= m1[r1][i];
				ymn1=i;
			}
		}
				
		
		for(i=0; i<m2[r2].length; i++) { // cerca il max e il min della riga scelta nel secondo vettore
			
			if(max2<m2[r2][i]) {
				max2= m2[r2][i];
				imx2=i;
			}
			
			if(min2>m2[r2][i]) {
				min2= m2[r2][i];
				ymn2=i;
			}	
		}
		
		if(max1>max2)  //confrontiamo quale dei due massimi delle matrici e' piu' grande
			System.out.println ("Il massimo si trova nella prima matrice ed e' il numero "+max1+" in posizone riga= "+r1+" colonna= "+imx1);
		else
			System.out.println ("Il massimo si trova nella seconda matrice ed e' il numero "+max2+" in posizone riga= "+r2+" colonna= "+imx2);
		
		if(min1>min2) //confrontiamo quale dei due minimi delle matrici e' piu' piccolo
			System.out.println("Il minimo si trova nella prima matrice ed e' il numero "+min1+" in posizone riga= "+r1+" colonna= "+ymn1);
		else
			System.out.println("Il minimo si trova nella seconda matrice ed e' il numero "+min2+" in posizone riga= "+r2+" colonna= "+ymn2);	
	}
			
	
	public static void mediaRigaCol (int m1[][], int m2[][], int r1, int r2) {   				//Metodo che calcola la media tra le due righe scelte delle matrici
		
		float media1=0, media2=0;
		int i;
		
		for(i=0; i<m1[r1].length; i++) 
			media1= m1[r1][i] + media1;
		
		media1= media1/(i+1);
		
		for(i=0; i<m2[r2].length; i++) 
			media2= m2[r2][i] + media2;
		
		media2= media2/(i+1);
		
		System.out.println("La media tra le due matrici e' "+(media1+media2));
	}
	
	
	public static void occDiag(int m1[][], int m2[][]) { 									//metodo che stampa i numeri uguali trovati nelle diagonali delle due matrici
		int i,j;
		boolean f=true; //controlla se ci sono state o no occorrenze
	
		for( i=0, j=0; i<m1.length && i<m2.length; i++, j++) 
			
			if(m1[i][j]==m2[i][j]) {
				System.out.println("E' stata trovata un occorrenza: "+m1[i][j]+"("+i+","+j+")");	
				f=false;
			}
	
		for(j=i-1, i=i-1; i>=0; i--, j--) 
					if(m1[i][j]==m2[i][j]) {
						System.out.println("E' stata trovata un occorrenza: "+m1[i][j]+"("+i+","+j+")");
						f=false;
					}
		if(f)
			System.out.println("Non e' stata trovata nessuna occorrenza!");
		}
	
	
	public static void parDispDiag(int m1[][], int m2[][]) { 						 //metodo che classifica i numeri diagonali in pari e dispari 
		
		int i,j;
		
		System.err.println("\nI numeri pari sono:");
		
		for(i=0,j=0; i<m1.length; i++, j++)   //Primo 'for' cerca i numeri pari nella prima matrice nella diagonale 1
			if(m1[i][j]%2==0)
				System.out.println(m1[i][j]+"("+i+","+j+")"+" nel primo vettore");
		
		for(i=0,j=0; i<m2.length; i++, j++) //secondo 'for' cerca i numeri pari nella seconda matrice nella diagonale 1
			if(m2[i][j]%2==0)
				System.out.println(m2[i][j]+"("+i+","+j+")"+" nel secondo vettore");
		
		System.err.println("\nI numeri dispari sono:");
		
		for(i=m1.length-1,j=i; i>=0; i--, j--) //terzo 'for' cerca i numeri dispari nella prima matrice nella diagonale 2
			if(m1[i][j]%2==0)
				System.out.println(m1[i][j]+"("+i+","+j+")"+" nel primo vettore");
		
		for(i=m2.length-1, j=i; i>=0; i--, j--)//quarto 'for' cerca i numeri dispari nella seconda matrice nella diagonale 2
			if(m2[i][j]%2==0)
				System.out.println(m2[i][j]+"("+i+","+j+")"+" nel secondo vettore");
	}

	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		int [][] m1, m2;
		int l1, l2;
		int opzione;
		boolean f, f2; //flag per ripetere una parte di codice codice in caso di errori commessi dall'utente
		int r1, r2; //righe assegnate nei casi 2 e 3 attraverso un metodo che controlla se le righe scelte rispettano alcune condizioni 
		String str = new String(); 
		
		do {
			
			System.out.println("Dammi la lunghezza del lato della prima e della seconda matrice (min.4 - max.8)");
			l1=sc.nextInt();
			l2=sc.nextInt();
			
			if(l1<4 || l1>8 || l2<4 || l2>8) {
				System.err.println("I lati non rispettano le richieste");
				sc.nextLine();
				f=true;
			}
			
			else {
				
				m1 = new int [l1][l1];
				m2 = new int [l2][l2];
				
				riempiMatrice(m1, m2);
				
				do {
					
					System.out.println("\nScegli un opzione");
					System.out.println("1: caricamento casuale delle matrici (valori da 1 a 50) e visualizzazione delle stesse");
					System.out.println("2: richiesta della riga della prima matrice e richiesta riga della seconda matrice\r\n" + 
							"di cui si vuole conoscere il massimo e il minimo,");
					System.out.println("3: richiesta della riga della prima matrice e della riga della seconda matrice e calcolare\r\n" + 
							"la media aritmetica");
					System.out.println("4: confrontare i valori delle diagonali delle 2 matrici, e visualizzare le occorrenze\r\n"+ 
							"con le rispettive coordinate specificando di quale matrice.");
					System.out.println("5: confrontare i valori delle prime diagonali delle 2 matrici\r\n"+
							"e visualizzare i numeri pari e dispari con le rispettive coordinate specificando di quale matrice.\n");
					
					opzione=sc.nextInt();
					
						
						switch (opzione) {
						
						case 1: stampaMatrice(m1, m2); f2=false; break;
						case 2: r1=controlloRighe(m1, m2); r2=controlloRighe(m1, m2); calcMinMax(m1, m2, r1, r2); f2=false; break;
						case 3: r1=controlloRighe(m1, m2); r2=controlloRighe(m1, m2); mediaRigaCol(m1 ,m2, r1, r2); f2=false; break;
						case 4: occDiag(m1, m2); f2=false; break;
						case 5: parDispDiag(m1 ,m2); f2=false; break;
						
						default:{
							System.out.println();
							System.err.println("Non esiste questa opzione");
							sc.nextLine();
							f2=true;
						  }
					}
						f=false;
						
				}while(f2); //ripete il ciclo fi quando l'utente non scrive un'opzione esistente
				
				System.out.println("\nDesideri stampare le matrici?");
				str=sc.next();
				
				if(str.contentEquals("si"))
					stampaMatrice(m1, m2);
				sc.nextLine();
				
			}
			
			System.out.println("\nVuoi continuare (rispondi si/no)");
			str=sc.next();
			
			if(str.contentEquals("si"))
				f=true;
			else
				f=false;
			
		}while(f);//ripete il ciclo fin quando l'utente non assegna correttamente le dimensioni delle matrici e fin quando l'utente risponde si alla richiesta di voler continuare

		System.out.println("\nAlla prossima :)");
	}

}