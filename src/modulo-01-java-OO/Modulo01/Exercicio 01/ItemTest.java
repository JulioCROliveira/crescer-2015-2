

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ItemTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ItemTest
{
   @Test
   public void itemSemDescricaoEquantidadeZero() {
       Item item = new Item(null, 0);
       
       assertEquals(null, item.getDescricao());
       assertEquals(0, item.getQuantidade());
    }      
    
    @Test
   public void itemDescricaoEmBrancoEquantidade2Negativo() {
       Item item = new Item("", -2);
       
       assertEquals("", item.getDescricao());
       assertEquals(-2, item.getQuantidade());
    }
    
    @Test
   public void itemDescricaoPocaoEquantidade2() {
       Item item = new Item("Poção", 2);
       
       assertEquals("Poção", item.getDescricao());
       assertEquals(2, item.getQuantidade());
    }
}
