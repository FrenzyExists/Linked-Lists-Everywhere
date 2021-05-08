package node;

import interfase.Node;

/**
 * @author frenzy
 *
 * The simplest type of node. This is a node which there is a reference to an element and a reference to another node
 * of the same type. This type of node is used to implement any SinglyLinkedList ADT
 * @param <T>
 */
public class SNode<T> implements Node<T> {

    // References
    private T element;
    private Node<T> nextNode;


    // Constructor
    public SNode() {
        this.element = null;
        this.nextNode = null;
    }

    // Another one
    public SNode(T e, Node<T> nextNode) {
        this.element = e;
        this.nextNode = nextNode;
    }

    /**
     * Returns a reference to the Element T
     * @return Element T
     */
    @Override
    public T getElement() {
        return this.element;
    }

    /**
     * Overrides the reference to the Element T for a new Element T
     * @param e The new Element T which will replace the older one
     */
    @Override
    public void setElement(T e) {
        this.element = e;
    }

    /**
     * Overrides all fields of node to null
     */
    @Override
    public void clean() {
        this.element = null;
        this. nextNode = null;
    }

    /**
     * Returns a reference to the next node
     * @return next node
     */
    @Override
    public Node<T> getNext() {
        return this.nextNode;
    }

    /**
     * Overrides the reference to the Element T for a new Element T
     * @param next - the new node to become next
     */
    public void setNext(Node<T> next) {
        this.nextNode = next;
    }
}


