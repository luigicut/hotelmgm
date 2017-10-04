package RMI;

import java.rmi.*;
import java.sql.SQLException;
import java.util.ArrayList;

import IS.*;

/**
 * Interfaccia DBAccount
 * @author Daniele
 *
 */
public interface DBAccount extends Remote {

public ArrayList<Account> getElencoAccount()throws SQLException,RemoteException;
public boolean insertAccount(Account a)throws SQLException,RemoteException;
public ArrayList<Account> getRicercaAccount(String login,String nome,String cognome)throws SQLException,RemoteException;

}
