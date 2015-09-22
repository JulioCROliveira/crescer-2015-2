

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
    
    @Test
   public void itemDescricaoPocaoEquantidade2RecebeMais1000() {
       Item item = new Item("Poção", 2);
       item.add1000Quantidade();

       assertEquals(1002, item.getQuantidade());
    }
    
    @Test
   public void itemDescricaoPocaoEquantidade2RecebeMais2000() {
       Item item = new Item("Poção", 2);
       item.add1000Quantidade();
       item.add1000Quantidade();

       assertEquals(2002, item.getQuantidade());
    }
    
    @Test 
    public void equalsComDoisObjetosIguais() {
        Item item = new Item("Poção", 2);
        Item item2 = new Item("Poção", 2);
        
        assertEquals(true, item.equals(item2));
    }
    
    @Test 
    public void equalsComDoisObjetosComQuantidadesDiferentes() {
        Item item = new Item("Poção", 2);
        Item item2 = new Item("Poção", 3);
        
        assertEquals(false, item.equals(item2));
    }
    
    @Test 
    public void equalsComDoisObjetosComQuantidadesDescriçoesDiferentes() {
        Item item = new Item("Poção", 2);
        Item item2 = new Item("Poço", 2);
        
        assertEquals(false, item.equals(item2));
    }
    
    @Test 
    public void equalsComDoisObjetosIguaisComDescricaoNulas() {
        Item item = new Item(null, 2);
        Item item2 = new Item(null, 2);
        
        assertEquals(true, item.equals(item2));
    }
    
    @Test 
    public void metodosPossuiEscudoEspadaArco() {
        Item item = new Item("Escudo Uruk-Hai", 1);
        Item item2 = new Item("Espada", 2);
        Item item3 = new Item("Arco", 2);
        
        assertEquals(true, item.ehEscudoUrukHai());
        assertEquals(true, item2.ehEspada());
        assertEquals(true, item3.ehArco());
        assertEquals(false, item2.ehEscudoUrukHai());
    }
}
