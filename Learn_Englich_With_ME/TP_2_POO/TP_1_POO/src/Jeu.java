import javax.imageio.ImageIO;
import javax.swing.*;

//import Chois_Image.Boutton_dem;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

public class Jeu extends JFrame implements Serializable  {
	
	Chois_Image pan;
	
	
	public Jeu()
	{
	
		 pan=new Chois_Image();
         JLabel background=new JLabel();
         background.setIcon(new ImageIcon("media/backgrounf_fenetre_demarage12.gif"));
         background.setLayout(null);
         background.add(pan);
         pan.setBounds(440, 78, 200, 300);
		 setTitle("LEARN ENGLISH");
		 setSize(641, 410);
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setContentPane(background);
		setVisible(true);
	}
	
	
	
	
	
	public class Chois_Image  extends JLabel {
		JPanel pan1;
		
		
		JLabel nouv_partie;
		JLabel repr_partie;
		JLabel meill_score;
		JLabel quitter;
		public Chois_Image()
		{   pan1=new JPanel();
	           
	       setLayout(new FlowLayout());

	       nouv_partie =new JLabel();
	       nouv_partie.setIcon(new ImageIcon("media/Demarage_fen/nouvelle_partie1.png"));
		   nouv_partie.setPreferredSize(new Dimension(190,54));
		   nouv_partie.addMouseListener(new MouseAdapter() {
			   public void mouseEntered (MouseEvent ev) {
				   
				   nouv_partie.setIcon(new ImageIcon("media/Demarage_fen/nouvelle_partie2.png"));
			                                            }
			   
			   
	   public void mouseExited (MouseEvent ev) 
	   {
		   nouv_partie.setIcon(new ImageIcon("media/Demarage_fen/nouvelle_partie1.png"));
			   
	  }
	   
	   public void mouseClicked(MouseEvent v)
	   {   
		   Jeu.this.dispose();
		  Utiliateur ut=new Utiliateur();

	   }
	   
	   
	   });
	  
		   
		  

		 
		   
		 repr_partie =new JLabel();
		 repr_partie.setIcon(new ImageIcon("media/Demarage_fen/reprendre_partie1.png"));
		 repr_partie.setPreferredSize(new Dimension(190,54));
		 repr_partie.addMouseListener(new MouseAdapter() 
		         {
			   
			 
			         public void mouseEntered (MouseEvent ev) 
			         {
				   
			        	 repr_partie.setIcon(new ImageIcon("media/Demarage_fen/reprendre_partie2.png"));
			       	}
			     
			         
			         public void mouseExited (MouseEvent ev) {
						   
						   repr_partie.setIcon(new ImageIcon("media/Demarage_fen/reprendre_partie1.png"));
					   }
			         
			         public void mouseClicked(MouseEvent p)
			         {   dispose();
			        	 Reprend_partie part=new Reprend_partie();
	 
			         }
			         
			         
		         
		         });

		   
	           
	           
	           
		meill_score =new JLabel();
		 meill_score.setIcon(new ImageIcon("media/Demarage_fen/meilleur_score 1.png"));
		meill_score.setPreferredSize(new Dimension(190,54));
		meill_score.setLocation(100, 260);
		meill_score.addMouseListener(new MouseAdapter() 
		{
			   public void mouseEntered (MouseEvent ev) 
			   {
				   
				   meill_score.setIcon(new ImageIcon("media/Demarage_fen/meilleur_score2.png"));
			   }
			   
		
		   public void mouseExited (MouseEvent ev)
		   {
				   
			   meill_score.setIcon(new ImageIcon("media/Demarage_fen/meilleur_score 1.png"));
			   }
			   
		   public void mouseClicked (MouseEvent ev)
		   {
				   Joueur joueur2=new Joueur("mahdaoui",70);
				Meilleur_score k=new Meilleur_score(true,joueur2);  
			   
			   }   
			   
		
		});

		   
	     
		
		
			quitter =new JLabel();
			 quitter.setIcon(new ImageIcon("media/Demarage_fen/quitter1.png"));
			quitter.setPreferredSize(new Dimension(190,54));
			quitter.setLocation(100, 340);
			quitter.addMouseListener(new MouseAdapter() 
			{
				   public void mouseEntered (MouseEvent ev)
				   {
					   
					   quitter.setIcon(new ImageIcon("media/Demarage_fen/quitter2.png"));
				   }
				   public void mouseClicked (MouseEvent ev)
				   {
					   
					  Jeu.this.dispose();
				   }
			
	            public void mouseExited (MouseEvent ev)
	            {
					   
	            	quitter.setIcon(new ImageIcon("media/Demarage_fen/quitter1.png"));
				   }
			
			
			});
	        add(nouv_partie);
	        add(repr_partie);
	        add(meill_score);
	        add(quitter);
	   
		}                   //fin du constructeur
		


}
};