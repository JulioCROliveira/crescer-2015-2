public class Dwarf {
    private int vida = 110;
        
    public Dwarf() {
    }


    
    public void receberFlechada() {
        this.vida -= 10;
    }
    
    public int getVida() {
        return this.vida;
    }
}
