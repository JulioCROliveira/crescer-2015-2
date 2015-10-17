

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class Refri2LitrosTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class Refri2LitrosTest
{
    @Test
    public void criarLataRefrigerantePepsi() {
        Refri refri = new Refri2Litros(Refrigerante.PEPSI, 1);
        
        assertEquals(Refrigerante.PEPSI, refri.getMarca());
        assertEquals(1, refri.getQuantidade());
        assertEquals(7, refri.getValorTotal(), 0.00001);
    }
    
    @Test
    public void criarLataRefrigeranteCocaCola() {
        Refri refri = new Refri2Litros(Refrigerante.COCACOLA, 2);
        
        assertEquals(Refrigerante.COCACOLA, refri.getMarca());
        assertEquals(2, refri.getQuantidade());
        assertEquals(14, refri.getValorTotal(), 0.00001);
    }
    
    @Test
    public void criarLataRefrigeranteAntartica() {
        Refri refri = new Refri2Litros(Refrigerante.ANTARTICA, 3);
        
        assertEquals(Refrigerante.ANTARTICA, refri.getMarca());
        assertEquals(3, refri.getQuantidade());
        assertEquals(21, refri.getValorTotal(), 0.00001);
    }
    
    @Test
    public void toStringRefrigerantePepsi() {
        Refri refri = new Refri2Litros(Refrigerante.PEPSI, 1);
        
        assertEquals("1 garrafa de 2L de refrigerante Pepsi R$ 7,00", refri.toString());
    }
    
    @Test
    public void toStringRefrigeranteCocaCola() {
        Refri refri = new Refri2Litros(Refrigerante.COCACOLA, 2);
        
        assertEquals("2 garrafas de 2L de refrigerante Coca-Cola R$ 14,00", refri.toString());
    }
    
    @Test
    public void toStringRefrigeranteAntartica() {
        Refri refri = new Refri2Litros(Refrigerante.ANTARTICA, 3);
        
        assertEquals("3 garrafas de 2L de refrigerante Guaraná Antartica R$ 21,00", refri.toString());
    }
    
    @Test
    public void toStringRefrigeranteNull() {
        Refri refri = new Refri2Litros(null, 3);
        
        assertEquals("Falha no pedido de bebidas", refri.toString());
        assertEquals(0, refri.getQuantidade());
        assertEquals(0, refri.getValorTotal(), 0.00001);
    }
}
