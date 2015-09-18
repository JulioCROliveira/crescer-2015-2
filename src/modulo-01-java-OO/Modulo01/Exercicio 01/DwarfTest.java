
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * A classe de teste DwarfTest.
 *
 * @author  (seu nome)
 * @version (um número de versão ou data)
 */
public class DwarfTest
{
    @Test public void dwarfNasceCom110DeVida() {
        Dwarf gimli = new Dwarf("a",new DataTerceiraEra(1,1,1));
        assertEquals(110, gimli.getVida());
    }

    @Test public void dwarfRecebeFlechadaEPerde10DeVida() {
        Dwarf gimli = new Dwarf("a",new DataTerceiraEra(1,1,1));
        gimli.receberFlechada();
        assertEquals(100, gimli.getVida());
    }

    @Test public void dwarfRecebe11FlechadaEPerde110DeVida() {
        Dwarf gimli = new Dwarf("a",new DataTerceiraEra(1,1,1));
        for (int i = 0; i < 11; i++){
            gimli.receberFlechada();
        }
        assertEquals(0, gimli.getVida());
    }

     @Test public void dwarfRecebe7FlechadaEPerde70DeVida() {
        Dwarf gimli = new Dwarf("a",new DataTerceiraEra(1,1,1));
        for (int i = 0; i < 7; i++){
            gimli.receberFlechada();
        }
        assertEquals(40, gimli.getVida());
    }
    
    @Test
    public void dwarfSortudoRecebe7FlechadaESoPerde20VidaEGanha10Experiencia() {
        Dwarf dwarf = new Dwarf("Elias",new DataTerceiraEra(3,11,2000));
        for (int i = 0; i < 7; i++){ dwarf.receberFlechada(); }        
        assertEquals(-3333, dwarf.getNumeroSorte(), 1e-15);
        assertEquals(90, dwarf.getVida());
        assertEquals(10, dwarf.getExperiencia());
    }
    
    @Test
    public void dwarfSortudoRecebe7FlechadaENaoPerdeVidaEMasNaoGanhaExperiencia() {
        Dwarf dwarf = new Dwarf("Seixas",new DataTerceiraEra(3,11,2001));
        for (int i = 0; i < 7; i++){ dwarf.receberFlechada(); }        
        assertEquals(33, dwarf.getNumeroSorte(), 1e-15);
        assertEquals(110, dwarf.getVida());
        assertEquals(0, dwarf.getExperiencia());
    }
    
    @Test
    public void dwarfNasceVivoComVida110() {
        Dwarf dwarf = new Dwarf("a",new DataTerceiraEra(1,1,1));
        
        assertEquals(Status.VIVO, dwarf.getStatus());
        assertEquals(110, dwarf.getVida());
    }
    
     @Test
    public void dwarfNasceVivoELevaDanoEMorreComVida0() {
        Dwarf dwarf = new Dwarf("a",new DataTerceiraEra(1,1,1));
        for( int i = 0; i < 11; i++) { dwarf.receberFlechada(); }
        
        assertEquals(Status.MORTO, dwarf.getStatus());
        assertEquals(0, dwarf.getVida());
    }
    
     @Test
    public void dwarfNasceVivoELevaDanoENaoMorreVida50() {
        Dwarf dwarf = new Dwarf("a",new DataTerceiraEra(1,1,1));
        for( int i = 0; i < 6; i++) { dwarf.receberFlechada(); }
        
        assertEquals(Status.VIVO, dwarf.getStatus());
        assertEquals(50, dwarf.getVida());
    }
    
    @Test
    public void dwarfNasceVivoELevaOverkillVida00() {
        Dwarf dwarf = new Dwarf("a",new DataTerceiraEra(1,1,1));
        for( int i = 0; i < 20; i++) { dwarf.receberFlechada(); }
        assertEquals(Status.MORTO, dwarf.getStatus());
        assertEquals(0, dwarf.getVida());
    }
    
