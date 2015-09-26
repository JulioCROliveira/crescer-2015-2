

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

/**
 * The test class NoturnosEspertosTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class NoturnosEspertosTest
{
    @Test
    public void test5ElfosVerdes5ElfosNoturnosAtacam1Dwarf() {
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.mudarEstrategia(new NoturnosEspertos());
        Elfo noturno = new ElfoNoturno("AA", 100);
        Elfo verde = new ElfoVerde("AAB", 100);
        exercito.alistarElfo(noturno); exercito.alistarElfo(verde);
        ArrayList<Dwarf> dwarves = new ArrayList<>();
         for (int i = 0; i < 50; i++) {
            dwarves.add(new Dwarf("A"+i));
        }               
        
       exercito.atacar(dwarves);
       
       assertEquals(29, noturno.getVida());
       assertEquals(79, noturno.getFlechas());
       assertEquals(50, verde.getFlechas());
    }
}
