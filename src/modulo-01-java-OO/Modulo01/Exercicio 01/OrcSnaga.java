
/**
 * Write a description of class OrcSnaga here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OrcSnaga extends OrcUrukHai
{    
    public OrcSnaga() {
        adicionaItensIniciais();
        this.vida = 70;
        this.flechas = 5;
    }
    
    public void adicionaItensIniciais() {
        this.inventario.adicionarItem(new Item("Arco", 1));
    }
}
