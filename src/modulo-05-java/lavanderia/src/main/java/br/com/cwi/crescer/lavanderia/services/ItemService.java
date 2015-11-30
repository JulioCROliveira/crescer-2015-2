package br.com.cwi.crescer.lavanderia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cwi.crescer.lavanderia.dao.ItemDAO;
import br.com.cwi.crescer.lavanderia.dto.pedido.PedidoDTO;

@Service
public class ItemService {

    private ItemDAO itemDAO;

    @Autowired
    public ItemService(ItemDAO itemDAO) {
        this.itemDAO = itemDAO;
    }

    @Transactional
    public void processarTodosItensDoPedido(PedidoDTO dto) {
        itemDAO.proccessAllItensFromPedido(dto.getIdPedido());
        // todo: processar pedido
    }

    @Transactional
    public void processarItemDoPedido(Long idItem) {
        itemDAO.proccessItem(idItem);
        // todo: verifica processar pedido
    }

}
