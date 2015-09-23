
/**
 * Write a description of class OrcSnaga here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OrcSnaga extends OrcUrukHai
{    
    public OrcSnaga(String nome) {
        super(nome);
        adicionaItensIniciais();
        this.vida = 70;        
    }
    
    public void adicionaItensIniciais() {
        this.inventario.adicionarItem(new Item("Arco", 1));
        this.inventario.adicionarItem(new Item("Flechas", 5));
    }
}
