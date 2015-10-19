

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PizzaTitanicTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;

public class PizzaTitanicTest
{
    @Test
    public void cria1PizzaSaborBacon() {
        String esperado = "[Bacon]";
        ArrayList<String> sabores = new ArrayList<>();
        sabores.add("Bacon");
        Pizza pizza = new PizzaTitanic(sabores, 1);
        
        //assertEquals(true, esperado.equals(pizza.toString()));
        assertEquals(esperado, pizza.toString());
        assertEquals(1, pizza.getQuantidade());
    }
    
    @Test
    public void cria2Pizza5Sabores3Diferentes() {
        String esperado = "[2/5 Calabresa, 2/5 Bacon, 1/5 4 Queijos]";
        ArrayList<String> sabores = new ArrayList<>();
        sabores.add("Calabresa");
        sabores.add("Bacon");
        sabores.add("4 Queijos");
        sabores.add("Bacon");
        sabores.add("Calabresa");
        Pizza pizza = new PizzaTitanic(sabores, 2);
        
        //assertEquals(true, esperado.equals(pizza.toString()));
        assertEquals(esperado, pizza.toString());
        assertEquals(2, pizza.getQuantidade());
    }
    
    @Test
    public void cria2Pizza7SaboresIguaisRetorna1() {
        String esperado = "[Calabresa]";
        ArrayList<String> sabores = new ArrayList<>();
        sabores.add("Calabresa");
        sabores.add("Calabresa");
        sabores.add("Calabresa");
        sabores.add("Calabresa");
        sabores.add("Calabresa");
        sabores.add("Calabresa");
        sabores.add("Calabresa");
        Pizza pizza = new PizzaTitanic(sabores, 2);
        
        //assertEquals(true, esperado.equals(pizza.toString()));
        assertEquals(esperado, pizza.toString());
        assertEquals(2, pizza.getQuantidade());
    }
    
    @Test
    public void cria2Pizza7Sabores3IguaisRetorna3() {
        String esperado = "[4/6 Calabresa, 1/6 Galinha, 1/6 Bacon]";
        ArrayList<String> sabores = new ArrayList<>();
        sabores.add("Calabresa");
        sabores.add("Bacon");
        sabores.add("Calabresa");
        sabores.add("Galinha");
        sabores.add("Calabresa");
        sabores.add("Calabresa");
        sabores.add("Calabresa");
        Pizza pizza = new PizzaTitanic(sabores, 2);
        
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
        Pizza pizza = new PizzaTitanic(sabores, 2);
        
        //assertEquals(true, esperado.equals(pizza.toString()));
        assertEquals(esperado, pizza.toString());
        assertEquals(2, pizza.getQuantidade());
    }
    
    @Test
    public void confereValorEMaxDeSabores() {
        ArrayList<String> sabores = new ArrayList<>();
        sabores.add("Bacon");
        Pizza pizza = new PizzaTitanic(sabores, 3);
        
        //assertEquals(true, esperado.equals(pizza.toString()));
        assertEquals(300, pizza.getValorTotal(), 0.00001);
        assertEquals(6, pizza.getMaxSabores());
    }
    
    @Test
    public void toString2PizzaTitanic() {
        String esperado = "1 pizza titanic [Bacon] R$ 100,00";
        ArrayList<String> sabores = new ArrayList<>();
        sabores.add("Bacon");
        Pizza pizza = new PizzaTitanic(sabores, 1);
        
        //assertEquals(true, esperado.equals(pizza.toString()));
        assertEquals(esperado, pizza.toString2());
    }
    
    @Test
    public void toString2PizzasTitanic() {
        String esperado = "2 pizzas titanic [Bacon] R$ 200,00";
        ArrayList<String> sabores = new ArrayList<>();
        sabores.add("Bacon");
        Pizza pizza = new PizzaTitanic(sabores, 2);
        
        //assertEquals(true, esperado.equals(pizza.toString()));
        assertEquals(esperado, pizza.toString2());
    }
}
