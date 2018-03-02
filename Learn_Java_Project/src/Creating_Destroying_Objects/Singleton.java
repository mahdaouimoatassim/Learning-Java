/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Creating_Destroying_Objects;

import java.io.Serializable;

/**
 *
 * @author El Mouatassim Billah
 */
public class Singleton implements Serializable {

    private Singleton() {
    }
    ;
    
private static final Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    }

    private Object readResolve() {
        return instance;
    }

}
