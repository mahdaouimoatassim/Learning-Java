/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes_Interfaces;

import Method_Commun.Humain;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

/**
 *
 * @author El Mouatassim Billah
 */
public class Test_3 {
    
    
    
    
    
  public static void main(String[] args) {   
      
             /*********************
        Tester la violation de sécurité lors de la déclaration d'une table static et final 
        */
        
//        Humain Amine = new Humain.Builder("test1", "Amine").cheuveux("Chatin").poids(65).taille(178).yeux("Maron").immutabe(false).age(16).build();
//        System.out.println(Amine.Hobbies[0]);
//        Amine.Hobbies[1]="Driving Car";
//        System.out.println(Amine.Hobbies[1]);
    
//        System.out.println(Amine.hour_jour);
        
        /*********************
        Tester les classes immutable et leurs Mutable Campaniom
        */
//        ComplexImmutableClass C1=new ComplexImmutableClass(2,1);
//        
//        ComplexImmutableClass zero=ComplexImmutableClass.ZERO;
//        
//        System.out.println(BigInteger.valueOf(123464));
//        System.out.println((new BigInteger("12365498796845163749684").add(BigInteger.valueOf(1))));
//        System.out.println(new BigDecimal(new BigInteger("12365498796845163749684").add(BigInteger.valueOf(1)),5));
//        
//        StringBuilder z=new StringBuilder("hdjjjnln");
//        System.out.println(z.insert(4,1.2));
//        
           /*********************
        Tester l'Item Favor compoition over inhéritence 
        */
        
      
//      FavorComposition<String> s = new FavorComposition<String>();
//    //  s.addAll(Arrays.asList("Snap", "Crackle"));/*, "Pop"*/
//     s.add("Snap");s.add("Crackle");s.add("Pop");
//      System.out.println(s.getAddCount());
//      
//      FavorComposition<String> s= new FavorComposition<String>(new TreeSet<String>());
//      s.addAll(Arrays.asList("Snap","Crackle","Pop"));
//      System.out.println(s.getAddCount()); 
//      
      
      
      
  }
  
  /*
  Tester la Fonvtionnalité Skeletal Implementation
  */
  
//    static List<Integer> intArrayAsList(final int[] a) {
//        if (a == null) {
//            throw new NullPointerException();
//        }
//        return new AbstractList<Integer>() {
//            public Integer get(int i) {
//                return a[i]; // Autoboxing (Item 5)
//            }
//
//            @Override
//            public Integer set(int i, Integer val) {
//                int oldVal = a[i];
//                a[i] = val; // Auto-unboxing
//                return oldVal; // Autoboxing
//            }
//
//            public int size() {
//                return a.length;
//            }
//        };
//    }
  
  
  static HashMap.Entry<Integer,String> intArrayAsHashMap(final int[] a,final String[] B) {
        if (a == null) {
            throw new NullPointerException();
        }
        return new SkeletalImplementation<Integer,String>() {

            @Override
            public Integer getKey(int i) {
            return a[i]; 
            }

            @Override
            public String getValue(int i) {
             return B[i];  
            }
            
            
            
            
//            public Integer get(int i) {
//                return a[i]; // Autoboxing (Item 5)
//            }
//
//            @Override
//            public Integer set(int i, Integer val) {
//                int oldVal = a[i];
//                a[i] = val; // Auto-unboxing
//                return oldVal; // Autoboxing
//            }
//
//            public int size() {
//                return a.length;
//            }

            @Override
            public Integer getKey() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public String getValue() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
    }
  
}
