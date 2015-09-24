

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
        
        assertEquals("{A=A possui 42 flechas e 0 níveis de experiência., B=B possui 10 flechas e 0 níveis de experiência., C=C possui 42 flechas e 0 níveis de experiência.}", ExercitoDeElfos.getExercito().toString());        
    }
}
