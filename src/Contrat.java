import java.util.Date;

public class Contrat {
    private Date datedeb;
    private Date datefin;
    private Produits produitConcerné;
    private Regles demande;

    /**
     * @return Date return the datedeb
     */
    public Date getDatedeb() {
        return datedeb;
    }

    /**
     * @param datedeb the datedeb to set
     */
    public void setDatedeb(Date datedeb) {
        this.datedeb = datedeb;
    }

    /**
     * @return Date return the datefin
     */
    public Date getDatefin() {
        return datefin;
    }

    /**
     * @param datefin the datefin to set
     */
    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    /**
     * @return Produits return the produitConcerné
     */
    public Produits getProduitConcerné() {
        return produitConcerné;
    }

    /**
     * @param produitConcerné the produitConcerné to set
     */
    public void setProduitConcerné(Produits produitConcerné) {
        this.produitConcerné = produitConcerné;
    }

    /**
     * @return Regles return the demande
     */
    public Regles getDemande() {
        return demande;
    }

    /**
     * @param demande the demande to set
     */
    public void setDemande(Regles demande) {
        this.demande = demande;
    }
    public void renouveler(Regles demande){
       /*     */
    }
}