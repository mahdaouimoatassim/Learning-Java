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
public class ThreadGroupExample extends Thread {
    
     private String word; // what word to print
    private int delay; // how long to pause
    //private ThreadGroup Group;
    public ThreadGroupExample(String whatToSay, int delayTime, String Name,ThreadGroup Group) {
        super(Group, Name);
        word = whatToSay;
        delay = delayTime;        
    }

    public void run() {
        try {
            for (int i=0;i <100; i++) {
//                System.out.println(word + " ");
//                System.out.println(this.getName()); 
//                System.out.println(this.getName()+this.getStackTrace());
//                System.out.println(this.getName()+this.getPriority());
//                System.out.println(this.getName()+this.getId());
//                System.out.println(this.getName()+this.getState());
//                System.out.println(this.getName()+this.getThreadGroup());
//                System.out.println(this.getName()+this.getClass());
                Thread.sleep(delay); 
                
            }
        } catch (InterruptedException e) {
            return; 
        }
    }

    public static void main(String[] args) {
      
       ThreadGroup group1= new ThreadGroup("groupe1");
       
       ThreadGroupExample thread1= new ThreadGroupExample("Thread1", 10,"Thread1",group1);
       thread1.start(); 
       System.out.println(" Thread 1 group "+thread1.getThreadGroup().getName());
       ThreadGroupExample thread2= new ThreadGroupExample("Thread2", 20,"Thread2",group1);
       thread2.start(); 
       System.out.println(" Thread 2 group "+thread2.getThreadGroup().getName());
       ThreadGroupExample thread3= new ThreadGroupExample("pThread3", 30,"Thread3",group1);
       thread3.start(); 
       System.out.println(" Thread 3 group "+thread1.getThreadGroup().getName());
       
      ;
       
    }

    
}
