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
}
