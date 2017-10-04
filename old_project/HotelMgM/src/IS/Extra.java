package IS;

import java.io.Serializable;

/** 
 * Questa classe definisce un oggetto di tipo Cliente
 */
public class Extra implements Serializable{
    
	private static final long serialVersionUID=1;
	
/** Inizializza un oggetto di tipo Extra
 * 
 * @param nome Stringa che contiene il nome dell'extra
 * @param prezzo Contiene il prezzo dell'extra
 */
	public Extra(int cod,String nome,double prezzo) {
		this.codice=cod;
		this.nome = nome;
		this.prezzo = prezzo;
	}

/** Restituisce il nome dell'extra al quale viene applicato il metodo
 * 
 * @return nome Stringa che contiene il nome dell'extra
 */
	public String getNome() {
		return nome;
	}

/** Modifica il nome dell'extra al quale viene applicato il metodo
 * 
 * @param nome Stringa che contiene il nome dell'extra
 */
	public void setNome(String nome) {
		this.nome = nome;
	}

/** Restituisce il prezzo dell'extra al quale viene applicato il metodo
 * 
 * @return prezzo Contiene il prezzo dell'extra
 */
	public double getPrezzo() {
		return prezzo;
	}

/** Modifica il prezzo dell'extra al quale viene applicato il metodo
 * 
 * @param prezzo Contiene il prezzo dell'extra
 */
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	
/** Restituisce il codice dell'extra al quale viene applicato il metodo
 * 
 * @return codice Stringa che contiene il codice dell'extra
 */
	public int getCodice() {
		return codice;
	}

/** Modifica il codice dell'extra al quale viene applicato il metodo
 * 
 * @param codice Stringa che contiene il codice dell'extra
 */
	public void setCodice(int cod) {
		this.codice = cod;
	}
	
		
	private int codice;
	private String nome;
	private double prezzo;

	
}

