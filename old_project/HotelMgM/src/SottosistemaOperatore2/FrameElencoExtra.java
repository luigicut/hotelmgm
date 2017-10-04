package SottosistemaOperatore2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import IS.BarraMenuIS;
import IS.Contenitore;
import IS.Extra;
import IS.FramePrincipaleIS;

/**
 * Questa classe definisce un oggetto FrameElencoExtra
 * @author Daniele
 *
 */
public class FrameElencoExtra extends JFrame{
	

	static final long serialVersionUID=0;
		
	/**
	 * Costruisce la finestra frame con tutte le sue componenti 
	 * @param c Oggetto di tipo contenitore
	 * @param ArrayList<Extra> Lista degli extra 
	 */
		public FrameElencoExtra(Contenitore c,ArrayList<Extra> ext){
			
			contenitore=c;
			arrayE=ext;
			
			frame=new JFrame();
			
			frame.setSize(900,600);
			frame.setTitle("HotelMgM");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			BarraMenuIS barra=new BarraMenuIS(frame,contenitore,28);
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
			
			JLabel larea=new JLabel("                 Elenco Extra  ");
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
	int l=arrayE.size();
	
	String[] nomiColonne={"Codice","Nome","Prezzo"};
	
	String[][] celle=new String[l][3];
	
	 for(Extra ex:arrayE){
		celle[indice][0]=Integer.toString(ex.getCodice());
	    celle[indice][1]=ex.getNome();
		celle[indice][2]=Double.toString(ex.getPrezzo());
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
			
			FrameOp2 p=new FrameOp2(contenitore);
			p.visualizzaFrame();
			frame.dispose();
			
		}
	}
	ActionListener listenerHome=new addActionListenerHome();
	home.addActionListener(listenerHome);
	
	panel3.add(home);
	
	
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
	    private ArrayList<Extra> arrayE;
	    private int indice;
		
}

