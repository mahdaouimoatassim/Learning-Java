/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package optometrie_version_1;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import com.mysql.jdbc.Connection;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.awt.event.MouseEvent;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Set;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
/**
 *
 * @author Milano
 */
public class Credit  extends Stage{
    
       
     private AnchorPane grand_conteneur = new AnchorPane();
     private Scene scene3 = new Scene(grand_conteneur,940, 554);
   
    
     
   
        
    Button supprimer_lunette =new Button("");
    Button enregistrer_lunette =new Button("");        
    HBox conteneur_bouton=new HBox(14);
        
        Button lunette_credit =new Button("");
        Button lentille_credit =new Button("");
        Button enfant_credit =new Button("");
        Button progressive_credit =new Button("");        
        VBox conteneur_bouton2=new VBox(14);
    
    private int selected_row_table_credit=-1;
    private String selected_row_table_credit_nom="";
    private String selected_row_table_credit_prenom="";
    private  Label labe=new Label("mon texte");
    private Text text=new Text();
    private TableView table_credits=new TableView();
   
    private TextField recherche_nom_field=new TextField();
    private  TextField recherche_date_field=new TextField();
    private  HBox recherche_box=new HBox(85);
    private  Button rechercher_buttom=new Button("");
    
    private String fenetre_varieble="";
    
    public Credit(){
    
    
    initialise_fenetre();    
    String requete="SELECT * FROM `credit`";
    evenement_fenetre();
    Chargement_Donnee(requete);
    this.setScene(scene3);
    this.show();
    
    }
    
     public void initialise_fenetre(){
    
      recherche_nom_field.setId("info_field_css");
      recherche_date_field.setId("info_field_css");
      recherche_box.getChildren().addAll(recherche_nom_field,recherche_date_field);
      grand_conteneur.getChildren().addAll(recherche_box,rechercher_buttom);
      AnchorPane.setTopAnchor(recherche_box, 89.00);
      AnchorPane.setLeftAnchor(recherche_box, 330.00);
      AnchorPane.setTopAnchor(rechercher_buttom, 85.00);
      AnchorPane.setLeftAnchor(rechercher_buttom, 748.00);
      rechercher_buttom.setStyle("-fx-min-width:115;-fx-max-width:115;-fx-min-height:32;-fx-max-height:32;-fx-background-color:transparent;");
        
      
   
     
     grand_conteneur.setId("Background_liste_credit_css");
     scene3.getStylesheets().addAll(this.getClass().getResource("css/credit.css").toExternalForm()); 
  
     
     
     
        conteneur_bouton.getChildren().addAll(supprimer_lunette,enregistrer_lunette);
        AnchorPane root = new AnchorPane();
        grand_conteneur.getChildren().addAll(conteneur_bouton2,table_credits,conteneur_bouton);
         AnchorPane.setLeftAnchor(conteneur_bouton, 658.0);
        AnchorPane.setTopAnchor(conteneur_bouton, 472.0);
        AnchorPane.setRightAnchor(table_credits, 70.0);
        AnchorPane.setTopAnchor(table_credits, 182.0);
        table_credits.setId("table_credit_css");      
         
        
        supprimer_lunette.setId("supprimer_lunette_css2");
        enregistrer_lunette.setId("enregistrer_lunette_css2");
        conteneur_bouton2.getChildren().addAll(lunette_credit,lentille_credit,enfant_credit,progressive_credit);
        
        
        AnchorPane.setLeftAnchor(conteneur_bouton2, 66.0);
        AnchorPane.setTopAnchor(conteneur_bouton2, 97.0);
   
        lunette_credit.setId("lunette_credit_css");   
        lentille_credit.setId("lentille_credit_css");
        enfant_credit.setId("enfant_credite_css");  
        progressive_credit.setId("progressive_credit_css");
        supprimer_lunette.setId("supprimer_lunette_css2");
        enregistrer_lunette.setId("enregistrer_lunette_css2");
        
    
    }
     /**************************************************************************************************************************************/     
            public Connection getconnaction() throws Exception{
    
        try {
            String url="jdbc:mysql://localhost:3306/optometrie";
            String user="root";
            String password="lailahailalah";
            Class.forName("com.mysql.jdbc.Driver");            
            Connection connection=(Connection) DriverManager.getConnection(url,user,password);            
            return connection;
        } catch (Exception e) {            
            e.printStackTrace();
        }
        return null;
    }
     
