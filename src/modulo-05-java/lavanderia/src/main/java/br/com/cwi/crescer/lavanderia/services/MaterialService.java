package br.com.cwi.crescer.lavanderia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.lavanderia.dao.MaterialDAO;
import br.com.cwi.crescer.lavanderia.domain.Material;

@Service
public class MaterialService {

    private MaterialDAO materialDAO;

    @Autowired
    public MaterialService(MaterialDAO materialDAO) {
        this.materialDAO = materialDAO;
    }

    public List<Material> listar(Long idServico) {
        List<Material> listar = materialDAO.listAllWhereDontcontainsServico(idServico);
        if (listar.isEmpty()) {
            Material nulo = new Material();
            nulo.setDescricao("Nenhum material disponivel para este serviço");
            nulo.setIdMaterial(null);
            listar.add(nulo);
        }

        return listar;
    }

}
