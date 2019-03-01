import java.io.*;
import java.util.ArrayList;

public class passwordGenerator{

    protected Dizionario diz;
    protected String pass="";

    //@costruttore
    public passwordGenerator(String path) {
        
        diz = new Dizionario(path);
        pass="";

	}//fine 

    protected Dizionario getDiz(){
        return this.diz;
    }

    protected void setPass(String s){
        pass=s;
    }


    protected void computePassword(int indice){
        pass=this.diz.getDizParole().get( indice );       
    }

    /*
    funzione che controlla se la password è un prefisso
    @param: lista di prefissi
    @return true se si trova la password
    */
    protected boolean prefixCheck(ArrayList<String> prefixList, String realPassword){
        
        for(int i=0; i<prefixList.size(); i++){
            String s = prefixList.get(i);
            if(s.equals(realPassword)){
                pass=s;
                //System.out.println("****DETECT password come prefisso!****");
                return true;
            }
        }

        return false;
    }    

    /*
    funzione che controlla se la password è un suffisso
    @param: lista di suffissi
    @return true se si trova la password
    */
    protected boolean suffixCheck(ArrayList<String> suffixList, String realPassword){
        
        for(int i=0; i<suffixList.size(); i++){
            String s = suffixList.get(i);
            if(s.equals(realPassword)){
                pass=s;
                //System.out.println("****DETECT password come suffisso!****");
                return true;
            }
        }
        return false;
    }    



    /*
    funzione che calcola i prefissi di una parola
    @param: indice della parola di cui calcolare i prefissi
    @return: lista dei prefissi
    */

    protected ArrayList<String> computePrefix(int indice){
     
        String parola = this.diz.getDizParole().get( indice );        
        StringBuffer prefix = new StringBuffer();   

        ArrayList<String> listaPrefissi = new ArrayList<String>();

        for(int i = 0; i<parola.length()-1; i++){
            prefix=prefix.append( parola.charAt(i) );
            listaPrefissi.add( prefix.toString() );
        }

        return listaPrefissi;

    }

    /*
    funziona duale a quella sui prefissi.
    @param: indice della parola sui cui calcolare i suffissi
    @return: lista dei suffissi della parola
    */

    protected ArrayList<String> computeSuffix(int indice){

        String parola = this.diz.getDizParole().get( indice );        
        StringBuffer suffix = new StringBuffer();   

        ArrayList<String> listaSuffissi = new ArrayList<String>();

        for(int i = parola.length()-1; i>0; i--){
            suffix=suffix.append( parola.charAt(i) );
            listaSuffissi.add( suffix.toString() );
        }

        return listaSuffissi;

    }


    /*
      @param password = password vera.
      @return boolean: vero se i le password sono uguali
    */

    protected boolean equals(String password){
        
        return pass.equals(password);

    }

    protected String getPassword(){

        return pass;
    }


}
