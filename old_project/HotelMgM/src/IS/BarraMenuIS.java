package IS;


import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JFrame;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Questa classe definisce un oggetto BarraMenuIS
 * @author Daniele
 *
 */
public class BarraMenuIS extends JMenuBar {

	static final long serialVersionUID=0;
	
	/**
	 * Crea la barra dei menu'
	 * @param f Frame che contiene la barra
	 * @param cont Oggetto di tipo contenitore
	 * @param i Parametro aggiuntivo per una eventuale gestione degli oggetti frame
	 */
	public BarraMenuIS(JFrame f, Contenitore cont,int i){
		
		frame=f;
		
		menuBar=new JMenuBar();
		menuBar.add(createFileMenu());
		menuBar.add(createInterrogMenu());

	}
	
	/**
	 * Restituisce il menuBar
	 * @return menuBar 
	 */
	
	public JMenuBar getMenu(){
		return menuBar;
	}
	
	/**
	 * Crea il menu File
	 * @return menu
	 */
	public JMenu createFileMenu(){
		JMenu menu=new JMenu("File");
		menu.add(createExitItem());
		return (menu);
	}
	
	/**
	 * Crea Exit item
	 * @return item
	 */
	public JMenuItem createExitItem(){
		JMenuItem item=new JMenuItem("Exit");
		class MenuItemListener implements ActionListener{
			public void actionPerformed(ActionEvent event){		
				frame.dispose();
			}
		}
		ActionListener listener=new MenuItemListener();
		item.addActionListener(listener);
		
		return (item);
	}

	/**
	 * Crea il menu Interrog
	 * @return menu
	 */
	public JMenu createInterrogMenu(){
		JMenu menu=new JMenu("  ?  ");
		menu.add(createAiutoItem());
		return (menu);
	}
	
	/**
	 * Crea help item
	 * @return item
	 */
	public JMenuItem createAiutoItem(){
		JMenuItem item=new JMenuItem("Help in linea");
		class MenuItemListener implements ActionListener{
			public void actionPerformed(ActionEvent event){		
				try {
					Desktop.getDesktop().browse(new URI("manuale.htm"));
				} catch (IOException e) {
					
					e.printStackTrace();
				} catch (URISyntaxException e) {
					
					e.printStackTrace();
				}
				
			}
		}
		ActionListener listener=new MenuItemListener();
		item.addActionListener(listener);
		
		return (item);
	}
	
	private JMenuBar menuBar;
	private JFrame frame;

}

