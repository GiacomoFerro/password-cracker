import java.util.*;

public class passwordGuesser {

	public static void main(String args[]) {
		
		String password="";
		Scanner scan = new Scanner(System.in);
        String Path[]=new String[3];

        Path[0]="volume/diz.txt";
        Path[1]="volume/bruteforce.txt";
        Path[2]="volume/parole-uniche.txt";

        long startTime,endTime;

        int i, indice,dimMassima;

        passwordGenerator generatore=null;

        //fine variabili

		
		System.out.println("****password guesser (brute force approach)****");
		do {
			System.out.print("inserisci la password da indovinare:");
			password = scan.next();
		}while(password.length()==0);
		
		scan.close();

		startTime = System.currentTimeMillis();
		
        for( i=0; i<3; i++){                       

            //imposto le sorgenti dei dizionari per l'attacco BF
            generatore = new passwordGenerator(Path[i]);
		 
            System.out.println("utilizzo le parole presenti in:"+Path[i]);
            System.out.println("dimensione dizionario:"+generatore.diz.getDizParole().size());

            dimMassima=generatore.diz.getDizParole().size();
            indice=0; 

            do{

                generatore.computePassword(indice);
			indice+=1;

	    	}while( ( ! generatore.equals(password) ) && ( ! generatore.getPassword().equals("") ) && indice != dimMassima);
			
		}//fine for()
		
		endTime = System.currentTimeMillis();
		
		System.out.println("password trovata. Essa è: "+ generatore.getPassword());

		System.out.println("Tempo impiegato:" + (endTime - startTime) + " millisecondi");
		

	}//fine main
	
}//fine della classe
