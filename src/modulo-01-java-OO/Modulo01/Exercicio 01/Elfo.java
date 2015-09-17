public class Elfo {
    private String nome;
    private Arma armaEquipada = new Arma(3,20,"Punhos");
    private int flechas, experiencia = 0;
    
    public Elfo(String n, int flech) {
        nome = n;
        flechas = flech;
    }
    
    public Elfo(String n) {
        this(n, 42);
    }
    
    public String equiparArma(Arma arma) {
        this.armaEquipada = arma;
        return "\nElfo " + this.nome + " equipou " + arma.nome+"\n";
    }
    
    public Arma armaEquipada() {
        return this.armaEquipada;
    }
    
    /* public void atirarFlecha() {
        if (this.flechas > 0) {
            this.flechas -= 1;
            this.experiencia += 3;
        } else {
            System.out.println("Sem flechas");
        }
    } */

    
    public String atacar(Arma arma, Dwarf alvo){
        if (arma.getUsaFlechas() == true) {
            if (this.flechas > 0) {
                flechas--;
                if(arma.acertar() == true){
                    experiencia++;
                    alvo.addVida(-1*arma.getDano());
                    return "Acertou alvo";
                }else{
                    return "Errou alvo";
                }
            } else {
                return "Sem flechas";
            }
        } else {
            if(arma.acertar() == true){
                    experiencia++;
                    alvo.addVida(-1*arma.getDano());
                    return "Acertou alvo";
                } else {
                    return "Errou alvo";
            }
        }
    }
   
    public int getFlechas() {
        return this.flechas;
    }
}
