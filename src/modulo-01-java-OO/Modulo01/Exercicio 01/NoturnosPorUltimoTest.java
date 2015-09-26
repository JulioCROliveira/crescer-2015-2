

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class NoturnosPorUltimoTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;

public class NoturnosPorUltimoTest
{
    @Test
    public void test5ElfosVerdes5ElfosNoturnosAtacam1Dwarf() {
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.mudarEstrategia(new NoturnosPorUltimo());
        Elfo a = new ElfoVerde("A");
        Elfo b = new ElfoVerde("B");
        Elfo c = new ElfoVerde("C");
        Elfo d = new ElfoVerde("D");
        Elfo e = new ElfoVerde("E");
        Elfo noturno1 = new ElfoNoturno("A1");
        Elfo noturno2 = new ElfoNoturno("A2");
        Elfo noturno3 = new ElfoNoturno("A3");
        Elfo noturno4 = new ElfoNoturno("A4");
        Elfo noturno5 = new ElfoNoturno("A5");
        ArrayList<Dwarf> dwarves = new ArrayList<>();
        Dwarf dwarf1 = new Dwarf("AA");
        exercito.alistarElfo(a); exercito.alistarElfo(b); exercito.alistarElfo(c);
        exercito.alistarElfo(d); exercito.alistarElfo(e);
        exercito.alistarElfo(noturno1); exercito.alistarElfo(noturno2); exercito.alistarElfo(noturno3);
        exercito.alistarElfo(noturno4); exercito.alistarElfo(noturno5);
        dwarves.add(dwarf1);
        
       exercito.atacar(dwarves);
       assertEquals(10, exercito.getExercito().size());
       assertEquals(10, dwarf1.getVida());
       assertEquals("V,V,V,V,V,N,N,N,N,N,", exercito.getEstrategia().getOrdemDoUltimoAtaque());
    }
    
    @Test
    public void test2ElfosVerdes8ElfosNoturnosAtacam3Dwarf() {
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.mudarEstrategia(new NoturnosPorUltimo());
        Elfo a = new ElfoVerde("A");
        Elfo b = new ElfoVerde("B");
        Elfo c = new ElfoNoturno("C");
        Elfo d = new ElfoNoturno("D");
        Elfo e = new ElfoNoturno("E");
        Elfo noturno1 = new ElfoNoturno("A1");
        Elfo noturno2 = new ElfoNoturno("A2");
        Elfo noturno3 = new ElfoNoturno("A3");
        Elfo noturno4 = new ElfoNoturno("A4");
        Elfo noturno5 = new ElfoNoturno("A5");
        ArrayList<Dwarf> dwarves = new ArrayList<>();
        Dwarf dwarf1 = new Dwarf("AA");
        Dwarf dwarf2 = new Dwarf("AB");
        Dwarf dwarf3 = new Dwarf("AC");
        exercito.alistarElfo(a); exercito.alistarElfo(b); exercito.alistarElfo(c);
        exercito.alistarElfo(d); exercito.alistarElfo(e);
        exercito.alistarElfo(noturno1); exercito.alistarElfo(noturno2); exercito.alistarElfo(noturno3);
        exercito.alistarElfo(noturno4); exercito.alistarElfo(noturno5);
        dwarves.add(dwarf1); dwarves.add(dwarf2); dwarves.add(dwarf3);
        
       exercito.atacar(dwarves);       
       assertEquals(10, dwarf1.getVida());
       assertEquals(10, dwarf2.getVida());
       assertEquals(10, dwarf3.getVida());
       assertEquals("V,V,V,V,V,V,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,", exercito.getEstrategia().getOrdemDoUltimoAtaque());
    }
    
    @Test
    public void test5ElfosVerdes5ElfosNoturnos1MortoAtacam3Dwarf() {
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.mudarEstrategia(new NoturnosPorUltimo());
        Elfo a = new ElfoVerde("A");
        Elfo b = new ElfoVerde("B");
        Elfo c = new ElfoVerde("C");
        Elfo d = new ElfoVerde("D");
        Elfo e = new ElfoVerde("E");
        Elfo noturno1 = new ElfoNoturno("A1");
        Elfo noturno2 = new ElfoNoturno("A2");
        Elfo noturno3 = new ElfoNoturno("A3");
        Elfo noturno4 = new ElfoNoturno("A4");
        Elfo noturno5 = new ElfoNoturno("A5");
        Elfo noturno6 = new ElfoNoturno("A6",100);
        ArrayList<Dwarf> dwarves = new ArrayList<>();
        Dwarf dwarf1 = new Dwarf("AA");
        Dwarf dwarf2 = new Dwarf("AB");
        Dwarf dwarf3 = new Dwarf("AC");
        exercito.alistarElfo(a); exercito.alistarElfo(b); exercito.alistarElfo(c);
        exercito.alistarElfo(d); exercito.alistarElfo(e);
        exercito.alistarElfo(noturno1); exercito.alistarElfo(noturno2); exercito.alistarElfo(noturno3);
        exercito.alistarElfo(noturno4); exercito.alistarElfo(noturno5); exercito.alistarElfo(noturno6);
        dwarves.add(dwarf1); dwarves.add(dwarf2); dwarves.add(dwarf3);
        
        for (int i = 0; i < 100; i++) {
            noturno6.atirarFlecha(new Dwarf("A"));
        }
        
       exercito.atacar(dwarves);       
       assertEquals(10, dwarf1.getVida());
       assertEquals(10, dwarf2.getVida());
       assertEquals(10, dwarf3.getVida());
       assertEquals("V,V,V,V,V,V,V,V,V,V,V,V,V,V,V,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,", exercito.getEstrategia().getOrdemDoUltimoAtaque());
    }
}
