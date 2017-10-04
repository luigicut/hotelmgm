package IS;

import java.awt.Color;
import java.rmi.RemoteException;
import RMI.DBClient;
import RMI.DBServer;

/**
 * Classe con il main principale
 * @author Daniele
 *
 */
public class mainProgettoIS {

	
	public static void main(String[] args) throws RemoteException {
		
        Color colore=new Color(252,238,141);
        
        DBServer server=new DBServer();
        server.avvia();
        
        DBClient client=new DBClient();
        client.avvia();

		Contenitore contenitore=new Contenitore(colore,client);
		
		FramePrincipaleIS principale=new FramePrincipaleIS(contenitore);
		principale.visualizzaFrame();

	}

}