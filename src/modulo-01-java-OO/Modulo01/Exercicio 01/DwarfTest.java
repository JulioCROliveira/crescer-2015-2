

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * A classe de teste DwarfTest.
 *
 * @author  (seu nome)
 * @version (um número de versão ou data)
 */
public class DwarfTest
{
    @Test public void dwarfNasceCom110DeVida() {
        Dwarf gimli = new Dwarf();
        assertEquals(110, gimli.getVida());
    }
    
    @Test public void addVidaTeste() {
        Dwarf gimli = new Dwarf();
        gimli.addVida(20);
        assertEquals(130, gimli.getVida());
    }
    
    @Test public void addVidaNegativaTeste() {
        Dwarf gimli = new Dwarf();
        gimli.addVida(-20);
        assertEquals(90, gimli.getVida());
    }
}
