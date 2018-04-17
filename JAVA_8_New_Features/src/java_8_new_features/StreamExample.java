/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_8_new_features;

import java.util.*;
import java.util.stream.IntStream;
/**
 *
 * Cette Classe represente l'ensemble de teste pour la nouvelle fonctionnalité Stream
 * 
 * @author El Mouatassim Billah
 */


public class StreamExample {
    
    
    private static class student implements Comparable<student>
    {
           /**
         * @param FirstName The Student’s First name
         */
        String FirstName;
        /**
         * @param LastName The Student’s last name
         */
        String LastName;
        /**
         * @param Age The Student’s Age
         */
        int Age;
        /**
         * @param IsDiplomed Boolean that return if the student is diplomated
         */
        boolean IsDiplomed;
             
        public student(String FirstName, String LastName, int Age, boolean IsDiplomed) {
            this.FirstName = FirstName;
            this.LastName = LastName;
            
            this.Age = Age;
            this.IsDiplomed = IsDiplomed;
            
        }
      @Override
       public int compareTo(student o) throws ClassCastException {
        
        return (this.Age-o.Age);
     
      }
    }
    
    public static void main(String args[])
    {
    
        List<student> ListStudent=Arrays.asList(
                new student("Mahdi", "Adel", 26, true),
                new student("Amine", "Tekret", 31, true),
                new student("Yacine", "Mrabet", 18, false),
                new student("Islem", "Boudali", 30, true),
                new student("Anis", "Boutadjine", 23, false),
                new student("Ali", "Belhoussin", 19, true));
        
        ListStudent.stream()
                //.filter(p->p.Age > 20 && p.IsDiplomed==true)
                //.skip(1)
               // .sorted((student t1,student t2)-> t1.Age - t2.Age )
                .map( p -> p= new student(p.FirstName, p.LastName, p.Age+3, true))
                .forEach(p->System.out.println(p.LastName+" "+p.FirstName+" "+p.Age));
    
        
        
        System.out.println(
                IntStream.range(1, 20)
                 .skip(8)
                .sum());
                //.forEach(p->System.out.println(p));
        
    }
    
    
}
