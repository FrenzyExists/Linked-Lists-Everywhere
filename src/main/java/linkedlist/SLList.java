package linkedlist;

import interfase.LinkedList;
import interfase.Node;
import node.SNode;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SLList<T> implements LinkedList<T> {
    private SNode<T> first;
    private int length;

    public SLList() {   // to create an empty list instance
        first = null;
        length = 0;
    }

    public void addFirstNode(Node<T> nuevo) {
        // Pre: nuevo is not a node in the list
        ((SNode<T>) nuevo).setNext(first);
        first = (SNode<T>) nuevo;
        length++;
    }

    public void addLastNode(Node<T> nuevo) {
        SNode<T> sNuevo = (SNode<T>) nuevo;
        sNuevo.setNext(null);
        if (length == 0)
            first = sNuevo;
        else {   // find current last node and add the new one after that last node
            SNode<T> p = first;
            while (p.getNext() != null)
                p = (SNode<T>) p.getNext();
            p.setNext(sNuevo);
        }
        length++;
    }

    public void addNodeAfter(Node<T> target, Node<T> nuevo) {
        // Pre: target is a node in the list
        // Pre: nuevo is not a node in the list
        ((SNode<T>) nuevo).setNext(target.getNext());
        ((SNode<T>) target).setNext(nuevo);
        length++;
    }

    public void addNodeBefore(Node<T> target, Node<T> nuevo) {
        // Pre: target is a node in the list
        // Pre: nuevo is not a node in the list

        if (target == first)
            this.addFirstNode(nuevo);
        else {
            Node<T> prevNode = findNodePrevTo(target);
            this.addNodeAfter(prevNode, nuevo);
        }
    }

    private Node<T> findNodePrevTo(Node<T> target) {
        // Pre: target is a node in the list
        if (target == first)  // the list is empty
            return null;
        else {
            SNode<T> prev = first;
            while (prev != null && prev.getNext() != target)
                prev = (SNode<T>) prev.getNext();
            return prev;
        }
    }

    public Node<T> getLastNode() {
        if (first == null)   // the list is empty
            return null;
        else {
            SNode<T> curr = first;
            while (curr.getNext() != null)
                curr = (SNode<T>) curr.getNext();
            return curr;
        }
    }

    public Node<T> getNodeAfter(Node<T> target) {
        // Pre: target is a node in the list
//        SNode<T> aNode = (SNode<T>) ((SNode<T>) target).getNext();
//        if (aNode == null)
//            return null;
//        else
//            return aNode;
        return ((SNode<T>) target).getNext();
    }

    /**
     *
     * @param target
     * @return
     */
    public Node<T> getNodeBefore(Node<T> target) {
        // Pre: target is a node in the list
        if (target == first)
            return null;
        else
            return findNodePrevTo(target);
    }

    /**
     * 
     * @return
     */
    public int length() {
        return this.length;
    }

    /**
     * 
     * @param target - the Node desired to remove from the list, assuming it exists in the list
     */
    public void removeNode(Node<T> target) {
        // Pre: target is a node in the list; hence, the list is not empty

        if (target == first)
            first = (SNode<T>) first.getNext();
        else {
            SNode<T> prevNode = (SNode<T>) this.getNodeBefore(target);
            prevNode.setNext(target.getNext());
        }
        target.clean();   // clear all references from target
        length--;
    }


    /**
     * 
     * @return
     * @throws NoSuchElementException
     */
    public Node<T> getFirstNode()
            throws NoSuchElementException {
        if (first == null)
            throw new NoSuchElementException("getFirstNode() : linked list is empty...");

        // the linked list is not empty....
        return first;
    }

    /**
     * Prepares every node so that the garbage collector can free
     * its memory space, at least from the point of view of the
     * list. This method is supposed to be used whenever the
     * list object is not going to be used anymore. Removes all
     * physical nodes (data nodes and control nodes, if any)
     * from the linked list
     */
    private void destroy() {
        while (first != null) {
            SNode<T> nnode = (SNode<T>) first.getNext();
            first.setElement(null);
            first.setNext(null);
            first = nnode;
        }
    }

    /**
     * The execution of this method removes all the data nodes
     * from the current instance of the list. The list becomes
     * an empty list. Notice that in general this is not the
     * same as destroy(). However, in this type of list it
     * can be done by first invoking the destroy method and
     * then make length = 0.
     * <p>
     * NOTE: For other types of list, this strategy may not
     * be correct as it is here.
     */
    public void makeEmpty() {
        destroy();
        length = 0;
    }

    /**
     * 
     * @return
     */
    public Node<T> createNewNode() {
        return new SNode<T>();
    }
    
    @Override
    public Iterable<Node<T>> nodes() {
        return new NodesIterable();
    }


    @Override
    public Iterator<T> iterator() {
        return new ElementsIterator();
    }

    private class NodesIterable implements Iterable<Node<T>> {

        @Override
        public Iterator<Node<T>> iterator() {
            return new NodesIterator();
        }

    }

    private class ElementsIterator implements Iterator<T> {

        NodesIterator nodesIter = new NodesIterator();

        @Override
        public boolean hasNext() {
            return nodesIter.hasNext();
        }

        @Override
        public T next() {
            return nodesIter.next().getElement();
        }

        public void remove() {
            nodesIter.remove();
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
                ptntr = (ptntr == null ? first : (SNode<T>) ptntr.getNext());  // Why this? Think...
            canRemove = true;
            SNode<T> ntr = curr;
            curr = (SNode<T>) curr.getNext();   // get element and prepare for future
            return ntr;
        }

        public void remove() {
            if (!canRemove)
                throw new IllegalStateException("Not valid to remove.");
            if (ptntr == null)
                first = (SNode<T>) first.getNext();             // removes the first node
            else
                ptntr.setNext(ptntr.getNext().getNext());     // removes node after ptntr
            length--;
            canRemove = false;
        }

    }
}
