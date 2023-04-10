import java.util.ArrayList;

public class CentreDeTri {
    private int id;
    private String nom;
    private String adresse;
    private ArrayList<Poubelle> listePoubelles;


    
    public String getNom() {
        return nom;
    }
  
    public void setNom(String nom) {
        this.nom = nom;
    }
  
    public String getAdresse() {
        return adresse;
    }
  
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
  
    public void setListePoubelles(ArrayList<Poubelle> listePoubelles) {
        this.listePoubelles = listePoubelles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    //Methodes
    public void placerPoubelle() {
    }
    public void collecter() {
    }
    public void realiserStats() {
    }

    public ArrayList<Poubelle> getListePoubelles() {
        return listePoubelles;
    }
}