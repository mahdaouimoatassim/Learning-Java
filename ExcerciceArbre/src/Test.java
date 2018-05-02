


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
 
    
 
    
    public static void SeparerLigne()
    {
    System.out.println("\n---------------------------------------------------------------------------------------------\n");
    }
    
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
    
    
    /**
     * La fonction qui permet d'afficher n espace sur la console
     * 
     * @param count nombre d'espace à ajouter
     */
    
    public static void AfficherEspace(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }
    
    
    
    /**
     *  La fonction qui permet d'ajouter une valeur dans une table dans la position de l'index
     * 
     * @param s la table dans laquelle la valeur sera ajouté
     * @param index
     * @param Valeur la valeur à ajouter
     * @return 
     */
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
      * La fonction qui permet de corriger la matrice en ajoutant les null manquants dans les derniers lignes
      * 
      * @param MatriceArbre  la fonction qui permet de corriger cette matrice 
      * en ajoutant les null manquant a chaque linge
      * @param niveau   le niveau de cette arbre
      */
    public static String[][] CorrigerMatrice(String[][] MatriceArbre,int niveau)
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
       return MatriceArbre;
    }
    
    
    
    
    /**
     * creer une table a deux dimensions qui contien le détail de tous les noeuds ( valeur, niveau, noeud droit, boeud gauche
     * 
     * @param ListeNoeuds la chaine de caractère qui contient le détail de tous les noeuds
     * @return 
     */
    public static String[][] GetDetailArbre(String ListeNoeuds)
    {
        String[] Tableau_arbre = ListeNoeuds.split("/");

     //  
        // 
        String[][] valeur_arbre = new String[Tableau_arbre.length][4];
        for (int i = 0; i < Tableau_arbre.length; i++) {
            for (int j = 0; j < 4; j++) {
                valeur_arbre[i][j] = Tableau_arbre[i].split("_")[j];
            }
        }
        return valeur_arbre;
    }
    
    
    
    /**
     * la fonction qui permet d'afficher une matrice sur la console
     * 
     * @param MatriceArbre 
     */
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
        int largeur_ligne = 4 * (int) Math.pow(2, niveau - 1);
        String ligne_lettre = "";
        int conteur = 0;
        int EspaceValeurColonne=0;
        int EspaceValeurLigne=0;
        for (int p = 1; p <= niveau ; p++) {
            
        //   Imprimer la ligne des valeurs    
            ligne_lettre = "";
            conteur = 0;
            EspaceValeurColonne=(largeur_ligne / ((int) Math.pow(2, p)));
            while (conteur <= 15 && MatriceArbre[p - 1][conteur] != null) {
                
                if (MatriceArbre[p - 1][conteur] != "*") {
                    
                    if (conteur == 0)    ligne_lettre += InsererEspace( EspaceValeurColonne - 1) + MatriceArbre[p - 1][conteur];
                    else     ligne_lettre += InsererEspace((EspaceValeurColonne - 1) * 2) + MatriceArbre[p - 1][conteur];     
                                  
                } else {
                    
                    if (conteur == 0) ligne_lettre += InsererEspace(EspaceValeurColonne - 1) + " ";
                    else   ligne_lettre += InsererEspace(( EspaceValeurColonne - 1) * 2) + "  ";                                      
                }
                 conteur++;
            }
            System.out.println(ligne_lettre);

        //   Imprimer l'ensemble de ligne de caractère séparateur 
            
            EspaceValeurLigne=(int) (Math.pow(2, Math.max(5 - p - 1, 0)));
            
            for (int i = 1; i <= EspaceValeurLigne + (int) (Math.pow(2, Math.max(5 - p - 2, 0))); i++) {
                for (int j = 1; j <= (int) (Math.pow(2, p - 1)); j++) {
                    
                    if (p < niveau)
                    {
                        AfficherEspace((largeur_ligne / ((int) Math.pow(2, p))) - i - 1);

                        if (MatriceArbre[p - 1][j - 1] == null) {
                            AfficherEspace(EspaceValeurLigne * 2 + i + 1);
                        }

                        if (MatriceArbre[p][j * 2 - 2] != "*") {
                            System.out.print("/");
                        } else {
                            AfficherEspace(1);
                        }

                        AfficherEspace(i + i - 1);

                        if (MatriceArbre[p][j * 2 - 1] != "*") {
                            System.out.print("\\");
                        } else {
                            AfficherEspace(1);
                        }

                        AfficherEspace(EspaceValeurLigne * 2 - i + (5 - p + 1));
                    }
                }
                System.out.println("");
            }

        }
    }
    
    
    /**
     * 
     * convertir une table de detail d'une arbre vers une matrice de valeurs de cette arbre
     * 
     * @param valeur_arbre
     * @param niveau
     * @return 
     */
    
    public static String[][] ConvertirArbreValeurToMatrice2(String[][] valeur_arbre, int niveau)
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

                        while (Ligne_Precedente[niveau_seq_affichage - 1].compareTo("null") == 0 && niveau_seq_affichage - 1 < Math.pow(2, k))
                        {

                            MatriceArbre[k-1][niveau_seq_affichage-1]="*";
                            niveau_seq_affichage++;   }

                        MatriceArbre[k-1][niveau_seq_affichage-1]=valeur_arbre[i][1];
                        niveau_seq_affichage++;

                    } else {
                        MatriceArbre[k-1][niveau_seq_affichage-1]=valeur_arbre[i][1];
                        niveau_seq_affichage++;    }

                    //   Initialiser la ligne précédente pour utilisé au niveau de la ligne suivante
                    Ligne_Actuelle[niveau_seq_creation * 2 - 2] = valeur_arbre[i][2];
                    Ligne_Actuelle[niveau_seq_creation * 2 - 1] = valeur_arbre[i][3];
                    niveau_seq_creation++;
                }
            }

        }
               

        
      return CorrigerMatrice(MatriceArbre, niveau);
   
    }   
    
    
    
    public static Arbre InitialiserArbre()
    {
         ArbreRectangle rec33 = new ArbreRectangle(33,new ArbreRectangle(12),new ArbreCercle("D".charAt(0)));
         ArbreRectangle rec8 = new ArbreRectangle(8,new ArbreCercle("E".charAt(0)),null);
         ArbreCercle cerC = new ArbreCercle("C".charAt(0),rec8,rec33);
         ArbreCercle cerB = new ArbreCercle("B".charAt(0),null,cerC);
         ArbreCercle cerF = new ArbreCercle("F".charAt(0),new ArbreCercle("G".charAt(0)),null);
         ArbreRectangle rec5 = new ArbreRectangle(5,cerF,new ArbreRectangle(7));
         ArbreCercle cerA = new ArbreCercle("A".charAt(0),rec5,cerB);
         return cerA;
    
    }
     public static void main(String[] arg) {
     
       
        Arbre cerA=InitialiserArbre();     // Initialiser le Schéma     
        System.out.println(cerA.somme());  //Calculer la somme de cette arbre 
        SeparerLigne();
         
        cerA.ParcoursPreOrder(); // Afficher l'arbre selon le parcours PreOrdre
        SeparerLigne();
        cerA.ParcoursInOrder();  // Afficher l'arbre selon le parcours InOrdre      
        SeparerLigne();
        cerA.ParcoursPostOrder();// Afficher l'arbre selon le parcours PostOrdre 
        SeparerLigne();
        String[][] ArbreValeur=GetDetailArbre(cerA.ExpressionArbreNiveau(1));  //Recuperer le détail de cette arbre dans un tableau
        String[][] arbreMatrice= ConvertirArbreValeurToMatrice2(ArbreValeur,5); //Convertir ce tableau de détail vers une matrice de valeur
        AfficherMatrice(arbreMatrice);// Affichage de la matrice de valeur de cette arbre
        SeparerLigne();
        AfficherArbrePartirMatrice(arbreMatrice,5); // affichage de l'arbre
        
     }
    
}
