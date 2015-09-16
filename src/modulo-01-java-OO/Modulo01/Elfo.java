public class Elfo {
    private String nome; 
    Armas armaEquipada = new Armas(3,20,"Punhos");
    private int flechas, experiencia = 0;
    
    public Elfo(String n, int flech) {
        nome = n;
        flechas = flech;
    }
    
    public Elfo(String n) {
        nome = n;
        flechas = 42;
    }
    
    public String equiparArma(Armas arma) {
        this.armaEquipada = arma;
        return "\nElfo " + this.nome + " equipou " + arma.nome+"\n";
    }
    
    public Armas armaEquipada() {
        return this.armaEquipada;
    }
    
    public void atirarFlecha() {
        if (this.flechas > 0) {
            this.flechas -= 1;
            this.experiencia += 3;
        } else {
            System.out.println("Sem flechas");
        }
    }

    
    public String atirarFlechaRefactory(Armas arma){
        if (arma.usaFlechas == true) {
            if (this.flechas > 0) {
                if(arma.acertar() == true){
                    flechas--;
                    experiencia++;
                    return "Acertou alvo";
                }else{
                    flechas--;
                    return "Errou alvo";
                }
            } else {
                return "Sem flechas";
            }
        } else {
            if(arma.acertar() == true){
                    experiencia++;
                    return "Acertou alvo";
                } else {
                    return "Errou alvo";
                }
            }
        }
    }
