package br.com.cwi.crescer.lavanderia.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.lavanderia.AbstractInfrastructureTest;
import br.com.cwi.crescer.lavanderia.domain.Material;

public class MaterialDAOTest extends AbstractInfrastructureTest {

    @Autowired
    private MaterialDAO materialDAO;

    @Test
    public void deveBuscarMaterialPorId() throws Exception {
        Material material = materialDAO.findById(1L);
        Assert.assertNotNull(material);
    }

    @Test
    public void deveBuscarTodosMateriais() throws Exception {
        List<Material> materiais = materialDAO.listAll();
        Assert.assertNotNull(materiais);
        Assert.assertFalse(materiais.isEmpty());
    }
}
