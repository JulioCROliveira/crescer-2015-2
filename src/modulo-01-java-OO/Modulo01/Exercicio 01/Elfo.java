public class Elfo extends Personagem{    
    protected int flechas = 42;
    
    public Elfo(String nome) {
        super(nome);
        this.vida = 80;
    }
    
    public Elfo(String nome, int flech) {
        this(nome);
        flechas = flech;
    }
    
    public String toString() {
        String singF = (this.flechas == 1) ? "flecha" : "flechas";
        String singE = (this.experiencia == 1) ? "nível" : "níveis";
        return String.format("%s possui %d %s e %d %s de experiência.", this.nome, 
            this.flechas, singF, this.experiencia, singE);        
    }
    
    /* public void atirarFlecha() {
        if (this.flechas > 0) {
            this.flechas -= 1;
            this.experiencia += 3;
        } else {
            System.out.println("Sem flechas");
        }
    } */

    
    public String atirarFlecha(Dwarf alvo){
        if (this.flechas > 0) {
            flechas--;
            experiencia++;
            alvo.receberFlechada();
            return "Acertou alvo";            
        } else {
            return "Sem flechas";
        }
    }
   
    public int getFlechas() {
        return this.flechas;
    }
}
