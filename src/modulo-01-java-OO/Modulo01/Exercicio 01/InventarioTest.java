

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
    
    @Test
    public void ordenandoItensQueJaEstavamOrdenadosCom20Itens() {
        Inventario inventario = new Inventario();
        Item item1 = new Item("poção",7);
        Item item2 = new Item("moedas",4);
        Item item3 = new Item("machado",3);
        Item item4 = new Item("moedas",15);
        Item item5 = new Item("machado",12);
        Item item6 = new Item("poção",14);
        Item item7 = new Item("moedas",13);
        Item item8 = new Item("machado",2);
        Item item9 = new Item("moedas",6);
        Item item10 = new Item("machado",16);
        Item item11 = new Item("poção",5);
        Item item12 = new Item("moedas",20);
        Item item13 = new Item("machado",1);
        Item item14 = new Item("moedas",17);
        Item item15 = new Item("machado",10);
        Item item16 = new Item("poção",19);
        Item item17 = new Item("moedas",8);
        Item item18 = new Item("machado",18);
        Item item19 = new Item("moedas",9);
        Item item20 = new Item("machado",11);
                
        inventario.adicionarItem(item1);
        inventario.adicionarItem(item2);
        inventario.adicionarItem(item3);
        inventario.adicionarItem(item4);
        inventario.adicionarItem(item5);
         inventario.adicionarItem(item6);
        inventario.adicionarItem(item7);
        inventario.adicionarItem(item8);
        inventario.adicionarItem(item9);
        inventario.adicionarItem(item10);
         inventario.adicionarItem(item11);
        inventario.adicionarItem(item12);
        inventario.adicionarItem(item13);
        inventario.adicionarItem(item14);
        inventario.adicionarItem(item15);
         inventario.adicionarItem(item16);
        inventario.adicionarItem(item17);
        inventario.adicionarItem(item18);
        inventario.adicionarItem(item19);
        inventario.adicionarItem(item20);
        
        inventario.ordenarItens();

        assertEquals(true, inventario.getItem(0).equals(item13)); 
        assertEquals(true, inventario.getItem(1).equals(item8)); 
        assertEquals(true, inventario.getItem(2).equals(item3));
        assertEquals(true, inventario.getItem(3).equals(item2)); 
        assertEquals(true, inventario.getItem(4).equals(item11));
        assertEquals(true, inventario.getItem(5).equals(item9)); 
        assertEquals(true, inventario.getItem(6).equals(item1)); 
        assertEquals(true, inventario.getItem(7).equals(item17));
        assertEquals(true, inventario.getItem(8).equals(item19)); 
        assertEquals(true, inventario.getItem(9).equals(item15));
        assertEquals(true, inventario.getItem(10).equals(item20)); 
        assertEquals(true, inventario.getItem(11).equals(item5)); 
        assertEquals(true, inventario.getItem(12).equals(item7));
        assertEquals(true, inventario.getItem(13).equals(item6)); 
        assertEquals(true, inventario.getItem(14).equals(item4));
        assertEquals(true, inventario.getItem(15).equals(item10)); 
        assertEquals(true, inventario.getItem(16).equals(item14)); 
        assertEquals(true, inventario.getItem(17).equals(item18));
        assertEquals(true, inventario.getItem(18).equals(item16)); 
        assertEquals(true, inventario.getItem(19).equals(item12));
    }
}
