package br.com.cwi.crescer.lavanderia.services;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.cwi.crescer.lavanderia.dao.ClienteDAO;
import br.com.cwi.crescer.lavanderia.dao.ItemDAO;
import br.com.cwi.crescer.lavanderia.dao.PedidoDAO;
import br.com.cwi.crescer.lavanderia.domain.Cliente;
import br.com.cwi.crescer.lavanderia.domain.Pedido;
import br.com.cwi.crescer.lavanderia.dto.pedido.PedidoListagemDTO;


public class PedidoServiceTest {

    @InjectMocks
    private PedidoService pedidoService;

    @Mock
    private PedidoDAO pedidoDAO;

    @Mock
    private ItemDAO itemDAO;

    @Mock
    private ClienteDAO clienteDAO;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void buscarTodosVemComCPFeNomeCliente() {

        List<Pedido> ListaDePedidos = new ArrayList<Pedido>();
        Pedido pedido1 = new Pedido();
        Cliente cliente = new Cliente();
        cliente.setIdCliente(1L);
        pedido1.setCliente(cliente);
        ListaDePedidos.add(pedido1);
        Mockito.when(pedidoDAO.listAll()).thenReturn(ListaDePedidos);
        Cliente clienteRetorno = new Cliente();
        clienteRetorno.setNome("teste");
        clienteRetorno.setCpf("CPFTeste");
        Mockito.when(clienteDAO.findById(1L)).thenReturn(clienteRetorno);

        this.pedidoService = pedidoService;
        List<PedidoListagemDTO> pedidos = pedidoService.listarTodosPedidos();
        Assert.assertNotNull(pedidos);
        Assert.assertFalse(pedidos.isEmpty());

        for (PedidoListagemDTO pedido : pedidos) {
            Assert.assertTrue("Teste".equals(pedido.getNomeCliente()));
            Assert.assertTrue("CPFTeste".equals(pedido.getCpf()));
        }

    }
}
