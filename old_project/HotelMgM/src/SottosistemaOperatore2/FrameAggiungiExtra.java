package SottosistemaOperatore2;

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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import Eccezioni.ErrorException;
import IS.BarraMenuIS;
import IS.Contenitore;
import IS.Extra;
import IS.FrameMessage;
import IS.FramePrincipaleIS;
import RMI.DBExtra;
import RMI.DBClient;

/**
 * Questa classe definisce un oggetto FrameAggiungiExtra
 * @author Daniele
 *
 */
public class FrameAggiungiExtra extends JFrame{

static final long serialVersionUID=0;
	
/**
 * Costruisce la finestra frame con tutte le sue componenti 
 * @param c Oggetto di tipo contenitore
 * 
 */
	public FrameAggiungiExtra(Contenitore c){
		
		contenitore=c;
		
		frame=new JFrame();
		
		frame.setSize(900,600);
		frame.setTitle("HotelMgM");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		BarraMenuIS barra=new BarraMenuIS(frame,contenitore,26);
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
		
		JLabel larea=new JLabel("                Dati Nuovo Extra  ");
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
		
		Image img2=kit.getImage("./immagini/extra.png");
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
				
				FrameOp2 p=new FrameOp2(contenitore);
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
		
		JLabel nome=new JLabel("Nome");
		final JTextField areaNom=new JTextField(15);
	
		JLabel prezzo=new JLabel("             Prezzo");
		final JTextField areaPrezzo=new JTextField(4);
		
		JPanel intermedio1=new JPanel();
		intermedio1.setBackground(contenitore.getColore());
		intermedio1.add(nome);
		intermedio1.add(areaNom);
		intermedio1.add(prezzo);
		intermedio1.add(areaPrezzo);
		
		JPanel intermedio2=new JPanel();
		intermedio2.setBackground(contenitore.getColore());
		
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
				
				try {     
				    	  String n=areaNom.getText();
				    	  if ( (n.equals("")) ||(areaPrezzo.getText().equals(""))) throw new ErrorException(contenitore,"Riempire tutti i campi!");				    	  
				    	  double p=Double.parseDouble(areaPrezzo.getText());
				    	  if (p<=0)throw new ErrorException(contenitore,"Inserire prezzo corretto!");
				    	  if (n.length()>20)throw new ErrorException(contenitore,"Non superare la lunghezza di 20 caratteri!");
				    	 
				    	    Extra ext=new Extra(0,n,p);
				    	
				            DBExtra d = (DBExtra)Naming.lookup(client.getUrl());  
				           
	                        boolean b=d.insertExtra(ext);
	                        
	                        if(!b) 
	                        { FrameMessage m=new FrameMessage(contenitore,"  Nuovo Extra Aggiunto nel Database",true);
		                    m.visualizzaFrame();}
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
	    intermedio3.add(conferma);
		
		panel2.setBorder(new TitledBorder(new EtchedBorder(),"Dati Registrazione Extra"));
		panel2.setLayout(new GridLayout(3,1));
		
		panel2.add(intermedio2);
		panel2.add(intermedio1);
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
	
	
}

