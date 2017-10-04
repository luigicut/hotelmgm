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

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import Eccezioni.ErrorException;
import IS.BarraMenuIS;
import IS.Camera;
import IS.Cliente;
import IS.Contenitore;
import IS.FrameMessage;
import IS.FramePrincipaleIS;
import RMI.DBCamera;
import RMI.DBClient;
import RMI.DBCliente;

/**
 * Questa classe definisce un oggetto FrameOccupa
 * @author Daniele
 *
 */
public class FrameOccupa extends JFrame{

static final long serialVersionUID=0;
	
/**
 * Costruisce la finestra frame con tutte le sue componenti 
 * @param c Oggetto di tipo contenitore
 * @param ArrayList<Camera> lista delle camere
 */
	public FrameOccupa(Contenitore c,ArrayList<Camera> arr){
		
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
		
		JLabel larea=new JLabel("                Occupa Camera  ");
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
		
		JLabel dataF=new JLabel("    Data di fine occupazione ");
		ggF=new JTextField(2);
		JLabel slash1=new JLabel("/");
		mmF=new JTextField(2);
		JLabel slash2=new JLabel("/");
		aaaaF=new JTextField(4);
		
		//radio button
		Sbutton=new JRadioButton("SI  ");
		Nbutton=new JRadioButton("NO      ");
		Sbutton.setBackground(contenitore.getColore());
		Nbutton.setBackground(contenitore.getColore());
		Sbutton.setFocusPainted(false); //elimina il rettangolo di selezione che si forma intorno al bottone quando lo si seleziona
		Nbutton.setFocusPainted(false); //elimina il rettangolo di selezione che si forma intorno al bottone quando lo si seleziona
		Nbutton.setSelected(true);
		
		ButtonGroup gruppo2=new ButtonGroup();
		gruppo2.add(Sbutton);
		gruppo2.add(Nbutton);
		
        JPanel intermedioRadio2=new JPanel();
		
		JLabel space45=new JLabel("        ");
			
		intermedioRadio2.setBorder(new TitledBorder(new EtchedBorder(),"Con Prenotazione"));
		intermedioRadio2.setBackground(contenitore.getColore());
		intermedioRadio2.add(space45);
		intermedioRadio2.add(Sbutton);
		intermedioRadio2.add(Nbutton);
		
		
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
		
		
		String pathOccupa="./Bottoni/Occupa_0.png";
		Image imgButtonOccupa=kit.getImage(pathOccupa);
		Icon iconaPulsanteOccupa=new ImageIcon(imgButtonOccupa);	
		JButton occupa=new JButton(iconaPulsanteOccupa);
		occupa.setBackground(contenitore.getColore());
		occupa.setFocusPainted(false); 
		occupa.setBorderPainted(false);
		occupa.setContentAreaFilled(false);
		occupa.setPressedIcon(new ImageIcon ("./Bottoni/Occupa_1.png"));

		//crea comandi bottone occupa <----------------------
		class addActionListenerOccupa implements ActionListener
		{
			public void actionPerformed(ActionEvent event){
				  
				DBClient client=contenitore.getClient();
		            
					try {     
					          DBCliente d = (DBCliente)Naming.lookup(client.getUrl()); 
					          
					          String n1=areaNom.getText();
					          String n2=areaCog.getText();
			
					          String sommaN;
					         
					          String giornoN=ggN.getText();	    	  
					    	  String meseN=mmN.getText();
					    	  String annoN=aaaaN.getText();
					    	  
					    	  if ((n1.length()>20)||(n2.length()>20))throw new ErrorException(contenitore,"Non superare la lunghezza di 20 caratteri!");
						  
					    	  if (giornoN.equals("")||meseN.equals("")||annoN.equals(""))  sommaN=" ";
					    	  else{
					    	  int ngN=Integer.parseInt(giornoN);
					    	  int nmN=Integer.parseInt(meseN);
					    	  int naN=Integer.parseInt(annoN);
					    	  
					    	  if ((ngN<1||ngN>31)||(nmN<1||nmN>12)||(naN<1880||naN>2010)) throw new ErrorException(contenitore,"Inserire data di nascita corretta!");
					    	  else if((nmN==11||nmN==9||nmN==6||nmN==4)&&(ngN>30))throw new ErrorException(contenitore,"Inserire data di nascita corretta!");
					    	  else if(((nmN==2)&&((naN % 4)==0)&&(ngN>29))||((nmN==2)&&(naN % 4!=0)&&(ngN>28)))throw new ErrorException(contenitore,"Inserire data di nascita corretta!");
					    	  else{
					    		  if (ngN<10) giornoN="0"+ngN;
					    		         else giornoN=""+ngN;
					    		  if (nmN<10) meseN="0"+nmN;
					    		         else meseN=""+nmN;
					    		  annoN=""+naN;
					    		  sommaN=giornoN+"/"+meseN+"/"+annoN;
					    		  }		          
                        }
					          if (n1.equals("")||n2.equals("")||sommaN.equals("")) throw new ErrorException(contenitore,"Inserire tutti i dati del cliente!");
					          else{
					    		  
					          ArrayList<Cliente> arrayCli=new ArrayList<Cliente>();	
					          
					          arrayCli=d.getRicercaCliente(n1,n2,sommaN);
					          
					          if (arrayCli.isEmpty()) throw new ErrorException(contenitore,"<html>Nessun elemento trovato! <br>Registrare dati cliente prima di <br>avviare la procedura 'occupa'</html>");
					          else{
					        	  int codCliente=arrayCli.get(0).getCodice();
					        	  DBCamera d2 = (DBCamera)Naming.lookup(client.getUrl()); 
					        	  
					        	  int numCamera=Integer.parseInt(areaNum.getText());
					        	  boolean flag2=false;
					        	  
					        	  for(Camera cam:arrayC){
					        		  int temporaneo=cam.getNumero();
					        		  if (temporaneo==numCamera) {flag2=true;break;}
					        	  }
					        	  
					        	  if (!flag2)throw new ErrorException(contenitore,"Numero di camera non corretto!");
					        	  else{
					        		  String sommaF;
								         
							          String giornoF=ggF.getText();	    	  
							    	  String meseF=mmF.getText();
							    	  String annoF=aaaaF.getText();
							    	  
							    	  if ((n1.equals(""))||(n2.equals(""))||(giornoN.equals(""))||(meseN.equals(""))||(annoN.equals(""))||(giornoF.equals(""))||(meseF.equals(""))||(annoF.equals("")))throw new ErrorException(contenitore,"Riempire tutti i campi!");
								  
							    	  if (giornoF.equals("")||meseF.equals("")||annoF.equals(""))  sommaF=" ";
							    	  else{  
							    	  int ngF=Integer.parseInt(giornoF);
							    	  int nmF=Integer.parseInt(meseF);
							    	  int naF=Integer.parseInt(annoF);
							    	  GregorianCalendar fine=new GregorianCalendar(naF,nmF,ngF);
							    	  
							    	  if ((ngF<1||ngF>31)||(nmF<1||nmF>12)||(naF<1880||naF>2050)) throw new ErrorException(contenitore,"Inserire data di fine corretta!");
							    	  else if((nmF==11||nmF==9||nmF==6||nmF==4)&&(ngF>30))throw new ErrorException(contenitore,"Inserire data di fine corretta!");
							    	  else if(((nmF==2)&&((naF % 4)==0)&&(ngF>29))||((nmF==2)&&(naF % 4!=0)&&(ngF>28)))throw new ErrorException(contenitore,"Inserire data di fine corretta!");
							    	  else{
							    		  if (ngF<10) giornoF="0"+ngF;
							    		         else giornoF=""+ngF;
							    		  if (nmF<10) meseF="0"+nmF;
							    		         else meseF=""+nmF;
							    		  annoF=""+naF;
							    		  sommaF=giornoF+"/"+meseF+"/"+annoF;
							    		  }	
							    	  
							    	  GregorianCalendar a=new GregorianCalendar(); 
							    	  GregorianCalendar attuale=new GregorianCalendar(a.get(Calendar.YEAR),a.get(Calendar.MONTH)+1,a.get(Calendar.DAY_OF_MONTH));
							
							    	  int ngI=a.get(Calendar.DAY_OF_MONTH);
							    	  int nmI=a.get(Calendar.MONTH)+1;
							    	  int naI=a.get(Calendar.YEAR);

							    	  
									  if (attuale.after(fine))throw new ErrorException(contenitore,"La data di fine PRECEDE la data attuale!");
									    
	  
							    	  
							    	  String giornoI;
							    	  String meseI;
							    	  String annoI;
							    	  if (ngI<10)  giornoI="0"+ngI;
					    		         else giornoI=""+ngI;
					    		      if (nmI<10) meseI="0"+nmI;
					    		         else meseI=""+nmI;
					    		      annoI=""+naI;
					    		      String sommaI=giornoI+"/"+meseI+"/"+annoI;
					        	  
					    		      if (Sbutton.isSelected()){
					    		    	                         boolean prenot=d2.controllaPrenotazione(codCliente,numCamera, sommaI, sommaF);
					    		    	                         if (!prenot)throw new ErrorException(contenitore,"<html>La prenotazione non risulta, selezionare 'NO'<br>oppure la camera è già stata occupata</html>");
					    		    	                         else{
					    		    	                        	 boolean b=d2.occupaCamera(numCamera, codCliente, sommaI, sommaF);
					    							        	      if(!b){
					    							                        FrameMessage m=new FrameMessage(contenitore,"    Camera Occupata",true);
					    								                    m.visualizzaFrame();}
					    										    	     }	
					    		    	                              }
					    		                               
							    	  if(Nbutton.isSelected()){   boolean b=d2.setPrenota(numCamera,sommaI,sommaF,n1,n2,sommaN);	                    
				                                                     if(b) throw new ErrorException(contenitore,"<html>La camera non è disponibile fino alla data fine, <br>modificare la data</html>");
				                                                      else{
 		    	                        	                              boolean bb=d2.occupaCamera(numCamera, codCliente, sommaI, sommaF);
 							        	                                  if(!bb){                                
 							        	                                   FrameMessage m=new FrameMessage(contenitore,"    Camera Occupata",true);
 								                                           m.visualizzaFrame();}
 										    	                           }	
							    		  
							    	                           }
							    	           
					        	          }
							    	  }
							       }
					            } 
					}
					    	  catch (Exception e) {
					          System.out.println("DataClient Error: " + e);
					          }
					
				}
		
		}
		ActionListener listenerOccupa=new addActionListenerOccupa();
		occupa.addActionListener(listenerOccupa);
		
		JPanel intermedio1=new JPanel();
		intermedio1.setBackground(contenitore.getColore());
		
		intermedio1.add(num);
		intermedio1.add(areaNum);
		intermedio1.add(dataF);
		intermedio1.add(ggF);
		intermedio1.add(slash1);
		intermedio1.add(mmF);
		intermedio1.add(slash2);
		intermedio1.add(aaaaF);
		intermedio1.add(intermedioRadio2);
		
		
        JPanel intermedio2=new JPanel();
        intermedio2.setBackground(contenitore.getColore());
        
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
		intermedio2.add(occupa);
		
		
		
		panel2.add(intermedio1);
		panel2.add(intermedio2);
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
    private JRadioButton Sbutton;
    private JRadioButton Nbutton;
    private JTextField ggF;
    private JTextField mmF;
    private JTextField aaaaF;
    private JTextField ggN;
    private JTextField mmN;
    private JTextField aaaaN;
    private JTextField areaNom;
    private JTextField areaCog;
    private JTextField areaNum;
}	

