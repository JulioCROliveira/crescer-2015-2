public class Elfo {
    private String nome;
    private int flechas, experiencia = 0;
    private Status status = Status.VIVO;
    
    public Elfo(String n, int flech) {
        nome = n;
        flechas = flech;
    }
    
    public Status getStatus() {
        return this.status;
    }
    
    public String toString() {
        String singF = (this.flechas == 1) ? "flecha" : "flechas";
        String singE = (this.experiencia == 1) ? "nível" : "níveis";
        return String.format("%s possui %d %s e %d %s de experiência.", this.nome, 
            this.flechas, singF, this.experiencia, singE);        
    }
    
    public Elfo(String n) {
        this(n, 42);
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
    
    public String getNome() {
        return this.nome;
    }
    
    public int getExperiencia() {
        return this.experiencia;
    }
}
