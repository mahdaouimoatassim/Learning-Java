/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Concurency;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import sun.misc.Queue;

/**
 *
 * @author El Mouatassim Billah
 */
public class ConcurrentCollectionExample {
   /**
    * 
    *   Implémentation de ConcurrentHashMap
    * 
    */ 
    private static final ConcurrentMap<String, String> map = new ConcurrentHashMap<String, String>();

    private static HashMap <String ,String> map2= new HashMap<String ,String>();
    private static TreeMap <String ,String> map3= new TreeMap<String ,String>();
    
    public static String intern(String s) {
        String previousValue = map.putIfAbsent(s, s);
        return previousValue == null ? s : previousValue;
    }
//Too Faster beceause it use Get.
    public static String intern2(String s) {
        String result = map.get(s);
        if (result == null) {
            result = map.putIfAbsent(s, s);
            if (result == null) {
                result = s;
            }
        }
        return result;
    }
    
   /**
    * 
    *   Implémentation de BlockingQueue
    * 
    */  
    
    private static final BlockingQueue<String> Queue1= new ArrayBlockingQueue<String>(15);
   // private static Queue<String> Queue2=new Queue<String>();

    
    /**
    * 
    *   Implémentation des synchronisateurs
    * 
    */ 
    private static CountDownLatch t= new CountDownLatch(1); 
    
        /***
     * Fonction implémenté en utilisant CyclicBarrier
     * 
     * @param executor
     * @param concurrency
     * @param action
     * @return
     * @throws InterruptedException 
     */
    
    
//    
//    public static long time2(ExecutorService executor, int concurrency, final Runnable action) throws InterruptedException {
//   
//        long time=0;   
//      final CyclicBarrier barrier= new CyclicBarrier(concurrency);
//      try{
//      for (int i = 0; i < concurrency; i++) {
//            executor.execute(new Runnable() {
//                public void run() {
//                    try {
//                   System.out.println(barrier.getNumberWaiting()+"....1");     
//                    barrier.await(); // Tell timer we're ready
//                    
//                       System.out.println(barrier.getNumberWaiting()+"....5");  
//                       barrier.await(); // Wait till peers are ready
//                        action.run();
//                    } catch (InterruptedException e) {
//                        Thread.currentThread().interrupt();
//                    } catch (BrokenBarrierException C) {
//                        Thread.currentThread().interrupt();
//                    }  finally {
//              //          barrier.await(); // Tell timer we're done
//                    }
//                }
//            });
//        }
//      
//      System.out.println(barrier.getNumberWaiting()+"....2");
//        barrier.await(); // Wait for all workers to be ready
//       System.out.println(barrier.getNumberWaiting()+"....3");
//        long startNanos = System.nanoTime();
//        barrier.reset(); // And they're off!
//        System.out.println(barrier.getNumberWaiting()+"....4");
//        barrier.await(); // Wait for all workers to finish
//        
//        time=System.nanoTime() - startNanos;
//      }
//      catch(BrokenBarrierException B)
//      {B.printStackTrace();}
//       catch(InterruptedException V)
//      {V.printStackTrace();} 
//      finally
//      {
//       executor.shutdown();
//        return time;
//      }
//    }

        public static long time2(ExecutorService executor, int concurrency, final Runnable action) throws InterruptedException {

        long time = 0;
        final CyclicBarrier barrier = new CyclicBarrier(concurrency);
        try {
            for (int i = 0; i < concurrency; i++) {
                executor.execute(new Runnable() {
                    public void run() {
                        try {
                            action.run();
                            barrier.await();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        } catch (BrokenBarrierException C) {
                            Thread.currentThread().interrupt();
                        } finally {
                            //          barrier.await(); // Tell timer we're done
                        }
                    }
                });
            }

            long startNanos = System.nanoTime();
            barrier.await(); // Wait for all workers to be ready
            System.out.println(barrier.getNumberWaiting() + "....1");
            barrier.reset();
            System.out.println(barrier.getNumberWaiting() + "....2");
            executor.shutdown();
            time = System.nanoTime() - startNanos;
        } catch (BrokenBarrierException B) {
            B.printStackTrace();
        } catch (InterruptedException V) {
            V.printStackTrace();
        } finally {

            return time;
        }
    }
    
    /***
     * Fonction implémenté en utilisant CountDownLatch
     * 
     * @param executor
     * @param concurrency
     * @param action
     * @return
     * @throws InterruptedException 
     */
    
    
    
    public static long time(ExecutorService executor, int concurrency, final Runnable action) throws InterruptedException {
        final CountDownLatch ready = new CountDownLatch(concurrency);
        final CountDownLatch start = new CountDownLatch(1);
        final CountDownLatch done = new CountDownLatch(concurrency);
        
        final CyclicBarrier barrier= new CyclicBarrier(12);
      
        for (int i = 0; i < concurrency; i++) {
            executor.execute(new Runnable() {
                public void run() {
                    ready.countDown(); // Tell timer we're ready
                    try {
                        start.await(); // Wait till peers are ready
                        action.run();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    } finally {
                        done.countDown(); // Tell timer we're done
                    }
                }
            });
        }
        ready.await(); // Wait for all workers to be ready
        long startNanos = System.nanoTime();
        start.countDown(); // And they're off!
        done.await(); // Wait for all workers to finish
        executor.shutdown();
        return System.nanoTime() - startNanos;
    }

    
    public static void main(String args[]) throws InterruptedException
    {
//        map.put("One", "Mahdaoui1");
//        map.put("Two", "Mahdaoui2");
//        map.put("Three", "Mahdaoui3");
//        map.put("Foor", "Mahdaoui4");
//// System.out.println(map.replace("Two", "Teste2"));
//        for (Map.Entry<String, String> s : map.entrySet()) {
//            System.out.println("la clé est : " + s.getKey() + " et la valeur = " + s.getValue());
//        }
//   
   /////////////////////////////////////////////////////////////////// 
//    
//        for (int i = 1; i <= 5; i++) {       //Initialisaion de la Queue
//            Queue1.offer("Mahdaoui" + i);
//        }
//        System.out.println(Queue1.poll()); //  Get and delete the element ; Null if vide
//        System.out.println(Queue1.peek()); // Get without deleting the element  ; Null si vide
//
//        System.out.println(Queue1.take());  // Get the element and wait until presence of element
//        System.out.println("Debut Print Queue Value");
//        for (String arg : Queue1) {
//
//            System.out.println(arg);
//
//        }
//    
     /////////////////////////////////////////////////////////////////// 
        
         Runnable Runnable_interface =new Runnable() {
            public void run() {
               
                    System.out.println("Je Suis la tache ");
      
            }

        };
  
        
      System.out.println(time2(Executors.newFixedThreadPool(5), 5 , Runnable_interface));
       
    }

    
    
    
    
}
