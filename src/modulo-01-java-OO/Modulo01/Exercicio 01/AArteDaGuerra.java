
/**
 * Write a description of class AArteDaGuerra here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;


public class AArteDaGuerra implements EstrategiaDeAtaque{
    String ordemUltimoAtaque = "";
        
    public void atacar(ExercitoDeElfos elfos, ArrayList<Dwarf> dwarves) {
        elfos.ordenarPorStatus();       
        ArrayList<Elfo> pelotao = elfos.getExercitoPorStatus(Status.VIVO);
        int ataquesElfosNoturnos=0, maximoElfosNoturnos;
        maximoElfosNoturnos = ((int)(pelotao.size()*dwarves.size()*0.30));
        this.ordemUltimoAtaque = "";
        for (Elfo elfo : pelotao) {
            for (Dwarf dwarf : dwarves) {
                if (elfo.getClass().getName().equals("ElfoNoturno")) {
                    if (ataquesElfosNoturnos >= maximoElfosNoturnos) {                         
                        continue;
                    }
                    ataquesElfosNoturnos++;
                }     
                elfo.atirarFlecha(dwarf);
                this.ordemUltimoAtaque += elfo.getClass().getName().substring(4, 5) + ",";
            }
        }
    }
    
    public String getOrdemDoUltimoAtaque(){
        return "";
    }
    
    public String metodoDeExemplo(){
        return "";
    }
}
