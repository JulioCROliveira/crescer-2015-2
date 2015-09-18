
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
    @Test public void testeCriandoElfoCom42FlechasPadraoEQuantidadeInformada() {
        Elfo elfo1 = new Elfo("A", 20);
        Elfo elfo2 = new Elfo("B");

        assertEquals(20, elfo1.getFlechas());
        assertEquals(42, elfo2.getFlechas());
    }

    @Test public void elfoNasceComNomeVazio() {
        Elfo elfo = new Elfo ("");
        assertEquals("", elfo.getNome());
    }

    @Test
    public void elfoNasceComNomeEPoucasFlechas() {
        Elfo elfo = new Elfo("elfo humilde", 2);
        assertEquals("elfo humilde", elfo.getNome());
        assertEquals(2, elfo.getFlechas());
    }

    @Test
    public void elfoNasceComNomeEFlechasNegativas() {
        Elfo elfo = new Elfo("elfo devedor", -2);
        assertEquals("elfo devedor", elfo.getNome());
        assertEquals(-2, elfo.getFlechas());
    }

    @Test public void elfoNasceComNomeNull() {
        Elfo elfo = new Elfo (null);
        assertNull(elfo.getNome());
    }

    @Test public void testeElfoAtiraFlechaEDwarfPerde10DeVidaEElfoFicaSemFlechasDwarfNaoPerdeVida() {
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

    @Test
    public void elfoAtiraFlechasEm2Dwarfs() {
        Elfo elfo1 = new Elfo("A", 20);        
        Dwarf alvo = new Dwarf();   
        Dwarf alvo2 = new Dwarf();

        elfo1.atirarFlecha(alvo);
        elfo1.atirarFlecha(alvo2);

        assertEquals(100, alvo.getVida());
        assertEquals(100, alvo2.getVida());
        assertEquals(18, elfo1.getFlechas());
        assertEquals(2, elfo1.getExperiencia());
    }

    @Test public void ElfoAtirarFlechaOutroElfoAtira5FlechasDwarfFicaCom50Vida() {
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
        teste = "Legolas possui 42 flechas e 0 níveis de experiência.";

        assertEquals(teste, elfo1.toString());
    }
    
    @Test
    public void elfoNasceVivo() {
        Elfo elfo = new Elfo("aa");
        assertEquals(Status.VIVO, elfo.getStatus());
    }

    @Test public void testeElfoToStringDepoisDeAtirarFlecha() {
        Elfo elfo1 = new Elfo("Legolas");
        Dwarf aa = new Dwarf();
        String teste = "";
        elfo1.atirarFlecha(aa);
        teste = "Legolas possui 41 flechas e 1 nível de experiência.";

        assertEquals(teste, elfo1.toString());
    }

    @Test public void testeElfoToStringComNomeAAe1flecha() {
        Elfo elfo1 = new Elfo("AA", 1);
        Dwarf aa = new Dwarf();
        String teste = "";        
        teste = "AA possui 1 flecha e 0 níveis de experiência.";

        assertEquals(teste, elfo1.toString());
    }
}
