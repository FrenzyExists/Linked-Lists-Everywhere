package linkedlist;

import interfase.LinkedList;
import interfase.Node;
import node.DNode;

import java.util.Iterator;

/**
 *
 * @param <T>
 */
public class DLList<T> implements LinkedList<T> {
    
    private DNode<T> header;
    private int length;

    // creates empty linked list
    public DLList() {
        header = null;
        length = 0;
    }

    @Override
    public int length() {
        return this.length;
    }

    @Override
    public Node<T> getFirstNode() {
        return null;
    }

    @Override
    public Node<T> getLastNode() {
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}