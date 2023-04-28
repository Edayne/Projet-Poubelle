

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
	    /* 
	    Scene utilisateur = new Scene(root, 500,300);
		Scene commerce = new Scene(root,500,300);
		Scene centreTri = new Scene(root,500,300);
	    */
	    primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch (args);
	}
}
