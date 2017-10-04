package SottosistemaAmministratore;

import java.awt.Dimension;
import java.awt.Font;
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

import IS.Account;
import IS.BarraMenuIS;
import IS.Camera;
import IS.Contenitore;
import IS.FramePrincipaleIS;
import RMI.DBAccount;
import RMI.DBCamera;
import RMI.DBClient;

/**
 * Questa classe definisce un oggetto FramePannelloControllo
 * @author Daniele
 *
 */
public class FramePannelloControllo extends JFrame {

static final long serialVersionUID=0;
	
/**
 * Costruisce la finestra frame con tutte le sue componenti 
 * @param c Oggetto di tipo contenitore
 * 
 */
	public FramePannelloControllo(Contenitore c){
		
		contenitore=c;
		
		frame=new JFrame();
		
		frame.setSize(900,600);
		frame.setTitle("HotelMgM");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		BarraMenuIS barra=new BarraMenuIS(frame,contenitore,7);
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
		
		JLabel larea=new JLabel("            Pannello di Controllo  ");
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
		
		panel0.add(imm3);
		panel0.add(larea);
		panel0.add(esci);
		
		//panel1
		JPanel panel1=new JPanel();
		panel1.setBackground(contenitore.getColore());
		
		Image img2=kit.getImage("./immagini/pannello_controllo.png");
		JLabel l2=new JLabel();
		Icon imIcona2=new ImageIcon(img2);//Crea una icona per caricare l'immagine in una label
		l2.setIcon(imIcona2);//Carica l'immagine in una label
		
		JLabel space0=new JLabel("                                                                  ");
		JLabel space=new JLabel("                                           ");

		
		String pathHome="./Bottoni/Home_0.png";
		Image imgButtonHome=kit.getImage(pathHome);
		Icon iconaPulsanteHome=new ImageIcon(imgButtonHome);	
		JButton home=new JButton(iconaPulsanteHome);
		home.setBackground(contenitore.getColore());
		home.setFocusPainted(false); 
		home.setBorderPainted(false);
		home.setContentAreaFilled(false);
		home.setPressedIcon(new ImageIcon ("./Bottoni/Home_1.png"));

		//crea comandi bottone Aggiungi <----------------------
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
		
		
		panel1.add(space0);
		panel1.add(l2);
		panel1.add(space);
		panel1.add(home);
		
		//panel15
		JPanel panel15=new JPanel();
		panel15.setBackground(contenitore.getColore());
		
        Font font2=new Font("SansSerif",Font.PLAIN+Font.BOLD,25);//FONT per una label
		
      
		JLabel tit1=new JLabel("Operazioni Camere:");
		tit1.setFont(font2);
		
		JLabel space3=new JLabel("                                            ");
		JLabel space4=new JLabel("                                            ");
		
		panel15.add(space3);
		panel15.add(tit1);
		panel15.add(space4);
		
		
		//panel2
		JPanel panel2=new JPanel();
		panel2.setBackground(contenitore.getColore());
		
		
		String pathAggiungi="./Bottoni/Aggiungi_0.png";
		Image imgButtonAggiungi=kit.getImage(pathAggiungi);
		Icon iconaPulsanteAggiungi=new ImageIcon(imgButtonAggiungi);	
		JButton aggiungi=new JButton(iconaPulsanteAggiungi);
		aggiungi.setBackground(contenitore.getColore());
		aggiungi.setFocusPainted(false); 
		aggiungi.setBorderPainted(false);
		aggiungi.setContentAreaFilled(false);
		aggiungi.setPressedIcon(new ImageIcon ("./Bottoni/Aggiungi_1.png"));

		//crea comandi bottone Aggiungi <----------------------
		class addActionListenerAggiungi implements ActionListener
		{
			public void actionPerformed(ActionEvent event){
				
				FrameAggiungiCamera p=new FrameAggiungiCamera(contenitore);
				p.visualizzaFrame();
				frame.dispose();
				
			}
		}
		ActionListener listenerAggiungi=new addActionListenerAggiungi();
		aggiungi.addActionListener(listenerAggiungi);
		
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
				
				FrameRicercaCamera p=new FrameRicercaCamera(contenitore);
				p.visualizzaFrame();
				frame.dispose();
				
			}
		}
		ActionListener listenerRicerca=new addActionListenerRicerca();
		ricerca.addActionListener(listenerRicerca);
		
		
		String pathModifica="./Bottoni/Modifica_0.png";
		Image imgButtonModifica=kit.getImage(pathModifica);
		Icon iconaPulsanteModifica=new ImageIcon(imgButtonModifica);	
		JButton modifica=new JButton(iconaPulsanteModifica);
		modifica.setBackground(contenitore.getColore());
		modifica.setFocusPainted(false); 
		modifica.setBorderPainted(false);
		modifica.setContentAreaFilled(false);
		modifica.setPressedIcon(new ImageIcon ("./Bottoni/Modifica_1.png"));
		
		//crea comandi bottone Modifica <----------------------
		class addActionListenerModifica implements ActionListener
		{
			public void actionPerformed(ActionEvent event){
				
				//FrameLogin p=new FrameLogin(contenitore);
				//p.visualizzaFrame();
				//frame.dispose();
				
			}
		}
		ActionListener listenerModifica=new addActionListenerModifica();
		modifica.addActionListener(listenerModifica);
		
		
		String pathCancella="./Bottoni/Cancella_0.png";
		Image imgButtonCancella=kit.getImage(pathCancella);
		Icon iconaPulsanteCancella=new ImageIcon(imgButtonCancella);	
		JButton cancella=new JButton(iconaPulsanteCancella);
		cancella.setBackground(contenitore.getColore());
		cancella.setFocusPainted(false); 
		cancella.setBorderPainted(false);
		cancella.setContentAreaFilled(false);
		cancella.setPressedIcon(new ImageIcon ("./Bottoni/Cancella_1.png"));
		
		//crea comandi bottone  Cancella<----------------------
		class addActionListenerCancella implements ActionListener
		{
			public void actionPerformed(ActionEvent event){
				
				//FrameLogin p=new FrameLogin(contenitore);
				//p.visualizzaFrame();
				//frame.dispose();
				
			}
		}
		ActionListener listenerCancella=new addActionListenerCancella();
		cancella.addActionListener(listenerCancella);
		
		
		
		String pathElenco="./Bottoni/Elenco_0.png";
		Image imgButtonElenco=kit.getImage(pathElenco);
		Icon iconaPulsanteElenco=new ImageIcon(imgButtonElenco);	
		JButton elenco=new JButton(iconaPulsanteElenco);
		elenco.setBackground(contenitore.getColore());
		elenco.setFocusPainted(false); 
		elenco.setBorderPainted(false);
		elenco.setContentAreaFilled(false);
		elenco.setPressedIcon(new ImageIcon ("./Bottoni/Elenco_1.png"));
		
		
		//crea comandi bottone  Elenco<----------------------
		class addActionListenerElenco implements ActionListener
		{
			public void actionPerformed(ActionEvent event){
				     
            DBClient client=contenitore.getClient();
				
				try {
				          DBCamera d = (DBCamera)Naming.lookup(client.getUrl()); 
				          
				          arrayC=new ArrayList<Camera>();
				          
				          arrayC=d.getElencoCamera();

				          
				         } catch (Exception e) {
				          System.out.println("DataClient Error: " + e);
				          }
				
				FrameElencoCamera p=new FrameElencoCamera(contenitore,arrayC);
				p.visualizzaFrame();
				frame.dispose();
				
			}
		}
		ActionListener listenerElenco=new addActionListenerElenco();
		elenco.addActionListener(listenerElenco);
		
		
		panel2.add(aggiungi);
		panel2.add(ricerca);
		panel2.add(modifica);
		panel2.add(cancella);
		panel2.add(elenco);
		
		
		//panel3
		JPanel panel3=new JPanel();
		panel3.setBackground(contenitore.getColore());
      
		JLabel tit2=new JLabel("Operazioni Utenti Sistema:");
		tit2.setFont(font2);
		
		JLabel space5=new JLabel("                                            ");
		JLabel space6=new JLabel("                                            ");
		
		panel3.add(space5);
		panel3.add(tit2);
		panel3.add(space6);
		
		//panel4
		JPanel panel4=new JPanel();
		panel4.setBackground(contenitore.getColore());
		
		String pathAggiungiU="./Bottoni/Aggiungi_0.png";
		Image imgButtonAggiungiU=kit.getImage(pathAggiungiU);
		Icon iconaPulsanteAggiungiU=new ImageIcon(imgButtonAggiungiU);	
		JButton aggiungiU=new JButton(iconaPulsanteAggiungiU);
		aggiungiU.setBackground(contenitore.getColore());
		aggiungiU.setFocusPainted(false); 
		aggiungiU.setBorderPainted(false);
		aggiungiU.setContentAreaFilled(false);
		aggiungiU.setPressedIcon(new ImageIcon ("./Bottoni/Aggiungi_1.png"));

		//crea comandi bottone Aggiungi <----------------------
		class addActionListenerAggiungiU implements ActionListener
		{
			public void actionPerformed(ActionEvent event){
				
				FrameAggiungiUtente p=new FrameAggiungiUtente (contenitore);
				p.visualizzaFrame();
				frame.dispose();
				
			}
		}
		ActionListener listenerAggiungiU=new addActionListenerAggiungiU();
		aggiungiU.addActionListener(listenerAggiungiU);
		
		String pathRicercaU="./Bottoni/Ricerca_0.png";
		Image imgButtonRicercaU=kit.getImage(pathRicercaU);
		Icon iconaPulsanteRicercaU=new ImageIcon(imgButtonRicercaU);	
		JButton ricercaU=new JButton(iconaPulsanteRicercaU);
		ricercaU.setBackground(contenitore.getColore());
		ricercaU.setFocusPainted(false); 
		ricercaU.setBorderPainted(false);
		ricercaU.setContentAreaFilled(false);
		ricercaU.setPressedIcon(new ImageIcon ("./Bottoni/Ricerca_1.png"));
		
		//crea comandi bottone  Ricerca<----------------------
		class addActionListenerRicercaU implements ActionListener
		{
			public void actionPerformed(ActionEvent event){
				
				FrameRicercaUtente p=new FrameRicercaUtente(contenitore);
				p.visualizzaFrame();
				frame.dispose();
				
			}
		}
		ActionListener listenerRicercaU=new addActionListenerRicercaU();
		ricercaU.addActionListener(listenerRicercaU);
		
		
		String pathModificaU="./Bottoni/Modifica_0.png";
		Image imgButtonModificaU=kit.getImage(pathModificaU);
		Icon iconaPulsanteModificaU=new ImageIcon(imgButtonModificaU);	
		JButton modificaU=new JButton(iconaPulsanteModificaU);
		modificaU.setBackground(contenitore.getColore());
		modificaU.setFocusPainted(false); 
		modificaU.setBorderPainted(false);
		modificaU.setContentAreaFilled(false);
		modificaU.setPressedIcon(new ImageIcon ("./Bottoni/Modifica_1.png"));
		
		//crea comandi bottone Modifica <----------------------
		class addActionListenerModificaU implements ActionListener
		{
			public void actionPerformed(ActionEvent event){
				
				//FrameLogin p=new FrameLogin(contenitore);
				//p.visualizzaFrame();
				//frame.dispose();
				
			}
		}
		ActionListener listenerModificaU=new addActionListenerModificaU();
		modificaU.addActionListener(listenerModificaU);
		
		
		String pathCancellaU="./Bottoni/Cancella_0.png";
		Image imgButtonCancellaU=kit.getImage(pathCancellaU);
		Icon iconaPulsanteCancellaU=new ImageIcon(imgButtonCancellaU);	
		JButton cancellaU=new JButton(iconaPulsanteCancellaU);
		cancellaU.setBackground(contenitore.getColore());
		cancellaU.setFocusPainted(false); 
		cancellaU.setBorderPainted(false);
		cancellaU.setContentAreaFilled(false);
		cancellaU.setPressedIcon(new ImageIcon ("./Bottoni/Cancella_1.png"));
		
		//crea comandi bottone  Cancella<----------------------
		class addActionListenerCancellaU implements ActionListener
		{
			public void actionPerformed(ActionEvent event){
				
				//FrameLogin p=new FrameLogin(contenitore);
				//p.visualizzaFrame();
				//frame.dispose();
				
			}
		}
		ActionListener listenerCancellaU=new addActionListenerCancellaU();
		cancellaU.addActionListener(listenerCancellaU);
		
		
		
		String pathElencoU="./Bottoni/Elenco_0.png";
		Image imgButtonElencoU=kit.getImage(pathElencoU);
		Icon iconaPulsanteElencoU=new ImageIcon(imgButtonElencoU);	
		JButton elencoU=new JButton(iconaPulsanteElencoU);
		elencoU.setBackground(contenitore.getColore());
		elencoU.setFocusPainted(false); 
		elencoU.setBorderPainted(false);
		elencoU.setContentAreaFilled(false);
		elencoU.setPressedIcon(new ImageIcon ("./Bottoni/Elenco_1.png"));
		
		
		//crea comandi bottone  Elenco<----------------------
		class addActionListenerElencoU implements ActionListener
		{
			public void actionPerformed(ActionEvent event){  
				
				DBClient client=contenitore.getClient();
				
				try {
				          DBAccount d = (DBAccount)Naming.lookup(client.getUrl()); 
				          
				          array=new ArrayList<Account>();
				          
				          array=d.getElencoAccount();

				          
				         } catch (Exception e) {
				          System.out.println("DataClient Error: " + e);
				          }
				FrameElencoUtente p=new FrameElencoUtente(contenitore,array);
				p.visualizzaFrame();
				frame.dispose();
				
			}
		}
		ActionListener listenerElencoU=new addActionListenerElencoU();
		elencoU.addActionListener(listenerElencoU);
		
		
		panel4.add(aggiungiU);
		panel4.add(ricercaU);
		panel4.add(modificaU);
		panel4.add(cancellaU);
		panel4.add(elencoU);
		
		//pannello Principale
		JPanel pannelloPrincipale=new JPanel();
		pannelloPrincipale.setBackground(contenitore.getColore());
		pannelloPrincipale.add(panel0);
		pannelloPrincipale.add(panel1);
		pannelloPrincipale.add(panel15);
		pannelloPrincipale.add(panel2);
		pannelloPrincipale.add(panel3);
		pannelloPrincipale.add(panel4);
				
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
    private ArrayList<Camera> arrayC;

}


