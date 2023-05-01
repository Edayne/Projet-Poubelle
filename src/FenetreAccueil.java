

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;

import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.stage.Stage;

public class FenetreAccueil extends Application {
	
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("ma Fenêtre");
		
		Button particuliersBouton = new Button("Particuliers");
		Button commerceBouton = new Button("Commerce");
		Button centreTriBouton = new Button("Centre de tri");
		
		VBox menuButtons = new VBox(5);
		
		StackPane root = new StackPane();
		
		root.getChildren().add(menuButtons);
		menuButtons.getChildren().add(particuliersBouton);
		menuButtons.getChildren().add(commerceBouton);
		menuButtons.getChildren().add(centreTriBouton);
		
		menuButtons.setAlignment(Pos.CENTER);
		
	    Scene scene = new Scene(root, 500, 300);
	    primaryStage.setScene(scene);

		// Définition des Scenes des diff personne
		Scene particuliersScene = new Scene(new VBox(),500,300);
		Scene centreTriScene = new Scene(new VBox(),500,300);
		Scene commerceScene = new Scene(new VBox(),500,300);
	    

		// Redirection des buttons vers d'autre scene 
		particuliersBouton.setOnAction(e -> primaryStage.setScene(particuliersScene));
		commerceBouton.setOnAction(e -> primaryStage.setScene(commerceScene));
		centreTriBouton.setOnAction(e -> primaryStage.setScene(centreTriScene));		 
		
		// Ajout des boutons du Particulier avec leur action (Potentiellement à déplacer dans une autre classe)
		//
		//
		Button consulterHistoriqueBtn = new Button("Consulter Historique");
        Button convertirPtsBtn = new Button("Convertir Pts");
        Button deposerDechetsBtn = new Button("Déposer");
		// Button ajoutPts = new Button("Point Gagné"); 


		VBox particulierLayout = new VBox(10);
        particulierLayout.getChildren().addAll(consulterHistoriqueBtn, convertirPtsBtn, deposerDechetsBtn);
        particuliersScene.setRoot(particulierLayout);

        consulterHistoriqueBtn.setOnAction(e -> {
        	Utilisateur utilisateur = new Utilisateur(1, "Didier");
            utilisateur.setPtsFidelite(200);
            Poubelle poubelle = new Poubelle(1,TypeDechets.VERRE);
            utilisateur.setPoubelle(poubelle);
            DeposerDechet deposerDechet = new DeposerDechet(1, "Bouteille", 1.5);
            ArrayList<DeposerDechet> listeDeposerDechets = new ArrayList<>();
            listeDeposerDechets.add(deposerDechet);
            utilisateur.setListeDeposerDechets(listeDeposerDechets);

            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent));

            utilisateur.consulterHistorique();

