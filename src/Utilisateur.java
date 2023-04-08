import java.util.ArrayList;

public class Utilisateur{
    private int idUser; 
    private String nom;
    private int codeAcces;
    private int ptsFidelite;
    private Poubelle poubelle;
    private ArrayList<DeposerDechet> listeDeposerDechets;

    //Getters et setters
    /**
     * @return int return the idUser
     */
    public int getIdUser() {
        return idUser;
    }
    /**
     * @param idUser the idUser to set
     */
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
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
     * @return int return the codeAcces
     */
    public int getCodeAcces() {
        return codeAcces;
    }
    /**
     * @param codeAcces the codeAcces to set
     */
    public void setCodeAcces(int codeAcces) {
        this.codeAcces = codeAcces;
    }
    /**
     * @return int return the ptsFidelite
     */
    public int getPtsFidelite() {
        return ptsFidelite;
    }
    /**
     * @param ptsFidelite the ptsFidelite to set
     */
    public void setPtsFidelite(int ptsFidelite) {
        this.ptsFidelite = ptsFidelite;
    }
    /**
     * @return Poubelle return the poubelle
     */
    public Poubelle getPoubelle() {
        return poubelle;
    }
    /**
     * @param poubelle the poubelle to set
     */
    public void setPoubelle(Poubelle poubelle) {
        this.poubelle = poubelle;
    }
    /**
     * @return ArrayList<DeposerDechet> return the listeDeposerDechets
     */
    public ArrayList<DeposerDechet> getListeDeposerDechets() {
        return listeDeposerDechets;
    }
    /**
     * @param listeDeposerDechets the listeDeposerDechets to set
     */
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