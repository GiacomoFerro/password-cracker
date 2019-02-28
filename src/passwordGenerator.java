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


    protected void computePassword(int indice){

        if(indice<this.diz.getDizParole().size()){
            pass=this.diz.getDizParole().get( indice );
        }
        else{
            pass="";
        }
        
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
