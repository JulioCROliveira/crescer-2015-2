package br.com.cwi.crescer.lavanderia.dao;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.lavanderia.domain.Cidade;

@Repository
public class CidadeDAO extends AbstractDAO {

    public Cidade findById (Long id) {
        return this.em.find(Cidade.class, id);
    }
}
