import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class CreerUtilisateur extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Création des champs de saisie
        TextField idUserField = new TextField();
        TextField nomField = new TextField();
        TextField codeAccesField = new TextField();
        TextField ptsFideliteField = new TextField();
        TextField poubelleField = new TextField();
        //TextArea listeDeposerDechetsArea = new TextArea();
        //TextArea listeProduitsArea = new TextArea();

        // Création du formulaire
        GridPane form = new GridPane();
        form.setPadding(new Insets(10));
        form.setHgap(10);
        form.setVgap(10);

        form.add(new Label("ID Utilisateur:"), 0, 0);
        form.add(idUserField, 1, 0);
        form.add(new Label("Nom:"), 0, 1);
        form.add(nomField, 1, 1);
        form.add(new Label("Code d'accès:"), 0, 2);
        form.add(codeAccesField, 1, 2);
        form.add(new Label("Points de fidélité:"), 0, 3);
        form.add(ptsFideliteField, 1, 3);
        form.add(new Label("Poubelle:"), 0, 4);
        form.add(poubelleField, 1, 4);
        //form.add(new Label("Liste des dépôts de déchets:"), 0, 5);
        //form.add(listeDeposerDechetsArea, 1, 5);
        //form.add(new Label("Liste des produits:"), 0, 6);
        //form.add(listeProduitsArea, 1, 6);

        // Création du bouton de validation
        Button validerButton = new Button("Valider");
        form.setAlignment(Pos.CENTER);
        validerButton.setOnAction(event -> {
        	
            // Récupération des valeurs saisies
            int idUser = Integer.parseInt(idUserField.getText());
            String nom = nomField.getText();
            int codeAcces = Integer.parseInt(codeAccesField.getText());
            int ptsFidelite = Integer.parseInt(ptsFideliteField.getText());
            PoubelleAutre poubelle = new PoubelleAutre(Integer.parseInt(poubelleField.getText()));

            // Création de l'instance de l'utilisateur
            Utilisateur utilisateur = new Utilisateur(idUser, nom);
            utilisateur.setCodeAcces(codeAcces);
            utilisateur.setPtsFidelite(ptsFidelite);
            utilisateur.setPoubelle(poubelle);
            
            // Affichage des informations saisies
            System.out.println("Utilisateur créé : " + utilisateur.toString());

            // Fermeture de la fenêtre
            primaryStage.close();
        });

        // Ajout du formulaire et du bouton de validation à la scène
        Scene scene = new Scene(new GridPane(), 400, 400);
        GridPane gridPane = (GridPane) scene.getRoot();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.add(form, 0, 0);
        gridPane.add(validerButton, 0, 1);

        // Affichage de la fenêtre
        primaryStage.setScene(scene);
        primaryStage.setTitle("Nouvel Utilisateur");
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    
    public void show() {
        // Création d'une nouvelle fenêtre Stage
        Stage stage = new Stage();

        // Création de la scène
        Scene nouveauUserScene = new Scene(new StackPane(), 400, 400);

        // Affichage de la scène dans la fenêtre
        stage.setScene(nouveauUserScene);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

}