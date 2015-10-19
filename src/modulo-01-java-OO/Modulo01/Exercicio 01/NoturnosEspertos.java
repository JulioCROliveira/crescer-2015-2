
/**
 * Write a description of class NoturnosEspertos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;

public class NoturnosEspertos implements EstrategiaDeAtaque{
    String ordemUltimoAtaque = "";
        
    public void atacar(ExercitoDeElfos elfos, ArrayList<Dwarf> dwarves) {
        elfos.ordenarPorStatus();       
        ArrayList<Elfo> pelotao = elfos.getExercitoPorStatus(Status.VIVO);        
        this.ordemUltimoAtaque = "";
        for (Elfo elfo : pelotao) {
            for (Dwarf dwarf : dwarves) {
                if (elfo.getClass().getName().equals("ElfoNoturno") && elfo.getVida() <= 30) {                                      
                    continue;
                }    
                elfo.atirarFlecha(dwarf);                
                this.ordemUltimoAtaque += elfo.getClass().getName().substring(4, 5) + ",";
            }
        }
    }
    
    public String getOrdemDoUltimoAtaque(){
        return this.ordemUltimoAtaque;
    }
}
