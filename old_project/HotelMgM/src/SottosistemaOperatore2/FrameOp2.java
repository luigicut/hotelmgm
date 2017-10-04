package SottosistemaOperatore2;

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
import IS.Contenitore;
import IS.Extra;
import IS.FramePrincipaleIS;
import RMI.DBExtra;
import RMI.DBClient;

/**
 * Questa classe definisce un oggetto FrameOp2
 * @author Daniele
 *
 */
public class FrameOp2 extends JFrame {

static final long serialVersionUID=0;
	
/**
 * Costruisce la finestra frame con tutte le sue componenti 
 * @param c Oggetto di tipo contenitore
 * 
 */
	public FrameOp2(Contenitore c){
		
		contenitore=c;
		
		frame=new JFrame();
		
		frame.setSize(900,600);
		frame.setTitle("HotelMgM");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		BarraMenuIS barra=new BarraMenuIS(frame,contenitore,29);
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
		
		JLabel larea=new JLabel("            Area Operatore liv.2  ");
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
		
		Image img2=kit.getImage("./immagini/User_info.png");
		JLabel l2=new JLabel();
		Icon imIcona2=new ImageIcon(img2);//Crea una icona per caricare l'immagine in una label
		l2.setIcon(imIcona2);//Carica l'immagine in una label
		
		JLabel space0=new JLabel("                                                               ");
		JLabel space=new JLabel("                                                               ");
		
		panel1.add(space0);
		panel1.add(l2);
		panel1.add(space);
		
		//panel15
		JPanel panel15=new JPanel();
		panel15.setBackground(contenitore.getColore());
		
        Font font2=new Font("SansSerif",Font.PLAIN+Font.BOLD,25);//FONT per una label
		
      
		JLabel tit1=new JLabel("Operazioni Extra:");
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
				
				FrameAggiungiExtra p=new FrameAggiungiExtra(contenitore);
				p.visualizzaFrame();
				frame.dispose();
				
			}
		}
		ActionListener listenerAggiungi=new addActionListenerAggiungi();
		aggiungi.addActionListener(listenerAggiungi);
		
		
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
				          DBExtra d = (DBExtra)Naming.lookup(client.getUrl()); 
				          
				          array=new ArrayList<Extra>();
				          
				          array=d.getElencoExtra();
				          
				          
				         } catch (Exception e) {
				          System.out.println("DataClient Error: " + e);
				          }
				         
				         FrameElencoExtra p= new FrameElencoExtra(contenitore,array);
				         p.visualizzaFrame();
				         frame.dispose();
		
			}
		}
		ActionListener listenerElenco=new addActionListenerElenco();
		elenco.addActionListener(listenerElenco);
		
		
		String pathAssocia="./Bottoni/Associa_Extra_0.png";
		Image imgButtonAssocia=kit.getImage(pathAssocia);
		Icon iconaPulsanteAssocia=new ImageIcon(imgButtonAssocia);	
		JButton associa=new JButton(iconaPulsanteAssocia);
		associa.setBackground(contenitore.getColore());
		associa.setFocusPainted(false); 
		associa.setBorderPainted(false);
		associa.setContentAreaFilled(false);
		associa.setPressedIcon(new ImageIcon ("./Bottoni/Associa_Extra_1.png"));
		
		
		//crea comandi bottone  Associa<----------------------
		class addActionListenerAssocia implements ActionListener
		{
			public void actionPerformed(ActionEvent event){
				 DBClient client=contenitore.getClient();
					
					try {
					          DBExtra d = (DBExtra)Naming.lookup(client.getUrl()); 
					          
					          array=new ArrayList<Extra>();
					          
					          array=d.getElencoExtra();
					          
					          
					         } catch (Exception e) {
					          System.out.println("DataClient Error: " + e);
					          }
					         
					         
				FrameAssociaExtra p=new FrameAssociaExtra(contenitore,array);
				p.visualizzaFrame();
				frame.dispose();
				
			}
		}
		ActionListener listenerAssocia=new addActionListenerAssocia();
		associa.addActionListener(listenerAssocia);
		
		
		panel2.add(aggiungi);
		panel2.add(elenco);
		panel2.add(associa);
		
		//pannello Principale
		JPanel pannelloPrincipale=new JPanel();
		pannelloPrincipale.setBackground(contenitore.getColore());
		pannelloPrincipale.add(panel0);
		pannelloPrincipale.add(panel1);
		pannelloPrincipale.add(panel15);
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
    private ArrayList<Extra> array;

}


