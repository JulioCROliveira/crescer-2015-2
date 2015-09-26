
/**
 * Write a description of interface EstrategiaDeAtaque here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;

public interface EstrategiaDeAtaque {
    void atacar(ExercitoDeElfos elfos, ArrayList<Dwarf> dwarves);
   
    String getOrdemDoUltimoAtaque();
}
