
/**
 * Write a description of class AtaqueIntercalado here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;

public class AtaqueIntercalado implements EstrategiaDeAtaque {
    String ordemUltimoAtaque = "";
    
    public void atacar(ExercitoDeElfos elfos, ArrayList<Dwarf> dwarves) {        
        ArrayList<Elfo> pelotao = ordenarPelotao(elfos);        
        this.ordemUltimoAtaque = "";
        for (Dwarf dwarf : dwarves) {
            for (Elfo elfo : pelotao) {                                 
                elfo.atirarFlecha(dwarf);
                this.ordemUltimoAtaque += elfo.getClass().getName().substring(4, 5) + ",";
            }
        }
    }
    
    public ArrayList<Elfo> ordenarPelotao(ExercitoDeElfos elfos) {
        elfos.ordenarPorStatus();       
        ArrayList<Elfo> vivos = elfos.getExercitoPorStatus(Status.VIVO);
        ArrayList<Elfo> pelotao = new ArrayList<Elfo>();
        String primeiraClasse = vivos.get(0).getClass().getName();
        Elfo aux;
        int primeiro=0, total=0, outroElfo;
        for (Elfo elfo : vivos) {
            if (elfo.getClass().getName().equals(primeiraClasse)) {
                pelotao.add(elfo);
                primeiro++;
            }
            total++;
        }
        
        for (int i = primeiro -1; i >= (total - primeiro); i--) {
            pelotao.remove(i);
        }
        
        total = 0;
        for (Elfo elfo : vivos) {
            if (!elfo.getClass().getName().equals(primeiraClasse) && total < primeiro) {
                pelotao.add(elfo);
                total++;
            }           
        }
        
        for (int i = 1; i < pelotao.size()/2; i+=2) {
            outroElfo = pelotao.size() - i - 1;
            aux = pelotao.get(i);
            pelotao.set(i, pelotao.get(outroElfo));
            pelotao.set(outroElfo, aux);
        }
        
        return pelotao;
    }
    
    public String getOrdemDoUltimoAtaque(){
        return this.ordemUltimoAtaque;
    }
}
