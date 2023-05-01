import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;

public class CentreTriTest {

    @Test
    public void testPlacerPoubelle() {
        CentreDeTri centre = new CentreDeTri();
        centre.setNom("Centre de tri test");
        centre.setAdresse("123 rue test");

        ArrayList<Poubelle> listePoubelles = new ArrayList<Poubelle>();
        centre.setListePoubelles(listePoubelles);

        Poubelle poubelle1 = new Poubelle(TypeDechets.PLASTIQUE, 1);
        Poubelle poubelle2 = new Poubelle(TypeDechets.VERRE, 2);

        centre.placerPoubelle(poubelle1, "123 rue test");
        centre.placerPoubelle(poubelle2, "456 rue test");

        assertEquals("La poubelle a été placée à l'adresse 123 rue test", outContent.toString().trim());
    }

    @Test
    public void testCollecter() {
        CentreDeTri centre = new CentreDeTri();
        centre.setNom("Centre de tri test");
        centre.setAdresse("123 rue test");

        ArrayList<Poubelle> listePoubelles = new ArrayList<Poubelle>();
        centre.setListePoubelles(listePoubelles);

        Poubelle poubelle1 = new Poubelle(TypeDechets.PLASTIQUE, 1);
        Poubelle poubelle2 = new Poubelle(TypeDechets.VERRE, 2);

        poubelle1.setEmplacement("123 rue test");
        poubelle2.setEmplacement("456 rue test");

        centre.getListePoubelles().add(poubelle1);
        centre.getListePoubelles().add(poubelle2);

        poubelle1.ajouterDechets(5);
        poubelle2.ajouterDechets(10);

        centre.collecter();

        assertEquals("Poubelle 1 collectée au centre de tri Centre de tri test\nPoubelle 2 collectée au centre de tri Centre de tri test\nStatistiques du centre de tri Centre de tri test\nPLASTIQUE : 5\nVERRE : 10", outContent.toString().trim());
    }

    @Test
    public void testRealiserStats() {
        CentreDeTri centre = new CentreDeTri();
        centre.setNom("Centre de tri test");
        centre.setAdresse("123 rue test");

        ArrayList<Poubelle> listePoubelles = new ArrayList<Poubelle>();
        centre.setListePoubelles(listePoubelles);

        Poubelle poubelle1 = new Poubelle(TypeDechets.PLASTIQUE, 1);
        Poubelle poubelle2 = new Poubelle(TypeDechets.VERRE, 2);

        poubelle1.setEmplacement("123 rue test");
        poubelle2.setEmplacement("456 rue test");

        centre.getListePoubelles().add(poubelle1);
        centre.getListePoubelles().add(poubelle2);

        poubelle1.ajouterDechets(5);
        poubelle2.ajouterDechets(10);

        centre.realiserStats();

        assertEquals("", outContent.toString().trim());
    }
}
