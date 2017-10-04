package IS;

import java.awt.Color;

import RMI.DBClient;

/**
 * Questa classe definisce un oggetto di tipo contenitore
 * @author Daniele
 *
 */
public class Contenitore {
	
	
	/**
	 * Costruisce un oggetto contenitore
	 * @param c colore per i frame
	 * @param cli oggetto di tipo client
	 */
	public Contenitore(Color c,DBClient cli){
		colore=c;
		client=cli;
	}
	
	/**
	 * 
	 * Permette di settare un nuovo colore
	 * @param c colore per i frame
	 */
	public void setColore(Color c){
		colore=c;
	}
	
	/**
	 * Restituisce il colore
	 * @return il colore per i frame
	 */
	public Color getColore(){
		return colore;
	}
	
	/**
	 * Restituisce il client per operazioni di tipo RMI
	 * @return il client
	 */
	public DBClient getClient(){
		return client;
	}
	
	private Color colore;
	private DBClient client;
}

