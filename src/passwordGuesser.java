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

        boolean trovata=false;

        passwordGenerator generatore=null;

        ArrayList<String> prefissi=null;
        ArrayList<String> suffissi=null;

        //fine variabili

		
		System.out.println("\n****PASSWORD GUESSER (BRUTE FORCE APPROACH)****\n");
		do {
			System.out.print("inserisci la password da indovinare:");
			password = scan.next();
		}while(password.length()==0);
		
		scan.close();

		startTime = System.currentTimeMillis();
		
        for( i=0; i<3&& ( !trovata ); i++){ 
            //esco o se non la trovo MAI in nessun dizionario 
            //oppure appena la trovo (parola intera,suffix o prefix)                      

            //imposto le sorgenti dei dizionari per l'attacco BF
            generatore = new passwordGenerator(Path[i]);
		 
            prefissi = new ArrayList<String>();
            suffissi = new ArrayList<String>();

            System.out.println("\n********************************************************");
            System.out.println("utilizzo le parole presenti in:"+Path[i]);
            System.out.println("dimensione dizionario:"+generatore.diz.getDizParole().size());
            System.out.println("********************************************************\n");


            dimMassima=generatore.diz.getDizParole().size();
            indice=0; 

            do{
                
                generatore.computePassword(indice);
                
                prefissi = generatore.computePrefix(indice);
                suffissi = generatore.computeSuffix(indice);

                if( ! trovata ) trovata=generatore.prefixCheck( prefissi, password);
                if( ! trovata ) trovata=generatore.suffixCheck( suffissi, password);

			    indice+=1;

	    	}while( ( !trovata ) && ( ! (trovata = generatore.equals(password) ) ) &&  ( indice != dimMassima ) );
			
		}//fine for()

		
		endTime = System.currentTimeMillis();
		
        if(generatore.equals(password)){
            System.out.println("\n****password trovata. Essa è: "+ generatore.getPassword()+"****\n");
        }
        else{ 
            System.out.println("\n****nessun match trovato nel dizionario.****\n");
        }

		System.out.println("\nTempo impiegato:" + (endTime - startTime) + " millisecondi");
		

	}//fine main
	
}//fine della classerovata.
