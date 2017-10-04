package SottosistemaAmministratore;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import IS.BarraMenuIS;
import IS.Contenitore;
import IS.FrameMessage;
import IS.Account;
import IS.FramePrincipaleIS;
import RMI.DBAccount;
import RMI.DBClient;
import Eccezioni.*;

/**
 * Questa classe definisce un oggetto FrameAggiungiUtente
 * @author Daniele
 *
 */
public class FrameAggiungiUtente extends JFrame{

static final long serialVersionUID=0;
	
/**
 * Costruisce la finestra frame con tutte le sue componenti 
 * @param c Oggetto di tipo contenitore
 */
	public FrameAggiungiUtente(Contenitore c){
		
		contenitore=c;
		
		frame=new JFrame();
		
		frame.setSize(900,600);
		frame.setTitle("HotelMgM");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		BarraMenuIS barra=new BarraMenuIS(frame,contenitore,4);
		frame.setJMenuBar(barra.getMenu());
		
		
		JPanel pannello=new JPanel();
		pannello.setBackground(contenitore.getColore());

		//Caricare un'immagine
		Toolkit kit=Toolkit.getDefaultToolkit();
		
		//immagine Icona
		String pathIcona="./immagini/trasparente/logo25.png";
		Image imgIcona=kit.getImage(pathIcona);
		
		frame.setIconImage(imgIcona);//inserisce l'icona al titolo
	
		//pannello0
		JPanel panel0=new JPanel();
		panel0.setBackground(contenitore.getColore());
		
		String pathImg3="./immagini/trasparente/logo25.png";
		Image img3=kit.getImage(pathImg3);
		Icon iconaImg3=new ImageIcon(img3);
		JLabel imm3=new JLabel(iconaImg3);
		
		Font font=new Font("SansSerif",Font.PLAIN+Font.BOLD,40);//FONT per una label
		
		JLabel larea=new JLabel("            Dati Nuovo Utente  ");
		larea.setFont(font);
		
		String pathEsci="./Bottoni/Esci_0.png";
		Image imgButtonEsci=kit.getImage(pathEsci);
		Icon iconaPulsanteEsci=new ImageIcon(imgButtonEsci);	
		JButton esci=new JButton(iconaPulsanteEsci);
		esci.setBackground(contenitore.getColore());
		esci.setFocusPainted(false); 
		esci.setBorderPainted(false);
		esci.setContentAreaFilled(false);
		esci.setPressedIcon(new ImageIcon ("./Bottoni/Esci_1.png"));
		
		//crea comandi bottone Esci <----------------------
		class addActionListenerEsci implements ActionListener
		{
			public void actionPerformed(ActionEvent event){
				
				FramePrincipaleIS p=new FramePrincipaleIS(contenitore);
				p.visualizzaFrame();
				frame.dispose();
				
			}
		}
		ActionListener listenerEsci=new addActionListenerEsci();
		esci.addActionListener(listenerEsci);
		
		JLabel space=new JLabel("                   ");
		
		panel0.add(imm3);
		panel0.add(larea);
		panel0.add(space);
		panel0.add(esci);
		
		//panel1
		JPanel panel1=new JPanel();
		panel1.setBackground(contenitore.getColore());
		
		Image img2=kit.getImage("./immagini/Contact.png");
		JLabel l2=new JLabel();
		Icon imIcona2=new ImageIcon(img2);//Crea una icona per caricare l'immagine in una label
		l2.setIcon(imIcona2);//Carica l'immagine in una label
		
		JLabel space0=new JLabel("                                      ");
		JLabel space1=new JLabel("                                      ");

		String pathIndietro="./Bottoni/Indietro_0.png";
		Image imgButtonIndietro=kit.getImage(pathIndietro);
		Icon iconaPulsanteIndietro=new ImageIcon(imgButtonIndietro);	
		JButton indietro=new JButton(iconaPulsanteIndietro);
		indietro.setBackground(contenitore.getColore());
		indietro.setFocusPainted(false); 
		indietro.setBorderPainted(false);
		indietro.setContentAreaFilled(false);
		indietro.setPressedIcon(new ImageIcon ("./Bottoni/Indietro_1.png"));

		//crea comandi bottone Indietro <----------------------
		class addActionListenerIndietro implements ActionListener
		{
			public void actionPerformed(ActionEvent event){
				
				FramePannelloControllo p=new FramePannelloControllo(contenitore);
				p.visualizzaFrame();
				frame.dispose();
				
			}
		}
		ActionListener listenerIndietro=new addActionListenerIndietro();
		indietro.addActionListener(listenerIndietro);
		
		
		String pathHome="./Bottoni/Home_0.png";
		Image imgButtonHome=kit.getImage(pathHome);
		Icon iconaPulsanteHome=new ImageIcon(imgButtonHome);	
		JButton home=new JButton(iconaPulsanteHome);
		home.setBackground(contenitore.getColore());
		home.setFocusPainted(false); 
		home.setBorderPainted(false);
		home.setContentAreaFilled(false);
		home.setPressedIcon(new ImageIcon ("./Bottoni/Home_1.png"));

		//crea comandi bottone Home <----------------------
		class addActionListenerHome implements ActionListener
		{
			public void actionPerformed(ActionEvent event){
				
				FrameAdmin p=new FrameAdmin(contenitore);
				p.visualizzaFrame();
				frame.dispose();
				
			}
		}
		ActionListener listenerHome=new addActionListenerHome();
		home.addActionListener(listenerHome);
		
		
		panel1.add(indietro);
		panel1.add(space0);
		panel1.add(l2);
		panel1.add(space1);
		panel1.add(home);
		
		//panel2
		JPanel panel2=new JPanel();
		panel2.setBackground(contenitore.getColore());
		
		JLabel nomeUtente=new JLabel("Nome Utente ");
		areaNomeU=new JTextField(15);
	
		JLabel pass=new JLabel("Password ");
		areaPass=new JTextField(15);
		
		JPanel intermedio1=new JPanel();
		intermedio1.setBackground(contenitore.getColore());
		intermedio1.add(nomeUtente);
		intermedio1.add(areaNomeU);
		intermedio1.add(pass);
		intermedio1.add(areaPass);
		
		
		JLabel nome=new JLabel("Nome ");
		areaNome=new JTextField(15);
	
		JLabel cognome=new JLabel("Cognome ");
		areaCog=new JTextField(15);
		
		JPanel intermedio2=new JPanel();
		intermedio2.setBackground(contenitore.getColore());
		intermedio2.add(nome);
		intermedio2.add(areaNome);
		intermedio2.add(cognome);
		intermedio2.add(areaCog);
		
		JLabel data=new JLabel("Data di Nascita ");
		gg=new JTextField(2);
		JLabel slash1=new JLabel("/");
		mm=new JTextField(2);
		JLabel slash2=new JLabel("/");
		aaaa=new JTextField(4);
		
		JLabel ruolo=new JLabel("         Ruolo ");
		scelta=new JComboBox();
		scelta.addItem("Amministratore");
		scelta.addItem("Operatore livello1");
		scelta.addItem("Operatore livello2");
		
		String pathConferma="./Bottoni/Conferma_0.png";
		Image imgButtonConferma=kit.getImage(pathConferma);
		Icon iconaPulsanteConferma=new ImageIcon(imgButtonConferma);	
		JButton conferma=new JButton(iconaPulsanteConferma);
		conferma.setBackground(contenitore.getColore());
		conferma.setFocusPainted(false); 
		conferma.setBorderPainted(false);
		conferma.setContentAreaFilled(false);
		conferma.setPressedIcon(new ImageIcon ("./Bottoni/Conferma_1.png"));

		//crea comandi bottone Conferma <----------------------
		class addActionListenerConferma implements ActionListener
		{
			public void actionPerformed(ActionEvent event){
				
				DBClient client=contenitore.getClient();  
				
				try {     String nomeU=areaNomeU.getText();
				    	  String n=areaNome.getText();
				    	  String p=areaPass.getText();
				    	  String c=areaCog.getText();
				    	  String select=(String)scelta.getSelectedItem();
				    	  
				    	  String giorno=gg.getText();    	 
				    	  String mese=mm.getText();
				    	  String anno=aaaa.getText();
				    	  
				    	  if (nomeU.equals("")||n.equals("")||p.equals("")||c.equals("")||select.equals("")||giorno.equals("")||mese.equals("")||anno.equals("")) throw new ErrorException(contenitore,"<html>Riempire tutti i campi!</html>");			    	  
				    	  
				    	  
				    	  int ng=Integer.parseInt(giorno);
				    	  int nm=Integer.parseInt(mese);			    	  
				    	  int na=Integer.parseInt(anno);
				    	 
				    	  if ((nomeU.length()<4||nomeU.length()>20)||(p.length()<4||p.length()>20))throw new ErrorException(contenitore,"<html>I dati NomeUtente e Password devono <br>avere una lunghezza <br>da 4 a 20 caratteri!</html>");
				    	  if (n.length()>20||c.length()>20) throw new ErrorException(contenitore,"<html>I dati Nome e Cognome non devono superare i 20 caratteri!</html>");
				    	  
				    	  if ((ng<1||ng>31)||(nm<1||nm>12)||(na<1880||na>2010)) throw new ErrorException(contenitore,"Inserire data di nascita corretta!");
				    	  else if((nm==11||nm==9||nm==6||nm==4)&&(ng>30))throw new ErrorException(contenitore,"Inserire data di nascita corretta!");
				    	  else if(((nm==2)&&((na % 4)==0)&&(ng>29))||((nm==2)&&(na % 4!=0)&&(ng>28)))throw new ErrorException(contenitore,"Inserire data di nascita corretta!");
				    	  else{
				    		  String somma;
				    		  if (ng<10) giorno="0"+ng;
				    		         else giorno=""+ng;
				    		  if (nm<10) mese="0"+nm;
				    		         else mese=""+nm;
				    		  anno=""+na;
				    		  somma=giorno+"/"+mese+"/"+anno;
				    		
				    	    Account acc=new Account(nomeU,p,n,c,somma,select);
				    	
				            DBAccount d = (DBAccount)Naming.lookup(client.getUrl());  
				           
	                        boolean b=d.insertAccount(acc);
	                        
	                        if(!b){
	                        FrameMessage m=new FrameMessage(contenitore,"  Nuovo Utente Aggiunto nel Database",true);
		                    m.visualizzaFrame();}
				    	     }
				          
			              }
		                 catch (Exception e) {
				       
				          System.out.println("DataClient Error: " + e);
				          throw new ErrorException(contenitore,"Impossibile aggiungere al database");
				          }
			
				         
			}
		}
		ActionListener listenerConferma=new addActionListenerConferma();
		conferma.addActionListener(listenerConferma);
		
		JPanel intermedio3=new JPanel();
		intermedio3.setBackground(contenitore.getColore());
		intermedio3.add(data);
		intermedio3.add(gg);
		intermedio3.add(slash1);
		intermedio3.add(mm);
		intermedio3.add(slash2);
	    intermedio3.add(aaaa);
	    intermedio3.add(ruolo);
	    intermedio3.add(scelta);
		
	    JPanel intermedio4=new JPanel();
		intermedio4.setBackground(contenitore.getColore());
		intermedio4.add(conferma);
	    
		panel2.setBorder(new TitledBorder(new EtchedBorder(),"Dati Registrazione Utente"));
		panel2.setLayout(new GridLayout(4,1));
		
		panel2.add(intermedio1);
		panel2.add(intermedio2);
		panel2.add(intermedio3);
		panel2.add(intermedio4);

		//pannello Principale
		JPanel pannelloPrincipale=new JPanel();
		pannelloPrincipale.setBackground(contenitore.getColore());
		pannelloPrincipale.add(panel0);
		pannelloPrincipale.add(panel1);
		pannelloPrincipale.add(panel2);
				
		frame.add(pannelloPrincipale);
	}
	
	/**
	 * Visualizza il frame
	 */
	public void visualizzaFrame(){
		//Calcolo dimensioni adatte per posizionare al centro dello schermo
	    Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
	    double altezza=screenSize.getHeight();//ricava diemsioni dello schermo
	    double larghezza=screenSize.getWidth();
	    int larg=(int)larghezza/2-450;//calcolo diemsioni effettive e faccio cast ad int
	    int alt=(int)altezza/2-310;
	    frame.setBounds(larg,alt,900,620);//posiziona il frame al centro dello schermo
	    
		frame.setVisible(true);
		
		//per eliminare il frame dalla memoria e distruggerlo frame.dispose() 

	}


	private JFrame frame;
    private Contenitore contenitore;
    private JTextField areaNomeU;
    private JTextField areaNome;
    private JTextField areaCog;
    private JTextField areaPass;
    private JTextField gg;
    private JTextField mm;
    private JTextField aaaa;
    private JComboBox scelta;
}
