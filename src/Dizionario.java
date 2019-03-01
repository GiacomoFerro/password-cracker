import java.io.*;
import java.util.ArrayList;

public class Dizionario {
 
    protected ArrayList<String> parole;
 
    /**
     * Il costruttore di default del Dizionario. Carica le parole.
       @param Path = percorso dei file di parole con cui creare il dizionario.
     */
    public Dizionario(String Path) {
        this.parole = new ArrayList<String>();
        run(Path);
 
    }

    public ArrayList<String> getDizParole(){
        return this.parole;
    }

 
    public void run(String Path) {
       
        try {

            FileReader f = new FileReader(Path);
            BufferedReader br = new BufferedReader(f);
            String appoggio = "";
            

            while ((appoggio = br.readLine()) != null) {
                
                parole.add(appoggio);

            }
        } 
        catch (IOException ex) {
        }            
    }   
    
 
    /**
     * Ricerca una parola all'interno del Dizionario
     * @param pWord La parola da ricercare
     * @return true se la parola è presente, false in caso contrario.
     */

    public boolean searchWord(String pWord) {
        pWord = pWord.toLowerCase();
        for (int i = 0; i < this.parole.size(); i++) {
            if (this.parole.get(i).equals(pWord)) {
                return true;
            }
        }
        return false;
    }
 
    /**
     * Ritorna tutte le parole che contengono pWord.
     * @param pWord La parola da ricercare.
     * @return Una ArrayList cointenente tutte le parole.
     */
    public ArrayList<String> searchContainsWords(String pWord) {
        pWord = pWord.toLowerCase();
        ArrayList<String> containsWords = new ArrayList<String>();
        for (int i = 0; i < this.parole.size(); i++) {
            if (this.parole.get(i).contains(pWord)) {
                containsWords.add(this.parole.get(i));
            }
        }
        return containsWords;
    }
 
    /**
     * Ritorna tutte le parole che iniziano per pWord.
     * @param pWord La parola da ricercare.
     * @return Una ArrayList cointenente tutte le parole.
     */
    public ArrayList<String> searchStartWhitWords(String pWord){
        pWord = pWord.toLowerCase();
        ArrayList<String> startWhitWords = new ArrayList<String>();
        for (int i = 0; i < this.parole.size(); i++) {
            if (this.parole.get(i).startsWith(pWord)) {
                startWhitWords.add(this.parole.get(i));
            }
        }
        return startWhitWords;
    }
 
        /**
     * Ritorna tutte le parole che finiscono per pWord.
     * @param pWord La parola da ricercare.
     * @return Una ArrayList cointenente tutte le parole.
     */
    public ArrayList<String> searchEndWhitWords(String pWord){
        pWord = pWord.toLowerCase();
        ArrayList<String> startEndWords = new ArrayList<String>();
        for (int i = 0; i < this.parole.size(); i++) {
            if (this.parole.get(i).endsWith(pWord)) {
                startEndWords.add(this.parole.get(i));
            }
        }
        return startEndWords;
    }
 
    /*
    @return una parola a caso
    */

    public String randomWord(){
        double random= Math.random()*this.parole.size();
        int rand= (int) random;
        return this.parole.get(rand);
    }


 
    public static void main(String args[]) throws IOException {
        /*
        Dizionario d = new Dizionario();
        System.out.print("Inserire parola da ricercare: ");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String parola = br.readLine();

        if (d.searchWord(parola)) {
            System.out.println("La parola " + parola + " esiste");
            ArrayList<String> parole = new ArrayList<String>();
            parole = d.searchContainsWords(parola);
            System.out.println("Elenco parole che contengono " + parola + "(" + parole.size() + "):");
            
            for (int i = 0; i < parole.size(); i++) {
                System.out.println(parole.get(i));
            }
  
            parole = d.searchStartWhitWords(parola);
            System.out.println("Elenco parole che iniziano per " + parola + "(" + parole.size() + "):");

            for (int i = 0; i < parole.size(); i++) {
                System.out.println(parole.get(i));
            }

            parole = d.searchEndWhitWords(parola);
            System.out.println("Elenco parole che finiscono per " + parola + "(" + parole.size() + "):");

            for (int i = 0; i < parole.size(); i++) {
                System.out.println(parole.get(i));
            }

        } else {
            System.out.println("La parola " + parola + " non esiste");
        }
        System.out.println("Una parola a caso: "+d.randomWord());
        */

    }
    
}
