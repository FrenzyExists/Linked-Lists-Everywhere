package linkedlist;

import interfase.LinkedList;
import interfase.Node;
import node.SNode;

import java.util.Iterator;

public class SLFLList<T> implements LinkedList<T>
{
    private SNode<T> first, last;   // reference to the first node and to the last node
    int length;

    public SLFLList() {       // to create an empty list instance
        first = last = null;
        length = 0;
    }

    /**
     *
     * @param newNode
     */
    public void addFirstNode(Node<T> newNode) {
        if (length == 0) {
            first = last = (SNode<T>) newNode;
        } else {
            ((SNode<T>) newNode).setNext(first);
            first = (SNode<T>) newNode;
        }
    }

    public void addNodeAfter(Node<T> target, Node<T> newNode) {
        // TODO Auto-generated method stub

    }

    public void addNodeBefore(Node<T> target, Node<T> newNode) {
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
}

