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
    /**
     * Methode de teste pour le Item 24 eliminate unchecked Error.
     * @param <T>
     * @param a
     * @return 
     */
    public static <T> T[] toArray(T[] a) {
          int size=16;
        if (a.length < size) {
         @SuppressWarnings("unchecked") T[] result = (T[]) Arrays.copyOf(a, size, a.getClass());
         return result;
        }
        System.arraycopy(a, 0, a, 0, size);
        if (a.length > size) {
            a[size] = null;
        }
        return a;
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

    
    /**
     *  F
     *
     */
//    static Object reduce(List list, Function f, Object initVal) {
//        synchronized (list) {
//            Object result = initVal;
//            for (Object o : list) {
//                result = f.apply(result, o);
//            }
//            return result;
//        }
//    }

    static Object reduce(List list, Function f,RawType_Stamp initVal) {
        Object[] snapshot = list.toArray(); // Locks list internally
        RawType_Stamp result = initVal;
        for (Object o : list) {
            result = Function.apply(result,(RawType_Stamp)o);
        }
        return result;
    }
    
    interface Function {

        static RawType_Stamp apply(RawType_Stamp arg1, RawType_Stamp arg2)
        {
        return (new RawType_Stamp(arg1.getName()+arg2.getName(),arg1.getDescription()+arg2.getDescription()));
        };
    }

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
      

      /**
       * Test de l'Item 24 Eliminate unchecked warning
       */
      
//      Set<RawType_Stamp> exaltation = new HashSet();
//      
//      RawType_Stamp[] tableau1={new RawType_Stamp("1","1") ,new RawType_Stamp("2","2"),new RawType_Stamp("3","3"),new RawType_Stamp("4","4")};
//      RawType_Stamp[] tableau2=null;
//      
//      tableau2= toArray(tableau1);
//
//      System.out.println(tableau2[1].getName());
      
      
      /**
       * Test de l'Item 25 Prefer Lists To Array
       */
      
//      Object[] objectArray = new Long[1];
//      objectArray[0] = "I don't fit in";
//     
//      List<Object> ol = new ArrayList<Long>(); // Incompatible types
//      ol.add("I don't fit in");
//      
//      List<RawType_Stamp> Liste1= new ArrayList<>();
//      RawType_Stamp concatenation_list= null; 
//      concatenation_list= reduce(Liste1, Function , Liste1);
      
  }
  
  
      
    
}
