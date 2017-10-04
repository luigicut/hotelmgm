package RMI;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;

/**
 * 
 * Questa classe rappresenta il Server che offre i servizi al CLient
 * @author Daniele
 *
 */
public class DBServer implements Remote{
      
	/**
	 * Costruisce un oggetto di tipo Server ed apre la porta 1099 
	 * che consente la comunicazione con il client
	 * @throws RemoteException
	 */
	public DBServer() throws RemoteException {	
		LocateRegistry.createRegistry(1099);
	}
      
	/**
	 * Avvia il Server
	 */
	public void avvia(){	

		try{
			System.out.println("Constructing server impl...");
	        d = new DBImpl();
			
              System.out.println("Binding server impl to registry...");
              Naming.rebind("//localhost/Data",d);

              System.out.println("Waiting for clients...");
		}
		catch (Exception e){
			System.out.println("DataServer Error: "+e);
		}
          
       }
	
	private DBImpl d;
	
}

