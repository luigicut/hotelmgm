package IS;

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

/**
 * Questa classe definisce un oggetto FrameMessage
 * @author Daniele
 *
 */

public class FrameMessage extends JFrame{
	
		static final long serialVersionUID=0;
		
		/**
		 * Costruisce la finestra frame con tutte le sue componenti 
		 * @param c Oggetto di tipo contenitore
		 * @param mes Messaggio da visualizzare 
		 * @param b Parametro che indica se il frame è un messaggio di errore o un avviso
		 */

	public FrameMessage(Contenitore c,String mes,Boolean b) {
			
		    contenitore=c;	
		    state=b;
			frame=new JFrame();
			
			frame.setSize(550,226);
			frame.setTitle("Message HotelMgM");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setBackground(contenitore.getColore());
			
			Toolkit kit=Toolkit.getDefaultToolkit();//Per eseguire metodi relativi a immagini
			
			//immagine Icona
			String pathIcona="./immagini/trasparente/logo25.png";
			Image imgIcona=kit.getImage(pathIcona);
			
			frame.setIconImage(imgIcona);//inserisce l'icona al titolo
			
			String pathImg="";
			if (state) pathImg="./immagini/true.png";
			      else pathImg="./immagini/false.png";			
			Image img=kit.getImage(pathImg);
			Icon iconaImg=new ImageIcon(img);
			JLabel imgn=new JLabel(iconaImg);
			
			Font font=new Font("",Font.BOLD,16);//FONT per una label
			JLabel label=new JLabel(mes);
			label.setFont(font);
			
			String pathOk="./Bottoni/OK_0.png";
			Image imgButtonOk=kit.getImage(pathOk);
			Icon iconaOk=new ImageIcon(imgButtonOk);	
			JButton ok=new JButton(iconaOk);
			ok.setBackground(contenitore.getColore());
			ok.setFocusPainted(false); 
			ok.setBorderPainted(false);
			ok.setContentAreaFilled(false);
			ok.setPressedIcon(new ImageIcon ("./Bottoni/OK_1.png"));
			
			//crea comandi bottone Ok <----------------------
			class addActionListenerOk implements ActionListener
			{
				public void actionPerformed(ActionEvent event){
					
					frame.dispose();
					
				}
			}
			ActionListener listenerOk=new addActionListenerOk();
			ok.addActionListener(listenerOk);
	        
			JPanel pannelloPrincipale=new JPanel();
			pannelloPrincipale.setBackground(contenitore.getColore());
			pannelloPrincipale.add(imgn);
			pannelloPrincipale.add(label);
			pannelloPrincipale.add(ok);
					
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
	        int larg=(int)larghezza/2-275;//calcolo diemsioni effettive e faccio cast ad int
	        int alt=(int)altezza/2-113;
	        frame.setBounds(larg,alt,550,226);//posiziona il frame al centro dello schermo
	        
			frame.setVisible(true);
			
			//per eliminare il frame dalla memoria e distruggerlo frame.dispose() 

	    }
	    
	    public void eliminaFrame(){
	    	frame.dispose();
	    }
	    
	    private JFrame frame;
	    private Contenitore contenitore;
	    private boolean state;

}



