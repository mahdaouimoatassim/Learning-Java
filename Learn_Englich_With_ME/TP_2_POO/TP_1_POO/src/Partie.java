
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.MaskFormatter;

//simport FenetreImage.OkButton;

//import Jeu.fen_ques_def.Text_1;
//import Jeu.fen_ques_image.bonne_reponse;
//import Jeu.fen_ques_image.movaisse_reponse;

//import Jeu.Boutton_jeu;
//import Jeu.Boutton_quitter;

//import Plateau.Case_bonus;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.sql.Time;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;

public class Partie extends JFrame implements ActionListener {
  Plateau plat;
  int sec=0;
  int min=0;
  int z=0;
  int nombre_animation_d�=0;
  String Chrono;
  int position_pr�cedente=1;
  int heure=0;
  Timer time;
  Timer time1; 
  //Joueur j2;
  //boolean vrai=true;
  String[]  type_case={"case_depart","case_bonus","case_malus","case_saut","question_image","question_d�finition","case_fin","case_parcourt"};
  private  int Position_joueur=1;
    JLabel ls;
  /*  public static int n_case_saut;
    public static int n_case_bonus;
    public static int n_case_malus;
    public static int n_case_question;*/
    JLabel timer_zone;
    JLabel timer_zone1;
    JLabel ln;
    JLabel lw;
    JLabel l1;
    JLabel nouvelle_partie;                                  //
	 JLabel reprendre_partie;                                //
	 JLabel Meilleur_score;							 // declaration des bouttons
	JLabel suspendre_partie;	
	JLabel score_joueur;//
	 JLabel quitter;	
	 boolean entre=false;
	 JLabel Indication;
	 JLabel partie2;
	 JLabel joueur_text;
	 JLabel score_text;
	 JLabel zone_pn ;
	 JLabel zone_gauche_l ;                                     //
	 JLabel zone_bat_l ;                                       //      d�claration des zones d'images 
	 JLabel zone_bat_l1 ;                                     // 
	 JLabel zone_d�_1 ; 
	 JLabel zone_d�_2 ; 
	 JLabel zone_haut_l ;
	 JLabel zone_pnl ; 
	 JLabel lancer_de;
	 
	
	 ImageIcon image_de_1;
	 ImageIcon image_de_2;	                               	                              // declaration des images
	ImageIcon quitter_icon;                           //
	ImageIcon zone_centre;
	 
transient static int o;
    
    
    public 	D� de_1;
    public 	D� de_2;
    public Joueur j1;
	public Partie (String nom_util,boolean nouv_par,Serialisation s) 
	{   
		set_fenetre_propri�t�();
		time =new Timer(1000, this);
		time.start();
		//time1 =new Timer(100, new timer());
		//time1.start();
		ls=new JLabel();
		ln=new JLabel();
		lw=new JLabel();
		l1=new JLabel();
		de_1=new D�();
		de_2=new D�();
	    j1=new Joueur(nom_util, 0);
		 if (nouv_par==false)
		 {
			 j1=s.j5;
			 Position_joueur=s.position;
			 
		 }
		 
		 
		//ls.setIcon(new ImageIcon("media/plateau_bat.png"));
		ls.setPreferredSize(new Dimension(777,22));
		//ln.setIcon(new ImageIcon("media/plateau_haut.png"));
		ln.setPreferredSize(new Dimension(785,22));
		//lw.setIcon(new ImageIcon("media/plateau_gh.png"));
		 lw.setPreferredSize(new Dimension(84,499));
		plat=new Plateau(nouv_par,s.k);
		plat.setVisible(true);
		partie2=new JLabel();
		partie2.setLayout(new BorderLayout());
		partie2.add(lw,BorderLayout.WEST);
		partie2.add(l1,BorderLayout.CENTER);
		l1.setLayout(new BorderLayout());
		l1.add(ls,BorderLayout.SOUTH);
		l1.add(ln,BorderLayout.NORTH);
		l1.add(plat,BorderLayout.CENTER);
		//Partie.this.plat.dessiner_annimation1(Position_joueur-1); 
		
		
		initialisation_boutton_menu();
		////////////////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////////////////
		Indication=new JLabel();
		Indication.setFont(new Font("Arial",Font.BOLD,16));
		Indication.setForeground(Color.white);
	    	  //	
		     //
 			//  initialisation des images
		  zone_centre=new ImageIcon("media/Center.png");												   //
		  quitter_icon=new ImageIcon("media/enregistrer_partier.png");									  //
	     zone_pn =new JLabel();
		 zone_gauche_l = new JLabel();	//la zone gauche du fenetre 																		//
		 zone_bat_l =new JLabel();		//la zone bat du fenetre 																		   //
		 zone_bat_l1 =new JLabel();		//la zone gauche de la zone bat 																  //initialisation des zones d'images														   			 //
		 zone_haut_l = new JLabel();	//	la zone haut du fenetre 																	//
		 zone_pnl =new JLabel();          // la zone centre du fenetre
		 zone_pnl.setIcon(new ImageIcon("media/center.png"));
		  JLabel zone_util_inf =new JLabel();  
		 zone_bat_l.setIcon(new ImageIcon("media/bare_bas.png"));                //
		// zone_bat_l.setPreferredSize(new Dimension());
		 zone_gauche_l.setIcon(new ImageIcon("media/bare_gauche.png")); 		  //  attribuer les images a leurs zones
		 zone_haut_l.setIcon(new ImageIcon("media/bare_haut.png"));			  //
		 zone_pn.setLayout(new BorderLayout());      // d�finir le layout du fenetre principale
		 setContentPane(zone_pn);
	/////////////////----------------------ajou des boutton du menu	 
		 zone_pn.add(zone_gauche_l,BorderLayout.WEST);
		 zone_gauche_l.setLayout(new FlowLayout());
		 JLabel o=new JLabel();
		 o.setPreferredSize(new Dimension(160,3));
		 zone_gauche_l.add(o);
		 zone_gauche_l.add(nouvelle_partie);
		 zone_gauche_l.add(reprendre_partie);     										 
		 zone_gauche_l.add(suspendre_partie);
		 zone_gauche_l.add(Meilleur_score);
		 zone_gauche_l.add(score_joueur);
		 zone_util_inf.setPreferredSize(new Dimension(215,66));
	    	/////////////////-----------------------------------------------------------------------//////////////////////////// 
		 /////////////// affichage du zone du non de joueur -------------------------------------------------////////////////
		 joueur_text=new JLabel();
		 joueur_text.setPreferredSize(new Dimension(120,30));
		 JLabel k=new JLabel();
		 k.setPreferredSize(new Dimension(280,22));
		 score_text=new JLabel();
		 score_text.setPreferredSize(new Dimension(40,50));		
		 joueur_text.setForeground(Color.white);
		 score_text.setForeground(Color.white);
		 joueur_text.setFont(new Font("Arial", Font.BOLD, 18));
		 score_text.setFont(new Font("Arial", Font.BOLD, 18));		
		 joueur_text.setText(j1.nom);	
		 score_text.setText(String.valueOf(j1.Score));
		 timer_zone =new JLabel();
		 timer_zone1 =new JLabel();
		 timer_zone1.setLayout(null);
		 timer_zone1.setPreferredSize(new Dimension(150,40));
		 JLabel imagechrono=new JLabel();
		 imagechrono.setIcon(new ImageIcon("media/chrono.png"));
		 
		 timer_zone1.add(imagechrono);
		 imagechrono.setBounds(0, 0, 41, 40);
		 timer_zone1.add(timer_zone);
		 timer_zone.setBounds(40, 0, 90, 40);
		 timer_zone.setFont(new Font("Arial", Font.BOLD, 18));
		 timer_zone.setForeground(Color.white);
		 JLabel v=new JLabel();
		 v.setPreferredSize(new Dimension(200,15));
		 
		 zone_gauche_l.add(zone_util_inf);
		 zone_gauche_l.add(joueur_text);
		 zone_gauche_l.add(k);
		 zone_gauche_l.add(score_text);
		 zone_gauche_l.add(v);
		 zone_gauche_l.add(timer_zone1);
		 //////////////////////////////////////////////////////////////////////-----------------------------------------------------
		 zone_pn.add(zone_pnl,BorderLayout.CENTER);
		 zone_pnl.setLayout(new BorderLayout()); 
		 zone_pnl.add(zone_haut_l,BorderLayout.NORTH);
		 zone_pnl.add(zone_bat_l,BorderLayout.SOUTH);
		 zone_pnl.add(partie2,BorderLayout.CENTER);
		 //////////////////////////////////******zone des d�s-------------------------------------------------/
		 //-------------------------------------------------------------------------------------------------------------------
		 ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		 /////////////////////-------------------------------------------- la zone du boutton quitter 
		 //zone_bat_l1.setIcon(zone_bat_1);
		
	//	 timer_zone.setText("dcvfdgb");
		 zone_bat_l1.setPreferredSize(new Dimension(650,72));
		 zone_bat_l.setLayout(null);         //
		// zone_bat_l.add(zone_bat_l1);
		 //zone_bat_l1.setLayout(null);
		 zone_bat_l.add(Indication);
		 //zone_bat_l.add(timer_zone);
		 Indication.setBounds(200,15,400,50);
		// Indication.setForeground(Color.white);
		 Indication.setText("lancer les D� pour commencer ta partie");
		 quitter.setIcon(new ImageIcon("media/button_quitter.png"));
		 zone_bat_l.add(quitter);
		 quitter.setBounds(700, 18, 141, 40);
		 quitter.addMouseListener(new MouseAdapter() {
			 
			 public void mouseEntered(MouseEvent v)
			 {    	
				 quitter.setIcon(new ImageIcon("Media/button_quitter2.png"));
			 }
			 public void mouseClicked(MouseEvent v)
			 {    
				 dispose();
			 }
			 public void mouseExited(MouseEvent v)
			 {    				 
				 quitter.setIcon(new ImageIcon("Media/button_quitter.png"));
				 
			 } 
		});
		 
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		 
		 traitement_d�();
		 
		 
		 nouvelle_partie.addMouseListener(new MouseAdapter() 
			{
				   public void mouseEntered (MouseEvent ev) 
				   {                                                                         
					   
					nouvelle_partie.setIcon(new ImageIcon("Media/nouvelle_2.png"));
				   }
				   
				   public void mouseClicked (MouseEvent ev) 
				   {                                                                
					  dispose();
					  Utiliateur nouv_uti=new Utiliateur();
				   }
			
			   public void mouseExited (MouseEvent ev)
			   {
					   
					  
				   
				   nouvelle_partie.setIcon(new ImageIcon("Media/nouvelle_1.png"));
			   }
			
			});
		  
		 reprendre_partie.addMouseListener(new MouseAdapter() 
			{
				   public void mouseEntered (MouseEvent ev) 
				   {
					   reprendre_partie.setIcon(new ImageIcon("Media/ouvrir_partie1.png"));
					   																				 //
				   }																					 //
				   
			
			   public void mouseExited (MouseEvent ev)
			   {
					   
				   reprendre_partie.setIcon(new ImageIcon("Media/ouvrir_partie.png"));
				   }
				   
				  public void mouseClicked(MouseEvent y) 
				  {
					  dispose();
					  
					  Reprend_partie par=new Reprend_partie();  
				  }
			
			});
		 	 
		 Meilleur_score.addMouseListener(new MouseAdapter() 
			{
				   public void mouseEntered (MouseEvent ev) 
				   {   
					   Meilleur_score.setIcon(new ImageIcon("Media//enregistrer_partier1.png"));																			//
				   }																			   //
			   public void mouseExited (MouseEvent ev)
			   {   
				  Meilleur_score.setIcon(new ImageIcon("Media/enregistrer_partier.png"));
				   }
			   public void mouseClicked(MouseEvent p)
			   {   j1.temps=Chrono;
				  // setScore(j1);
				   Meilleur_score l=new Meilleur_score(true,j1);
			   }
			});
	 
		score_joueur.addMouseListener(new MouseAdapter() 
			{
				   public void mouseEntered (MouseEvent ev) 
				   {
					   
					   score_joueur.setIcon(new ImageIcon("Media//score_joueur2.png"));																			//
				   }																			   //
				   
			
			   public void mouseExited (MouseEvent ev)
			   {
					   
				 score_joueur.setIcon(new ImageIcon("Media/score_joueur.png"));
				   }
				   
				   public void mouseClicked(MouseEvent t)
				   {   j1.temps=Chrono;
					   //setScore(j1);
					   Meilleur_score j=new Meilleur_score(false, j1);
				   }
			
			});
		 
		 
		 suspendre_partie.addMouseListener(new MouseAdapter() 
			{
				   public void mouseEntered (MouseEvent ev) 
				   { 
					   																							//
					   suspendre_partie.setIcon(new ImageIcon("Media/suspendre_partie1.png"));																						//
				   }
				   
			
			   public void mouseExited (MouseEvent ev)
			   { 																								//
					   																							//	
				   suspendre_partie.setIcon(new ImageIcon("Media/suspendre_partie.png"));
				   }
				   
				   
				public void mouseClicked(MouseEvent u)
			      {
				
			confirmation_sauvegarder j=new confirmation_sauvegarder();
					
			      }
			
			});
	    
		 setVisible(true);          // rendre la fenetre visible 
		//////////////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////
		
		
	}	
	/*************************************************************************************************************/
	
