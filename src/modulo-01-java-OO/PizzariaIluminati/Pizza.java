
/**
 * Abstract class Pizza - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
import java.util.ArrayList;

public abstract class Pizza extends Produto
{
    protected int maxSabores;
    protected ArrayList<String> sabores = new ArrayList<>();
    
    public Pizza(ArrayList<String> sabores, int qtd) {
        int sequencia=1, nSabores, count;
        String sabor;
        recebeValoresIniciais();        
        try {
            if (sabores.size() > 1) {
                if (sabores.size() > maxSabores) {
                    for (int i = (sabores.size() - 1); i > (maxSabores-1); i--) {
                        sabores.remove(i);
                    }
                }
                nSabores=sabores.size();
                while (sequencia <= sabores.size()) {
                    sabor = sabores.get(sabores.size()-sequencia);
                    count = 0;
                    for (int i = sabores.size()-sequencia; i > -1; i--) {
                        if (sabor.equals(sabores.get(i))) {
                            count++;
                            sabores.remove(i);
                        }
                    }
                    if (count == nSabores) {
                        sabores.add(sabor);
                    } else {
                        sabores.add(count+"/"+nSabores+" "+sabor);
                    }
                    sequencia++;
                }
            } else {
                if (sabores.get(0).equals("")) { } //força erros se houver
            }
            this.sabores = sabores;
            quantidade = qtd;
        } catch (NullPointerException err) {
            if (sabores == null) {
                this.sabores.add("Falha no pedido, sabor não informado");
            } else {
                this.sabores.add("Falha no pedido");
            }
        } catch (IndexOutOfBoundsException err2) {            
            if (sabores.size() == 0) {
                this.sabores.add("Falha no pedido, sabor não informado");
            } else {
                this.sabores.add("Falha no pedido, se o problema persistir contate o suporte técnico");
            }
        }
    }
    
    public String toString() {
        return sabores.toString();
    }
    
    abstract public String toString2();
    
    public int getMaxSabores() {
        return this.maxSabores;
    }
    
    abstract void recebeValoresIniciais();
}
