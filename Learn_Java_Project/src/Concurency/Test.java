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
public class Test {
 
    
      public void run() {
        try {
            for (int i=0;i <1; i++) {

                Thread.sleep(1000); 
               
            }
        } catch (InterruptedException e) {
            return; 
        }
    }
    
}
