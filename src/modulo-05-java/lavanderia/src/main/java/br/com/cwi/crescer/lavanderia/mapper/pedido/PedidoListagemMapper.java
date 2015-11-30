package br.com.cwi.crescer.lavanderia.mapper.pedido;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.lavanderia.domain.Pedido;
import br.com.cwi.crescer.lavanderia.dto.pedido.PedidoListagemDTO;

public class PedidoListagemMapper {

    @Autowired
    public static Pedido getNewEntity(PedidoListagemDTO dto) {
        Pedido entity = new Pedido();
        entity.setIdPedido(dto.getIdPedido());
        entity.setDataInclusao(dto.getDataInclusao());
        entity.setValorFinal(new BigDecimal(dto.getValorTotal()));
        entity.setSituacao(dto.getSituacao());
        return entity;
    }

    public static PedidoListagemDTO toDTO(Pedido entity) {
        PedidoListagemDTO dto = new PedidoListagemDTO();
        dto.setIdPedido(entity.getIdPedido());
        dto.setIdCliente(entity.getCliente().getIdCliente());
        dto.setDataInclusao(entity.getDataInclusao());
        dto.setValorTotal(entity.getValorFinal().toString());
        dto.setSituacao(entity.getSituacao());
        return dto;
    }

    public static Pedido merge(PedidoListagemDTO dto, Pedido entity) {
        entity.setIdPedido(dto.getIdPedido());
        entity.setDataInclusao(dto.getDataInclusao());
        entity.setValorFinal(new BigDecimal(dto.getValorTotal()));
        entity.setSituacao(dto.getSituacao());
        return entity;
    }
}
