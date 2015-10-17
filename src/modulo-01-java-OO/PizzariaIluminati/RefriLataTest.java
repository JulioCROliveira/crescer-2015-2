

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class RefriLataTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class RefriLataTest
{
    @Test
    public void criarLataRefrigerantePepsi() {
        Refri refri = new RefriLata(Refrigerante.PEPSI, 1);
        
        assertEquals(Refrigerante.PEPSI, refri.getMarca());
        assertEquals(1, refri.getQuantidade());
        assertEquals(3.50, refri.getValorTotal(), 0.00001);
    }
    
    @Test
    public void criarLataRefrigeranteCocaCola() {
        Refri refri = new RefriLata(Refrigerante.COCACOLA, 2);
        
        assertEquals(Refrigerante.COCACOLA, refri.getMarca());
        assertEquals(2, refri.getQuantidade());
        assertEquals(7, refri.getValorTotal(), 0.00001);
    }
    
    @Test
    public void criarLataRefrigeranteAntartica() {
        Refri refri = new RefriLata(Refrigerante.ANTARTICA, 3);
        
        assertEquals(Refrigerante.ANTARTICA, refri.getMarca());
        assertEquals(3, refri.getQuantidade());
        assertEquals(10.50, refri.getValorTotal(), 0.00001);
    }
    
    @Test
    public void toStringRefrigerantePepsi() {
        Refri refri = new RefriLata(Refrigerante.PEPSI, 1);
        
        assertEquals("1 lata de refrigerante Pepsi R$ 3,50", refri.toString());
    }
    
    @Test
    public void toStringRefrigeranteCocaCola() {
        Refri refri = new RefriLata(Refrigerante.COCACOLA, 2);
        
        assertEquals("2 latas de refrigerante Coca-Cola R$ 7,00", refri.toString());
    }
    
    @Test
    public void toStringRefrigeranteAntartica() {
        Refri refri = new RefriLata(Refrigerante.ANTARTICA, 3);
        
        assertEquals("3 latas de refrigerante Guaraná Antartica R$ 10,50", refri.toString());
    }
    
    @Test
    public void toStringRefrigeranteNull() {
        Refri refri = new RefriLata(null, 3);
        
        assertEquals("Falha no pedido de bebidas", refri.toString());
        assertEquals(0, refri.getQuantidade());
        assertEquals(0, refri.getValorTotal(), 0.00001);
    }
}
