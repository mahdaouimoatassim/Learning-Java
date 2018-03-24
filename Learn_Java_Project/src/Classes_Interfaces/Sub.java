/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes_Interfaces;

import java.util.Date;


/**
 *
 * @author El Mouatassim Billah
 */
public class Sub extends Super{
    private final Date date; // Blank final, set by constructor

    Sub() {
        date = new Date();
    }
// Overriding method invoked by superclass constructor

    @Override
    public void overrideMe() {
        System.out.println(date);
    }

    public static void main(String[] args) {
        Sub sub = new Sub();
        sub.overrideMe();
    }
}
