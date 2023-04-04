import java.util.Date;

public class Contrat {
    private Date datedeb;
    private Date datefin;
    private Produits demande;
    private String produitConcerné=demande.getCatalog();


    public Date getDatedeb() {
        return datedeb;
    }

    public void setDatedeb(Date datedeb) {
        this.datedeb = datedeb;
    }

    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    public Produits getDemande() {
        return demande;
    }

    public void setDemande(Produits demande) {
        this.demande = demande;
    }

    public String getProduitConcerné() {
        return produitConcerné;
    }
   
    public void setProduitConcerné(String produitConcerné) {
        this.produitConcerné = produitConcerné;
    }

    public void renouveler(Produits demande){
        /*  */
     }

}