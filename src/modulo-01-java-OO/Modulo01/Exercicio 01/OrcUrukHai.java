
/**
 * Write a description of class Orcs here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OrcUrukHai
{
    protected int vida = 150, flechas = 0;
    protected Inventario inventario = new Inventario();
    protected Status status = Status.VIVO;
    
    public OrcUrukHai() {
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
        return this.inventario.possuiArco() && this.flechas > 0;
    }
    
    public void atualizarStatus() {
        if (this.status != Status.MORTO) {
            if (!possuiArcoEFlechas() && !possuiEspada()) {
                status = Status.FUGINDO;
            }
        }
    }
    
    public void atacarElfo(Elfo elfo) {
        if (this.status == Status.VIVO && elfo.getStatus() != Status.MORTO) {
            int dano = getDano(), danoInimigo = 8;
            if (dano > danoInimigo) {
                if (dano == 8) {
                    elfo.receberFlechadaDeOrc();
                    flechas--;
                } else {
                    elfo.receberEspadadaDeOrc();
                }
            }
        }        
    }
    
    public void atacadoPeloElfo(Elfo elfo) {
        if (this.status == Status.VIVO && elfo.getStatus() != Status.MORTO) {
            int dano = getDano(), danoInimigo = 8;
            if (dano < danoInimigo) {
                this.vida -= 8;
                verificaVida();
            }
        }        
    }
    
    public void atacarDwarf(Dwarf dwarf) {
        if (this.status == Status.VIVO && dwarf.getStatus() != Status.MORTO) {
            int dano = getDano(), danoInimigo = getDanoDeDwarfs();
            if (dano > danoInimigo) {
                if (dano == 8) {
                    dwarf.receberFlechadaDeOrc();
                    flechas--;
                } else {
                    dwarf.receberEspadadaDeOrc();
                }
            }
        }        
    }
    
    public void atacadoPeloDwarf(Dwarf dwarf) {
        if (this.status == Status.VIVO && dwarf.getStatus() != Status.MORTO) {
            int dano = getDano(), danoInimigo = getDanoDeDwarfs();
            if (dano < danoInimigo) {
                this.vida -= danoInimigo;
                verificaVida();
            }
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
    
    public int getDanoDeDwarfs() {
        int dano = 10; 
        if (possuiEscudoUrukHai()) {
            dano = 5; 
        }
        return dano;
    }
    
    public void verificaVida() {
        if (this.vida <= 0) {
            status = Status.MORTO;
            this.vida = 0;
        }
    }
}
