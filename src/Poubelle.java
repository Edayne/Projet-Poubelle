import java.util.ArrayList;

public abstract class Poubelle {
    private int idPoubelle;
    private String emplacement;
    private int capaciteMax;
    private int quantiteAct;
    private TypeDechets typeDechets;
    private ArrayList<Utilisateur> listeUser; //Définit les utilisateurs possesseurs de cette poubelle
    private CentreDeTri centreDeTri; //Poubelle affiliée à un unique centre

    //Ajout d'un nouvel utilisateur en fin de liste
    public void addUser(Utilisateur user) {
        this.listeUser.add(user);
    }

    //Teste si l'utilisateur qui tente de mettre un déchet est propriétaire
    public boolean checkUser(Utilisateur utilisateur) {
        int idTeste = utilisateur.getIdUser();

        ArrayList<Integer> listeIdUser = new ArrayList<Integer>();
        for (Utilisateur utilIter : listeUser) {
            listeIdUser.add(utilIter.getIdUser());
        }

        for (Integer idIter : listeIdUser) {
            if (idIter == idTeste) {
                System.out.println("Il s'agit du bon utilisateur.");
                return(true);
            } 
        }
        System.out.println("Vous n'êtes pas propriétaire de cette poubelle.");
        return false;
    }

    //Envoit une notification au centre de tri affilié
    public void envoyerNotifCentre(){
        System.out.println("Poubelle n° "+ getIdPoubelle() + " pleine !");
    }

    public void consulterHistorique() {
        
    }

    public boolean estPleine() {
        return (quantiteAct >= capaciteMax);
    }
    
    public void vider() {
        this.quantiteAct = 0;
    }

    //Getters et setters
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

    public ArrayList<Utilisateur> getListeUser() {
        return listeUser;
    }

    public void setListeUser(ArrayList<Utilisateur> listeUser) {
        this.listeUser = listeUser;
    }

    public CentreDeTri getCentreDeTri() {
        return centreDeTri;
    }

    public void setCentreDeTri(CentreDeTri centreDeTri) {
        this.centreDeTri = centreDeTri;
    }

    
}
