
/**
 * Write a description of class PizzaPequena here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;

public class PizzaPequena extends Pizza{
          

   public PizzaPequena(ArrayList<String> sabores, int qtd) {
       super(sabores, qtd);
    }
    
    public void recebeValoresIniciais() {
       valor = 20.00;
       maxSabores = 1; 
    }
    
    public String toString2() {
        String pizzas = this.quantidade == 1 ? "pizza" : "pizzas";
        return String.format("%d %s pequena %s R$ %.2f", 
            this.quantidade, pizzas, sabores.toString(), getValorTotal());
    }
}
