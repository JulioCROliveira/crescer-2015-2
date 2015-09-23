
/**
 * Write a description of class Personagem here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Personagem
{
    protected String nome;
    protected int experiencia = 0, vida;
    protected Status status = Status.VIVO;
    protected Inventario inventario = new Inventario();
    
    public Personagem(String nome) {
        this.nome = nome;
    }
    
    public Status getStatus() {
        return this.status;
    }
    
    public Inventario getInventario() {
        return this.inventario;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public int getVida() {
        return this.vida;
    } 
    
    public int getExperiencia() {
        return this.experiencia;
    }
    
    public void receberFlechadaDeOrc() {
        this.vida -= 8;
        verificaVida();
    }
    
    public void receberEspadadaDeOrc() {
        this.vida -= 12;
        verificaVida();
    }
    
    public void verificaVida() {
        if (this.vida <= 0) {
            status = Status.MORTO;
            this.vida = 0;
        }
    }
    
    public void adicionarItem(Item item) {
        int index =possuiItemComMesmaDescricao(item);
        if (index == -1) {
            this.getInventario().adicionarItem(item);
        } else {
            this.getInventario().getItem(index).itemAddQuantidade(item.getQuantidade());
        }
    }
    
    public int possuiItemComMesmaDescricao(Item item) {
        return this.getInventario().jaPossuiItem(item);
    }
    
    public void perderItem(Item item) {
       this.getInventario().perderItem(item);
    }    
    
    public void atacarOrc(OrcUrukHai orc) {
        orc.receberAtaque(this);
    }
}