    @Test
    public void dwarfNasceComNome() {
        Dwarf dwarf = new Dwarf("Elias",new DataTerceiraEra(1,1,1));
        
        assertEquals("Elias", dwarf.getNome());
    }
    
    @Test
    public void dwarfNasceComDataDefinida() {
        Dwarf dwarf = new Dwarf("Elias",new DataTerceiraEra(3,11,1915));
        DataTerceiraEra data = dwarf.getDataNascimento();
        assertEquals("03/11/1915", data.getData());
    }
    
    @Test
    public void dwarfNasceComDataPadrao() {
        Dwarf dwarf = new Dwarf("Elias");
        DataTerceiraEra data = dwarf.getDataNascimento();
        assertEquals("01/01/1", data.getData());
    }
    
    @Test
    public void dwarfQualquerComSortePadrão101() {
        Dwarf dwarf = new Dwarf("Elias",new DataTerceiraEra(3,11,1915));
        assertEquals(101.0, dwarf.getNumeroSorte(), 1e-15);
    }
    
    @Test
    public void dwarfSortudoEnre80E90DeVidaEAnoBissextoComSorteMenos33333() {
        Dwarf dwarf = new Dwarf("Elias",new DataTerceiraEra(3,11,2000));
        dwarf.receberFlechada();
        dwarf.receberFlechada();
        assertEquals(-3333, dwarf.getNumeroSorte(), 1e-15);
        assertEquals(90, dwarf.getVida());
    }
    
    @Test
    public void dwarfSortudoComMaisDe90DeVidaEAnoBissextoComSorte101() {
        Dwarf dwarf = new Dwarf("Elias",new DataTerceiraEra(3,11,2000));
        dwarf.receberFlechada();        
        assertEquals(101, dwarf.getNumeroSorte(), 1e-15);
        assertEquals(100, dwarf.getVida());
    }
    
    @Test
    public void dwarfSortudoComMenosDe80DeVidaEAnoBissextoComSorteMenos33333() {
        Dwarf dwarf = new Dwarf("Elias",new DataTerceiraEra(3,11,2000));
        dwarf.receberFlechadaHacker();
        dwarf.receberFlechada();       
        assertEquals(101, dwarf.getNumeroSorte(), 1e-15);
        assertEquals(50, dwarf.getVida());
    }
    
    @Test
    public void dwarfSeixasEAnoNaoBissextoComSorte133() {
        Dwarf dwarf = new Dwarf("Seixas",new DataTerceiraEra(3,11,2001));     
        assertEquals(33, dwarf.getNumeroSorte(), 1e-15);
    }
    
    @Test
    public void dwarfSeixasEAnoBissextoComSorte1101() {
        Dwarf dwarf = new Dwarf("Seixas",new DataTerceiraEra(3,11,2000));     
        assertEquals(101, dwarf.getNumeroSorte(), 1e-15);
    }
    
    @Test
    public void dwarfMeirelesEAnoNaoBissextoComSorte133() {
        Dwarf dwarf = new Dwarf("Meireles",new DataTerceiraEra(3,11,2001));     
        assertEquals(33, dwarf.getNumeroSorte(), 1e-15);
    }
    
    @Test
    public void dwarfMeirelesEAnoBissextoComSorte1101() {
        Dwarf dwarf = new Dwarf("Meireles",new DataTerceiraEra(3,11,2000));     
        assertEquals(101, dwarf.getNumeroSorte(), 1e-15);
    }
    
    @Test
    public void dwarfDwarfEAnoNaoBissextoComSorte1101() {
        Dwarf dwarf = new Dwarf("Dwarf",new DataTerceiraEra(3,11,2001));     
        assertEquals(101, dwarf.getNumeroSorte(), 1e-15);
    }
    
    @Test
    public void dwarfNullNaoBissextoSorte101() {
        Dwarf dwarf = new Dwarf(null ,new DataTerceiraEra(3,11,2001));     
        assertEquals(101, dwarf.getNumeroSorte(), 1e-15);
    }
    
}
