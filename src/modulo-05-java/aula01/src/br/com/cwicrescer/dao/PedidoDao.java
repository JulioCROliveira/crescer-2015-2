package br.com.cwicrescer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cwicrescer.JDBC.ConnectionFactory;
import br.com.cwicrescer.model.Cliente;
import br.com.cwicrescer.model.Pedido;

public class PedidoDao {

    public void add(Pedido pedido, Cliente cliente) throws Exception {
        try (Connection conexao = new ConnectionFactory().getConnection();) {
            PreparedStatement statement = conexao.prepareStatement("insert into pedido (idPedido, idCliente, dsPedido) values (pedido_seq.nextVal,?,?) ");
            statement.setLong(1, cliente.getIdCliente());
            statement.setString(2, pedido.getDsPedido());

            statement.execute();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public void update(Pedido pedido) throws Exception {
        try (Connection conexao = new ConnectionFactory().getConnection();) {
            PreparedStatement statement = conexao.prepareStatement("update pedido set dsPedido = ? where idPedido = ? ");
            statement.setString(1, pedido.getDsPedido());
            statement.setLong(2, pedido.getIdPedido());

            statement.execute();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public void update(Pedido pedido, Cliente cliente) throws Exception {
        try (Connection conexao = new ConnectionFactory().getConnection();) {
            PreparedStatement statement = conexao.prepareStatement("update pedido set dsPedido = ?, idCliente = ? where idPedido = ? ");
            statement.setString(1, pedido.getDsPedido());
            statement.setLong(2, cliente.getIdCliente());
            statement.setLong(3, pedido.getIdPedido());

            statement.execute();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public Pedido load(Long idPedido) throws SQLException {
        try (Connection conexao = new ConnectionFactory().getConnection();) {
            Pedido pedido = new Pedido();

            StringBuilder sql = new StringBuilder();
            sql.append("select idPedido, dsPedido ");
            sql.append("from pedido where idPedido = ?");
            PreparedStatement statement = conexao.prepareStatement(sql.toString());
            statement.setLong(1, idPedido);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                pedido.setIdPedido(resultSet.getLong(1));
                pedido.setDsPedido(resultSet.getString(2));
            } else {
                throw new RuntimeException("Registro não encontrado!");
            }

            return pedido;
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public List<Pedido> find(Pedido pedido, Cliente cliente) throws SQLException {
        try (Connection conexao = new ConnectionFactory().getConnection();) {
            StringBuilder sql = new StringBuilder();
            sql.append("select idPedido, dsPedido, idCliente ");
            sql.append("from pedido where ");
            boolean jaPossuiFilter = false;
            int index = 1;
            if (pedido.getIdPedido() != 0) {
                sql.append("idPedido = ? ");
                jaPossuiFilter = true;
            }
            if (pedido.getDsPedido() != null) {
                if (jaPossuiFilter) {
                    sql.append(" and ");
                }
                sql.append("dsPedido = ? ");
                jaPossuiFilter = true;
            }
            if (cliente.getIdCliente() != 0) {
                if (jaPossuiFilter) {
                    sql.append(" and ");
                }
                sql.append("idPedido = ? ");
                jaPossuiFilter = true;
            }
            if (!jaPossuiFilter) {
                sql.append("1=1");
            }
            PreparedStatement statement = conexao.prepareStatement(sql.toString());
            if (pedido.getIdPedido() != 0) {
                statement.setLong(index, pedido.getIdPedido());
                index++;
            }
            if (pedido.getDsPedido() != null) {
                statement.setString(index, pedido.getDsPedido());
                index++;
            }
            if (cliente.getIdCliente() != 0) {
                statement.setLong(index, cliente.getIdCliente());
                index++;
            }
            ResultSet resultSet = statement.executeQuery();
            List<Pedido> pedidos = new ArrayList<Pedido>();
            while (resultSet.next()) {
                Pedido pedidoBusca = new Pedido();
                pedidoBusca.setIdPedido(resultSet.getLong(1));
                pedidoBusca.setDsPedido(resultSet.getString(2));
                pedidoBusca.setIdCliente(resultSet.getLong(3));
                pedidos.add(pedidoBusca);
            }

            return pedidos;
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public void delete(long id) throws Exception {
        try (Connection conexao = new ConnectionFactory().getConnection();) {
            StringBuilder sql = new StringBuilder();
            sql.append("delete from pedido where idPedido = ?");

            PreparedStatement statement = conexao.prepareStatement(sql.toString());
            statement.setLong(1, id);
            statement.executeQuery();
        } catch (SQLException e) {
            throw new Exception(e);
        }
    }

    public List<Pedido> listAll() throws SQLException {
        List<Pedido> lista = new ArrayList<Pedido>();
        try (Connection conexao = new ConnectionFactory().getConnection()) {
            StringBuilder query = new StringBuilder();
            query.append("select idPedido, dsPedido, idCliente from pedido");
            PreparedStatement statement = conexao.prepareStatement(query.toString());
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                Pedido pedidoBusca = new Pedido();
                pedidoBusca.setIdPedido(resultSet.getLong(1));
                pedidoBusca.setDsPedido(resultSet.getString(2));
                pedidoBusca.setIdCliente(resultSet.getLong(3));
                lista.add(pedidoBusca);
            }
        } catch (SQLException e) {
            throw e;
        }
        return lista;
    }
}
