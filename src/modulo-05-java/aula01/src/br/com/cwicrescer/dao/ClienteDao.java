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
        try (Connection conexao = new ConnectionFactory().getConnection();) {
            PreparedStatement statement = conexao.prepareStatement("insert into cliente (IdCliente, nmCliente, nrCpf) values (?,?,?) ");

            Statement stat = conexao.createStatement();
            stat.execute("insert into cliente (IdCliente, nmCliente, nrCpf) values (cliente_seq.nextVal, '" + cliente.getNmCliente() + "','" + cliente.getNrCpf()
            + "') ");

        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public void update(Cliente cliente) throws Exception {
        try (Connection conexao = new ConnectionFactory().getConnection();) {
            PreparedStatement statement = conexao.prepareStatement("update cliente set nmCliente = ?, nrCpf = ? where idCliente = ? ");
            statement.setString(1, cliente.getNmCliente());
            statement.setString(2, cliente.getNrCpf());
            statement.setLong(3, cliente.getIdCliente());

            statement.execute();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public Cliente load(Long idCliente) throws SQLException {
        try (Connection conexao = new ConnectionFactory().getConnection();) {
            Cliente cliente = new Cliente();

            StringBuilder sql = new StringBuilder();
            sql.append("select idCliente, nmCliente, nrCpf ");
            sql.append("from cliente where idCliente = ?");
            PreparedStatement statement = conexao.prepareStatement(sql.toString());
            statement.setLong(1, idCliente);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                cliente.setIdCliente(resultSet.getLong(1));
                cliente.setNmCliente(resultSet.getString(2));
                cliente.setNrCpf(resultSet.getString(3));
            } else {
                throw new RuntimeException("Registro não encontrado!");
            }

            return cliente;
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public List<Cliente> find(Cliente cliente) throws SQLException {
        try (Connection conexao = new ConnectionFactory().getConnection();) {
            StringBuilder sql = new StringBuilder();
            sql.append("select idCliente, nmCliente, nrCpf ");
            sql.append("from cliente where ");
            boolean jaPossuiFilter = false;
            int index = 1;
            if (cliente.getIdCliente() != 0) {
                sql.append("idCliente = ? ");
                jaPossuiFilter = true;
            }
            if (cliente.getNmCliente() != null) {
                if (jaPossuiFilter) {
                    sql.append(" and ");
                }
                sql.append("nmCliente like '%?%' ");
                jaPossuiFilter = true;
            }
            if (cliente.getNrCpf() != null) {
                if (jaPossuiFilter) {
                    sql.append(" and ");
                }
                sql.append("nrCpf = ? ");
                jaPossuiFilter = true;
            }
            if (!jaPossuiFilter) {
                sql.append("1=1");
            }
            PreparedStatement statement = conexao.prepareStatement(sql.toString());
            if (cliente.getIdCliente() != 0) {
                statement.setLong(index, cliente.getIdCliente());
                index++;
            }
            if (cliente.getNmCliente() != null) {
                statement.setString(index, cliente.getNmCliente());
                index++;
            }
            if (cliente.getNrCpf() != null) {
                statement.setString(index, cliente.getNrCpf());
                index++;
            }
            ResultSet resultSet = statement.executeQuery();
            List<Cliente> clientes = new ArrayList<Cliente>();
            while (resultSet.next()) {
                Cliente clienteBusca = new Cliente();
                clienteBusca.setIdCliente(resultSet.getLong(1));
                clienteBusca.setNmCliente(resultSet.getString(2));
                clienteBusca.setNrCpf(resultSet.getString(3));
                clientes.add(clienteBusca);
            }

            return clientes;
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public void delete(long id) throws Exception {
        try (Connection conexao = new ConnectionFactory().getConnection();) {
            StringBuilder sql = new StringBuilder();
            sql.append("delete from Cliente where idCliente = ?");

            PreparedStatement statement = conexao.prepareStatement(sql.toString());
            statement.setLong(1, id);
            statement.executeQuery();
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
