

import java.util.Date;

import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.stage.Stage;

public class FenetreAccueil extends Application {
	
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("ma Fenêtre");
		
		Button particuliersBouton = new Button("Particuliers");
		Button commerceBouton = new Button("Commerce");
		Button centreTriBouton = new Button("Centre de tri");
		
		VBox menuButtons = new VBox(5);
		
		StackPane root = new StackPane();
		
		root.getChildren().add(menuButtons);
		menuButtons.getChildren().add(particuliersBouton);
		menuButtons.getChildren().add(commerceBouton);
		menuButtons.getChildren().add(centreTriBouton);
		
		menuButtons.setAlignment(Pos.CENTER);
		
	    Scene scene = new Scene(root, 500, 300);
	    primaryStage.setScene(scene);

		// Définition des Scenes des diff personne
		Scene particuliersScene = new Scene(new VBox(),500,300);
		Scene centreTriScene = new Scene(new VBox(),500,300);
		Scene commerceScene = new Scene(new VBox(),500,300);
	    

		// Redirection des buttons vers d'autre scene 
		particuliersBouton.setOnAction(e -> primaryStage.setScene(particuliersScene));
		commerceBouton.setOnAction(e -> primaryStage.setScene(commerceScene));
		centreTriBouton.setOnAction(e -> primaryStage.setScene(centreTriScene));		 
		
		// Ajout des boutons du Particulier avec leur action (Potentiellement à déplacer dans une autre classe)
		//
		//
		Button consulterHistoriqueBtn = new Button("Consulter Historique");
        Button convertirPtsBtn = new Button("Convertir Pts");
        Button deposerDechetsBtn = new Button("Déposer");
		// Button ajoutPts = new Button("Point Gagné"); 


		VBox particulierLayout = new VBox(10);
        particulierLayout.getChildren().addAll(consulterHistoriqueBtn, convertirPtsBtn, deposerDechetsBtn);
        particuliersScene.setRoot(particulierLayout);

        consulterHistoriqueBtn.setOnAction(e -> {
            // Ajouter la méthode pour consulter l'histo
        });
        convertirPtsBtn.setOnAction(e -> {
            // Ajouter la méthode pour consulter l'histo
        });
		deposerDechetsBtn.setOnAction(e -> {
			// Méthode de déposer Déchets
			DeposerDechet dechetAlice = new DeposerDechet();
			dechetAlice.setDate(new Date());
			dechetAlice.setQteDechet(10);
			dechetAlice.setTypeDechets(TypeDechets.VERRE);
			Utilisateur alice = new Utilisateur(01, "alice");
			dechetAlice.setUtilisateur(alice);
			dechetAlice.setPtsgagne(0);
			int j = alice.getPtsFidelite();
			dechetAlice.calculerQteDechets(dechetAlice.getQteDechet(), dechetAlice.getTypeDechets());
			dechetAlice.ajoutPtsGagné(alice,dechetAlice.getPtsgagne());
			int i = alice.getPtsFidelite();

			Alert alert = new Alert(Alert.AlertType.INFORMATION);
    		alert.setTitle("Message");
    		alert.setHeaderText(null);
			alert.setContentText("Nombre de points de fidélité avant ajout : " + j + "\n" +
			"Nombre de points de fidélité après ajout : " + i);
			alert.showAndWait();
		});



        // Ajout des boutons du Centre de tri avec leur action
        Button placerPoubelle = new Button("Placer une poubelle");
        Button collecter = new Button("Collecter");
        Button realiserStat = new Button("Réaliser");

        VBox centreTriLayout = new VBox(10);
        centreTriLayout.getChildren().addAll(placerPoubelle, collecter, realiserStat);
        centreTriScene.setRoot(centreTriLayout);

        placerPoubelle.setOnAction(e -> {
            // Ajouter la méthode pour placer la poubelle
        });
        collecter.setOnAction(e -> {
            // Ajouter la méthode pour collecter
        });
        realiserStat.setOnAction(e -> {
            // Ajouter la méthode pour faire stat
        });

		// Ajout du bouton pour le commerce
		Button renouveler = new Button("Renouveler le contrat d'un an");

		VBox commerceLayout = new VBox(10);
        commerceLayout.getChildren().addAll(renouveler);
        commerceScene.setRoot(centreTriLayout);

		renouveler.setOnAction(e -> {
			// Méthode renouveler
			Contrat contrat = new Contrat();
			contrat.setDatedeb(new Date());
			Date date = new Date();
			// Permet de fixer la date de fin à dans un an
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(Calendar.YEAR, 1);
			Date datefin = calendar.getTime();
			contrat.setDatefin(datefin);
			contrat.setProduitConcerné(Produit.Offre);

			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText(null);
			alert.setContentText(datefin.toString());
			alert.showAndWait();

			Alert alert2 = new Alert(AlertType.INFORMATION);
			alert2.setHeaderText(null);
			alert2.setContentText(contrat.getProduitConcerné().toString());
			alert2.showAndWait();
			// Renouveler augmente de 1 an la date de fin du contrat 
			// Renouveler permet de modifier la valeur d'une reduction
			contrat.renouveler(datefin);

			Alert alert3 = new Alert(AlertType.INFORMATION);
			alert3.setHeaderText(null);
			alert3.setContentText(contrat.getDatefin().toString());
			alert3.showAndWait();

			Alert alert4 = new Alert(AlertType.INFORMATION);
			alert4.setHeaderText(null);
			alert4.setContentText(contrat.getProduitConcerné().toString());
			alert4.showAndWait();
		});

	    primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch (args);
	}
}