	public void initialisation_boutton_menu()
	{
		 nouvelle_partie=new JLabel();                       //
	     nouvelle_partie.setIcon(new ImageIcon("media/nouvelle_1.png"));
		 reprendre_partie=new JLabel();	
		 reprendre_partie.setIcon(new ImageIcon("media/ouvrir_partie.png"));                                                                         //initialisation des bouttons 
	     Meilleur_score=new JLabel();				   //
	     Meilleur_score.setIcon(new ImageIcon("media/enregistrer_partier.png"));  
		 suspendre_partie=new JLabel();					  //
		 suspendre_partie.setIcon(new ImageIcon("media/suspendre_partie.png"));  
		 score_joueur=new JLabel();
		 score_joueur.setIcon(new ImageIcon("Media/score_joueur.png"));
		 quitter=new JLabel();
		 nouvelle_partie.setPreferredSize(new Dimension(159,50));			//
		 reprendre_partie.setPreferredSize(new Dimension(159,49));          //    definir la taille des bouttons 
		 Meilleur_score.setPreferredSize(new Dimension(159,49));		//
		 suspendre_partie.setPreferredSize(new Dimension(159,49));			//
		 score_joueur.setPreferredSize(new Dimension(159,49));	
	}
	/********************************************************************************************************/
	public void set_position(int i)
	{
		Position_joueur=i;
		
	}
	/************************************************************************************************************/
	public void set_fenetre_propri�t�()
	{
		setSize(1100, 700);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		
	}
	/*******************************************************************************************************/
	public void annimation_d�()
	{ 
		time1 =new Timer(50, new timer());
	
	     time1.start();
	
	}
	
	/***************************************************************************************************/
	
	public void decouper_chaine(String temps)
	{
		
		String[]  tab_temp;
	
	tab_temp=temps.split(":");
	heure=Integer.parseInt(tab_temp[0]);
	min=Integer.parseInt(tab_temp[1]);
	z=Integer.parseInt(tab_temp[2]);		
  		
		
		
		
	}
	
	
	
	
	
	/****************************************************************************************************************/
	
