
/**
 * Write a description of class PizzaTitanic here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;

public class PizzaTitanic extends Pizza{
          

   public PizzaTitanic(ArrayList<String> sabores, int qtd) {
       super(sabores, qtd);
    }
    
    public void recebeValoresIniciais() {
       valor = 100.00;
       maxSabores = 6; 
    }
    
    public String toString2() {
        String pizzas = this.quantidade == 1 ? "pizza" : "pizzas";
        return String.format("%d %s titanic %s R$ %.2f", 
            this.quantidade, pizzas, sabores.toString(), getValorTotal());
    }
}

