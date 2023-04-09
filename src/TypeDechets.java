
public enum TypeDechets {
    VERRE(50), 
    RECYCL(20), 
    PAPIERS(15), 
    AUTRES(45);

    private int masse; //unite arbitraire

    TypeDechets(int masse) {
        this.masse = masse;
    }
    public int getMasse() {
        return masse;
    }
}
