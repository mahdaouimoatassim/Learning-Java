/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author El Mouatassim Billah
 */
public class ArbreRectangle extends Arbre
 {
    int valeur;
    
    
    ArbreRectangle(int valeur) {
        super(null, null);
        this.valeur = valeur;
    }
    
    ArbreRectangle(int valeur, Arbre Guache,Arbre Droite){        
        super(Droite, Guache);
        this.valeur = valeur;
    }
    
    public int getValue()
    {
    return  this.valeur;
    }
    
        @Override
    public int somme()
    {
//       if (this==null) return 0;
//       else if (this instanceof ArbreRectangle) return noeudGauche.somme()+noeudDroit.somme()+valeur;
//       else  return noeudGauche.somme()+noeudDroit.somme();
       
        
//       if ( this != null) { 
//       if (this instanceof ArbreRectangle) return noeudGauche.somme()+noeudDroit.somme();
//       else return noeudGauche.somme()+noeudDroit.somme()+valeur;
//       }         
//       else return 0;
        
        
    //   if (this instanceof ArbreRectangle) return noeudGauche.somme()+noeudDroit.somme();
    //   else return noeudGauche.somme()+noeudDroit.somme()+valeur;
              
   if ( (super.noeudDroit == null) && (noeudDroit==null) ) 
   {
    if (this instanceof ArbreRectangle) return valeur;
       else return 0;
   }
   else if ( noeudGauche != null && noeudDroit==null )
    {
    if (this instanceof ArbreRectangle) return noeudGauche.somme()+valeur;
       else return noeudGauche.somme();
   } 
   else if  ( noeudGauche == null && noeudDroit!=null )
    {
    if (this instanceof ArbreRectangle) return noeudDroit.somme()+valeur;
       else return noeudDroit.somme();
   }
   else 
   {
    if (this instanceof ArbreRectangle) return valeur+ noeudDroit.somme()+ noeudGauche.somme();
       else return noeudDroit.somme()+ noeudGauche.somme();
   }
       
    };
    @Override
    public void ParcoursPreOrder(){
    System.out.println("|"+valeur+"|");
    if (this.getNoeudGauche()!= null) getNoeudGauche().ParcoursPreOrder();
    if (this.getNoeudDroite()!= null) getNoeudDroite().ParcoursPreOrder();
    };
    @Override
    public void ParcoursInOrder(){    
    if (this.getNoeudGauche()!= null) getNoeudGauche().ParcoursInOrder();
    System.out.println("|"+valeur+"|");
    if (this.getNoeudDroite()!= null) getNoeudDroite().ParcoursInOrder();
    };
    @Override
    public void ParcoursPostOrder(){    
    if (this.getNoeudGauche()!= null) getNoeudGauche().ParcoursPostOrder();
    if (this.getNoeudDroite()!= null) getNoeudDroite().ParcoursPostOrder();
    System.out.println("|"+valeur+"|");
    };
    @Override
    public String ExpressionArbreHauteur()
    {
        String s;
        if (this.getNoeudGauche()== null && this.getNoeudDroite()== null) 
        {s= hauteur(this)+ "_null"+"_null"+"/";
        return s;}
        else if (this.getNoeudGauche()!= null && this.getNoeudDroite()!= null) 
        {s= hauteur(this)+ "_"+this.noeudGauche+"_"+this.noeudDroit+"/";
        return s+noeudGauche.ExpressionArbreHauteur()+noeudDroit.ExpressionArbreHauteur();}
        else if (this.getNoeudGauche()!= null && this.getNoeudDroite()== null) 
        {s= hauteur(this)+ "_"+this.noeudGauche+"_null"+"/";
        return s+noeudGauche.ExpressionArbreHauteur();}
        else  
        {s= hauteur(this)+ "_null"+"_"+this.noeudDroit+"/";
        return s+noeudDroit.ExpressionArbreHauteur();}
    };
    @Override
    public String ExpressionArbreNiveau(int niveau_precedent)
    {
        String s;
        if (this.getNoeudGauche()== null && this.getNoeudDroite()== null) 
        {s= niveau_precedent+"_"+this.valeur+"_null"+"_null"+"/";
        return s;}
        else if (this.getNoeudGauche()!= null && this.getNoeudDroite()!= null) 
        {s= niveau_precedent+"_"+this.valeur+ "_"+this.noeudGauche+"_"+this.noeudDroit+"/";
        return s+noeudGauche.ExpressionArbreNiveau(niveau_precedent+1)+noeudDroit.ExpressionArbreNiveau(niveau_precedent+1);}
        else if (this.getNoeudGauche()!= null && this.getNoeudDroite()== null) 
        {s= niveau_precedent+"_"+this.valeur+ "_"+this.noeudGauche+"_null"+"/";
        return s+noeudGauche.ExpressionArbreNiveau(niveau_precedent+1);}
        else  
        {s= niveau_precedent+"_"+this.valeur+ "_null"+"_"+this.noeudDroit+"/";
        return s+noeudDroit.ExpressionArbreNiveau(niveau_precedent+1);}
    };
    
}
