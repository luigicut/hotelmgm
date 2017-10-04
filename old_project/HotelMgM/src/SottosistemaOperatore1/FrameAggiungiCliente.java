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
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import Eccezioni.ErrorException;
import IS.BarraMenuIS;
import IS.Cliente;
import IS.Contenitore;
import IS.FrameMessage;
import IS.FramePrincipaleIS;
import RMI.DBClient;
import RMI.DBCliente;

/**
 * Questa classe definisce un oggetto FrameAggiungiCliente
 * @author Daniele
 *
 */
public class FrameAggiungiCliente extends JFrame{

static final long serialVersionUID=0;
	
/**
 * Costruisce la finestra frame con tutte le sue componenti 
 * @param c Oggetto di tipo contenitore
 * 
 */
	public FrameAggiungiCliente(Contenitore c){
		
		contenitore=c;
		
		frame=new JFrame();
		
		frame.setSize(900,600);
		frame.setTitle("HotelMgM");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		BarraMenuIS barra=new BarraMenuIS(frame,contenitore,12);
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
		
		JLabel larea=new JLabel("            Dati Nuovo Cliente  ");
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
		
		Image img2=kit.getImage("./immagini/nuovo_cli.png");
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
		
		JLabel nome=new JLabel("Nome ");
		areaNome=new JTextField(15);
	
		JLabel cog=new JLabel("Cognome");
		areaCog=new JTextField(15);
		
		JLabel data=new JLabel("Data di Nascita ");
		gg=new JTextField(2);
		JLabel slash1=new JLabel("/");
		mm=new JTextField(2);
		JLabel slash2=new JLabel("/");
		aaaa=new JTextField(4);
		
		JPanel intermedio1=new JPanel();
		intermedio1.setBackground(contenitore.getColore());
		intermedio1.add(nome);
		intermedio1.add(areaNome);
		intermedio1.add(cog);
		intermedio1.add(areaCog);
		intermedio1.add(data);
		intermedio1.add(gg);
		intermedio1.add(slash1);
		intermedio1.add(mm);
		intermedio1.add(slash2);
	    intermedio1.add(aaaa);
		
	
		JLabel nazione=new JLabel("Nazionalità ");
		areaNazione=new JTextField(15);
		
		//radio button
		Mbutton=new JRadioButton("M");
		Fbutton=new JRadioButton("F");
		Mbutton.setBackground(contenitore.getColore());
		Fbutton.setBackground(contenitore.getColore());
		Mbutton.setFocusPainted(false); //elimina il rettangolo di selezione che si forma intorno al bottone quando lo si seleziona
		Fbutton.setFocusPainted(false); //elimina il rettangolo di selezione che si forma intorno al bottone quando lo si seleziona
		Mbutton.setSelected(true);
		
		ButtonGroup gruppo1=new ButtonGroup();
		gruppo1.add(Mbutton);
		gruppo1.add(Fbutton);
		JPanel intermedioRadio=new JPanel();
		
		intermedioRadio.setBorder(new TitledBorder(new EtchedBorder(),"Sesso"));
		intermedioRadio.setBackground(contenitore.getColore());
		intermedioRadio.add(Mbutton);
		intermedioRadio.add(Fbutton);
		
		
		JPanel intermedio2=new JPanel();
		intermedio2.setBackground(contenitore.getColore());
		intermedio2.add(nazione);
		intermedio2.add(areaNazione);
		intermedio2.add(intermedioRadio);
		
		
		JLabel luogo=new JLabel("Luogo di Nascita ");
		areaLuogo=new JTextField(15);
	
		JLabel prov=new JLabel("Provincia ");
		areaPro=new JTextField(15);
		
		
		JPanel intermedio3=new JPanel();
		intermedio3.setBackground(contenitore.getColore());
		intermedio3.add(luogo);
		intermedio3.add(areaLuogo);
		intermedio3.add(prov);
		intermedio3.add(areaPro);
		
		panel2.setBorder(new TitledBorder(new EtchedBorder(),"Dati Anagrafici"));
		panel2.setLayout(new GridLayout(3,1));
		
		panel2.add(intermedio1);
		panel2.add(intermedio3);
		panel2.add(intermedio2);

		//panel3
		JPanel panel3=new JPanel();
		panel3.setBackground(contenitore.getColore());
		
		JLabel num=new JLabel("N° ");
		areaNum=new JTextField(15);
	
		JLabel codice=new JLabel("Codice Fiscale ");
		areaCodice=new JTextField(20);
		
		JPanel intermedio4=new JPanel();
		intermedio4.setBackground(contenitore.getColore());
		intermedio4.add(num);
		intermedio4.add(areaNum);
		intermedio4.add(codice);
		intermedio4.add(areaCodice);
		
	    
	    panel3.setBorder(new TitledBorder(new EtchedBorder()," Documento d'Identità "));
		
		panel3.add(intermedio4);
			
		
		//panel4
		JPanel panel4=new JPanel();
		panel4.setBackground(contenitore.getColore());
		
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
		
		JLabel space45=new JLabel("     ");
		
		
		intermedioRadio2.setBorder(new TitledBorder(new EtchedBorder(),"Persone a Carico"));
		intermedioRadio2.setBackground(contenitore.getColore());
		intermedioRadio2.add(space45);
		intermedioRadio2.add(Sbutton);
		intermedioRadio2.add(Nbutton);
		
		
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
            				
				try {     String nome=areaNome.getText();
				    	  String cognome=areaCog.getText();
				    	  String luogo=areaLuogo.getText();
				    	  String provincia=areaPro.getText();
				    	  String nazione=areaNazione.getText();
				    	  String numeroCartaID=areaNum.getText();
				    	  String codiceFiscale=areaCodice.getText();
				    	  
				    	  String sesso; String carico;
				    	  
				    	  if (Mbutton.isSelected()) sesso="M";
				    	  else sesso="F";
				    					    	  
				    	  if (Sbutton.isSelected()) carico="SI";
				    	  else carico="NO";
				    		
				    	  String giorno=gg.getText();
				    	  int ng=Integer.parseInt(giorno);
				    	  String mese=mm.getText();
				    	  int nm=Integer.parseInt(mese);
				    	  String anno=aaaa.getText();
				    	  int na=Integer.parseInt(anno);
				    	  
				    	  
				    	  if ((nome.length()>20)||(cognome.length()>20)||(luogo.length()>20)||(provincia.length()>20)||(nazione.length()>20)||(numeroCartaID.length()>20))throw new ErrorException(contenitore,"Non superare la lunghezza di 20 caratteri!");
				    	  if ((nome.equals(""))||(cognome.equals(""))||(luogo.equals(""))||(provincia.equals(""))||(nazione.equals(""))||(numeroCartaID.equals(""))||(codiceFiscale.equals(""))||(giorno.equals(""))||(mese.equals(""))||(anno.equals("")))throw new ErrorException(contenitore,"Riempire tutti i campi!");
				    	  if (codiceFiscale.length()!=16)throw new ErrorException(contenitore,"Il codice fiscale deve essere di 16 caratteri!");
				    	  
				    	     	  
				    	  if ((ng<1||ng>31)||(nm<1||nm>12)||(na<1880||na>2010)) throw new ErrorException(contenitore,"Inserire data di nascita corretta!");
				    	  else if((nm==11||nm==9||nm==6||nm==4)&&(ng>30))throw new ErrorException(contenitore,"Inserire data di nascita corretta!");
				    	  else if(((nm==2)&&((na % 4)==0)&&(ng>29))||((nm==2)&&(na % 4!=0)&&(ng>28)))throw new ErrorException(contenitore,"Inserire data di nascita corretta!");
				    	  else{
				    		  String somma;
				    		  if (ng<10) giorno="0"+ng;
				    		         else giorno=""+ng;
				    		  if (nm<10) mese="0"+nm;
				    		         else mese=""+nm;
				    		  anno=""+na;
				    		  somma=giorno+"/"+mese+"/"+anno;
				    					
				    	    Cliente cliente=new Cliente(1,nome,cognome,luogo,provincia,somma,numeroCartaID,codiceFiscale,nazione,sesso);
				    	    DBCliente d = (DBCliente)Naming.lookup(client.getUrl());  
				      	    boolean b=d.insertCliente(cliente);
	                      	                        
	                        if(!b){ 
	                        	if(carico.equals("NO")){
	            				                       FrameMessage m=new FrameMessage(contenitore,"  Nuovo Cliente Aggiunta al Database",true);
	            				                       m.visualizzaFrame();}
	                        	   else{
	                        		   
	                        		      try{DBCliente d2 = (DBCliente)Naming.lookup(client.getUrl()); 
	                        		       arrayCli=new ArrayList<Cliente>();	
	 						          
	 						               arrayCli=d2.getRicercaCliente(nome,cognome,somma);
	 		
	 						               if (arrayCli.isEmpty())throw new ErrorException(contenitore,"Nessun elemento trovato");
	 						                 else{
	 						                	 Cliente cliente2=arrayCli.get(0);
	 						                	 FrameAggiungiPersone p=new FrameAggiungiPersone(contenitore,cliente2.getCodice());
	 						                     p.visualizzaFrame();
	 						                     frame.dispose();
	 						                      }
	 						               } 
	 						    	    catch (Exception e) {
	 						            System.out.println("DataClient Error: " + e);
	 						            }
	 						  
	                        	   }
	            				  
	                              }
				    	     }
				          
			              }
		                 catch (Exception e) {
				       
				          System.out.println("DataClient Error: " + e);
				          throw new ErrorException(contenitore,"Impossibile aggiungere al database");
				          }
			}
		}
		ActionListener listenerConferma=new addActionListenerConferma();
		conferma.addActionListener(listenerConferma);

		panel4.add(intermedioRadio2);
		panel4.add(conferma);
		
		
		//pannello Principale
		JPanel pannelloPrincipale=new JPanel();
		pannelloPrincipale.setBackground(contenitore.getColore());
		pannelloPrincipale.add(panel0);
		pannelloPrincipale.add(panel1);
		pannelloPrincipale.add(panel2);
		pannelloPrincipale.add(panel3);
		pannelloPrincipale.add(panel4);
				
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
    private JTextField areaNome;
	private JTextField areaCog;
	private JTextField areaLuogo;
	private JTextField areaPro;
    private JTextField gg;
    private JTextField mm;
    private JTextField aaaa;
    private JTextField areaNazione;
    private JTextField areaCodice;
	private JTextField areaNum;
	private JRadioButton Mbutton;
	private JRadioButton Fbutton;
	private JRadioButton Nbutton;
	private JRadioButton Sbutton;
	private ArrayList<Cliente> arrayCli;

}
