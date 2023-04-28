import javafx.application.Application;
	import javafx.scene.Scene;
	import javafx.scene.control.Button;
	import javafx.scene.control.Label;
	import javafx.scene.layout.StackPane;
	import javafx.scene.layout.GridPane;
	import javafx.geometry.Insets;
	import javafx.stage.Stage;
	
public class testLogan extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception {


	    /* donner un nom à la fenêtre */
	    primaryStage.setTitle("ma Fenêtre");

	    /* Création d'un bouton */
	    Button b = new Button("mon bouton");


	    /* création d'une fenêtre */
	   /* StackPane root = new StackPane();*/
	    
	    /* création d'une grille de 3 x 3 cellules */
	    GridPane gridPane = new GridPane();
	    gridPane.setPadding(new Insets(10, 10, 10, 10));
	    gridPane.setHgap(10);
	    gridPane.setVgap(10);
	    

	    /* création de boutons */
	    Button button1 = new Button("Bouton 1");
	    Button button2 = new Button("Bouton 2");
	    Button button3 = new Button("Bouton 3");
	    Button button4 = new Button("Bouton 4");
	    Button button5 = new Button("Bouton 5");
	    Button button6 = new Button("Bouton 6");
	    Button button7 = new Button("Bouton 7");
	    Button button8 = new Button("Bouton 8");
	    Label la = new Label("votre nombre de points:");

	    /* ajout des boutons à la grille */
	    gridPane.add(button1, 0, 0);
	    gridPane.add(button2, 1, 0);
	    gridPane.add(button3, 2, 0);
	    gridPane.add(button4, 0, 1);
	    gridPane.add(button5, 1, 1);
	    gridPane.add(button6, 2, 1);
	    gridPane.add(button7, 0, 2);
	    gridPane.add(la, 1, 2);
	    gridPane.add(button8, 2, 2);

	    /* ajouter le bouton à la scene */
	    
	   /* root.getChildren().add(b);	
	    root.getChildren().add(la);	*/
	    
	    
	    

	    /* création d'une scene et de son association avec */
	    /* la fenêtre + taille */
	   /* Scene scene = new Scene(root, 1000, 600); */
	    Scene scene = new Scene(gridPane, 1000, 600);

	    /* Ajouter la scene */
	    primaryStage.setScene(scene);

	    /* rendre la fenêtre visible */
	    primaryStage.show();

	    }
	    public static void main (String[] args) {
	        launch (args);
	    }
	    
	    }

