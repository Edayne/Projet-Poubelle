

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

		Scene Particuliers = new Scene(root,500,300);
		Scene CentreTri = new Scene(root,500,300);
		Scene Commerce = new Scene(root,500,300);
	    
		
		// Redirection des buttons vers d'autre scene 
		particuliers.setOnAction(e -> primaryStage.setScene(Particuliers));
		commerce.setOnAction(e -> primaryStage.setScene(Commerce));
		centreTri.setOnAction(e -> primaryStage.setScene(CentreTri));

		

	    primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch (args);
	}
}
