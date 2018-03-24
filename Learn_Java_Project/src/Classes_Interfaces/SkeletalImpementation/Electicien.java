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
public class Electicien implements ITravailleur{
    
    private class AbstractElectricienDelegator extends AbstractTravailleur {

        @Override
        public void Travailler() {
            System.out.println("Commener le travail");
            System.out.println("Reparer le véhicule");
            System.out.println("Terminer le travail");
        }

    }

    AbstractElectricienDelegator electricien1 = new AbstractElectricienDelegator();

    @Override
    public void se_lever() {
        electricien1.se_lever();
    }

    @Override
    public void Dormir() {
        electricien1.Dormir();
    }

    @Override
    public void Travailler() {
        electricien1.Dormir();
    }
    
    @Override
    public void Process() {
        electricien1.Process();
    }
}