  /***************************************************************************************************************************************************/   
        public void Chargement_Donnee(String requete2){
        
            
            
            
            
            
            
             ObservableList<ObservableList>  data ;
            data = FXCollections.observableArrayList();
          
            table_credits= new TableView();
            grand_conteneur.getChildren().addAll(table_credits);
            AnchorPane.setRightAnchor(table_credits, 70.0);
            AnchorPane.setTopAnchor(table_credits, 182.0);
            table_credits.setId("table_credit_css");
             table_credits.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
                @Override
                public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
                    //Check whether item is selected and set value of selected item to Label
                    if(table_credits.getSelectionModel().getSelectedItem() != null) 
                    {    
                       TableViewSelectionModel selectionModel = table_credits.getSelectionModel();
                       ObservableList selectedCells = selectionModel.getSelectedCells();
                       TablePosition tablePosition = (TablePosition) selectedCells.get(0); 
                       String[] liste_value=newValue.toString().split(",");
                       selected_row_table_credit=tablePosition.getRow()+1;
                       selected_row_table_credit_nom=liste_value[1].trim();
                       selected_row_table_credit_prenom=liste_value[2].trim();
                     //  Object val = tablePosition.getTableColumn().getCellData(newValue);                         
                     }
                     }
                 });
     
            
        
            
            
            
            
            
          try{
          
            
            Statement st=getconnaction().createStatement();
            ResultSet rs = st.executeQuery(requete2);

            /**********************************
             * TABLE COLUMN ADDED DYNAMICALLY *
             **********************************/
            for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
                //We are using non property style for making dynamic table
                final int j = i;                
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
                col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                    public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {                                                                                              
                        return new SimpleStringProperty(param.getValue().get(j).toString());                        
                    }                    
                });

                table_credits.getColumns().addAll(col); 
               
            }

            /********************************
             * Data added to ObservableList *
             ********************************/
            while(rs.next()){
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    //Iterate Column
                    row.add(rs.getString(i));
                }             
                 data.add(row);
            }           
           table_credits.setItems(data);       
          }catch(Exception e){
              e.printStackTrace();
              System.out.println("Error on Building Data");             
          }
      }
     
       /**************************************************************************************************************************************/   
      public void evenement_fenetre()
        {
 
        
     
   
   
    supprimer_lunette.setOnMouseEntered((event) -> {           
         
         scene3.setCursor(Cursor.HAND);
         
        }); 
    
    enregistrer_lunette.setOnMouseEntered((event) -> {           
         
         scene3.setCursor(Cursor.HAND);
         
        }); 
    
      enfant_credit.setOnMouseEntered((event) -> {           
         
         scene3.setCursor(Cursor.HAND);
         
        }); 
       lunette_credit.setOnMouseEntered((event) -> {           
         
         scene3.setCursor(Cursor.HAND);
         
        }); 
        lentille_credit.setOnMouseEntered((event) -> {           
         
         scene3.setCursor(Cursor.HAND);
         
        }); 
         progressive_credit.setOnMouseEntered((event) -> {           
         
         scene3.setCursor(Cursor.HAND);
         
        }); 
    rechercher_buttom.setOnMouseEntered((event) -> {           
         
         scene3.setCursor(Cursor.HAND);
         
        });
    
     progressive_credit.setOnMouseExited((event)-> {
         
         scene3.setCursor(Cursor.DEFAULT);
     
     });
      enfant_credit.setOnMouseExited((event)-> {
         
         scene3.setCursor(Cursor.DEFAULT);
     
     });
       lunette_credit.setOnMouseExited((event)-> {
         
         scene3.setCursor(Cursor.DEFAULT);
     
     });
      lentille_credit.setOnMouseExited((event)-> {
         
         scene3.setCursor(Cursor.DEFAULT);
     
     });
     supprimer_lunette.setOnMouseExited((event)-> {
         
         scene3.setCursor(Cursor.DEFAULT);
     
     });
     
 
     
     enregistrer_lunette.setOnMouseExited((event)-> {
         
         scene3.setCursor(Cursor.DEFAULT);
     
     });
     
     rechercher_buttom.setOnMouseExited((event)-> {
         
         scene3.setCursor(Cursor.DEFAULT);
     
     });
    /************************************************* evenement de traitement***************************************************************/
     
   enregistrer_lunette.setOnAction((event) -> {
       
      this .close();
        });
    rechercher_buttom.setOnAction((event) -> {
            
       rechercher_malade();
        });

    supprimer_lunette.setOnAction((event) -> {
             
                try {
                          if(getconnaction()!=null ) {
                              
                              modifier_credit_parametre();
                              
                          }else
                          {
                             Alert dialogE = new Alert(AlertType.ERROR);
                             dialogE.setTitle("Supression Eronnée ");
                             dialogE.setHeaderText("Malade Non Supprimée");
                             dialogE.setContentText("la suppression du malade n'a pas été effectuée, veuillez vérifier la connexion avec la base de données");
                             dialogE.showAndWait();
                          }

                     } catch (Exception e) {

                     }

                              });
 
       
         
   
         
   table_credits.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
                @Override
                public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
                    //Check whether item is selected and set value of selected item to Label
                    if(table_credits.getSelectionModel().getSelectedItem() != null) 
                    {    
                       TableViewSelectionModel selectionModel = table_credits.getSelectionModel();
                       ObservableList selectedCells = selectionModel.getSelectedCells();
                       TablePosition tablePosition = (TablePosition) selectedCells.get(0); 
                       String[] liste_value=newValue.toString().split(",");
                       selected_row_table_credit=tablePosition.getRow()+1;
                       selected_row_table_credit_nom=liste_value[1].trim();
                       selected_row_table_credit_prenom=liste_value[2].trim();
                     //  Object val = tablePosition.getTableColumn().getCellData(newValue);                         
                     }
                     }
                 });
 
 
    progressive_credit.setOnAction((event)-> {
         
        String requete="SELECT `Id`, `Nom`, `Prenom`, `Telephone`, `Montant_verse`, `Montant_restant`, `Date_Commande` FROM `progressive` where `Montant_restant`>0 ";
        Chargement_Donnee(requete);
        fenetre_varieble="progressive";
     });
      enfant_credit.setOnAction((event)-> {
         
        String requete="SELECT `Id`, `Nom`, `Prenom`, `Numero_Telephone`, `Montant_verse`, `Montant_restant`, `Date_consultation` FROM `enfant` where `Montant_restant`>0";
        Chargement_Donnee(requete);
        fenetre_varieble="enfant";
     });
       lunette_credit.setOnAction((event)-> {
         
        String requete="SELECT `Id`, `Nom`, `Prenom`,`Montant`,`Montant_restant`,`telphone`,`Date` FROM `lunette` where `Montant_restant`>0";
        Chargement_Donnee(requete);
        fenetre_varieble="lunette";
        
     });
      lentille_credit.setOnAction((event)-> {
         
        String requete="SELECT `Id`, `Nom`, `Prenom`, `Numero_Telephone`, `Montant_verse`, `Montant_restant`, `Date_consultation` FROM `lentille`  where `Montant_restant`>0";
        Chargement_Donnee(requete);
        fenetre_varieble="lentille";
     });
   
   
   
 
 }  
   
 /**************************************************************************************************************************/     
          public void supprimerligne(String selected_item_nom,String selected_item_prenom)
   {
       
            selected_item_nom=selected_item_nom.trim();
            selected_item_prenom=selected_item_prenom.trim();
            String requete_suppression= "DELETE FROM `enfant` WHERE Nom='"+selected_item_nom+"' AND Prenom='"+selected_item_prenom+"'";
            try {
            Statement st1=getconnaction().createStatement();
            st1.executeUpdate(requete_suppression);
            String requete2="SELECT  `Id`,`Nom`, `Prenom`, `Age`, `Numero_Telephone`, `Medecin`, `Adresse`, `Predominance`, `Date_consultation`, `Antecedent`, `Diagnostic`, `SF_D_MV`, `SF_D_MH`, `SF_G_MV`, `SF_G_MH`, `SD_D_MV`, `SD_D_MH`, `SD_G_MV`, `SD_G_MH`, `Diagnostic_D`, `Diagnostic_G`  FROM `enfant` ";
            Chargement_Donnee(requete2);
            
       } catch (Exception e) {
           e.printStackTrace();
       }
           
   }
     
