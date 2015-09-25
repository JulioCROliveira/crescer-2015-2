

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
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        Elfo elfo1 = new Elfo("A");
        Elfo elfo2 = new ElfoVerde("B",10);
        Elfo elfo3 = new ElfoNoturno("C");
        exercito.alistarElfo(elfo1);
        exercito.alistarElfo(elfo2);
        exercito.alistarElfo(elfo3);
        
        assertEquals("{B=B possui 10 flechas e 0 níveis de experiência., C=C possui 42 flechas e 0 níveis de experiência.}", exercito.getExercito().toString());        
    }
    
    @Test
    public void criar53ElfosEOrdenarPorStatus() { 
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        Elfo elfo1 = new ElfoVerde("A");
        Elfo elfo2 = new ElfoVerde("B",10);
        Elfo elfo3 = new ElfoNoturno("C");
        Elfo elfo4 = new ElfoNoturno("E");
        Elfo elfo5 = new ElfoVerde("D");
        exercito.alistarElfo(elfo1);
        exercito.alistarElfo(elfo2);
        exercito.alistarElfo(elfo3);
        exercito.alistarElfo(elfo4);
        exercito.alistarElfo(elfo5);
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
        
        
        exercito.ordenarPorStatus();
        
        assertEquals(elfosVivos, exercito.getExercitoPorStatus(Status.VIVO));
        assertEquals(elfosMortos, exercito.getExercitoPorStatus(Status.MORTO));       
    }
    
    @Test
    public void retornarElfoAtrvesDoNome() {
        int numeroDeElfosAnteriormente = Elfo.getNumeroDeElfos();  
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        Elfo elfo1 = new Elfo("A");
        Elfo elfo2 = new ElfoVerde("B",10);
        Elfo elfo3 = new ElfoNoturno("C");
        exercito.alistarElfo(elfo1);
        exercito.alistarElfo(elfo2);
        exercito.alistarElfo(elfo3);
        
        assertEquals(elfo2, exercito.buscar("B"));        
    }
    
    @Test
    public void testandoMetodoGetElfosDoExercito() {
        int numeroDeElfosAnteriormente = Elfo.getNumeroDeElfos(); 
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.getExercito().clear();
        Elfo elfo1 = new Elfo("A");
        Elfo elfo2 = new ElfoVerde("B",10);
        Elfo elfo3 = new ElfoNoturno("C");
        exercito.alistarElfo(elfo1);
        exercito.alistarElfo(elfo2);
        exercito.alistarElfo(elfo3);
        ArrayList<Elfo> listaDeElfos = new ArrayList<>();
        listaDeElfos.add(elfo2);
        listaDeElfos.add(elfo3);
        
        assertEquals(listaDeElfos, exercito.getElfosDoExercito());        
    }
}
