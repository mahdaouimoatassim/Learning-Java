import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollBar;


public class Reprend_partie extends JFrame implements Serializable   {
    JLabel ok;
    boolean retour_fen_prin=true;
    JLabel background;
    JLabel annuler;
    JList<String > list_partie;
	String[] tab_partie;
	
	public Reprend_partie()
	{
		
		
    
        set_fenetre_propri�te();
        ok.addMouseListener(new MouseAdapter() {
        	
        	public void mouseEntered(MouseEvent i)
        	{
        		
        		ok.setIcon(new ImageIcon("media/Fenetre_chargement/ok_rep_2.png"));
        	}
        	public void mouseExited(MouseEvent i)
        	{
        		
        		ok.setIcon(new ImageIcon("media/Fenetre_chargement/ok_rep_1.png"));
        	}
        	
        	public void mouseClicked(MouseEvent y)
        	{
        		
        		if( list_partie.getSelectedIndex()>=0)
            	{
            		try {
						restaurer(list_partie.getSelectedValue());
						dispose();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
            		
            	}
          
        	}
		});
        
       annuler.addMouseListener(new MouseAdapter() {
        	
        	public void mouseEntered(MouseEvent i)
        	{	
        		annuler.setIcon(new ImageIcon("media/Fenetre_chargement/annuler_rep_2.png"));
        	}
        	public void mouseExited(MouseEvent i)
        	{	
        		annuler.setIcon(new ImageIcon("media/Fenetre_chargement/annuler_rep_1.png"));
        	}
        	public void mouseClicked(MouseEvent t)
        	{
        		dispose();
        		Jeu nouv_chois=new Jeu();
        		
        		
        	}
		}); 
        
        
        
        
        partie_deja_sauvegarder();
        set_list_partie_propri�te();
        background.add(list_partie);
        setTitle("Charger patie");
		setVisible(true);

	}
	
	public void set_list_partie_propri�te()
	{
		  list_partie=new JList<String>(tab_partie);
	        list_partie.setBackground(Color.BLACK);
	        list_partie.setForeground(Color.white);
	        list_partie.setBounds(29, 98, 174, 235);
	        list_partie.setFont(new Font("Arial",Font.PLAIN,20));
		
	
	}
	
	
	public void set_fenetre_propri�te()
	{
		setSize(new Dimension(235,415));
		setLocationRelativeTo(null);
		setResizable(false);
		 background=new JLabel();
         background.setIcon(new ImageIcon("media/Fenetre_chargement/fen_chargement.png"));
         setContentPane(background);
         ok=new JLabel();
         annuler=new JLabel();
         ok.setIcon(new ImageIcon("media/Fenetre_chargement/ok_rep_1.png"));
         annuler.setIcon(new ImageIcon("media/Fenetre_chargement/annuler_rep_1.png"));
         background.setLayout(null);
         annuler.setBounds(120, 343, 95, 43);
         ok.setBounds(20, 343, 90, 43);
         background.add(ok);
         background.add(annuler);
	}
	
	
	
	
	public void restaurer(String NomJoueur) throws FileNotFoundException, IOException
	{    Partie part;
	     Serialisation ser3;
	     ObjectInputStream in;
	     in = new ObjectInputStream( new BufferedInputStream(new FileInputStream(new File("fichier/Partie/"+NomJoueur+".dat"))));
	     try 
	     {
	       ser3=(Serialisation) in.readObject();
	       in.close();
	   	part=new Partie("", false, ser3);
	     } 
	     catch (ClassNotFoundException e) {e.printStackTrace();}
	     catch (IOException e) {e.printStackTrace();}

	
	}
	
	
	public void partie_deja_sauvegarder()
	{   String mom_fichier;
		  File j=new File("fichier/Partie");
		  tab_partie=j.list();
		 
	  
		  for (int k=0;k<tab_partie.length;k++)
		  {	 
		  mom_fichier=tab_partie[k].substring(0, tab_partie[k].length()-4);
		  tab_partie[k]=mom_fichier;	  
		  }
		
		
	}
	
	
	
}