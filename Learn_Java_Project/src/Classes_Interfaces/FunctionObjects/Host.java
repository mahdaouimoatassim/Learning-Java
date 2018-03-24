/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes_Interfaces.FunctionObjects;

import java.io.Serializable;

/**
 *
 * @author El Mouatassim Billah
 */
public class Host {

    private static class StrLenCmp
            implements Comparator<String>, Serializable {

        public int compare(String s1, String s2) {
            return s1.length() - s2.length();
        }
    }

    public static final Comparator<String> STRING_LENGTH_COMPARATOR = new StrLenCmp();


}
