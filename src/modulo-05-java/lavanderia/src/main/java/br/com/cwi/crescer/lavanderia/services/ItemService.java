package br.com.cwi.crescer.lavanderia.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.cwi.crescer.lavanderia.dao.ItemDAO;
import br.com.cwi.crescer.lavanderia.domain.Item;
import br.com.cwi.crescer.lavanderia.dto.item.ItemDTO;
import br.com.cwi.crescer.lavanderia.mapper.ItemMapper;

@Service
public class ItemService {

    private ItemDAO itemDAO;

    public ItemService(ItemDAO itemDAO) {
        this.itemDAO = itemDAO;
    }

    public List<ItemDTO> retornarItensDePedido(Long idPedido) {
        List<Item> itens = itemDAO.listAllWhereIdPedido(idPedido);
        List<ItemDTO> dtos = new ArrayList<ItemDTO>();

        for (Item item : itens) {
            dtos.add(ItemMapper.toDTO(item));
        }

        return dtos;
    }

}
