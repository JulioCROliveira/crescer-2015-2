package br.com.cwicrescer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cwicrescer.JDBC.ConnectionFactory;
import br.com.cwicrescer.model.Servico;

public class ServicoDao {

    public void add(Servico servico) throws Exception {
        try (Connection conexao = new ConnectionFactory().getConnection();) {
            PreparedStatement statement = conexao.prepareStatement("insert into servico (idServico, dsServico) values (servico_seq.nextVal,?) ");
            statement.setString(1, servico.getdServico());

            statement.execute();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public void update(Servico servico) throws Exception {
        try (Connection conexao = new ConnectionFactory().getConnection();) {
            PreparedStatement statement = conexao.prepareStatement("update servico set dsServico = ?where idServico = ? ");
            statement.setString(1, servico.getdServico());
            statement.setLong(2, servico.getIdServico());

            statement.execute();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public Servico load(Long idServico) throws SQLException {
        try (Connection conexao = new ConnectionFactory().getConnection();) {
            Servico servico = new Servico();

            StringBuilder sql = new StringBuilder();
            sql.append("select idServico, dsServico ");
            sql.append("from servico where idServico = ?");
            PreparedStatement statement = conexao.prepareStatement(sql.toString());
            statement.setLong(1, idServico);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                servico.setIdServico(resultSet.getLong(1));
                servico.setdServico(resultSet.getString(2));
            } else {
                throw new RuntimeException("Registro não encontrado!");
            }

            return servico;
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public List<Servico> find(Servico servico) throws SQLException {
        try (Connection conexao = new ConnectionFactory().getConnection();) {
            StringBuilder sql = new StringBuilder();
            sql.append("select idServico, dsServico ");
            sql.append("from servico where ");
            boolean jaPossuiFilter = false;
            int index = 1;
            if (servico.getIdServico() != 0) {
                sql.append("idServico = ? ");
                jaPossuiFilter = true;
            }
            if (servico.getdServico() != null) {
                if (jaPossuiFilter) {
                    sql.append(" and ");
                }
                sql.append("dsServico = ? ");
                jaPossuiFilter = true;
            }
            if (!jaPossuiFilter) {
                sql.append("1=1");
            }
            PreparedStatement statement = conexao.prepareStatement(sql.toString());
            if (servico.getIdServico() != 0) {
                statement.setLong(index, servico.getIdServico());
                index++;
            }
            if (servico.getdServico() != null) {
                statement.setString(index, servico.getdServico());
                index++;
            }
            ResultSet resultSet = statement.executeQuery();
            List<Servico> servicos = new ArrayList<Servico>();
            while (resultSet.next()) {
                Servico servicoBusca = new Servico();
                servicoBusca.setIdServico(resultSet.getLong(1));
                servicoBusca.setdServico(resultSet.getString(2));
                servicos.add(servicoBusca);
            }

            return servicos;
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public void delete(long id) throws Exception {
        try (Connection conexao = new ConnectionFactory().getConnection();) {
            StringBuilder sql = new StringBuilder();
            sql.append("delete from servico where idServico = ?");

            PreparedStatement statement = conexao.prepareStatement(sql.toString());
            statement.setLong(1, id);
            statement.executeQuery();
        } catch (SQLException e) {
            throw new Exception(e);
        }
    }

    public List<Servico> listAll() throws SQLException {
        List<Servico> lista = new ArrayList<Servico>();
        try (Connection conexao = new ConnectionFactory().getConnection()) {
            StringBuilder query = new StringBuilder();
            query.append("select idServico, dsServico from Servico");
            PreparedStatement statement = conexao.prepareStatement(query.toString());
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                Servico servicoBusca = new Servico();
                servicoBusca.setIdServico(resultSet.getLong(1));
                servicoBusca.setdServico(resultSet.getString(2));
                lista.add(servicoBusca);
            }
        } catch (SQLException e) {
            throw e;
        }
        return lista;
    }
}
