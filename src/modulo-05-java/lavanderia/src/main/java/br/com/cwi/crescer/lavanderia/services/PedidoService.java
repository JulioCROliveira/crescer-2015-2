package br.com.cwi.crescer.lavanderia.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.lavanderia.dao.ClienteDAO;
import br.com.cwi.crescer.lavanderia.dao.PedidoDAO;
import br.com.cwi.crescer.lavanderia.domain.Pedido;
import br.com.cwi.crescer.lavanderia.dto.pedido.PedidoDTO;
import br.com.cwi.crescer.lavanderia.dto.pedido.PedidoListagemDTO;
import br.com.cwi.crescer.lavanderia.mapper.pedido.PedidoListagemMapper;
import br.com.cwi.crescer.lavanderia.mapper.pedido.PedidoMapper;

@Service
public class PedidoService {

    private PedidoDAO pedidoDAO;
    private ClienteDAO clienteDAO;

    @Autowired
    public PedidoService(PedidoDAO pedidoDAO, ClienteDAO clienteDAO) {
        this.pedidoDAO = pedidoDAO;
        this.clienteDAO = clienteDAO;
    }

    public PedidoDTO buscarPedidoPorId(Long id) {
        return PedidoMapper.toDTO(pedidoDAO.findById(id));
    }

    public List<PedidoListagemDTO> listarTodosPedidos() {
        List<Pedido> pedidos = pedidoDAO.listAll();
        List<PedidoListagemDTO> dtos = new ArrayList<PedidoListagemDTO>();

        for (Pedido pedido : pedidos) {
            PedidoListagemDTO dto = PedidoListagemMapper.toDTO(pedido);
            dto.setCpf(clienteDAO.findById(dto.getIdCliente()).getCpf());
            dto.setNomeCliente(clienteDAO.findById(dto.getIdCliente()).getNome());
            dtos.add(dto);
        }

        return dtos;
    }

}
