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
    public void placerPoubelle(Poubelle poubelle, String adresse){
        for (Poubelle p : listePoubelles) {
            if (p.getAdresse().equals(adresse)){
                System.out.println("La poubelle existe déjà");
                return;

            }
        }
        poubelle.setAdresse(adresse);
        listePoubelles.add(poubelle);
        System.out.println("La poubelle a été placée à l'adresse " + adresse);
    }
    
    public void collecter() {
    for (Poubelle poubelle : listePoubelles) {
        if (poubelle.isPleine()) {
            // collecte de la poubelle
            poubelle.vider();

            // enregistrement dans le journal de collecte
            System.out.println("Poubelle " + poubelle.getId() + " collectée au centre de tri " + nom);
        }
    }
}

    public void realiserStats() {
    }

    public ArrayList<Poubelle> getListePoubelles() {
        return listePoubelles;
    }

    


    
}