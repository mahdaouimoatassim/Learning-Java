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
 
    
 
    /**
     * La fonction qui permet d'ajouter une valeur à un tableau à partir d'un index
     * @param s
     * @param index l'index de la colonne ou on ajoute l'element
     * @param Valeur 
     */
    
    public static String InsererEspace(int n)
    {
        String result = "";
        for (int i = 0; i < n; i++) {
            result += " ";
        }
        return result;
    }
    
    public static boolean AjouterCellule(String[] s, int index, String Valeur) {
        boolean result = true;
        if (index < s.length) {
            for (int i = 1; i < (s.length - index); i++) {
                s[s.length - i] = s[s.length - i - 1];
            }
            s[index] = Valeur;
        } else {
            result = false;
        }
        return result;
    }
     /**
      * 
      * @param MatriceArbre  la fonction qui permet de corriger cette matrice 
      * en ajoutant les null manquant a chaque linge
      * @param niveau   le niveau de cette arbre
      */
    public static void CorrigerMatrice(String[][] MatriceArbre,int niveau)
    {
          if (MatriceArbre[0][0]!=null)
        {
        String[] Ligne_Precedente_matrice = new String[(int) Math.pow(2, niveau-1)];
        String[] Ligne_Actuelle_matrice = new String[(int) Math.pow(2, niveau-1)];
        
        Ligne_Actuelle_matrice=MatriceArbre[2].clone();
        Ligne_Precedente_matrice=MatriceArbre[1].clone();
        
            for (int u = 2; u < niveau ; u++) {
                for (int e = 0; e < (int) Math.pow(2, niveau - 1); e++) {
                    if (Ligne_Precedente_matrice[e] == "*") {
                        AjouterCellule(Ligne_Actuelle_matrice, e * 2 ,"*");
                        AjouterCellule(Ligne_Actuelle_matrice, e * 2 + 1,"*");
                    }
                    MatriceArbre[u]=Ligne_Actuelle_matrice.clone();
                }
                Ligne_Precedente_matrice=Ligne_Actuelle_matrice.clone();
                if (u<4)
                {Ligne_Actuelle_matrice=MatriceArbre[u+1];}
            }
        
        }
       
    }
    public static  void AfficherMatrice(String[][] MatriceArbre)
    {
        for (int i = 0; i < MatriceArbre.length; i++) {
            for (int j = 0; j < MatriceArbre[0].length; j++) {
                
                if(MatriceArbre[i][j]!=null) System.out.print(MatriceArbre[i][j]+" ");
            }System.out.println("");
        }
    }
    
    /**
     * La fonction qui permet d'afficher l'arbre à partir d'une matrice
     * @param MatriceArbre
     * @param niveau 
     */
    public static  void AfficherArbrePartirMatrice(String[][] MatriceArbre, int niveau)
    {  
        int largeur_ligne=6*(int)Math.pow(2, niveau-1);
        String ligne_lettre="";
        String ligne_Separateur="";
        int conteur=0;
        for(int p =1;p<=5;p++)
        {
         ligne_Separateur="";
         ligne_lettre="";
         conteur=0;
         
        while (conteur < 15 && MatriceArbre[p-1][conteur]!=null  )
        {
        if (MatriceArbre[p-1][conteur]!="*" ){
            if(conteur==0){
        ligne_lettre+=InsererEspace((largeur_ligne/((int)Math.pow(2, p)))-1)+MatriceArbre[p-1][conteur];
        ligne_Separateur+=InsererEspace((largeur_ligne/((int)Math.pow(2, p)))-2)+"/ \\";
            }else{
             ligne_lettre+=InsererEspace(((largeur_ligne/((int)Math.pow(2, p)))-1)*2)+MatriceArbre[p-1][conteur];
             ligne_Separateur+=InsererEspace(((largeur_ligne/((int)Math.pow(2, p)))-2)*2)+"/ \\";       
            }
        
        conteur++;
        }
        else{
            if(conteur==0){
        ligne_lettre+=InsererEspace((largeur_ligne/((int)Math.pow(2, p)))-1)+" ";
        ligne_Separateur+=InsererEspace((largeur_ligne/((int)Math.pow(2, p)))-2)+"   ";
            }else{
        ligne_lettre+=InsererEspace(((largeur_ligne/((int)Math.pow(2, p)))-1)*2)+"  ";
        ligne_Separateur+=InsererEspace(((largeur_ligne/((int)Math.pow(2, p)))-2)*2)+"    ";
            }
        conteur++;
        }
        }
        System.out.println(ligne_lettre);
        if (p!=5) System.out.println(ligne_Separateur);
                
        }
    }
    
     public static void ConvertirArbreValeurToMatrice2(String[][] valeur_arbre, int niveau)
    {
  
        String[] Ligne_Precedente = new String[(int) Math.pow(2, niveau-1)];
        String[] Ligne_Actuelle = new String[(int) Math.pow(2, niveau-1)];
        int niveau_seq_creation;
        int niveau_seq_affichage;
         
        String[][] MatriceArbre= new String[niveau][(int) Math.pow(2, niveau-1)];
        for (int k = 1; k <= niveau; k++) {
            niveau_seq_creation = 1;
            niveau_seq_affichage = 1;

            Ligne_Precedente = Ligne_Actuelle.clone();
            for (int i = 0; i < valeur_arbre.length; i++) {

                if (Integer.parseInt(valeur_arbre[i][0]) == k) {

                    if (k != 1) {

                        while (Ligne_Precedente[niveau_seq_affichage - 1].compareTo("null") == 0 && niveau_seq_affichage - 1 < Math.pow(2, k)) {
                            System.out.print("null\t ");
                            MatriceArbre[k-1][niveau_seq_affichage-1]="*";
                            niveau_seq_affichage++;
                        }
                        System.out.print(valeur_arbre[i][1] + "\t");
                        MatriceArbre[k-1][niveau_seq_affichage-1]=valeur_arbre[i][1];
                        niveau_seq_affichage++;

                    } else {
                        System.out.print(valeur_arbre[i][1] + "\t");
                        MatriceArbre[k-1][niveau_seq_affichage-1]=valeur_arbre[i][1];
                        niveau_seq_affichage++;
                        
                    }

                    //   Initialiser la ligne précédente pour utilisé au niveau de la ligne suivante
                    Ligne_Actuelle[niveau_seq_creation * 2 - 2] = valeur_arbre[i][2];
                    Ligne_Actuelle[niveau_seq_creation * 2 - 1] = valeur_arbre[i][3];
                    niveau_seq_creation++;
                }
            }
            System.out.println("\n");
        }
               

        
        System.out.println("-----------------------------------------------------------------------------------------------------");
        CorrigerMatrice(MatriceArbre, 5);
        AfficherMatrice(MatriceArbre);
        System.out.println("-----------------------------------------------------------------------------------------------------");
        AfficherArbrePartirMatrice(MatriceArbre, 5);
      
    }   
    
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
         //    System.out.println(valeur_arbre[i][j]+"_"+i+"_"+j);
             
             }
        //     System.out.println("--------------------------------------------------");
         }
         
         // creer le tableau qui contient les valeurs de la liste précedente

        

        //afficher tous les valeurs de l'arbre
          /*      
         for (int k = 1; k < 6; k++) {

             for (int i = 0; i < valeur_arbre.length; i++) {

                 if (Integer.parseInt(valeur_arbre[i][0]) == k) {
                     System.out.print(valeur_arbre[i][1] + "\t");
                 }
             }
             System.out.println("\n");
         }
        
        int niveau=5;
       
        System.out.println((int)Math.pow(2,niveau-1));
        
        String[][] matrice_valeur= new String[(int)Math.pow(2,niveau-1)][niveau];
        
        
        for (int s=0;s<(int)Math.pow(2,niveau-1);s++)
        {
        
        
        };
        */
        
        ConvertirArbreValeurToMatrice2(valeur_arbre,5);
        
        System.out.println("************************************************");
     
        
        
       
        
        
     }
    
}
