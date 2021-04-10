package node;

import interfase.Node;

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


}
