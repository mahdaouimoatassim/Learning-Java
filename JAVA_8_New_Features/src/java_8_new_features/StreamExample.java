/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_8_new_features;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;
import java.util.stream.*;
/**
 *
 * Cette Classe represente l'ensemble de teste pour la nouvelle fonctionnalité Stream
 * 
 * @author El Mouatassim Billah
 */


public class StreamExample {
    
    /**
     * Classe Qui represente un Etudiant
     * 
     * Cette classe est implémenté dans l'exemple 1 
     */
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
    /**
     * Classe Qui represente un employe au sein du service DWH
     * 
     * Cette Classe est implémenté dans l'exemple 5: lire a partir d'un fichier l'ensemble d'employer comme string puis creer un stream de cette classe
     */
     private static class EmployeDWH implements Comparable<EmployeDWH>
    {

      
         /**
          * Enumeration qui represente les equipes du service Datawarehouse 
          */
         public enum Equipe { ChefService, DataQualite, ETL, Operation, Reporting }
         /**
          * Enumeration qui represente les equipes du service Datawarehouse 
          */
         public enum Profile { EmployeOoredoo, ConsultantSA}
         /**
         * @param FirstName The Employe’s First name
         */
        String FirstName;
        /**
         * @param LastName The Employe’s last name
         */
        String LastName;
        /**
         * @param equipe The Employe’s Equipe in DWH Service
         */
        Equipe equipe;
        /**
         * @param Age The Employe’s Age
         */
        int Age;
        /**
         * @param Experience String that represent The Employe’s Experience
         */
       String Experience;
         /**
         * @param profile the employe's Profile
         */
       Profile profile;   
       
       /**
        * Constructor of class EmployeDWh
        * @param FirstName 
        * @param LastName
        * @param equipe
        * @param Age
        * @param experience
        * @param profile 
        */
        public EmployeDWH(String FirstName, String LastName, Equipe equipe, int Age,String experience, Profile profile) {
            this.FirstName = FirstName;
            this.LastName = LastName;
            this.equipe = equipe;
            this.Age = Age;
            this.Experience=experience;
            this.profile=profile;
        }
        
        /**
         * Constructor that create a employe from a string
         * 
         * @param t  Stream de String
         */
        
        public EmployeDWH(String t)
        {
        String[] ListValue=t.split(",");      
        this.FirstName=ListValue[0].trim();
        this.LastName=ListValue[1].trim();
        this.equipe=Equipe.valueOf(ListValue[2].trim()) ;
        this.Age=Integer.parseInt(ListValue[3].trim());
        this.Experience=ListValue[4].trim();
        this.profile=Profile.valueOf(ListValue[5].trim());
        }
        
        @Override
        public String toString()
        {
        String  Result="************* Description Employe DWH *****************\n";             
        Result+="Je m'appele "+this.FirstName+" "+this.LastName+"\n";
        Result+="Je suis membres de l'équipe : "+this.equipe+"\n";
        Result+="J'ai: "+this.Age+"et j'ai "+this.Experience+"\n";
        Result+="Je travaille en tant que : "+this.profile+"\n";
        Result+="*******************************************************\n\n";
        return Result;
        }
        
        @Override
        public int compareTo(EmployeDWH o) {
             return this.Age-o.Age;
        }        

    }
    public static void main(String args[]) 
    {
    
        //Stream from A List  --Exemple 1--.
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
    
        
        //stream from an Int Range  --Exemple 2--
        System.out.println(
                IntStream.range(1, 20)
                 .skip(8)
                .sum());
                //.forEach(p->System.out.println(p));
    
        //Stream From list value    --Exemple 3--
        Stream.of("Mahdaoui","Ghazi","Mebbani")
                .sorted()
                .findFirst()
                .ifPresent((System.out::println));
        
        //Stream From an Arrays     --Exemple 4--
        
        String[] Names={"Amine","Mohamed","Tarek","Islem","Rabah"};
        Arrays.stream(Names)
                .filter(x -> x.startsWith("M"))
                .sorted()
                .forEach(System.out::println);
        
        Arrays.stream( new int[]{1,2,3,4,5})
                .map(p-> p*p)
                .limit(4)
                .average()
                .ifPresent(System.out::println);
        Arrays.stream(Names)
                .map(String::toLowerCase)
                .filter(p->p.startsWith("t"))
                .forEachOrdered(System.out::println);
                      ;
                      
                      
        //Stream for files    --Exemple 5--
                      
                      
        try {
           
            Stream<String> name_employe_DWH = Files.lines(Paths.get("names.txt"));
            name_employe_DWH.sorted().forEach(System.out::println);
            name_employe_DWH.close();
            
            //Collecter les lignes dans une liste       
            List<String> name_employe_DWH2 = Files.lines(Paths.get("names.txt")).collect(Collectors.toList());
            name_employe_DWH2.forEach(x->System.out.println(x.trim()));
            name_employe_DWH.close();
            
            
            // Afficher la liste des employe DWH
            Stream<EmployeDWH> LisEmploye=Files.lines(Paths.get("Employe_DWH.txt")).map(r->new EmployeDWH(r));
            LisEmploye.forEach(x->System.out.println(x.toString()));
           
            
            
            // Initialiser un fournisseur de <Stream<EmployeDWH>
            Supplier<Stream<EmployeDWH>> streamSupplier = () -> {
                try {
                  return  Files.lines(Paths.get("Employe_DWH.txt")).map(r->new EmployeDWH(r));
                } catch (IOException ex) {
                    Logger.getLogger(StreamExample.class.getName()).log(Level.SEVERE, null, ex);
                    return Stream.of(new EmployeDWH("Import File FAILED","LastName",EmployeDWH.Equipe.ETL,20,"",EmployeDWH.Profile.ConsultantSA));
                }
            };
            
            //Afficher les membres de l'équipe reporting
            System.out.println("Le nombre de membres reporting est "+streamSupplier.get().filter(p->p.equipe==EmployeDWH.Equipe.Reporting).count()+"\n") ;            
            Stream<EmployeDWH> ReporingEquiqe=streamSupplier.get().filter(p->p.equipe==EmployeDWH.Equipe.Reporting);
            ReporingEquiqe.forEachOrdered(p->System.out.println(p.toString()));
            ReporingEquiqe.close();
      
            //Afficher les Consultant
            System.out.println("Le nombre de consultants est "+streamSupplier.get().filter(p->p.profile==EmployeDWH.Profile.ConsultantSA).count()+"\n") ;            
            Stream<EmployeDWH> COnsultants=streamSupplier.get().filter(p->p.profile==EmployeDWH.Profile.ConsultantSA);
            COnsultants.forEachOrdered(p->System.out.println(p.toString()));               
            COnsultants.close();
            
                
        } catch (IOException ex) {
            System.out.println(ex.getCause());
        }
                      
        
        
        //              
    }
    
    
}
