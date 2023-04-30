

import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.stage.*;

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

		// 
		//
		// Ajout des boutons du Particulier avec leur action (Potentiellement à déplacer dans une autre classe)
		//
		//
		Button consulterHistoriqueBtn = new Button("Consulter Historique");
        Button convertirPtsBtn = new Button("Convertir Pts");
		// Button ajoutPts = new Button("Point Gagné"); 


		VBox particulierLayout = new VBox(10);
        particulierLayout.getChildren().addAll(consulterHistoriqueBtn, convertirPtsBtn);
        Particuliers.setRoot(particulierLayout);

        consulterHistoriqueBtn.setOnAction(e -> {
            // Ajouter la méthode pour consulter l'histo
        });
        convertirPtsBtn.setOnAction(e -> {
            // Ajouter la méthode pour consulter l'histo
        });

        // Ajout des boutons du Centre de tri avec leur action
        Button placerPoubelle = new Button("Placer une poubelle");
        Button collecter = new Button("Collecter");
        Button realiserStat = new Button("Réaliser");

        VBox centreTriLayout = new VBox(10);
        centreTriLayout.getChildren().addAll(placerPoubelle, collecter, realiserStat);
        CentreTri.setRoot(centreTriLayout);

        placerPoubelle.setOnAction(e -> {
            // Ajouter la méthode pour placer la poubelle
        });
        collecter.setOnAction(e -> {
            // Ajouter la méthode pour collecter
        });
        realiserStat.setOnAction(e -> {
            // Ajouter la méthode pour faire stat
        });

		

	    primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch (args);
	}
}
