import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;

public class testLogan extends Application {
	
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
		int nbrP = 500;
		String nom = "Moulin";
		Label label = new Label("Bonjour Monsieur "+nom+ ", vous avez " + nbrP + " points");
		Label nbr = new Label("123");
		Button consulterHistoriqueBtn = new Button("Consulter Historique");
        Button convertirPtsBtn = new Button("Convertir Pts");
		// Button ajoutPts = new Button("Point Gagné"); 
        

        VBox particulierLayout = new VBox(10);
        particulierLayout.setAlignment(Pos.CENTER);
        particulierLayout.getChildren().add(0,label);
        particulierLayout.getChildren().add(1,nbr);
        particulierLayout.getChildren().addAll(consulterHistoriqueBtn, convertirPtsBtn);
        Particuliers.setRoot(particulierLayout);

        consulterHistoriqueBtn.setOnAction(e -> {
            // Ajouter la méthode pour consulter l'histo
        	Label label2 = new Label("Bonjour");
        	particulierLayout.getChildren().add(3,label2);
        			
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
