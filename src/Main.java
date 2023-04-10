import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// Création de 2 utilisateur pour faire les tests des fonctions
		Utilisateur user1 = new Utilisateur();
        user1.setIdUser(1);
        user1.setNom("Alice");
        user1.setCodeAcces(1234);
        user1.setPtsFidelite(50);
        user1.setPoubelle(new Poubelle());
        user1.setListeDeposerDechets(new ArrayList<>());

        Utilisateur user2 = new Utilisateur();
        user2.setIdUser(2);
        user2.setNom("Bob");
        user2.setCodeAcces(5678);
        user2.setPtsFidelite(20);
        user2.setPoubelle(new Poubelle());
        user2.setListeDeposerDechets(new ArrayList<>());
	}

}
