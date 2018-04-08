/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Concurency;

/**
 *
 * @author El Mouatassim Billah
 * 
 * cette classe représente un compte banquaire  et qui implémente le design Server-Side Sunchronization
 * 
 */
public class BankAccount {
    
    
    
    private long number; // account number
    private long balance; // current balance (in cents)

    public BankAccount(long initialDeposit) {
        balance = initialDeposit;
    }

    public synchronized long getBalance() {
        return balance;
    }

    public synchronized void deposit(long amount) {
        balance += amount;
    }
    
    public static void abs(int[] values,int[] lenght) {
        synchronized (values) {
             synchronized (lenght) {
            for (int i = 0; i < values.length; i++) {
                if (values[i] < 0) {
                    values[i] = -values[i];
                }
            }
             }
        }
}
 // 
}
