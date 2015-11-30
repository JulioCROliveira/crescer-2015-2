package br.com.cwi.crescer.lavanderia.mapper.pedido;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.lavanderia.domain.Pedido;
import br.com.cwi.crescer.lavanderia.dto.pedido.PedidoDTO;

public class PedidoMapper {

    @Autowired
    public static Pedido getNewEntity(PedidoDTO dto) {
        Pedido entity = new Pedido();
        entity.setIdPedido(dto.getIdPedido());
        entity.setDataInclusao(dto.getDataInclusao());
        entity.setValorFinal(new BigDecimal(dto.getValorFinal()));
        entity.setSituacao(dto.getSituacao());
        entity.setDataEntrega(dto.getDataEntrega());
        entity.setValorBruto(new BigDecimal(dto.getValorBruto()));
        entity.setValorDesconto(new BigDecimal(dto.getValorDesconto()));

        return entity;
    }

    public static PedidoDTO toDTO(Pedido entity) {
        PedidoDTO dto = new PedidoDTO();
        dto.setIdPedido(entity.getIdPedido());
        dto.setIdCliente(entity.getCliente().getIdCliente());
        dto.setDataInclusao(entity.getDataInclusao());
        dto.setValorFinal(entity.getValorFinal().toString());
        dto.setSituacao(entity.getSituacao());
        dto.setDataEntrega(entity.getDataEntrega());
        dto.setValorBruto(entity.getValorBruto().toString());
        dto.setValorDesconto(entity.getValorDesconto().toString());

        return dto;
    }

    public static Pedido merge(PedidoDTO dto, Pedido entity) {
        entity.setIdPedido(dto.getIdPedido());
        entity.setDataInclusao(dto.getDataInclusao());
        entity.setValorFinal(new BigDecimal(dto.getValorFinal()));
        entity.setSituacao(dto.getSituacao());
        entity.setDataEntrega(dto.getDataEntrega());
        entity.setValorBruto(new BigDecimal(dto.getValorBruto()));
        entity.setValorDesconto(new BigDecimal(dto.getValorDesconto()));

        return entity;
    }
}
