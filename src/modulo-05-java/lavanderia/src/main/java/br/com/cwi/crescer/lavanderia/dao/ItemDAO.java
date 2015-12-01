package br.com.cwi.crescer.lavanderia.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.lavanderia.domain.Item;
import br.com.cwi.crescer.lavanderia.domain.Item.SituacaoItem;

@Repository
public class ItemDAO extends AbstractDAO {

    public Item findById(Long id) {
        return em.find(Item.class, id);
    }

    public List<Item> findBySituacao(SituacaoItem situacao) {
        return em.createQuery("FROM Item c WHERE c.situacao = :situacao", Item.class)
                .setParameter("situacao", situacao)
                .getResultList();
    }

    public List<Item> listAll() {
        return em.createQuery("FROM Item i", Item.class)
                .getResultList();
    }

    public List<Item> listAllWhereIdPedido(Long idPedido) {
        return em.createQuery("FROM Item i WHERE IDPedido = :idPedido", Item.class)
                .setParameter("idPedido", idPedido)
                .getResultList();
    }

    public void processAllItensFromPedido(Long idPedido) {
        em.createQuery("UPDATE Item SET situacao = :situacao WHERE idPedido = :idPedido")
        .setParameter("situacao", Item.SituacaoItem.PROCESSADO)
        .setParameter("idPedido", idPedido)
        .executeUpdate();

    }

    public void processItem(Long idItem) {
        em.createQuery("UPDATE Item SET situacao = :situacao WHERE idItem = :idItem")
        .setParameter("situacao", Item.SituacaoItem.PROCESSADO)
        .setParameter("idItem", idItem)
        .executeUpdate();
    }
}
