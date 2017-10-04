package SottosistemaOperatore1;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import Eccezioni.ErrorException;
import IS.BarraMenuIS;
import IS.Cliente;
import IS.Contenitore;
import IS.FramePrincipaleIS;
import RMI.DBClient;
import RMI.DBCliente;

/**
 * Questa classe definisce un oggetto FrameRicercaCliente
 * @author Daniele
 *
 */
public class FrameRicercaCliente extends JFrame{

static final long serialVersionUID=0;
	
/**
 * Costruisce la finestra frame con tutte le sue componenti 
 * @param c Oggetto di tipo contenitore
 * @param param Un parametro per decidere il percorso tra frame
 */
	public FrameRicercaCliente(Contenitore c,int param){
		
		contenitore=c;
		parametro=param;
		
		frame=new JFrame();
		
		frame.setSize(900,600);
		frame.setTitle("HotelMgM");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		BarraMenuIS barra=new BarraMenuIS(frame,contenitore,21);
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
		
		JLabel larea=new JLabel("               Area Ricerca Cliente  ");
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
		
		Image img2=kit.getImage("./immagini/ricerca.png");
		JLabel l2=new JLabel();
		Icon imIcona2=new ImageIcon(img2);//Crea una icona per caricare l'immagine in una label
		l2.setIcon(imIcona2);//Carica l'immagine in una label
		
		JLabel space0=new JLabel("                                      ");
		JLabel space1=new JLabel("                                      ");
		
		
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
				
				FrameOp1 p=new FrameOp1(contenitore);
				p.visualizzaFrame();
				frame.dispose();
				
			}
		}
		ActionListener listenerHome=new addActionListenerHome();
		home.addActionListener(listenerHome);
		

		panel1.add(space0);
		panel1.add(l2);
		panel1.add(space1);
		panel1.add(home);
		
		//panel2
		JPanel panel2=new JPanel();
		panel2.setBackground(contenitore.getColore());
		
		JLabel nome=new JLabel("Nome ");
		areaNome=new JTextField(15);
	
		JLabel cog=new JLabel("            Cognome ");
		areaCog=new JTextField(15);
		
		JPanel intermedio1=new JPanel();
		intermedio1.setBackground(contenitore.getColore());
		intermedio1.add(nome);
		intermedio1.add(areaNome);
		intermedio1.add(cog);
		intermedio1.add(areaCog);

		
		JLabel data=new JLabel("Data di Nascita ");
		ggI=new JTextField(2);
		JLabel slash1=new JLabel("/");
		mmI=new JTextField(2);
		JLabel slash2=new JLabel("/");
		aaaaI=new JTextField(4);
		
		
		String pathRicerca="./Bottoni/Ricerca_0.png";
		Image imgButtonRicerca=kit.getImage(pathRicerca);
		Icon iconaPulsanteRicerca=new ImageIcon(imgButtonRicerca);	
		JButton ricerca=new JButton(iconaPulsanteRicerca);
		ricerca.setBackground(contenitore.getColore());
		ricerca.setFocusPainted(false); 
		ricerca.setBorderPainted(false);
		ricerca.setContentAreaFilled(false);
		ricerca.setPressedIcon(new ImageIcon ("./Bottoni/Ricerca_1.png"));
		
		//crea comandi bottone  Ricerca<----------------------
		class addActionListenerRicerca implements ActionListener
		{
			public void actionPerformed(ActionEvent event){
				
				 DBClient client=contenitore.getClient();
		            
						try {     
						          DBCliente d = (DBCliente)Naming.lookup(client.getUrl()); 
						          
						          String n1=areaNome.getText();
						          String n2=areaCog.getText();
				
						          String sommaI;
						         
						          String giornoI=ggI.getText();	    	  
						    	  String meseI=mmI.getText();
						    	  String annoI=aaaaI.getText();
						    	  
						    	  if ((n1.length()>20)||(n2.length()>20))throw new ErrorException(contenitore,"Non superare la lunghezza di 20 caratteri!");
						    	  if ((n1.equals(""))&&(n2.equals(""))&&(giornoI.equals(""))&&(meseI.equals(""))&&(annoI.equals("")))throw new ErrorException(contenitore,"Riempire tutti i campi!");
					
						    	  
						    	  if (giornoI.equals("")||meseI.equals("")||annoI.equals(""))  sommaI=" ";
						    	  else{
						    	  int ngI=Integer.parseInt(giornoI);
						    	  int nmI=Integer.parseInt(meseI);
						    	  int naI=Integer.parseInt(annoI);
						    	  
						    	  if ((ngI<1||ngI>31)||(nmI<1||nmI>12)||(naI<1880||naI>2010)) throw new ErrorException(contenitore,"Inserire data di nascita corretta!");
						    	  else if((nmI==11||nmI==9||nmI==6||nmI==4)&&(ngI>30))throw new ErrorException(contenitore,"Inserire data di nascita corretta!");
						    	  else if(((nmI==2)&&((naI % 4)==0)&&(ngI>29))||((nmI==2)&&(naI % 4!=0)&&(ngI>28)))throw new ErrorException(contenitore,"Inserire data di nascita corretta!");
						    	  else{
						    		  if (ngI<10) giornoI="0"+ngI;
						    		         else giornoI=""+ngI;
						    		  if (nmI<10) meseI="0"+nmI;
						    		         else meseI=""+nmI;
						    		  annoI=""+naI;
						    		  sommaI=giornoI+"/"+meseI+"/"+annoI;
						    		  }		          
                               }
						          if (n1.equals("")) n1=" ";
						          if (n2.equals("")) n2=" ";

						    		  
						          arrayCli=new ArrayList<Cliente>();	
						          
						          arrayCli=d.getRicercaCliente(n1,n2,sommaI);					          
						         } 

						    	  catch (Exception e) {
						          System.out.println("DataClient Error: " + e);
						          }
						
			if (arrayCli.isEmpty()) throw new ErrorException(contenitore,"Nessun elemento trovato");
			else{
				if (parametro==1)  {FrameRisultatiRicercaCliente p=new FrameRisultatiRicercaCliente(contenitore,arrayCli);p.visualizzaFrame();}
				else if (parametro==2){FrameRisultatiAggiungiCliente p=new FrameRisultatiAggiungiCliente(contenitore,arrayCli);p.visualizzaFrame();}
				      else{FrameRisultatiElencoClientePersone p=new FrameRisultatiElencoClientePersone(contenitore,arrayCli);p.visualizzaFrame();}
				frame.dispose();
						
					}
				

				
			}
		}
		ActionListener listenerRicerca=new addActionListenerRicerca();
		ricerca.addActionListener(listenerRicerca);
		
		JPanel intermedio3=new JPanel();
		intermedio3.setBackground(contenitore.getColore());
		intermedio3.add(data);
		intermedio3.add(ggI);
		intermedio3.add(slash1);
		intermedio3.add(mmI);
		intermedio3.add(slash2);
	    intermedio3.add(aaaaI);

		
		panel2.setBorder(new TitledBorder(new EtchedBorder(),"Dati Ricerca Cliente"));
		panel2.setLayout(new GridLayout(3,1));
		
		panel2.add(intermedio1);
		panel2.add(intermedio3);
		panel2.add(ricerca);

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
    private JTextField areaNome;
    private JTextField areaCog;
    private JTextField ggI;
    private JTextField mmI;
    private JTextField aaaaI;
    private ArrayList<Cliente> arrayCli;
    private int parametro;
	
}