	public void annimation_joueur(int position1,int position2)
	{
		if (position1<position2)
		{
		for(int i=position1;i<position2;i++)
		{
			plat.tab_cas1.get(i).dessiner_image_joueur=false;
			plat.tab_cas1.get(i).repaint();
			plat.tab_cas1.get(i+1).dessiner_image_joueur=true;
			plat.tab_cas1.get(i+1).repaint();
			try{
			Thread.sleep(200);}
			catch (InterruptedException u)
			{
				u.printStackTrace();
			}
		}
			
			
		}
		else if(position1>position2)
		{
			
		}
		
		
		
		
	}
	
	
	
	
	/**********************************************************************************************************/
	
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if (z>=60)
		{
			z=z%60;
			sec=z;
			min+=1;
			if (min >=60)
			{	
			min =min%60;
			heure+=1;
			}
			}
		sec=z;
		if(heure<10) Chrono ="0"+heure+":";
		else  Chrono=""+heure+":"; 
		if(min<10) Chrono +="0"+min+":";
		else  Chrono+=""+min+":";
		if(sec<10) Chrono +="0"+sec;
		else  Chrono+=""+sec;
		timer_zone.setText(Chrono);
		z++;		
	}
	
	
	/*************************************************************************************************************/
	   public void Sauvegarder(String NomJoueur) throws FileNotFoundException, IOException
	   {
		   Serialisation n=new Serialisation() ;
		   j1.temps=Chrono;
	       n.set_attribus(plat.tab_cas2, j1, Position_joueur);
	       ObjectOutputStream out;
	   try 
	   {
	     out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("fichier/Partie/"+NomJoueur+".dat"))));
	     out.writeObject(n);
	     out.close();   
	   } 
	   catch (FileNotFoundException e) {e.printStackTrace();} 
	   catch (IOException e) {e.printStackTrace();}
	 }
	/*************************************************************************************************/
	   

			
	
	public void traitement_d�()
	{
		
		JLabel i=new JLabel();
		 i.setPreferredSize(new Dimension(250,10));
		 image_de_1=new ImageIcon("media/Fen_d�/de1.png");
		 image_de_2=new ImageIcon("media/Fen_d�/de1.png");
		 zone_d�_1=new JLabel();
		 zone_d�_2=new JLabel();
		 zone_d�_2.setIcon(image_de_2);
		 zone_d�_1.setIcon(image_de_1);
		 zone_gauche_l.add(i);
		 zone_gauche_l.add(zone_d�_1);
		 zone_gauche_l.add(zone_d�_2);
		 
		 
		 lancer_de=new JLabel();
		 lancer_de.setIcon(new ImageIcon("media/Fen_d�/lance_d�1.png"));
		 zone_gauche_l.add(lancer_de);
		
		 lancer_de.addMouseListener(new MouseAdapter() {
			 
			 public void mouseEntered(MouseEvent v)
			 {    
				 
				 
				 lancer_de.setIcon(new ImageIcon("media/Fen_d�/lance_d�2.png"));
			 }
			 public void mouseExited(MouseEvent v)
			 {    
				 
				 
				
				 lancer_de.setIcon(new ImageIcon("media/Fen_d�/lance_d�1.png"));
			 }
			 public void mouseClicked(MouseEvent v)
			 {    
				if ((de_1.lancer==true) &&  (de_2.lancer==true))
				{
				    annimation_d�();
			/*	    de_1.lancer=false;
				    de_1.valeur_d�();
				    image_de_1= de_1.img2;
				    zone_d�_1.setIcon(image_de_1);  
				    de_2.lancer=false;
					de_2.valeur_d�();
				    image_de_2= de_2.img2;
				    zone_d�_2.setIcon(image_de_2); 
				    int r=get_position()+de_1.valeur+de_2.valeur;
				    if (r<100)
				    {set_position(r);}
				    else {set_position(100-(r%100));}
				    Indication.setText("vous devez clicker sur la case n "+get_position());*/
				    
				 }
			 }
			 
		});
		
	}
/**************************************************************************************************************/	   
	public int get_position()
	{
		
		return Position_joueur;
	}
/*************************************************************************************************************/
	
	
	//***************************************************************************
    public void setScore(Joueur joueur)
    {
        ArrayList <Joueur> MeilleursScores = new ArrayList<Joueur>();
        //*************************************************************
      
       ObjectInputStream in=null;
       try 
       { 
           in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("fichier/Meilleur_score/Meilleurs Scores.dat"))));
           MeilleursScores=(ArrayList<Joueur>) in.readObject(); in.close(); 
       } catch (IOException e) {}
       catch (ClassNotFoundException e) {}
       finally   
       {
          MeilleursScores.add(joueur);
          
          Collections.sort(MeilleursScores);
          ObjectOutputStream out=null;
          try 
         {
          out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("fichier/Meilleur_score/Meilleurs Scores.dat"))));
          out.writeObject(MeilleursScores);
          
          out.close();   
         } 
         catch (FileNotFoundException e) {} 
         catch (IOException e) {e.printStackTrace();}
       }
        

        //*************************************************************   
       }
