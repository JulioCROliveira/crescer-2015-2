
/**
 * Write a description of class ExercitoDeElfos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.HashMap;
import java.util.ArrayList;

public class ExercitoDeElfos
{
    private static HashMap<String, Elfo> exercito = new HashMap<>();
    
    public static void alistarElfo(Elfo elfo) {
        exercito.put(elfo.getNome(), elfo);
    }    
    
    public static HashMap getExercito() {
        return exercito;
    }
}
