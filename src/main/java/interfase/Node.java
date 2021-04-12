package interfase;

/**
 * A node is a dataholder place. A simple node can hold one data element of type T, and supports operations to set
 * the element value or to access the value of a Node object.
 * @param <T> Generic
 */
public interface Node<T> {

    /**
     * Returns a reference to the Element T
     * @return Element T
     */
    T getElement();

    /**
     * Overrides the reference to the Element T for a new Element T
     * @param e The new Element T which will replace the older one
     */
    void setElement(T e);

    /**
     * Overrides all fields of node to null
     */
    public void clean();

    /**
     * Returns a reference to the next node
     * @return the next node
     */
    Node<T> getNext();
}