/*****************************************************************************************************************/	
/*	public void paintComponent(Graphics g)
	{ System.out.println("dsfb");
		plat =new Plateau();
		
	}*/
	public class Plateau  extends JLabel  {
	    
		public ImageIcon fond;
		public boolean nouv_par=true;
		public Case tab_cas[];
		public String mout="hljplk";
		public Hashtable<Integer, Case>  tab_cas1=new Hashtable<Integer,Case>();
		public Hashtable<Integer, String>  tab_cas2=new Hashtable<Integer,String>();
	public 	Plateau(boolean nouv,Hashtable<Integer, String> j)  
	{  
        nouv_par=nouv;	   
	    setPreferredSize(new Dimension(780,462));
		tab_cas=new Case[100];
		setLayout(new GridBagLayout());
		GridBagConstraints c=new GridBagConstraints();
		if(nouv_par==true)	{  generer_tab_aleatoire();     }
		else { generer_tab_reprend(j) ;
		
		//System.out.println(Partie.this.j1.temps);
		Partie.this.decouper_chaine(Partie.this.j1.temps);
		}

		for(int i=0;i<100;i++)
		{ 
			
			// tab_cas[i]= generer_case(i);
		//	tab_cas[i]=new Case_depart();
			if (i<17)
			{ c.fill=GridBagConstraints.BOTH ;
			  c.gridx=i*4;
			  c.gridy=0;
			  c.weightx=4.0;
			  c.weighty=4.0;
			  tab_cas1.get(i).set_vnumero(i+1);
			add(tab_cas1.get(i),c);
			}
			if((i>=17)&&(i<27))
			{c.fill=GridBagConstraints.BOTH ;
			  c.gridx=16*4;
			  c.gridy=i*4-16*4;
			  tab_cas1.get(i).set_vnumero(i+1);
			  add(tab_cas1.get(i),c);
			}
			if((i>=27)&&(i<42))
			{c.fill=GridBagConstraints.BOTH ;
			  c.gridx=42*4-i*4;
			  c.gridy=10*4;
			  tab_cas1.get(i).set_vnumero(i+1);
			  add(tab_cas1.get(i),c);
			}
			
			
			if((i>=42)&&(i<51))
			{c.fill=GridBagConstraints.BOTH ;
			  c.gridx=0;
			  c.gridy=52*4-i*4;
			  tab_cas1.get(i).set_vnumero(i+1);
			  add(tab_cas1.get(i),c);
			}
			
		
			if((i>=51)&&(i<65))
			{c.fill=GridBagConstraints.BOTH ;
			  c.gridx=i*4-50*4;
			  c.gridy=2*4;
			  tab_cas1.get(i).set_vnumero(i+1);
			  add(tab_cas1.get(i),c);
			}
			
			if((i>=65)&&(i<71))
			{c.fill=GridBagConstraints.BOTH ;
			  c.gridx=14*4;
			  c.gridy=i*4-62*4;
			  tab_cas1.get(i).set_vnumero(i+1);
			  add(tab_cas1.get(i),c);
			}
			
			if((i>=71)&&(i<83))
			{c.fill=GridBagConstraints.BOTH ;
			  c.gridx=84*4-i*4;
			  c.gridy=8*4;
			  tab_cas1.get(i).set_vnumero(i+1);
			  add(tab_cas1.get(i),c);
			}
		
			
			if((i>=83)&&(i<86))
			{c.fill=GridBagConstraints.BOTH ;
			  c.gridx=2*4;
			  c.gridy=90*4-i*4;
			  tab_cas1.get(i).set_vnumero(i+1);
			  add(tab_cas1.get(i),c);
			}
		
			if((i>=86)&&(i<96))
			{c.fill=GridBagConstraints.BOTH ;
			  c.gridx=i*4-84*4;
			  c.gridy=4*4;
			  tab_cas1.get(i).set_vnumero(i+1);
			  add(tab_cas1.get(i),c);
			}			
			if((i>=96)&&(i<98))
			{c.fill=GridBagConstraints.BOTH ;
			  c.gridx=12*4;
			  c.gridy=i*4-92*4;
			  add(tab_cas1.get(i),c);
			}
			if((i>=98)&&(i<100))
			{c.fill=GridBagConstraints.BOTH ;
			  c.gridx=110*4-i*4;
			  c.gridy=6*4;
			  add(tab_cas1.get(i),c);
			}
			
			
		}  
		//add(pan);
		 
		
	}
	///////////////////////////////////////////////////////
	///////////////////////////////////////////////////////    generation aleatoire du tableau
	public void generer_tab_aleatoire()
	{int k=0;
	
	tab_cas1.put(0, new Case_depart(k+1));
	tab_cas2.put(0, type_case[0]);
	tab_cas1.put(99, new Case_fin(k+1));
	tab_cas2.put(99, type_case[6]);
	
		for (int i=0;i<5;i++)
		{
			
			while(tab_cas1.containsKey(k))
			{
				k=random_m(97,10);
				
			}
			try{
			
			tab_cas1.put(k, new Case_bonus(k+1));}
			catch
			(Exception1 o)
			{ o.afficher();
				o.printStackTrace();
			}
			 tab_cas2.put(k, type_case[1]);	
		}
		for (int i=0;i<5;i++)
		{
			k=random_m(97, 10);
			while(tab_cas1.containsKey(k))
			{
				k=random_m(97,10);		
			}
			tab_cas1.put(k, new Case_suat(k+1));
			tab_cas2.put(k, type_case[3]);
			
		}
		for (int i=0;i<5;i++)
		{
			k=random_m(97, 10);
			while(tab_cas1.containsKey(k))
			{
				k=random_m(97, 10);	
			}
			tab_cas1.put(k, new Question_d�finition(k+1));
			tab_cas2.put(k, type_case[5]);
			
		}
		for (int i=0;i<5;i++)
		{
			k=random_m(97, 10);
			while(tab_cas1.containsKey(k))
			{
				k=random_m(97, 10);  
			}
			tab_cas1.put(k, new Case_malus(k+1));
			tab_cas2.put(k, type_case[2]);
			
		}
		for (int i=0;i<5;i++)
		{
			k=random_m(97, 10);
			while(tab_cas1.containsKey(k+1))
			{
				k=random_m(97, 10);
			}
			tab_cas1.put(k, new Question_image(k+1));	
			tab_cas2.put(k, type_case[4]);
			
		}
		
		for (int i=1;i<99;i++)
		{
			//tab_cas1.put(i, new Case_parcourt());
			
			if(!tab_cas1.containsKey(i))
			{		tab_cas1.put(i, new Case_parcourt(i+1));
			        tab_cas2.put(i, type_case[7]);
			
			}
		
		}
	    }	
	public void generer_tab_reprend(Hashtable<Integer, String> e)
	{ //Hashtable<Integer,String> e=new Hashtable<Integer,String> ();
	/*Serialisation u=new Serialisation();
	ObjectInputStream in;
	
	
	try{
		in=new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("data.dat"))));
	   
		u=(Serialisation )in.readObject();
		 //System.out.println(in.readInt());
		// System.out.println(in.readInt());
		 //System.out.println(in.readInt());
	//	u=(Serialisation )in.readObject();
		
	}catch(FileNotFoundException y)
	{           y.printStackTrace();}
	catch(ClassNotFoundException o)
	{      o.printStackTrace();}
	catch(IOException s)
	{  s.printStackTrace();   }
		
	e=u.k;*/
		String type="";
		tab_cas2=e;
		for(int a=0;a<100;a++)
		{  type=e.get(a);
		//System.out.println(a);
			switch(type)
			{
			case "case_depart" : tab_cas1.put(a, new Case_depart(1));
			break;
			case "case_bonus" : try{tab_cas1.put(a, new Case_bonus(a+1));}catch(Exception1 n){n.printStackTrace();}
			break;
			case "case_malus" : tab_cas1.put(a, new Case_malus(a+1));
			break;
			case "case_saut" : tab_cas1.put(a, new Case_suat(a+1));
			break;
			case "case_parcourt" : tab_cas1.put(a, new Case_parcourt(a+1));
			break;
			case "question_image" : tab_cas1.put(a, new Question_image(a+1));
			break;
			case "question_d�finition" : tab_cas1.put(a, new Question_d�finition(a+1));
			break;
			case "case_fin" : tab_cas1.put(a, new Case_fin(100));
			break;
			}	
		}	
	}
	
	/////////////////////////////////////////////
	///////////////////////////////////////////////donner un entier entre deux nombre
	
	public  int random_m(int c1/*valeur superieur*/,int c2/*valeur inf�rieur*/)
	
	{
	int k=0,j=0;	
		k=c1-c2;
	j= (int) ((Math.random()*1000)%k);
	j+=c2;
	j++;
	return j;
	}
	
	
	public void dessiner_annimation1(int i)
	{
		
		  try {Thread.sleep(200);}
			catch(InterruptedException u)
			{u.printStackTrace();}
		  
		Partie.this.plat.tab_cas1.get(0).dessiner_annimation_case(true);
		
	}
	
	///////////////////////////////////////////////////////////////
	public void dessiner_annimation(int i,int i1)
	{
		if (i<i1)
		{
			for(int j=i;j<i1;j++)
			{
				
				    Partie.this.plat.tab_cas1.get(j).dessiner_annimation_case(false);
				    Partie.this.plat.tab_cas1.get(j+1).dessiner_annimation_case(true);
				    try {Thread.sleep(200);}
					catch(InterruptedException u)
					{u.printStackTrace();}
			}	
		}
		else if (i>i1)
		{
			for(int j=i;j>i1;j--)
			{
				Partie.this.plat.tab_cas1.get(j).dessiner_annimation_case(false);
			    Partie.this.plat.tab_cas1.get(j-1).dessiner_annimation_case(true);
				
				    try {Thread.sleep(200);}
					catch(InterruptedException u)
					{u.printStackTrace();}
				
			}
		}
		
		
		
		
	}
	
	
	
	/////////////////////////////////////////////////////
	////////////////////////////       la fonction qui p   permet de g�nerer une case al�atoirement 
	
	
/*	public Case  generer_case(int i)
	{  Case j;
		int s=0;

	j=new Case_parcourt();
	    
		   
		   if ((i%2)==0)
		   {
		         int k=( (int)( (Math.random()*100)%4))+1;
		               switch(k)
		             {
		                 case 1: if (n_case_bonus <7) 
		   													{  j=new Case_bonus();
		   														n_case_bonus++;
			  													break;
		                                                     } 
		                 case 2: if (n_case_malus <7) 
		    												{  j=new Case_malus();
		                                                 	  n_case_malus++;
			                                                  break;
		                                                     } 
		   				 case 3: if (n_case_saut<7) 
		   													{  //j=new Case_suat();
		   														n_case_saut++;
			  													break;
		   													} 
		                 case 4: if (n_case_question <14)  	                	 
		                 										{  if((s%2)==0)   j=new Question_d�finition();
		                 											
		                	                                      else  j=new Question_image(); 
		                	                                      n_case_question++;
		                	                                      break;
		                                                      } 
		                  
		              }
		        }

	return j;
	}*/

/*	public void paintComponent(Graphics g)
	{ //System.out.println("dsfb2");
		//plat =new Plateau();
		//repaint();
	}*/	
////////////////////////////////////////////////////
/////////////////////////////////////////////////              Case Depart	
	
	 class Case_depart extends Case  {
		
		public Case_depart(int i)
		{   super(i);	
			addMouseListener(new MouseAdapter() {	
				public void mouseClicked(MouseEvent t)
				{
							if (Partie.this.Position_joueur==numero)
							{
								Partie.this.de_1.lancer=true;
								Partie.this.de_2.lancer=true;
								 zone_d�_1.setIcon(image_de_1); 
								 zone_d�_2.setIcon(image_de_2);  
								Indication.setText("lancer les D�s pour avevcer");
								 image_de_1=new ImageIcon("media/Fen_d�/de1.png");
								 image_de_2=new ImageIcon("media/Fen_d�/de1.png");
							}
							else{
								if((de_1.lancer==false)&&(de_2.lancer==false))
								{
								Indication.setForeground(Color.red);
								Indication.setText("erreur,clicker sur la case n"+get_position());
								Indication.setForeground(Color.white);
								}
							}
				}
			});
		}
		
		
	
		
		public void paintComponent(Graphics g)
		{
		try {
			
			Image img = ImageIO.read(new File("media/case_debut.png"));
		    g.drawImage(img,0, 0, this); String k=""+numero;
		    setForeground(Color.white);
		    g.drawString(k , 28, 32);
		}catch (IOException t)
		{ t.printStackTrace();}}
		

	}

//////////////////////////////////////////
	//////////////////////////////////////       Question Image
	
	public class Question_image extends Case_question {
		FileReader monFichier ;
		int i1,i2,i3,i4;
		ArrayList <String> Mots = new ArrayList<String>(); 
		ArrayList <String> Imgs = new ArrayList<String>();
		public Question_image(int i)
		{
			numero=i;
			////*************************charger les deux tableaux**********************////
			try {
				monFichier = new FileReader("Image.txt");
			 } catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			    
			  BufferedReader br = new BufferedReader(monFichier);
	             String line=null;
	             try {
					while( (line=br.readLine()) != null) {
					        					
					  String[] te=   (line.split("-"));
					  Imgs.add(te[0]);
					  Mots.add(te[1]);
					  }
					  monFichier.close();					  
	             }
				 catch (IOException e1) {
					e1.printStackTrace();
				}
			///********************************************************************///

			addMouseListener(new MouseAdapter() {
				
				public void mouseClicked(MouseEvent r)
				{
					
					if(Partie.this.Position_joueur==numero)
					{
						
                     
						
						
                        dessiner_annimation(position_pr�cedente-1,Position_joueur-1 );
						
						 image_de_1=new ImageIcon("media/Fen_d�/de1.png");
						 image_de_2=new ImageIcon("media/Fen_d�/de1.png");
						 zone_d�_1.setIcon(image_de_1);
						 zone_d�_2.setIcon(image_de_2);  
					Fenetre_image3 img =new Fenetre_image3(); 
				    Choix_Quatres_Images();
					img.image1.setIcon(new ImageIcon(Imgs.get(i1)));
					img.image2.setIcon(new ImageIcon(Imgs.get(i2)));
					img.image3.setIcon(new ImageIcon(Imgs.get(i3)));
					img.image4.setIcon(new ImageIcon(Imgs.get(i4)));	
					 img.val=ChoixMot();
					 if (img.val==i1) img.choix=0; 
					 if (img.val==i2) img.choix=1; 
					 if (img.val==i3) img.choix=2; 
					 if (img.val==i4) img.choix=3; 
					 img.mot.setText(Mots.get(img.val)); 
					 img.setVisible(true);
				     Partie.this.de_1.lancer=true;
					 Partie.this.de_2.lancer=true;
				}else{
						
						if((de_1.lancer==false)&&(de_2.lancer==false))
					{   Indication.setForeground(Color.red);
						Indication.setText("erreur,clicker sur la case n "+get_position());
						Indication.setForeground(Color.white);
					}
					
					}
					
				}

			});
		}
		
		
	
		
		//****************************************chois_image****************************/
		public void Choix_Quatres_Images()
    	{
    		 
    	     i1 = (int) (Math.random()*Imgs.size()-1);
    	    
    		 i2 = (int) (Math.random()*Imgs.size()-1);
    			while (i2 == i1 ){ i2= (int) (Math.random()*Imgs.size()-1);}
    			
    		 i3 = (int) (Math.random()*Imgs.size()-1);
    			while (i3 == i1 || i3==i2 ){ i3= (int) (Math.random()*Imgs.size()-1);}
    			
    		 i4 = (int) (Math.random()*Imgs.size()-1);
    			while (i4 == i1 || i4==i2 || i4==i3 ){ i4= (int) (Math.random()*Imgs.size()-1);}			
    	}
		
		public int ChoixMot()
		{
			int j=0; 
			int i = (int) (Math.random()*3);
			switch (i)
			{
			case 0: j= i1;// System.out.println(i1);
			break; 
			case 1:  j= i2; // System.out.println(i2);
			break; 
			case 2 : j= i3; // System.out.println(i3);
			break; 
			case 3 : j= i4;// System.out.println(i4);
			break;
			}
			return j; 
		}
		public void paintComponent(Graphics g)
		{
		try {
			
			Image img = ImageIO.read(new File("media/question_image.png"));
		    g.drawImage(img,0, 0, this);
		    Image  img2=ImageIO.read(new File("media/image_joueur.png"));
		    g.drawImage(img,0, 0, this);
		   if(dessiner_image_joueur)
		   {
			   g.drawImage(img2, 0, 0, this);
			   
		   }
		    String k=""+numero;
		    setForeground(Color.white);
		    g.drawString(k ,24,30);
		}catch (IOException t)
		{ t.printStackTrace();}}
		
		
	}

	//////////////////////////////////////////////////////////////////          case Question
	////////////////////////////////////////////////////////////////
	public abstract class Case_question extends Case {
		
	}

////////////////////////////////////////////////////
/////////////////////////////////////////////////              Case Malus
	
	
	public class Case_malus extends Case {

		
		
		private final int Bonus=-20 ;
		private final int pos=-2; 
		
		public Case_malus(int i)
		{
			super(i);
			addMouseListener(new MouseAdapter() {
				
				public void mouseClicked(MouseEvent u)
				{
				if(Partie.this.Position_joueur==numero)
				{  
					dessiner_annimation(position_pr�cedente-1,Position_joueur-1 );
					
					image_de_1=new ImageIcon("media/Fen_d�/de1.png");
				    image_de_2=new ImageIcon("media/Fen_d�/de1.png");
				    zone_d�_1.setIcon(image_de_1);
					 zone_d�_2.setIcon(image_de_2);
					position_pr�cedente=Position_joueur;
				    Partie.this.Position_joueur+=pos;
					Partie.this.j1.Score+=Bonus;	
					Indication.setText("vous avez perdu 2 position,allez vers "+get_position());
					score_text.setText(String.valueOf(j1.Score));
				}else{
					if((de_1.lancer==false)&&(de_2.lancer==false))
					{
					Indication.setText("erreur,clicker sur la case n "+get_position());
				    }
					}
				}
			});
			
		}
		
	
		
		public void paintComponent(Graphics g)
		{
		try {
			
			Image img = ImageIO.read(new File("media/case_malus.png"));
		    g.drawImage(img,0, 0, this);
		    Image  img2=ImageIO.read(new File("media/image_joueur.png"));
		    g.drawImage(img,0, 0, this);
		   if(dessiner_image_joueur)
		   {
			   g.drawImage(img2, 0, 0, this);
			   
		   }
		    String k=""+numero;
		    setForeground(Color.white);
		    g.drawString(k , 24, 30);
		}catch (IOException t)
		{ t.printStackTrace();}}
		
	}
	
////////////////////////////////////////////////////
/////////////////////////////////////////////////              Case saut 	
	public class Case_suat extends Case  {

		
		
		public Case_suat(int i)
		{
			super(i);
			addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent t)
				{
					
					if(Partie.this.Position_joueur==numero)
					{ 
						dessiner_annimation(position_pr�cedente-1,Position_joueur-1 );
						image_de_1=new ImageIcon("media/Fen_d�/de1.png");
					    image_de_2=new ImageIcon("media/Fen_d�/de1.png");
						int p=random_m(97, 4);
						
							if(p>Partie.this.Position_joueur)
				           		{   position_pr�cedente=Position_joueur;
									Partie.this.Position_joueur=p;
									System.out.println(Partie.this.Position_joueur);
				              		Indication.setText("avancez vers la case "+get_position());
				              		}
						else if (p<Partie.this.Position_joueur)
								{	position_pr�cedente=Position_joueur;					
									Partie.this.Position_joueur=p;	
					                Indication.setText("reculer vers la case "+get_position());
					                }
					 		else
					 			{position_pr�cedente=Position_joueur;
						 		    Partie.this.Position_joueur+=1;	
						 		    Indication.setText("avancez vers la case "+get_position());
					                }
				     }
					else 
					{
						if((de_1.lancer==false)&&(de_2.lancer==false))
						{
							Indication.setForeground(Color.red);
							Indication.setText("erreur,clicker sur la case n "+get_position());
							Indication.setForeground(Color.white);
						}	
					}
				}	
			});			
		}
		
		public int position()
		{
			return ((int) ((Math.random()*1000)+1) );

		}		
		public void paintComponent(Graphics g)
		{
		try {
			
			Image img = ImageIO.read(new File("media/case_saut.png"));
		    g.drawImage(img,0, 0, this);
		    Image  img2=ImageIO.read(new File("media/image_joueur.png"));
		    g.drawImage(img,0, 0, this);
		   if(dessiner_image_joueur)
		   {
			   g.drawImage(img2, 0, 0, this);
			   
		   }
		    String k=""+numero;
		    setForeground(Color.white);
		    g.drawString(k , 24, 30);
		}catch (IOException t)
		{ t.printStackTrace();}}
	}
	////////////////////////////////////////////////////
	/////////////////////////////////////////////////              Case Parcours
	
	public class Case_parcourt extends Case  {
		Image img,img2;
		//public boolean dessiner_image_joueur=false;
			public Case_parcourt(int i)
			{
				super(i);
				addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent z)
					{int i1=0,i=0;
						if (Partie.this.Position_joueur==numero)
						{						
							
							dessiner_annimation(position_pr�cedente-1,Position_joueur-1 );
							

							 image_de_1=new ImageIcon("media/Fen_d�/de1.png");
						
							 image_de_2=new ImageIcon("media/Fen_d�/de1.png");
							 zone_d�_1.setIcon(image_de_1);
							 zone_d�_2.setIcon(image_de_2);
							Partie.this.de_1.lancer=true;
							Partie.this.de_2.lancer=true;
							Indication.setText("lancez les D�s pour avancer");
						}
						else {
							if((de_1.lancer==false)&&(de_2.lancer==false))
							{
								
							Indication.setForeground(Color.red);	
							Indication.setText("erreur,clicker sur la case n "+get_position());		
							Indication.setForeground(Color.white);
						    }
							}
					}		
				});
			
			}	

			public void paintComponent(Graphics g)
			{
			try {
				
				 img = ImageIO.read(new File("media/blue8.png"));
				 img2=ImageIO.read(new File("media/image_joueur.png"));
			    g.drawImage(img,0, 0, this);
			   if(dessiner_image_joueur)
			   {
				   g.drawImage(img2, 0, 0, this);
				   
			   }
			    String k=""+super.numero;
			    
			    g.drawString(k , 28, 32);
			}catch (IOException t)
			{ t.printStackTrace();}}
		}
	////////////////////////////////////////////////////
	/////////////////////////////////////////////////              Case Fin
	public class Case_fin extends Case  {
		
		
		
		
		public Case_fin(int i)
		{	numero=100;
		
		addMouseListener(new MouseAdapter() {
		
			
			public void mouseClicked(MouseEvent p)
			{
			if ( Partie.this.Position_joueur==numero)
			{ 
				/*if(position_pr�cedente >0){
					position_pr�cedente-=1;
				}*/
				
				dessiner_annimation(position_pr�cedente-1,Position_joueur-1 );
				/*System.out.println(position_pr�cedente);
				System.out.println(Position_joueur);
				    plat.tab_cas1.get(position_pr�cedente).dessiner_image_joueur=false;
				    plat.tab_cas1.get(position_pr�cedente).repaint();
				    plat.tab_cas1.get(Position_joueur-1).dessiner_image_joueur=true;
				    plat.tab_cas1.get(Position_joueur-1).repaint();image_de_1=new ImageIcon("media/Fen_d�/de1.png");*/
			 image_de_2=new ImageIcon("media/Fen_d�/de1.png");
			 zone_d�_1.setIcon(image_de_1);
			 zone_d�_2.setIcon(image_de_2);	
			 setScore(j1);
			 Meilleur_score j=new Meilleur_score(true ,j1);
			}else {Indication.setText("erreur,clicker sur la case n "+get_position());}
			}
		});
		
		}
		
		Image img;
		public void paintComponent(Graphics g)
		{
		try {
			 img = ImageIO.read(new File("media/case_fin.png"));
		     g.drawImage(img,0, 0, this);
		     Image  img2=ImageIO.read(new File("media/image_joueur.png"));
			    g.drawImage(img,0, 0, this);
			   if(dessiner_image_joueur)
			   {
				   g.drawImage(img2, 0, 0, this);
				   
			   }
		     String k=""+100;
		     setForeground(Color.white);
		     g.drawString(k ,24, 30);
		}catch (IOException t)
		{
			t.printStackTrace();
		}
		}
	}
	//////////////////////////////////////////////////
   //////////////////////////////////////////////////              Case
	
