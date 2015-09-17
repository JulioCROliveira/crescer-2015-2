

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * A classe de teste ElfoTest.
 *
 * @author  (seu nome)
 * @version (um número de versão ou data)
 */
public class ElfoTest
{
    @Test public void testeCriandoElfo() {
        Elfo elfo1 = new Elfo("A", 20);
        Elfo elfo2 = new Elfo("B");
        
        assertEquals(20, elfo1.getFlechas());
        assertEquals(42, elfo2.getFlechas());
    }
    
    @Test public void testeElfoAtirarFlecha() {
        Elfo elfo1 = new Elfo("A", 1);        
        Dwarf alvo = new Dwarf();        
        String teste = "";
             
        teste = elfo1.atirarFlecha(alvo);
        if (teste == "Acertou alvo") {
            assertEquals(alvo.getVida(), 100);
        }
        
        assertEquals(elfo1.getFlechas(), 0);
        
        teste = elfo1.atirarFlecha(alvo);
        if (teste == "Sem Flechas") {
            assertEquals(alvo.getVida(), 100);
        }
    }
}
