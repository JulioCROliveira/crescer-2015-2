

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class InventarioTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class InventarioTest
{
    @Test
    public void adicionado3ItensDiferentes() {
        Inventario inventario = new Inventario();
        Item item1 = new Item("poção",3);
        Item item2 = new Item("moedas",10);
        Item item3 = new Item("machado",1);
                
        inventario.adicionarItem(item1);
        inventario.adicionarItem(item2);
        inventario.adicionarItem(item3);
        
        assertEquals(true, inventario.getItem(0).equals(item1));
        assertEquals(true, inventario.getItem(1).equals(item2));
        assertEquals(true, inventario.getItem(2).equals(item3));
    }
    
    @Test
    public void getDescricaoCom3ItensDiferentes() {
        Inventario inventario = new Inventario();
        Item item1 = new Item("poção",3);
        Item item2 = new Item("moedas",10);
        Item item3 = new Item("machado",1);
                
        inventario.adicionarItem(item1);
        inventario.adicionarItem(item2);
        inventario.adicionarItem(item3);
        
        assertEquals(true, inventario.getItem(0).getDescricao().equals("poção"));
        assertEquals(true, inventario.getItem(1).getDescricao().equals("moedas"));
        assertEquals(true, inventario.getItem(2).getDescricao().equals("machado"));
    }
    
    @Test
    public void getQuantidadeCom3ItensDiferentes() {
        Inventario inventario = new Inventario();
        Item item1 = new Item("poção",3);
        Item item2 = new Item("moedas",10);
        Item item3 = new Item("machado",1);
                
        inventario.adicionarItem(item1);
        inventario.adicionarItem(item2);
        inventario.adicionarItem(item3);
        
        assertEquals(3, inventario.getItem(0).getQuantidade());
        assertEquals(10, inventario.getItem(1).getQuantidade());
        assertEquals(1, inventario.getItem(2).getQuantidade());
    }
    
    @Test
    public void recebendoItemComMaiorQuantidade() {
        Inventario inventario = new Inventario();
        Item item1 = new Item("poção",3);
        Item item2 = new Item("moedas",10);
        Item item3 = new Item("machado",1);
                
        inventario.adicionarItem(item1);
        inventario.adicionarItem(item2);
        inventario.adicionarItem(item3);
        
        assertEquals(true, inventario.getItemComMaiorQuantidade().equals(item2)); 
    }
    
    @Test
    public void negandoAReceberItemSemSerComMaiorQuantidade() {
        Inventario inventario = new Inventario();
        Item item1 = new Item("poção",3);
        Item item2 = new Item("moedas",10);
        Item item3 = new Item("machado",1);
                
        inventario.adicionarItem(item1);
        inventario.adicionarItem(item2);
        inventario.adicionarItem(item3);
        
        assertEquals(false, inventario.getItemComMaiorQuantidade().equals(item1)); 
        assertEquals(false, inventario.getItemComMaiorQuantidade().equals(item3)); 
    }
    
    @Test
    public void removendoUmItem() {
        Inventario inventario = new Inventario();
        Item item1 = new Item("poção",3);
        Item item2 = new Item("moedas",10);
        Item item3 = new Item("machado",1);
                
        inventario.adicionarItem(item1);
        inventario.adicionarItem(item2);
        inventario.adicionarItem(item3);
        
        inventario.perderItem(item2);
        
        assertEquals(true, inventario.getItem(0).equals(item1)); 
        assertEquals(true, inventario.getItem(1).equals(item3)); 
    }
    
    @Test
    public void removendoDoisItens() {
        Inventario inventario = new Inventario();
        Item item1 = new Item("poção",3);
        Item item2 = new Item("moedas",10);
        Item item3 = new Item("machado",1);
                
        inventario.adicionarItem(item1);
        inventario.adicionarItem(item2);
        inventario.adicionarItem(item3);
        
        inventario.perderItem(item2);
        inventario.perderItem(item1);

        assertEquals(true, inventario.getItem(0).equals(item3)); 
    }
    
    @Test
    public void ordenandoItensBagunçados() {
        Inventario inventario = new Inventario();
        Item item1 = new Item("poção",3);
        Item item2 = new Item("moedas",10);
        Item item3 = new Item("machado",1);
        Item item4 = new Item("moedas",7);
        Item item5 = new Item("machado",6);
                
        inventario.adicionarItem(item1);
        inventario.adicionarItem(item2);
        inventario.adicionarItem(item3);
        inventario.adicionarItem(item4);
        inventario.adicionarItem(item5);
        
        inventario.ordenarItens();

        assertEquals(true, inventario.getItem(0).equals(item3)); 
        assertEquals(true, inventario.getItem(1).equals(item1)); 
        assertEquals(true, inventario.getItem(2).equals(item5));
        assertEquals(true, inventario.getItem(3).equals(item4)); 
        assertEquals(true, inventario.getItem(4).equals(item2));
    }
    
    @Test
    public void ordenandoItensQueJaEstavamOrdenadosAoContrario() {
        Inventario inventario = new Inventario();
        Item item1 = new Item("poção",5);
        Item item2 = new Item("moedas",4);
        Item item3 = new Item("machado",3);
        Item item4 = new Item("moedas",2);
        Item item5 = new Item("machado",1);
                
        inventario.adicionarItem(item1);
        inventario.adicionarItem(item2);
        inventario.adicionarItem(item3);
        inventario.adicionarItem(item4);
        inventario.adicionarItem(item5);
        
        inventario.ordenarItens();

        assertEquals(true, inventario.getItem(0).equals(item5)); 
        assertEquals(true, inventario.getItem(1).equals(item4)); 
        assertEquals(true, inventario.getItem(2).equals(item3));
        assertEquals(true, inventario.getItem(3).equals(item2)); 
        assertEquals(true, inventario.getItem(4).equals(item1));
    }
    
    @Test
    public void ordenandoItensQueJaEstavamOrdenados() {
        Inventario inventario = new Inventario();
        Item item1 = new Item("poção",1);
        Item item2 = new Item("moedas",2);
        Item item3 = new Item("machado",3);
        Item item4 = new Item("moedas",4);
        Item item5 = new Item("machado",5);
                
        inventario.adicionarItem(item1);
        inventario.adicionarItem(item2);
        inventario.adicionarItem(item3);
        inventario.adicionarItem(item4);
        inventario.adicionarItem(item5);
        
        inventario.ordenarItens();

        assertEquals(true, inventario.getItem(0).equals(item1)); 
        assertEquals(true, inventario.getItem(1).equals(item2)); 
        assertEquals(true, inventario.getItem(2).equals(item3));
        assertEquals(true, inventario.getItem(3).equals(item4)); 
        assertEquals(true, inventario.getItem(4).equals(item5));
    }
    
}
