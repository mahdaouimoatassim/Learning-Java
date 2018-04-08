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

import java.util.*;
public class Bank {
    /**
     *  cette classe permet d'ajouter des comptes à la banque et de supprimer 
     * des comptes en appliquant le principe de synchronisation et de notifications.
     * 
     */
    
    private ArrayList<BankAccount> queue = new ArrayList<BankAccount>();

    public synchronized void add(BankAccount j) {
        queue.add(j);
        notifyAll(); // Tell waiters: print job added
    }

    public synchronized BankAccount remove()
            throws InterruptedException {
        while (queue.size() == 0) {
            wait(); // Wait for a print job
        }
        int  size1=queue.size();
        return queue.get(size1-1);
    }
}
  
