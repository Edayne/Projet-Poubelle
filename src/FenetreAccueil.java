

import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;

public class FenetreAccueil extends Application {
	
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("ma Fenêtre");
		
		Button particuliers = new Button("Particuliers");
		Button commerce = new Button("Commerce");
		Button centreTri = new Button("Centre de tri");
		
		VBox menuButtons = new VBox(5);
		
		StackPane root = new StackPane();
		
		root.getChildren().add(menuButtons);
		menuButtons.getChildren().add(particuliers);
		menuButtons.getChildren().add(commerce);
		menuButtons.getChildren().add(centreTri);
		
		menuButtons.setAlignment(Pos.CENTER);
		
	    Scene scene = new Scene(root, 500, 300);
	    primaryStage.setScene(scene);

		// Définition des Scenes des diff personne
		Scene Particuliers = new Scene(new VBox(),500,300);
		Scene CentreTri = new Scene(new VBox(),500,300);
		Scene Commerce = new Scene(new VBox(),500,300);
	    

		// Redirection des buttons vers d'autre scene 
		particuliers.setOnAction(e -> primaryStage.setScene(Particuliers));
		commerce.setOnAction(e -> primaryStage.setScene(Commerce));
		centreTri.setOnAction(e -> primaryStage.setScene(CentreTri));

		// 
		//
		// Ajout des boutons du Particulier avec leur action (Potentiellement à déplacer dans une autre classe)
		//
		//
		Button consulterHistoriqueBtn = new Button("Consulter Historique");
        Button convertirPtsBtn = new Button("Convertir Pts");
		// Button ajoutPts = new Button("Point Gagné"); 


		VBox vbox = (VBox) particuliers.getRoot();
        vbox.getChildren().addAll(consulterHistoriqueBtn, convertirPtsBtn/*,ajoutPts */);

        consulterHistoriqueBtn.setOnAction(e -> {
			// Ajouter la méthode pour consulter l'histo
        });
        convertirPtsBtn.setOnAction(e -> {
			// Ajouter la méthode pour consulter l'histo
        });
		/* ajoutPts.setOnAction(e -> {
			Ajouter les méthodes pour calculer qteDechet + ajoutPts
		}) */

		//
		//
		// Ajout des boutons du Centre de tri
		//
		//
		Button placerPoubelle = new Button("Placer une poubelle"); 
		Button collecter = new Button("Collecter");
		Button realiserStat = new Button("Réaliser");

		VBox vbox = (VBox) CentreTri.getRoot();
        vbox.getChildren().addAll(placerPoubelle, collecter,realiserStat);

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