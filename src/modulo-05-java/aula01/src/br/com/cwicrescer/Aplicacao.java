package br.com.cwicrescer;

import java.util.Scanner;

public class Aplicacao {
    private static Scanner scanner = new Scanner(System.in);
    private static DoublyLinkedList<String> doublyLinkedList = new DoublyLinkedList<String>();

    public static void main(String[] args) {
        while(true) {
            mainMenu();
        }
    }

    public static void mainMenu(){
        System.out.print(doublyLinkedList.getSize() + " itens na lista\n\n");
        System.out.print("Digite 1 para adicionar\nDigite 2 para remover\nDigite 3 para listar\n\n");
        switch (scanner.nextLine()) {
            case "1":
                adicionar();
                break;
            case "2":
                remover();
                break;
            case "3":
                listar();
                break;
            default:
                break;
        }
        System.out.print("Pressione enter para prosseguir");
        scanner.nextLine();
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    public static void adicionar() {
        System.out.print("Insira o valor a ser adicionado : \n");
        String valor = scanner.nextLine();
        if (doublyLinkedList.getSize() == 0) {
            doublyLinkedList.addLast(valor);
        } else {
            System.out.print("Insira a posição a ser inserido (de 0 até " + doublyLinkedList.getSize() + ")\n");
            String numeroTexto = scanner.nextLine();
            if (tryParseInt(numeroTexto)) {
                int index = Integer.parseInt(numeroTexto);
                int size = doublyLinkedList.getSize();
                if (index == size) {
                    doublyLinkedList.addLast(valor);
                } else if (index < 0 || index >= size) {
                    System.out.print("Valor não está entre o permitido\n");
                } else {
                    doublyLinkedList.add(index, valor);
                }
            } else {
                System.out.print("Valor não númerico\n");
            }
        }
    }

    public static void remover() {
        if (doublyLinkedList.getSize() > 0) {
            System.out.print("Insira a posição do valor a remover (de 0 até " + doublyLinkedList.getSize() + ")\n");
            String numeroTexto = scanner.nextLine();
            if (tryParseInt(numeroTexto)) {
                int index = Integer.parseInt(numeroTexto);
                if (index < 0 || index > doublyLinkedList.getSize() - 1) {
                    System.out.print("Valor não está entre o permitido\n");
                } else {
                    doublyLinkedList.remove(index);
                }
            } else {
                System.out.print("Valor não númerico\n");
            }
        } else {
            System.out.print("Lista está vazia\n");
        }
    }

    public static void listar() {
        if (doublyLinkedList.getSize() > 0) {
            System.out.print("Digite 1 para listar do primeiro ao ultimo\nDigite 2 para listar do ultimo ao primeiro\n\n");
            switch (scanner.nextLine()) {
                case "1":
                    System.out.print(doublyLinkedList.list());
                    break;
                case "2":
                    System.out.print(doublyLinkedList.reverseList());
                    break;
                default:
                    System.out.print("Opção inválida");
                    break;
            }
            System.out.print("\n");
        } else {
            System.out.print("Lista está vazia\n");
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
