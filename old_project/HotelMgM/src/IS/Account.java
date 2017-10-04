package IS;

import java.io.Serializable;

/** 
 Questa classe definisce un oggetto di tipo account
 */
public class Account implements Serializable{
    
	private static final long serialVersionUID=1;
	
/** Inizializza un oggetto di tipo account
 * @param login Stringa che contiene il nome dell'account dell'utente
 * @param password Stringa che contiene la password dell'account dell'utente
 * @param nome Stringa che contiente il nome dell'utente
 * @param cognome Stringa che contiente il cognome dell'utente 
 * @param data_nascita Contiente la data di nascita dell'utente
 * @param ruolo Stringa che contiene il ruolo dell'utente
 */
       public Account(String login, String password, String nome, String cognome,String data_nascita, String ruolo) {
		super();
		this.login = login;
		this.password = password;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = data_nascita;
		this.ruolo = ruolo;
	}
       
 /** Restituisce il ruolo dell'account al quale viene applicato il metodo
  * 
  * @return ruolo Stringa che contiene il ruolo dell'utente
  */
   	public String getRuolo() {
		return ruolo;      
	}

/** Modifica il ruolo dell'account al quale viene applicato il metodo
 * 
 * @param ruolo Stringa che contiene il ruolo dell'utente
 */
	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}

/** Restituisce il login dell'account al quale viene applicato il metodo
 * 
 * @return login Stringa che contiene il nome dell'account dell'utente
 */
	public String getLogin() {
		return login;
	}

/** Modifica il login dell'account al quale viene applicato il metodo
 * 
 * @param login Stringa che contiene il nome dell'account dell'utente
 */
	public void setLogin(String login) {
		this.login = login;
	}

/** Restituisce la password dell'account al quale viene applicato il metodo
 * 
 * @return password Stringa che contiene la password dell'account dell'utente
 */
	public String getPassword() {
		return password;
	}

/** Modifica la password dell'account al quale viene applicato il metodo
 * 
 * @param password Stringa che contiene la password dell'account dell'utente
 */
	public void setPassword(String password) {
		this.password = password;
	}

/** Restituisce il nome dell'utente dell'account al quale viene applicato il metodo
 * 
 * @return nome Stringa che contiente il nome dell'utente
 */
	public String getNome() {
		return nome;
	}

/** Modifica il nome dell'utente dell'account al quale viene applicato il metodo
 * 
 * @param nome Stringa che contiente il nome dell'utente
 */
	public void setNome(String nome) {
		this.nome = nome;
	}

/** Restituisce il cognome dell'utente dell'account al quale viene applicato il metodo
 * 
 * @return cognome Stringa che contiente il cognome dell'utente
 */
	public String getCognome() {
		return cognome;
	}

/** Modifica il cognome dell'utente dell'account al quale viene applicato il metodo
 * 
 * @param cognome Stringa che contiente il cognome dell'utente
 */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

/** Restituisce la data di nascita dell'utente dell'account al quale viene applicato il metodo
 * 
 * @return data_nascita Contiente la data di nascita dell'utente
 */
	public String getDataNascita() {
		return dataNascita;
	}

	
/** Modifica la data di nascita dell'utente dell'account al quale viene applicato il metodoù
 * 
 * @param data_nascita Contiente la data di nascita dell'utente
 */
	public void setDataNascita(String data_nascita) {
		this.dataNascita = data_nascita;
	}
	
	 private String login;
	 private String password;
	 private String nome;
	 private String cognome;
	 private String dataNascita;
	 private String ruolo;
	 	 
}