public void modifier_credit_parametre(){
        String requete="";
        if (fenetre_varieble=="progressive")
        {
            
        requete="UPDATE `progressive` SET `Montant_restant`=0 WHERE `Nom`='"+ selected_row_table_credit_nom +"' AND `Prenom`='"+selected_row_table_credit_prenom +"'";        
        
        }
                                                       
        if (fenetre_varieble=="enfant"){
        requete="UPDATE `enfant` SET `Montant_restant`=0 WHERE `Nom`='"+ selected_row_table_credit_nom +"' AND `Prenom`='"+selected_row_table_credit_prenom +"'";        

        }
                                                            
        if (fenetre_varieble=="lunette"){
        requete="UPDATE `lunette` SET `Montant_restant`=0 WHERE `Nom`='"+ selected_row_table_credit_nom +"' AND `Prenom`='"+selected_row_table_credit_prenom +"'";        

        }         
        if (fenetre_varieble=="lentille"){
        requete="UPDATE `lentille` SET `Montant_restant`=0 WHERE `Nom`='"+ selected_row_table_credit_nom +"' AND `Prenom`='"+selected_row_table_credit_prenom +"'";        
        
        } 
Statement st1;
          try {
              
                 if(getconnaction()!=null ) {
                        
                    st1 = getconnaction().createStatement();
                    st1.executeUpdate(requete);
                   
                    
                    
               
                  }
                 else{
                             Alert dialogE = new Alert(Alert.AlertType.ERROR);
                             dialogE.setTitle("Suppression  Eronné ");
                             dialogE.setHeaderText("Malade Non Ajouté");
                             dialogE.setContentText("l'ajout du malade n'a pas été effectuée, veuillez vérifier la connexion avec la base de données");
                             dialogE.showAndWait();
                          }
          
            } catch (Exception ex) {
              
                 
                             Alert dialogE = new Alert(Alert.AlertType.ERROR);
                             dialogE.setTitle("Ajout éronné ");
                             dialogE.setHeaderText("Malade Non Ajouté");
                             dialogE.setContentText("léajout du malade n'a pas été effectuée, veuillez vérifier leur inforamtion");
                             dialogE.showAndWait();
                                         
          }
   
        

}
          
    

