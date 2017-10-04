package SottosistemaAmministratore;

import java.awt.Dimension;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import IS.BarraMenuIS;
import IS.Contenitore;
import IS.FramePrincipaleIS;
import SottosistemaOperatore1.FrameOp1;
import SottosistemaOperatore2.FrameOp2;

/**
 * Questa classe definisce un oggetto FrameAdmin
 * @author Daniele
 *
 */
public class FrameAdmin extends JFrame {

static final long serialVersionUID=0;
	
/**
 * Costruisce la finestra frame con tutte le sue componenti 
 * @param c Oggetto di tipo contenitore
 */
	public FrameAdmin(Contenitore c){
		
		contenitore=c;
		
		frame=new JFrame();
		
		frame.setSize(900,600);
		frame.setTitle("HotelMgM");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		BarraMenuIS barra=new BarraMenuIS(frame,contenitore,2);
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
		
		JLabel larea=new JLabel("            Area Amministratore  ");
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
		
		Image img2=kit.getImage("./immagini/User.png");
		JLabel l2=new JLabel();
		Icon imIcona2=new ImageIcon(img2);//Crea una icona per caricare l'immagine in una label
		l2.setIcon(imIcona2);//Carica l'immagine in una label
		panel1.add(l2);
		
		
		//panel2
		JPanel panel2=new JPanel();
		panel2.setBackground(contenitore.getColore());
		
		String pathControllo="./Bottoni/Pannello_0.png";
		Image imgButtonControllo=kit.getImage(pathControllo);
		Icon iconaPulsanteControllo=new ImageIcon(imgButtonControllo);	
		JButton control=new JButton(iconaPulsanteControllo);
		control.setBackground(contenitore.getColore());
		control.setFocusPainted(false); 
		control.setBorderPainted(false);
		control.setContentAreaFilled(false);
		control.setPressedIcon(new ImageIcon ("./Bottoni/Pannello_1.png"));

		//crea comandi bottone PannelloControllo <----------------------
		class addActionListener implements ActionListener
		{
			public void actionPerformed(ActionEvent event){
				
				FramePannelloControllo p=new FramePannelloControllo(contenitore);
				p.visualizzaFrame();
				frame.dispose();
				
			}
		}
		ActionListener listener=new addActionListener();
		control.addActionListener(listener);
		
		
		String pathLiv1="./Bottoni/liv1_0.png";
		Image imgButtonLiv1=kit.getImage(pathLiv1);
		Icon iconaPulsanteLiv1=new ImageIcon(imgButtonLiv1);	
		JButton liv1=new JButton(iconaPulsanteLiv1);
		liv1.setBackground(contenitore.getColore());
		liv1.setFocusPainted(false); 
		liv1.setBorderPainted(false);
		liv1.setContentAreaFilled(false);
		liv1.setPressedIcon(new ImageIcon ("./Bottoni/liv1_1.png"));
		
		//crea comandi bottone Liv1 <----------------------
		class addActionListenerLiv1 implements ActionListener
		{
			public void actionPerformed(ActionEvent event){
				
				FrameOp1 p=new FrameOp1(contenitore);
				p.visualizzaFrame();
				frame.dispose();
				
			}
		}
		ActionListener listenerLiv1=new addActionListenerLiv1();
		liv1.addActionListener(listenerLiv1);
		
		String pathLiv2="./Bottoni/liv2_0.png";
		Image imgButtonLiv2=kit.getImage(pathLiv2);
		Icon iconaPulsanteLiv2=new ImageIcon(imgButtonLiv2);	
		JButton liv2=new JButton(iconaPulsanteLiv2);
		liv2.setBackground(contenitore.getColore());
		liv2.setFocusPainted(false); 
		liv2.setBorderPainted(false);
		liv2.setContentAreaFilled(false);
		liv2.setPressedIcon(new ImageIcon ("./Bottoni/liv2_1.png"));
		
		//crea comandi bottone  Liv2<----------------------
		class addActionListenerLiv2 implements ActionListener
		{
			public void actionPerformed(ActionEvent event){
				
				FrameOp2 p=new FrameOp2(contenitore);
				p.visualizzaFrame();
				frame.dispose();
				
			}
		}
		ActionListener listenerLiv2=new addActionListenerLiv2();
		liv2.addActionListener(listenerLiv2);
		
		panel2.add(control);
		panel2.add(liv1);
		panel2.add(liv2);
		
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
