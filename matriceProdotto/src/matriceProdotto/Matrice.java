package matriceProdotto;

import java.util.Scanner;

public class Matrice {
	
	public static int minimo(int a, int b) {  //metodo minimo per trovare la riga minore delle due matrici
		
		if(a<b)
			return a;
		else
			return b;
		
	}
	
	public static void riempiMatrice(int m[][]) {          //metodo riempi matrice
		
		for(int i=0; i<m.length; i++) 
			
			for(int j=0; j<m[0].length; j++) 	
				
				m[i][j] = (int) (Math.random() * 10);
		
	}
	
	public static void stampaMatrice (int m[][]) {            //metodo stampa matrice
		
		for(int i=0; i<m.length; i++) {
			
			for(int j=0; j<m[0].length; j++) {
				
				System.out.print(m[i][j]+" ");
				
			}
			
			System.out.println();
		}
		
	}
	
	public static void matriceProdotto(int ma[][], int mb[][], int mc[][], int min) {  //metodo matrice prodotto
		
		int prodotto;
		int i,j,y;
		
		for(i=0; i<mc[0].length; i++) {
			
			for(j=0; j<mc.length; j++) {
			
				prodotto=0;
				
					for(y=0; y<min; y++) {
					
						prodotto = prodotto + (ma[j][y] * mb[y][i]);
		
					}
					
					mc[j][i] = prodotto;
				
			}
			
		}
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		int ca, ra, cb;  //ca= colonne matrice A;  ra= colonne matrice A; cb= colonne matrice B
		int min;
		
		
			System.out.println("Scrivi rispettivamente il numero di colonne e righe della matrice 'A'");
			
				ca = sc.nextInt();
				ra = sc.nextInt();
				
			System.out.println("Scrivi il numero di colonne per la matrice 'B'");
			
				cb = sc.nextInt();
		
		int[][] a = new int [ra][ca];
			riempiMatrice(a);
			
		int[][] b = new int [ca][cb];
		
			riempiMatrice(b);
			
		int[][] c = new int [ra][cb];
			min=minimo(ra,ca);
			
		
			System.out.println();
			System.out.println("Matrice A");
			
			stampaMatrice(a);
			
			System.out.println();
			System.out.println("Matrice B");
			
			stampaMatrice(b);
			
			System.out.println();
			System.out.println("Matrice prodotto");
			
			matriceProdotto(a,b,c,min);
			stampaMatrice(c);			

	}

}
