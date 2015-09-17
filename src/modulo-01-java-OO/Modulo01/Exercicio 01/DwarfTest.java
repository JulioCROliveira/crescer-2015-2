
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

    @Test public void dwarfRecebeFlechadaEPerde10DeVida() {
        Dwarf gimli = new Dwarf();
        gimli.receberFlechada();
        assertEquals(100, gimli.getVida());
    }

    @Test public void dwarfRecebe11FlechadaEPerde110DeVida() {
        Dwarf gimli = new Dwarf();
        for (int i = 0; i < 11; i++){
            gimli.receberFlechada();
        }
        assertEquals(0, gimli.getVida());
    }

     @Test public void dwarfRecebe7FlechadaEPerde70DeVida() {
        Dwarf gimli = new Dwarf();
        for (int i = 0; i < 7; i++){
            gimli.receberFlechada();
        }
        assertEquals(40, gimli.getVida());
    }
}
