/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Method_Commun;

import jdk.internal.org.objectweb.asm.Opcodes;

import java.lang.ClassCastException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.*;

/**
 *
 * @author El Mouatassim Billah
 */
public class Humain implements Cloneable , Comparable<Humain>{
    private String Nom, Prenom;
    private int Taille;
    private int poids;
    private int Age;
    private String cheuveux;
    private String yeux;
    private boolean Immutable;
    private volatile int hashcode1;
    private static final String[] Hobbies={"Playing Fottball","Swimming"};
    public static final int hour_jour=24; 
 //   public static final List<String> = Collections.unmodifiableCollection( Arrays.asList(Hobbies));
    /**
     * @return the Nom
     */
    public String getNom() {
        return Nom;
    }
    public static final String[] Hobbies() {
    return Hobbies.clone();
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
     * @return the Age
     */
    public int getAge() {
        return this.Age;
    }

    /**
     * @param poids the Age to set
     */
    public void setAge(int Age) {
        this.Age = Age;
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

  
    /**
     * the classe Builder
     */
    
    
    public static class Builder {

        private String Nom, Prenom;
        private int Taille;
        private int poids;
        private int Age;
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
    
    public Builder age(int age) {
            this.Age = age;
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
 /**
     * the Constructor Humain
     */
    private Humain(Builder builder) {

        this.Nom = builder.Nom;
        this.Prenom = builder.Prenom;
        this.Taille = builder.Taille;
        this.Age=builder.Age;
        this.poids = builder.poids;
        this.cheuveux = builder.cheuveux;
        this.yeux = builder.yeux;
        this.Immutable=builder.Immutable;
        
    }
    /**
     * Redefinition de la methode Equals
     */

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
                && hm.getAge()== this.getAge()
                && hm.getPoids() == this.getPoids()
                && hm.getCheuveux() == this.getCheuveux()
                && hm.getYeux() == this.getYeux()
                && hm.isImmutable()==this.isImmutable()
                ;
    }
    
     /**
     * Redefinition de la methode HashCode
     */
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
                result = result*31+Age ;
                result = result*31+Taille ;        
                }
                else {
                    result=hashcode1;
                }
                
            return result;
            }
 /**
     * Redefinition de la methode toString
     */
     @Override public String toString()
     {
         String Object_Affichage;
     
          Object_Affichage="je suis "+this.getNom()+" "+this.getPrenom()+", je possede les caractéristiques suivant: \n";
          Object_Affichage+= "J'ai : "+this.getAge()+";\n";
          Object_Affichage+= "taille : "+this.getTaille()+";\n";
          Object_Affichage+= "Poids : "+this.getPoids()+";\n";
          Object_Affichage+= "Yeux : "+this.getYeux()+";\n";
          Object_Affichage+= "Cheuveux : "+this.getCheuveux()+";\n";
          
     return Object_Affichage;
     }
   
//    public String To_string2()
//    {        
//    return  ((Object)this).toString() ;
//    }
     
     @Override public Humain clone() 
     {
         try
         {
             return (Humain)super.clone();
     
  
         }catch (CloneNotSupportedException e)
         {
         System.out.println("Le clone ne peut pas etre effectué");
         throw  new AssertionError();
         }       
     }
    /*
     
      la redéfinition de la méthode compareTo
      a noter que cette définition ne permet pas d'assurer la 4 provision (x.ccompareTo(y)==0)==x.equals(y)
      car j'ai définit la fonction pour comparer entre les humains en terme d'Age.
     *****/
     
   @Override
    public int compareTo(Humain o) throws ClassCastException {
        
        return (this.getAge()-o.getAge());
     
    }
}

