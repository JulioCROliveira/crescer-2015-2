
/**
 * Write a description of class Orc here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Orc extends Personagem
{
    public Orc(String nome) {
        super(nome);
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
    
    public void atacarPersonagem(Orc orc) {
        if (this.status == Status.VIVO && orc.getStatus() != Status.MORTO) {
            int dano = getDano();           
            if (dano == 8) {
                perderUmaFlecha();
            }
            atualizarStatus();                
            orc.receberAtaque(this);                      
        }        
    }
    
    public void receberAtaque(Personagem personagem) {
        if (this.status != Status.MORTO && personagem.getStatus() != Status.MORTO) {
            int danoInimigo = getDanoRecebido();            
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
    
    public void tentarSorte() {
    }
}
