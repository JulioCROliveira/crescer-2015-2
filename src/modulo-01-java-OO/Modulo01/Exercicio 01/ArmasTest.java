

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * A classe de teste ArmasTest.
 *
 * @author  (seu nome)
 * @version (um número de versão ou data)
 */
public class ArmasTest
{
    @Test public void testeCriandoArma() {
        Arma arco = new Arma(10,-5,"Arco", true);
        Arma arco2 = new Arma(10,105,"Arco", true);
        Arma arco3 = new Arma(10,60,"Arco", true);
        Arma espada = new Arma(10,-5,"Espada");
        Arma espada2 = new Arma(10,105,"Espada");
        Arma espada3 = new Arma(10,60,"Espada");
        assertEquals(0, arco.getProbAcerto());
        assertEquals(100, arco2.getProbAcerto());
        assertEquals(true, arco.getUsaFlechas());
        assertEquals(0, espada.getProbAcerto());
        assertEquals(100, espada2.getProbAcerto());
        assertEquals(false, espada.getUsaFlechas());
        assertEquals(60, arco3.getProbAcerto());
        assertEquals(60, espada3.getProbAcerto());      
    }
    
    @Test public void testeMetodoAcertar() {
        Arma arco = new Arma(10,50,"Arco", true);
        boolean testeTrue = false;
        boolean testeFalse = true;
        int i = 0;
        while (testeTrue == false) {            
            testeTrue = arco.acertar();
            i++;
            if (i>50) {break;}
        }
        
        i = 0;
        while (testeFalse) {
            testeFalse = arco.acertar();            
            i++;
            if (i>50) {break;}
        }
        
        assertEquals(true, testeTrue);
        assertEquals(false, testeFalse);
    }
}
