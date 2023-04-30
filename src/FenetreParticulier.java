import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.stage.Stage;

public class FenetreParticulier extends Application {

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("ma Fenêtre");		
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
		
		ObservableList<String> names = FXCollections.observableArrayList(
				alice.getNom(), bob.getNom());
		ListView<String> listView = new ListView<String>(names);
		Button ajouter = new Button("Nouveau");
		listeUtil.getChildren().add(listView);
		listeUtil.getChildren().add(ajouter);
		
		Text t = new Text(10, 50, "Entrez votre code d'accès");
		TextField motDePasse = new TextField();
		zoneInfos.getChildren().add(t);
		zoneInfos.getChildren().add(motDePasse);
		
		
	    Scene scene = new Scene(root, 500, 300);
	    primaryStage.setScene(scene);
	    
	    primaryStage.show();
	}
	
	public static void main(String[] args) {
		Application.launch (args);
	}
}