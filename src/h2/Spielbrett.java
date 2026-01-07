package h2;

public class Spielbrett {
    private Feld [][] brett;
    private int dim ;
    //objekt attribute konstruktor
    public Spielbrett (Feld[][] brett, int dim){
        this.brett = brett;
        this.dim = dim;
    }
    public Spielbrett(int dim){
        this.dim = dim;
        brett = new Feld[dim][dim];
    }
    //Spielbrett hat Getter und Setter fuer Brett und dim
    public void setBrett(Feld[][] brett){
        this.brett = brett;
    }
    public Feld[][] getBrett(){
        return brett;
    }
    public void setDim(int dim){
        this.dim = dim;
    }
    public int getDim(){
        return dim;
    }
}
