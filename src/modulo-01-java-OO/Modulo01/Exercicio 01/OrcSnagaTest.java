

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class OrcSnagaTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class OrcSnagaTest
{
    @Test
    public void inventarioSnagaSemEspadaEEscudoComArcoVida70Flechas5() {
        OrcSnaga orc = new OrcSnaga();
        
        assertEquals(false, orc.possuiEscudoUrukHai());
        assertEquals(false, orc.possuiEspada());
        assertEquals(true, orc.possuiArcoEFlechas());
        assertEquals(70, orc.getVida());
        assertEquals(5, orc.getFlechas());
    }
    
    @Test
    public void atacarElfo() {
        OrcSnaga orc = new OrcSnaga();
        Elfo elfo = new Elfo("Elfo");
        
        orc.atacarElfo(elfo);
        
        assertEquals(72, elfo.getVida());
        assertEquals(70, orc.getVida());
        assertEquals(4, orc.getFlechas());
    }
    
    @Test
    public void atacar3VezesElfo() {
        OrcSnaga orc = new OrcSnaga();
        Elfo elfo = new Elfo("Elfo");
        
        orc.atacarElfo(elfo);
        orc.atacarElfo(elfo);
        orc.atacarElfo(elfo);
        
        assertEquals(56, elfo.getVida());
        assertEquals(Status.VIVO, elfo.getStatus());
        assertEquals(70, orc.getVida());
        assertEquals(2, orc.getFlechas());
    }
    
    @Test
    public void atacar10VezesElfo() {
        OrcSnaga orc = new OrcSnaga();
        Elfo elfo = new Elfo("Elfo");
        
        for (int i = 0; i < 10; i++) {
            orc.atacarElfo(elfo);
        }
        
        
        assertEquals(40, elfo.getVida());
        assertEquals(Status.VIVO, elfo.getStatus());
        assertEquals(70, orc.getVida());
        assertEquals(0, orc.getFlechas());
        assertEquals(Status.FUGINDO, orc.getStatus());
    }
    
    @Test
    public void atacarDwarf() {
        OrcSnaga orc = new OrcSnaga();
        Dwarf dwarf = new Dwarf("Dwarf");
        
        orc.atacarDwarf(dwarf);
        
        assertEquals(110, dwarf.getVida());
        assertEquals(70, orc.getVida());
    }
    
    @Test
    public void atacar3VezesDwarf() {
        OrcSnaga orc = new OrcSnaga();
        Dwarf dwarf = new Dwarf("Dwarf");
        
        orc.atacarDwarf(dwarf);
        orc.atacarDwarf(dwarf);
        orc.atacarDwarf(dwarf);
        
        assertEquals(110, dwarf.getVida());
        assertEquals(Status.VIVO, dwarf.getStatus());
        assertEquals(70, orc.getVida());
    }
    
    @Test
    public void orcGanhaEscudoEAtaca10VezesDwarf() {
        OrcSnaga orc = new OrcSnaga();
        Dwarf dwarf = new Dwarf("Dwarf");
        
        orc.getInventario().adicionarItem(new Item("Escudo Uruk-Hai", 1));
        for (int i = 0; i < 10; i++) {
            orc.atacarDwarf(dwarf);
        }
        
        
        assertEquals(70, dwarf.getVida());
        assertEquals(Status.VIVO, dwarf.getStatus());
        assertEquals(70, orc.getVida());
    }
        
    @Test
    public void elfoAtaca() {
        OrcSnaga orc = new OrcSnaga();
        Elfo elfo = new Elfo("Elfo");
        
        elfo.atacarOrc(orc);
        
        assertEquals(62, orc.getVida());
    }
    
    @Test
    public void elfoAtaca20Vezes() {
        OrcSnaga orc = new OrcSnaga();
        Elfo elfo = new Elfo("Elfo");
        
        for (int i = 0; i < 20; i++) {
            elfo.atacarOrc(orc);
        }
        
        
        assertEquals(0, orc.getVida());
        assertEquals(Status.MORTO, orc.getStatus());
    }
    
    @Test
    public void dwarfAtaca() {
        OrcSnaga orc = new OrcSnaga();
        Dwarf dwarf = new Dwarf("Dwarf");
        
        dwarf.atacarOrc(orc);
        
        assertEquals(60, orc.getVida());
    }
    
    @Test
    public void orcGanhaEscudoEDwarfAtaca() {
        OrcSnaga orc = new OrcSnaga();
        Dwarf dwarf = new Dwarf("Dwarf");
        
        orc.getInventario().adicionarItem(new Item("Escudo Uruk-Hai", 1));
        dwarf.atacarOrc(orc);
        
        assertEquals(true, orc.possuiEscudoUrukHai());
        assertEquals(70, orc.getVida());
    }
    
    @Test
    public void atacar5VezesElfoEFoge() {
        OrcSnaga orc = new OrcSnaga();
        Elfo elfo = new Elfo("Elfo");
        
        for (int i = 0; i < 5; i++) {
            orc.atacarElfo(elfo);
        }
        
        
        assertEquals(40, elfo.getVida());
        assertEquals(Status.VIVO, elfo.getStatus());
        assertEquals(70, orc.getVida());
        assertEquals(0, orc.getFlechas());
        assertEquals(Status.FUGINDO, orc.getStatus());
    }
}
