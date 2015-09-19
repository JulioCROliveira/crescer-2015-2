
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
}
