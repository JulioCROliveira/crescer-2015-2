

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ClienteTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ClienteTest
{
    @Test
    public void criandoCliente() {
        Cliente cliente = new Cliente("Júlio", "Rua Pedro...", "555 444");
        
        assertEquals("Júlio", cliente.getNome());
        assertEquals("Rua Pedro...", cliente.getEndereco());
        assertEquals("555 444", cliente.getTelefone());
    }
    
    @Test
    public void criandoClienteComNull() {
        Cliente cliente = new Cliente("Júlio", "Rua Pedro...", null);
        
        assertEquals("Falha ao informar cliente", cliente.getNome());
        assertEquals("", cliente.getEndereco());
        assertEquals("", cliente.getTelefone());
    }
}
