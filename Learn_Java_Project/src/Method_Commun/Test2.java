/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Method_Commun;
import Creating_Destroying_Objects.*;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.BigInteger;
/**
 *
 * @author El Mouatassim Billah
 */
public class Test2 {

   
 
    public static void main(String[] args) {

    
        /**************** hashcode test*********************/
//      HashCod  hashcode1 = new HashCod();
//      System.out.println(hashcode1.getC());
//      System.out.println(hashcode1.getB());
//      System.out.println(hashcode1.getL());
//      System.out.println(hashcode1.toString());
////      System.out.println(hashcode1.toString());
//      
      
 //     Humain Moatassim= new Humain.Builder("Mahdaoui","El Moutassim Billah").cheuveux("Chatin").poids(65).taille(178).yeux("Maron").immutabe(false).build();
      
//      System.out.println(Moatassim);
      
//      System.out.println(System.identityHashCode(Moatassim));       
//      Humain Moatassim2=(Humain) Moatassim.clone();
//      System.out.println(System.identityHashCode(Moatassim2));
//      System.out.println(Moatassim.equals(Moatassim2)); 
//      System.out.println(Moatassim.hashCode());
//      System.out.println(Moatassim2.hashCode());
//      
      
      
      //-------------------- Clone teste Table--------------------------/
      
//      Absolete_Object test_tab=new Absolete_Object();
//      
//      Humain Amine= new Humain.Builder("test1","Amine").cheuveux("Chatin").poids(65).taille(178).yeux("Maron").immutabe(false).build();
//      Humain Amine2= new Humain.Builder("test2","Amine2").cheuveux("Chatin").poids(65).taille(178).yeux("Maron").immutabe(false).build();
//      Humain Amine3= new Humain.Builder("test3","Amine3").cheuveux("Chatin").poids(65).taille(178).yeux("Maron").immutabe(false).build();
//      Humain Amine4= new Humain.Builder("test4","Amine4").cheuveux("Chatin").poids(65).taille(178).yeux("Maron").immutabe(false).build();
//      test_tab.push(Amine);
//      test_tab.push(Amine2);
//      test_tab.push(Amine3);
//      test_tab.push(Amine4);
      
//      Absolete_Object test_tab2=test_tab.clone();
//      System.out.println(test_tab2.Humains);
//      System.out.println(test_tab.Humains);
      
      //-------------------- Clone teste Hashtable des Listes linéaire chainée --------------------------/
      
//      Liste_Equipe liste1=new Liste_Equipe(3, 2);
//      
//      Liste_Equipe liste2=liste1.clone();
//      System.out.println(liste1.liste[1].Get_Humain());
//      System.out.println(liste2.liste[1].Get_Humain());
//      System.out.println(liste1.liste[1].Get_Next().Get_Humain());
//      System.out.println(liste2.liste[1].Get_Next().Get_Humain());
//      System.out.println(liste1.liste[0].Get_Humain());
//      System.out.println(liste2.liste[0].Get_Humain());
//      System.out.println(liste1.liste[0].Get_Next().Get_Humain());
//      System.out.println(liste2.liste[0].Get_Next().Get_Humain());
//      System.out.println(liste1.liste[2].Get_Humain());
//      System.out.println(liste2.liste[2].Get_Humain());
//      System.out.println(liste1.liste[2].Get_Next().Get_Humain());
//      System.out.println(liste2.liste[2].Get_Next().Get_Humain());
    
      /******************** Test CompareTo************************/
      
      Set<String> s = new TreeSet<String>();
      Collections.addAll(s, args);
      System.out.println(s);
      double k=2123464894.22;
        BigDecimal nombre=new BigDecimal(k);
        
        byte [] v = {3,-2};
        byte [] v1 = {-1};
        BigInteger d = new BigInteger(v);
        BigInteger d1 = new BigInteger(v1);
        System.out.println(nombre);
        System.out.println(d1);
    }
    
   
}
