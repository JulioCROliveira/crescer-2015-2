
/**
 * Write a description of class PizzaGrande here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;

public class PizzaGrande extends Pizza{
          

   public PizzaGrande(ArrayList<String> sabores, int qtd) {
       super(sabores, qtd);
    }
    
    public void recebeValoresIniciais() {
       valor = 40.00;
       maxSabores = 2; 
    }
    
    public String toString2() {
        String pizzas = this.quantidade == 1 ? "pizza" : "pizzas";
        return String.format("%d %s grande %s R$ %.2f", 
            this.quantidade, pizzas, sabores.toString(), getValorTotal());
    }
}
