

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
        OrcSnaga orc = new OrcSnaga("A");
        
        assertEquals(false, orc.possuiEscudoUrukHai());
        assertEquals(false, orc.possuiEspada());
        assertEquals(true, orc.possuiArcoEFlechas());
        assertEquals(70, orc.getVida());
        assertEquals(5, orc.getFlechas());
    }
    
    @Test
    public void atacarElfo() {
        OrcSnaga orc = new OrcSnaga("A");
        Elfo elfo = new Elfo("Elfo");
        
        orc.atacarPersonagem(elfo);
        
        assertEquals(72, elfo.getVida());
        assertEquals(70, orc.getVida());
        assertEquals(4, orc.getFlechas());
    }
    
    @Test
    public void atacar3VezesElfo() {
        OrcSnaga orc = new OrcSnaga("A");
        Elfo elfo = new Elfo("Elfo");
        
        orc.atacarPersonagem(elfo);
        orc.atacarPersonagem(elfo);
        orc.atacarPersonagem(elfo);
        
        assertEquals(56, elfo.getVida());
        assertEquals(Status.VIVO, elfo.getStatus());
        assertEquals(70, orc.getVida());
        assertEquals(2, orc.getFlechas());
    }
    
    @Test
    public void atacar10VezesElfo() {
        OrcSnaga orc = new OrcSnaga("A");
        Elfo elfo = new Elfo("Elfo");
        
        for (int i = 0; i < 10; i++) {
            orc.atacarPersonagem(elfo);
        }
        
        
        assertEquals(40, elfo.getVida());
        assertEquals(Status.VIVO, elfo.getStatus());
        assertEquals(70, orc.getVida());
        assertEquals(0, orc.getFlechas());
        assertEquals(Status.FUGINDO, orc.getStatus());
    }
    
    @Test
    public void atacarDwarf() {
        OrcSnaga orc = new OrcSnaga("A");
        Dwarf dwarf = new Dwarf("Dwarf");
        
        orc.atacarPersonagem(dwarf);
        
        assertEquals(102, dwarf.getVida());
        assertEquals(70, orc.getVida());
    }
    
    @Test
    public void atacar3VezesDwarf() {
        OrcSnaga orc = new OrcSnaga("A");
        Dwarf dwarf = new Dwarf("Dwarf");
        
        orc.atacarPersonagem(dwarf);
        orc.atacarPersonagem(dwarf);
        orc.atacarPersonagem(dwarf);
        
        assertEquals(86, dwarf.getVida());
        assertEquals(Status.VIVO, dwarf.getStatus());
        assertEquals(70, orc.getVida());
    }
    
    @Test
    public void orcGanhaEscudoEAtaca10VezesDwarf() {
        OrcSnaga orc = new OrcSnaga("A");
        Dwarf dwarf = new Dwarf("Dwarf");
        
        orc.getInventario().adicionarItem(new Item("Escudo Uruk-Hai", 1));
        for (int i = 0; i < 10; i++) {
            orc.atacarPersonagem(dwarf);
        }
        
        
        assertEquals(70, dwarf.getVida());
        assertEquals(Status.VIVO, dwarf.getStatus());
        assertEquals(70, orc.getVida());
    }
        
    @Test
    public void elfoAtaca() {
        OrcSnaga orc = new OrcSnaga("A");
        Elfo elfo = new Elfo("Elfo");
        
        elfo.atacarOrc(orc);
        
        assertEquals(60, orc.getVida());
    }
    
    @Test
    public void elfoAtaca20Vezes() {
        OrcSnaga orc = new OrcSnaga("A");
        Elfo elfo = new Elfo("Elfo");
        
        for (int i = 0; i < 20; i++) {
            elfo.atacarOrc(orc);
        }
        
        
        assertEquals(0, orc.getVida());
        assertEquals(Status.MORTO, orc.getStatus());
    }
    
    @Test
    public void dwarfAtaca() {
        OrcSnaga orc = new OrcSnaga("A");
        Dwarf dwarf = new Dwarf("Dwarf");
        
        dwarf.atacarOrc(orc);
        
        assertEquals(60, orc.getVida());
    }
    
    @Test
    public void orcGanhaEscudoEDwarfAtaca() {
        OrcSnaga orc = new OrcSnaga("A");
        Dwarf dwarf = new Dwarf("Dwarf");
        
        orc.getInventario().adicionarItem(new Item("Escudo Uruk-Hai", 1));
        dwarf.atacarOrc(orc);
        
        assertEquals(true, orc.possuiEscudoUrukHai());
        assertEquals(64, orc.getVida());
    }
    
    @Test
    public void atacar5VezesElfoEFoge() {
        OrcSnaga orc = new OrcSnaga("A");
        Elfo elfo = new Elfo("Elfo");
        
        for (int i = 0; i < 5; i++) {
            orc.atacarPersonagem(elfo);
        }
        
        
        assertEquals(40, elfo.getVida());
        assertEquals(Status.VIVO, elfo.getStatus());
        assertEquals(70, orc.getVida());
        assertEquals(0, orc.getFlechas());
        assertEquals(Status.FUGINDO, orc.getStatus());
    }
    
    @Test
    public void orcSnagaAtaca5VezesOrcUrukHaiEFoge() {
        OrcSnaga orc = new OrcSnaga("A");
        OrcUrukHai orc2 = new OrcUrukHai("A");
        
        for (int i = 0; i < 5; i++) {
            orc.atacarPersonagem(orc2);
        }
        
        for (int i = 0; i < 5; i++) {
            orc2.atacarPersonagem(orc);
        }
        
        
        assertEquals(120, orc2.getVida());
        assertEquals(20, orc.getVida());
        assertEquals(Status.VIVO, orc2.getStatus());
        assertEquals(70, orc.getVida());
        assertEquals(0, orc.getFlechas());
        assertEquals(Status.FUGINDO, orc.getStatus());
    }
}
