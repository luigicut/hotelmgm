package IS;

import java.io.Serializable;

/** 
 * Questa classe definisce un oggetto di tipo Persona
 */
public class Persona implements Serializable{
	  
	private static final long serialVersionUID=1;
	
/** Inizializza un oggetto di tipo Persona
 * 
 * @param nome Stringa che contiene il nome proprio della persona 
 * @param cognome Stringa che contiene il cognome della persona
 * @param luogo_nascita Stringa che contiene il luogo di nascita della persona  
 * @param provincia Stringa che contiene la provincia del luogo di nascita della persona
 * @param num_camera Intero che contiene il numero della camera della persona
 * @param data_nascita Contiene la data di nascita della persona
 */
	public Persona(int cod,String nome, String cognome, String luogo_nascita,String provincia, String data_nascita) {
		this.codice=cod;
		this.nome = nome;
		this.cognome = cognome;
		this.luogoNascita = luogo_nascita;
		this.provincia = provincia;
		this.dataNascita = data_nascita;
	}

/** Restituisce il codice della persona alla quale viene applicato il metodo
 * 
 * @return nome Stringa che contiene il codice della persona 
 */
    public int getCodice() {
		return codice;
	}	
    
   
/** Modifica il codice della persona alla quale viene applicato il metodo
 * 
 * @param codice Stringa che contiene il codice della persona
 */
    public void setCodice(int cod) {
    	this.codice = cod;
    }    
    
/** Restituisce il nome della persona alla quale viene applicato il metodo
 * 
 * @return nome Stringa che contiene il nome proprio della persona 
 */
	public String getNome() {
		return nome;
	}
	
/** Modifica il nome della persona alla quale viene applicato il metodo
 * 
 * @param nome Stringa che contiene il nome proprio della persona
 */
public void setNome(String nome) {
		this.nome = nome;
	}

/** Restituisce il cognome della persona alla quale viene applicato il metodo
 * 
 * @return cognome Stringa che contiene il cognome della persona
 */
	public String getCognome() {
		return cognome;
	}

/** Modifica il cognome della persona alla quale viene applicato il metodo
 * 
 * @param cognome Stringa che contiene il cognome della persona
 */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

/** Restituisce il luogo di nascita della persona alla quale viene applicato il metodo
 * 
 * @return luogo_nascita Stringa che contiene il luogo di nascita della persona
 */
	public String getLuogoNascita() {
		return luogoNascita;
	}

/** Modifica il luogo di nascita della persona alla quale viene applicato il metodo
 * 
 * @param luogo_nascita Stringa che contiene il luogo di nascita della persona
 */
	public void setLuogoNascita(String luogoNascita) {
		this.luogoNascita = luogoNascita;
	}

/** Restituisce la provincia del luogo di nascita della persona alla quale viene applicato il metodo
 * 
 * @return provincia Stringa che contiene la provincia del luogo di nascita della persona
 */
	public String getProvincia() {
		return provincia;
	}

/** Modifica la provincia del luogo di nascita della persona alla quale viene applicato il metodo
 * 
 * @param provincia Stringa che contiene la provincia del luogo di nascita della persona
 */
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}


/** Restituisce la data di nascita della persona alla quale viene applicato il metodo
 * 
 * @return data_nascita Contiene la data di nascita della persona
 */
	public String getDataNascita() {
		return dataNascita;
	}

/** Modifica la data di nascita della persona alla quale viene applicato il metodo
 * 
 * @param data_nascita Contiene la data di nascita della persona
 */
	public void setDataNascita(String dataNascita) {
		this.dataNascita = dataNascita;
	}
	  
	  private int codice;
	  private String nome;
	  private String cognome;
	  private String luogoNascita;
	  private String provincia;
	  private String dataNascita;	  
}

