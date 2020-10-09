package matriceSpirale;

import java.util.Scanner;

public class Matrice {
	
	
	public static void matriceSpirale(int m[][], int l) {
		
		int n=0, i=0, j=0;
		
		do {
				while( j<l && j>=0) {
								
								if(m[i][j]!=0) 
								     break;
								
								
								else {
									if(i>l/2) {
										m[i][j]=++n; j--;
									}
									
									else {
										m[i][j]=++n; j++;
									  }
								    }
				}				
												if(i>l/2) {
													i--; j++;
												}
												else {
													i++; j--;
												}
									 
								
			  while( i<l && i>=0) {
					
								if(m[i][j]!=0) 
									 break;
								
								else {
									if(j>=l/2) {
										m[i][j]=++n; i++;
									}
									
									else {
										m[i][j]=++n; i--;
									  }
								    }
				  }
		
												if(j>=l/2 && i>l/2) {
													i--; j--;
												}
												
												else if(j<l/2 && i<l/2) {
													i++; j++;
												}
		}while(n!=l*l);
			
	}	
		
	
	public static void stampaMatrice(int m[][]) {
		
		for(int i[]: m) {
			for(int y: i) 
				System.out.print(y+" ");
			System.out.println();
		}
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		int n;
		int[][] m;
		
		System.out.println("Dammi un numero N positivo per creare una matrice quadrata NxN");
			n=sc.nextInt();
			
			m = new int [n][n];
			
			matriceSpirale(m,n);
			System.out.println();
			stampaMatrice(m);
			
	}

}
