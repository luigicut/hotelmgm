package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import IS.Cliente;

/**
 * Interfaccia DBCliente
 * @author Daniele
 *
 */
public interface DBCliente extends Remote {
	public boolean insertCliente(Cliente c) throws SQLException,RemoteException;
	public ArrayList<Cliente> getElencoCliente()throws SQLException,RemoteException;
	public ArrayList<Cliente> getDettagliCliente(int cod) throws SQLException,RemoteException;
	public ArrayList<Cliente> getRicercaCliente(String nome,String cognome,String data) throws SQLException,RemoteException;
}

