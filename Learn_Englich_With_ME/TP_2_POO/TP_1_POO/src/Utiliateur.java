import javax.swing.*;
import javax.imageio.*;

import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.util.Hashtable;


public class Utiliateur extends JFrame implements Serializable{
	

	
	
	JLabel backgroung;
	JLabel ok;
	JLabel annuler;
	JTextField nom_util;
	Serialisation p;

	public Utiliateur()
	{ 
	  backgroung=new JLabel();
	  backgroung.setIcon(new ImageIcon("media/utilisateur_nom/background.png"));
	  backgroung.setLayout(null);
	  p=new Serialisation();
	 
	  nom_util= new JTextField();     
	  ok=new JLabel();
	  ok.setIcon(new ImageIcon("media/utilisateur_nom/lancer1.png"));
	  annuler=new JLabel();
      annuler.setIcon(new ImageIcon("media/utilisateur_nom/annuler1.png"));
      ok.setBounds(245, 78, 90, 47);
      annuler.setBounds(340,79, 91, 47);
      nom_util.setBounds(23, 85, 176, 33);
      nom_util.setBackground(Color.black);
      nom_util.setForeground(Color.white);
      nom_util.setFont(new Font("Arial", Font.BOLD, 16));
    
	  ok.addMouseListener(new MouseAdapter() {
		  
		  public void mouseEntered (MouseEvent v)
		  {
			  ok.setIcon(new ImageIcon("media/utilisateur_nom/lancer2.png"));
			  
		  }
		  
		  
		  public void mouseClicked(MouseEvent v)
		  {   if(!nom_util.getText().isEmpty())
		      {
			   dispose();
			   Partie j=new Partie(nom_util.getText(),true,p);
			  }
		  }
		  
		  public void mouseExited (MouseEvent v)
		  {
			  ok.setIcon(new ImageIcon("media/utilisateur_nom/lancer1.png"));
		  }
		  
		  
	});
	  
	  
	  
	  
  annuler.addMouseListener(new MouseAdapter() {
		  
		  public void mouseEntered (MouseEvent v)
		  {
			  annuler.setIcon(new ImageIcon("media/utilisateur_nom/annuler2.png"));
			  
		  }
		  
		  public void mouseClicked (MouseEvent v)
		  {   
			  dispose();
			  Jeu ch=new Jeu();
			  
		  }
		  
		  public void mouseExited (MouseEvent v)
		  {
			 
			  annuler.setIcon(new ImageIcon("media/utilisateur_nom/annuler1.png"));
		  }
		  
		  
	});
	  
	  
	  setTitle("Nom du joueur");
	  setSize(445, 170);
	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);           //paramètre du fenetre 
	  setResizable(false);
	  setLocationRelativeTo(null);
	  setContentPane(backgroung);
	  backgroung.add(ok);
	  backgroung.add(annuler);
	  backgroung.add(nom_util);
	  
	  setVisible(true);
	}
	

	


	}
	


	
	
	
	
	

