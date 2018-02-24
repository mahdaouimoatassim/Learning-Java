import java.io.Serializable;


public class Joueur implements Serializable,Comparable<Joueur> {

	public String nom ;
	public int Score;
	public String temps;


	
	public Joueur(String nom,int score)
	{
		this.nom=nom;
		this.Score=score;
	}
	
	
	
	public int compareTo(Joueur k)
	{
		
		if (this.Score>k.Score)  return -1;
		else if(this.Score<k.Score) return 1;
		else return 0;
		
	}
	
}
