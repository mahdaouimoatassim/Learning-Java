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
public class Vendeur extends  Humain2 implements ITravailleur{
     
    private class AbstractVendeurDelegator extends AbstractTravailleur {

        @Override
        public void Travailler() {
            System.out.println("Commener le travail");
            System.out.println("Vendre la pièce");
            System.out.println("Terminer le travail");
        }

    }

    AbstractVendeurDelegator  Vendeur1 = new AbstractVendeurDelegator ();

    @Override
    public void se_lever() {
        Vendeur1.se_lever();
    }

    @Override
    public void Dormir() {
        Vendeur1.Dormir();
    }

    @Override
    public void Travailler() {
        Vendeur1.Dormir();
    } 
    
    
    @Override
    public void Process() {
        Vendeur1.Process();
    } 
}
