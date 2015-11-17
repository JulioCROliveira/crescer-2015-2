package br.com.cwicrescer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.cwicrescer.JDBC.ConnectionFactory;
import br.com.cwicrescer.model.Cliente;

public class ClienteDao {
    public void add(Cliente cliente) throws Exception{
        try {
            Connection conexao = new ConnectionFactory().getConnection();
            PreparedStatement statement = conexao.prepareStatement("insert into cliente (IdCliente, nmCliente, nrCpf) values (?,?,?) ");

            Statement stat = conexao.createStatement();
            stat.execute("insert into cliente (IdCliente, nmCliente, nrCpf) values ('" + cliente.getIdCliente() + "','"+ cliente.getNmCliente() +"','"+ cliente.getNrCpf() +"') ");

            statement.execute();
        } catch (SQLException e) {
            throw new Exception(e);
        }
    }

    public List<Cliente> listAll() throws SQLException {
        List<Cliente> lista = new ArrayList<Cliente>();
        try (Connection conexao = new ConnectionFactory().getConnection()) {
            StringBuilder query = new StringBuilder();
            query.append("select idCliente, nmCliente, nrCpf from Cliente");
            PreparedStatement statement = conexao.prepareStatement(query.toString());
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(resultSet.getLong(1));
                cliente.setNmCliente(resultSet.getString(2));
                cliente.setNrCpf(resultSet.getString(3));
            }
        } catch (SQLException e) {
            throw e;
        }
        return lista;
    }
}
