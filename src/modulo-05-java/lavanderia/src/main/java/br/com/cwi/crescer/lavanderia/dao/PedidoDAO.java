package br.com.cwi.crescer.lavanderia.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.lavanderia.domain.Item;
import br.com.cwi.crescer.lavanderia.domain.Pedido;
import br.com.cwi.crescer.lavanderia.domain.Pedido.SituacaoPedido;

@Repository
public class PedidoDAO extends AbstractDAO {

    public Pedido findById(Long id) {
        return em.find(Pedido.class, id);
    }

    public List<Pedido> findBySituacao(SituacaoPedido situacao) {
        return em.createQuery("FROM Pedido c WHERE c.situacao = :situacao", Pedido.class)
                .setParameter("situacao", situacao)
                .getResultList();
    }

    public List<Pedido> listAll() {
        return em.createQuery("FROM Pedido c", Pedido.class)
                .getResultList();
    }

    public void processPedido(Long idPedido) {
        em.createQuery("UPDATE Pedido SET situacao = :situacao WHERE IDPedido = :idPedido")
        .setParameter("situacao", Pedido.SituacaoPedido.PROCESSADO)
        .setParameter("idPedido", idPedido)
        .executeUpdate();
    }

    public int getActiveItens(Long idPedido) {
        List<Item> contador = em.createQuery("FROM Item i WHERE pedido = :idPedido and situacao = :situacao")
                .setParameter("situacao", Item.SituacaoItem.PENDENTE)
                .setParameter("idPedido", idPedido)
                .getResultList();
        int size = contador.size();
        return size;
    }

    public void cancelPedido(Long idPedido) {
        em.createQuery("UPDATE Pedido SET situacao = :situacao WHERE IDPedido = :idPedido")
        .setParameter("situacao", Pedido.SituacaoPedido.CANCELADO)
                .setParameter("idPedido", idPedido)
        .executeUpdate();
    }

    public void recoverPedido(Long idPedido) {
        em.createQuery("UPDATE Pedido SET situacao = :situacao WHERE IDPedido = :idPedido")
        .setParameter("situacao", Pedido.SituacaoPedido.ENCERRADO)
        .setParameter("idPedido", idPedido)
        .executeUpdate();
    }
}
