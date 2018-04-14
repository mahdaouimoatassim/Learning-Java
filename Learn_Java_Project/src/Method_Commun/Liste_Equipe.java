/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Method_Commun;

import Creating_Destroying_Objects.Absolete_Object;
import Method_Commun.Liste_Equipe.Joueur;

/**
 *
 * Cette classe implémente le clonage d'une liste des listes linéaires.
 * 
 * @author El Mouatassim Billah
 */
public class Liste_Equipe implements Cloneable{
    
    /************************   cette classe permet de presenter l'exempe de clonage du hashtable avec les listes linéaire   , 
     * **********************   elle joue le role du hashtable, et la classe joueur joue le role de la classe Entry   ****************************/
    
    public Joueur[] liste;
    
    /******************   Fonction qui permet d'initiaiser une liste d'equipe  comme parametre nombre de joueur et le nombre d'éuipe*****************/
    
    public Liste_Equipe(int nombre_liste, int Nombre_joueur) {

        liste = new Joueur[nombre_liste];
        Joueur Suivant = null;
        Joueur Precedent = null;
        for (int i = 0; i < nombre_liste; i++) {

            for (int j = 0; j < Nombre_joueur; j++) {
                Suivant = Precedent;
                Precedent = new Joueur(j, random_Humain(), Suivant);

                if (j == 1) {
                    liste[i] = Precedent;
                }
                System.out.println(i+"//"+j);
            }
            Suivant = null;
            Precedent = null;
        }

    }
    /********************************* permet de creer un homme aléatoirement*************/
    public Humain random_Humain() 
    {
    
        Humain homme = null;
        switch (random_int(0, 5)) {
            case 1:
                homme = new Humain.Builder("Nom 1", "Prenom 1").taille(random_int(160, 180)).immutabe(false).poids(random_int(60, 90)).yeux("Maron").cheuveux("Maron").build();
                break;
            case 2:
                homme = new Humain.Builder("Nom 2", "Prenom 2").taille(random_int(160, 180)).immutabe(false).poids(random_int(60, 90)).yeux("Maron").cheuveux("Maron").build();
                break;
            case 3:
                homme = new Humain.Builder("Nom 3", "Prenom 3").taille(random_int(160, 180)).immutabe(false).poids(random_int(60, 90)).yeux("Maron").cheuveux("Maron").build();
                break;
            case 4:
                homme = new Humain.Builder("Nom 4", "Prenom 4").taille(random_int(160, 180)).immutabe(false).poids(random_int(60, 90)).yeux("Maron").cheuveux("Maron").build();
                break;
            case 5:
                homme = new Humain.Builder("Nom 5", "Prenom 5").taille(random_int(160, 180)).immutabe(false).poids(random_int(60, 90)).yeux("Maron").cheuveux("Maron").build();
                break;
        }
        return homme;
    }
    /********************************** random entier  ******************************/
    
    public int random_int(int Debut, int Fin ) 
    {
        int random = 0;

        random = ((int) (Math.random() * (Fin - Debut))) + Debut + 1;

        return random;
    }
    
    public static class Joueur {
    
    private int Numero;
    private Humain Valeur;
    private Joueur next;

        public Joueur(int Numero, Humain Valeur, Joueur next) {

            this.Numero = Numero;
            this.Valeur = Valeur;
            this.next = next;
        }

        public void Set_Numero(int numero) {
            this.Numero = numero;
        }

        public int Get_Numero() {
            return this.Numero;
        }

        public void Set_Humain(Humain humain) {
            this.Valeur = humain;
        }

        public Humain Get_Humain() {
            return this.Valeur;
        }

        public void Set_Joueur(Joueur joueur) {
            this.next = joueur;
        }

        public Joueur Get_Next() {
            return this.next;
        }
        //////    Méthode Copy Récurssive
        public Joueur deep_copy() {

            return new Joueur(this.Numero, this.Valeur, next != null ? next.deep_copy() : null);
        }
        
        //////    Méthode Copy Ittératif
        public Joueur deep_copy2() {
            Joueur j = new Joueur(Numero, Valeur, next);

            for (Joueur t = j; t.next != null; t = t.next) {
                t.next = new Joueur(t.next.Numero, t.next.Valeur, t.next.next);
            }
            return j;
        }
    
    
    
    
    }
    
    @Override public Liste_Equipe clone()
    {
    
        try {
           
          //--------------      1 ere methode
            Liste_Equipe result = (Liste_Equipe) super.clone();
            result.liste= new Joueur[liste.length];
            for (int u =0; u<liste.length;u++)
            {
            if (liste[u] != null)
            {
            result.liste[u]=liste[u].deep_copy();
            }
            }
            
            return result;
            
    
        }catch(CloneNotSupportedException e )
        {
        throw new AssertionError();
        }
    }
    
}
