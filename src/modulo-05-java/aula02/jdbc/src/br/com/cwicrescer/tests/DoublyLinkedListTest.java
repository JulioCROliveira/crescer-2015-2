package br.com.cwicrescer.tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.cwicrescer.DoublyLinkedList;

public class DoublyLinkedListTest {

    @Test
    public void adicionaPrimeiroNaLista() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.addFirst("primeiro");
        doublyLinkedList.addFirst("segundo");
        doublyLinkedList.addFirst("terceiro");
        assertEquals(doublyLinkedList.getFirst(), "terceiro");
        assertEquals(doublyLinkedList.getLast(), "primeiro");
    }

    @Test
    public void adicionaUltimo() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.addFirst("primeiro");
        doublyLinkedList.addFirst("segundo");
        doublyLinkedList.addFirst("terceiro");
        doublyLinkedList.addLast("ultimo");
        assertEquals(doublyLinkedList.getFirst(), "terceiro");
        assertEquals(doublyLinkedList.getLast(), "ultimo");
    }

    @Test
    public void removePrimeiroNaLista() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.addFirst("primeiro");
        doublyLinkedList.addFirst("segundo");
        doublyLinkedList.addFirst("terceiro");
        doublyLinkedList.removeFirst();
        assertEquals(doublyLinkedList.getFirst(), "segundo");
        assertEquals(doublyLinkedList.getLast(), "primeiro");
    }

    @Test
    public void listarItens() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        List<String> esperado = new ArrayList<String>();
        esperado.add("terceiro");
        esperado.add("segundo");
        esperado.add("primeiro");
        doublyLinkedList.addFirst("primeiro");
        doublyLinkedList.addFirst("segundo");
        doublyLinkedList.addFirst("terceiro");
        assertEquals(doublyLinkedList.list(), esperado);
    }

    @Test
    public void listarItensReverso() {
        DoublyLinkedList doublyLinkedListTest = new DoublyLinkedList();
        List<String> esperado = new ArrayList<String>();
        esperado.add("primeiro");
        esperado.add("segundo");
        esperado.add("terceiro");
        doublyLinkedListTest.addFirst("primeiro");
        doublyLinkedListTest.addFirst("segundo");
        doublyLinkedListTest.addFirst("terceiro");
        assertEquals(doublyLinkedListTest.reverseList(), esperado);
    }

    @Test
    public void removeSegundaNaLista() {
        DoublyLinkedList doublyLinkedListTest = new DoublyLinkedList();
        List<String> esperado = new ArrayList<String>();
        esperado.add("terceiro");
        esperado.add("primeiro");
        doublyLinkedListTest.addFirst("primeiro");
        doublyLinkedListTest.addFirst("segundo");
        doublyLinkedListTest.addFirst("terceiro");
        doublyLinkedListTest.remove(1);
        assertEquals(doublyLinkedListTest.list(), esperado);
    }

    @Test
    public void adicionaSegundaPosicao() {
        DoublyLinkedList doublyLinkedListTest = new DoublyLinkedList();
        List<String> esperado = new ArrayList<String>();
        esperado.add("terceiro");
        esperado.add("novo");
        esperado.add("segundo");
        esperado.add("primeiro");
        doublyLinkedListTest.addFirst("primeiro");
        doublyLinkedListTest.addFirst("segundo");
        doublyLinkedListTest.addFirst("terceiro");
        doublyLinkedListTest.add(1, "novo");
        assertEquals(doublyLinkedListTest.list(), esperado);
    }
}
