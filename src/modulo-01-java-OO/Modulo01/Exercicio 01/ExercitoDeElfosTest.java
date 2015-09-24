

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

/**
 * The test class ExercitoDeElfosTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ExercitoDeElfosTest
{
    @Test
    public void criar3ElfosEVerificarContador() {
        int numeroDeElfosAnteriormente = Elfo.getNumeroDeElfos();  
        Elfo elfo1 = new Elfo("A");
        Elfo elfo2 = new ElfoVerde("A");
        Elfo elfo3 = new ElfoNoturno("A");
        
        assertEquals(numeroDeElfosAnteriormente + 3, Elfo.getNumeroDeElfos());        
    }
    
    @Test
    public void criar3ElfosE1OrcE1DwarfEVerificarContador() {
        int numeroDeElfosAnteriormente = Elfo.getNumeroDeElfos();  
        Elfo elfo1 = new Elfo("A");
        Elfo elfo2 = new ElfoVerde("A");
        Elfo elfo3 = new ElfoNoturno("A");
        Personagem darf = new Dwarf("A");
        Personagem orc = new OrcSnaga("A");
        
        assertEquals(numeroDeElfosAnteriormente + 3, Elfo.getNumeroDeElfos());        
    }
    
    @Test
    public void criar3ElfosEVerificarEOsAlistam() {
        int numeroDeElfosAnteriormente = Elfo.getNumeroDeElfos();  
        Elfo elfo1 = new Elfo("A");
        Elfo elfo2 = new ElfoVerde("B",10);
        Elfo elfo3 = new ElfoNoturno("C");
        ExercitoDeElfos.alistarElfo(elfo1);
        ExercitoDeElfos.alistarElfo(elfo2);
        ExercitoDeElfos.alistarElfo(elfo3);
        
        assertEquals("{B=B possui 10 flechas e 0 níveis de experiência., C=C possui 42 flechas e 0 níveis de experiência.}", ExercitoDeElfos.getExercito().toString());        
    }
    
    @Test
    public void criar53ElfosEOrdenarPorStatus() {        
        Elfo elfo1 = new ElfoVerde("A");
        Elfo elfo2 = new ElfoVerde("B",10);
        Elfo elfo3 = new ElfoNoturno("C");
        Elfo elfo4 = new ElfoNoturno("E");
        Elfo elfo5 = new ElfoVerde("D");
        ExercitoDeElfos.alistarElfo(elfo1);
        ExercitoDeElfos.alistarElfo(elfo2);
        ExercitoDeElfos.alistarElfo(elfo3);
        ExercitoDeElfos.alistarElfo(elfo4);
        ExercitoDeElfos.alistarElfo(elfo5);
        Orc orc = new OrcUrukHai("A");
        ArrayList<Elfo> elfosVivos = new ArrayList<>();
        ArrayList<Elfo> elfosMortos = new ArrayList<>();
        
        for (int i = 0; i < 30; i++) {
            orc.atacarPersonagem(elfo2);
            orc.atacarPersonagem(elfo4);
        }
        elfosVivos.add(elfo1);
        elfosVivos.add(elfo3);
        elfosVivos.add(elfo5);
        
        elfosMortos.add(elfo2);
        elfosMortos.add(elfo4);
        
        
        ExercitoDeElfos.ordenarPorStatus();
        
        assertEquals(elfosVivos, ExercitoDeElfos.getExercitoPorStatus(Status.VIVO));
        assertEquals(elfosMortos, ExercitoDeElfos.getExercitoPorStatus(Status.MORTO));       
    }
}
