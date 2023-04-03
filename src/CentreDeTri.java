import java.util.ArrayList;

public class CentreDeTri {
    private String nom;
    private String adresse;
    private ArrayList<Poubelle> listePoubelles;


    //Getters et setters
    /**
     * @return String return the nom
     */
    public String getNom() {
        return nom;
    }
    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    /**
     * @return String return the adresse
     */
    public String getAdresse() {
        return adresse;
    }
    /**
     * @param adresse the adresse to set
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    /**
     * @param listePoubelles the listePoubelles to set
     */
    public void setListePoubelles(ArrayList<Poubelle> listePoubelles) {
        this.listePoubelles = listePoubelles;
    }

    //Methodes
    public void placerPoubelle() {
    }
    public void collecter() {
    }
    public void realiserStats() {
    }

    /**
     * @return ArrayList<Poubelle> return the listePoubelles
     */
    public ArrayList<Poubelle> getListePoubelles() {
        return listePoubelles;
    }

    

}