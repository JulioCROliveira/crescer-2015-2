
/**
 * Write a description of class OrcSnaga here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OrcSnaga extends Orc
{    
    public OrcSnaga(String nome) {
        super(nome);
        this.inventario.adicionarItem(new Item("Arco", 1));
        this.inventario.adicionarItem(new Item("Flechas", 5));
        this.vida = 70;        
    }
}
