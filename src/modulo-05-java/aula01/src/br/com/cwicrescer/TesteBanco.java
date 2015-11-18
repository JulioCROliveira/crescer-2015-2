package br.com.cwicrescer;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.cwicrescer.JDBC.ConnectionFactory;

public class TesteBanco {

    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();
        try {
            Connection conexao = factory.getConnection();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
