public class PoubelleAutre extends Poubelle{
    private int poidsIndiv; //correspond au poids d'un déchet de ce type

    public PoubelleAutre(int poids) {
        
    }
    public int calculerPoids() {
        int poids = getQuantiteAct()*this.getPoids();
        return poids;
    }

    public int getPoids() {
        return poidsIndiv;
    }
    public void setPoids(int poids) {
        this.poidsIndiv = poids;
    }
    
}