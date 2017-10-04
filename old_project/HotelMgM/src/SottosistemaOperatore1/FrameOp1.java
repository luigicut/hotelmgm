package SottosistemaOperatore1;

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

import IS.BarraMenuIS;
import IS.Camera;
import IS.Cliente;
import IS.Contenitore;
import IS.FramePrincipaleIS;
import RMI.DBCamera;
import RMI.DBClient;
import RMI.DBCliente;

/**
 * Questa classe definisce un oggetto FrameOp1
 * @author Daniele
 *
 */
public class FrameOp1 extends JFrame {

static final long serialVersionUID=1;
	
/**
 * Costruisce la finestra frame con tutte le sue componenti 
 * @param c Oggetto di tipo contenitore
 * 
 */
	public FrameOp1(Contenitore c){
		
		contenitore=c;
		
		frame=new JFrame();
		
		frame.setSize(900,600);
		frame.setTitle("HotelMgM");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		BarraMenuIS barra=new BarraMenuIS(frame,contenitore,18);
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
		
		JLabel larea=new JLabel("            Area Operatore liv.1  ");
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
		
		Image img2=kit.getImage("./immagini/User_info4.png");
		JLabel l2=new JLabel();
		Icon imIcona2=new ImageIcon(img2);//Crea una icona per caricare l'immagine in una label
		l2.setIcon(imIcona2);//Carica l'immagine in una label
		
		JLabel space0=new JLabel("                                                                  ");
		JLabel space=new JLabel("                                                                  ");
		
		panel1.add(space0);
		panel1.add(l2);
		panel1.add(space);
		
		//panel15
		JPanel panel15=new JPanel();
		panel15.setBackground(contenitore.getColore());
		
        Font font2=new Font("SansSerif",Font.PLAIN+Font.BOLD,25);//FONT per una label
		
      
		JLabel tit1=new JLabel("Operazioni Clienti:");
		tit1.setFont(font2);
		JLabel space8=new JLabel("                                                        ");
		JLabel space9=new JLabel("                                                        ");
		
		panel15.add(space8);
		panel15.add(tit1);
		panel15.add(space9);
		
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
				
				FrameAggiungiCliente p=new FrameAggiungiCliente(contenitore);
				p.visualizzaFrame();
				frame.dispose();
				
			}
		}
		ActionListener listenerAggiungi=new addActionListenerAggiungi();
		aggiungi.addActionListener(listenerAggiungi);
		
		
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
				
				FrameRicercaCliente p=new FrameRicercaCliente(contenitore,1);
				p.visualizzaFrame();
				frame.dispose();
				
			}
		}
		ActionListener listenerRicerca=new addActionListenerRicerca();
		ricerca.addActionListener(listenerRicerca);
		
		
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
				          DBCliente d = (DBCliente)Naming.lookup(client.getUrl()); 
			
				          arrayCli=new ArrayList<Cliente>();

				          arrayCli=d.getElencoCliente();

				          
				         } catch (Exception e) {
				          System.out.println("DataClient Error: " + e);
				          }

				FrameElencoClienti p=new FrameElencoClienti(contenitore,arrayCli);
				p.visualizzaFrame();
				frame.dispose();
				
			}
		}
		ActionListener listenerElenco=new addActionListenerElenco();
		elenco.addActionListener(listenerElenco);
		
		String pathFattura="./Bottoni/Fattura_0.png";
		Image imgButtonFattura=kit.getImage(pathFattura);
		Icon iconaPulsanteFattura=new ImageIcon(imgButtonFattura);	
		JButton fattura=new JButton(iconaPulsanteFattura);
		fattura.setBackground(contenitore.getColore());
		fattura.setFocusPainted(false); 
		fattura.setBorderPainted(false);
		fattura.setContentAreaFilled(false);
		fattura.setPressedIcon(new ImageIcon ("./Bottoni/Fattura_1.png"));

		//crea comandi bottone Aggiungi <----------------------
		class addActionListenerFattura implements ActionListener
		{
			public void actionPerformed(ActionEvent event){
				
				//FrameAggiungiPersone p=new FrameAggiungiPersone(contenitore);
				//p.visualizzaFrame();
				//frame.dispose();
				
			}
		}
		ActionListener listenerFattura=new addActionListenerFattura();
		fattura.addActionListener(listenerFattura);
		
		panel2.add(aggiungi);
		panel2.add(modifica);
		panel2.add(ricerca);
		panel2.add(elenco);
		panel2.add(fattura);
		
		//panel3
		JPanel panel3=new JPanel();
		panel3.setBackground(contenitore.getColore());
      
		JLabel tit2=new JLabel("Operazioni Persone Associate:");
		tit2.setFont(font2);
		
		JLabel space3=new JLabel("                                                         ");
		JLabel space4=new JLabel("                                                         ");
		
		panel3.add(space4);
		panel3.add(tit2);
		panel3.add(space3);
		
		//panel4
		JPanel panel4=new JPanel();
		panel4.setBackground(contenitore.getColore());
		
		String pathAggiungiP="./Bottoni/Aggiungi_0.png";
		Image imgButtonAggiungiP=kit.getImage(pathAggiungiP);
		Icon iconaPulsanteAggiungiP=new ImageIcon(imgButtonAggiungiP);	
		JButton aggiungiP=new JButton(iconaPulsanteAggiungiP);
		aggiungiP.setBackground(contenitore.getColore());
		aggiungiP.setFocusPainted(false); 
		aggiungiP.setBorderPainted(false);
		aggiungiP.setContentAreaFilled(false);
		aggiungiP.setPressedIcon(new ImageIcon ("./Bottoni/Aggiungi_1.png"));

		//crea comandi bottone Aggiungi <----------------------
		class addActionListenerAggiungiP implements ActionListener
		{
			public void actionPerformed(ActionEvent event){
				
				FrameRicercaCliente p=new FrameRicercaCliente(contenitore,2);
				p.visualizzaFrame();
				frame.dispose();
				
			}
		}
		ActionListener listenerAggiungiP=new addActionListenerAggiungiP();
		aggiungiP.addActionListener(listenerAggiungiP);
		
		String pathElencoP="./Bottoni/Elenco_0.png";
		Image imgButtonElencoP=kit.getImage(pathElencoP);
		Icon iconaPulsanteElencoP=new ImageIcon(imgButtonElencoP);	
		JButton elencoP=new JButton(iconaPulsanteElencoP);
		elencoP.setBackground(contenitore.getColore());
		elencoP.setFocusPainted(false); 
		elencoP.setBorderPainted(false);
		elencoP.setContentAreaFilled(false);
		elencoP.setPressedIcon(new ImageIcon ("./Bottoni/Elenco_1.png"));
		
		
		//crea comandi bottone  Elenco<----------------------
		class addActionListenerElencoP implements ActionListener
		{
			public void actionPerformed(ActionEvent event){

				FrameRicercaCliente p=new FrameRicercaCliente(contenitore,3);
				p.visualizzaFrame();
				frame.dispose();
				
			}
		}
		ActionListener listenerElencoP=new addActionListenerElencoP();
		elencoP.addActionListener(listenerElencoP);
		
		panel4.add(aggiungiP);
		panel4.add(elencoP);
		
		//panel5
		JPanel panel5=new JPanel();
		panel5.setBackground(contenitore.getColore());
      
		JLabel tit3=new JLabel("Operazioni Camere:");
		tit3.setFont(font2);
		
		JLabel space5=new JLabel("                                                          ");
		JLabel space6=new JLabel("                                                          ");
		
		panel5.add(space5);
		panel5.add(tit3);
		panel5.add(space6);
		
		//panel6
		JPanel panel6=new JPanel();
		panel6.setBackground(contenitore.getColore());
		
		String pathRicercaC="./Bottoni/Ricerca_0.png";
		Image imgButtonRicercaC=kit.getImage(pathRicercaC);
		Icon iconaPulsanteRicercaC=new ImageIcon(imgButtonRicercaC);	
		JButton ricercaC=new JButton(iconaPulsanteRicercaC);
		ricercaC.setBackground(contenitore.getColore());
		ricercaC.setFocusPainted(false); 
		ricercaC.setBorderPainted(false);
		ricercaC.setContentAreaFilled(false);
		ricercaC.setPressedIcon(new ImageIcon ("./Bottoni/Ricerca_1.png"));
		
		//crea comandi bottone  Ricerca<----------------------
		class addActionListenerRicercaC implements ActionListener
		{
			public void actionPerformed(ActionEvent event){
				
				FrameRicercaCameraOp p=new FrameRicercaCameraOp(contenitore);
				p.visualizzaFrame();
				frame.dispose();
				
			}
		}
		ActionListener listenerRicercaC=new addActionListenerRicercaC();
		ricercaC.addActionListener(listenerRicercaC);
		
		String pathElencoC="./Bottoni/Elenco_0.png";
		Image imgButtonElencoC=kit.getImage(pathElencoC);
		Icon iconaPulsanteElencoC=new ImageIcon(imgButtonElencoC);	
		JButton elencoC=new JButton(iconaPulsanteElencoC);
		elencoC.setBackground(contenitore.getColore());
		elencoC.setFocusPainted(false); 
		elencoC.setBorderPainted(false);
		elencoC.setContentAreaFilled(false);
		elencoC.setPressedIcon(new ImageIcon ("./Bottoni/Elenco_1.png"));
		
		
		//crea comandi bottone  Elenco<----------------------
		class addActionListenerElencoC implements ActionListener
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
					
				FrameElencoCamere p=new FrameElencoCamere(contenitore,arrayC);
				p.visualizzaFrame();
				frame.dispose();
				
			}
		}
		ActionListener listenerElencoC=new addActionListenerElencoC();
		elencoC.addActionListener(listenerElencoC);
		
		
		String pathPrenota="./Bottoni/Prenota_0.png";
		Image imgButtonPrenota=kit.getImage(pathPrenota);
		Icon iconaPulsantePrenota=new ImageIcon(imgButtonPrenota);	
		JButton prenota=new JButton(iconaPulsantePrenota);
		prenota.setBackground(contenitore.getColore());
		prenota.setFocusPainted(false); 
		prenota.setBorderPainted(false);
		prenota.setContentAreaFilled(false);
		prenota.setPressedIcon(new ImageIcon ("./Bottoni/Prenota_1.png"));
		
		//crea comandi bottone  Prenota<----------------------
		class addActionListenerPrenota implements ActionListener
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
				
				         
				FramePrenota p=new FramePrenota(contenitore,arrayC);
				p.visualizzaFrame();
				frame.dispose();
				
			}
		}
		ActionListener listenerPrenota=new addActionListenerPrenota();
		prenota.addActionListener(listenerPrenota);
		
		String pathOccupa="./Bottoni/Occupa_0.png";
		Image imgButtonOccupa=kit.getImage(pathOccupa);
		Icon iconaPulsanteOccupa=new ImageIcon(imgButtonOccupa);	
		JButton occupa=new JButton(iconaPulsanteOccupa);
		occupa.setBackground(contenitore.getColore());
		occupa.setFocusPainted(false); 
		occupa.setBorderPainted(false);
		occupa.setContentAreaFilled(false);
		occupa.setPressedIcon(new ImageIcon ("./Bottoni/Occupa_1.png"));
		
		//crea comandi bottone  Occupa<----------------------
		class addActionListenerOccupa implements ActionListener
		{
			public void actionPerformed(ActionEvent event){
				
                DBClient client=contenitore.getClient();
				
				try {
				          DBCamera d = (DBCamera)Naming.lookup(client.getUrl()); 
				          
				          arrayC=new ArrayList<Camera>();
				          
				          arrayC=d.getElencoCameraLibera();

				          
				         } catch (Exception e) {
				          System.out.println("DataClient Error: " + e);
				          }
	
				FrameOccupa p=new FrameOccupa(contenitore,arrayC);
				p.visualizzaFrame();
				frame.dispose();
				
			}
		}
		ActionListener listenerOccupa=new addActionListenerOccupa();
		occupa.addActionListener(listenerOccupa);
		
		String pathRilascia="./Bottoni/Rilascia_0.png";
		Image imgButtonRilascia=kit.getImage(pathRilascia);
		Icon iconaPulsanteRilascia=new ImageIcon(imgButtonRilascia);	
		JButton rilascia=new JButton(iconaPulsanteRilascia);
		rilascia.setBackground(contenitore.getColore());
		rilascia.setFocusPainted(false); 
		rilascia.setBorderPainted(false);
		rilascia.setContentAreaFilled(false);
		rilascia.setPressedIcon(new ImageIcon ("./Bottoni/Rilascia_1.png"));
		
		//crea comandi bottone  Rilascia<----------------------
		class addActionListenerRilascia implements ActionListener
		{
			public void actionPerformed(ActionEvent event){
				
                DBClient client=contenitore.getClient();
				
				try {
				          DBCamera d = (DBCamera)Naming.lookup(client.getUrl()); 
				          
				          arrayC=new ArrayList<Camera>();
				          
				          arrayC=d.getElencoCameraOccupata();

				          
				         } catch (Exception e) {
				          System.out.println("DataClient Error: " + e);
				          }
	
				FrameRilascia p=new FrameRilascia(contenitore,arrayC);
				p.visualizzaFrame();
				frame.dispose();
				
			}
		}
		ActionListener listenerRilascia=new addActionListenerRilascia();
		rilascia.addActionListener(listenerRilascia);
		
		panel6.add(ricercaC);
		panel6.add(elencoC);
		panel6.add(prenota);
		panel6.add(occupa);
		panel6.add(rilascia);
		
		//pannello Principale
		JPanel pannelloPrincipale=new JPanel();
		pannelloPrincipale.setBackground(contenitore.getColore());
		pannelloPrincipale.add(panel0);
		pannelloPrincipale.add(panel1);
		pannelloPrincipale.add(panel15);
		pannelloPrincipale.add(panel2);
		pannelloPrincipale.add(panel3);
		pannelloPrincipale.add(panel4);
		pannelloPrincipale.add(panel5);
		pannelloPrincipale.add(panel6);
				
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
    private ArrayList<Camera> arrayC;
    private ArrayList<Cliente> arrayCli;
}


