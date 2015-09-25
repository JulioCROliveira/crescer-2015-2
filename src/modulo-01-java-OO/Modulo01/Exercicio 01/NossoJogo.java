
/**
 * Write a description of class Jogo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NossoJogo
{
    public final static String NOME = "Bahh of the Rings";
    
    public static void main(String[] args) {
        try {
            System.out.println("Olá "+args[0]+", bem vindo ao "+ NossoJogo.NOME);
        } catch (IndexOutOfBoundsException err) {
            System.out.println("Olá jogador, bem vindo ao "+ NossoJogo.NOME);
        } 
    }
}
