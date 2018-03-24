/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes_Interfaces.SkeletalImpementation;

/**
 *
 * @author El Mouatassim Billah
 */
public class TesT {
    
    public static void main(String[] args) {
        ITravailleur electricion_1 = new Electicien();
        ITravailleur Vendeur_1 = new Vendeur();
        System.out.println("*********************");
        electricion_1.Process();
        System.out.println("*********************");
        Vendeur_1.Process();
      
    }
    
}
