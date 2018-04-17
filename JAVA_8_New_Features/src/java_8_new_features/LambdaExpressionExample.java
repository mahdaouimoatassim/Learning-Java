/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_8_new_features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.stream.IntStream;

/**
 * Cette Classe represente l'ensemble de teste pour la nouvelle fonctionnalité Lambda Expression
 * @author El Mouatassim Billah
 */
public class LambdaExpressionExample {

    
    
    
    
   /**
    * Methode qui permet d'illuster une implémentation de l'expression Lambda avec l'interface runnable
    */ 
    public static void ExampleLambdaRunnableImplementation(){

        Thread ThreadExemple = new Thread(()->
        {
            for (int i =1;i<10;i++)
            {
                try{
                System.out.println("Temps Passé : "+System.nanoTime()+"en nano time, "+System.currentTimeMillis()+"En millis seconde");
                Thread.sleep(1000);
                }
                catch (InterruptedException e)
                {
                    e.getCause();
                }catch(NullPointerException s)
                    {
                    s.getCause();
                    }
            }
            
        });
        ThreadExemple.start();
}
    
    /**
     * 
     * Exemple d'Implémentation d'une interface comparable avec un tabeau de string
     * 
     */
    /////// Fonction qui affiche la liste des valeurs contenus dans un tableau
    public static void AfficherTableau(String[] Tab_Str) {
        
        System.out.print("Les Valeurs initiales de la table sont : {");
        for (int i = 0; i < Tab_Str.length - 1; i++) {
            System.out.print(Tab_Str[i] + ",");
        }
        System.out.println(Tab_Str[Tab_Str.length - 1] + "}");
      
    }

    public static String[] ExampleLambdaComparableImplementation(String[] Tab_Str) {
        
        AfficherTableau(Tab_Str);
        Arrays.sort(Tab_Str, (String t1, String t2) -> t2.length() - t1.length());
        AfficherTableau(Tab_Str);
        return Tab_Str;

    }

    /**
     * 
     * Interface qui offre la fonction indiquant si l'entier est premier ou pas
     * 
     */
    
    interface Prime_Number{
    
        Boolean IsPrime(int Number);
    }
    
    /**
     * 
     *  Classe Student 
     * 
    */
    
    private static class student
    {
    String FirstName,LastName;
    int Age;
    boolean IsDiplomed;
 
        public student(String FirstName, String LastName, int Age, boolean IsDiplomed) {
            this.FirstName = FirstName;
            this.LastName = LastName;
            this.Age = Age;
            this.IsDiplomed = IsDiplomed;
            
        }
   
    } 
    
    /**
     * 
     *  Fonction qui calcule la somme des integers avec un predicat.
     * 
    */ 
     public static int sumWithCondition(List<Integer> numbers, Predicate<Integer> predicate) {
	    return numbers.parallelStream()
	    		.filter(predicate)
	    		.mapToInt(i -> i)
	    		.sum();
	}
    
public static void main(String args[])
{
    
    /**
     * 
     * Exemple of implementation of Runnable Interface with LambdaExpression
     * 
     */
    
      ExampleLambdaRunnableImplementation();
    
    /**
     * 
     * Exemple of implementation of Comparable Interface with LambdaExpression
     * 
     */  
      String[] Tab_Str_Ins={"Five","One","Three"};
      ExampleLambdaComparableImplementation(Tab_Str_Ins);
    
      
      /**
     * 
     * Exemple of implementation of Test_¨Prime Interface (Defined in this class) with LambdaExpression
     * 
     */ 
    Prime_Number Test_Prime1 = (int number)->{
    
    	if(number < 2) return false;
	for(int i=2; i<number; i++){
		if(number % i == 0) return false;
	}
	return true;
    };
    Prime_Number Test_Prime2 = (int number)->{
        
    return number > 1 && IntStream.range(2, number).noneMatch(
					index -> number % index == 0);    
         
    };
    
    System.out.println(Test_Prime2.IsPrime(15));
 

    /**
    *  Example of some Functionnal Interface Implementation
    */    
    ////////// Functionnal Abject that concatenate two string.
    BiFunction<String,String,String> Concatenation =(String i,String s)->{ return s+i; };
    System.out.println(Concatenation.apply("Mahdaoui", "Elmoutassim billah"));
    
    
    ////////// Functionnal Abject that check if a student is able to work or none.
    Predicate <student> IsAbleToWork = s  -> { return s.Age > 18 ? s.IsDiplomed : false ; };
    if(IsAbleToWork.test(new student("Mahdaoui", "MoatassimBillah", 24 , true))) System.out.println("Vous etes capable de travailler");
    else System.out.println("Vous n'etes pas encore capable de travailler"); 
    
    ////////// Functionnal Abject that print the int factorial.
    IntConsumer Factorial=(int i)->{
    int result=1; 
        if (i > 2) {
            for (int s = 1; s <= i; s++) {
                   result=s*result;
            }
        }
        System.out.println("Le factorial du "+i+" est : "+ result);
    };
    Factorial.accept(4);
    
    /**
     * 
     * Functionnal methode implementation in parameter
     * 
    */
    List<Integer> List_Number=new ArrayList<Integer>();
    List_Number.addAll(Arrays.asList(12,15,487,54,21,13,45));
    int Somme_paire=sumWithCondition(List_Number,  i -> {return i%2 == 0 ;});
    int Somme_impaire=sumWithCondition(List_Number, (Integer i) -> {return i%2 == 1 ;});
    int Somme_total=sumWithCondition(List_Number, (Integer i) -> {return true ;});
    System.out.println(Somme_paire);
    System.out.println(Somme_impaire);
    System.out.println(Somme_total);
     
}
    
    
}

