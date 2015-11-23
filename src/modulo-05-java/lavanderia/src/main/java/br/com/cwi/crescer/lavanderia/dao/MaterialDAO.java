package br.com.cwi.crescer.lavanderia.dao;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.lavanderia.domain.Material;

@Repository
public class MaterialDAO extends AbstractDAO {

    public Material findById(Long id) {
        return em.find(Material.class, id);
    }
}
