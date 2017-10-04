package Eccezioni;

import IS.Contenitore;
import IS.FrameMessage;

/**
 * Crea un eccezione ErrorException che viene lanciata in caso di errore
 * @author Daniele
 *
 */
public class ErrorException extends RuntimeException{
	
	static final long serialVersionUID=0;
	
	/**
	 * Costruisce l'eccezione
	 * @param c Oggetto di tipo contenitore
	 * @param s Messaggio da visualizzare
	 */
	public ErrorException(Contenitore c,String s){
		super(s);		
		FrameMessage m=new FrameMessage(c,s,false);
		m.visualizzaFrame();
	}

}