public abstract class Case extends JLabel implements Serializable {
public  int numero;
public boolean dessiner_image_joueur=false;



public void dessiner_annimation_case(boolean isdessiner)
{
	if (isdessiner)
	{
		this.dessiner_image_joueur=true;
		this.update(getGraphics());
		
	}
		
	else{
		
		this.dessiner_image_joueur=false;
		this.update(getGraphics());
	}	
	
	
	
}

public void set_vnumero(int num)
    { 
	this.numero=num;	
	}
public Case()
{	
}

public Case(int i )
{
	this.numero=i;
}
	
	public int get_numero()
	{
	return this.numero;	
	}
	}
	//////////////////////////////////////////////////
	/////////////////////////////////////////////////              Question d�finition 
	public class Question_d�finition extends Case_question 
	
	{
		ArrayList <String> Mots = new ArrayList<String>(); 
		ArrayList <String> Defs = new ArrayList<String>(); 
		private String name;
		RandomAccessFile monFichier;
		
	
		
		
		
		public Question_d�finition(int i)
		{
			numero=i;
			addMouseListener(new MouseAdapter() {
				public void  mouseClicked(MouseEvent y)
				{
							try {
								  monFichier = new RandomAccessFile("Fichier.txt", "rw");				  
								  for (int i=0; i<5; i++)       
								  { 
									  String[] te=   (monFichier.readLine()).split("-");
								      Defs.add(te[0]);
								      Mots.add(te[1]);
								  }
									  monFichier.close();					  
								} 
							catch (Exception e) {  e.printStackTrace(); }
							int m = (int) (Math.random()* Defs.size());
				/*if (Partie.this.Position_joueur==numero)
					{*/
					
					fenetre_f�finition3 defi = new fenetre_f�finition3((Mots.get(m)).length()); 
					defi.motDevine=Mots.get(m); 
					defi.definition.setFont(new Font("Arial", Font.BOLD, 16));
				    defi.definition.setText("  " +Defs.get(m));
				    defi.setLocationRelativeTo(null);
					defi.setVisible(true);
					dessiner_annimation(position_pr�cedente-1,Position_joueur-1 );		
				    	image_de_1=new ImageIcon("media/Fen_d�/de1.png");
					 image_de_2=new ImageIcon("media/Fen_d�/de1.png");
					 zone_d�_1.setIcon(image_de_1);
					 zone_d�_2.setIcon(image_de_2);
							Partie.this.de_1.lancer=true;
							Partie.this.de_2.lancer=true;
					}
			
					
					/*else*/
					{
						if((de_1.lancer==false)&&(de_2.lancer==false))
						{
							Indication.setText("erreur,clicker sur la case n "+get_position());							
						}		
					/*}*/
				}
			});
		}
		
		public void paintComponent(Graphics g)
		{
		try {
			
			Image img = ImageIO.read(new File("media/question_definition.png"));
		    g.drawImage(img,0, 0, this);
		    Image  img2=ImageIO.read(new File("media/image_joueur.png"));
		    g.drawImage(img,0, 0, this);
		   if(dessiner_image_joueur)
		   {
			   g.drawImage(img2, 0, 0, this);
			   
		   }
		    String k=""+numero;
		 setForeground(Color.white);
		    g.drawString(k , 24, 30);
		}catch (IOException t)
		{ t.printStackTrace();}
		}
	}
	
