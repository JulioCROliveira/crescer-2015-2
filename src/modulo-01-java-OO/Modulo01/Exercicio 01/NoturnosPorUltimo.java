
/**
 * Write a description of class NoturnosPorUltimo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;

public class NoturnosPorUltimo implements EstrategiaDeAtaque {
   String ordemUltimoAtaque = "";
    
    public void atacar(ExercitoDeElfos elfos, ArrayList<Dwarf> dwarves) {        
        ArrayList<Elfo> pelotao = ordenarPelotao(elfos);        
        this.ordemUltimoAtaque = "";
        for (Elfo elfo : pelotao) {
            for (Dwarf dwarf : dwarves) {                                 
                elfo.atirarFlecha(dwarf);
                this.ordemUltimoAtaque += elfo.getClass().getName().substring(4, 5) + ",";
            }
        }
    }
    
    public ArrayList<Elfo> ordenarPelotao(ExercitoDeElfos elfos) {
        elfos.ordenarPorStatus();       
        ArrayList<Elfo> vivos = elfos.getExercitoPorStatus(Status.VIVO);
        ArrayList<Elfo> pelotao = new ArrayList<Elfo>();
        for (Elfo elfo : vivos) {
            if (elfo.getClass().getName().equals("ElfoVerde")) {
                pelotao.add(elfo);
            }
        }
        for (Elfo elfo : vivos) {
            if (elfo.getClass().getName().equals("ElfoNoturno")) {
                pelotao.add(elfo);
            }
        }
        return pelotao;
    }
    
    public String getOrdemDoUltimoAtaque(){
        return this.ordemUltimoAtaque;
    }

}
