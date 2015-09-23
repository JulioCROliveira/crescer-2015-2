
/**
 * Write a description of class Orcs here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OrcUrukHai extends Personagem
{
      
    public OrcUrukHai(String nome) {
        super(nome);
        adicionaItensIniciais();
        this.vida = 150;
    }
    
    public void adicionaItensIniciais() {
        this.inventario.adicionarItem(new Item("Escudo Uruk-Hai", 1));
        this.inventario.adicionarItem(new Item("Espada", 1));
    }
    
    public boolean possuiEscudoUrukHai() {
        return this.inventario.possuiEscudoUrukHai();
    }
    
    public boolean possuiEspada() {
        return this.inventario.possuiEspada();
    }
    
    public boolean possuiArcoEFlechas() {
        return this.inventario.possuiArcoeFlecha();
    }
    
    public void atualizarStatus() {
        if (this.status != Status.MORTO) {
            if ((!possuiArcoEFlechas() || getFlechas() <= 0) && !possuiEspada()) {
                status = Status.FUGINDO;
            }
        }
    }
    
    public void atacarPersonagem(Personagem personagem) {
        if (this.status == Status.VIVO && personagem.getStatus() != Status.MORTO) {
            int dano = getDano();           
            if (dano == 8) {
                personagem.receberFlechadaDeOrc();
                perderUmaFlecha();
                atualizarStatus();
            } else if (dano == 12) {
                personagem.receberEspadadaDeOrc();
            }            
        }        
    }
    
    public void receberAtaque(Personagem personagem) {
        if (this.status == Status.VIVO && personagem.getStatus() != Status.MORTO) {
            int dano = getDano(), danoInimigo = getDanoRecebido();            
            this.vida -= danoInimigo;
            verificaVida();            
        }        
    }
    
    public int getDano() {
        int dano = 0;
        atualizarStatus();
         if (this.status == Status.VIVO) {
            if (possuiEspada()) {
                dano = 12; 
            } else {
                dano = 8;
            }
        }
        return dano;
    }
    
    public int getDanoRecebido() {
        int dano = 10; 
        if (possuiEscudoUrukHai()) {
            dano = 6; 
        }
        return dano;
    }
    
    public int getFlechas() {
        if (this.getInventario().jaPossuiItem(new Item("Flechas",1)) != -1) {
            return this.getInventario().getItem(this.getInventario().jaPossuiItem(new Item("Flechas",1))).getQuantidade();
        } else {
            return 0;
        }
    }
    
    public void perderUmaFlecha() {
        this.getInventario().getItem(this.getInventario().jaPossuiItem(new Item("Flechas",1))).menosUmaFlecha();
    }
}
