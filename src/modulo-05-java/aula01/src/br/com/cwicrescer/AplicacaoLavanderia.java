package br.com.cwicrescer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.cwicrescer.dao.ClienteDao;
import br.com.cwicrescer.dao.PedidoDao;
import br.com.cwicrescer.model.Cliente;
import br.com.cwicrescer.model.Pedido;

public class AplicacaoLavanderia {

    private static Scanner scanner = new Scanner(System.in);
    private static Cliente cliente = new Cliente();
    private static List<Cliente> listaCliente = new ArrayList<Cliente>();
    private static ClienteDao dbCliente = new ClienteDao();
    private static PedidoDao dbPedidos = new PedidoDao();

    public static void main(String[] args) {
        while (true) {
            mainMenu();
        }
    }

    public static void mainMenu() throws SQLException {
        System.out.print("SISTEMA LAVANDERIA\n\n");
        System.out.print("Digite 1 para adicionar pedido\nDigite 2 para lsitar pedidos\n\n");
        switch (scanner.nextLine()) {
            case "1":
                adicionar();
                break;
            case "2":
                listar();
                break;
            default:
                break;
        }
        System.out.print("Pressione enter para prosseguir");
        scanner.nextLine();
        limparTela();
    }

    public static void adicionar() throws SQLException {
        Cliente cliente = selecionarCliente();
        System.out.println("Insira a descrição do pedido");
        String descricao = scanner.nextLine();
        Pedido pedidoNovo = new Pedido();
        pedidoNovo.setDsPedido(descricao);
        try {
            dbPedidos.add(pedidoNovo, cliente);
            System.out.println("Pedido adiconado com sucesso!");
        } catch (Exception e) {
            System.out.println("Falha ao inserir pedido.");
        }
    }

    public static void listar() throws NumberFormatException, SQLException {
        System.out.println("Digite 0 para listar todos ou insere o id para detalhes do pedido");
        String escolha = scanner.nextLine();
        if (!escolha.equals("0")) {
            if (tryParseInt(escolha)) {
                System.out.println(dbCliente.load(Long.parseLong(escolha)).toString());
            } else {
                List<Pedido> listaPedidos = dbPedidos.listAll();
                for (Pedido pedido : listaPedidos) {
                    System.out.println(pedido.toString());
                }
            }
        }
    }

    public static void limparTela() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    public static Cliente selecionarCliente() throws SQLException {
        Cliente buscouCliente = null;
        while (buscouCliente == null) {
            limparTela();
            System.out.println("Insira o nome do cliente ou digite 'inserir' para cadastrar um novo");
            String nome = scanner.nextLine();
            if (nome.toLowerCase().equals("inserir")) {
                buscouCliente = inserirCliente();
            } else {
                buscouCliente = buscarCliente(nome);
            }
        }
        return buscouCliente;
    }

    public static Cliente buscarCliente(String nome) throws SQLException {
        Cliente buscarCliente = new Cliente();
        buscarCliente.setNmCliente(nome);
        List<Cliente> listaClientes = dbCliente.find(buscarCliente);
        String escolha = "0";
        int idCliente = 0;
        if (listaClientes.isEmpty()) {
            System.out.println("Nenhum cliente encontrado!");
        } else {
            for (Cliente cliente : listaClientes) {
                System.out.println("Entre com o id do cliente ou digite 0 para voltar ao menu anterior");
                System.out.println(cliente.toString());
            }
            escolha = scanner.nextLine();
        }
        if (!escolha.equals("0")) {
            if (tryParseInt(escolha)) {
                return dbCliente.load(Long.parseLong(escolha));
            } else {
                System.out.println("Parametro informado invalido!");
            }
        }
        return null;
    }

    public static Cliente inserirCliente() {
        System.out.println("Insira o nome do cliente");
        String nome = scanner.nextLine();
        System.out.println("Insira o CPF do cliente");
        String CPF = scanner.nextLine();
        Cliente novoCliente = new Cliente();
        novoCliente.setNmCliente(nome);
        novoCliente.setNrCpf(CPF);
        try {
            dbCliente.add(novoCliente);
            System.out.println("\nCliente adicionado com sucesso!");
            List<Cliente> buscarCliente = dbCliente.find(novoCliente);
            return buscarCliente.get(0);
        } catch (Exception e) {
            System.out.println("\nFalaha ao inserir cliente.");
            return null;
        }
    }

    public static boolean tryParseInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
