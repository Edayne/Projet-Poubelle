import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.stage.*;

public class FenetrePart extends Application {

	public void start(Stage primaryStage) {
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
	    
	    primaryStage.show();
	}
	
	public static void main(String[] args) {
		Application.launch (args);
	}
}