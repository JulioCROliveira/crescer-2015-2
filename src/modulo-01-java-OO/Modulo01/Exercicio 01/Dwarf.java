public class Dwarf {
    private String nome; 
    Arma armaEquipada = new Arma(3,20,"Punhos");
    private int vida = 110, experiencia = 0;
        
    public Dwarf() {
    }
    
    public String equiparArma(Arma arma) {
        this.armaEquipada = arma;
        return "\nDwarve " + this.nome + " equipou " + arma.nome+"\n";
    }
    
    public Arma armaEquipada() {
        return this.armaEquipada;
    }
    
    
    public String atacar(Arma arma){        
        if(arma.acertar() == true){
                experiencia++;
                return "Acertou alvo";
            } else {
                return "Errou alvo";        
        }
    }
    
    public void addVida(int dano) {
        this.vida = this.vida + dano;
    }
    
    public int getVida() {
        return this.vida;
    }
}
