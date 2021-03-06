
/**
 * Write a description of class Item here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Item
{
    private String descricao;
    private int quantidade;
    
    public Item(String nome, int n) {
        this.descricao = nome;
        this.quantidade = n;
    }
    
    public String getDescricao() {
        return this.descricao;
    }
    
    public int getQuantidade() {
        return this.quantidade;
    }
    
    public void add1000Quantidade() {
        this.quantidade += 1000;
    }
    
    public boolean equals(Object obj) {
        Item outroObj = (Item)obj;
        if (this.descricao == null || outroObj.getDescricao() == null) {
            return this.quantidade == outroObj.getQuantidade() &&
                this.descricao == outroObj.getDescricao();
        } else {
            return this.quantidade == outroObj.getQuantidade() &&
                this.descricao.equals(outroObj.getDescricao());
            }
    }
    
    public void addItensComSorteIrish() {
        int n = this.quantidade;
        n = n * (n+1)/2;
        this.quantidade += n * 1000;
    }
    
    public boolean ehEscudoUrukHai() {
        return this.descricao.equals("Escudo Uruk-Hai");
    }
    
    public boolean ehEspada() {
        return this.descricao.equals("Espada");
    }
    
    public boolean ehArco() {
        return this.descricao.equals("Arco");        
    }
    
    public boolean ehFlecha() {
        return this.descricao.equals("Flecha") && this.quantidade > 0;        
    }
    
    public void itemAddQuantidade(int n) {
        this.quantidade += n;
    }
    
    public void menosUmaFlecha() {
        this.quantidade -= 1;
    }
    
    /*
     * Exercicio correção
    public void shimbalaie() {
        int pa = this.quantidade * (this.quantidade +1) / 2;
        this.quantidade += 1000 * pa;
    } */

}
