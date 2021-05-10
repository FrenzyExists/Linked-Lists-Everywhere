package linkedLists;

import interfases.LinkedList;
import interfases.Node;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Singly linked list with references to its first and its
 * last node.
 *
 * @author frenzy
 */

public class SLFLList<T> extends AbstractSLList<T> {
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
        length++;
    }

    /**
     *
     * @param target
     * @param newNode
     */
    public void addNodeAfter(Node<T> target, Node<T> newNode) {
        if (target.equals(last)) {
            last = (SNode<T>) newNode;
            ((SNode<T>) target).setNext(last);
        } else {
            ((SNode<T>) newNode).setNext(((SNode<T>) target).getNext());
            ((SNode<T>) target).setNext((SNode<T>) newNode);
        }
        length++;
    }

    private Node<T> findNodePrevTo(Node<T> target) {
        // Pre: target is a node in the list
        if (target == first)  // the list is empty
            return null;
        else {
            SNode<T> prev = first;
            while (prev != null && prev.getNext() != target)
                prev = prev.getNext();
            return prev;
        }
    }

    /**
     *
     * @param target
     * @param newNode
     */
    public void addNodeBefore(Node<T> target, Node<T> newNode) {
        if (target == first)
            this.addFirstNode(newNode);
        else {
            Node<T> prevNode = findNodePrevTo(target);
            assert prevNode != null;
            this.addNodeAfter(prevNode, newNode);
        }
    }

    public Node<T> getFirstNode() throws NoSuchElementException {
        // TODO Auto-generated method stub
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
        if (length == 0)
            throw new NoSuchElementException("getNodeAfter: list is empty");
        if (target.equals(last))
            return null;
        return ((SNode<T>) target).getNext();
    }

    public Node<T> getNodeBefore(Node<T> target) {
        if(length == 0)
            throw new NoSuchElementException("getNodeBefore: list is empty");

        if (target.equals(first)) {
            return null;
        } else if (target.equals(last)) {
            return last;
        } else {
            SNode<T> prev = first;
            while (prev != null && prev.getNext() != target)
                prev = prev.getNext();
            return prev;
        }
    }

    public int length() {
        return length;
    }

    public void removeNode(Node<T> target) {
        SNode<T> newTarget = (SNode<T>) target;
        SNode<T> previous;
        if(target == first) {
            first = first.getNext();
        } else if(target == last) {
            previous = (SNode<T>) this.getNodeBefore(newTarget);
            previous.setNext(null);
            last = previous;
        } else {
            previous = (SNode<T>) this.getNodeBefore(newTarget);
            previous.setNext(newTarget.getNext());
        }
        newTarget.setElement(null);
        newTarget.setNext(null);

        length--;
    }

    public Node<T> createNewNode() {
        return new SNode<>();
    }

    @Override
    public Iterator<T> iterator() {
        return new ElementsIterator();
    }

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
        return new NodesIterable();
    }

    private class NodesIterable implements Iterable<Node<T>> {

        @Override
        public Iterator<Node<T>> iterator() {
            return new NodesIterator();
        }
    }

    private class NodesIterator implements Iterator<Node<T>> {

        private SNode<T> curr = first;    // node containing element to return on next next()
        private SNode<T> ptntr = null;   // node preceding node valid to be removed
        private boolean canRemove = false;       // to control when remove() is valid to execute

        public boolean hasNext() {
            return curr != null;
        }

        public SNode<T> next() {
            if (!hasNext())
                throw new NoSuchElementException("Iterator is completed.");
            if (canRemove)
                ptntr = (ptntr == null ? first : ptntr.getNext());  // Why this? Think...
            canRemove = true;
            SNode<T> ntr = curr;
            curr = curr.getNext();   // get element and prepare for future
            return ntr;
        }

        public void remove() {
            if (!canRemove)
                throw new IllegalStateException("Not valid to remove.");
            if (ptntr == null)
                first = first.getNext();             // removes the first node
            else
                ptntr.setNext(ptntr.getNext().getNext());     // removes node after ptntr
            length--;
            canRemove = false;
        }

    }

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

    @Override
    public LinkedList<T> clone() {
        LinkedList<T> listClone = new SLFLList<>(); //or new DLDHDTList<>();, depends which clone you are implementing
        for (T e : this) {
            //---- Copy the information from each node in this list into a temporary node that will then be added into the clone of this list. ----//
            Node<T> tempNode = listClone.createNewNode();
            tempNode.setElement(e);
            listClone.addLastNode(tempNode);
        }
        return listClone;
    }
}

