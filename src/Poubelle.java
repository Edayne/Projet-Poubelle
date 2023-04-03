public abstract class Poubelle {
    private int idPoubelle;
    private String emplacement;
    private int capaciteMax;
    private int quantiteAct;
    private TypeDechets typeDechets;


    public void addUser(Utilisateur user) {

    }

    public void checkUser(Utilisateur user) {
        idUser = get
    }

    public void envoyerNotifCentre(){
        System.out.println("Poubelle n° "+ getIdPoubelle() + " pleine !");
    }

    public int getIdPoubelle() {
        return idPoubelle;
    }

    public void setIdPoubelle(int idPoubelle) {
        this.idPoubelle = idPoubelle;
    }

    public String getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(String emplacement) {
        this.emplacement = emplacement;
    }

    public int getCapaciteMax() {
        return capaciteMax;
    }

    public void setCapaciteMax(int capaciteMax) {
        this.capaciteMax = capaciteMax;
    }

    public int getQuantiteAct() {
        return quantiteAct;
    }

    public void setQuantiteAct(int quantiteAct) {
        this.quantiteAct = quantiteAct;
    }

    public TypeDechets getTypeDechets() {
        return typeDechets;
    }

    public void setTypeDechets(TypeDechets typeDechets) {
        this.typeDechets = typeDechets;
    }

    

}
