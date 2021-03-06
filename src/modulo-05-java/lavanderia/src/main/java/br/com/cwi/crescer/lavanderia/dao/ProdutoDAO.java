package br.com.cwi.crescer.lavanderia.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.cwi.crescer.lavanderia.domain.Produto;

@Repository
public class ProdutoDAO extends AbstractDAO {

    public Produto findById(Long id) {
        return em.find(Produto.class, id);
    }

    public List<Produto> listAll() {
        return em.createQuery("FROM Produto p")
                .getResultList();
    }

    @Transactional
    public Produto save(Produto produto) {

        if (produto.getIdProduto() == null) {
            em.persist(produto);
            return produto;
        }

        return em.merge(produto);
    }

}
