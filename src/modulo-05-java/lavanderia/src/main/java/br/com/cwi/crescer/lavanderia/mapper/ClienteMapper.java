package br.com.cwi.crescer.lavanderia.mapper;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.lavanderia.domain.Cliente;
import br.com.cwi.crescer.lavanderia.dto.cliente.ClienteDTO;

public class ClienteMapper {

    @Autowired
    public static Cliente getNewEntity(ClienteDTO dto) {
        Cliente entity = new Cliente();
        entity.setNome(dto.getNome());
        entity.setCpf(dto.getCpf());
        entity.setEmail(dto.getEmail());
        entity.setEndereco(dto.getEndereco());
        entity.setBairro(dto.getBairro());
        entity.setCep(dto.getCep());
        return entity;
    }

    public static ClienteDTO toDTO(Cliente entity) {
        ClienteDTO dto = new ClienteDTO();
        dto.setId(entity.getIdCliente());
        dto.setNome(entity.getNome());
        dto.setCpf(entity.getCpf());
        dto.setEmail(entity.getEmail());
        dto.setEndereco(entity.getEndereco());
        dto.setIdCidade(entity.getCidade().getIdCidade());
        dto.setBairro(entity.getBairro());
        dto.setCep(entity.getCep());
        dto.setSituacao(entity.getSituacao());
        return dto;
    }

    public static Cliente merge(ClienteDTO dto, Cliente entity) {
        entity.setNome(dto.getNome());
        entity.setCpf(dto.getCpf());
        entity.setEmail(dto.getEmail());
        entity.setEndereco(dto.getEndereco());
        entity.setBairro(dto.getBairro());
        entity.setCep(dto.getCep());
        return entity;
    }

}
