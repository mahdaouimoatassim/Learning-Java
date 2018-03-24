/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes_Interfaces.SkeletalImpementation;

import Method_Commun.Humain;

/**
 *
 * @author El Mouatassim Billah
 */
public class Humain2 implements Cloneable , Comparable<Humain2>{
        
    private String Nom, Prenom;
    private int Taille;
    private int poids;
    private int Age;
    private String cheuveux;
    private String yeux;
    private boolean Immutable;
    private volatile int hashcode1;

    
    public  Humain2 ()
    {
    this.Nom="";
    this.Prenom="";
    this.Taille=175;
    this.poids=70;
    this.Age=20;
    this.cheuveux="Noir";
    this.yeux="Maron";
    this.Immutable=false;
    this.hashcode1=0;
    
    }    
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
     * @return the Age
     */
    public int getAge() {
        return Age;
    }

    /**
     * @param Age the Age to set
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
     * @return the hashcode1
     */
    public int getHashcode1() {
        return hashcode1;
    }

    /**
     * @param hashcode1 the hashcode1 to set
     */
    public void setHashcode1(int hashcode1) {
        this.hashcode1 = hashcode1;
    }
    
    /**
     * Redefinition de la methode toString
     */
    @Override
    public String toString() {
        String Object_Affichage;

        Object_Affichage = "je suis " + this.getNom() + " " + this.getPrenom() + ", je possede les caractéristiques suivant: \n";
        Object_Affichage += "J'ai : " + this.getAge() + ";\n";
        Object_Affichage += "taille : " + this.getTaille() + ";\n";
        Object_Affichage += "Poids : " + this.getPoids() + ";\n";
        Object_Affichage += "Yeux : " + this.getYeux() + ";\n";
        Object_Affichage += "Cheuveux : " + this.getCheuveux() + ";\n";

        return Object_Affichage;
    }

    @Override
    public Humain2 clone() {
        try {
            return (Humain2) super.clone();

        } catch (CloneNotSupportedException e) {
            System.out.println("Le clone ne peut pas etre effectué");
            throw new AssertionError();
        }
    }

    @Override
    public int compareTo(Humain2 o) throws ClassCastException {

        return (this.getAge() - o.getAge());

    }
    
       @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Humain2)) {
            return false;
        }
        Humain2 hm = (Humain2) o;
        return hm.getNom() == this.getNom()
                && hm.getPrenom() == this.getPrenom()
                && hm.getTaille() == this.getTaille()
                && hm.getAge() == this.getAge()
                && hm.getPoids() == this.getPoids()
                && hm.getCheuveux() == this.getCheuveux()
                && hm.getYeux() == this.getYeux()
                && hm.isImmutable() == this.isImmutable();
    }

    /**
     * Redefinition de la methode HashCode
     */
    @Override
    public int hashCode() {
        int result;
        if ((Immutable && hashcode1 == 0) || !Immutable) {
            result = 17;
            result = result * 31 + (Immutable ? 1 : 0);
            result = result * 31 + Nom.hashCode();
            result = result * 31 + Prenom.hashCode();
            result = result * 31 + cheuveux.hashCode();
            result = result * 31 + yeux.hashCode();
            result = result * 31 + poids;
            result = result * 31 + Age;
            result = result * 31 + Taille;
        } else {
            result = hashcode1;
        }

        return result;
    }
}
