import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;

public class FenetreParticulier extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception{
		
		primaryStage.setTitle("Gestion des utlisateurs");		
		StackPane root = new StackPane();
		
		HBox fenetre = new HBox(25);
		VBox listeUtil = new VBox(10);
		VBox zoneInfos = new VBox(10);
		root.getChildren().add(fenetre);
		fenetre.getChildren().add(listeUtil);
		fenetre.getChildren().add(zoneInfos);
		
		Utilisateur alice = new Utilisateur(01, "Alice");
		Utilisateur bob = new Utilisateur(02, "Bob");
		alice.setCodeAcces(1234);
		bob.setCodeAcces(5678);
		alice.setPtsFidelite(50);
		bob.setPtsFidelite(0);
		
		ObservableList<Utilisateur> names = FXCollections.observableArrayList(
				alice, bob);
		ListView<Utilisateur> listView = new ListView<Utilisateur>(names);
		Button ajouter = new Button("Nouveau");
		Button choisir = new Button("Choisir");
		HBox listeUtilBouton = new HBox(10);
		listeUtil.getChildren().add(listView);
		listeUtil.getChildren().add(listeUtilBouton);
		listeUtilBouton.getChildren().add(ajouter);
		listeUtilBouton.getChildren().add(choisir);
		
		listeUtilBouton.setAlignment(Pos.CENTER);
		
		
		Text t = new Text(10, 50, "Entrez votre code d'accès");
		TextField motDePasse = new TextField();
		zoneInfos.getChildren().add(t);
		zoneInfos.getChildren().add(motDePasse);
		
		//Récupère l'élément actuellement sélectionné
		Utilisateur currentElm = listView.getSelectionModel().getSelectedItem();
		
		Text infos = new Text(10, 50, "Nom :\t" + "Alice"
				+ "\nPoints de fidélité :\t" + "215"
				+ "\nPoubelles :\t" + "01"
		);
		zoneInfos.getChildren().add(infos);
		listView.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends Utilisateur> ov, Utilisateur old_val, Utilisateur new_val) -> {
		     Utilisateur selectedItem = listView.getSelectionModel().getSelectedItem();
		     int index = listView.getSelectionModel().getSelectedIndex();
		     
		     infos.setText("Nom :\t" + selectedItem.getNom() +
		    		 "\nId :\t" + selectedItem.getIdUser() +
		    		 "\nCode d'accès :\t" + selectedItem.getCodeAcces() +
		    		 "\nPoints de fidélité :\t" + selectedItem.getPtsFidelite() +
		    		 "\nPoubelles :\t" + selectedItem.getPoubelle().getIdPoubelle());
		});
		
	    Scene scene = new Scene(root, 500, 300);
	     
	    
	    primaryStage.setScene(scene);
	    primaryStage.show();
	    
	    
	    //////////
	    //Création de nouvel utilisateur
	    // Création des champs de saisie
        TextField idUserField = new TextField();
        TextField nomField = new TextField();
        TextField codeAccesField = new TextField();
        TextField ptsFideliteField = new TextField();
        TextField poubelleField = new TextField();
        //TextArea listeDeposerDechetsArea = new TextArea();
        //TextArea listeProduitsArea = new TextArea();

        // Création du formulaire
        GridPane form = new GridPane();
        form.setPadding(new Insets(10));
        form.setHgap(10);
        form.setVgap(10);

        form.add(new Label("ID Utilisateur:"), 0, 0);
        form.add(idUserField, 1, 0);
        form.add(new Label("Nom:"), 0, 1);
        form.add(nomField, 1, 1);
        form.add(new Label("Code d'accès:"), 0, 2);
        form.add(codeAccesField, 1, 2);
        form.add(new Label("Points de fidélité:"), 0, 3);
        form.add(ptsFideliteField, 1, 3);
        form.add(new Label("Poubelle:"), 0, 4);
        form.add(poubelleField, 1, 4);
        //form.add(new Label("Liste des dépôts de déchets:"), 0, 5);
        //form.add(listeDeposerDechetsArea, 1, 5);
        //form.add(new Label("Liste des produits:"), 0, 6);
        //form.add(listeProduitsArea, 1, 6);

        // Création du bouton de validation
        Button validerButton = new Button("Valider");
        form.setAlignment(Pos.CENTER);
        validerButton.setOnAction(event -> {
        	
            // Récupération des valeurs saisies
            int idUser = Integer.parseInt(idUserField.getText());
            String nom = nomField.getText();
            int codeAcces = Integer.parseInt(codeAccesField.getText());
            int ptsFidelite = Integer.parseInt(ptsFideliteField.getText());
            PoubelleAutre poubelle = new PoubelleAutre(Integer.parseInt(poubelleField.getText()));

            // Création de l'instance de l'utilisateur
            Utilisateur utilisateur = new Utilisateur(idUser, nom);
            utilisateur.setCodeAcces(codeAcces);
            utilisateur.setPtsFidelite(ptsFidelite);
            utilisateur.setPoubelle(poubelle);
            
            // Affichage des informations saisies
            System.out.println("Utilisateur créé : " + utilisateur.getNom());
            
            //Ajout de l'utilisateur dans la liste
            names.add(utilisateur);
            
            // Fermeture de la fenêtre
            primaryStage.setScene(scene);
        });

        // Ajout du formulaire et du bouton de validation à la scène
        Scene nouveauUserScene = new Scene(new GridPane(), 400, 400);
        GridPane gridPane = (GridPane) nouveauUserScene.getRoot();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.add(form, 0, 0);
        gridPane.add(validerButton, 0, 1);
        
        //Apparition de la fenetre de création de perso lors du clic sur bouton
	    ajouter.setOnAction(e -> {        	
            primaryStage.setScene(nouveauUserScene);
        });
	}
	
	
	public static void main(String[] args) {
		Application.launch (args);
	}
}