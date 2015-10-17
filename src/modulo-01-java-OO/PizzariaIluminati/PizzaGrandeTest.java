

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PizzaGrandeTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;

public class PizzaGrandeTest
{
    @Test
    public void cria1PizzaSaborBacon() {
        String esperado = "[Bacon]";
        ArrayList<String> sabores = new ArrayList<>();
        sabores.add("Bacon");
        Pizza pizza = new PizzaGrande(sabores, 1);
        
        //assertEquals(true, esperado.equals(pizza.toString()));
        assertEquals(esperado, pizza.toString());
        assertEquals(1, pizza.getQuantidade());
    }
    
    @Test
    public void cria2Pizza5Sabores3DiferentesRetornaSomenteCalbresaEBacon() {
        String esperado = "[1/2 Bacon, 1/2 Calabresa]";
        ArrayList<String> sabores = new ArrayList<>();
        sabores.add("Calabresa");
        sabores.add("Bacon");
        sabores.add("4 Queijos");
        sabores.add("Bacon");
        sabores.add("Calabresa");
        Pizza pizza = new PizzaGrande(sabores, 2);
        
        //assertEquals(true, esperado.equals(pizza.toString()));
        assertEquals(esperado, pizza.toString());
        assertEquals(2, pizza.getQuantidade());
    }
    
    @Test
    public void cria2Pizza2Sabores() {
        String esperado = "[1/2 Bacon, 1/2 Calabresa]";
        ArrayList<String> sabores = new ArrayList<>();
        sabores.add("Calabresa");
        sabores.add("Bacon");
        Pizza pizza = new PizzaGrande(sabores, 2);
        
        //assertEquals(true, esperado.equals(pizza.toString()));
        assertEquals(esperado, pizza.toString());
        assertEquals(2, pizza.getQuantidade());
    }
    
    @Test
    public void confereValorEMaxDeSabores() {
        ArrayList<String> sabores = new ArrayList<>();
        sabores.add("Bacon");
        Pizza pizza = new PizzaGrande(sabores, 3);
        
        //assertEquals(true, esperado.equals(pizza.toString()));
        assertEquals(120, pizza.getValorTotal(), 0.00001);
        assertEquals(2, pizza.getMaxSabores());
    }
    
    @Test
    public void toString2PizzaGrande() {
        String esperado = "1 pizza grande [Bacon] R$ 40,00";
        ArrayList<String> sabores = new ArrayList<>();
        sabores.add("Bacon");
        Pizza pizza = new PizzaGrande(sabores, 1);
        
        //assertEquals(true, esperado.equals(pizza.toString()));
        assertEquals(esperado, pizza.toString2());
    }
    
    @Test
    public void toString2PizzasGrande() {
        String esperado = "2 pizzas grande [Bacon] R$ 80,00";
        ArrayList<String> sabores = new ArrayList<>();
        sabores.add("Bacon");
        Pizza pizza = new PizzaGrande(sabores, 2);
        
        //assertEquals(true, esperado.equals(pizza.toString()));
        assertEquals(esperado, pizza.toString2());
    }
}
