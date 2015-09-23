
/**
 * Write a description of class Orcs here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OrcUrukHai extends Orc
{
      
    public OrcUrukHai(String nome) {
        super(nome);
        this.inventario.adicionarItem(new Item("Escudo Uruk-Hai", 1));
        this.inventario.adicionarItem(new Item("Espada", 1));
        this.vida = 150;
    }
}
