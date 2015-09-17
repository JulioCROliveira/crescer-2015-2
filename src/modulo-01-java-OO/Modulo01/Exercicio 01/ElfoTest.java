

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
    
    @Test public void teste2ElfoAtirarFlecha() {
        Elfo elfo1 = new Elfo("A", 1);
        Elfo elfo2 = new Elfo("A", 10);      
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
        
        for (int i = 0; i < 5; i++) {
            elfo2.atirarFlecha(alvo);
        }
        
        assertEquals(50, alvo.getVida());
    }
    
    @Test public void testeElfoToString() {
        Elfo elfo1 = new Elfo("Legolas");
       String teste = "";
       teste = elfo1.getNome() + " possui " + elfo1.getFlechas() + " flechas e " + elfo1.getExperiencia() + 
        " níveis de experiência";
        
        assertEquals(teste, elfo1.toString());
    }
}
