
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
    private HashMap<String, Elfo> exercito = new HashMap<>();    
    private HashMap<Status, ArrayList<Elfo>> elfoPorStatus = new HashMap<>();
    private EstrategiaDeAtaque estrategia = new AArteDaGuerra();
    
    public EstrategiaDeAtaque getEstrategia() {
        return this.estrategia;
    }
    
    public void mudarEstrategia(EstrategiaDeAtaque estrategia) {
        this.estrategia = estrategia;
    }
    
    public void atacar(ArrayList<Dwarf> dwarves) {
        this.getEstrategia().atacar(this, dwarves);
    }
    
    public void alistarElfo(Elfo elfo) {
        String classe = elfo.getClass().getName();
        if (classe.equals("ElfoNoturno") || classe.equals("ElfoVerde")) {
            exercito.put(elfo.getNome(), elfo);         
        }
    }
    
    public void ordenarPorStatus() {
        elfoPorStatus.clear();
        for (Elfo elfo : exercito.values()) {
            if(elfoPorStatus.get(elfo.getStatus()) == null) 
               { 
                  elfoPorStatus.put(elfo.getStatus(),new ArrayList<Elfo>()); 
              } 
              elfoPorStatus.get(elfo.getStatus()).add(elfo); 
        }
    }
    
    public HashMap getExercito() {
        return exercito;
    }
    
    public ArrayList<Elfo> getExercitoPorStatus(Status status) {
        ArrayList<Elfo> retornar = elfoPorStatus.get(status);            
        return retornar;
    }
    
    public ArrayList getElfosDoExercito() {
        ArrayList<Elfo> retornar = new ArrayList<>();
        for (Elfo elfo : exercito.values()) {
            retornar.add(elfo);
        }
        return retornar;
    }
    
    public Elfo buscar(String nome) {
        return exercito.get(nome);
    }
}
