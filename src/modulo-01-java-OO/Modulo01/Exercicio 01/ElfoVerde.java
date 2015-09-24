
/**
 * Write a description of class ElfoVerde here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ElfoVerde extends Elfo
{
    public ElfoVerde(String nome) {
        super(nome);
        this.vida = 80;
    }
    
    public ElfoVerde(String nome, int flechas) {
        super(nome, flechas);        
    }
    
    public String atirarFlecha(Dwarf alvo){
        if (this.flechas > 0) {
            flechas--;
            experiencia += 2;
            alvo.receberFlechada();
            return "Acertou alvo";            
        } else {
            return "Sem flechas";
        }
   }
    
    public void adicionarItem(Item item) {
        boolean itensValidos;
        String descricao = item.getDescricao();
        if (descricao != null) {
            itensValidos = descricao.equals("Espada de aço valiriano") ||
                descricao.equals("Arco e Flecha de Vidro");
            if (itensValidos)  {
                super.getInventario().adicionarItem(item);
            }
        }
    }
    
    public int hashCode() {
        return this.nome.hashCode() + "ElfoVerde".hashCode();
    }
}
