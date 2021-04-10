package node;

import interfase.Node;

/**
 * Another node, but this one however contains a reference to an element T, a reference to the next node and
 * a reference to the previous node
 * @param <T>
 */
public class DNode<T> implements Node<T> {
    /**
     * Returns a reference to the Element T
     *
     * @return Element T
     */
    @Override
    public T getElement() {
        return null;
    }

    /**
     * Overrides the reference to the Element T for a new Element T
     *
     * @param e The new Element T which will replace the older one
     */
    @Override
    public void setElement(T e) {

    }

    /**
     * Overrides all fields of node to null
     */
    @Override
    public void clean() {

    }
}
