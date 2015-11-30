package br.com.cwi.crescer.lavanderia.mapper;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.lavanderia.domain.Item;
import br.com.cwi.crescer.lavanderia.dto.item.ItemDTO;

public class ItemMapper {

    @Autowired
    public static Item getNewEntity(ItemDTO dto) {
        Item entity = new Item();
        entity.setIdItem(dto.getIdItem());
        entity.setPeso(dto.getPeso());
        entity.setSituacao(dto.getSituacao());
        entity.setValorTotal(dto.getValorTotal());
        entity.setValorUnitario(new BigDecimal(dto.getValorUnitario()));
        return entity;
    }

    public static ItemDTO toDTO(Item entity) {
        ItemDTO dto = new ItemDTO();
        dto.setIdItem(entity.getIdItem());
        dto.setIdPedido(entity.getPedido().getIdPedido());
        dto.setIdProduto(entity.getProduto().getIdProduto());
        dto.setPeso(entity.getPeso());
        dto.setSituacao(entity.getSituacao());
        dto.setValorTotal(entity.getValorTotal());
        dto.setValorUnitario(entity.getValorUnitario().toString());
        dto.setServico(entity.getProduto().getServico().getDescricao());
        dto.setMaterial(entity.getProduto().getMaterial().getDescricao());

        return dto;
    }

    public static Item merge(ItemDTO dto, Item entity) {
        entity.setIdItem(dto.getIdItem());
        entity.setPeso(dto.getPeso());
        entity.setSituacao(dto.getSituacao());
        entity.setValorTotal(dto.getValorTotal());
        entity.setValorUnitario(new BigDecimal(dto.getValorUnitario()));

        return entity;
    }
}
