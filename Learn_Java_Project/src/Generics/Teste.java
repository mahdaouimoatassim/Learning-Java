/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Generics;

import java.util.*;

/**
 *
 * @author El Mouatassim Billah
 */
public class Teste {
  public static void main(String[] args) {
  
      
      /**
       * Teste du Item 23 RawType And Generics Types.
       */
//        List<RawType_Stamp> Stamps = new ArrayList<RawType_Stamp>();
//      RawType_Stamp Stamp1 = new RawType_Stamp("Name1", "Description1");
//      RawType_Stamp Stamp2 = new RawType_Stamp("Name2", "Description2");
//      RawType_Stamp Stamp3 = new RawType_Stamp("Name3", "Description3");
//      Stamps.addAll(Arrays.asList(Stamp1, Stamp2, Stamp3));
//      RawType_Stamp Stamp4 = null;
//      for (RawType_Stamp s : Stamps) {
//          System.out.println(s.getName() + "," + s.getDescription());
//      }
//
//      for (Iterator<RawType_Stamp> i = Stamps.iterator(); i.hasNext();) {
//          Stamp4 = i.next();
//          System.out.println(Stamp4.getName() + "," + Stamp4.getDescription());
//      }
//      
      
//      List<String> strings = new ArrayList<String>();
//        unsafeAdd(strings ,new String(" srb"));
//        String s = strings.get(0); 
  }
    
    private static void unsafeAdd(List  list, Object o) {
        list.add(o);
    }
    
    /**
     * Exemple de unbounded widcard type
     * @param s1
     * @param s2
     * @return 
     */
    static int numElementsInCommon(Set<?> s1, Set<?> s2) {
        int result = 0;
        for (Object o1 : s1) {
            if (s2.contains(o1)) {
                result++;
            }
        }
        return result;
    }
    
    /**
     * 
     * @param  utiliser une méthode avec rawtype safely (Case Instance OF)
     * @return 
     */
    public static boolean TestInstanceOfSet(Object o)
    {
        if (o instanceof Set) { // Raw type
            Set<?> m = (Set<?>) o; // Wildcard type         
            return true;
        } else {
            return false;
        }
    }
    
    
}
