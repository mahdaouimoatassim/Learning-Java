/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes_Interfaces;

import Method_Commun.Humain;

/**
 *
 * @author El Mouatassim Billah
 */
public class Test_3 {
    
    
  public static void main(String[] args) {   
      
             /*********************
        Tester la violation de sécurité lors de la déclaration d'une table static et final 
        */
        
        Humain Amine = new Humain.Builder("test1", "Amine").cheuveux("Chatin").poids(65).taille(178).yeux("Maron").immutabe(false).age(16).build();
//        System.out.println(Amine.Hobbies[0]);
//        Amine.Hobbies[1]="Driving Car";
//        System.out.println(Amine.Hobbies[1]);
    
//        System.out.println(Amine.hour_jour);
  }
}
