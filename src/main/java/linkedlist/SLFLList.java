package linkedlist;

import interfase.LinkedList;
import interfase.Node;

import java.util.Iterator;

public class SLFLList<T> implements LinkedList<T>
{
    private SNode<T> first, last;   // reference to the first node and to the last node
    int length;

    public SLFLList() {       // to create an empty list instance
        first = last = null;
        length = 0;
    }


    public void addFirstNode(Node<T> nuevo) {
        // TODO Auto-generated method stub

    }

    public void addNodeAfter(Node<T> target, Node<T> nuevo) {
        // TODO Auto-generated method stub

    }

    public void addNodeBefore(Node<T> target, Node<T> nuevo) {
        // TODO Auto-generated method stub

    }

    public Node<T> getFirstNode() {
        // TODO Auto-generated method stub
        return null;
    }

    public Node<T> getLastNode() {
        // TODO Auto-generated method stub
        return null;
    }

    public Node<T> getNodeAfter(Node<T> target) {
        // TODO Auto-generated method stub
        return null;
    }

    public Node<T> getNodeBefore(Node<T> target) {
        // TODO Auto-generated method stub
        return null;
    }

    public int length() {
        // TODO Auto-generated method stub
        return 0;
    }

    public void removeNode(Node<T> target) {
        // TODO Auto-generated method stub

    }

    public Node<T> createNewNode() {
        return new SNode<T>();
    }


    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public void addLastNode(Node<T> newNode) {
        // TODO Auto-generated method stub

    }


    @Override
    public Iterable<Node<T>> nodes() {
        // TODO Auto-generated method stub
        return null;
    }


    /**
     * Class to represent a node of the type used in singly linked lists. 
     * @author pedroirivera-vega
     *
     * @param <T> Data type of element in a node.
     */
    protected static class SNode<T> implements Node<T> {
        private T element;
        private SNode<T> next;
        public SNode() {
            element = null;
            next = null;
        }
        public SNode(T data, SNode<T> next) {
            this.element = data;
            this.next = next;
        }
        public SNode(T data)  {
            this.element = data;
            next = null;
        }
        public T getElement() {
            return element;
        }
        public void setElement(T data) {
            this.element = data;
        }
        public SNode<T> getNext() {
            return next;
        }
        public void setNext(SNode<T> next) {
            this.next = next;
        }
        public void clean() {
            element = null;
            next = null;
        }
    }

}

