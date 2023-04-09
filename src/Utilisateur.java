import java.util.ArrayList;

public class Utilisateur{
    private int idUser; 
    private String nom;
    private int codeAcces;
    private int ptsFidelite;
    private Poubelle poubelle;
    private ArrayList<DeposerDechet> listeDeposerDechets;

 
    public int getIdUser() {
        return idUser;
    }
  
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
   
    public String getNom() {
        return nom;
    }
  
    public void setNom(String nom) {
        this.nom = nom;
    }
  
    public int getCodeAcces() {
        return codeAcces;
    }
  
    public void setCodeAcces(int codeAcces) {
        this.codeAcces = codeAcces;
    }
 
    public int getPtsFidelite() {
        return ptsFidelite;
    }
  
    public void setPtsFidelite(int ptsFidelite) {
        this.ptsFidelite = ptsFidelite;
    }
   
    public Poubelle getPoubelle() {
        return poubelle;
    }
  
    public void setPoubelle(Poubelle poubelle) {
        this.poubelle = poubelle;
    }
  
    public ArrayList<DeposerDechet> getListeDeposerDechets() {
        return listeDeposerDechets;
    }
   
    public void setListeDeposerDechets(ArrayList<DeposerDechet> listeDeposerDechets) {
        this.listeDeposerDechets = listeDeposerDechets;
    }

    

    //Méthodes
    public void convertirPtsFidelite(int ptsFidelite) {
        this.ptsFidelite = ptsFidelite;
        this.poubelle.consulterHistorique();
    }
    
    public void consulterHistorique() {
        System.out.println("Historique de l'utilisateur :");
        System.out.println("Nom : " + getNom());
        System.out.println("idUser : " + getIdUser());
        System.out.println("Code Acces : " + getCodeAcces());
        System.out.println("Pts Fidelite : " + getPtsFidelite());
        System.out.println("Poubelle : " + getPoubelle());
        System.out.println("Dechets deposes : " +getListeDeposerDechets());
    }
}