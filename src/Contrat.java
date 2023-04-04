import java.util.Calendar;
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

    /* Renouveler concerne les valeurs d'une réduction pour un catalogue  */
    /* Et augmente la date de fin de 1 an */
    public void renouveler(Produits demande,Date datefin){

        Calendar calendar= Calendar.getInstance();
        calendar.setTime(datefin);
        calendar.add(Calendar.YEAR,1);  /* Ajoute 1 an à l'instance calendar */
        datefin = calendar.getTime();
     }

}