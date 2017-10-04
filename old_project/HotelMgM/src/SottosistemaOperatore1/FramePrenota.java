package SottosistemaOperatore1;

import java.awt.Color;
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
 * Questa classe definisce un oggetto FramePrenota
 * @author Daniele
 *
 */
public class FramePrenota extends JFrame{

static final long serialVersionUID=0;
	
/**
 * Costruisce la finestra frame con tutte le sue componenti 
 * @param c Oggetto di tipo contenitore
 * @param ArrayList<Camera> lista delle camere
 */
	public FramePrenota(Contenitore c,ArrayList<Camera> arr){
		
		contenitore=c;
		arrayC=arr;
		
		frame=new JFrame();
		
		frame.setSize(900,600);
		frame.setTitle("HotelMgM");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		BarraMenuIS barra=new BarraMenuIS(frame,contenitore,19);
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
		
		JLabel larea=new JLabel("                Prenota Camera  ");
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
		
		Image img2=kit.getImage("./immagini/camera.png");
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
		JPanel panel2=new JPanel(new GridLayout(2,1));
		panel2.setBackground(contenitore.getColore());
		
		JLabel num=new JLabel("Numero della Camera ");
		areaNum=new JTextField(4);
		
		JLabel dataI=new JLabel("Data Inizio Prenotazione ");
		ggI=new JTextField(2);
		JLabel slash1=new JLabel("/");
		mmI=new JTextField(2);
		JLabel slash2=new JLabel("/");
		aaaaI=new JTextField(4);
		
		JLabel dataF=new JLabel("Data Fine Prenotazione ");
		ggF=new JTextField(2);
		JLabel slash3=new JLabel("/");
		mmF=new JTextField(2);
		JLabel slash4=new JLabel("/");
		aaaaF=new JTextField(4);
		
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
				    	  
				    	  String giornoI=ggI.getText();
				    	  int ngI=Integer.parseInt(giornoI);
				    	  String meseI=mmI.getText();
				    	  int nmI=Integer.parseInt(meseI);
				    	  String annoI=aaaaI.getText();
				    	  int naI=Integer.parseInt(annoI);
				    	  
				    	  if ((ngI<1||ngI>31)||(nmI<1||nmI>12)||(naI<1880||naI>2050)) throw new ErrorException(contenitore,"Inserire data di inizio prenotazione corretta!");
				    	  else if((nmI==11||nmI==9||nmI==6||nmI==4)&&(ngI>30))throw new ErrorException(contenitore,"Inserire data di inizio prenotazione corretta!");
				    	  else if(((nmI==2)&&((naI % 4)==0)&&(ngI>29))||((nmI==2)&&(naI % 4!=0)&&(ngI>28)))throw new ErrorException(contenitore,"Inserire data di inizio prenotazione corretta!");
				    	  else{
				    		  String sommaI;
				    		  if (ngI<10) giornoI="0"+ngI;
				    		         else giornoI=""+ngI;
				    		  if (nmI<10) meseI="0"+nmI;
				    		         else meseI=""+nmI;
				    		  annoI=""+naI;
				    		  sommaI=giornoI+"/"+meseI+"/"+annoI;
				            
			  
				    		  
				            String giornoF=ggF.getText();
					    	  int ngF=Integer.parseInt(giornoF);
					    	  String meseF=mmF.getText();
					    	  int nmF=Integer.parseInt(meseF);
					    	  String annoF=aaaaF.getText();
					    	  int naF=Integer.parseInt(annoF);
					    	  
					    	  if ((ngF<1||ngF>31)||(nmF<1||nmF>12)||(naF<1880||naF>2050)) throw new ErrorException(contenitore,"Inserire data di fine prenotazione  corretta!");
					    	  else if((nmF==11||nmF==9||nmF==6||nmF==4)&&(ngF>30))throw new ErrorException(contenitore,"Inserire data di fine prenotazione  corretta!");
					    	  else if(((nmF==2)&&((naF % 4)==0)&&(ngF>29))||((nmF==2)&&(naF % 4!=0)&&(ngF>28)))throw new ErrorException(contenitore,"Inserire data di fine prenotazione corretta!");
					    	  else{
					    		  String sommaF;
					    		  if (ngF<10) giornoF="0"+ngF;
					    		         else giornoF=""+ngF;
					    		  if (nmF<10) meseF="0"+nmF;
					    		         else meseF=""+nmF;
					    		  annoF=""+naF;
					    		  sommaF=giornoF+"/"+meseF+"/"+annoF;
					    		  
					    		  
					    		  
					    		  
					    		  String giornoN=ggN.getText();
						    	  int ngN=Integer.parseInt(giornoN);
						    	  String meseN=mmN.getText();
						    	  int nmN=Integer.parseInt(meseN);
						    	  String annoN=aaaaN.getText();
						    	  int naN=Integer.parseInt(annoN);
						    	  
						    	  if ((ngN<1||ngN>31)||(nmN<1||nmN>12)||(naN<1880||naN>2010)) throw new ErrorException(contenitore,"Inserire data di nascita corretta!");
						    	  else if((nmN==11||nmN==9||nmN==6||nmN==4)&&(ngN>30))throw new ErrorException(contenitore,"Inserire data di nascita corretta!");
						    	  else if(((nmN==2)&&((naN % 4)==0)&&(ngN>29))||((nmN==2)&&(naN % 4!=0)&&(ngN>28)))throw new ErrorException(contenitore,"Inserire data di nascita corretta!");
						    	  else{
						    		  String sommaN;
						    		  if (ngN<10) giornoN="0"+ngN;
						    		         else giornoN=""+ngN;
						    		  if (nmN<10) meseN="0"+nmN;
						    		         else meseN=""+nmN;
						    		  annoN=""+naN;
						    		  sommaN=giornoN+"/"+meseN+"/"+annoN;	 

						   int gg1=Integer.parseInt(sommaI.substring(0,2));
						   int mm1=Integer.parseInt(sommaI.substring(3,5));
						   int aa1=Integer.parseInt(sommaI.substring(6,10));
						   GregorianCalendar dataI=new GregorianCalendar(aa1,mm1-1,gg1);
						    	  		
						   int gg2=Integer.parseInt(sommaF.substring(0,2));
						   int mm2=Integer.parseInt(sommaF.substring(3,5));
						   int aa2=Integer.parseInt(sommaF.substring(6,10));
						   GregorianCalendar dataF=new GregorianCalendar(aa2,mm2-1,gg2); 
						   
						   GregorianCalendar a=new GregorianCalendar(); 
						   GregorianCalendar attuale=new GregorianCalendar(a.get(Calendar.YEAR),a.get(Calendar.MONTH),a.get(Calendar.DAY_OF_MONTH));
						   
						   if (attuale.after(dataI))throw new ErrorException(contenitore,"La data di inizio PRECEDE la data di attuale!");
						   if (dataI.after(dataF))throw new ErrorException(contenitore,"La data di fine PRECEDE la data di inizio!");
						    
						   if (areaNum.getText().equals(""))throw new ErrorException(contenitore,"Inserire numero della camera");
						   int numeroCamera=Integer.parseInt(areaNum.getText());

						   
						   String nome=areaNom.getText();
						   String cognome=areaCog.getText();
					    	
						   if ((nome.length()>20)||(cognome.length()>20))throw new ErrorException(contenitore,"Non superare la lunghezza di 20 caratteri!");
					       if ((nome.equals(""))&&(cognome.equals(""))&&(giornoI.equals(""))&&(meseI.equals(""))&&(annoI.equals(""))&&(giornoF.equals(""))&&(meseF.equals(""))&&(annoF.equals(""))&&(giornoN.equals(""))&&(meseN.equals(""))&&(annoN.equals("")))throw new ErrorException(contenitore,"Riempire tutti i campi!");
						   
					        DBCamera d = (DBCamera)Naming.lookup(client.getUrl());  
					       
					        ArrayList<Camera> camere=new ArrayList<Camera>();
					        camere=d.getElencoCamera();
					        
					        boolean bit=false;
					        for(Camera C:camere){
					        	if (C.getNumero()==numeroCamera) bit=true;
					        }
					        
					        if (!bit) throw new ErrorException(contenitore,"Camera non presente nell'elenco!"); 
					        
	                        boolean b=d.setPrenota(numeroCamera,sommaI,sommaF,nome,cognome,sommaN);
	                    
	                        if(!b){FrameMessage m=new FrameMessage(contenitore,"  Camera Prenotata",true);
		                          m.visualizzaFrame();}
				    	       else throw new ErrorException(contenitore,"<html>Camera già impegnata per il periodo richiesto<br>oppure dati cliente non corretti</html>");
					    	  
						    	  }}}}
		                 catch (Exception e) {
				       
				          System.out.println("DataClient Error: " + e);
				          throw new ErrorException(contenitore,"Impossibile aggiungere al database");
				          }
				
			}
		}
		ActionListener listenerPrenota=new addActionListenerPrenota();
		prenota.addActionListener(listenerPrenota);
		
		
		JPanel intermedio1=new JPanel();
		intermedio1.setBackground(contenitore.getColore());
		
		intermedio1.add(dataI);
		intermedio1.add(ggI);
		intermedio1.add(slash1);
		intermedio1.add(mmI);
		intermedio1.add(slash2);
		intermedio1.add(aaaaI);
		intermedio1.add(dataF);
		intermedio1.add(ggF);
		intermedio1.add(slash3);
		intermedio1.add(mmF);
	    intermedio1.add(slash4);
		intermedio1.add(aaaaF);
		intermedio1.add(num);
		intermedio1.add(areaNum);
		
		
		JPanel intermedio2=new JPanel();
		intermedio2.setBackground(contenitore.getColore());
		
		JLabel nome=new JLabel("Nome ");
		areaNom=new JTextField(15);
		
		JLabel cog=new JLabel("Cognome ");
		areaCog=new JTextField(15);
		
		JLabel dataN=new JLabel("Data di Nascita");
		ggN=new JTextField(2);
		JLabel slash5=new JLabel("/");
		mmN=new JTextField(2);
		JLabel slash6=new JLabel("/");
		aaaaN=new JTextField(4);
		
		intermedio2.add(nome);
		intermedio2.add(areaNom);
		intermedio2.add(cog);
		intermedio2.add(areaCog);
		intermedio2.add(dataN);
		intermedio2.add(ggN);
		intermedio2.add(slash5);
		intermedio2.add(mmN);
		intermedio2.add(slash6);
		intermedio2.add(aaaaN);
		intermedio2.add(prenota);
	
		
		panel2.add(intermedio1);
		panel2.add(intermedio2);
		
		//panel3
		JPanel panel3=new JPanel();
		panel3.setBackground(contenitore.getColore());
		
		
		indice=0;
		int l=arrayC.size();
		
		String[] nomiColonne={"Numero","Piano","Numero Letti","Tipo","Stato"};
		
		String[][] celle=new String[l][5];
		
		 for(Camera cam:arrayC){
			celle[indice][0]=Integer.toString(cam.getNumero());
		    celle[indice][1]=Integer.toString(cam.getPiano());
			celle[indice][2]=Integer.toString(cam.getNumLetti());
			celle[indice][3]=cam.getTipo();
			if (cam.getStato()) celle[indice][4]="Libera";
			               else celle[indice][4]="Occupata";
			indice++;
		}
		
		JScrollPane barra2=new JScrollPane();
		
		JTable tabella=new JTable(celle,nomiColonne);
		tabella.setBackground(Color.WHITE);
		
		tabella.setEnabled(false);

		Dimension d=new Dimension(750,160);
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
	private JTextField ggI;
	private JTextField mmI;
	private JTextField aaaaI;
	private JTextField ggF;
	private JTextField mmF;
	private JTextField aaaaF;
	private JTextField ggN;
	private JTextField mmN;
	private JTextField aaaaN;
	private JTextField areaNum;
	private JTextField areaCog;
	private JTextField areaNom;
	
}	

