/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Concurency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author El Mouatassim Billah
 */
public class ExecutorServiceExemple {
    
    public static void main(String mahdaoui[])
    {
    ExecutorService executor =  Executors.newSingleThreadExecutor();
    ExecutorService executor2 = Executors.newFixedThreadPool(5);
    ExecutorService executor6 = Executors.newCachedThreadPool();    
    
    Runnable Runnable_interface =new Runnable() {
            public void run() {
                for (int i = 1; i < 6; i++) {
                    System.out.println("Teste Avec l'Interface Runnable");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException s) {
                        s.printStackTrace();
                    }
                }
            }

        };
    Runnable Runnable_interface2 = new Runnable() {

            public void run() {
                for (int i = 1; i < 12; i++) {
                    System.out.println("Premier teste avec la méthode Executor");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException s) {
                        s.printStackTrace();
                    }
                }
            }

        };

    
        executor6.execute(Runnable_interface2);
    /**************************
     * 
     * Essayer si l'éxecutor peut changer 'interface Runnable qui'il utilise.
     * 
     * Conclusion : les taches sont empilé dans le scheduler si il est de type newSingleThreadExecutor .
     * si il est de type newFixedThreadPool, les peuvent etre éxécuté simultanément selon le nombre de trhread.
     */
    
        executor6.submit(Runnable_interface);
 
   /**
    *   Tester e submit avec le Future et les deux interface Runnable et Callable 
    */ 

  
        Future future = executor2.submit(new Runnable() {

            public void run() {
                System.out.println("Future Thread with runnable");
            }
        });

         Future future2 = executor2.submit(new Callable() {

            @Override
            public Object call(){
                System.out.println("Future Thread with callable");
                return  ("callable result");
            }
        });
        
        try{  
        future.get();
        System.out.println(future2.get());
        }catch(Exception o){ o.printStackTrace(); }
     
      executor2.shutdown();

      /**
       * 
       * Teste d'une Tache programme
       * 
       */
      
        ScheduledExecutorService executor3 = Executors.newScheduledThreadPool(5);      
       // executor3.schedule(Runnable_interface, 10, TimeUnit.SECONDS);
        executor3.scheduleAtFixedRate(Runnable_interface,10, 2 , TimeUnit.SECONDS);
        executor3.shutdown();
    }
    
    
}
