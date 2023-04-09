import java.util.Date;

public class DeposerDechet {
    private Date date;
    private int qteDechet;
    private TypeDechets typeDechets;
    private int ptsgagne;
    private Utilisateur user; //faut savoir quel utilisateur dépose les déchets pour récupérer l'historique notamment



    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getQteDechet() {
        return qteDechet;
    }

    public void setQteDechet(int qteDechet) {
        this.qteDechet = qteDechet;
    }

    public TypeDechets getTypeDechets() {
        return typeDechets;
    }

    public void setTypeDechets(TypeDechets typeDechets) {
        this.typeDechets = typeDechets;
    }

    public int getPtsgagne() {
        return ptsgagne;
    }

    public void setPtsgagne(int ptsgagne) {
        this.ptsgagne = ptsgagne;
    }
    
    public void calculerQteDechets(int qteDechet, TypeDechets typeDechets){
        ptsgagne=0;
        int masse = typeDechets.getMasse();
        ptsgagne= masse*qteDechet;
        setPtsgagne(ptsgagne);
    }

    public void ajoutPtsGagné(Utilisateur user,int ptsgagne){
        user.setPtsFidelite(user.getPtsFidelite() + ptsgagne);
    }
}