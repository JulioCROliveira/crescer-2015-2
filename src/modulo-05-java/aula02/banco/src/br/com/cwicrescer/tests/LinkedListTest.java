package br.com.cwicrescer.tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.cwicrescer.LinkedList;

public class LinkedListTest {

    @Test
    public void adicionaPrimeiroNaLista() {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst("primeiro");
        linkedList.addFirst("segundo");
        linkedList.addFirst("terceiro");
        assertEquals(linkedList.getFirst(), "terceiro");
        assertEquals(linkedList.getLast(), "primeiro");
    }

    @Test
    public void adicionaUltimo() {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst("primeiro");
        linkedList.addFirst("segundo");
        linkedList.addFirst("terceiro");
        linkedList.addLast("ultimo");
        assertEquals(linkedList.getFirst(), "terceiro");
        assertEquals(linkedList.getLast(), "ultimo");
    }

    @Test
    public void removePrimeiroNaLista() {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst("primeiro");
        linkedList.addFirst("segundo");
        linkedList.addFirst("terceiro");
        linkedList.removeFirst();
        assertEquals(linkedList.getFirst(), "segundo");
        assertEquals(linkedList.getLast(), "primeiro");
    }

    @Test
    public void listarItens() {
        LinkedList linkedList = new LinkedList();
        List<String> esperado = new ArrayList<String>();
        esperado.add("terceiro");
        esperado.add("segundo");
        esperado.add("primeiro");
        linkedList.addFirst("primeiro");
        linkedList.addFirst("segundo");
        linkedList.addFirst("terceiro");
        assertEquals(linkedList.list(), esperado);
    }

    @Test
    public void removeSegundaNaLista() {
        LinkedList linkedList = new LinkedList();
        List<String> esperado = new ArrayList<String>();
        esperado.add("terceiro");
        esperado.add("primeiro");
        linkedList.addFirst("primeiro");
        linkedList.addFirst("segundo");
        linkedList.addFirst("terceiro");
        linkedList.remove(1);
        assertEquals(linkedList.list(), esperado);
    }

    @Test
    public void adicionaSegundaPosicao() {
        LinkedList linkedList = new LinkedList();
        List<String> esperado = new ArrayList<String>();
        esperado.add("terceiro");
        esperado.add("novo");
        esperado.add("segundo");
        esperado.add("primeiro");
        linkedList.addFirst("primeiro");
        linkedList.addFirst("segundo");
        linkedList.addFirst("terceiro");
        linkedList.add(1, "novo");
        assertEquals(linkedList.list(), esperado);
    }
}
