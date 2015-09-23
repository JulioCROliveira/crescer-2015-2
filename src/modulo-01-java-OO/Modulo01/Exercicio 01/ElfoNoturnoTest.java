

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ElfoNoturnoTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ElfoNoturnoTest
{
    
    @Test 
    public void testeElfoNoturnoAtiraFlechaEDwarfPerde10DeVida() {
        Elfo elfo1 = new ElfoNoturno("A");        
        Dwarf alvo = new Dwarf("a",new DataTerceiraEra(1,1,1));
        elfo1.atirarFlecha(alvo);  
        
        assertEquals(100, alvo.getVida());
        assertEquals(41, elfo1.getFlechas());
        assertEquals(95, elfo1.getVida());
    }
    
    @Test 
    public void testeElfoNoturnoAtiraFlechaEDwarfPerde20DeVida() {
        Elfo elfo1 = new ElfoNoturno("A");        
        Dwarf alvo = new Dwarf("a",new DataTerceiraEra(1,1,1));
        elfo1.atirarFlecha(alvo); 
        elfo1.atirarFlecha(alvo); 
        
        assertEquals(90, alvo.getVida());
        assertEquals(40, elfo1.getFlechas());
        assertEquals(90, elfo1.getVida());
    }
    
    @Test 
    public void testeElfoNoturnoAtira100FlechasEMorre() {
        Elfo elfo1 = new ElfoNoturno("A", 100);        
        Dwarf alvo = new Dwarf("a",new DataTerceiraEra(1,1,1));
        
        for (int i = 0; i < 100; i++) {
            elfo1.atirarFlecha(alvo);
        }
        
        assertEquals(56, elfo1.getFlechas());
        assertEquals(0, elfo1.getVida());
        assertEquals(Status.MORTO, elfo1.getStatus());
    }
}
