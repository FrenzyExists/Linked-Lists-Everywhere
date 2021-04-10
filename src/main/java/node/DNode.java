package node;

import interfase.Node;

/**
 *
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
}
