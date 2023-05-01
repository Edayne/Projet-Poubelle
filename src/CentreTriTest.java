
public class CentreTriTest {

    public static void main(String[] args) {
        testPlacerPoubelle();
        testCollecter();
        testRealiserStats();
    }
    private static void assertEquals(int i, int size) {
		// TODO Auto-generated method stub
		
	}
	private static void assertEquals(String adresse, String string) {
		// TODO Auto-generated method stub
		
	}
	private static void assertNotEquals(String adresse, String emplacement) {
		// TODO Auto-generated method stub
		
	}
	
    private static void testPlacerPoubelle() {
        CentreDeTri centreDeTri = new CentreDeTri();
        Poubelle poubelle = new Poubelle(1);
        String adresse = "rue des Gâtés";

        // Ajout d'une première poubelle
        centreDeTri.placerPoubelle(poubelle, adresse);
        assertEquals(1, centreDeTri.getListePoubelles().size());
        assertEquals(adresse, centreDeTri.getListePoubelles().get(0).getEmplacement());

        // Ajout d'une deuxième poubelle à la même adresse
        Poubelle poubelle2 = new Poubelle(2, TypeDechets.PAPIER);
        centreDeTri.placerPoubelle(poubelle2, adresse);
        assertEquals(1, centreDeTri.getListePoubelles().size());
        assertNotEquals(adresse, centreDeTri.getListePoubelles().get(0).getEmplacement());
    }

	private static void testCollecter() {
        CentreDeTri centreDeTri = new CentreDeTri();
        Poubelle poubelle = new Poubelle(1, TypeDechets.VERRE);
        centreDeTri.setNom("Centre de tri Patafix");
        centreDeTri.setAdresse("rue des Gâtés");
        centreDeTri.setListePoubelles(new ArrayList<>());
        centreDeTri.getListePoubelles().add(poubelle);

        // Vérification des statistiques avant collecte
        assertEquals(0, centreDeTri.realiserStats().size());

        // Collecte de la poubelle
        poubelle.ajouterDechet(new Dechet(TypeDechets.VERRE));
        poubelle.ajouterDechet(new Dechet(TypeDechets.VERRE));
        poubelle.ajouterDechet(new Dechet(TypeDechets.PAPIER));
        centreDeTri.collecter();

        // Vérification de la collecte et des statistiques
        assertTrue(poubelle.estVide());
        assertEquals(2, centreDeTri.getListePoubelles().size());
        assertEquals(2, centreDeTri.realiserStats().get(TypeDechets.VERRE).intValue());
        assertEquals(1, centreDeTri.realiserStats().get(TypeDechets.PAPIER).intValue());
    }
	
	public static void testRealiserStats() {
        // Créer un centre de tri avec une poubelle pour les déchets recyclables
        CentreDeTri centre = new CentreDeTri();
        centre.setNom("Centre de tri #1");
        centre.setAdresse("123 rue de la Recyclade");
        centre.setListePoubelles(new ArrayList<>());

        Poubelle poubelle1 = new Poubelle(TypeDechets.RECYCLABLES);
        centre.placerPoubelle(poubelle1, "Entrée");
        centre.realiserStats();

        // On s'attend à avoir 1 déchet recyclable collecté
        HashMap<TypeDechets, Integer> stats = centre.getStats();
        assert stats.get(TypeDechets.RECYCLABLES) == 1 : "Le nombre de déchets recyclables collectés est incorrect";

        // Ajouter une autre poubelle pour les déchets organiques
        Poubelle poubelle2 = new Poubelle(TypeDechets.ORGANIQUES);
        centre.placerPoubelle(poubelle2, "Cuisine");

        // Collecter les déchets dans les poubelles pleines
        poubelle1.ajouterDechets(2);
        poubelle2.ajouterDechets(3);
        centre.collecter();

        // On s'attend à avoir 1 déchet recyclable collecté et 1 déchet organique collecté
        stats = centre.getStats();
        assert stats.get(TypeDechets.RECYCLABLES) == 1 : "Le nombre de déchets recyclables collectés est incorrect";
        assert stats.get(TypeDechets.ORGANIQUES) == 1 : "Le nombre de déchets organiques collectés est incorrect";

        // Collecter les déchets restants
        poubelle1.ajouterDechets(3);
        poubelle2.ajouterDechets(4);
        centre.collecter();

        // On s'attend à avoir 4 déchets recyclables collectés et 4 déchets organiques collectés
        stats = centre.getStats();
        assert stats.get(TypeDechets.RECYCLABLES) == 4 : "Le nombre de déchets recyclables collectés est incorrect";
        assert stats.get(TypeDechets.ORGANIQUES) == 4 : "Le nombre de déchets organiques collectés est incorrect";
    }
}
