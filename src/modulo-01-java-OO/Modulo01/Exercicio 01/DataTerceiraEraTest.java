

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class  DataTerceiraEraTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class DataTerceiraEraTest
{
    @Test
    public void ano2000Bissexto() {
        DataTerceiraEra teste = new DataTerceiraEra(1,1,2000);
        assertEquals(true, teste.ehBissexto());
    }
    
    @Test
    public void ano2100NaoBissexto() {
        DataTerceiraEra teste = new DataTerceiraEra(1,1,2100);
        assertEquals(false, teste.ehBissexto());
    }
    
    @Test
    public void ano2002NaoBissexto() {
        DataTerceiraEra teste = new DataTerceiraEra(1,1,2002);
        assertEquals(false, teste.ehBissexto());
    }
    
    @Test
    public void mostrandoDataDaTerceiraEraMesMenorQue10() {
        DataTerceiraEra teste = new DataTerceiraEra(10,5,2002);
        assertEquals("10/05/2002", teste.getData());
    }
    
    @Test
    public void mostrandoDataDaTerceiraEraDiaMenorQue10() {
        DataTerceiraEra teste = new DataTerceiraEra(5,10,2002);
        assertEquals("05/10/2002", teste.getData());
    }
}
