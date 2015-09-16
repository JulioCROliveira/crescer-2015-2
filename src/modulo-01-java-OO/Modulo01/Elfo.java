public class Elfo {
    private String nome, armaEquipada="";
    private int flechas, experiencia = 0;
    
    public Elfo(String n, int flech) {
        nome = n;
        flechas = flech;
    }
    
    public Elfo(String n) {
        nome = n;
        flechas = 42;
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
    }
}