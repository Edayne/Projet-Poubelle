public class Utilisateur {
    private int idUser; 
    private String nom;
    private int codeAcces;
    private int ptsFidelite;
    private Poubelle poubelle;

    //Getters et setters
    public getIdUser() {
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
}