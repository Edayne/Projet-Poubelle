public enum Produits {
    /* Proposition des différentes offres */
    Offre( 'Alimentaire', 15),
    Offre2('Sport', 5),
    Offre3('HightTech',  5),
    Offre4( 'Maison',  5),
    Offre5( 'Jardin',  5),
    Offre6( 'Vetement',  5),
    Offre7( 'Animalier',  5); 

    private String catalog;
    private int reduction;

    
    private Produits(String catalog,int reduction){
        this.catalog=catalog;
        this.reduction=reduction;
    }
    
    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    public int getReduction() {
        return reduction;
    }

    public void setReduction(int reduction) {
        this.reduction = reduction;
    }

}