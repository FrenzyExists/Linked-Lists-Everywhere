package node;

import interfase.Node;

/**
 * Another node, but this one however contains a reference to an element T, a reference to the next node and
 * a reference to the previous node
 * @param <T>
 */
public class DNode<T> implements Node<T> {

    // References
    private T element;
    private Node<T> nextNode, previousNode;

    // Constructor
    public DNode() {
        this.previousNode = this.nextNode =  null;
    }

    /**
     * Returns a reference to the Element T
     *
     * @return Element T
     */
    @Override
    public T getElement() {
        return this.element;
    }

    /**
     * Overrides the reference to the Element T for a new Element T
     *
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
        this.previousNode = null;
        this.nextNode = null;
    }
}
