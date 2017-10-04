package IS;

import java.io.Serializable;
import java.util.ArrayList;

/** 
 * Questa classe definisce un oggetto di tipo Camera
 */
public class Camera implements Serializable{
    
	private static final long serialVersionUID=1;
	
/** Inizializza un oggetto di tipo Camera
 * 
 * @param numero Intero che contiene il numero della camera
 * @param piano Intero che contiene il numero del piano della camera
 * @param num_letti Intero che contiene il numero di letti della camera
 * @param tipo Stringa che contiente il tipo della camera
 * @param stato Booleano che contiene lo stato della camera
 */
    public Camera(int numero, int piano, int num_letti, String tipo, Boolean stato) {
		this.numero = numero;
		this.piano = piano;
		this.numLetti = num_letti;
		this.tipo = tipo;
		this.stato = stato;
		this.extra = new ArrayList<Extra>();
	}

/** Restituisce il numero della camera alla quale viene applicato il metodo
 * 
 * @return numero Intero che contiene il numero della camera
 */
	public int getNumero() {
		return numero;
	}

/** Modifica il numero della camera alla quale viene applicato il metodo
 * 
 * @param numero Intero che contiene il numero della camera
 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

/** Restituisce il piano della camera alla quale viene applicato il metodo
 * 
 * @return piano Intero che contiene il numero del piano della camera
 */
	public int getPiano() {
		return piano;
	}

/** Modifica il piano della camera alla quale viene applicato il metodo
 * 
 * @param piano Intero che contiene il numero del piano della camera
 */
	public void setPiano(int piano) {
		this.piano = piano;
	}

/** Restituisce il numero di letti della camera alla quale viene applicato il metodo
 * 
 * @return num_letti Intero che contiene il numero di letti della camera
 */
	public int getNumLetti() {
		return numLetti;
	}

/** Restituisce il numero di letti della camera alla quale viene applicato il metodo
 * 
 * @param num_letti Intero che contiene il numero di letti della camera
 */
	public void setNumLetti(int num_letti) {
		this.numLetti = num_letti;
	}

/** Restituisce il tipo della camera alla quale viene applicato il metodo
 * 
 * @return tipo Stringa che contiente il tipo della camera
 */
	public String getTipo() {
		return tipo;
	}

/** Modifica il tipo della camera alla quale viene applicato il metodo
 * 
 * @param tipo Stringa che contiente il tipo della camera
 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

/** Restituisce lo stato della camera alla quale viene applicato il metodo
 * 
 * @return stato Booleano che contiene lo stato della camera
 */
	public Boolean getStato() {
		return stato;
	}

/** Modifica lo stato della camera alla quale viene applicato il metodo
 * 
 * @param stato Booleano che contiene lo stato della camera
 */
	public void setStato(Boolean stato) {
		this.stato = stato;
	}

/** Restituisce la lista degli extra associati alla camera alla quale viene applicato il metodo
 * 
 * @return extra ArrayList che contiene la lista degli extra associati alla camera
 */
	public ArrayList<Extra> getExtra() {
		return extra;
	}

/** Aggiunge un'extra alla camera alla quale viene applicato il metodo
 * 
 * @param extra Un oggetto di tipo Extra
 */
	public void add_Extra(Extra extra) {
		this.extra.add(extra);
	}
	

	private int numero;
    private int piano;
    private int numLetti;
    private String tipo;
    private Boolean stato;
    private ArrayList<Extra> extra;
}

