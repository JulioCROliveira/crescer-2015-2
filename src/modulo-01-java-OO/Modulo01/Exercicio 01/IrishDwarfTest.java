

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class IrishDwarfTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class IrishDwarfTest
{
    @Test
    public void irishDwarfSortudoTentaSorte() {
        IrishDwarf dwarf = new IrishDwarf("Dwarfino", new DataTerceiraEra(1,1,2004));
        Item item1 = new Item("poção",3);
        Item item2 = new Item("moedas",4);
                
        dwarf.getInventario().adicionarItem(item1);
        dwarf.getInventario().adicionarItem(item2);
        
        dwarf.receberFlechada();
        dwarf.receberFlechada();
        dwarf.tentarSorte();
        
        assertEquals(6003,  dwarf.getInventario().getItem(0).getQuantidade());
        assertEquals(10004,  dwarf.getInventario().getItem(1).getQuantidade());
    }
    
    @Test
    public void dwarfSortudoTentaSorte2() {
        IrishDwarf dwarf = new IrishDwarf("Dwarfino", new DataTerceiraEra(1,1,2004));
        Item item1 = new Item("poção",10);
        Item item2 = new Item("moedas",1);
                
        dwarf.getInventario().adicionarItem(item1);
        dwarf.getInventario().adicionarItem(item2);
        
        dwarf.receberFlechada();
        dwarf.receberFlechada();
        dwarf.tentarSorte();
                
        assertEquals(55010,  dwarf.getInventario().getItem(0).getQuantidade());
        assertEquals(1001,  dwarf.getInventario().getItem(1).getQuantidade());
    }
    
    @Test
    public void irishDwarfSortudoTentaSorteSemSucesso() {
        IrishDwarf dwarf = new IrishDwarf("Dwarfino", new DataTerceiraEra(1,1,2014));
        Item item1 = new Item("poção",3);
        Item item2 = new Item("moedas",4);
                
        dwarf.getInventario().adicionarItem(item1);
        dwarf.getInventario().adicionarItem(item2);
        
        dwarf.receberFlechada();
        dwarf.receberFlechada();
        dwarf.tentarSorte();
        
        assertEquals(3,  dwarf.getInventario().getItem(0).getQuantidade());
        assertEquals(4,  dwarf.getInventario().getItem(1).getQuantidade());
    }
}
