package RMI;

import java.rmi.*;

/**
 * Questa classe rappresenta il Client che richiede l'oggetto remoto del server
 * @author Daniele
 *
 */

public class DBClient {
	
/**
 * Crea un oggetto Client
 */
    public DBClient(){	
     System.setSecurityManager(new RMISecurityManager());
     url="";
    }
    
     /**
      * Avvia il Client
      */
    public void avvia(){
    url = "rmi://localhost/Data";
    }

    /**
     * Restituisce l'url dell'oggetto remoto
     * @return url
     */
    public String getUrl(){
    	return url;
    }
    
    
    private String url;
}
 
     


