package br.com.cwi.crescer.lavanderia.mapper.produto;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.lavanderia.domain.Produto;
import br.com.cwi.crescer.lavanderia.dto.produto.ProdutoEdicaoDTO;

public class ProdutoEdicaoMapper {

    @Autowired
    public static Produto getNewEntity(ProdutoEdicaoDTO dto) {
        Produto entity = new Produto();
        entity.setIdProduto(dto.getIdProduto());
        entity.setPrazo(dto.getPrazo());
        entity.setValor(dto.getValor());
        entity.setSituacao(dto.getSituacao());
        return entity;
    }

    public static ProdutoEdicaoDTO toDTO(Produto entity) {
        ProdutoEdicaoDTO dto = new ProdutoEdicaoDTO();
        dto.setIdProduto(entity.getIdProduto());
        dto.setPrazo(entity.getPrazo());
        dto.setValor(entity.getValor());
        dto.setSituacao(entity.getSituacao());
        return dto;
    }

    public static Produto merge(ProdutoEdicaoDTO dto, Produto entity) {
        entity.setIdProduto(dto.getIdProduto());
        entity.setPrazo(dto.getPrazo());
        entity.setValor(dto.getValor());
        entity.setSituacao(dto.getSituacao());
        return entity;
    }
}
