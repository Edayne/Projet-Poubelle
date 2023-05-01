public class PoubelleVerre extends Poubelle{
    public PoubelleVerre(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	private int poidsIndiv; //correspond au poids d'un seul déchet de ce type

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
