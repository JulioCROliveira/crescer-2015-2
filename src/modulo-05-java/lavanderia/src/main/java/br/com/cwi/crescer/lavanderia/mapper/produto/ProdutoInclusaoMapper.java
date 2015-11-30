package br.com.cwi.crescer.lavanderia.mapper.produto;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.lavanderia.domain.Produto;
import br.com.cwi.crescer.lavanderia.dto.produto.ProdutoInclusaoDTO;

public class ProdutoInclusaoMapper {

    @Autowired
    public static Produto getNewEntity(ProdutoInclusaoDTO dto) {
        Produto entity = new Produto();
        entity.setPrazo(dto.getPrazo());
        entity.setValor(dto.getValor());
        return entity;
    }

    public static ProdutoInclusaoDTO toDTO(Produto entity) {
        ProdutoInclusaoDTO dto = new ProdutoInclusaoDTO();
        dto.setIdMaterial(entity.getMaterial().getIdMaterial());
        dto.setIdServico(entity.getServico().getIdServico());
        dto.setPrazo(entity.getPrazo());
        dto.setValor(entity.getValor());
        return dto;
    }

    public static Produto merge(ProdutoInclusaoDTO dto, Produto entity) {
        entity.setPrazo(dto.getPrazo());
        entity.setValor(dto.getValor());
        return entity;
    }
}
