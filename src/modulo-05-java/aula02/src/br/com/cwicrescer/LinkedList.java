package br.com.cwicrescer;

import java.util.ArrayList;
import java.util.List;

public class LinkedList {

    private Node last, first;

    public void addFirst(String value) {
        Node node;
        if (first == null) {
            node = new Node(value);
            last = node;
        } else {
            node = new Node(value, first);
        }
        first = node;
    }

    public String getFirst() {
        return first.getValue();
    }

    public String getLast() {
        return last.getValue();
    }

    public List<String> list() {
        ArrayList<String> lista = new ArrayList<String>();
        Node node = first;
        while (node != null) {
            lista.add(node.getValue());
            node = node.getNext();
        }
        return lista;
    }

    public void addLast(String value) {
        Node node = new Node(value);
        if (last == null) {
            first = node;
        } else {
            last.setNext(node);
        }
        last = node;
    }

    public void removeFirst() {
        first = first.getNext();
    }

    public void add(int index, String value) {
        int count = 0;
        Node node = first;
        while (count < index && node != null) {
            if (count == (index - 1)) {
                Node newNode = new Node(value, node.getNext());
                node.setNext(newNode);
            }
            node = node.getNext();
            count++;
        }
    }

    public void remove(int index) {
        int count = 0;
        Node node = first;
        if (index == 0) {
            removeFirst();
        } else {
            while (count < index && node != null) {
                if (count == (index - 1)) {
                    if (node.getNext().getNext() == null) {
                        node.setNext(null);
                        last = node;
                    } else {
                        node.setNext(node.getNext().getNext());
                    }
                }
                node = node.getNext();
                count++;
            }
        }
    }

    protected class Node {

        public String value;

        private Node next;

        public Node(String value, Node next) {
            this.value = value;
            this.next = next;
        }

        public void setNext(Node node) {
            this.next = node;
        }

        public Node getNext() {
            return this.next;
        }

        public Node(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }
    }
}
