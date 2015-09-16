
/**
 * Escreva a descrição da classe Armas aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
import java.util.Random;

public class Armas
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private int dano, probAcerto;
    String nome;
    
    Armas(int dano, int probAcerto, String nome) {
        this.nome = nome;
        this.probAcerto = probAcerto;
        this.dano = dano;
    }
    
    public boolean acertar() {
        Random rnd = new Random();
        if ((double) probAcerto >= rnd.nextDouble() * 100) {
            return true;
        } else {
            return false;
        }
    }    
}
