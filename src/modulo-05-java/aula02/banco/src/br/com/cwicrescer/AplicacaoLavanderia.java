package br.com.cwicrescer;

import java.sql.SQLException;
import java.util.List;

import br.com.cwicrescer.dao.ClienteDao;
import br.com.cwicrescer.model.Cliente;

public class AplicacaoLavanderia {

    public static void main(String[] args) throws SQLException {
        ClienteDao clienteDao = new ClienteDao();
        List<Cliente> lista = clienteDao.listAll();

        for (Cliente cliente : lista) {
            System.out.println(cliente.getNmCliente());
        }
    }
}
