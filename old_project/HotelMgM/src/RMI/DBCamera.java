package RMI;

import java.rmi.*;
import java.sql.SQLException;
import java.util.ArrayList;

import IS.*;

/**
 * Interfaccia DBCamera
 * @author Daniele
 *
 */
public interface DBCamera extends Remote {

public ArrayList<Camera> getElencoCamera()throws SQLException,RemoteException;
public ArrayList<Camera> getElencoCameraLibera() throws SQLException,RemoteException;
public ArrayList<Camera> getElencoCameraOccupata() throws SQLException,RemoteException;
public boolean setPrenota(int camera,String dI,String dF,String nom,String cog,String dN)throws SQLException,RemoteException;
public ArrayList<Camera> getRicercaCamera(int num, int piano, String tipo,int numLetti) throws SQLException, RemoteException;
public ArrayList<Camera> getRicercaDisponibilitaCamera(int num, int piano, String tipo,int numLetti,String dI,String dF) throws SQLException, RemoteException; 
public boolean insertCamera(Camera c) throws SQLException, RemoteException;
public boolean occupaCamera(int numCamera,int codiceCliente,String dI,String dF) throws SQLException,RemoteException;
public void rilasciaCamera(int numCamera,String dataFine) throws SQLException,RemoteException;
public boolean controllaPrenotazione(int codCliente,int num,String dI,String dF)throws SQLException,RemoteException;
}

