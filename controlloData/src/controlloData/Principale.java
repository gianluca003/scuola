package controlloData;

import java.util.Scanner;

public class Principale {

	public static void main(String[] args) {
		   
		 Scanner sc = new Scanner (System.in);
		 MyData md = new MyData();
		 
		 int giorno, mese, anno;
		
			System.out.println("Scrivi una data nel seguente formato (gg/mm/yyyy)");
			
			giorno = sc.nextInt();
			mese = sc.nextInt();
			anno = sc.nextInt();
			
			md.setMese(mese);
			md.setGiorno(giorno);	
			md.setAnno(anno);
			
			if(md.flag == false) {
				
				System.out.println("\nIn che formato desideri visualizzare la data? (it/en)");
				
				md.setFormato(sc.next());
				
				System.out.println("\n"+md);
			}

	}

}
 