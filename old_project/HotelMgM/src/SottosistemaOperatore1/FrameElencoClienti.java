package SottosistemaOperatore1;

import java.awt.Color;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import Eccezioni.ErrorException;
import IS.BarraMenuIS;
import IS.Cliente;
import IS.Contenitore;
import IS.FramePrincipaleIS;
import RMI.DBClient;
import RMI.DBCliente;

/**
 * Questa classe definisce un oggetto FrameElencoClienti
 * @author Daniele
 *
 */
public class FrameElencoClienti extends JFrame{
	

	static final long serialVersionUID=0;
		
	/**
	 * Costruisce la finestra frame con tutte le sue componenti 
	 * @param c Oggetto di tipo contenitore
	 * @param ArrayList<Cliente> lista dei clienti
	 */
		public FrameElencoClienti(Contenitore c,ArrayList<Cliente> arr){
			
			contenitore=c;
			arrayCli=arr;
			
			frame=new JFrame();
			
			frame.setSize(900,600);
			frame.setTitle("HotelMgM");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			BarraMenuIS barra=new BarraMenuIS(frame,contenitore,15);
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
			
			JLabel larea=new JLabel("                 Elenco Clienti  ");
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

	
	//panel2
	JPanel panel2=new JPanel();
	panel2.setBackground(contenitore.getColore());
	
	indice=0;
	int l=arrayCli.size();
	String[] nomiColonne={"Codice","Nome","Cognome","Data Nascita","Luogo di Nascita","Provincia"};
	
	String[][] celle=new String[l][6];
	
	 for(Cliente cli:arrayCli){
		 celle[indice][0]=Integer.toString(cli.getCodice());
		 celle[indice][1]=cli.getNome();
		 celle[indice][2]=cli.getCognome();
		 celle[indice][3]=cli.getDataNascita();
		 celle[indice][4]=cli.getLuogoNascita();
		 celle[indice][5]=cli.getProvincia();
		indice++;
	}
	
	JScrollPane barra2=new JScrollPane();
	
	JTable tabella=new JTable(celle,nomiColonne);
	tabella.setBackground(Color.WHITE);
	
	tabella.setEnabled(false);

	Dimension d=new Dimension(750,380);
	tabella.setPreferredScrollableViewportSize(d);
	
	barra2.getViewport().add(tabella);
	barra2.setBackground(contenitore.getColore());
	
	panel2.add(barra2);
	
	//panel3
	JPanel panel3=new JPanel();
	panel3.setBackground(contenitore.getColore());
	
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
	
	JLabel dettagli=new JLabel("      Per visualizzare i dettagli del cliente inserire il codice: ");
	areaDettagli=new JTextField(6);
	
	String pathAvanti="./Bottoni/Avanti_0.png";
	Image imgButtonAvanti=kit.getImage(pathAvanti);
	Icon iconaPulsanteAvanti=new ImageIcon(imgButtonAvanti);	
	JButton avanti=new JButton(iconaPulsanteAvanti);
	avanti.setBackground(contenitore.getColore());
	avanti.setFocusPainted(false); 
	avanti.setBorderPainted(false);
	avanti.setContentAreaFilled(false);
	avanti.setPressedIcon(new ImageIcon ("./Bottoni/Avanti_1.png"));

	//crea comandi bottone Avanti <----------------------
	class addActionListenerAvanti implements ActionListener
	{
		public void actionPerformed(ActionEvent event){
			
			DBClient client=contenitore.getClient();
			
			try {
			          DBCliente d = (DBCliente)Naming.lookup(client.getUrl()); 
			     
			          arrayCli2=new ArrayList<Cliente>();
			        
                      int codi=Integer.parseInt(areaDettagli.getText());
                      
			          arrayCli2=d.getDettagliCliente(codi);
			          
			          if (codi<1||arrayCli2.size()==0) throw new ErrorException(contenitore,"Codice errato! Riprovare");
			          
			         } catch (Exception e) {
			          System.out.println("DataClient Error: " + e);
			          }
			         
			FrameDettagliCliente p=new FrameDettagliCliente(contenitore,arrayCli2,frame);
			p.visualizzaFrame();
			frame.setVisible(false);
			
		}
	}
	ActionListener listenerAvanti=new addActionListenerAvanti();
	avanti.addActionListener(listenerAvanti);
	
	panel3.add(home);
	panel3.add(dettagli);
	panel3.add(areaDettagli);
	panel3.add(avanti);
	
	
	//pannello Principale
	JPanel pannelloPrincipale=new JPanel();
	pannelloPrincipale.setBackground(contenitore.getColore());
	pannelloPrincipale.add(panel0);
	pannelloPrincipale.add(panel2);
	pannelloPrincipale.add(panel3);
			
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
	    private ArrayList<Cliente> arrayCli;
	    private ArrayList<Cliente> arrayCli2;
	    private int indice;
	    private JTextField areaDettagli;
}
