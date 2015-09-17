
/**
 * Escreva a descrição da classe Armas aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
import java.util.Random;

public class Arma
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private int dano, probAcerto;
    String nome;
    private Boolean usaFlechas = false;
    ;
    Arma(int dano, int probAcerto, String nome) {
        this.nome = nome;
        if ((probAcerto > -1) && (probAcerto < 101)) {
            this.probAcerto = probAcerto;
        } else if (probAcerto < 0) {
            this.probAcerto = 0;
        } else {
            this.probAcerto = 100;
       }
        this.dano = dano;
    }
    
        Arma(int dano, int probAcerto, String nome, boolean flechas) {
        this.nome = nome;
        if ((probAcerto > -1) && (probAcerto < 101)) {
            this.probAcerto = probAcerto;
        } else if (probAcerto < 0) {
            this.probAcerto = 0;
        } else {
            this.probAcerto = 100;
       }
        this.dano = dano;
        usaFlechas = flechas;
    }
    
    public boolean acertar() {
        Random rnd = new Random();
        if ((double) probAcerto >= rnd.nextDouble() * 100) {
            return true;
        } else {
            return false;
        }
    }
    
    public int getDano() {
        return this.dano;
    }
    
    public int getProbAcerto() {
        return this.probAcerto;
    }
    
    public boolean getUsaFlechas() {
        return this.usaFlechas;
    }
}
