

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PedidoTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;

public class PedidoTest 
{
   
   @Test
   public void novoPedidoPedePizzaAumentaValor() {
       Pedido pedido = new Pedido(new Cliente("A","A","A"));
       ArrayList<String> sabor = new ArrayList<>();
       sabor.add("Bacon");
       pedido.pedirPizza(new PizzaGrande(sabor, 2));
       
       assertEquals(80, pedido.getValorTotal(), 0.000001);
   }
    
   @Test
   public void Pede2PizzaAumentaValor() {
       Pedido pedido = new Pedido(new Cliente("A","A","A"));
       ArrayList<String> sabor = new ArrayList<>();
       sabor.add("Bacon");
       pedido.pedirPizza(new PizzaGrande(sabor, 2));
       pedido.pedirPizza(new PizzaGrande(sabor, 1));
       
       assertEquals(120, pedido.getValorTotal(), 0.000001);
   }
   
   @Test
   public void Pede3PizzaAumentaValorRemove1Diminui() {
       Pedido pedido = new Pedido(new Cliente("A","A","A"));
       ArrayList<String> sabor = new ArrayList<>();
       sabor.add("Bacon");
       pedido.pedirPizza(new PizzaGrande(sabor, 2));
       pedido.pedirPizza(new PizzaGrande(sabor, 1));
       pedido.removerPizza(0);
       
       assertEquals(40, pedido.getValorTotal(), 0.000001);
       assertEquals("1 pizza grande [Bacon] R$ 40,00\n", pedido.pizzasToString());
   }
   
   @Test
   public void Pede3PizzaAumentaValorRemove1Diminui2() {
       Pedido pedido = new Pedido(new Cliente("A","A","A"));
       ArrayList<String> sabor = new ArrayList<>();
       sabor.add("Bacon");
       pedido.pedirPizza(new PizzaGrande(sabor, 2));
       pedido.pedirPizza(new PizzaGrande(sabor, 1));
       pedido.removerPizza(2);
       
       assertEquals(120, pedido.getValorTotal(), 0.000001);
   }
   
   @Test
   public void novoPedidoPedeRefriAumentaValor() {
       Pedido pedido = new Pedido(new Cliente("A","A","A"));
       pedido.pedirBebida(new RefriLata(Refrigerante.PEPSI, 1));
       
       assertEquals(3.50, pedido.getValorTotal(), 0.000001);
   }
    
   @Test
   public void Pede2RefriAumentaValor() {
       Pedido pedido = new Pedido(new Cliente("A","A","A"));
       pedido.pedirBebida(new RefriLata(Refrigerante.PEPSI, 1));
       pedido.pedirBebida(new RefriLata(Refrigerante.PEPSI, 2));
       
       assertEquals(10.50, pedido.getValorTotal(), 0.000001);
       assertEquals("1 lata de refrigerante Pepsi R$ 3,50\n2 latas de refrigerante Pepsi R$ 7,00\n", pedido.refriToString());
   }
   
   @Test
   public void Pede3RefriAumentaValorRemove1Diminui() {
       Pedido pedido = new Pedido(new Cliente("A","A","A"));
       pedido.pedirBebida(new RefriLata(Refrigerante.PEPSI, 1));
       pedido.pedirBebida(new RefriLata(Refrigerante.PEPSI, 2));
       pedido.removerBebida(1);
       
       assertEquals(3.5, pedido.getValorTotal(), 0.000001);
       assertEquals("1 lata de refrigerante Pepsi R$ 3,50\n", pedido.refriToString());
   }
   
   @Test
   public void comprovanteSemDesconto() {
       Pedido pedido = new Pedido(new Cliente("Júlio","Rua Ruazinha","9742 4561"));
       pedido.pedirBebida(new RefriLata(Refrigerante.PEPSI, 2));
       ArrayList<String> sabor = new ArrayList<>();
       sabor.add("Bacon");
       sabor.add("Filé");
       pedido.pedirPizza(new PizzaGrande(sabor, 1));
       
       pedido.gerarComprovante(100.00);
       pedido.imprimeComprovante();
       
       assertEquals(4.50, pedido.getFrete(), 0.00001);
       assertEquals(0, pedido.getDesconto(), 0.00001);
   }
   
   @Test
   public void comprovanteDescontoDeFrete() {
       Pedido pedido = new Pedido(new Cliente("Júlio","Rua Ruazinha","9742 4561"));
       pedido.pedirBebida(new RefriLata(Refrigerante.ANTARTICA, 2));
       pedido.pedirBebida(new Refri2Litros(Refrigerante.COCACOLA, 2));
       ArrayList<String> sabor = new ArrayList<>();
       sabor.add("Bacon");
       sabor.add("Filé");
       pedido.pedirPizza(new PizzaGrande(sabor, 1));
       
       pedido.gerarComprovante(100.00);
       pedido.imprimeComprovante();
       
       assertEquals(0, pedido.getFrete(), 0.00001);
       assertEquals(0, pedido.getDesconto(), 0.00001);
   }
   
   @Test
   public void comprovanteDescontoDeFreteE10Porcento() {
       Pedido pedido = new Pedido(new Cliente("Júlio","Rua Ruazinha","9742 4561"));
       pedido.pedirBebida(new RefriLata(Refrigerante.PEPSI, 5));
       pedido.pedirBebida(new Refri2Litros(Refrigerante.COCACOLA, 3));
       ArrayList<String> sabor = new ArrayList<>();
       sabor.add("Bacon");
       sabor.add("Filé");
       pedido.pedirPizza(new PizzaTitanic(sabor, 1));
       
       
       pedido.gerarComprovante(150.00);
       pedido.imprimeComprovante();
       
       assertEquals(0, pedido.getFrete(), 0.00001);
       assertEquals(13.85, pedido.getDesconto(), 0.00001);
   }
}
