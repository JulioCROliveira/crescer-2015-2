

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PersonagemTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PersonagemTest
{
    @Test
    public void adicionado3ItensDiferentes() {
        Personagem personagem = new Elfo("AA");
        Item item1 = new Item("poção",3);
        Item item2 = new Item("moedas",10);
        Item item3 = new Item("machado",1);
                
        personagem.getInventario().adicionarItem(item1);
        personagem.getInventario().adicionarItem(item2);
        personagem.getInventario().adicionarItem(item3);
        
        assertEquals(true, personagem.getInventario().getItem(0).equals(item1));
        assertEquals(true, personagem.getInventario().getItem(1).equals(item2));
        assertEquals(true, personagem.getInventario().getItem(2).equals(item3));
    }
}
