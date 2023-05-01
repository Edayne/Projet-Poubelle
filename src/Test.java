import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
	
	public class Test extends Application {
		
		@Override
		public void start(Stage primaryStage) throws Exception {
			
			// Code pour créer une page de connexion
			Label nameL = new Label("Nom :");
			TextField nameF = new TextField();

			Label pwL = new Label("Code d'accès :");
			TextField pwF = new TextField();

			Button connectB = new Button("Connexion");
			
			GridPane gridpane = new GridPane();
			gridpane.addRow(0, nameL, nameF);
			gridpane.addRow(1, pwL, pwF);
			gridpane.add(connectB, 0, 2, 2, 1);
	
			GridPane.setHalignment(connectB, HPos.CENTER);
	
			Scene scene = new Scene(gridpane);
			primaryStage.setScene(scene);
			primaryStage.show();
			
		

	        // Clear
	        Button buttonClear = new Button("Clear");
	        buttonClear.setOnAction(new EventHandler<ActionEvent>() {
	
	            @Override
	            public void handle(ActionEvent event) {
	                nameF.clear();
	            }
	        });
	
	        // Copy
	        Button buttonCopy = new Button("Copy");
	
	        buttonCopy.setFocusTraversable(false);
	
	        buttonCopy.setOnAction(new EventHandler<ActionEvent>() {
	
	            @Override
	            public void handle(ActionEvent event) {
	                nameF.copy();
	            }
	        });
	
	        // Cut
	        Button buttonCut = new Button("Cut");
	
	        buttonCut.setFocusTraversable(false);
	
	        buttonCut.setOnAction(new EventHandler<ActionEvent>() {
	
	            @Override
	            public void handle(ActionEvent event) {
	                nameF.cut();
	            }
	        });
	
	        // Paste
	        Button buttonPaste = new Button("Paste");
	        buttonPaste.setFocusTraversable(false);
	        buttonPaste.setOnAction(new EventHandler<ActionEvent>() {
	
	            @Override
	            public void handle(ActionEvent event) {
	                nameF.paste();
	            }
	        });
		}
		  public static void main (String[] args) {
		        launch (args);
		  }      
		}


