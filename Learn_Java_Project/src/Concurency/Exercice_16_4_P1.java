/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Concurency;

import java.util.concurrent.TimeUnit;

/**
 * Implementation de l'exercice 14.6 du livre : Java Programming language
 *Exemple 1 : résoudre l'exercice avec deux thread creer au niveau de la meme classe.
 * 
 * Implementation selon le design pattern Client side synchronisation
 * 
 * @author El Mouatassim Billah
 */
public class Exercice_16_4_P1 {
    
    private static volatile Integer compteur=0;
    private static boolean state=false;
    
        
    public static void main(String[] args)
    {
    /*****************************  Thread 1 Declaration   ************************************/
    Thread thread1= new Thread(new Runnable() {

        @Override
        public void run() {
             synchronized (compteur) {
                for (int i = 0;; i++) {
                    try {
                        System.out.println("Entrer au niveau du thread 1");
                        System.out.println(Thread.holdsLock(compteur));
                        
                        System.out.println("Hello  " + i);

                        compteur = compteur + 1;
                        if (compteur==15) {i=0;}
                        else ;
                        System.out.println(compteur);
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println(Thread.holdsLock(compteur));// Voir si le thread lock la variable compteur
               
                        compteur.notify();
                        //compteur.notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    }
                }
            }
        
    }) ;
    
    /*****************************  Thread 2 Declaration   ************************************/
    
    
      Thread thread2= new Thread(new Runnable() {

          @Override
          public void run() {

              synchronized (compteur) {

                  try {
                      for (int i = 0;; i++) {

                          System.out.println("Entrer au niveau du thread 2");
                          System.out.println(Thread.holdsLock(compteur));
                          while (compteur != 15) {
                              compteur.wait();
                          }
                          System.out.println("mahdaouie");

                      }
                  } catch (InterruptedException i) {
                      // System.out.println("Le 2 ème Thread a été interompu");
                      i.printStackTrace();

                  }
              }
            

            }
        
    }) ;  
    /****************************************************************/
      thread1.setPriority(Thread.MAX_PRIORITY);
      thread2.start();
      thread1.start();
      
    }
    
    public void Print_System_Time(Print print1)
    {
//   print1.settime(System.get);
    System.out.println(print1.getTexte());
    print1.setconteur(print1.getconteur()+1);
    }
}
