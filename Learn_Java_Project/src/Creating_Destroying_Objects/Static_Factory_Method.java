/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Creating_Destroying_Objects;

/**
 *
 * @author El Mouatassim Billah
 */
public class Static_Factory_Method {

    private String Nom, prenom;

    private Static_Factory_Method(String nom, String prenom) {
        this.Nom = nom;
        this.prenom = prenom;
    }

    ;
    
    
    public String getnom() {
        return this.Nom;
    }

    public String getprenom() {
        return this.prenom;
    }

    private static Static_Factory_Method Exemple_Static_Factory_Method = new Static_Factory_Method("Mahdaoui", "ElmoutassimBillah");

    public static Static_Factory_Method GetInstance() {
        return Exemple_Static_Factory_Method;
    }

}
