import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;


public class Main {

	public static void main(String[] args) {
		// Création de d'utilisateur pour faire les tests des fonctions
		Utilisateur user1 = new Utilisateur(1, "Alice");
        user1.setCodeAcces(1234);
        user1.setPtsFidelite(50);
        // user1.setPoubelle(new Poubelle());
        user1.setListeDeposerDechets(new ArrayList<>());

		// User2 Utilisé pour tester la partie Utilisateur/DéposerDéchets
        Utilisateur user2 = new Utilisateur(2, "Bob");
        user2.setCodeAcces(5678);
        user2.setPtsFidelite(20);
		// user2.setPoubelle(new Poubelle());
		user2.setListeDeposerDechets(new ArrayList<>());

		// Enlever les /*  */ Pour essayer les méthodes de DeposerDechet
		
		/* 
		DeposerDechet dechetUser2 = new DeposerDechet();
		dechetUser2.setDate(new Date());
		dechetUser2.setQteDechet(10);
		dechetUser2.setTypeDechets(TypeDechets.VERRE);
		dechetUser2.setUtilisateur(user2);
		dechetUser2.setPtsgagne(0);
		dechetUser2.calculerQteDechets(dechetUser2.getQteDechet(), dechetUser2.getTypeDechets());
		dechetUser2.ajoutPtsGagné(user2,dechetUser2.getPtsgagne());
		int i=user2.getPtsFidelite();
		System.out.println("Le nombre de point de fidelité après ajout est :" + i);
		*/

		// Enlever les /* */ Pour essayer les méthodes de Contrat

		/* 
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
		System.out.println(datefin.toString());
		System.out.println(contrat.getProduitConcerné().toString());
		// Renouveler augmente de 1 an la date de fin du contrat 
		// Renouveler permet de modifier la valeur d'une reduction
		contrat.renouveler(datefin);
		System.out.println(contrat.getDatefin().toString());
		System.out.println(contrat.getProduitConcerné().toString());
		*/
	}

	//Fonction qui permet la lecture de fichiers csv/txt avec un délimiteur ","
	public ArrayList<String[]> readData() throws IOException { 
        int count = 0;
        String file = "../donnees/utilisateur.txt";
        ArrayList<String[]> content = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = "";
            while ((line = br.readLine()) != null) {
                content.add(line.split(","));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Fichier utilisateur.txt introuvable !");
        }

        return content;
    }
}
