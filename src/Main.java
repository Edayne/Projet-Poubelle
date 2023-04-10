import java.util.ArrayList;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		// Création de 2 utilisateur pour faire les tests des fonctions
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
        // user2.setPoubelle(new Poubelle());
        user2.setListeDeposerDechets(new ArrayList<>());

		DeposerDechet dechetUser2 = new DeposerDechet();
		dechetUser2.setDate(new Date());
		dechetUser2.setQteDechet(10);
		dechetUser2.setTypeDechets(TypeDechets.VERRE);
		dechetUser2.setUtilisateur(user2);
		dechetUser2.setPtsgagne(0);
		dechetUser2.calculerQteDechets(dechetUser2.getQteDechet(), dechetUser2.getTypeDechets());
		dechetUser2.ajoutPtsGagné(user2,dechetUser2.getPtsgagne());
		int i=dechetUser2.getPtsgagne();
		System.out.println("Le nombre de point de fidelité après ajout est :" + i);
	}

}
