/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Method_Commun;



/**
 *
 * @author El Mouatassim Billah
 */
public class Humain {
        private String Nom, Prenom;
    private int Taille;
    private int poids;
    private String cheuveux;
    private String yeux;
    private boolean Immutable;
   private volatile int hashcode1;
    /**
     * @return the Nom
     */
    public String getNom() {
        return Nom;
    }

    /**
     * @param Nom the Nom to set
     */
    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    /**
     * @return the Prenom
     */
    public String getPrenom() {
        return Prenom;
    }

    /**
     * @param Prenom the Prenom to set
     */
    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    /**
     * @return the Taille
     */
    public int getTaille() {
        return Taille;
    }

    /**
     * @param Taille the Taille to set
     */
    public void setTaille(int Taille) {
        this.Taille = Taille;
    }

    /**
     * @return the poids
     */
    public int getPoids() {
        return poids;
    }

    /**
     * @param poids the poids to set
     */
    public void setPoids(int poids) {
        this.poids = poids;
    }

    /**
     * @return the cheuveux
     */
    public String getCheuveux() {
        return cheuveux;
    }

    /**
     * @param cheuveux the cheuveux to set
     */
    public void setCheuveux(String cheuveux) {
        this.cheuveux = cheuveux;
    }

    /**
     * @return the yeux
     */
    public String getYeux() {
        return yeux;
    }

    /**
     * @param yeux the yeux to set
     */
    public void setYeux(String yeux) {
        this.yeux = yeux;
    }

    /**
     * @return the Immutable
     */
    public boolean isImmutable() {
        return Immutable;
    }

    /**
     * @param Immutable the Immutable to set
     */
    public void setImmutable(boolean Immutable) {
        this.Immutable = Immutable;
    }
    public static class Builder {

        private String Nom, Prenom;
        private int Taille;
        private int poids;
        private String cheuveux;
        private String yeux;
        private boolean Immutable;
        ;
        public Builder(String nom, String prenom) {
            this.Nom = nom;
            this.Prenom = prenom;
        }

        ;
    public Builder taille(int taille) {
            this.Taille = taille;
            return this;
        }

    public Builder immutabe(boolean immutabe) {
            this.Immutable = immutabe;
            return this;
        }
        public Builder poids(int poids) {
            this.poids = poids;
            return this;
        }

        public Builder cheuveux(String cheuveux) {
            this.cheuveux = cheuveux;
            return this;
        }

        public Builder yeux(String yeux) {
            this.yeux = yeux;
            return this;
        }

        public Humain build() {
            return new Humain(this);
        }

    }

    private Humain(Builder builder) {

        this.Nom = builder.Nom;
        this.Prenom = builder.Prenom;
        this.Taille = builder.Taille;
        this.poids = builder.poids;
        this.cheuveux = builder.cheuveux;
        this.yeux = builder.yeux;
        this.Immutable=builder.Immutable;
        
    }
    /*****************************************************/
       @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Humain)) {
            return false;
        }
        Humain hm = (Humain) o;
        return hm.getNom() == this.getNom()
                && hm.getPrenom() == this.getPrenom()
                && hm.getTaille() == this.getTaille()
                && hm.getPoids() == this.getPoids()
                && hm.getCheuveux() == this.getCheuveux()
                && hm.getYeux() == this.getYeux()
                && hm.isImmutable()==this.isImmutable()
                ;
    }
    
    /*****************************************************/
       @Override 
     public int hashCode() 
            {
                
                int result;
                
                if ( ( Immutable && hashcode1==0) || !Immutable )
                {
                result=17;
                
                result = result*31+ (Immutable ? 1 : 0);
                result = result*31+Nom.hashCode() ;
                result = result*31+Prenom.hashCode();
                result = result*31+cheuveux.hashCode() ;
                result = result*31+yeux.hashCode() ;
                result = result*31+poids ;
                result = result*31+Taille ;
        
                }
                else {
                    result=hashcode1;
                }
                
            return result;
            }
/*****************************************************/
     @Override public String toString()
     {
         String Object_Affichage;
     
          Object_Affichage=" je suis "+this.getNom()+" "+this.getPrenom()+", je possede les caractéristiques suivant: \n";
          Object_Affichage+= "taille : "+this.getTaille()+";\n";
          Object_Affichage+= "Poids : "+this.getPoids()+";\n";
          Object_Affichage+= "Yeux : "+this.getYeux()+";\n";
          Object_Affichage+= "Cheuveux : "+this.getCheuveux()+";\n";
          
     return Object_Affichage;
     }
    
    

}

