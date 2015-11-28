package br.com.cwi.crescer.lavanderia.mapper;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.lavanderia.domain.Produto;
import br.com.cwi.crescer.lavanderia.dto.produto.ProdutoListagemDTO;

public class ProdutoListagemMapper {

    @Autowired
    public static Produto getNewEntity(ProdutoListagemDTO dto) {
        Produto entity = new Produto();
        entity.setIdProduto(dto.getIdProduto());
        entity.setPrazo(dto.getPrazo());
        entity.setValor(dto.getValor());
        entity.setSituacao(dto.getSituacao());
        return entity;
    }

    public static ProdutoListagemDTO toDTO(Produto entity) {
        ProdutoListagemDTO dto = new ProdutoListagemDTO();
        dto.setIdProduto(entity.getIdProduto());
        dto.setMaterial(entity.getMaterial().getDescricao());
        dto.setServico(entity.getServico().getDescricao());
        dto.setPrazo(entity.getPrazo());
        dto.setValor(entity.getValor());
        dto.setSituacao(entity.getSituacao());
        return dto;
    }

    public static Produto merge(ProdutoListagemDTO dto, Produto entity) {
        entity.setIdProduto(dto.getIdProduto());
        entity.setPrazo(dto.getPrazo());
        entity.setValor(dto.getValor());
        entity.setSituacao(dto.getSituacao());
        return entity;
    }
}
