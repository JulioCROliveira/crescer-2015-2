public class Dwarf {
    private String nome; 
    Armas armaEquipada = new Armas(3,20,"Punhos");
    private int vida = 115, experiencia = 0;
        
    public Dwarf() {
    }
    
    public String equiparArma(Armas arma) {
        this.armaEquipada = arma;
        return "\nDwarve " + this.nome + " equipou " + arma.nome+"\n";
    }
    
    public Armas armaEquipada() {
        return this.armaEquipada;
    }
    
    
    public String atacar(Armas arma){        
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
