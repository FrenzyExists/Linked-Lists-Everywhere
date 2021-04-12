package linkedlist;

import interfase.LinkedList;
import interfase.Node;
import node.SNode;

import java.util.Iterator;
import java.util.NoSuchElementException;

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

    /**
     *
     * @param target
     * @param newNode
     */
    public void addNodeAfter(Node<T> target, Node<T> newNode) {
        ((SNode<T>) newNode).setNext(target.getNext());
        ((SNode<T>) target).setNext(newNode);
        length++;
    }

    /**
     *
     * @param target
     * @param newNode
     */
    public void addNodeBefore(Node<T> target, Node<T> newNode) {
        SNode<T> nody = (SNode<T>) newNode;
        SNode<T> prev = (SNode<T>) getNodeBefore(target);
        ((SNode<T>) newNode).setNext(target);
        prev.setNext(nody);
        length++;
    }

    /**
     *
     * @return
     */
    public Node<T> getFirstNode() {
        if (first == null)
            throw new NoSuchElementException("getFirstNode() : linked list is empty...");
        return first;
    }

    public Node<T> getLastNode() {
        if (last == null)
            throw new NoSuchElementException("getLastNode() : linked list is empty...");
        return last;
    }

    public Node<T> getNodeAfter(Node<T> target) {
        if (target.equals(last)) {
            return null;
        }
        return target.getNext();
    }

    public Node<T> getNodeBefore(Node<T> target) {
        if (target.equals(first)) {
            return null;
        } else if (target.equals(last)) {
            return last;
        } else {
            SNode<T> prev = first;
            while (prev != null && prev.getNext() != target)
                prev = (SNode<T>) prev.getNext();
            return prev;
        }
    }

    /**
     *
     * @return
     */
    public int length() {
        // TODO Auto-generated method stub
        return length;
    }

    /**
     *
     * @param target - the Node desired to remove from the list, assuming it exists in the list
     */
    public void removeNode(Node<T> target) {
        SNode<T> prev = (SNode<T>) getNodeBefore(target);
        prev.setNext(target.getNext());
        target.clean();
        length--;
    }

    public Node<T> createNewNode() {
        return new SNode<>();
    }


    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     *
     * @param newNode
     */
    @Override
    public void addLastNode(Node<T> newNode) {
        SNode<T> daNode = (SNode<T>) newNode;
        daNode.setNext(null);
        if (first == null)  {
            first = daNode;
        } else {
            last.setNext(daNode);
        }
        last = daNode;
        length++;
    }


    @Override
    public Iterable<Node<T>> nodes() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     *
     */
    private class ElementsIterator implements Iterator<T> {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public T next() {
            return null;
        }
    }

    /**
     *
     */
    private class NodesIterator implements Iterator<Node<T>> {
        private SNode<T> curr = first;
        private SNode<T> prev = null;

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Node<T> next() {
            return null;
        }
    }
}

