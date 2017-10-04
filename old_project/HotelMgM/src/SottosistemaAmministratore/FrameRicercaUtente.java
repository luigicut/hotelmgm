package SottosistemaAmministratore;

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
import IS.Account;
import IS.BarraMenuIS;
import IS.Contenitore;
import IS.FramePrincipaleIS;
import RMI.DBAccount;
import RMI.DBClient;

/**
 * Questa classe definisce un oggetto FrameRicercaUtente
 * @author Daniele
 *
 */
public class FrameRicercaUtente extends JFrame{

static final long serialVersionUID=0;
	
/**
 * Costruisce la finestra frame con tutte le sue componenti 
 * @param c Oggetto di tipo contenitore
 * 
 */
	public FrameRicercaUtente(Contenitore c){
		
		contenitore=c;
		
		frame=new JFrame();
		
		frame.setSize(900,600);
		frame.setTitle("HotelMgM");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		BarraMenuIS barra=new BarraMenuIS(frame,contenitore,9);
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
		
		JLabel larea=new JLabel("               Area Ricerca Utente  ");
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
	
		JPanel intermedio1=new JPanel();
		intermedio1.setBackground(contenitore.getColore());
		intermedio1.add(nomeUtente);
		intermedio1.add(areaNomeU);	
		
		JLabel nome=new JLabel("            Nome ");
		areaNome=new JTextField(15);
	
		JLabel cognome=new JLabel("Cognome ");
		areaCog=new JTextField(15);
		
		JPanel intermedio2=new JPanel();
		intermedio2.setBackground(contenitore.getColore());
		intermedio2.add(nome);
		intermedio2.add(areaNome);
		intermedio2.add(cognome);
		intermedio2.add(areaCog);

		
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
            boolean flag=true;
            
				try {     
				          DBAccount d = (DBAccount)Naming.lookup(client.getUrl()); 
				          
				          String n1=areaNomeU.getText();
				          String n2=areaNome.getText();
				          String n3=areaCog.getText();
				          
				         
				          if((n2.equals("")||n3.equals(""))&&n1.equals("")) {flag=false;throw new ErrorException(contenitore,"<html>Inserimento dati non corretto!<br> Inserire Nome Utente o la coppia Nome e Cognome</html>");}				         
				          if ((n2.length()>20)||(n3.length()>20))throw new ErrorException(contenitore,"<html>I dati Nome e Cognome non devono <br>superare i 20 caratteri!</html>");
				          if ((n1.length()<4&& (!n1.equals("")))||(n1.length()>20))throw new ErrorException(contenitore,"<html>Il NomeUtente deve <br>avere una lunghezza <br>da 4 a 20 caratteri!</html>");
				          
				          array=new ArrayList<Account>();	
				          array=d.getRicercaAccount(n1,n2,n3);
				          
				         } catch (Exception e) {
				          System.out.println("DataClient Error: " + e);
				          }
				
	if (array.isEmpty()&&(flag)) throw new ErrorException(contenitore,"Nessun elemento trovato");
	else{
				FrameRisultatiRicercaUtente p=new FrameRisultatiRicercaUtente(contenitore,array);
				p.visualizzaFrame();
				frame.dispose();}
				
			}
		}
		ActionListener listenerRicerca=new addActionListenerRicerca();
		ricerca.addActionListener(listenerRicerca);
		
		JPanel intermedio3=new JPanel();
		intermedio3.setBackground(contenitore.getColore());
	    intermedio3.add(ricerca);
		
		panel2.setBorder(new TitledBorder(new EtchedBorder(),"Dati Ricerca Utente"));
		panel2.setLayout(new GridLayout(3,1));
		
		panel2.add(intermedio1);
		panel2.add(intermedio2);
		panel2.add(intermedio3);

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
    private ArrayList<Account> array;
    private JTextField areaNomeU;
    private JTextField areaNome;
    private JTextField areaCog;
}
