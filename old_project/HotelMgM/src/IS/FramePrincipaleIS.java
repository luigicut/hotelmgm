package IS;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Questa classe definisce un oggetto FramePrincipaleIS
 * @author Daniele
 *
 */
	
public class FramePrincipaleIS extends JFrame{

	static final long serialVersionUID=0;
	
	/**
	 * Costruisce la finestra frame con tutte le sue componenti 
	 * @param c Oggetto di tipo contenitore
	 */
	
	public FramePrincipaleIS(Contenitore c){
		
		contenitore=c;
		
		frame=new JFrame();
		
		frame.setSize(900,600);
		frame.setTitle("HotelMgM");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		BarraMenuIS barra=new BarraMenuIS(frame,contenitore,1);
		frame.setJMenuBar(barra.getMenu());
		
		
		JPanel pannello=new JPanel();
		pannello.setBackground(contenitore.getColore());
		
		//Caricare un'immagine
		Toolkit kit=Toolkit.getDefaultToolkit();
		Image img=kit.getImage("./immagini/trasparente/logo300.png");
		
		//immagine Icona
		String pathIcona="./immagini/trasparente/logo25.png";
		Image imgIcona=kit.getImage(pathIcona);
		
		frame.setIconImage(imgIcona);//inserisce l'icona al titolo
		
		//immagine logo nella label
		JLabel l=new JLabel();
		Icon imIcona=new ImageIcon(img);//Crea una icona per caricare l'immagine in una label
		l.setIcon(imIcona);//Carica l'immagine in una label
		pannello.add(l);
		
		//pulsante home
		JPanel panelHome=new JPanel();
		
		
		String pathHome="./Bottoni/Entra_0.png";
		Image imgButton=kit.getImage(pathHome);
		Icon iconaPulsante=new ImageIcon(imgButton);	
		JButton home=new JButton(iconaPulsante);
		home.setBackground(contenitore.getColore());
		home.setFocusPainted(false); 
		home.setBorderPainted(false);
		home.setContentAreaFilled(false);
		home.setPressedIcon(new ImageIcon ("./Bottoni/Entra_1.png"));

		
		//crea comandi bottone HOME <----------------------
		class addActionListener implements ActionListener
		{
			public void actionPerformed(ActionEvent event){
				
				FrameLogin p=new FrameLogin(contenitore,frame);
				p.visualizzaFrame();
				//frame.dispose();
				
			}
		}
		ActionListener listener=new addActionListener();
		home.addActionListener(listener);
		
		panelHome.setBackground(contenitore.getColore());
		panelHome.add(home);
		
		
        frame.add(pannello);
        frame.add(panelHome,BorderLayout.SOUTH);
     
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
