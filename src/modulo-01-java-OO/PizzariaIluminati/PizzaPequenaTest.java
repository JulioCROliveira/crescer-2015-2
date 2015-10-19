

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PizzaPequenaTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;

public class PizzaPequenaTest
{
    
    @Test
    public void cria1PizzaSaborBacon() {
        String esperado = "[Bacon]";
        ArrayList<String> sabores = new ArrayList<>();
        sabores.add("Bacon");
        Pizza pizza = new PizzaPequena(sabores, 1);
        
        //assertEquals(true, esperado.equals(pizza.toString()));
        assertEquals(esperado, pizza.toString());
        assertEquals(1, pizza.getQuantidade());
    }
    
    @Test
    public void cria2Pizza5Sabores3DiferentesRetornaSomenteCalbresa() {
        String esperado = "[Calabresa]";
        ArrayList<String> sabores = new ArrayList<>();
        sabores.add("Calabresa");
        sabores.add("Calabresa");
        sabores.add("4 Queijos");
        sabores.add("Bacon");
        sabores.add("Calabresa");
        Pizza pizza = new PizzaPequena(sabores, 2);
        
        //assertEquals(true, esperado.equals(pizza.toString()));
        assertEquals(esperado, pizza.toString());
        assertEquals(2, pizza.getQuantidade());
    }
    
    @Test
    public void confereValorEMaxDeSabores() {
        ArrayList<String> sabores = new ArrayList<>();
        sabores.add("Bacon");
        Pizza pizza = new PizzaPequena(sabores, 3);
        
        //assertEquals(true, esperado.equals(pizza.toString()));
        assertEquals(60, pizza.getValorTotal(), 0.00001);
        assertEquals(1, pizza.getMaxSabores());
    }
    
    @Test
    public void criaPizzaComSaborNull() {
        ArrayList<String> sabores = new ArrayList<>();
        sabores.add(null);
        Pizza pizza = new PizzaPequena(sabores, 3);
        
        //assertEquals(true, esperado.equals(pizza.toString()));
        assertEquals(0, pizza.getValorTotal(), 0.00001);
        assertEquals("[Falha no pedido]", pizza.toString());
        assertEquals(0, pizza.getQuantidade());
    }
    
    @Test
    public void criaPizzaCom2SaboresNull() {
        ArrayList<String> sabores = new ArrayList<>();
        sabores.add(null);
        Pizza pizza = new PizzaPequena(sabores, 3);
        
        //assertEquals(true, esperado.equals(pizza.toString()));
        assertEquals(0, pizza.getValorTotal(), 0.00001);
        assertEquals("[Falha no pedido]", pizza.toString());
        assertEquals(0, pizza.getQuantidade());
    }
    
    @Test
    public void criaPizzaSemSabores() {
        ArrayList<String> sabores = new ArrayList<>();
        Pizza pizza = new PizzaPequena(sabores, 3);
        
        //assertEquals(true, esperado.equals(pizza.toString()));
        assertEquals(0, pizza.getValorTotal(), 0.00001);
        assertEquals("[Falha no pedido, sabor não informado]", pizza.toString());
        assertEquals(0, pizza.getQuantidade());
    }
    
    @Test
    public void criaPizzaSemArrayListSabores() {
        Pizza pizza = new PizzaPequena(null, 3);
        
        //assertEquals(true, esperado.equals(pizza.toString()));
        assertEquals(0, pizza.getValorTotal(), 0.00001);
        assertEquals("[Falha no pedido, sabor não informado]", pizza.toString());
        assertEquals(0, pizza.getQuantidade());
    }
    
    @Test
    public void toString2PizzaPequena() {
        String esperado = "1 pizza pequena [Bacon] R$ 20,00";
        ArrayList<String> sabores = new ArrayList<>();
        sabores.add("Bacon");
        Pizza pizza = new PizzaPequena(sabores, 1);
        
        //assertEquals(true, esperado.equals(pizza.toString()));
        assertEquals(esperado, pizza.toString2());
    }
    
    @Test
    public void toString2PizzasPequena() {
        String esperado = "2 pizzas pequena [Bacon] R$ 40,00";
        ArrayList<String> sabores = new ArrayList<>();
        sabores.add("Bacon");
        Pizza pizza = new PizzaPequena(sabores, 2);
        
        //assertEquals(true, esperado.equals(pizza.toString()));
        assertEquals(esperado, pizza.toString2());
    }
}
