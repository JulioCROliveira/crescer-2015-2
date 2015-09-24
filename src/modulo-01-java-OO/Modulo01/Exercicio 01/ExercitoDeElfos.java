
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
    private static HashMap<Status, ArrayList> elfoPorStatus = new HashMap<>();
    
    public static void alistarElfo(Elfo elfo) {
        String classe = elfo.getClass().getName();
        if (classe.equals("ElfoNoturno") || classe.equals("ElfoVerde")) {
            exercito.put(elfo.getNome(), elfo);         
        }
    }
    
    public static void ordenarPorStatus() {
        elfoPorStatus.clear();
        for (Elfo elfo : exercito.values()) {
            if(elfoPorStatus.get(elfo.getStatus()) == null) 
               { 
                  elfoPorStatus.put(elfo.getStatus(),new ArrayList<Elfo>()); 
              } 
              elfoPorStatus.get(elfo.getStatus()).add(elfo); 
        }
    }
    
    public static HashMap getExercito() {
        return exercito;
    }
    
    public static ArrayList getExercitoPorStatus(Status status) {
        ArrayList<Elfo> retornar = elfoPorStatus.get(status);            
        return retornar;
    }
    
    public static ArrayList getElfosDoExercito() {
        ArrayList<Elfo> retornar = new ArrayList<>();
        for (Elfo elfo : exercito.values()) {
            retornar.add(elfo);
        }
        return retornar;
    }
}
