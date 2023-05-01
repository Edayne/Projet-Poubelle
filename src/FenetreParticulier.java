import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.stage.Stage;

public class FenetreParticulier extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception{
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
		Button choisir = new Button("Choisir");
		HBox listeUtilBouton = new HBox(10);
		listeUtil.getChildren().add(listView);
		listeUtil.getChildren().add(listeUtilBouton);
		listeUtilBouton.getChildren().add(ajouter);
		listeUtilBouton.getChildren().add(choisir);
		
		listeUtilBouton.setAlignment(Pos.CENTER);
		
		//Classe invisible qui gère les clics sur boutons
		EventHandler<ActionEvent> handler = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				// on a cliqué sur le bouton
				System.out.println("Handling event " + event.getEventType());
				
				// on signifie à JavaFX que rien d’autre n’a besoin de cet événement
				//event.consume();
			}
		};
		
		choisir.setOnAction(e -> System.out.println("Bouton CHOISIR appuyé"));

		Text t = new Text(10, 50, "Entrez votre code d'accès");
		TextField motDePasse = new TextField();
		zoneInfos.getChildren().add(t);
		zoneInfos.getChildren().add(motDePasse);
		
		//Récupère l'élément actuellement sélectionné
		String currentElm = listView.getSelectionModel().getSelectedItem();
		
		Text infos = new Text(10, 50, "Nom :\t" + currentElm
		+ "\nPoints de fidélité :\t215"
		+ "\nPoubelles :\t01"
		);
		zoneInfos.getChildren().add(infos);
		
		
	    Scene scene = new Scene(root, 500, 300);
	    primaryStage.setScene(scene);
	    primaryStage.show();
	}
	
	public static void main(String[] args) {
		Application.launch (args);
	}
}



