package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import IS.Extra;

/**
 * Interfaccia DBExtra
 * @author Daniele
 *
 */
public interface DBExtra extends Remote {

	public ArrayList<Extra> getElencoExtra()throws SQLException,RemoteException;
	public boolean insertExtra(Extra a)throws SQLException,RemoteException;
	public boolean associaExtra(int numeroCamera,String dataConsumazione,int codExtra,int q)throws SQLException,RemoteException;
}
