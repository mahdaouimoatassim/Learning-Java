/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_8_new_features;


import java.util.concurrent.*;
import java.lang.*;
/**
 *
 * @author El Mouatassim Billah
 */
public class ConcurrenceExample {
    
    public static void main(String[] args)
    {
    
        CompletableFuture CF=CompletableFuture.completedFuture("message");
        
        
        ExecutorService service= Executors.newFixedThreadPool(5);

 /**
  * Example of execution of asynchronous task
  */           
            String Chaine="La commande est intialiser\n";
            CompletableFuture.supplyAsync(()-> {System.out.println("la commande a été récuperé");return "la commande a été récuperé";})
                    .thenApply((Chaine2)-> {System.out.println("la commande a été enrichit"); return "la commande a été enrichit";})
                    .thenApply((Chaine2)-> {System.out.println("la commande a été payé"); return "la commande a été payé";})
                    .thenApply((Chaine2)-> {System.out.println("la commande a été dispatcher"); return "la commande a été envoyé";});
            
  /**
   * Example of then Combine
   */       
            String original="Original";
            
            CompletableFuture cf = CompletableFuture.completedFuture(original).thenApply(s -> s.toLowerCase())
            .thenCombine(CompletableFuture.completedFuture(original).thenApply(s -> s.toLowerCase()),
                    (s1, s2) -> s1 + s2);
    System.out.println(cf.getNow(null));
    
    
    /**
     * 
     *  adding example of concurrent hashmap
     */
    
    ConcurrentHashMap<String,String> Map=new ConcurrentHashMap<>();
    
    
    for (int i=0; i<10; i++)
    {
        Map.put("mhdaoui"+i, "ElmoutasimBillah"+i);    
    }
    Map.put("mahdaoui", "ElmoutasimBillah"); 
    Map.forEach((s1,s2)-> System.out.println(s1+s2));
    System.out.println(Map.compute("mahdaoui1", (key, value)->  key+value));
    System.out.println(Map.search(5, (key,value)-> {
        
        if (key.contains("mah")) return "True";
        else return "False" ;
    
    } ));
    
    System.out.println(Map.reduce(100,(key,value)-> key.toLowerCase(), (count,discount)->count+discount));
    
    }
    
    
    }
    
    

