public class Dwarf {
    private int vida = 110, experiencia;
    private Status status = Status.VIVO;
    private String nome;   
    
        
    public Dwarf() {
    }

    public Dwarf(String nome) {
        this.nome = nome;
    }
    
    public void receberFlechada() {
        this.vida -= 10;
        if (this.vida <= 0) {this.status = Status.MORTO; }
    }
    
    public int getVida() {
        return this.vida;
    } 
    
    public Status getStatus() {
        return this.status;
    }
    
    public String getNome() {
        return this.nome;
    }
}
