

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class OrcUrukHaiTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class OrcUrukHaiTest
{
    @Test
    public void inventarioComEspadaEEscudoSemArcoVida150SemFlechas() {
        OrcUrukHai orc = new OrcUrukHai();
        
        assertEquals(true, orc.possuiEscudoUrukHai());
        assertEquals(true, orc.possuiEspada());
        assertEquals(false, orc.possuiArcoEFlechas());
        assertEquals(150, orc.getVida());
        assertEquals(0, orc.getFlechas());
    }
    
    @Test
    public void atacarElfo() {
        OrcUrukHai orc = new OrcUrukHai();
        Elfo elfo = new Elfo("Elfo");
        
        orc.atacarElfo(elfo);
        
        assertEquals(68, elfo.getVida());
        assertEquals(150, orc.getVida());
    }
    
    @Test
    public void atacar3VezesElfo() {
        OrcUrukHai orc = new OrcUrukHai();
        Elfo elfo = new Elfo("Elfo");
        
        orc.atacarElfo(elfo);
        orc.atacarElfo(elfo);
        orc.atacarElfo(elfo);
        
        assertEquals(44, elfo.getVida());
        assertEquals(Status.VIVO, elfo.getStatus());
        assertEquals(150, orc.getVida());
    }
    
    @Test
    public void atacar10VezesElfo() {
        OrcUrukHai orc = new OrcUrukHai();
        Elfo elfo = new Elfo("Elfo");
        
        for (int i = 0; i < 10; i++) {
            orc.atacarElfo(elfo);
        }
        
        
        assertEquals(0, elfo.getVida());
        assertEquals(Status.MORTO, elfo.getStatus());
        assertEquals(150, orc.getVida());
    }
    
    @Test
    public void atacarDwarf() {
        OrcUrukHai orc = new OrcUrukHai();
        Dwarf dwarf = new Dwarf("Dwarf");
        
        orc.atacarDwarf(dwarf);
        
        assertEquals(98, dwarf.getVida());
        assertEquals(150, orc.getVida());
    }
    
    @Test
    public void atacar3VezesDwarf() {
        OrcUrukHai orc = new OrcUrukHai();
        Dwarf dwarf = new Dwarf("Dwarf");
        
        orc.atacarDwarf(dwarf);
        orc.atacarDwarf(dwarf);
        orc.atacarDwarf(dwarf);
        
        assertEquals(74, dwarf.getVida());
        assertEquals(Status.VIVO, dwarf.getStatus());
        assertEquals(150, orc.getVida());
    }
    
    @Test
    public void atacar10VezesDwarf() {
        OrcUrukHai orc = new OrcUrukHai();
        Dwarf dwarf = new Dwarf("Dwarf");
        
        for (int i = 0; i < 10; i++) {
            orc.atacarDwarf(dwarf);
        }
        
        
        assertEquals(0, dwarf.getVida());
        assertEquals(Status.MORTO, dwarf.getStatus());
        assertEquals(150, orc.getVida());
    }
    
    @Test
    public void atacar10VezesDwarfSemSorte() {
        OrcUrukHai orc = new OrcUrukHai();
        Dwarf dwarf = new Dwarf("Dwarf", new DataTerceiraEra(1,1,2000));
        
        for (int i = 0; i < 10; i++) {
            orc.atacarDwarf(dwarf);
        }
        
        
        assertEquals(0, dwarf.getVida());
        assertEquals(Status.MORTO, dwarf.getStatus());
        assertEquals(150, orc.getVida());
    }
    
    @Test
    public void elfoTentaAtacar() {
        OrcUrukHai orc = new OrcUrukHai();
        Elfo elfo = new Elfo("Elfo");
        
        elfo.atacarOrc(orc);
        
        assertEquals(150, orc.getVida());
    }
    
    @Test
    public void orcPerdeEscudoEElfoAtaca() {
        OrcUrukHai orc = new OrcUrukHai();
        Elfo elfo = new Elfo("Elfo");
        
        orc.getInventario().perderItem(new Item("Escudo Uruk-Hai", 1));
        elfo.atacarOrc(orc);
        
        assertEquals(150, orc.getVida());
    }
    
    @Test
    public void dwarfTentaAtacar() {
        OrcUrukHai orc = new OrcUrukHai();
        Dwarf dwarf = new Dwarf("Dwarf");
        
        dwarf.atacarOrc(orc);
        
        assertEquals(150, orc.getVida());
    }
    
    @Test
    public void orcPerdeEscudoEDwarfAtaca() {
        OrcUrukHai orc = new OrcUrukHai();
        Dwarf dwarf = new Dwarf("Dwarf");
        
        orc.getInventario().perderItem(new Item("Escudo Uruk-Hai", 1));
        dwarf.atacarOrc(orc);
        
        assertEquals(false, orc.possuiEscudoUrukHai());
        assertEquals(150, orc.getVida());
    }
}
