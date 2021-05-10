package linkedLists;

import interfases.LinkedList;
import interfases.Node;

/**
 *
 * @param <T>
 */
public abstract class AbstractSLList<T> implements LinkedList<T> {
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

