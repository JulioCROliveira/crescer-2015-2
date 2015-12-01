package br.com.cwi.crescer.lavanderia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cwi.crescer.lavanderia.dao.ItemDAO;
import br.com.cwi.crescer.lavanderia.dao.PedidoDAO;
import br.com.cwi.crescer.lavanderia.dto.pedido.PedidoDTO;

@Service
public class ItemService {

    private ItemDAO itemDAO;
    private PedidoDAO pedidoDAO;

    @Autowired
    public ItemService(ItemDAO itemDAO, PedidoDAO pedidoDAO) {
        this.itemDAO = itemDAO;
        this.pedidoDAO = pedidoDAO;
    }

    @Transactional
    public void processarTodosItensDoPedido(PedidoDTO dto) {
        itemDAO.processAllItensFromPedido(dto.getIdPedido());
        processarPedido(dto.getIdPedido());
    }

    @Transactional
    public void processarItemDoPedido(Long idItem, PedidoDTO dto) {
        itemDAO.processItem(idItem);

        int contaAtivos = pedidoDAO.getActiveItens(dto.getIdPedido());
        if (contaAtivos == 0) {
            processarPedido(dto.getIdPedido());
        }
    }

    private void processarPedido(Long idPedido) {
        pedidoDAO.processPedido(idPedido);
    }

}
