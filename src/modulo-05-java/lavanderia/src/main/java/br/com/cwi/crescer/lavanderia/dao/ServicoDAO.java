package br.com.cwi.crescer.lavanderia.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.lavanderia.domain.Servico;

@Repository
public class ServicoDAO extends AbstractDAO {

    public Servico findById(Long id) {
        return em.find(Servico.class, id);
    }

    public List<Servico> listAll() {
        return em.createQuery("FROM Servico c")
                .getResultList();
    }
}
