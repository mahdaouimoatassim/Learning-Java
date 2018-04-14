/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Concurency;

/**
 *
 * @author El Mouatassim Billah
 */
public class LazyInitilizationExemple {
  
 //   private final int field = 1;
    
    private String LazyInitialed;

    synchronized String getLazyInitialed() {
        if (LazyInitialed == null) {
            LazyInitialed = "la variable est lazyInitialed";
        }
        return LazyInitialed;
    }   
    
    //    case of Static field LazyInitializationHolderClass
    
    private static class FieldHolder {

        static final String field = "LazyIniialedStaticFeild";
    }

    static String getField() {
        return FieldHolder.field;
    }
    
  //    case of instance field  Dooble Check
    
    private volatile String field;

    String getField2() {
        String result = field;
        if (result == null) { // First check (no locking)
            synchronized (this) {
                result = field;
                if (result == null) // Second check (with locking)
                {
                    field = result = "FirstInitialization";
                }
            }
        }
        return result;
    }
    
     //    case of instance field with support multiple Initialization Single Check
    
    private volatile String field2;

    private String  getField3() {
        String  result = field;
        if (result == null) {
            field = result = "First Initilization";
        }
        return result;
    }
}
