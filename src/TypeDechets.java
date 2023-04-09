import java.lang.ProcessBuilder.Redirect.Type;

public enum TypeDechets {
    VERRE(50), 
    RECYCL(20), 
    PAPIERS(15), 
    AUTRES(45);

    private double masse; //unite arbitraire

    TypeDechets(double masse) {
        this.masse = masse;
    }

}
