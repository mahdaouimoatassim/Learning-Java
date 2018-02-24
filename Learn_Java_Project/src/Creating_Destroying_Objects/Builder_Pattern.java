/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Creating_Destroying_Objects;

/**
 *
 * @author El Mouatassim Billah
 */
public class Builder_Pattern {
    
    private String Nom,Prenom;
    private int Taille;
    private int poids;   
    private String cheuveux;
    private String yeux;
    
   
    public static class Builder{
    
    private String Nom,Prenom;
    private int Taille;
    private int poids; 
    private String cheuveux;
    private String yeux;
    
    public Builder(String nom, String prenom)
    {
    this.Nom=nom;
    this.Prenom=prenom;
    };
    public Builder taille (int taille)
    {
    this.Taille=taille;
    return this;
    }
   
     public Builder poids(int poids)
    {
    this.poids=poids;
    return this;
    }
     public Builder cheuveux (String cheuveux)
    {
    this.cheuveux=cheuveux;
    return this;
    }
     public Builder yeux (String yeux)
    {
    this.yeux=yeux;
    return this;
    }
     
     
     public Builder_Pattern build()
     {
     return  new Builder_Pattern(this);
     }
     
    }
    
     private Builder_Pattern(Builder builder)
    {
        
        this.Nom=builder.Nom;
        this.Prenom=builder.Prenom;
        this.Taille=builder.Taille;
        this.poids=builder.poids;
        this.cheuveux=builder.cheuveux;
        this.yeux=builder.yeux;
       
    }
    
}
