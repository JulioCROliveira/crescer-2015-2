

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ElfoVerdeTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ElfoVerdeTest
{
    @Test 
    public void novoElfoVerde () {
        Elfo elfo = new ElfoVerde("Elfo");
        
        assertEquals(true, elfo.getNome().equals("Elfo"));
    }
    
    @Test 
    public void novoElfoVerdeAtiraFlechaEmDwarf () {
        Elfo elfo = new ElfoVerde("Elfo");
        Dwarf dwarf = new Dwarf("Dwarf");
        
        elfo.atirarFlecha(dwarf);
        elfo.atirarFlecha(dwarf);
        
        assertEquals(4, elfo.getExperiencia());
    }
    
    @Test 
    public void novoElfoVerdeRecebeItensValidos () {
        Elfo elfo = new ElfoVerde("Elfo");
        Item item = new Item("Arco e Flecha de Vidro", 1);
        Item item2 = new Item("Espada de aço valiriano", 1);
        
        elfo.adicionarItem(item);
        elfo.adicionarItem(item2);
        
        assertEquals(true, item.equals(elfo.getInventario().getItem(0)));
        assertEquals(true, item2.equals(elfo.getInventario().getItem(1)));
    }
    
    @Test
    public void elfoVerdeTentaAdicionarItenInvalidos() {
        Elfo elfo = new ElfoVerde("Elfo");
        Item item = new Item("Arco", 1);
        Item item2 = new Item("Espada", 1);
        
        elfo.adicionarItem(item);
        elfo.adicionarItem(item2);
        
        assertEquals(0, elfo.getInventario().getQuantidadeDeItens());        
    }
    
    @Test
    public void elfoVerdeTentaAdicionarItenNulos() {
        Elfo elfo = new ElfoVerde("Elfo");
        Item item = new Item("Arco", 1);
        Item item2 = new Item(null, 1);
        
        elfo.adicionarItem(item);
        elfo.adicionarItem(item2);
        
        assertEquals(0, elfo.getInventario().getQuantidadeDeItens());        
    }
}
