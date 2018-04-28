/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author El Mouatassim Billah
 */
public class Test {
 
    
     public static void main(String[] arg) {
     
         /******************************   Initialiser le Schéma *******************************/
         
         ArbreRectangle rec33 = new ArbreRectangle(33,new ArbreRectangle(12),new ArbreCercle("D".charAt(0)));
         ArbreRectangle rec8 = new ArbreRectangle(8,new ArbreCercle("E".charAt(0)),null);
         ArbreCercle cerC = new ArbreCercle("C".charAt(0),rec8,rec33);
         ArbreCercle cerB = new ArbreCercle("B".charAt(0),null,cerC);
         ArbreCercle cerF = new ArbreCercle("F".charAt(0),new ArbreCercle("G".charAt(0)),null);
         ArbreRectangle rec5 = new ArbreRectangle(5,cerF,new ArbreRectangle(7));
         ArbreCercle cerA = new ArbreCercle("A".charAt(0),rec5,cerB);
         System.out.println("sfv");
         /*****************************    Calculer la somme de cette arbre  ***************************************/
         System.out.println(cerA.somme());
         
         /******************************    Affichage du schéma de l'arbre**********************/
         cerA.ParcoursPreOrder();
         System.out.println("*****************************************");
         cerA.ParcoursInOrder();
         System.out.println("*****************************************");
         cerA.ParcoursPostOrder();
         System.out.println("*****************************************");
         System.out.println(cerA.ExpressionArbreHauteur());
         System.out.println("*****************************************");
         System.out.println(cerA.ExpressionArbreNiveau(1));
         System.out.println("*****************************************");
         String[] Tableau_arbre=cerA.ExpressionArbreNiveau(1).split("/");
         
     //  
         
        // creer une table a deux dimensions qui contien le détail de tous les noeuds 
         
         String[][] valeur_arbre=new String[Tableau_arbre.length][4];
         for (int i =0 ; i<Tableau_arbre.length;i++)
         {
             for(int j =0; j<4;j++)
             {
             valeur_arbre[i][j]=Tableau_arbre[i].split("_")[j];
             System.out.println(valeur_arbre[i][j]+"_"+i+"_"+j);
             
             }
             System.out.println("--------------------------------------------------");
         }
         
         // creer le tableau qui contient les valeurs de la liste précedente
         String[] Ligne_Precedente=new String[(int)Math.pow(2, 4)];
         String[] Ligne_Actuelle=new String[(int)Math.pow(2, 4)];
        try{ 
        System.out.println("--------------------------------------------------");
        int niveau_seq_creation;
        int niveau_seq_affichage;
        //afficher les valeurs de l'arbre
         for (int k = 1; k < 6; k++) {
             niveau_seq_creation = 1;
             niveau_seq_affichage=1;
          
             Ligne_Precedente=Ligne_Actuelle;
             System.out.println("table de ligne "+Ligne_Actuelle[0]+"_"+Ligne_Actuelle[1]+"_"+Ligne_Actuelle[2]+"_"+Ligne_Actuelle[3]+"_"+Ligne_Actuelle[4]+"_"+Ligne_Actuelle[5]+"_");
             System.out.println("table de ligne "+Ligne_Precedente[0]+"_"+Ligne_Precedente[1]+"_"+Ligne_Precedente[2]+"_"+Ligne_Precedente[3]+"_"+Ligne_Precedente[4]+"_"+Ligne_Precedente[5]+"_");
             for (int i = 0; i < valeur_arbre.length; i++) {

                 if (Integer.parseInt(valeur_arbre[i][0]) == k) {
                     
                     if (k != 1) {
                         
                        while (Ligne_Precedente[niveau_seq_affichage-1].compareTo("null") == 0 && niveau_seq_affichage-1<Math.pow(2, k)) {
                             System.out.print("null\t **");
                             System.out.print(Ligne_Precedente[niveau_seq_affichage-1]+"**");
                             System.out.print(niveau_seq_affichage-1);
                             niveau_seq_affichage++;
                           
                         } 
                             System.out.print(valeur_arbre[i][1] + "\t");
                             niveau_seq_affichage++;
                           
                         
                     }else
                     {System.out.print(valeur_arbre[i][1] + "\t");
                     niveau_seq_affichage++;
                     //System.out.print("3****");
                     }
                  
                     //   Initialiser la ligne précédente pour utilisé au niveau de la ligne suivante
                     Ligne_Actuelle[niveau_seq_creation * 2 - 2] = valeur_arbre[i][2];
                     Ligne_Actuelle[niveau_seq_creation * 2 - 1] = valeur_arbre[i][3];
                     niveau_seq_creation++;
                     
                 }//System.out.print("*"+niveau_seq_creation+"*");
             }//System.out.print(compteur);
             System.out.println("\n");
        }
        }catch (Exception e){e.printStackTrace();}
     }
    
}
