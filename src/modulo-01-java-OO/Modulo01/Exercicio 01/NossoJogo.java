
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
        if (args.length > 0) {
            System.out.println("Olá "+args[0]+", bem vindo ao "+ NossoJogo.NOME);
        }
    }
}
