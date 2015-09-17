

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
    
    @Test public void testeElfoEquiparArma() {
        Elfo elfo1 = new Elfo("A", 20);
        Arma arco = new Arma(20,60,"Arco", true);
        elfo1.equiparArma(arco);
        
        assertEquals(arco, elfo1.armaEquipada());        
    }
    
    @Test public void testeElfoAtacar() {
        Elfo elfo1 = new Elfo("A", 100);
        Elfo elfo2 = new Elfo("B", 0);
        Dwarf alvo = new Dwarf();
        Arma arco = new Arma(20,50,"Arco", true);
        Arma espada = new Arma(20,50,"Espada");
        boolean testeAcerto = false, testeErro = false;
        String teste = "";
        int i = 0, darfVidaAnt, flechasAnt;
        
        elfo2.equiparArma(espada);
        teste = elfo2.atacar(elfo2.armaEquipada(), alvo);
        assertEquals(false, teste.equals("sem flechas"));
        
        elfo2.equiparArma(arco);
        teste = elfo2.atacar(elfo2.armaEquipada(), alvo);
        assertEquals("Sem flechas", teste);
        
        elfo1.equiparArma(arco);
        
        while (testeAcerto == false || testeErro == false) {
            darfVidaAnt = alvo.getVida();
            flechasAnt = elfo1.getFlechas();
            teste = elfo1.atacar(elfo1.armaEquipada(), alvo);
            if (teste == "Acertou alvo") {
                assertEquals(alvo.getVida(), (darfVidaAnt - elfo1.armaEquipada().getDano()));
                testeAcerto = true;
            }
            
            if (teste == "Errou alvo") {
                assertEquals(alvo.getVida(), darfVidaAnt);
                testeErro = true;
            }
            
            assertEquals(elfo1.getFlechas(), --flechasAnt);
            
            i++;
            if (i > 60) { 
                assertEquals(true, false);
                break; 
            }
        }
        
        elfo1.equiparArma(espada);
        i = 0;
        testeAcerto = false;
        testeErro = false;
        
        while (testeAcerto == false || testeErro == false) {
            darfVidaAnt = alvo.getVida();
            teste = elfo1.atacar(elfo1.armaEquipada(), alvo);
            if (teste == "Acertou alvo") {
                assertEquals(alvo.getVida(), (darfVidaAnt - elfo1.armaEquipada().getDano()));
                testeAcerto = true;
            }
            
            if (teste == "Errou alvo") {
                assertEquals(alvo.getVida(), darfVidaAnt);
                testeErro = true;
            }
            
            i++;
            if (i > 60) { 
                assertEquals(true, false);
                break; 
            }
        }
    }
}
