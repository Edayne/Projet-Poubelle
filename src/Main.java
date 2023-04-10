import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;


public class Main {

	public static void main(String[] args) {
		// Création de d'utilisateur pour faire les tests des fonctions
		Utilisateur user1 = new Utilisateur();
        user1.setIdUser(1);
        user1.setNom("Alice");
        user1.setCodeAcces(1234);
        user1.setPtsFidelite(50);
        // user1.setPoubelle(new Poubelle());
        user1.setListeDeposerDechets(new ArrayList<>());

		// User2 Utilisé pour tester la partie Utilisateur/DéposerDéchets
        Utilisateur user2 = new Utilisateur();
        user2.setIdUser(2);
        user2.setNom("Bob");
        user2.setCodeAcces(5678);
        user2.setPtsFidelite(20);

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


		// Contrat Permet de verifier si la méthode renouveler fonctionne
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
		contrat.renouveler(datefin);
		System.out.println(contrat.getDatefin().toString());
	}	

}
