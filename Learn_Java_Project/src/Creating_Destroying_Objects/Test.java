/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Creating_Destroying_Objects;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author El Mouatassim Billah
 */
public class Test {
    
    private Test()
    {};
    
   
    public static void main (String[] args) throws FileNotFoundException, IOException
    {
        /*   test Static Factory Method
        
        Static_Factory_Method mes_information=Static_Factory_Method.GetInstance();
        System.out.println(mes_information.getnom());
        System.out.println(mes_information.getprenom());
        */
       
        /*   test Builder patern
        Builder_Pattern Homme_1= new Builder_Pattern.Builder("Mahdaoui","Elmoutassim Billah").taille(178).poids(65).cheuveux("Chatin").yeux("Maron").build();
        Builder_Pattern Homme_2= new Builder_Pattern.Builder("","").taille(178).cheuveux("Chatin").poids(65).yeux("Maron").build();
        */
        
        
        /* Singleton tester l'unicite de l'objet creer
        
        Singleton sing2= Singleton.getInstance();
        Singleton sing3= Singleton.getInstance();
        
        if (sing2==sing3)
        {System.out.println("True");}
        else 
        {System.out.println("False");}
     
        System.out.println(sing2);  //afficher le type et l'adresse de l'objet
        System.out.println(sing3);  //afficher le type et l'adresse de l'objet
       
        final FileOutputStream fichier = new FileOutputStream("Singleton_Code.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fichier);
        oos.writeObject(sing2);
        oos.writeObject(sing3);
        oos.flush();
        oos.close();
        */
        
       /* Absolete_Object liste_humain=new Absolete_Object();
        liste_humain.push(1);
        liste_humain.push(2);
        liste_humain.push(3);
        liste_humain.push(4);
        liste_humain.push(5);
     
        System.out.println(liste_humain.pop());
        
         int Humainss[] = {0,1,2,3};
         Humainss[0]=5;
         Humainss[1]=6;
         Humainss[2]=7;
         int size=2;
         System.out.println(Humainss[++size]);
          System.out.println(size);               
        */
        
    }
    
}
