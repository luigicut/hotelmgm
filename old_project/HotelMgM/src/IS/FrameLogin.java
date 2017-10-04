package IS;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.util.ArrayList;

import javax.swing.*;

import Eccezioni.ErrorException;
import RMI.DBAccount;
import RMI.DBClient;
import SottosistemaAmministratore.FrameAdmin;
import SottosistemaOperatore1.FrameOp1;
import SottosistemaOperatore2.FrameOp2;

/**
 * Questa classe definisce un oggetto FrameLogin
 * @author Daniele
 *
 */
	public class FrameLogin extends JFrame{
		
		static final long serialVersionUID=0;

		/**
		 * Costruisce la finestra frame con tutte le sue componenti 
		 * @param c Oggetto di tipo contenitore
		 * @param prec Frame precedente
		 */
	public FrameLogin(Contenitore c,JFrame prec) {
			
		    contenitore=c;
		    framePrecedente=prec;
		
			frame=new JFrame();
			
			frame.setSize(550,226);
			frame.setTitle("HotelMgM");
			frame.setResizable(false);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			
			
			Toolkit kit=Toolkit.getDefaultToolkit();//Per eseguire metodi relativi a immagini
			
			//immagine Icona
			String pathIcona="./immagini/trasparente/logo25.png";
			Image imgIcona=kit.getImage(pathIcona);
			
			frame.setIconImage(imgIcona);//inserisce l'icona al titolo
			
			//Colore di sfondo di un pannello
			JPanel pannello=new JPanel();
			pannello.setBackground(contenitore.getColore());
			
			
			//pannello1
			JPanel panel1=new JPanel();
			panel1.setBackground(contenitore.getColore());
			
			JLabel l0=new JLabel("         ");
			JPanel intermedio0=new JPanel();
			intermedio0.add(l0);
			intermedio0.setBackground(contenitore.getColore());
			
			String strNome="Nome Utente";
			JLabel lnome=new JLabel(strNome);
			areaNome=new JTextField(15);
			JPanel intermedio1=new JPanel();
			intermedio1.setBackground(contenitore.getColore());
			intermedio1.add(lnome);
			intermedio1.add(areaNome);
			
			JLabel lpass=new JLabel("   Password  ");
			areaPass=new JPasswordField(15);
			JPanel intermedio2=new JPanel();
			intermedio2.setBackground(contenitore.getColore());
			intermedio2.add(lpass);
			intermedio2.add(areaPass);
			
			
			String pathAccedi="./Bottoni/Accedi_0.png";
			Image imgButtonAccedi=kit.getImage(pathAccedi);
			Icon iconaAccedi=new ImageIcon(imgButtonAccedi);	
			JButton accedi=new JButton(iconaAccedi);
			accedi.setBackground(contenitore.getColore());
			accedi.setFocusPainted(false); 
			accedi.setBorderPainted(false);
			accedi.setContentAreaFilled(false);
			accedi.setPressedIcon(new ImageIcon ("./Bottoni/Accedi_1.png"));
			
			//crea comandi bottone ACCEDI <----------------------
			class addActionListener implements ActionListener
			{
				public void actionPerformed(ActionEvent event){

					DBClient client=contenitore.getClient();
					
					try {
					     boolean flag=false;
					     Account trovato=new Account("","","","","","");
					
					     DBAccount d = (DBAccount)Naming.lookup(client.getUrl()); 
					
					     ArrayList<Account> ListaAccount=new ArrayList<Account>();
					
					     ListaAccount=d.getElencoAccount();
					
					     String nom;String pas;String areaN;String contenutoP="";
					
					     areaN=areaNome.getText();
						 char[] vettoreP=areaPass.getPassword();
						 int i;
						 for(i=0;i<vettoreP.length;i++){
								contenutoP=contenutoP+vettoreP[i];
						 }
						 
						 if (areaN.equals("")||contenutoP.equals(""))throw new ErrorException(contenitore,"<html>Riempire tutti i campi!</html>");
						 if ((areaN.length()<4||areaN.length()>20)||(contenutoP.length()<4||contenutoP.length()>20))throw new ErrorException(contenitore,"<html>I dati devono avere una lunghezza <br>da 4 a 20 caratteri!</html>");
						 
					     
					for(Account caricato:ListaAccount){
						 nom=caricato.getLogin();
						 pas=caricato.getPassword();		 
						 if (nom.equals(areaN) && pas.equals(contenutoP)){flag=true;trovato=caricato;break;} 
					}
					
					if (flag){
					            if (trovato.getRuolo().equals("Amministratore")){FrameAdmin p=new FrameAdmin(contenitore);
								                                                 p.visualizzaFrame();
					                                                             }
					            else{if (trovato.getRuolo().equals("Operatore livello1")){FrameOp1 p=new FrameOp1(contenitore);
                                                                                          p.visualizzaFrame();
                                                            					            }
					                  else{
					                	  FrameOp2 p=new FrameOp2(contenitore);
                                          p.visualizzaFrame();
					                      }
					                }     
					            frame.dispose();
								framePrecedente.dispose(); 
					            }
					else
					{ throw new ErrorException(contenitore,"Dati Account errati!");}
			}
					catch (Exception e) {
				          System.out.println("DataClient Error: " + e);
				          }					
				}
			}
			ActionListener listener=new addActionListener();
			accedi.addActionListener(listener);
			
			JPanel intermedio3=new JPanel();
			intermedio3.setBackground(contenitore.getColore());
			intermedio3.add(accedi);
			
			
			panel1.add(intermedio0);
			panel1.add(intermedio1);
			panel1.add(intermedio2);
			panel1.add(intermedio3);
			
			//pannello 2
			JPanel panel2=new JPanel();
			
			String pathImg="./immagini/trasparente/logo100.png";
			Image img=kit.getImage(pathImg);
			Icon iconaImg=new ImageIcon(img);
			JLabel imm=new JLabel(iconaImg);
			panel2.setBackground(contenitore.getColore());
			panel2.add(imm);
			
			//pannello Principale
			JPanel pannelloPrincipale=new JPanel();
			pannelloPrincipale.setLayout(new GridLayout(1,2));
			pannelloPrincipale.add(panel2);
			pannelloPrincipale.add(panel1);
	        
					
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
	    

	    private JFrame frame;
	    private JFrame framePrecedente;
	    private Contenitore contenitore;
	    private JPasswordField areaPass;
	    private JTextField areaNome;
	}


