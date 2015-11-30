package br.com.cwi.crescer.lavanderia.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.lavanderia.AbstractInfrastructureTest;
import br.com.cwi.crescer.lavanderia.domain.Item;
import br.com.cwi.crescer.lavanderia.domain.Item.SituacaoItem;

public class ItemDAOTest extends AbstractInfrastructureTest {

    @Autowired
    private ItemDAO itemDAO;

    @Test
    public void deveBuscarPedidoPorId() throws Exception {
        Item item = itemDAO.findById(1L);
        Assert.assertNotNull(item);
    }

    @Test
    public void deveBuscarPedidoPorIdComPedido() throws Exception {
        Item item = itemDAO.findById(1L);
        Assert.assertNotNull(item);
        Assert.assertNotNull(item.getPedido());
    }

    @Test
    public void deveBuscarPedidoPorIdComProduto() throws Exception {
        Item item = itemDAO.findById(1L);
        Assert.assertNotNull(item);
        Assert.assertNotNull(item.getProduto());
    }

    @Test
    public void deveBuscarItensPendentes() throws Exception {
        List<Item> itens = itemDAO.findBySituacao(SituacaoItem.PENDENTE);
        Assert.assertNotNull(itens);
        Assert.assertFalse(itens.isEmpty());

        for (Item item : itens) {
            Assert.assertEquals(SituacaoItem.PENDENTE, item.getSituacao());
        }
    }

    @Test
    public void listAllItensTeste() throws Exception {
        List<Item> itens = itemDAO.listAll();
        Assert.assertNotNull(itens);
        Assert.assertFalse(itens.isEmpty());
    }

    @Test
    public void listAllItensDoPedidoUm() throws Exception {
        List<Item> itens = itemDAO.listAllWhereIdPedido(1L);
        Assert.assertNotNull(itens);
        Assert.assertFalse(itens.isEmpty());

        for (Item item : itens) {
            Assert.assertEquals("1", item.getPedido().getIdPedido().toString());
        }
    }
}