////////////////////////////////////////////////////
/////////////////////////////////////////////////              Case Bonus 
	
	
	public class Case_bonus extends Case {

		public int Bonus=20;
		public int pos=3;
		Image img;
		
		
		
		
		
		public Case_bonus(int i) throws Exception1
		{
			
		super(i);		
			addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent u)
				{
				if(Partie.this.Position_joueur==numero)
				{
					dessiner_annimation(position_pr�cedente-1,Position_joueur-1 );
					position_pr�cedente=Position_joueur;
					Partie.this.Position_joueur+=pos;
					Partie.this.j1.Score+=20;	
					Indication.setText("vous avez gagner 2 position,allez vers "+get_position());
					System.out.println(j1.Score);
					score_text.setText(String.valueOf(j1.Score));
					 image_de_1=new ImageIcon("media/Fen_d�/de1.png");
					 image_de_2=new ImageIcon("media/Fen_d�/de1.png");
					 zone_d�_1.setIcon(image_de_1);
					 zone_d�_2.setIcon(image_de_2);
					
			}else{
					if((de_1.lancer==false)&&(de_2.lancer==false))
						System.out.println("dfghj");
						try{System.out.println("dfghj");
						throw new Exception1();
						}catch (Exception e) {
							e.printStackTrace();
							// TODO: handle exception
						}
						/*Indication.setForeground(Color.red);
						Indication.setText("erreur,clicker sur la case n"+get_position());
						Indication.setForeground(Color.white);*/
				    
					}
				}
			});
		}
		
		
		public void paintComponent(Graphics g)
		{
		try {
			
		 img = ImageIO.read(new File("media/case_bonus.png"));
		    g.drawImage(img,0, 0, this);
		    Image  img2=ImageIO.read(new File("media/image_joueur.png"));
		    g.drawImage(img,0, 0, this);
		   if(dessiner_image_joueur)
		   {
			   g.drawImage(img2, 0, 0, this);
			   
		   }
		    String k=""+numero;
		 setForeground(Color.white);
		    g.drawString(k, 24, 32);
		}catch (IOException t)
		{ t.printStackTrace();}}
	}
	}
