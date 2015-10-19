
/**
 * Write a description of class Pedido here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;

public class Pedido {
    private Cliente cliente;
    private ArrayList<Pizza> pizzas = new ArrayList<>();
    private ArrayList<Refri> refrigerantes = new ArrayList<>();
    private double valorTotal=0, valorFrete=4.50, valorDesconto=0, valorPagamento=0, 
        valorTroco=0, valorAPagar=0;
    private String comprovante="";
    
    public Pedido(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public void pedirPizza(Pizza pizza) {
        pizzas.add(pizza);
        this.valorTotal += pizza.getValorTotal();
    }
    
    public void removerPizza(int i) {
        try {
            this.valorTotal -= pizzas.get(i).getValorTotal();
            pizzas.remove(i);
        } catch (IndexOutOfBoundsException err) {
            //System.out.println("Index invalido");
        }
    }
    
    public void pedirBebida(Refri refri) {
        refrigerantes.add(refri);
        this.valorTotal += refri.getValorTotal();
    }
    
    public void removerBebida(int i) {
        try {
            this.valorTotal -= refrigerantes.get(i).getValorTotal();
            refrigerantes.remove(i);
        } catch (IndexOutOfBoundsException err) {
            //System.out.println("Index invalido");
        }
    }
    
    public double getValorTotal() {
        return this.valorTotal;
    }
    
    public String pizzasToString() {
        String retorna="";
        for (Pizza i : pizzas) {
            retorna += i.toString2()+"\n";
        }
        return retorna;
    }
    
    public String refriToString() {
        String retorna="";
        for (Refri i : refrigerantes) {
            retorna += i.toString()+"\n";
        }
        return retorna;
    }
    
    public void fecharPedido() {
        if (valorTotal >= 60) {
            valorFrete = 0;
        }
        if (valorTotal >= 100) {
            valorDesconto = valorTotal * 0.1;
        }
        valorAPagar = valorTotal + valorFrete - valorDesconto;
    }
    
    public void pagarConta(double pagamento) {
        fecharPedido();
        if (pagamento < valorAPagar) {
            System.out.println("Valor insuficiente");
        } else {
            valorTroco = pagamento - valorAPagar;
        }
    }
    
    public void gerarComprovante(double pagamento) {
        pagarConta(pagamento);
        this.comprovante = cliente.getNome()+"\n"
            + cliente.getEndereco()+"\n"
            + cliente.getTelefone()+"\n";
        this.comprovante += pizzasToString();
        this.comprovante += refriToString();
        this.comprovante += String.format("Valor frete                                R$ %.2f\n",valorFrete);
        this.comprovante += String.format("Desconto                                -  R$ %.2f\n",valorDesconto);
        this.comprovante += "----------------------------------------------------\n";
        this.comprovante += String.format("Valor total                                R$ %.2f\n",valorAPagar);
        this.comprovante += String.format("Valor pago                               - R$ %.2f\n",pagamento);
        this.comprovante += "----------------------------------------------------\n";
        this.comprovante += String.format("Valor troco                                R$ %.2f\n",valorTroco);
    }
    
    public void imprimeComprovante() {
        System.out.println(this.comprovante);
    }
    
    public double getFrete() {
        return this.valorFrete;
    }
    
    public double getDesconto() {
        return this.valorDesconto;
    }
}
