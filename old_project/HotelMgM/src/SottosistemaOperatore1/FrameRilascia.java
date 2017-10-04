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
import java.util.Calendar;
import java.util.GregorianCalendar;

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
import IS.Camera;
import IS.Contenitore;
import IS.FrameMessage;
import IS.FramePrincipaleIS;
import RMI.DBCamera;
import RMI.DBClient;

/**
 * Questa classe definisce un oggetto FrameRilascia
 * @author Daniele
 *
 */
public class FrameRilascia extends JFrame{

static final long serialVersionUID=0;

/**
 * Costruisce la finestra frame con tutte le sue componenti 
 * @param c Oggetto di tipo contenitore
 * @param ArrayList<Camera> lista delle camere
 */
	public FrameRilascia(Contenitore c,ArrayList<Camera> arr){
		
		contenitore=c;
		arrayC=arr;
		
		frame=new JFrame();
		
		frame.setSize(900,600);
		frame.setTitle("HotelMgM");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		BarraMenuIS barra=new BarraMenuIS(frame,contenitore,22);
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
		
		JLabel larea=new JLabel("                Rilascia Camera  ");
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
		
		Image img2=kit.getImage("./immagini/rilascia.png");
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
				
				FrameOp1 p=new FrameOp1(contenitore);
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
		
		JLabel num=new JLabel("Numero della Camera ");
		areaNum=new JTextField(4);
		
		
		
		String pathRilascia="./Bottoni/Rilascia_0.png";
		Image imgButtonRilascia=kit.getImage(pathRilascia);
		Icon iconaPulsanteRilascia=new ImageIcon(imgButtonRilascia);	
		JButton rilascia=new JButton(iconaPulsanteRilascia);
		rilascia.setBackground(contenitore.getColore());
		rilascia.setFocusPainted(false); 
		rilascia.setBorderPainted(false);
		rilascia.setContentAreaFilled(false);
		rilascia.setPressedIcon(new ImageIcon ("./Bottoni/Rilascia_1.png"));

		//crea comandi bottone Rilascia <----------------------
		class addActionListenerRilascia implements ActionListener
		{
			public void actionPerformed(ActionEvent event){
				
				DBClient client=contenitore.getClient();
	            
				try {     
				       DBCamera d2 = (DBCamera)Naming.lookup(client.getUrl()); 
				       
				       if(areaNum.getText().equals("")) throw new ErrorException(contenitore,"<html>Riempire il campo numero</html>");	  
				       
				       int numCamera=Integer.parseInt(areaNum.getText());
				        boolean flag2=false;
				        	  
				        	  for(Camera cam:arrayC){
				        		  int temporaneo=cam.getNumero();
				        		  if (temporaneo==numCamera) {flag2=true;break;}
				        	  }
				        	  
				        	  if (!flag2)throw new ErrorException(contenitore,"Numero di camera non corretto!");
				        	  else{  		 					    	  
						    	  GregorianCalendar attuale=new GregorianCalendar();
						    	  int ngI=attuale.get(Calendar.DAY_OF_MONTH);
						    	  int nmI=attuale.get(Calendar.MONTH)+1;
						    	  int naI=attuale.get(Calendar.YEAR);
						    	  
						    	  String giornoI;
						    	  String meseI;
						    	  String annoI;
						    	  if (ngI<10)  giornoI="0"+ngI;
				    		         else giornoI=""+ngI;
				    		      if (nmI<10) meseI="0"+nmI;
				    		         else meseI=""+nmI;
				    		      annoI=""+naI;
				    		      String sommaI=giornoI+"/"+meseI+"/"+annoI;
				            
				    		      d2.rilasciaCamera(numCamera,sommaI);
				        	  
				    		      FrameMessage m=new FrameMessage(contenitore,"  Camera Rilasciata",true);
				  				  m.visualizzaFrame();
				        	  }
			           
				}
			 catch (Exception e) {
			     System.out.println("DataClient Error: " + e);
			}
		
			}
		}
		ActionListener listenerRilascia=new addActionListenerRilascia();
		rilascia.addActionListener(listenerRilascia);
		
		
		panel2.add(num);
		panel2.add(areaNum);
		panel2.add(rilascia);
		
		//panel3
		JPanel panel3=new JPanel();
		panel3.setBackground(contenitore.getColore());
				
		String[] nomiColonne={"Numero","Piano","Posti Letto","Tipo"};
		
		indice=0;
		int l=arrayC.size();
		
		String[][] celle=new String[l][4];
		
		 for(Camera cam:arrayC){
			celle[indice][0]=Integer.toString(cam.getNumero());
		    celle[indice][1]=Integer.toString(cam.getPiano());
			celle[indice][2]=Integer.toString(cam.getNumLetti());
			celle[indice][3]=cam.getTipo();
			indice++;
		}
		
		JScrollPane barra2=new JScrollPane();
		
		JTable tabella=new JTable(celle,nomiColonne);
		tabella.setBackground(Color.WHITE);
		
		tabella.setEnabled(false);

		Dimension d=new Dimension(750,200);
		tabella.setPreferredScrollableViewportSize(d);
		
		barra2.getViewport().add(tabella);
		barra2.setBackground(contenitore.getColore());
		
		panel3.add(barra2);
		
		//pannello Principale
		JPanel pannelloPrincipale=new JPanel();
		pannelloPrincipale.setBackground(contenitore.getColore());
		pannelloPrincipale.add(panel0);
		pannelloPrincipale.add(panel1);
		pannelloPrincipale.add(panel3);
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
    private int indice;
    private ArrayList<Camera> arrayC;
    private JTextField areaNum;
	
}	
