package br.com.cwi.crescer.lavanderia.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.lavanderia.AbstractInfrastructureTest;
import br.com.cwi.crescer.lavanderia.domain.Produto;

public class ProdutoDAOTest extends AbstractInfrastructureTest {

    @Autowired
    private ProdutoDAO produtoDAO;

    @Test
    public void deveBuscarProdutoPorId() throws Exception {
        Produto produto = produtoDAO.findById(1L);
        Assert.assertNotNull(produto);
    }

    @Test
    public void deveBuscarProdutoPorIdComServico() throws Exception {
        Produto produto = produtoDAO.findById(1L);
        Assert.assertNotNull(produto);
        Assert.assertNotNull(produto.getServico());
    }

    @Test
    public void deveBuscarProdutoPorIdComMaterial() throws Exception {
        Produto produto = produtoDAO.findById(1L);
        Assert.assertNotNull(produto);
        Assert.assertNotNull(produto.getMaterial());
    }

    @Test
    public void deveBuscarTodosProdutos() throws Exception {
        List<Produto> produtos = produtoDAO.listAll();
        Assert.assertNotNull(produtos);
        Assert.assertFalse(produtos.isEmpty());
    }
}
