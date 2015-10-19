
/**
 * Abstract class Produto - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Produto
{
    protected double valor;
    protected int quantidade;
    
     public int getQuantidade() {
        return this.quantidade;
    }
    
    public double getValorTotal() {
        return this.valor * this.quantidade;
    }
    
    abstract void recebeValoresIniciais();
}
