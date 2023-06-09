import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Contrat {
    private Date datedeb;
    private Date datefin;
    private Produit produitConcerné;


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
        
    public Produit getProduitConcerné() {
        return produitConcerné;
    }
   
    public void setProduitConcerné(Produit offre) {
        this.produitConcerné = offre;
    }



    /* Renouveler concerne les valeurs d'une réduction pour un catalogue  */
    /* Et augmente la date de fin de 1 an */
 
    public void renouveler(Date datefin){
        Calendar calendar= Calendar.getInstance();
        calendar.setTime(datefin);
        calendar.add(Calendar.YEAR, 1);  /* Ajoute 1 an à l'instance calendar */
        datefin = calendar.getTime();
        setDatefin(datefin);
            Scanner sc;
            sc= new Scanner(System.in);
            System.out.println("Veuillez saisir la rubrique du catalogue dont vous souhaitez modifier le bon d'achat : ");
            String rubrique;
            rubrique=sc.nextLine();

            for (Produit produits: Produit.values()) {
                String name=produits.getCatalog();
                //On regarde si le produit qu'on souhaite modifier fait partie de notre catalogue
                if (rubrique.equals(name)){
                    Scanner sc2;
                    sc2 = new Scanner(System.in);
                    System.out.print("Saisir un pourcentage de réduction (ex: 5 pour une réduction de 5%) : ");
                    int value = sc2.nextInt();

                    produits.setReduction(value); //Mise à jour de la réduction offerte
                    sc2.close();
                }
            }
            sc.close();
        }
    public static void main(String[] args) {
        Contrat contrat = new Contrat();
        Date date = new Date();
        contrat.renouveler(date);
    }
}