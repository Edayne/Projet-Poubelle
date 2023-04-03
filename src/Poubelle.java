public abstract class Poubelle {
    private int idPoubelle;
    private String emplacement;
    private int capaciteMax;
    private int quantiteAct;
    private TypeDechets typeDechets;

    public void addUser(Utilisateur user);
}
