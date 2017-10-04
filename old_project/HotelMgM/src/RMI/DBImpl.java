package RMI;

import java.io.Serializable;
import java.rmi.*;
import java.rmi.server.*;
import java.sql.*;
import java.util.*;
import java.sql.Connection;
import IS.*;

import java.util.Calendar;

/**
 * Questa classe contiene i metodi implementati per il collegamento con il database remoto
 * @author Daniele
 *
 */
public class DBImpl extends UnicastRemoteObject implements Serializable,DBAccount,DBCamera,DBPersona,DBCliente,DBExtra {

	static final long serialVersionUID=0;

	 private Connection conn;
     public java.sql.Statement stmt;
     private Connection conn2;
     public java.sql.Statement stmt2;
     String url;
     String url2;
     
	 public Calendar calendar = Calendar.getInstance();
	 
	/**
	 * Costruisce un oggetto di tipo DBImpl
	 * @throws RemoteException
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws SQLException
	 */
    public DBImpl() throws RemoteException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
     super();
     
     try {
 		  Class.forName("com.mysql.jdbc.Driver");
 	      } catch (ClassNotFoundException e) {	
 	    	  
 		      e.printStackTrace();
 	         }
 	
     String usr = "root";
     String psw = "";

     url= "jdbc:mysql://localhost/account?user=" + usr + "&password=" + psw;
     url2= "jdbc:mysql://localhost/hotelmgm?user=" + usr + "&password=" + psw;
     
    }
    
    /**
     * Apre la connessione al database1 (account)
     * @throws SQLException
     */
    public void openConnection() throws SQLException {
    	conn = DriverManager.getConnection(url);
        stmt = conn.createStatement();
    }
    
    /**
     * Apre la connessione al database2 (hotelmgm)
     * @throws SQLException
     */
    public void openConnection2() throws SQLException {
    	conn2=DriverManager.getConnection(url2);
        stmt2 = conn2.createStatement();
    }
    
    /**
     * Chiude la connessione al database1 (account)
     * @throws SQLException
     */
    public void closeConnection() throws SQLException {
    	stmt.close();
        conn.close();
    }
    
    /**
     * Chiude la connessione al database2 (hotelmgm)
     * @throws SQLException
     */
    public void closeConnection2() throws SQLException {
    	stmt2.close();
        conn2.close();
    }
    
 /**
  * Restituisce l'elenco degli account memorizzati nel database
  *
  * @return ArrayList<Account> lista degli account
  * @throws SQLException
  * @throws RemoteException
  */
    public ArrayList<Account> getElencoAccount() throws SQLException,RemoteException {
    	
    	    this.openConnection();    
    	
    	    ArrayList<Account> ListaAccount = new ArrayList<Account>();
    	    
    	    ResultSet rs = stmt.executeQuery("SELECT * FROM account");
    	    
    	    while(rs.next()){
    	    Account acc = new Account(rs.getString(1),rs.getString(2),rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
    	    ListaAccount.add(acc);
    	    }
    	    
    	    rs.close();
    	    this.closeConnection();
    	    
    	    return ListaAccount;	
       } 
    
    
    
    /**
     * Inserisce un Account nel database
     *
     *@param a Account
     * @return b Valore di controllo
     * @throws SQLException
     * @throws RemoteException
     */
    public boolean insertAccount(Account a) throws SQLException,RemoteException { 
 	    
    	this.openConnection(); 
    	boolean b=stmt.execute("INSERT INTO account VALUES('"+a.getLogin()+"','"+a.getPassword()+"','"+a.getNome()+
				"','"+a.getCognome()+"','"+a.getDataNascita()+"','"+a.getRuolo()+"');");
	    
    	this.closeConnection();
    	return b;
    }
    
    /**
     * Restituisce l'elenco degli account ricercati secondo i parametri memorizzati nel database
     *
     * @param login Nome utente dell'account 
     * @param nome Nome della persona a cui appartiene l'account
     * @param cognome Cognome della persona a cui appartiene l'account
     * @return ArrayList<Account> lista degli account
     * @throws SQLException
     * @throws RemoteException
     */
    public ArrayList<Account> getRicercaAccount(String login,String nome,String cognome) throws SQLException,RemoteException {
    	
    	this.openConnection(); 
    	ArrayList<Account> ListaAccount = new ArrayList<Account>();
    	
    	ResultSet rs=null;
   
    	if (!login.equals("")){
    	rs=stmt.executeQuery("SELECT * FROM account WHERE Login='"+login+"';");
        }
    	else  if (!nome.equals("")&&!cognome.equals("")){
    		rs=stmt.executeQuery("SELECT * FROM account WHERE (Nome='"+nome+"'and Cognome='"+cognome+"');");}
    	
    	while(rs.next()){
    	    Account acc = new Account(rs.getString(1),rs.getString(2),rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
    	    ListaAccount.add(acc);
    	    }
    	
    	rs.close();
    	this.closeConnection();
    	
    	return(ListaAccount);
    }
    
    /**
     * Restituisce l'elenco delle camere memorizzate nel database
     *
     * @return ArrayList<Camera> lista delle camere
     * @throws SQLException
     * @throws RemoteException
     */
    public ArrayList<Camera> getElencoCamera() throws SQLException,RemoteException {
	    
    	this.openConnection2();
    	
	    ArrayList<Camera> ListaCamera = new ArrayList<Camera>();
	    
	    ResultSet rs = stmt2.executeQuery("SELECT * FROM camera");
	    
	    while(rs.next()){
	    Camera cam = new Camera(rs.getInt(1),rs.getInt(2),rs.getInt(3), rs.getString(4), rs.getBoolean(5));
	    ListaCamera.add(cam);
	    }
	    
	    rs.close();
	    this.closeConnection2();
	    
	    return ListaCamera;	
   } 
   
    /**
     * Restituisce l'elenco delle camere libere memorizzate nel database
     *
     * @return ArrayList<Camera> lista delle camere
     * @throws SQLException
     * @throws RemoteException
     */
   public ArrayList<Camera> getElencoCameraLibera() throws SQLException,RemoteException {
	    
    	this.openConnection2();
    	
	    ArrayList<Camera> ListaCamera = new ArrayList<Camera>();
	    
	    ResultSet rs = stmt2.executeQuery("SELECT * FROM camera WHERE Stato='1';");
	    
	    while(rs.next()){
	    Camera cam = new Camera(rs.getInt(1),rs.getInt(2),rs.getInt(3), rs.getString(4), rs.getBoolean(5));
	    ListaCamera.add(cam);
	    }
	    
	    rs.close();
	    this.closeConnection2();
	    
	    return ListaCamera;	
   } 
   
   /**
    * Restituisce l'elenco delle camere occupate memorizzate nel database
    *
    * @return ArrayList<Camera> lista delle camere
    * @throws SQLException
    * @throws RemoteException
    */
   public ArrayList<Camera> getElencoCameraOccupata() throws SQLException,RemoteException {
	    
   	this.openConnection2();
   	
	    ArrayList<Camera> ListaCamera = new ArrayList<Camera>();
	    
	    ResultSet rs = stmt2.executeQuery("SELECT * FROM camera WHERE Stato='0';");
	    
	    while(rs.next()){
	    Camera cam = new Camera(rs.getInt(1),rs.getInt(2),rs.getInt(3), rs.getString(4), rs.getBoolean(5));
	    ListaCamera.add(cam);
	    }
	    
	    rs.close();
	    this.closeConnection2();
	    
	    return ListaCamera;	
  } 
   
   /**
    * Restituisce l'elenco delle persone associate ad un cliente
    *
    * @param codice Il codice del cliente associato
    * @return ArrayList<Persona> lista delle persone
    * @throws SQLException
    * @throws RemoteException
    */
   public ArrayList<Persona> getElencoPersone(int codice) throws SQLException,RemoteException {
	    
	   	this.openConnection2();

		    ArrayList<Persona> ListaPersone = new ArrayList<Persona>();
		    
		    ResultSet rs = stmt2.executeQuery("SELECT * FROM associa,persona WHERE (CodCliente='"+codice+"'and CodPersona=Cod);");
		    
		    while(rs.next()){
		    Persona per = new Persona(rs.getInt(3),rs.getString(4),rs.getString(5), rs.getString(6), rs.getString(7),rs.getString(8));
		    ListaPersone.add(per);
		    }
		    
		    rs.close();
		    this.closeConnection2();
		    
		    return ListaPersone;	
	  } 
   
   
   /**
    * Restituisce l'elenco dei clienti memorizzati nel database
    *
    * @return ArrayList<Cliente> lista dei clienti
    * @throws SQLException
    * @throws RemoteException
    */
   public ArrayList<Cliente> getElencoCliente() throws SQLException,RemoteException {
	    
	   	    this.openConnection2();
	   	
		    ArrayList<Cliente> ListaClienti = new ArrayList<Cliente>();
		    
		    ResultSet rs = stmt2.executeQuery("SELECT * FROM cliente");

		    while(rs.next()){
		    Cliente cli = new Cliente(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10));
		    ListaClienti.add(cli);

		    }
		    
		    rs.close();
		    this.closeConnection2();
		    
		    return ListaClienti;	
	  } 
   
   /**
    * Restituisce tutte le informazioni relative ad un cliente memorizzato nel database
    *
    * @param cod Il codice del cliente
    * @return ArrayList<Camera> lista delle camere
    * @throws SQLException
    * @throws RemoteException
    */
   public ArrayList<Cliente> getDettagliCliente(int cod) throws SQLException,RemoteException {
  	    this.openConnection2();
	    ArrayList<Cliente> ListaClienti = new ArrayList<Cliente>();
	    
	    ResultSet rs = stmt2.executeQuery("SELECT * FROM cliente WHERE Cod='"+cod+"';");
	    
	    while(rs.next()){
	    Cliente cli = new Cliente(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10));
	    ListaClienti.add(cli);

	    }
	    
	    rs.close();
	    this.closeConnection2();
	    
	    return ListaClienti;	
 } 
   
   /**
    * Restituisce l'elenco degli extra memorizzati nel database
    *
    * @return ArrayList<Extra> lista dei clienti
    * @throws SQLException
    * @throws RemoteException
    */
   public ArrayList<Extra> getElencoExtra() throws SQLException,RemoteException {
	   	
	    this.openConnection2();    
	
	    ArrayList<Extra> ListaExtra = new ArrayList<Extra>();
	    
	    ResultSet rs = stmt2.executeQuery("SELECT * FROM Extra");
	    
	    while(rs.next()){
	    	
	    Extra ext= new Extra(rs.getInt(1),rs.getString(2),rs.getDouble(3));
	    ListaExtra.add(ext);
	    }
	    
	    rs.close();
	    this.closeConnection2();
	    
	    return ListaExtra;	
 }
  
   /**
    * Inserisce un Extra nel database
    *
    *@param a Extra
    * @return b Valore di controllo
    * @throws SQLException
    * @throws RemoteException
    */
  public boolean insertExtra(Extra a) throws SQLException,RemoteException { 
	    
  	this.openConnection2(); 
  	boolean b=stmt2.execute("INSERT INTO extra (Nome,Prezzo) VALUES('"+a.getNome()+"','"+a.getPrezzo()+"');");
	    
  	this.closeConnection2();
  	return b;
  }
  
  /**
   * Inserisce una Persona nel database
   *
   *@param p Persona
   *@param cod Il codice del cliente a cui è associata la persona
   * @return b Valore di controllo
   * @throws SQLException
   * @throws RemoteException
   */
  public boolean insertPersona(Persona p,int cod)throws SQLException,RemoteException{
	   
  	this.openConnection2(); 
  	
	boolean b=stmt2.execute("INSERT INTO persona (Nome,Cognome,LuogoNascita,Provincia,DataNascita) VALUES('"+p.getNome()+"','"+p.getCognome()+"','"+p.getLuogoNascita()+
			"','"+p.getProvincia()+"','"+p.getDataNascita()+"');");
	
	ResultSet rs = stmt2.executeQuery("SELECT * FROM persona WHERE (Nome='"+p.getNome()+"' and Cognome='"+p.getCognome()+"' and DataNascita='"+p.getDataNascita()+"');");
	rs.next();
	boolean c=stmt2.execute("INSERT INTO associa VALUES('"+cod+"','"+rs.getInt(1)+"');");

	rs.close();
	this.closeConnection2();
	return c&&b;   
  }
  
  /**
   * Associa un extra ad una camera e di conseguenza ad un cliente
   *
   *@param numeCamera Il numero della camera
   *@param dataConsumazione La data in cui viene consumato l'extra
   *@param codExtra Il codice dell'extra consumato
   *@param q La quantità di extra consumati
   * @return b Valore di controllo
   * @throws SQLException
   * @throws RemoteException
   */
  public boolean associaExtra(int numeroCamera,String dataConsumazione,int codExtra,int q)throws SQLException,RemoteException{
	   
  	this.openConnection2(); 
  	boolean b=true;
  	
  	ResultSet rs = stmt2.executeQuery("SELECT * FROM calendario LEFT JOIN possiede ON(possiede.IDcalendario=calendario.IDcalendario) WHERE Numero='"+numeroCamera+"';");
  	
  	while(rs.next()){
  		String dataInizio=rs.getString(2);
  		String dataFine=rs.getString(3);
  
  		 int gg1=Integer.parseInt(dataInizio.substring(0,2));
         int mm1=Integer.parseInt(dataInizio.substring(3,5));
         int aa1=Integer.parseInt(dataInizio.substring(6,10));
   		GregorianCalendar dI=new GregorianCalendar(aa1,mm1-1,gg1);

   		
   		int gg2=Integer.parseInt(dataFine.substring(0,2));
         int mm2=Integer.parseInt(dataFine.substring(3,5));
         int aa2=Integer.parseInt(dataFine.substring(6,10));
   		GregorianCalendar dF=new GregorianCalendar(aa2,mm2-1,gg2);
   				
   		int gg3=Integer.parseInt(dataConsumazione.substring(0,2));
         int mm3=Integer.parseInt(dataConsumazione.substring(3,5));
         int aa3=Integer.parseInt(dataConsumazione.substring(6,10));
   		GregorianCalendar dCons=new GregorianCalendar(aa3,mm3-1,gg3);
  		
  		if ((dCons.after(dF)||dCons.before(dI))&& rs.getInt(6)==numeroCamera){b=true;}
  		else{b=stmt2.execute("INSERT INTO ha VALUES('"+numeroCamera+"','"+rs.getInt(4)+"','"+codExtra+"','"+dataConsumazione+"','"+q+"');"); break;}
  		
  	   }
  	
	rs.close();
	this.closeConnection2();
	return b;	   
  }
	
  
  /**
   * Effettua la prenotazione di una camera in un determinato periodo
   *
   *@param camera Il numero della camera
   *@param dI La data di inizio prenotazione
   *@param dF La data di fine prenotazione
   *@param nom Il nome del cliente
   *@param cog Il cognome del cliente
   *@param dN La data di nascita del cliente
   * @return b Valore di controllo
   * @throws SQLException
   * @throws RemoteException
   */
  public boolean setPrenota(int camera,String dI,String dF,String nom,String cog,String dN)throws SQLException,RemoteException{
	   
 	this.openConnection2(); 
 	ResultSet rs1 = stmt2.executeQuery("SELECT * FROM prenota");
 	
 	int gg1P=Integer.parseInt(dI.substring(0,2));
    int mm1P=Integer.parseInt(dI.substring(3,5));
    int aa1P=Integer.parseInt(dI.substring(6,10));
		GregorianCalendar parametrodI=new GregorianCalendar(aa1P,mm1P-1,gg1P);
		
    int gg2P=Integer.parseInt(dF.substring(0,2));
    int mm2P=Integer.parseInt(dF.substring(3,5));
    int aa2P=Integer.parseInt(dF.substring(6,10));
		GregorianCalendar parametrodF=new GregorianCalendar(aa2P,mm2P-1,gg2P);
 	
 	while(rs1.next()){
 		int codCamera=rs1.getInt(2);
 		String datI=rs1.getString(3);
 		String datF=rs1.getString(4);
 		
 		int gg1=Integer.parseInt(datI.substring(0,2));
        int mm1=Integer.parseInt(datI.substring(3,5));
        int aa1=Integer.parseInt(datI.substring(6,10));
  		GregorianCalendar calendariodI=new GregorianCalendar(aa1,mm1-1,gg1);
  		
  		int gg2=Integer.parseInt(datF.substring(0,2));
        int mm2=Integer.parseInt(datF.substring(3,5));
        int aa2=Integer.parseInt(datF.substring(6,10));
  		GregorianCalendar calendariodF=new GregorianCalendar(aa2,mm2-1,gg2);
 		
  		if ((parametrodI.after(calendariodI)&&parametrodI.before(calendariodF))&& codCamera==camera){return true;}
  		if ((parametrodF.after(calendariodI)&&parametrodF.before(calendariodF))&& codCamera==camera){return true;}
  		if ((parametrodF.equals(calendariodF)||parametrodI.equals(calendariodI))&& codCamera==camera){return true;}
  		
 	}
 	
	ResultSet rs = stmt2.executeQuery("SELECT * FROM cliente WHERE (Nome='"+nom+"' and Cognome='"+cog+"' and DataNascita='"+dN+"');");

	
	if (rs.next())
    {boolean c=stmt2.execute("INSERT INTO prenota VALUES('"+rs.getInt(1)+"','"+camera+"','"+dI+"','"+dF+"');");
	 rs.close();
	 this.closeConnection2();
	 return c;  
	}
	
	rs.close();
	this.closeConnection2();
	return true; 
 }
  
  
  /**
   * Effettua la ricerca di una cliente nel database secondo i parametri d'ingresso
   *
   *@param nome Il nome del cliente
   *@param cognome Il cognome del cliente
   *@param data La data di nascita prenotazione
   * @return ArrayList<Cliente> lista dei clienti
   * @throws SQLException
   * @throws RemoteException
   */
  public ArrayList<Cliente> getRicercaCliente(String nome,String cognome,String data) throws SQLException,RemoteException {
  	
  	this.openConnection2(); 
  	ArrayList<Cliente> ListaClienti = new ArrayList<Cliente>();
  	
  	ResultSet rs=null;
 
  	if (!nome.equals(" ")&&cognome.equals(" ")&&data.equals(" "))
  	rs=stmt2.executeQuery("SELECT * FROM cliente WHERE Nome='"+nome+"';");
  	else{
  		if (nome.equals(" ")&&!cognome.equals(" ")&&data.equals(" "))
  		  	rs=stmt2.executeQuery("SELECT * FROM cliente WHERE Cognome='"+cognome+"';"); 		      
  		else{
  			if (nome.equals(" ")&&cognome.equals(" ")&&!data.equals(" "))
  	  		  	rs=stmt2.executeQuery("SELECT * FROM cliente WHERE DataNascita='"+data+"';");
  			else{
  		        if (!nome.equals(" ")&&!cognome.equals(" "))
  		          rs=stmt2.executeQuery("SELECT * FROM cliente WHERE (Nome='"+nome+"'and Cognome='"+cognome+"');");
  		        else{
  		        	 if (!nome.equals(" ")&&cognome.equals(" ")&&!data.equals(" "))
  		  		          rs=stmt2.executeQuery("SELECT * FROM cliente WHERE (Nome='"+nome+"'and DataNascita='"+data+"');");
  		  		        else{
  		  		        if (nome.equals(" ")&&!cognome.equals(" ")&&!data.equals(" "))
    		  		          rs=stmt2.executeQuery("SELECT * FROM cliente WHERE (Cognome='"+cognome+"'and DataNascita='"+data+"');");
    		  		        else{
  		                       if (!nome.equals(" ")&&!cognome.equals(" ")&&!data.equals(" "))
                                 rs=stmt2.executeQuery("SELECT * FROM cliente WHERE (Nome='"+nome+"'and Cognome='"+cognome+"'and DataNascita='"+data+"');");
		                        }
		                     }
		              }
		         }
  	        }
  	}
  		        	
  	while(rs.next()){
  	    Cliente cli = new Cliente(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10));
  	    ListaClienti.add(cli);
  	    }
  	
  	rs.close();
  	this.closeConnection2();
  	
  	return(ListaClienti);
  }
  
  /**
   * Inserisce un Cliente nel database
   *
   * @param c Cliente
   * @return b Valore di controllo
   * @throws SQLException
   * @throws RemoteException
   */
  public boolean insertCliente(Cliente c) throws SQLException,RemoteException { 
	    
	  	this.openConnection2(); 
	  	boolean b=stmt2.execute("INSERT INTO cliente (Nome,Cognome,LuogoNascita,Provincia,DataNascita,NumCartaID,CodFiscale,Nazionalita,Sesso)VALUES('"+c.getNome()+"','"+c.getCognome()+"','"+c.getLuogoNascita()+
			"','"+c.getProvincia()+"','"+c.getDataNascita()+"','"+c.getNumCartaID()+"','"+c.getCodFiscale()+"','"+c.getNazionalita()+"','"+c.getSesso()+"');");
	  	this.closeConnection2();
	  	return b;
	  }
  
  /**
   * Effettua la ricerca di una camera nel database secondo i parametri d'ingresso
   *
   *@param num Il numero della camera
   *@param piano Il numero di piano in cui si trova la camera
   *@param tipo Il tipo della camera
   *@param numLetti Il numero di letti della camera
   * @return ArrayList<Camera> lista delle camere
   * @throws SQLException
   * @throws RemoteException
   */
  public ArrayList<Camera> getRicercaCamera(int num, int piano, String tipo,int numLetti) throws SQLException, RemoteException {
	   	this.openConnection2();
	   	
	   	ResultSet rs = null;
	   	
	    ArrayList<Camera> ListaCamera = new ArrayList<Camera>();
	    
	    if (num!=0&&piano==0&&tipo.equals("")&&numLetti==0)
	      	rs=stmt2.executeQuery("SELECT * FROM camera WHERE Numero='"+num+"';");
	      	else{  
	      		if (num==0&&piano!=0&&tipo.equals("")&&numLetti==0)
	    	      	   rs=stmt2.executeQuery("SELECT * FROM camera WHERE Piano='"+piano+"';");
	      	      else{  
	      	    	  if (num==0&&piano==0&&(!tipo.equals(""))&&numLetti==0)
	      	            	rs=stmt2.executeQuery("SELECT * FROM camera WHERE Tipo='"+tipo+"';");
	      	             else{
	      	            	  if (num==0&&piano==0&&tipo.equals("")&&numLetti!=0)
	      	        	      	  rs=stmt2.executeQuery("SELECT * FROM camera WHERE NumLetti='"+numLetti+"';");
	      	        	      	else{          
	      		                   if (num!=0&&piano!=0&&tipo.equals("")&&numLetti==0)
	      		                	   rs=stmt2.executeQuery("SELECT * FROM camera WHERE (Numero='"+num+"'and Piano='"+piano+"');");
	      		                    else{ 
	      		                	   if (num!=0&&piano==0&&tipo.equals("")&&numLetti!=0)
		      		                	     rs=stmt2.executeQuery("SELECT * FROM camera WHERE (Numero='"+num+"'and NumLetti='"+numLetti+"');");
		      		                     else{
		      		                    	if (num!=0&&piano==0&&(!tipo.equals(""))&&numLetti==0)
		 	      		                	   rs=stmt2.executeQuery("SELECT * FROM camera WHERE (Numero='"+num+"'and Tipo='"+tipo+"');");
		 	      		                      else{	 
		 	      		                    	  if (num==0&&piano!=0&&tipo.equals("")&&numLetti!=0)
		 		      		                	       rs=stmt2.executeQuery("SELECT * FROM camera WHERE (NumLetti='"+numLetti+"'and Piano='"+piano+"');");
		 		      		                       else{
		 		      		                    	   if (num==0&&piano!=0&&(!tipo.equals(""))&&numLetti==0)
		 			      		                	       rs=stmt2.executeQuery("SELECT * FROM camera WHERE (Tipo='"+tipo+"'and Piano='"+piano+"');");
		 			      		                        else{
		 			      		                        	if (num==0&&piano==0&&(!tipo.equals(""))&&numLetti!=0)
		 			    	      		                	      rs=stmt2.executeQuery("SELECT * FROM camera WHERE (Tipo='"+tipo+"'and NumLetti='"+numLetti+"');");
		 			    	      		                       else{
		 			    	      		                    	  if (num!=0&&piano!=0&&tipo.equals("")&&numLetti!=0)
		 			    		      		                	      rs=stmt2.executeQuery("SELECT * FROM camera WHERE (Numero='"+num+"'and Piano='"+piano+"'and NumLetti='"+numLetti+"');");
		 			    		      		                         else{
		 			    		      		                        	if (num!=0&&piano!=0&&(!tipo.equals(""))&&numLetti==0)
				 			    		      		                	      rs=stmt2.executeQuery("SELECT * FROM camera WHERE (Numero='"+num+"'and Piano='"+piano+"'and Tipo='"+tipo+"');");
				 			    		      		                         else{
				 			    		      		                        	if (num!=0&&piano==0&&(!tipo.equals(""))&&numLetti!=0)
						 			    		      		                	      rs=stmt2.executeQuery("SELECT * FROM camera WHERE (Numero='"+num+"'and Tipo='"+tipo+"'and NumLetti='"+numLetti+"');");
						 			    		      		                         else{
						 			    		      		                        	if (num==0&&piano!=0&&(!tipo.equals(""))&&numLetti!=0)
								 			    		      		                	      rs=stmt2.executeQuery("SELECT * FROM camera WHERE (Tipo='"+tipo+"'and Piano='"+piano+"'and NumLetti='"+numLetti+"');");
								 			    		      		                         else{	 
								 			    		      		                        	if (num!=0&&piano!=0&&(!tipo.equals(""))&&numLetti!=0)
										 			    		      		                	      rs=stmt2.executeQuery("SELECT * FROM camera WHERE (Numero='"+num+"'and Piano='"+piano+"'and NumLetti='"+numLetti+"'and Tipo='"+tipo+"');");
								 			    		      		                              }
						 			    		      		                              }
				 			    		      		                              }
		 			    		      		                             }
		 			    	      		                            }
		 			      		                            }
		 		      		                       }
		 	      		                      }
		      		                     }
	      		                    }
	      	        	      	}
	      	             }
	      	      }
	      	}    
	    while(rs.next()){
	    Camera cam = new Camera(rs.getInt(1),rs.getInt(2),rs.getInt(3), rs.getString(4), rs.getBoolean(5));
	    ListaCamera.add(cam);
	    }
	    
	    rs.close();
	    this.closeConnection2();
	    
	    return ListaCamera;
	}
  
  
  /**
   * Effettua la ricerca disponibilità di una camera in un determinato periodo secondo i parametri d'ingresso
   *
   *@param num Il numero della camera
   *@param piano Il numero di piano in cui si trova la camera
   *@param tipo Il tipo della camera
   *@param numLetti Il numero di letti della camera
   *@param dI La data di inizio prenotazione
   *@param dF La data di fine prenotazione
   * @return ArrayList<Camera> lista delle camere
   * @throws SQLException
   * @throws RemoteException
   */
  
  public ArrayList<Camera> getRicercaDisponibilitaCamera(int num, int piano, String tipo,int numLetti,String dI,String dF) throws SQLException, RemoteException {  
	  this.openConnection2();
	   	
	    int gg1P=Integer.parseInt(dI.substring(0,2));
	    int mm1P=Integer.parseInt(dI.substring(3,5));
	    int aa1P=Integer.parseInt(dI.substring(6,10));
			GregorianCalendar parametrodI=new GregorianCalendar(aa1P,mm1P-1,gg1P);
			
	    int gg2P=Integer.parseInt(dF.substring(0,2));
	    int mm2P=Integer.parseInt(dF.substring(3,5));
	    int aa2P=Integer.parseInt(dF.substring(6,10));
			GregorianCalendar parametrodF=new GregorianCalendar(aa2P,mm2P-1,gg2P);
	  
	   	ResultSet rs = null;
	   	
	    ArrayList<Camera> ListaRicerca = new ArrayList<Camera>();
	    
	    if (num!=0&&piano==0&&tipo.equals("")&&numLetti==0)
	      	rs=stmt2.executeQuery("SELECT * FROM camera WHERE Numero='"+num+"';");
	      	else{  
	      		if (num==0&&piano!=0&&tipo.equals("")&&numLetti==0)
	    	      	   rs=stmt2.executeQuery("SELECT * FROM camera WHERE Piano='"+piano+"';");
	      	      else{  
	      	    	  if (num==0&&piano==0&&(!tipo.equals(""))&&numLetti==0)
	      	            	rs=stmt2.executeQuery("SELECT * FROM camera WHERE Tipo='"+tipo+"';");
	      	             else{
	      	            	  if (num==0&&piano==0&&tipo.equals("")&&numLetti!=0)
	      	        	      	  rs=stmt2.executeQuery("SELECT * FROM camera WHERE NumLetti='"+numLetti+"';");
	      	        	      	else{          
	      		                   if (num!=0&&piano!=0&&tipo.equals("")&&numLetti==0)
	      		                	   rs=stmt2.executeQuery("SELECT * FROM camera WHERE (Numero='"+num+"'and Piano='"+piano+"');");
	      		                    else{ 
	      		                	   if (num!=0&&piano==0&&tipo.equals("")&&numLetti!=0)
		      		                	     rs=stmt2.executeQuery("SELECT * FROM camera WHERE (Numero='"+num+"'and NumLetti='"+numLetti+"');");
		      		                     else{
		      		                    	if (num!=0&&piano==0&&(!tipo.equals(""))&&numLetti==0)
		 	      		                	   rs=stmt2.executeQuery("SELECT * FROM camera WHERE (Numero='"+num+"'and Tipo='"+tipo+"');");
		 	      		                      else{	 
		 	      		                    	  if (num==0&&piano!=0&&tipo.equals("")&&numLetti!=0)
		 		      		                	       rs=stmt2.executeQuery("SELECT * FROM camera WHERE (NumLetti='"+numLetti+"'and Piano='"+piano+"');");
		 		      		                       else{
		 		      		                    	   if (num==0&&piano!=0&&(!tipo.equals(""))&&numLetti==0)
		 			      		                	       rs=stmt2.executeQuery("SELECT * FROM camera WHERE (Tipo='"+tipo+"'and Piano='"+piano+"');");
		 			      		                        else{
		 			      		                        	if (num==0&&piano==0&&(!tipo.equals(""))&&numLetti!=0)
		 			    	      		                	      rs=stmt2.executeQuery("SELECT * FROM camera WHERE (Tipo='"+tipo+"'and NumLetti='"+numLetti+"');");
		 			    	      		                       else{
		 			    	      		                    	  if (num!=0&&piano!=0&&tipo.equals("")&&numLetti!=0)
		 			    		      		                	      rs=stmt2.executeQuery("SELECT * FROM camera WHERE (Numero='"+num+"'and Piano='"+piano+"'and NumLetti='"+numLetti+"');");
		 			    		      		                         else{
		 			    		      		                        	if (num!=0&&piano!=0&&(!tipo.equals(""))&&numLetti==0)
				 			    		      		                	      rs=stmt2.executeQuery("SELECT * FROM camera WHERE (Numero='"+num+"'and Piano='"+piano+"'and Tipo='"+tipo+"');");
				 			    		      		                         else{
				 			    		      		                        	if (num!=0&&piano==0&&(!tipo.equals(""))&&numLetti!=0)
						 			    		      		                	      rs=stmt2.executeQuery("SELECT * FROM camera WHERE (Numero='"+num+"'and Tipo='"+tipo+"'and NumLetti='"+numLetti+"');");
						 			    		      		                         else{
						 			    		      		                        	if (num==0&&piano!=0&&(!tipo.equals(""))&&numLetti!=0)
								 			    		      		                	      rs=stmt2.executeQuery("SELECT * FROM camera WHERE (Tipo='"+tipo+"'and Piano='"+piano+"'and NumLetti='"+numLetti+"');");
								 			    		      		                         else{	 
								 			    		      		                        	if (num!=0&&piano!=0&&(!tipo.equals(""))&&numLetti!=0)
										 			    		      		                	      rs=stmt2.executeQuery("SELECT * FROM camera WHERE (Numero='"+num+"'and Piano='"+piano+"'and NumLetti='"+numLetti+"'and Tipo='"+tipo+"');");
								 			    		      		                              }
						 			    		      		                              }
				 			    		      		                              }
		 			    		      		                             }
		 			    	      		                            }
		 			      		                            }
		 		      		                       }
		 	      		                      }
		      		                     }
	      		                    }
	      	        	      	}
	      	             }
	      	      }
	      	}  
	    
	    
	  while(rs.next()){
	    Camera cam = new Camera(rs.getInt(1),rs.getInt(2),rs.getInt(3), rs.getString(4), rs.getBoolean(5));
	    ListaRicerca.add(cam);
	  }
	    
	  ArrayList<Camera> ListaCamere = new ArrayList<Camera>();
	  boolean flag=true;; 
	  
	   for(Camera cam:ListaRicerca){ 
	    
		   ResultSet rs2 = stmt2.executeQuery("SELECT distinct * FROM prenota WHERE Numero='"+cam.getNumero()+"';");
		   flag=true;
		   while(rs2.next()){
			   String dataInizio=rs2.getString(3);
		       String dataFine=rs2.getString(4);
		          
		       int ggDI=Integer.parseInt(dataInizio.substring(0,2));
		       int mmDI=Integer.parseInt(dataInizio.substring(3,5));
		       int aaDI=Integer.parseInt(dataInizio.substring(6,10));
			   GregorianCalendar prenotaDI=new GregorianCalendar(aaDI,mmDI-1,ggDI);
				
		       int ggDF=Integer.parseInt(dataFine.substring(0,2));
		       int mmDF=Integer.parseInt(dataFine.substring(3,5));
		       int aaDF=Integer.parseInt(dataFine.substring(6,10));
			   GregorianCalendar prenotaDF=new GregorianCalendar(aaDF,mmDF-1,ggDF);
			   
			   if ((parametrodI.after(prenotaDI)&& parametrodI.before(prenotaDF)) ||(parametrodF.after(prenotaDI)&& parametrodF.before(prenotaDF))||(parametrodI.before(prenotaDI)&& parametrodF.after(prenotaDF)) || (parametrodI.equals(prenotaDI)||parametrodF.equals(prenotaDF))){flag=false;}
		   }
		   
		   if (flag) ListaCamere.add(cam); 
	   }

	    
	   rs.close();
	   this.closeConnection2();
	    
	  return ListaCamere;
  }
  
  /**
   * Inserisce una Camera nel database
   *
   * @param c Camera
   * @return b Valore di controllo
   * @throws SQLException
   * @throws RemoteException
   */
  public boolean insertCamera(Camera c) throws SQLException, RemoteException {
		
		this.openConnection2();
		int stato;
		
		if(c.getStato())stato=1;
		else stato=0;
		
		boolean b=stmt2.execute("INSERT INTO camera VALUES('"+c.getNumero()+"','"+c.getPiano()+"','"+c.getNumLetti()+
				"','"+c.getTipo()+"','"+stato+"');");
	    
		this.closeConnection2();
		
		return b;
	}
 
 
  /**
   * Effettua l'operazione di occupazione della camera
   *
   *@param numCamera Il numero della camera
   *@param codiceCliente Il codice cliente
   *@param dI La data di inizio prenotazione
   *@param dF La data di fine prenotazione
   * @return b Valore di controllo
   * @throws SQLException
   * @throws RemoteException
   */
  public boolean occupaCamera(int numCamera,int codiceCliente,String dI,String dF) throws SQLException,RemoteException { 
	    
	  	this.openConnection2(); 
	  
	  	
	  	  boolean b=stmt2.execute("INSERT INTO calendario (DataInizio,DataFine,CodCliente) VALUES('"+dI+"','"+dF+"','"+codiceCliente+"');");
	  	  
	  	  ResultSet rs=stmt2.executeQuery("SELECT IDcalendario FROM calendario WHERE (DataInizio='"+dI+"'and DataFine='"+dF+"'and CodCliente='"+codiceCliente+"');");
	  	  rs.next();
	  	  int idCalendario=rs.getInt(1);
	  	
	  	  boolean c=stmt2.execute("INSERT INTO possiede (IDcalendario,Numero) VALUES('"+idCalendario+"','"+numCamera+"');");
	  	
	  	  stmt2.executeUpdate("UPDATE camera SET Stato='0' WHERE Numero='"+numCamera+"';");
	  	  
	  	  this.closeConnection2();
	  	  return b&&c;
	  	 }  
  
  /**
   * Verifica se un determinato cliente ha prenotato quella determinata camera
   *
   *@param codCliente Il codice cliente
   *@param num Il numero della camera
   *@param dI La data di inizio prenotazione
   *@param dF La data di fine prenotazione
   * @return b Valore di controllo
   * @throws SQLException
   * @throws RemoteException
   */
  public boolean controllaPrenotazione(int codCliente,int num,String dI,String dF)throws SQLException,RemoteException{
	  this.openConnection2();
	  
  	  ResultSet rs=stmt2.executeQuery("SELECT * FROM prenota WHERE (DataInizio='"+dI+"'and DataFine='"+dF+"'and Cod='"+codCliente+"'and Numero='"+num+"');");
  	  int cont=0;
  	  
  	  while(rs.next()){
  		  cont++;
  	  }
  	  
  	 ResultSet rs2=stmt2.executeQuery("SELECT * FROM calendario WHERE (DataInizio='"+dI+"'and DataFine='"+dF+"'and CodCliente='"+codCliente+"');");
 	  int cont2=0;
 	  
 	  while(rs2.next()){
 		  cont2++;
 	  }

	  this.closeConnection2();
	  if (cont>0&&cont2==0) return true;
  	                     else return false;
  }
	

  /**
   * Effettua l'operazione di rilascio della camera
   *
   *@param numCamera Il numero della camera
   *@param dataFine La data del giorno attuale (data di rilascio)
   * @throws SQLException
   * @throws RemoteException
   */
  public void rilasciaCamera(int numCamera,String dataFine) throws SQLException,RemoteException { 
	    
	  	this.openConnection2(); 
	  
	  	  ResultSet rs=stmt2.executeQuery("SELECT DataInizio FROM possiede,calendario WHERE (possiede.IDcalendario=calendario.IDcalendario and Numero='"+numCamera+"');");
	  	  
	  	  String data;
	  	  String ultimaData;
	  	  rs.next();
	  	  
	  	  String dataPrec=rs.getString(1);
	  	  ultimaData=dataPrec;
	  	  
	  	  int ggPrec=Integer.parseInt(dataPrec.substring(0,2));
	      int mmPrec=Integer.parseInt(dataPrec.substring(3,5));
	      int aaPrec=Integer.parseInt(dataPrec.substring(6,10));
		  GregorianCalendar dataprecedente=new GregorianCalendar(aaPrec,mmPrec-1,ggPrec);
	  	  
	  	  while(rs.next()){
	  		
	  		  data=rs.getString(1);
	  		  int gg=Integer.parseInt(data.substring(0,2));
		      int mm=Integer.parseInt(data.substring(3,5));
		      int aa=Integer.parseInt(data.substring(6,10));
			  GregorianCalendar datattuale=new GregorianCalendar(aa,mm-1,gg);

	  		  if(datattuale.after(dataprecedente)){ultimaData=data;}
	  		  dataprecedente=datattuale;
	  	  }
	  	 
	  	  stmt2.executeUpdate("UPDATE calendario SET DataFine='"+dataFine+"' WHERE DataInizio='"+ultimaData+"';");
	  	  stmt2.executeUpdate("UPDATE camera SET Stato='1' WHERE Numero='"+numCamera+"';");
	  	
	  	  ResultSet rs2=stmt2.executeQuery("SELECT * FROM prenota WHERE Numero='"+numCamera+"';");
	  	  
	  	  ArrayList<String> ListaDataInizio= new ArrayList<String>();
	  	  ArrayList<String> ListaDataFine=new ArrayList<String>();
	  	  
	  	  while(rs2.next()){
	  		  ListaDataInizio.add(rs2.getString(3));
	  		  ListaDataFine.add(rs2.getString(4));
	  	  }
	  	  
	  	  
	  	  int gg=Integer.parseInt(dataFine.substring(0,2));
	      int mm=Integer.parseInt(dataFine.substring(3,5));
	      int aa=Integer.parseInt(dataFine.substring(6,10));
		  GregorianCalendar attuale=new GregorianCalendar(aa,mm-1,gg);
	  	  
		  String dI="";
		  String dF="";
		  String ini="";
		  String fin="";
		  
	  	  int i=0;
	  	  
	  	  for(i=0; i<ListaDataInizio.size() ;i++){
	  		  
	  		  dI=ListaDataInizio.get(i);
	  		  dF=ListaDataFine.get(i);
	  		  
	  		  int ggI=Integer.parseInt(dI.substring(0,2));
		      int mmI=Integer.parseInt(dI.substring(3,5));
		      int aaI=Integer.parseInt(dI.substring(6,10));
			  GregorianCalendar iniziale=new GregorianCalendar(aaI,mmI-1,ggI);
		  	  
			  int ggF=Integer.parseInt(dF.substring(0,2));
		      int mmF=Integer.parseInt(dF.substring(3,5));
		      int aaF=Integer.parseInt(dF.substring(6,10));
			  GregorianCalendar finale=new GregorianCalendar(aaF,mmF-1,ggF);
		  	  
			  if ((attuale.after(iniziale)&& attuale.before(finale))||(attuale.equals(iniziale))||(attuale.equals(finale)))	{ini=dI;fin=dF;break;}	  
	  	  }
  
	  	  
	  	  stmt2.executeUpdate("DELETE FROM prenota WHERE (DataInizio='"+ini+"'and DataFine='"+fin+"'and Numero='"+numCamera+"');");
 	                                                                                                                    
	  	  this.closeConnection2();
	  	 } 
  
}
  