///////////////////////////////*************************************************//////////////////////
	
	
	
	public class Fenetre_image3  extends JFrame {
		int val,choix=0;
		JLabel ok;
		JLabel mot;
		JLabel image1;
		JLabel image2;
		JLabel image3;
		JLabel image4;
		
		JComboBox<String>  box =new JComboBox<String>();
		public Fenetre_image3()
		{setSize(713,370);
		setAlwaysOnTop(true);
		mot=new JLabel();
		mot.setText("fghjkl");
	   	mot.setBounds(421, 30, 124, 40);
	   	mot.setForeground(Color.white);
	   	mot.setFont(new Font("Arial", Font.BOLD,18));
		 ok=new JLabel();
		 ok.setIcon(new ImageIcon("media/fenetre_image/ok_boutton1.png"));
		 ok.setBounds(570, 294, 87, 39);
		 ok.addMouseListener(new MouseAdapter() 
		 {
			public void mouseEntered(MouseEvent u)
			{
				ok.setIcon(new ImageIcon("media/fenetre_image/ok_boutton2.png"));
				
			}
			public void mouseExited(MouseEvent u)
			{
				ok.setIcon(new ImageIcon("media/fenetre_image/ok_boutton1.png"));				
			}
			
			public void mouseClicked(MouseEvent arg0)
			{
				if (((box.getSelectedItem()=="a") && choix==0) || ((box.getSelectedItem()=="b") && choix==1) || ((box.getSelectedItem()=="c") && choix==2) || ((box.getSelectedItem()=="d") && choix==3)) 
				{ 
				  /*  JOptionPane bravo;  
					bravo = new JOptionPane();
					JOptionPane.showMessageDialog(null, "Bravo :) Vous �tes dou� !", "Bravo", JOptionPane.QUESTION_MESSAGE );*/
					bonne_reponse p=new bonne_reponse();
					Partie.this.j1.Score+=10;
					position_pr�cedente=Position_joueur;
					Partie.this.Position_joueur+=2;
					Partie.this.score_text.setText(String.valueOf(Partie.this.j1.Score));
					Partie.this.Indication.setText("Vous devez aller vers la case n "+ Partie.this.get_position());
					
				}
				else	
				{	/*JOptionPane dommage;  
					dommage = new JOptionPane();
					JOptionPane.showMessageDialog(null, "Dommage :( Retentez votre chance !", "Dommage", JOptionPane.QUESTION_MESSAGE );*/
					movaisse_reponse p=new movaisse_reponse();
					Partie.this.Indication.setText("Lancez les D�s pour avancer");
					
				}dispose();
			}
			
		});
		 image1=new JLabel();
		 image1.setIcon(new ImageIcon("media/fenetre_image/image.png"));
		 image2=new JLabel();
		 image2.setIcon(new ImageIcon("media/fenetre_image/image.png"));
		 image3=new JLabel();
		 image3.setIcon(new ImageIcon("media/fenetre_image/image.png"));
		 image4=new JLabel();
		 image4.setIcon(new ImageIcon("media/fenetre_image/image.png"));
		 JLabel background =new JLabel();
		 
		 
		    box.setBounds(430, 300, 120,26);
			box.addItem("a");
			box.addItem("b");
			box.addItem("c");
			box.addItem("d");
		    background.add(box);
			image1.setBounds(48, 89, 136, 160);
			image2.setBounds(210, 89, 136, 160);
			image3.setBounds(369, 89, 136, 160);
			image4.setBounds(531, 89, 136, 160);
			background.add(image1);
			background.add(image2);
			background.add(image3);
			background.add(image4);
			background.add(ok);
			background.add(mot);
			setContentPane(background);
			setContentPane(background);
			background.setIcon(new ImageIcon("media/fenetre_image/background.png"));
			background.setLayout(null);
			setLocationRelativeTo(null);
			setResizable(false);
			setTitle("Question Image");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		}
	}

/****************************************************************************************************/	
//////////////////////////////**********************************////////////////////////////////////
	
	
	public class fenetre_f�finition3 extends JFrame {
	    JLabel ok;
		JLabel background=new JLabel();
		JLabel champ_text;		
		MaskFormatter lettre;
		JLabel definition;
		String motForm�="", motDevine=""; 
		ArrayList <JTextField> txt = new ArrayList <JTextField>(); 
		int val;
		public fenetre_f�finition3(  int nb)
		{  val=nb;
			definition=new JLabel();
			definition.setBounds(30, 110,400, 50);
			definition.setFont(new Font("Arial",Font.BOLD,16));
			
			setAlwaysOnTop(true);
			definition.setForeground(Color.white);
			champ_text=new JLabel();
			champ_text.setLayout(new FlowLayout());
			champ_text.setBounds(230, 75, 250, 50);
		setSize(505,250);
		setContentPane(background);
		background.setLayout(null);
		background.setIcon(new ImageIcon("media/Fenetre_d�finition/background_fenetre_d�finition.png"));
		ok=new JLabel();
		ok.setBounds(365, 170,108, 54);
		ok.setIcon(new ImageIcon("media/Fenetre_d�finition/boutton_ok1.png"));
		
		background.add(ok);
		background.add(champ_text);
		background.add(definition);	
		for (int j=0; j<nb; j++)
		{
			if (j==0)
			{try{
				lettre=new MaskFormatter("U");
			}catch (ParseException y)
			{
				y.printStackTrace();
			}	
			}
			else
			{
				try{
					 lettre=new MaskFormatter("L");
				}catch (ParseException y)
				{
					y.printStackTrace();
				}
			
			
			}
			
			
			JFormattedTextField m = new JFormattedTextField(lettre);
			m.setPreferredSize(new Dimension (20,27));
			m.setFont(new Font("Arial",  Font.BOLD, 16));
			m.setForeground(Color.white);
			m.setBackground(Color.black);
			txt.add(m); 
			champ_text.add(m); 
		}
		ok.addMouseListener(new MouseAdapter() {
			
			public void mouseEntered(MouseEvent t)
			{  
				ok.setIcon(new ImageIcon("media/Fenetre_d�finition/boutton_ok2.png"));
					
			}		
			public void mouseExited(MouseEvent t)
			{  
				ok.setIcon(new ImageIcon("media/Fenetre_d�finition/boutton_ok1.png"));
			}		
		public void mouseClicked(MouseEvent j)	
		{	int i=0;
		
			while (i<val)
			{
				motForm�+= (txt.get(i)).getText(); 
				i++;
			}
			if (motForm�.equalsIgnoreCase(motDevine))
				{
				
				JOptionPane bravo; 
				{
					
					
					Partie.this.j1.Score+=20;
					position_pr�cedente=Position_joueur;
					Partie.this.Position_joueur+=4;
					Partie.this.score_text.setText(String.valueOf(Partie.this.j1.Score));
					Partie.this.Indication.setText("Vous devez aller vers la case n "+ Partie.this.get_position());
					dispose();
					bonne_reponse bonne_reReponse1=new bonne_reponse();
				}
				}
			else
			{
			JOptionPane dommage;  
			{
		
				Partie.this.j1.Score+=(-10);
				Partie.this.score_text.setText(String.valueOf(Partie.this.j1.Score));
				Partie.this.Indication.setText("Lancez les d�s pour avancer");
				dispose();
				movaisse_reponse movaise_r�ponse=new movaisse_reponse();
			}
			}
		
		 
		 dispose();
			
			
		}	
		
		});
		setResizable(false);
		setTitle("Question D�finition");
         setVisible(true);

		}
		
	}

