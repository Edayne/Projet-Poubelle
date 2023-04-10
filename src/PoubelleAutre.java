public class PoubelleAutre extends Poubelle{
    private int poids;

    public PoubelleAutre(int poids) {
        
    }
    public int calculerPoids() {
        int poids = getQuantiteAct()*this.getPoids();
        return poids;
    }

    public int getPoids() {
        return poids;
    }
    public void setPoids(int poids) {
        this.poids = poids;
    }
    
}
