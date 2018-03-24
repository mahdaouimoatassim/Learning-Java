/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes_Interfaces.FunctionObjects;

/**
 *
 * @author El Mouatassim Billah
 */
public class StringLengthComparator {

    private StringLengthComparator() {
    }
    public static final StringLengthComparator INSTANCE = new StringLengthComparator();

    public int compare(String s1, String s2) {
        return s1.length() - s2.length();
    }
}
