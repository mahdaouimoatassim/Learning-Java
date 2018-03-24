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
public abstract class AbstractTravailleur implements ITravailleur {
    
    @Override
      public void se_lever()
    {
        System.out.println("C'est le temps de se lever");
    }
      
    @Override
    public void Dormir()
    {
        System.out.println("C'est le temps de dormir");
    }
    
    @Override
    public void Process()
    {
         se_lever();
         Travailler();
         Dormir();
    }
}
