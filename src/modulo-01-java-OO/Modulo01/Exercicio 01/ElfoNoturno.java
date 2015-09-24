
/**
 * Write a description of class ElfoNoturno here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ElfoNoturno extends Elfo
{
    public ElfoNoturno(String nome) {
        super(nome);
    }
    
    public ElfoNoturno(String nome, int flechas) {
        super(nome, flechas);
    }
    
    public String atirarFlecha(Dwarf alvo){
        if (this.flechas > 0) {
            experiencia += 2;
            this.vida = ((int)(this.vida * 0.95));
        }
        super.verificaVida(); //
        return super.atirarFlecha(alvo);  
    }
    
    public int hashCode() {
        return this.nome.hashCode() + "ElfoNoturno".hashCode();
    }
}