            String expectedOutput = "Historique de l'utilisateur :\n" +
                "\n" +
                "Nom : Didier\n" +
                "idUser : 1\n" +
                "Code Acces : 0\n" +
                "Pts Fidelite : 200\n" +
                "Poubelle : " + poubelle + "\n" +
                "\n" +
                "Déchets déposés :\n" +
                "DéposerDechet{idDeposerDechet=1, nom='Bouteille', poids=1.5}\n";
            assertEquals(expectedOutput, outContent.toString());        
            });
        
        convertirPtsBtn.setOnAction(e -> {
            Utilisateur utilisateur = new Utilisateur(1, "Bigard");
            utilisateur.setPtsFidelite(200);
            utilisateur.convertirPtsFidelite(utilisateur);
            assertEquals(2, utilisateur.getPtsFidelite()); 
            });
        
		deposerDechetsBtn.setOnAction(e -> {
			// Méthode de déposer Déchets
			DeposerDechet dechetAlice = new DeposerDechet();
			dechetAlice.setDate(new Date());
			dechetAlice.setQteDechet(10);
			dechetAlice.setTypeDechets(TypeDechets.VERRE);
			Utilisateur alice = new Utilisateur(01, "alice");
			dechetAlice.setUtilisateur(alice);
			dechetAlice.setPtsgagne(0);
			int j = alice.getPtsFidelite();
			dechetAlice.calculerQteDechets(dechetAlice.getQteDechet(), dechetAlice.getTypeDechets());
			dechetAlice.ajoutPtsGagné(alice,dechetAlice.getPtsgagne());
			int i = alice.getPtsFidelite();

			Alert alert = new Alert(Alert.AlertType.INFORMATION);
    		alert.setTitle("Message");
    		alert.setHeaderText(null);
			alert.setContentText("Nombre de points de fidélité avant ajout : " + j + "\n" +
			"Nombre de points de fidélité après ajout : " + i);
			alert.showAndWait();
		});



        // Ajout des boutons du Centre de tri avec leur action
        Button placerPoubelle = new Button("Placer une poubelle");
        Button collecter = new Button("Collecter");
        Button realiserStat = new Button("Réaliser");

        VBox centreTriLayout = new VBox(10);
        centreTriLayout.getChildren().addAll(placerPoubelle, collecter, realiserStat);
        centreTriScene.setRoot(centreTriLayout);

        placerPoubelle.setOnAction(e -> {
        	CentreDeTri centreDeTri = new CentreDeTri();
            Poubelle poubelle = new Poubelle(1);
            String adresse = "rue des Gâtés";

            // Ajout d'une première poubelle
            centreDeTri.placerPoubelle(poubelle, adresse);
            assertEquals(1, centreDeTri.getListePoubelles().size());
            assertEquals(adresse, centreDeTri.getListePoubelles().get(0).getEmplacement());

            // Ajout d'une deuxième poubelle à la même adresse
            Poubelle poubelle2 = new Poubelle(2);
            centreDeTri.placerPoubelle(poubelle2, adresse);
            assertEquals(1, centreDeTri.getListePoubelles().size());
            assertNotEquals(adresse, centreDeTri.getListePoubelles().get(0).getEmplacement());
        });
        collecter.setOnAction(e -> {
        	CentreDeTri centreDeTri = new CentreDeTri();
            Poubelle poubelle = new Poubelle(1);
            centreDeTri.setNom("Centre de tri Patafix");
            centreDeTri.setAdresse("rue des Gâtés");
            centreDeTri.setListePoubelles(new ArrayList<>());
            centreDeTri.getListePoubelles().add(poubelle);

            // Vérification des statistiques avant collecte
            assertEquals(0, centreDeTri.realiserStats().size());

            // Collecte de la poubelle
            poubelle.ajouterDechet(new TypeDechet(TypeDechets.VERRE));
            poubelle.ajouterDechet(new Dechet(TypeDechets.VERRE));
            poubelle.ajouterDechet(new Dechet(TypeDechets.PAPIER));
            centreDeTri.collecter();

            // Vérification de la collecte et des statistiques
            assertTrue(poubelle.estVide());
            assertEquals(2, centreDeTri.getListePoubelles().size());
            assertEquals(2, centreDeTri.realiserStats().get(TypeDechets.VERRE).intValue());
            assertEquals(1, centreDeTri.realiserStats().get(TypeDechets.PAPIERS).intValue());        
            });
        realiserStat.setOnAction(e -> {
        	// Créer un centre de tri avec une poubelle pour les déchets recyclables
            CentreDeTri centre = new CentreDeTri();
            centre.setNom("Centre de tri Patafix");
            centre.setAdresse("4 rue du Matic");
            centre.setListePoubelles(new ArrayList<>());

            Poubelle poubelle1 = new Poubelle(TypeDechets.VERRE);
            centre.placerPoubelle(poubelle1, "Entrée");
            centre.realiserStats();

            // On s'attend à avoir 1 déchet recyclable collecté
            HashMap<TypeDechets, Integer> stats = centre.getStats();
            assert stats.get(TypeDechets.VERRE) == 1 : "Le nombre de déchets verres collectés est incorrect";

            // Ajouter une autre poubelle pour les déchets organiques
            Poubelle poubelle2 = new Poubelle(TypeDechets.PAPIERS);
            centre.placerPoubelle(poubelle2, "Cuisine");

            // Collecter les déchets dans les poubelles pleines
            poubelle1.ajouterDechets(2);
            poubelle2.ajouterDechets(3);
            centre.collecter();

            // On s'attend à avoir 1 déchet recyclable collecté et 1 déchet organique collecté
            stats = centre.getStats();
            assert stats.get(TypeDechets.VERRE) == 1 : "Le nombre de déchets verres collectés est incorrect";
            assert stats.get(TypeDechets.PAPIERS) == 1 : "Le nombre de déchets papiers collectés est incorrect";

            // Collecter les déchets restants
            poubelle1.ajouterDechets(3);
            poubelle2.ajouterDechets(4);
            centre.collecter();

            // On s'attend à avoir 4 déchets recyclables collectés et 4 déchets organiques collectés
            stats = centre.getStats();
            assert stats.get(TypeDechets.VERRE) == 4 : "Le nombre de déchets verres collectés est incorrect";
            assert stats.get(TypeDechets.PAPIERS) == 4 : "Le nombre de déchets papiers collectés est incorrect";        });

		// Ajout du bouton pour le commerce
		Button renouveler = new Button("Renouveler le contrat d'un an");

		VBox commerceLayout = new VBox(10);
        commerceLayout.getChildren().addAll(renouveler);
        commerceScene.setRoot(centreTriLayout);

		renouveler.setOnAction(e -> {
			// Méthode renouveler
			Contrat contrat = new Contrat();
			contrat.setDatedeb(new Date());
			Date date = new Date();
			// Permet de fixer la date de fin à dans un an
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(Calendar.YEAR, 1);
			Date datefin = calendar.getTime();
			contrat.setDatefin(datefin);
			contrat.setProduitConcerné(Produit.Offre);

			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText(null);
			alert.setContentText(datefin.toString());
			alert.showAndWait();

			Alert alert2 = new Alert(AlertType.INFORMATION);
			alert2.setHeaderText(null);
			alert2.setContentText(contrat.getProduitConcerné().toString());
			alert2.showAndWait();
			// Renouveler augmente de 1 an la date de fin du contrat 
			// Renouveler permet de modifier la valeur d'une reduction
			contrat.renouveler(datefin);

			Alert alert3 = new Alert(AlertType.INFORMATION);
			alert3.setHeaderText(null);
			alert3.setContentText(contrat.getDatefin().toString());
			alert3.showAndWait();

			Alert alert4 = new Alert(AlertType.INFORMATION);
			alert4.setHeaderText(null);
			alert4.setContentText(contrat.getProduitConcerné().toString());
			alert4.showAndWait();
		});

	    primaryStage.show();
	}
	
	private void assertTrue(boolean estVide) {
		// TODO Auto-generated method stub
		
	}

	private void assertNotEquals(String adresse, String emplacement) {
		// TODO Auto-generated method stub
		
	}

	private void assertEquals(String adresse, String emplacement) {
		// TODO Auto-generated method stub
		
	}

	private void assertEquals(int i, int size) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		launch (args);
	}
}
