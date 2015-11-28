package br.com.cwi.crescer.lavanderia.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.lavanderia.AbstractInfrastructureTest;
import br.com.cwi.crescer.lavanderia.domain.Servico;

public class ServicoDAOTest extends AbstractInfrastructureTest {

    @Autowired
    private ServicoDAO servicoDAO;

    @Test
    public void deveBuscarServicoPorId() throws Exception {
        Servico servico = servicoDAO.findById(1L);
        Assert.assertNotNull(servico);
    }

    @Test
    public void deveBuscarTodosServicos() throws Exception {
        List<Servico> servicos = servicoDAO.listAll();
        Assert.assertNotNull(servicos);
        Assert.assertFalse(servicos.isEmpty());
    }
}
