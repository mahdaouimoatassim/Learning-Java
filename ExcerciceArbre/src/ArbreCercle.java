/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author El Mouatassim Billah
 */
public class ArbreCercle extends Arbre{
    
    char valeur;
    
    ArbreCercle(char valeur) {
        super(null, null);
        this.valeur = valeur;
    }
    
    ArbreCercle(char valeur, Arbre Guache,Arbre Droite){        
        super(Droite, Guache);
        this.valeur = valeur;
    }
    
    @Override
    public int somme()
    {
//       if (this==null) return 0;
//       else if (this instanceof ArbreCercle) return noeudGauche.somme()+noeudDroit.somme();
//       else return noeudGauche.somme()+noeudDroit.somme()+valeur;
       
//       if ( this != null) { 
//       if (this instanceof ArbreCercle) return noeudGauche.somme()+noeudDroit.somme();
//       else return noeudGauche.somme()+noeudDroit.somme()+valeur;
//       }
//       else return 0;
        if ((super.noeudDroit == null) && (noeudDroit == null)) {
            if (this instanceof ArbreCercle) {
                return 0;
            } else {
                return valeur;
            }
        } else if (noeudGauche != null && noeudDroit == null) {
            if (this instanceof ArbreCercle) {
                return noeudGauche.somme();
            } else {
                return noeudGauche.somme() + valeur;
            }
        } else if (noeudGauche == null && noeudDroit != null) {
            if (this instanceof ArbreCercle) {
                return noeudDroit.somme() + 0;
            } else {
                return noeudDroit.somme() + valeur;
            }
        } else {
            if (this instanceof ArbreCercle) {
                return noeudDroit.somme() + noeudGauche.somme();
            } else {
                return valeur + noeudDroit.somme() + noeudGauche.somme();
            }
        }

        
    };
    @Override
    public void ParcoursPreOrder(){   
    System.out.println("("+valeur+")");
    if (this.getNoeudGauche()!= null) getNoeudGauche().ParcoursPreOrder();
    if (this.getNoeudDroite()!= null) getNoeudDroite().ParcoursPreOrder();
    };
    @Override
    public void ParcoursInOrder(){       
    if (this.getNoeudGauche()!= null) getNoeudGauche().ParcoursInOrder();
     System.out.println("("+valeur+")");
    if (this.getNoeudDroite()!= null) getNoeudDroite().ParcoursInOrder();
    };
    @Override
    public void ParcoursPostOrder(){          
    if (this.getNoeudGauche()!= null) getNoeudGauche().ParcoursPostOrder();
    if (this.getNoeudDroite()!= null) getNoeudDroite().ParcoursPostOrder();
    System.out.println("("+valeur+")");
    };
}
