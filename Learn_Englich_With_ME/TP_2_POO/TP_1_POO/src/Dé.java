import javax.imageio.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;


public class Dé implements Serializable {
	
	public ImageIcon img2;
	public int valeur;
	public boolean lancer=true;
	
	
	public void valeur_dé()
	{   
		valeur=((int)((Math.random()*100)%6))+1;
		String chemin="media/Fen_dé/";
		chemin+=valeur;
		chemin+=valeur;
		chemin+=".png";

		 img2=new ImageIcon(chemin);
	
	}
	
	

}
