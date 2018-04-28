/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author El Mouatassim Billah
 */
public abstract class Arbre {
    
     public Arbre noeudGauche, noeudDroit;
     private int niveau;
     /**
      * Constructeur qui permet d'initialiser les deux noeud droit et gauche
      * @param droit le noeud droit de cette noeud
      * @param gauche le noeud gauche de cette noeud 
      */
    Arbre(Arbre droit, Arbre gauche) {
        this.noeudGauche = gauche;
        this.noeudDroit = droit;
    };

    public Arbre getNoeudGauche() {
        return (noeudGauche);
    };
    
    
            
    /**
      * Mutator qui permet de récuperer le noeud Droi
      */
     public Arbre getNoeudDroite() {
        return (noeudDroit);
    };
     
     /**
      * la methode qui permet de parcours l'arbre dans le preordre
      */
    abstract public void ParcoursPreOrder();
    /**
      * la methode qui permet de parcours l'arbre dans le inordre
      */
    abstract public void ParcoursInOrder();
    /**
      * la methode qui permet de parcours l'arbre dans le postordre
      */
    abstract public void ParcoursPostOrder();
    /**
      * la methode qui permet de calculer la somme d'une arbre
      */
    abstract public int somme();
    /**
     * La methode qui calcule la hauteur d'un arbre a 
     * @param arbre
     * @return un entier qui represente la hauteur de cette arbre
     */
    public int hauteur(Arbre arbre) {
	if (arbre == null)
	    return 0;
	else
	    return (1 + Math.max(hauteur(arbre.getNoeudGauche()), hauteur(arbre.getNoeudDroite())));
    }
    /**
     * cette méthode permet de transformer l'arbre en une chaine de caractaire de type hauteur_@noeudGauche@noeudDroit/ 
     * @param arbre
     * @return un entier qui represente la hauteur de cette arbre
     */
    abstract public String ExpressionArbreHauteur();
    
    /**
     * cette méthode permet de transformer l'arbre en une chaine de caractaire de type Niveau_@noeudGauche@noeudDroit/ 
     * @param arbre
     * @return un entier qui represente la hauteur de cette arbre
     */
    abstract public String ExpressionArbreNiveau(int niveau_precedent);

}
