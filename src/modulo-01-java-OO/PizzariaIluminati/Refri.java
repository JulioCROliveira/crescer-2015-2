
/**
 * Abstract class Refri - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Refri extends Produto {
    protected Refrigerante marca;
    
    public Refri(Refrigerante marca, int qtd) {
        if (marca != null) {
            recebeValoresIniciais();
            this.marca = marca;
            quantidade = qtd;
        }
    }
    
    public Refrigerante getMarca() {
        return marca;
    }
    
    abstract public String toString();
    
    abstract void recebeValoresIniciais();
}