/********************************************************************************************/

public class movaisse_reponse extends JFrame  implements ActionListener
{
	public movaisse_reponse()
	{   JLabel background=new JLabel();
	    background.setIcon(new ImageIcon("media/im_movaise_r�ponse.png"));
	    setContentPane(background);
		setSize(350, 150);	
		setTitle("movaisse R�ponse");
		Timer time=new Timer(3000, this);
		time.start();
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		dispose();	
	}
	
}


public class bonne_reponse extends JFrame  implements ActionListener
{
	public bonne_reponse()
	{   JLabel background=new JLabel();
	   background.setIcon(new ImageIcon("media/im_bonne_r�ponse.png"));
	   setContentPane(background);
		setSize(335, 135);	
		Timer time=new Timer(3000, this);
		time.start();
		setTitle("Bonne R�ponse");
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		dispose();	
	}
	
}


public class fenetre_confirmation_enregistrement extends JFrame implements
ActionListener{
	
	public fenetre_confirmation_enregistrement()
	{
		setSize(200,100);
		JLabel background= new JLabel();
		background.setIcon(new ImageIcon(""));
	Timer temps_sauvegarde=new Timer(1000, this);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

    dispose();
		
	}	
}

/***********************************************************************************************/
public class Exception1 extends Exception{
	
	public void afficher()
	{
		Indication.setForeground(Color.red);
		Indication.setText("erreur,clicker sur la case n"+get_position());
		Indication.setForeground(Color.white);
		
	}
	
public  Exception1()

{
	
	
	Indication.setForeground(Color.red);
	Indication.setText("erreur,clicker sur la case n"+get_position());
	Indication.setForeground(Color.white);
	}

}





//////////******************************************************************************************///

public class timer implements ActionListener
{

@Override
public void actionPerformed(ActionEvent arg0) {
	
	if (nombre_animation_d� <30)
	{ 
		
	de_1.lancer=false;
  de_1.valeur_d�();		    
  zone_d�_1.setIcon(de_1.img2 );  
  de_2.lancer=false;
	de_2.valeur_d�();
  zone_d�_2.setIcon(de_2.img2); 
  nombre_animation_d�++;
	}
	else
	{
		de_1.lancer=false;
	    de_1.valeur_d�();
	    image_de_1= de_1.img2;
	    zone_d�_1.setIcon(image_de_1);  
	    de_2.lancer=false;
		de_2.valeur_d�();
	    image_de_2= de_2.img2;
	    zone_d�_2.setIcon(image_de_2); 
	    position_pr�cedente=Position_joueur;

	    int r=get_position()+de_1.valeur+de_2.valeur;
	    if (r<100)
	    {set_position(r);}
	    else {set_position(100-(r%100));}
	    Indication.setText("vous devez clicker sur la case n "+get_position());
	
	time1.stop();	
	nombre_animation_d�=0;	
	}
}

}
/*****************************************************************************************/




public class confirmation_sauvegarder extends JFrame  {

		JLabel ok;
	    boolean retour_fen_prin=true;
	    JLabel background;
	    JLabel annuler;
	    JTextField nom_partie;
	    JList<String > list_partie;
		String[] tab_partie;
		
		
		
		public confirmation_sauvegarder()
		{

		        set_fenetre_propri�te();
		        ok.addMouseListener(new MouseAdapter() {
		        	
		        	public void mouseEntered(MouseEvent i)
		        	{
		        		
		        		ok.setIcon(new ImageIcon("media/Confirmation_sauvegarde/ok_rep_2.png"));
		        	}
		        	public void mouseExited(MouseEvent i)
		        	{
		        		
		        		ok.setIcon(new ImageIcon("media/Confirmation_sauvegarde/ok_rep_1.png"));
		        	}
		        	
		        	public void mouseClicked(MouseEvent y)
		        	{
		        		
		        		if( !nom_partie.getText().isEmpty())
		            	{
		        			try {
								Sauvegarder(nom_partie.getText());
								dispose();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
		            		
		            	}
		        		else if(list_partie.getSelectedIndex()>=0)
		        		{
		        			
		        			try {
								Sauvegarder(list_partie.getSelectedValue());
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
		        		annuler.setIcon(new ImageIcon("media/Confirmation_sauvegarde/annuler_rep_2.png"));
		        	}
		        	public void mouseExited(MouseEvent i)
		        	{	
		        		annuler.setIcon(new ImageIcon("media/Confirmation_sauvegarde/annuler_rep_1.png"));
		        	}
		        	public void mouseClicked(MouseEvent t)
		        	{
		        		dispose();
		        	//	Chois nouv_chois=new Chois();
		        		
		        		
		        	}
				}); 
		        
		        
		        
		        
		        partie_deja_sauvegarder();
		        set_list_partie_propri�te();
		        background.add(list_partie);
		        setResizable(false);
		        setTitle("Sauvegarde Partie");
				setVisible(true);

			}
			
			public void set_list_partie_propri�te()
			{
				  list_partie=new JList<String>(tab_partie);
			        list_partie.setBackground(Color.BLACK);
			        list_partie.setForeground(Color.white);
			        list_partie.setBounds(23, 103, 204, 235);
			        list_partie.setFont(new Font("Arial",Font.PLAIN,20));
				
				
			}
			
			
			public void set_fenetre_propri�te()
			{
				setSize(new Dimension(260,478));
				setLocationRelativeTo(null);
				setResizable(false);
				 background=new JLabel();
		         background.setIcon(new ImageIcon("media/Confirmation_sauvegarde/background.png"));
		         setContentPane(background);
		         ok=new JLabel();
		         annuler=new JLabel();
		         ok.setIcon(new ImageIcon("media/Confirmation_sauvegarde/ok_rep_1.png"));
		         annuler.setIcon(new ImageIcon("media/Confirmation_sauvegarde/annuler_rep_1.png"));
		         background.setLayout(null);
		         annuler.setBounds(140, 400, 95, 43);
		         ok.setBounds(30, 400, 90, 43);
		         nom_partie=new JTextField();
		         nom_partie.setBackground(Color.black);
		         nom_partie.setForeground(Color.white);
		         nom_partie.setBounds(35, 360, 180, 30);
		         nom_partie.setFont(new Font("Arial", Font.BOLD, 16));
		         background.add(ok);
		         background.add(nom_partie);
		         background.add(annuler);
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


/****************************************************************************************/












}//fin de clase