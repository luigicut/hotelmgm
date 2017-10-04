package IS;

import java.io.Serializable;

/**
 * Questa classe definisce un oggetto di tipo Cliente
 */
public class Cliente extends Persona implements Serializable{
	
	private static final long serialVersionUID=1;
      
/** Inizializza un oggetto di tipo Cliente
 *      
 * @param nome Stringa che contiene il nome proprio della cliente 
 * @param cognome Stringa che contiene il cognome della cliente
 * @param luogo_nascita Stringa che contiene il luogo di nascita della cliente  
 * @param provincia Stringa che contiene la provincia del luogo di nascita della cliente
 * @param num_camera Intero che contiene il numero della camera della cliente
 * @param data_nascita Contiene la data di nascita della cliente
 * @param num_carta_ID String Stringa che contiene il numero della carta di identità del cliente
 * @param cod_fiscale Stringa che contiene il codice fiscale del cliente
 * @param nazionalita Stringa che contiene la nazionalità del cliente
 * @param n Contiene il sesso del cliente
 */
      public Cliente(int cod,String nome, String cognome, String luogo_nascita,String provincia, String data_nascita,String num_carta_ID, String cod_fiscale, String nazionalita, String n) {
		super(cod,nome, cognome, luogo_nascita, provincia, data_nascita);
		this.numCartaID = num_carta_ID;
		this.codFiscale = cod_fiscale;
		this.nazionalita = nazionalita;
		this.sesso = n;
	}
	
/** Restituisce il numero della carta di identità del cliente al quale viene applicato il metodo
 * 
 * @return num_carta_ID Stringa che contiene il numero della carta di identità del cliente
 */
	public String getNumCartaID() {
		return numCartaID;
	}

/** Modifica il numero della carta di identità del cliente al quale viene applicato il metodo
 * 
 * @param num_carta_ID Stringa che contiene il numero della carta di identità del cliente
 */
	public void setNumCartaID(String num_carta_ID) {
		this.numCartaID = num_carta_ID;
	}

/** Restituisce il codice fiscale del cliente al quale viene applicato il metodo
 * 
 * @return cod_fiscale Stringa che contiene il codice fiscale del cliente
 */
	public String getCodFiscale() {
		return codFiscale;
	}

/** Modifica il codice fiscale del cliente al quale viene applicato il metodo
 * 
 * @param cod_fiscale Stringa che contiene il codice fiscale del cliente
 */
	public void setCodFiscale(String cod_fiscale) {
		this.codFiscale = cod_fiscale;
	}

/** Restituisce la nazionalità del cliente al quale viene applicato il metodo
 * 
 * @return nazionalita Stringa che contiene la nazionalità del cliente
 */
	public String getNazionalita() {
		return nazionalita;
	}

/** Modifica la nazionalità del cliente al quale viene applicato il metodo
 * 
 * @param nazionalita Stringa che contiene la nazionalità del cliente
 */
	public void setNazionalita(String nazionalita) {
		this.nazionalita = nazionalita;
	}

/** Restituisce il sesso del cliente al quale viene applicato il metodo
 * 
 * @return sesso Contiene il sesso del cliente 
 */
	public String getSesso() {
		return sesso;
	}

/** Modifica il sesso del cliente al quale viene applicato il metodo
 * 
 * @param sesso Contiene il sesso del cliente
 */
    public void setSesso(String sesso) {
		this.sesso = sesso;
	}
  
    
    private String numCartaID;
    private String codFiscale;
    private String nazionalita;
    private String sesso;
	     
}

