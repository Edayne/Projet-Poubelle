import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.plugins.tiff.ExifTIFFTagSet;

public class Utilisateur{
    private int idUser; 
    private String nom;
    private int codeAcces;
    private int ptsFidelite;
    private Poubelle poubelle;
    private ArrayList<DeposerDechet> listeDeposerDechets;
    private ArrayList<Produit> listeProduits;

    public Utilisateur(int idUser, String nom) {
        this.idUser = idUser;
        this.nom = nom;
    }

    public int getIdUser() {
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
  
    public ArrayList<DeposerDechet> getListeDeposerDechets() {
        return listeDeposerDechets;
    }
   
    public void setListeDeposerDechets(ArrayList<DeposerDechet> listeDeposerDechets) {
        this.listeDeposerDechets = listeDeposerDechets;
    }

    

    //Méthodes
    public void convertirPtsFidelite(Utilisateur utilisateur) {
        int ptsFidelite = utilisateur.getPtsFidelite();
        Commerce commerce = new Commerce();
        Contrat contrat = commerce.getContrat();
        Produit produitConcerné = contrat.getProduitConcerné();
        int reduction = produitConcerné.getReduction();
        int reductionAppliquee = ptsFidelite / 100 * reduction;
        utilisateur.setPtsFidelite(ptsFidelite % 100);
        System.out.println("Vous avez utilisé " + reductionAppliquee + " points de fidélité pour bénéficier d'une réduction de " + reductionAppliquee + "% sur votre prochain achat de produits " + produitConcerné.getCatalog());
    }



    
    public void consulterHistorique() {
        System.out.println("Historique de l'utilisateur :\n");
        System.out.println("Nom : " + getNom());
        System.out.println("idUser : " + getIdUser());
        System.out.println("Code Acces : " + getCodeAcces());
        System.out.println("Pts Fidelite : " + getPtsFidelite());
        System.out.println("Poubelle : " + getPoubelle());

        System.out.println("Déchets déposés :");
        for (DeposerDechet deposerDechet : getListeDeposerDechets()) {
            System.out.println(deposerDechet);
        }
    }

    public ArrayList<String[]> readData() throws IOException { 
        int count = 0;
        String file = "../donnees/utilisateur.txt";
        ArrayList<String[]> content = new ArrayList<>();
        
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = "";
            while ((line = br.readLine()) != null) {
                content.add(line.split(","));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Fichier utilisateur.txt introuvable !");
        }

        return content;
    }
    
}