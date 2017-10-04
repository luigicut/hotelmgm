package SottosistemaOperatore1;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import Eccezioni.ErrorException;
import IS.BarraMenuIS;
import IS.Camera;
import IS.Contenitore;
import IS.FramePrincipaleIS;
import RMI.DBCamera;
import RMI.DBClient;

/**
 * Questa classe definisce un oggetto FrameRicercaCameraOp
 * @author Daniele
 *
 */
public class FrameRicercaCameraOp extends JFrame{

static final long serialVersionUID=0;
	
/**
 * Costruisce la finestra frame con tutte le sue componenti 
 * @param c Oggetto di tipo contenitore
 * 
 */
	public FrameRicercaCameraOp(Contenitore c){
		
		contenitore=c;
		
		frame=new JFrame();
		
		frame.setSize(900,600);
		frame.setTitle("HotelMgM");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		BarraMenuIS barra=new BarraMenuIS(frame,contenitore,20);
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
		
		JLabel larea=new JLabel("               Area Ricerca Camera  ");
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
		
		Image img2=kit.getImage("./immagini/ricerca.png");
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
		
		JLabel num=new JLabel(" Numero ");
		areaNum=new JTextField(4);
	
		JLabel piano=new JLabel("      Piano ");
		areaPiano=new JTextField(4);
		
		JLabel letti=new JLabel("      Numero Letti");
		areaLetti=new JTextField(4);
	
		JLabel tipo=new JLabel("      Tipo ");
		scelta=new JComboBox();
		scelta.addItem(" -- ");
		scelta.addItem("Singola");
		scelta.addItem("Doppia");
		scelta.addItem("Matrimoniale");
		scelta.addItem("Tripla");
		scelta.addItem("Quadrupla");
		scelta.addItem("Multipla");
		scelta.addItem("Suite");
		
		JPanel intermedio1=new JPanel();
		intermedio1.setBackground(contenitore.getColore());
		intermedio1.add(num);
		intermedio1.add(areaNum);
		intermedio1.add(piano);
		intermedio1.add(areaPiano);
		intermedio1.add(letti);
		intermedio1.add(areaLetti);
		intermedio1.add(tipo);
		intermedio1.add(scelta);
		
			
		JLabel data=new JLabel("Data di inizio ");
		ggI=new JTextField(2);
		JLabel slash1=new JLabel("/");
		mmI=new JTextField(2);
		JLabel slash2=new JLabel("/");
		aaaaI=new JTextField(4);
		
		JLabel dataF=new JLabel("              Data di fine ");
		ggF=new JTextField(2);
		JLabel slash3=new JLabel("/");
		mmF=new JTextField(2);
		JLabel slash4=new JLabel("/");
		aaaaF=new JTextField(4);
		
		JPanel intermedio2=new JPanel();
		intermedio2.setBackground(contenitore.getColore());
		intermedio2.add(data);
		intermedio2.add(ggI);
		intermedio2.add(slash1);
		intermedio2.add(mmI);
		intermedio2.add(slash2);
		intermedio2.add(aaaaI);
		intermedio2.add(dataF);
		intermedio2.add(ggF);
		intermedio2.add(slash3);
		intermedio2.add(mmF);
		intermedio2.add(slash4);
		intermedio2.add(aaaaF);

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
				

				DBClient client=contenitore.getClient();
		            
					try {     
					          DBCamera d = (DBCamera)Naming.lookup(client.getUrl()); 
					          
					          String sommaF="";
					          String sommaI="";
					          
					          String n1=areaNum.getText();
					          String n2=areaPiano.getText();
					          String n3=areaLetti.getText();
					          String n4=(String)scelta.getSelectedItem();
					          
					          String giornoI=ggI.getText();
					          String annoI=aaaaI.getText();
					          String meseI=mmI.getText();
					          
					          if(giornoI.equals("")||meseI.equals("")||annoI.equals("")) throw new ErrorException(contenitore,"Inserire i valori della data!");
						      else{
					    	  int ngI=Integer.parseInt(giornoI);
					    	  int nmI=Integer.parseInt(meseI);
					    	  int naI=Integer.parseInt(annoI);
					    	  					    						    	  
					    	  if ((ngI<1||ngI>31)||(nmI<1||nmI>12)||(naI<1880||naI>2020)) throw new ErrorException(contenitore,"Inserire data corretta!");
					    	  else if((nmI==11||nmI==9||nmI==6||nmI==4)&&(ngI>30))throw new ErrorException(contenitore,"Inserire data corretta!");
					    	  else if(((nmI==2)&&((naI % 4)==0)&&(ngI>29))||((nmI==2)&&(naI % 4!=0)&&(ngI>28)))throw new ErrorException(contenitore,"Inserire data corretta!");
					    	  else{
					    		  if (ngI<10) giornoI="0"+ngI;
					    		         else giornoI=""+ngI;
					    		  if (nmI<10) meseI="0"+nmI;
					    		         else meseI=""+nmI;
					    		  annoI=""+naI;
					    		  sommaI=giornoI+"/"+meseI+"/"+annoI;
					    		}
					          }
					    	  
					    	  String giornoF=ggF.getText();
					    	  String meseF=mmF.getText();
					    	  String annoF=aaaaF.getText();
					    	  
					    	  if(giornoF.equals("")||meseF.equals("")||annoF.equals("")) throw new ErrorException(contenitore,"Inserire i valori della data!");
						      else{
					    	  int ngF=Integer.parseInt(giornoF);
					    	  int nmF=Integer.parseInt(meseF);
					    	  int naF=Integer.parseInt(annoF);
					    	  					    	  
					    	  if ((ngF<1||ngF>31)||(nmF<1||nmF>12)||(naF<1880||naF>2020)) throw new ErrorException(contenitore,"Inserire data corretta!");
					    	  else if((nmF==11||nmF==9||nmF==6||nmF==4)&&(ngF>30))throw new ErrorException(contenitore,"Inserire data corretta!");
					    	  else if(((nmF==2)&&((naF % 4)==0)&&(ngF>29))||((nmF==2)&&(naF % 4!=0)&&(ngF>28)))throw new ErrorException(contenitore,"Inserire data corretta!");
					    	  else{
					       		  if (ngF<10) giornoF="0"+ngF;
					    		         else giornoF=""+ngF;
					    		  if (nmF<10) meseF="0"+nmF;
					    		         else meseF=""+nmF;
					    		  annoF=""+naF;
					    		  sommaF=giornoF+"/"+meseF+"/"+annoF;
					    		 } 
					    	  }
					    	  
					    	  int ggI=Integer.parseInt(sommaI.substring(0,2));
							   int mmI=Integer.parseInt(sommaI.substring(3,5));
							   int aaI=Integer.parseInt(sommaI.substring(6,10));
							   GregorianCalendar dataI=new GregorianCalendar(aaI,mmI-1,ggI);
							    	  		
							   int ggF=Integer.parseInt(sommaF.substring(0,2));
							   int mmF=Integer.parseInt(sommaF.substring(3,5));
							   int aaF=Integer.parseInt(sommaF.substring(6,10));
							   GregorianCalendar dataF=new GregorianCalendar(aaF,mmF-1,ggF); 
							   
							   GregorianCalendar a=new GregorianCalendar(); 
							   GregorianCalendar attuale=new GregorianCalendar(a.get(Calendar.YEAR),a.get(Calendar.MONTH),a.get(Calendar.DAY_OF_MONTH));
							   
							   if (attuale.after(dataI))throw new ErrorException(contenitore,"La data di inizio PRECEDE la data di attuale!");
                               if (dataI.after(dataF))throw new ErrorException(contenitore,"La data di fine PRECEDE la data di inizio!");
					  
					    	  if (n1.equals("")&&n2.equals("")&&n3.equals("")&&n4.equals(" -- "))  throw new ErrorException(contenitore,"Inserire i valori!");
					    	  else{
					    		  int numero;
					    		  if (n1.equals("")) numero=0;
					    		                else numero=Integer.parseInt(n1);
					    		  
					    		  int piano;
					    		  if (n2.equals("")) piano=0;
					    		                else piano=Integer.parseInt(n2);
					    		  
					    		  int numLetti;
					    		  if (n3.equals("")) numLetti=0;
					    		                else numLetti=Integer.parseInt(n3);
					    		  
					    		  if  (n4.equals(" -- "))  n4="";
					    		  
					    		  if ((numero<0)||(piano<0)||(numLetti<0))throw new ErrorException(contenitore,"Inserire valori positivi!");
						    	 
					          arrayCamera=new ArrayList<Camera>();	
					          
					          arrayCamera=d.getRicercaDisponibilitaCamera(numero,piano,n4,numLetti,sommaI,sommaF);					          
					         } 
					     }
					   catch (Exception e) {
					   System.out.println("DataClient Error: " + e);
					  }
					
		if (arrayCamera.isEmpty()) throw new ErrorException(contenitore,"Nessun elemento trovato");
		else{
			FrameRisultatiRicercaCameraOp p=new FrameRisultatiRicercaCameraOp(contenitore,arrayCamera);
			p.visualizzaFrame();
			frame.dispose();
		     }		
		    }
		}
		ActionListener listenerRicerca=new addActionListenerRicerca();
		ricerca.addActionListener(listenerRicerca);
		
		JPanel intermedio3=new JPanel();
		intermedio3.setBackground(contenitore.getColore());
	    intermedio3.add(ricerca);
		
		panel2.setBorder(new TitledBorder(new EtchedBorder(),"Dati Ricerca Camera"));
		panel2.setLayout(new GridLayout(3,1));
		
		panel2.add(intermedio1);
		panel2.add(intermedio2);
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
	private JComboBox scelta;
	private JTextField ggI;
	private JTextField mmI;
	private JTextField aaaaI;
	private JTextField ggF;
	private JTextField mmF;
	private JTextField aaaaF;
	private JTextField areaNum;
	private JTextField areaPiano;
	private JTextField areaLetti;
	private ArrayList<Camera> arrayCamera;
}


