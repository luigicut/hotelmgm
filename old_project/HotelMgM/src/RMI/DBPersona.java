package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import IS.Persona;

/**
 * Interfaccia DBPersona
 * @author Daniele
 *
 */
public interface DBPersona extends Remote {
public ArrayList<Persona> getElencoPersone(int codice)throws SQLException,RemoteException;
public boolean insertPersona(Persona p,int cod)throws SQLException,RemoteException;
}





