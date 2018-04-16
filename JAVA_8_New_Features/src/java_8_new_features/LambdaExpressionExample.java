/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_8_new_features;

import java.util.Arrays;

/**
 *
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
    
    public static void AfficherTableau(String[] Tab_Str) {
        
        System.out.print("Les Valeurs initiales de la table sont : {");
        for (int i = 0; i < Tab_Str.length - 1; i++) {
            System.out.print(Tab_Str[i] + ",");
        }
        System.out.println(Tab_Str[Tab_Str.length - 1] + "}");
      //  System.out.println(
    }

    public static String[] ExampleLambdaComparableImplementation(String[] Tab_Str) {
        
        AfficherTableau(Tab_Str);
        Arrays.sort(Tab_Str, (String t1, String t2) -> t2.length() - t1.length());
        AfficherTableau(Tab_Str);
        return Tab_Str;

    }

public static void main(String args[])
{
  //ExampleLambdaRunnableImplementation();
    String[] Tab_Str_Ins={"Five","One","Three"};
    ExampleLambdaComparableImplementation(Tab_Str_Ins);
    
}
    
    
}

