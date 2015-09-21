
/**
 * Write a description of class s here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;

public class Inventario {
    private ArrayList<Item> inventario = new ArrayList<>();
    
    public void adicionarItem(Item item) {
                this.inventario.add(item);
    }
    
    public void perderItem(Item item) {
       this.inventario.remove(item);
    }
    
    public int getQuantidadeDeItens() {
        return this.inventario.size();
    }
    
    public String getDescricao(int i) {
        return this.inventario.get(i).getDescricao();
    }
    
    public String getDescricoesItens() {
        String resultado = "";
        for (int i = 0; i < inventario.size(); i++) {
            resultado +=  inventario.get(i).getDescricao();
            if ((i+1) != inventario.size()) {
                resultado += ",";
            }
        }
        resultado = resultado.equals("") ? "Nenhum item no inventário." : resultado;
        return resultado;
    }
    
    public Item getItem(int i) {
        return inventario.get(i);
    }
    
    public Item getItemComMaiorQuantidade() {
        int maior = -9999, j = -1;
        for (int i = 0; i < inventario.size(); i++) {
            if (inventario.get(i).getQuantidade() > maior) {
                maior = inventario.get(i).getQuantidade();
                j = i;
            }
        }
        return inventario.get(j);
    }
    
    public void ordenarItens() {        
        Item aux;
        for (int i = 0; i < inventario.size(); i++) {
            for (int j = 0; j < inventario.size(); j++) {                
                 if (inventario.get(i).getQuantidade() < inventario.get(j).getQuantidade()) {
                    aux  = inventario.get(j);
                    inventario.set(j, inventario.get(i));
                    inventario.set(i, aux);
                 }                 
            }
        }
    }   
    
    public void aumentar1000CadaItem() {
        for (int i = 0; i < this.getQuantidadeDeItens(); i++) {
            this.getItem(i).add1000Quantidade();
        }
    }
    
    public void aumentarNVezes1000CadaItem() {
        for (int i = 0; i < this.getQuantidadeDeItens(); i++) {
            this.getItem(i).addItensComSorteIrish();
        }
    }
    
}
