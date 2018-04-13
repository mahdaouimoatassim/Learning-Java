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
 * cette classe represent un exemple d'un thread
 * 
 */
public class PingPong extends Thread {
    
    private String word; // what word to print
    private int delay; // how long to pause

    public PingPong(String whatToSay, int delayTime, String Name) {
        word = whatToSay;
        delay = delayTime;
        this.setName(Name);
    }

    public void run() {
        try {
            for (int i=0;i <1; i++) {
                System.out.println(word + " ");
                System.out.println(this.getName()); 
                System.out.println(this.getName()+this.getStackTrace());
                System.out.println(this.getName()+this.getPriority());
                System.out.println(this.getName()+this.getId());
                System.out.println(this.getName()+this.getState());
                System.out.println(this.getName()+this.getThreadGroup());
                System.out.println(this.getName()+this.getClass());
                Thread.sleep(delay); 
                
            }
        } catch (InterruptedException e) {
            return; 
        }
    }

    public static void main(String[] args) {
        new PingPong("ping", 33,"ping").start(); 
        new PingPong("PONG", 100,"PONG").start(); 
        
    }

    
}
