package br.com.cwicrescer;

import java.util.ArrayList;
import java.util.List;

public class DoublyLinkedList<T> {

    private Node<T> last, first;
    private int size = 0;

    public void addFirst(T value) {
        Node<T> node;
        if (first == null) {
            node = new Node<T>(value);
            last = node;
        } else {
            node = new Node<T>(value, null, first);
            first.setPrevious(node);
        }
        size++;
        first = node;
    }

    public T getFirst() {
        return first.getValue();
    }

    public int getSize() {
        return size;
    }

    public T getLast() {
        return last.getValue();
    }

    public List<T> list() {
        ArrayList<T> lista = new ArrayList<T>();
        Node<T> node = first;
        while (node != null) {
            lista.add(node.getValue());
            node = node.getNext();
        }
        return lista;
    }

    public List<T> reverseList() {
        ArrayList<T> lista = new ArrayList<T>();
        Node<T> node = last;
        while (node != null) {
            lista.add(node.getValue());
            node = node.getPrevious();
        }
        return lista;
    }

    public void addLast(T value) {
        Node<T> node = new Node<T>(value, last, null);
        if (last == null) {
            addFirst(value);
        } else {
            last.setNext(node);
        }
        size++;
        last = node;
    }

    public void removeFirst() {
        if (first != null) {
            first = first.getNext();
            first.setPrevious(null);
            size--;
        }
    }

    public void add(int index, T value) {
        Node<T> node = get(index - 1);
        if (node != null) {
            Node<T> newNode = new Node<T>(value, node, node.getNext());
            node.setNext(newNode);
            size++;
        }
    }

    public Node<T> get(int index) {
        if (index == 0) {
            return first;
        } else {
            Node<T> node = first;
            for (int i = 0; i < index; i++) {
                node = node.getNext();
            }
            return node;
        }
    }

    public void remove(int index) {
        if (index == 0) {
            removeFirst();
        } else {
            Node<T> node = get(index - 1);
            if (node != null) {
                if (node.getNext().getNext() == null) {
                    node.setNext(null);
                    last = node;
                } else {
                    node.getNext().getNext().setPrevious(node);
                    node.setNext(node.getNext().getNext());
                }
                size--;
            }
        }
    }

    protected class Node<T> {

        public T value;

        private Node<T> next, previous;

        public Node(T value, Node<T> previous, Node<T> next) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }

        public void setNext(Node<T> node) {
            this.next = node;
        }

        public Node<T> getNext() {
            return this.next;
        }

        public void setPrevious(Node<T> node) {
            this.previous = node;
        }

        public Node<T> getPrevious() {
            return this.previous;
        }

        public Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return this.value;
        }
    }
}
