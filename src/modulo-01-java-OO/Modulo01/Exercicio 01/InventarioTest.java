

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
    public void getDescricaoCom3ItensDiferentes() {
        Personagem personagem = new Personagem("AA");
        Item item1 = new Item("poção",3);
        Item item2 = new Item("moedas",10);
        Item item3 = new Item("machado",1);
                
        personagem.adicionarItem(item1);
        personagem.adicionarItem(item2);
        personagem.adicionarItem(item3);
        
        assertEquals(true, personagem.getInventario().getItem(0).getDescricao().equals("poção"));
        assertEquals(true, personagem.getInventario().getItem(1).getDescricao().equals("moedas"));
        assertEquals(true, personagem.getInventario().getItem(2).getDescricao().equals("machado"));
    }
    
    @Test
    public void getQuantidadeCom3ItensDiferentes() {
        Personagem personagem = new Personagem("AA");
        Item item1 = new Item("poção",3);
        Item item2 = new Item("moedas",10);
        Item item3 = new Item("machado",1);
                
        personagem.adicionarItem(item1);
        personagem.adicionarItem(item2);
        personagem.adicionarItem(item3);
        
        assertEquals(3, personagem.getInventario().getItem(0).getQuantidade());
        assertEquals(10, personagem.getInventario().getItem(1).getQuantidade());
        assertEquals(1, personagem.getInventario().getItem(2).getQuantidade());
    }
    
    @Test
    public void recebendoItemComMaiorQuantidade() {
        Personagem personagem = new Personagem("AA");
        Item item1 = new Item("poção",3);
        Item item2 = new Item("moedas",10);
        Item item3 = new Item("machado",1);
                
        personagem.adicionarItem(item1);
        personagem.adicionarItem(item2);
        personagem.adicionarItem(item3);
        
        assertEquals(true, personagem.getInventario().getItemComMaiorQuantidade().equals(item2)); 
    }
    
    @Test
    public void negandoAReceberItemSemSerComMaiorQuantidade() {
        Personagem personagem = new Personagem("AA");
        Item item1 = new Item("poção",3);
        Item item2 = new Item("moedas",10);
        Item item3 = new Item("machado",1);
                
        personagem.adicionarItem(item1);
        personagem.adicionarItem(item2);
        personagem.adicionarItem(item3);
        
        assertEquals(false, personagem.getInventario().getItemComMaiorQuantidade().equals(item1)); 
        assertEquals(false, personagem.getInventario().getItemComMaiorQuantidade().equals(item3)); 
    }
    
    @Test
    public void removendoUmItem() {
        Personagem personagem = new Personagem("AA");
        Item item1 = new Item("poção",3);
        Item item2 = new Item("moedas",10);
        Item item3 = new Item("machado",1);
                
        personagem.adicionarItem(item1);
        personagem.adicionarItem(item2);
        personagem.adicionarItem(item3);
        
        personagem.perderItem(item2);
        
        assertEquals(true, personagem.getInventario().getItem(0).equals(item1)); 
        assertEquals(true, personagem.getInventario().getItem(1).equals(item3)); 
    }
    
    @Test
    public void removendoDoisItens() {
        Personagem personagem = new Personagem("AA");
        Item item1 = new Item("poção",3);
        Item item2 = new Item("moedas",10);
        Item item3 = new Item("machado",1);
                
        personagem.adicionarItem(item1);
        personagem.adicionarItem(item2);
        personagem.adicionarItem(item3);
        
        personagem.perderItem(item2);
        personagem.perderItem(item1);

        assertEquals(true, personagem.getInventario().getItem(0).equals(item3)); 
    }
    
    @Test
    public void ordenandoItensBagunçados() {
        Personagem personagem = new Personagem("AA");
        Item item1 = new Item("a",3);
        Item item2 = new Item("b",10);
        Item item3 = new Item("c",1);
        Item item4 = new Item("d",7);
        Item item5 = new Item("e",6);
                
        personagem.adicionarItem(item1);
        personagem.adicionarItem(item2);
        personagem.adicionarItem(item3);
        personagem.adicionarItem(item4);
        personagem.adicionarItem(item5);
        
        personagem.getInventario().ordenarItens();

        assertEquals(true, personagem.getInventario().getItem(0).equals(item3)); 
        assertEquals(true, personagem.getInventario().getItem(1).equals(item1)); 
        assertEquals(true, personagem.getInventario().getItem(2).equals(item5));
        assertEquals(true, personagem.getInventario().getItem(3).equals(item4)); 
        assertEquals(true, personagem.getInventario().getItem(4).equals(item2));
    }
    
    @Test
    public void ordenandoItensQueJaEstavamOrdenadosAoContrario() {
        Personagem personagem = new Personagem("AA");
        Item item1 = new Item("pocção",5);
        Item item2 = new Item("moevdas",4);
        Item item3 = new Item("macbhado",3);
        Item item4 = new Item("moendas",2);
        Item item5 = new Item("macmhado",1);
                
        personagem.adicionarItem(item1);
        personagem.adicionarItem(item2);
        personagem.adicionarItem(item3);
        personagem.adicionarItem(item4);
        personagem.adicionarItem(item5);
        
        personagem.getInventario().ordenarItens();

        assertEquals(true, personagem.getInventario().getItem(0).equals(item5)); 
        assertEquals(true, personagem.getInventario().getItem(1).equals(item4)); 
        assertEquals(true, personagem.getInventario().getItem(2).equals(item3));
        assertEquals(true, personagem.getInventario().getItem(3).equals(item2)); 
        assertEquals(true, personagem.getInventario().getItem(4).equals(item1));
    }
    
    @Test
    public void ordenandoItensQueJaEstavamOrdenados() {
        Personagem personagem = new Personagem("AA");
        Item item1 = new Item("poçaão",1);
        Item item2 = new Item("moedsas",2);
        Item item3 = new Item("macdhado",3);
        Item item4 = new Item("moefdas",4);
        Item item5 = new Item("macghado",5);
                
        personagem.adicionarItem(item1);
        personagem.adicionarItem(item2);
        personagem.adicionarItem(item3);
        personagem.adicionarItem(item4);
        personagem.adicionarItem(item5);
        
        personagem.getInventario().ordenarItens();

        assertEquals(true, personagem.getInventario().getItem(0).equals(item1)); 
        assertEquals(true, personagem.getInventario().getItem(1).equals(item2)); 
        assertEquals(true, personagem.getInventario().getItem(2).equals(item3));
        assertEquals(true, personagem.getInventario().getItem(3).equals(item4)); 
        assertEquals(true, personagem.getInventario().getItem(4).equals(item5));
    }
    
    @Test
    public void ordenandoItensQueJaEstavamOrdenadosCom20Itens() {
        Personagem personagem = new Personagem("AA");
        Item item1 = new Item("poação",7);
        Item item2 = new Item("mosedas",4);
        Item item3 = new Item("madchado",3);
        Item item4 = new Item("moefdas",15);
        Item item5 = new Item("macghado",12);
        Item item6 = new Item("poçhão",14);
        Item item7 = new Item("moejdas",13);
        Item item8 = new Item("machkado",2);
        Item item9 = new Item("moeldas",6);
        Item item10 = new Item("macçhado",16);
        Item item11 = new Item("poçxão",5);
        Item item12 = new Item("moevdas",20);
        Item item13 = new Item("macchado",1);
        Item item14 = new Item("moebdas",17);
        Item item15 = new Item("macnhado",10);
        Item item16 = new Item("poçmão",19);
        Item item17 = new Item("moe,das",8);
        Item item18 = new Item("mach.ado",18);
        Item item19 = new Item("moeduas",9);
        Item item20 = new Item("macthado",11);
                
        personagem.adicionarItem(item1);
        personagem.adicionarItem(item2);
        personagem.adicionarItem(item3);
        personagem.adicionarItem(item4);
        personagem.adicionarItem(item5);
        personagem.adicionarItem(item6);
        personagem.adicionarItem(item7);
        personagem.adicionarItem(item8);
        personagem.adicionarItem(item9);
        personagem.adicionarItem(item10);
        personagem.adicionarItem(item11);
        personagem.adicionarItem(item12);
        personagem.adicionarItem(item13);
        personagem.adicionarItem(item14);
        personagem.adicionarItem(item15);
        personagem.adicionarItem(item16);
        personagem.adicionarItem(item17);
        personagem.adicionarItem(item18);
        personagem.adicionarItem(item19);
        personagem.adicionarItem(item20);
        
        personagem.getInventario().ordenarItens();

        assertEquals(true, personagem.getInventario().getItem(0).equals(item13)); 
        assertEquals(true, personagem.getInventario().getItem(1).equals(item8)); 
        assertEquals(true, personagem.getInventario().getItem(2).equals(item3));
        assertEquals(true, personagem.getInventario().getItem(3).equals(item2)); 
        assertEquals(true, personagem.getInventario().getItem(4).equals(item11));
        assertEquals(true, personagem.getInventario().getItem(5).equals(item9)); 
        assertEquals(true, personagem.getInventario().getItem(6).equals(item1)); 
        assertEquals(true, personagem.getInventario().getItem(7).equals(item17));
        assertEquals(true, personagem.getInventario().getItem(8).equals(item19)); 
        assertEquals(true, personagem.getInventario().getItem(9).equals(item15));
        assertEquals(true, personagem.getInventario().getItem(10).equals(item20)); 
        assertEquals(true, personagem.getInventario().getItem(11).equals(item5)); 
        assertEquals(true, personagem.getInventario().getItem(12).equals(item7));
        assertEquals(true, personagem.getInventario().getItem(13).equals(item6)); 
        assertEquals(true, personagem.getInventario().getItem(14).equals(item4));
        assertEquals(true, personagem.getInventario().getItem(15).equals(item10)); 
        assertEquals(true, personagem.getInventario().getItem(16).equals(item14)); 
        assertEquals(true, personagem.getInventario().getItem(17).equals(item18));
        assertEquals(true, personagem.getInventario().getItem(18).equals(item16)); 
        assertEquals(true, personagem.getInventario().getItem(19).equals(item12));
    }
    
    @Test
    public void metodoPossuiEspada() {
        Personagem personagem = new Personagem("AA");
        Item item = new Item("Escudo Uruk-Hai", 1);
        Item item2 = new Item("Espada", 2);
        Item item3 = new Item("Arco", 2);
        personagem.adicionarItem(item);
        personagem.adicionarItem(item2);
        personagem.adicionarItem(item3);
        
        assertEquals(true, personagem.getInventario().possuiEspada());
    }
    
    @Test
    public void metodoPossuiEspadaFalso() {
        Personagem personagem = new Personagem("AA");
        Item item = new Item("Escudo Uruk-Hai", 1);
        Item item2 = new Item("Espada", 2);
        Item item3 = new Item("Arco", 2);
        personagem.adicionarItem(item);
        personagem.adicionarItem(item3);
        
        assertEquals(false, personagem.getInventario().possuiEspada());
    }
    
    @Test
    public void metodoPossuiEscudo() {
        Personagem personagem = new Personagem("AA");
        Item item = new Item("Escudo Uruk-Hai", 1);
        Item item2 = new Item("Espada", 2);
        Item item3 = new Item("Arco", 2);
        personagem.adicionarItem(item);
        personagem.adicionarItem(item2);
        personagem.adicionarItem(item3);
        
        assertEquals(true, personagem.getInventario().possuiEscudoUrukHai());
    }
    
    @Test
    public void metodoPossuiEscudoFalso() {
        Personagem personagem = new Personagem("AA");
        Item item = new Item("Escudo Uruk-Hai", 1);
        Item item2 = new Item("Espada", 2);
        Item item3 = new Item("Arco", 2);
        personagem.adicionarItem(item2);
        personagem.adicionarItem(item3);
        
        assertEquals(false, personagem.getInventario().possuiEscudoUrukHai());
    }
    
    @Test
    public void metodoPossuiArco() {
        Personagem personagem = new Personagem("AA");
        Item item = new Item("Escudo Uruk-Hai", 1);
        Item item2 = new Item("Flechas", 2);
        Item item3 = new Item("Arco", 2);
        personagem.adicionarItem(item);
        personagem.adicionarItem(item2);
        personagem.adicionarItem(item3);
        
        assertEquals(true, personagem.getInventario().possuiArcoeFlecha());
    }
    
    @Test
    public void metodoPossuiArcoFalso() {
        Personagem personagem = new Personagem("AA");
        Item item = new Item("Escudo Uruk-Hai", 1);
        Item item2 = new Item("Espada", 2);
        Item item3 = new Item("Arco", 2);
        personagem.adicionarItem(item);
        personagem.adicionarItem(item2);
        
        assertEquals(false, personagem.getInventario().possuiArcoeFlecha());
    }
    
    @Test
    public void metodoJaPossuiItem() {
        Personagem personagem = new Personagem("AA");
        Item item = new Item("Escudo Uruk-Hai", 1);
        Item item2 = new Item("Espada", 2);        
        personagem.adicionarItem(item);
        personagem.adicionarItem(item2);
        
        assertEquals(false, personagem.getInventario().jaPossuiItem(item2) == -1);
    }
    
    @Test
    public void metodoJaPossuiItemFalso() {
        Personagem personagem = new Personagem("AA");
        Item item = new Item("Escudo Uruk-Hai", 1);
        Item item2 = new Item("Espada", 2);        
        personagem.adicionarItem(item);        
        
        assertEquals(-1, personagem.getInventario().jaPossuiItem(item2));
    }
}
