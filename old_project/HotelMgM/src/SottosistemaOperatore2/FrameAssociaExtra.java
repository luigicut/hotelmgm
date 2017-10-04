package SottosistemaOperatore2;

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

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import Eccezioni.ErrorException;
import IS.BarraMenuIS;
import IS.Camera;
import IS.Contenitore;
import IS.Extra;
import IS.FrameMessage;
import IS.FramePrincipaleIS;
import RMI.DBExtra;
import RMI.DBCamera;
import RMI.DBClient;

/**
 * Questa classe definisce un oggetto FrameAssociaExtra
 * @author Daniele
 *
 */
public class FrameAssociaExtra extends JFrame{

	static final long serialVersionUID=0;
	
	/**
	 * Costruisce la finestra frame con tutte le sue componenti 
	 * @param c Oggetto di tipo contenitore
	 * @param ArrayList<Extra> lista degli extra
	 */
	public FrameAssociaExtra(Contenitore c,ArrayList<Extra> arr){
		
		contenitore=c;
		arrayE=arr;
		
		frame=new JFrame();
		
		frame.setSize(900,600);
		frame.setTitle("HotelMgM");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		BarraMenuIS barra=new BarraMenuIS(frame,contenitore,27);
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
		
		JLabel larea=new JLabel("                 Associa Extra  ");
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

		Dimension d=new Dimension(750,200);
		tabella.setPreferredScrollableViewportSize(d);
		
		barra2.getViewport().add(tabella);
		barra2.setBackground(contenitore.getColore());
		
		panel2.add(barra2);
		
		//panel3
		JPanel panel3=new JPanel();
		panel3.setBackground(contenitore.getColore());
		
		JLabel num=new JLabel("Numero Camera ");
		areaNum=new JTextField(5);
	
		JLabel qt=new JLabel("             Quantità ");
		areaQt=new JTextField(4);
		
		JPanel intermedio1=new JPanel();
		intermedio1.setBackground(contenitore.getColore());
		intermedio1.add(num);
		intermedio1.add(areaNum);
		intermedio1.add(qt);
		intermedio1.add(areaQt);
		
		JLabel codE=new JLabel("Codice Extra");
		areaCodE=new JTextField(4);
		
		JLabel data=new JLabel("Data di Consumazione ");
		gg=new JTextField(2);
		JLabel slash1=new JLabel("/");
		mm=new JTextField(2);
		JLabel slash2=new JLabel("/");
		aaaa=new JTextField(4);
		
		JPanel intermedio2=new JPanel();
		intermedio2.setBackground(contenitore.getColore());
		intermedio2.add(codE);
		intermedio2.add(areaCodE);
		intermedio2.add(data);
		intermedio2.add(gg);
		intermedio2.add(slash1);
		intermedio2.add(mm);
		intermedio2.add(slash2);
		intermedio2.add(aaaa);
		
		
		String pathInserisci="./Bottoni/Inserisci_0.png";
		Image imgButtonInserisci=kit.getImage(pathInserisci);
		Icon iconaPulsanteInserisci=new ImageIcon(imgButtonInserisci);	
		JButton inserisci=new JButton(iconaPulsanteInserisci);
		inserisci.setBackground(contenitore.getColore());
		inserisci.setFocusPainted(false); 
		inserisci.setBorderPainted(false);
		inserisci.setContentAreaFilled(false);
		inserisci.setPressedIcon(new ImageIcon ("./Bottoni/Inserisci_1.png"));

		//crea comandi bottone Inserisci <----------------------
		class addActionListenerInserisci implements ActionListener
		{
			public void actionPerformed(ActionEvent event){
				
              DBClient client=contenitore.getClient();  
				
				try {     
					      if ( (areaNum.getText().equals(""))) throw new ErrorException(contenitore,"Riempire tutti i campi!");				    	  
					      int numCamera=Integer.parseInt(areaNum.getText());
					      
					       DBCamera dd = (DBCamera)Naming.lookup(client.getUrl()); 
		    		        
		    		        boolean flagCamera=false;
		    		        ArrayList<Camera> listaCamere=new ArrayList<Camera>();
		    		        listaCamere=dd.getElencoCamera();
				            for(Camera cam:listaCamere){
				            	if (cam.getNumero()==numCamera) {flagCamera=true;break;}
				            }
		    		       
				            if (!flagCamera)throw new ErrorException(contenitore,"Codice Camera Inesistente!");
				             
					      
					      
				          String giorno=gg.getText();         
		    	          String mese=mm.getText();
		    	          String anno=aaaa.getText();
		    	          
		    	          if ((giorno.equals(""))||(mese.equals(""))||(anno.equals(""))) throw new ErrorException(contenitore,"Riempire tutti i campi!");				    	  
		    	          
		    	          int ng=Integer.parseInt(giorno);
		    	          int nm=Integer.parseInt(mese);
		    	          int na=Integer.parseInt(anno);
		    	  
		    	  if ((ng<1||ng>31)||(nm<1||nm>12)||(na<1880||na>2050)) throw new ErrorException(contenitore,"Inserire data di consumazione corretta!");
		    	  else if((nm==11||nm==9||nm==6||nm==4)&&(ng>30))throw new ErrorException(contenitore,"Inserire data di consumazione corretta!");
		    	  else if(((nm==2)&&((na % 4)==0)&&(ng>29))||((nm==2)&&(na % 4!=0)&&(ng>28)))throw new ErrorException(contenitore,"Inserire data di consumazione corretta!");
		    	  else{
		    		  String somma;
		    		  if (ng<10) giorno="0"+ng;
		    		         else giorno=""+ng;
		    		  if (nm<10) mese="0"+nm;
		    		         else mese=""+nm;
		    		  anno=""+na;
		    		  somma=giorno+"/"+mese+"/"+anno;
				    	  
		    		  if ( (areaCodE.getText().equals("")) ||(areaQt.getText().equals(""))) throw new ErrorException(contenitore,"Riempire tutti i campi!");				    	  
			    	
		    		  
		    		  int codExtra=Integer.parseInt(areaCodE.getText());
		    		  int qt=Integer.parseInt(areaQt.getText());
				    	
		    		  if (qt<=0)throw new ErrorException(contenitore,"Inserire quantità corretta!");
				            
		    		  
		    		        DBExtra d = (DBExtra)Naming.lookup(client.getUrl()); 
		    		        
		    		        boolean flagExtra=false;
		    		        ArrayList<Extra> listaExtra=new ArrayList<Extra>();
		    		        listaExtra=d.getElencoExtra();
				            for(Extra ex:listaExtra){
				            	if (ex.getCodice()==codExtra) {flagExtra=true;break;}
				            }
		    		       
				            if (!flagExtra)throw new ErrorException(contenitore,"Codice Extra Inesistente!");
				             
		    		        
	                        boolean b=d.associaExtra(numCamera,somma,codExtra,qt);
	                        

	                        if(!b) 
	                        { FrameMessage m=new FrameMessage(contenitore,"  Extra Associato alla Camera "+numCamera,true);
		                    m.visualizzaFrame();}
	                        else throw new ErrorException(contenitore,"Errore inserimento dati");
	                   } 
		    	  }
				
	                        catch (Exception e) {
							       
						          System.out.println("DataClient Error: " + e);
						          throw new ErrorException(contenitore,"Impossibile aggiungere al database");
						          }		
			}
		}
		ActionListener listenerInserisci=new addActionListenerInserisci();
		inserisci.addActionListener(listenerInserisci);
		
		JPanel intermedio3=new JPanel();
		intermedio3.setBackground(contenitore.getColore());
	    intermedio3.add(inserisci);
		
		panel3.setBorder(new TitledBorder(new EtchedBorder(),"Dati Associazione Extra"));
		panel3.setLayout(new GridLayout(3,1));
		
		panel3.add(intermedio1);
		panel3.add(intermedio2);
		panel3.add(intermedio3);

		//panel4
		JPanel panel4=new JPanel();
		panel4.setBackground(contenitore.getColore());
		
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
		
		String pathFine="./Bottoni/Fine_Inserimento_0.png";
		Image imgButtonFine=kit.getImage(pathFine);
		Icon iconaPulsanteFine=new ImageIcon(imgButtonFine);	
		JButton fine=new JButton(iconaPulsanteFine);
		fine.setBackground(contenitore.getColore());
		fine.setFocusPainted(false); 
		fine.setBorderPainted(false);
		fine.setContentAreaFilled(false);
		fine.setPressedIcon(new ImageIcon ("./Bottoni/Fine_Inserimento_1.png"));

		//crea comandi bottone Fine <----------------------
		class addActionListenerFine implements ActionListener
		{
			public void actionPerformed(ActionEvent event){
				
				FrameOp2 p=new FrameOp2(contenitore);
				p.visualizzaFrame();
				frame.dispose();
				
				FrameMessage m=new FrameMessage(contenitore,"  Inserimento Terminato",true);
				m.visualizzaFrame();
				
			}
		}
		ActionListener listenerFine=new addActionListenerFine();
		fine.addActionListener(listenerFine);
		
		panel4.add(fine);
		panel4.add(home);
		
		//pannello Principale
		JPanel pannelloPrincipale=new JPanel();
		pannelloPrincipale.setBackground(contenitore.getColore());
		pannelloPrincipale.add(panel0);
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
    private int indice;
    private ArrayList<Extra> arrayE;
    private JTextField gg;
    private JTextField mm;
    private JTextField aaaa;
    private JTextField areaNum;private JTextField areaCodE;private JTextField areaQt;
	
}

