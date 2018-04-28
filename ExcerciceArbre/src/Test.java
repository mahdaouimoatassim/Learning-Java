/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author El Mouatassim Billah
 */
public class Test {
 
    
     public static void main(String[] arg) {
     
         /******************************   Initialiser le Schéma *******************************/
         
         ArbreRectangle rec33 = new ArbreRectangle(33,new ArbreRectangle(12),new ArbreCercle("D".charAt(0)));
         ArbreRectangle rec8 = new ArbreRectangle(8,new ArbreCercle("E".charAt(0)),null);
         ArbreCercle cerC = new ArbreCercle("C".charAt(0),rec8,rec33);
         ArbreCercle cerB = new ArbreCercle("B".charAt(0),null,cerC);
         ArbreCercle cerF = new ArbreCercle("F".charAt(0),new ArbreCercle("G".charAt(0)),null);
         ArbreRectangle rec5 = new ArbreRectangle(5,cerF,new ArbreRectangle(7));
         ArbreCercle cerA = new ArbreCercle("A".charAt(0),rec5,cerB);
         System.out.println("sfv");
         /*****************************    Calculer la somme de cette arbre  ***************************************/
         System.out.println(cerA.somme());
         
         /******************************    Affichage du schéma de l'arbre**********************/
         cerA.ParcoursPreOrder();
         System.out.println("*****************************************");
         cerA.ParcoursInOrder();
         System.out.println("*****************************************");
         cerA.ParcoursPostOrder();
       // Arbre1 c = new Arbre(10,new Arbre(8),new Arbre(12));       
      //  Arbre1 a = new Arbre(6,b,c);
     
     }
    
}