public void rechercher_malade(){

    
    String requete="";
    
    if (fenetre_varieble=="progressive") 
    {
        requete= "SELECT `Id`, `Nom`, `Prenom`, `Telephone`, `Montant_verse`, `Montant_restant`, `Date_Commande` FROM `progressive` " ;
        if (recherche_nom_field.getText().isEmpty()){     
               if(!recherche_date_field.getText().isEmpty()) requete+=" WHERE Montant_restant>"+Integer.parseInt(recherche_date_field.getText().trim()); 
               else requete+=" WHERE Montant_restant>0";
        }else{
           requete+= " WHERE Nom='"+recherche_nom_field.getText()+"'";
             if(!recherche_date_field.getText().isEmpty()) requete+=" AND Montant_restant>"+Integer.parseInt(recherche_date_field.getText().trim()); 
             else requete+=" AND Montant_restant>0";
        }
    }
     if (fenetre_varieble=="enfant") 
    {
        requete= "SELECT `Id`, `Nom`, `Prenom`, `Numero_Telephone`, `Montant_verse`, `Montant_restant`, `Date_consultation` FROM `enfant`  " ;
       if (recherche_nom_field.getText().isEmpty()){     
               if(!recherche_date_field.getText().isEmpty()) requete+=" WHERE Montant_restant>"+Integer.parseInt(recherche_date_field.getText().trim()); 
               else requete+=" WHERE Montant_restant>0";
        }else{
           requete+= " WHERE Nom='"+recherche_nom_field.getText()+"'";
             if(!recherche_date_field.getText().isEmpty()) requete+=" AND Montant_restant>"+Integer.parseInt(recherche_date_field.getText().trim()); 
             else requete+=" AND Montant_restant>0";
        }
    }
     if (fenetre_varieble=="lunette") 
    {
        requete= "SELECT `Id`, `Nom`, `Prenom`,`Montant`,`Montant_restant`,`telphone`,`Date` FROM `lunette` " ;
       if (recherche_nom_field.getText().isEmpty()){     
               if(!recherche_date_field.getText().isEmpty()) requete+=" WHERE Montant_restant>"+Integer.parseInt(recherche_date_field.getText().trim()); 
               else requete+=" WHERE Montant_restant>0";
        }else{
           requete+= " WHERE Nom='"+recherche_nom_field.getText()+"'";
             if(!recherche_date_field.getText().isEmpty()) requete+=" AND Montant_restant>"+Integer.parseInt(recherche_date_field.getText().trim()); 
             else requete+=" AND Montant_restant>0";
        }
    }
     if (fenetre_varieble=="lentille") 
    {
        requete= "SELECT `Id`, `Nom`, `Prenom`, `Numero_Telephone`, `Montant_verse`, `Montant_restant`, `Date_consultation` FROM `lentille` " ;
        if (recherche_nom_field.getText().isEmpty()){     
               if(!recherche_date_field.getText().isEmpty()) requete+=" WHERE Montant_restant>"+Integer.parseInt(recherche_date_field.getText().trim()); 
               else requete+=" WHERE Montant_restant>0";
        }else{
           requete+= " WHERE Nom='"+recherche_nom_field.getText()+"'";
             if(!recherche_date_field.getText().isEmpty()) requete+=" AND Montant_restant>"+Integer.parseInt(recherche_date_field.getText().trim()); 
             else requete+=" AND Montant_restant>0";
        }
    }
     
             Chargement_Donnee(requete);


}

          
          
      
}
