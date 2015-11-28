package br.com.cwi.crescer.lavanderia.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.lavanderia.domain.Material;

@Repository
public class MaterialDAO extends AbstractDAO {

    public Material findById(Long id) {
        return em.find(Material.class, id);
    }

    public List<Material> listAll() {
        return em.createQuery("FROM Material p")
                .getResultList();
    }

    public List<Material> listAllWhereDontcontainsServico(Long idServico) {
        return em.createQuery("SELECT m FROM Material m "
                + "WHERE idMaterial not in(SELECT material FROM Produto WHERE IDSERVICO = :idServico)")
                .setParameter("idServico", idServico)
                .getResultList();
    }
}
