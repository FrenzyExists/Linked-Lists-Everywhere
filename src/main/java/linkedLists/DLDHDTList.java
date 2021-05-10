package linkedLists;

import interfases.LinkedList;
import interfases.Node;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DLDHDTList<T> extends AbstractDLList<T> {
    private DNode<T> header, trailer;
    private int length;

    //constructor:
    public DLDHDTList() {
        header = new DNode<>();
        trailer =new DNode<>();
        header.setNext(trailer);
        trailer.setPrev(header);
        length = 0;
    }

    public void addFirstNode(Node<T> newNode) {
        addNodeAfter(header, newNode);
    }

    public void addLastNode(Node<T> newNode) {
        DNode<T> dNewNode = (DNode<T>) newNode;
        DNode<T> nBefore = trailer.getPrev();
        nBefore.setNext(dNewNode);
        trailer.setPrev(dNewNode);
        dNewNode.setPrev(nBefore);
        dNewNode.setNext(trailer);
        length++;
    }

    public void addNodeAfter(Node<T> target, Node<T> newNode) {
        DNode<T> dNewNode = (DNode<T>) newNode;
        DNode<T> nBefore = (DNode<T>) target;
        DNode<T> nAfter = nBefore.getNext();
        nBefore.setNext(dNewNode);
        nAfter.setPrev(dNewNode);
        dNewNode.setPrev(nBefore);
        dNewNode.setNext(nAfter);
        length++;
    }

    public void addNodeBefore(Node<T> target, Node<T> nuevo) {
        DNode<T> targetNode = (DNode<T>) target;
        DNode<T> newNode = (DNode<T>) nuevo;

        newNode.setPrev(targetNode.getPrev());
        newNode.setNext(targetNode);

        targetNode.setPrev(newNode);
        targetNode.setNext(targetNode.getNext());

        length++;
    }

    public Node<T> createNewNode() {
        return new DNode<>();
    }

    public Node<T> getFirstNode() throws NoSuchElementException {
        if (length == 0)
            throw new NoSuchElementException("getFirstNode: The list is empty");
        return header.getNext();
    }

    public Node<T> getLastNode() throws NoSuchElementException {
        if (length == 0)
            throw new NoSuchElementException("getFirstNode: The list is empty");
        return trailer.getPrev();
    }

    public Node<T> getNodeAfter(Node<T> target) {
        if (length == 0)
            throw new NoSuchElementException("getNodeAfter: list is empty");
        return ((DNode<T>) target).getNext();
    }

    public Node<T> getNodeBefore(Node<T> target) {
        if (length == 0)
            throw new NoSuchElementException("getNodeBefore: list is empty");
        return ((DNode<T>) target).getPrev();
    }

    /**
     *
     * @return
     */
    public int length() {
        return length;
    }

    /**
     *
     * @param target - the Node desired to remove from the list, assuming it exists in the list
     */
    public void removeNode(Node<T> target) {
        DNode<T> tNode = (DNode<T>) target; //targeted node
        tNode.getPrev().setNext(tNode.getNext());
        tNode.getNext().setPrev(tNode.getPrev());
        length--;
        tNode.clean();
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
        while (header != null) {
            DNode<T> nodeToBeDestroyed = header.getNext();
            header.clean();
            header = nodeToBeDestroyed;
        }
    }

    /**
     * The execution of this method removes all the data nodes from
     * the current instance of the list, leaving it as a valid empty
     * doubly linked list with dummy header and dummy trailer nodes. 
     */
    public void makeEmpty() {
        DNode<T> dummyTrailerNode = header;
        while(trailer.getNext() != null) {
            dummyTrailerNode.setNext(null);
        }
    }

    /**
     *
     * @return
     */
    @Override
    public Iterable<Node<T>> nodes() {
        return new DLDHDTList<T>.NodesIterable();
    }

    private class NodesIterable implements Iterable<Node<T>> {

        @Override
        public Iterator<Node<T>> iterator() {
            return new DLDHDTList<T>.NodesIterator();
        }
    }

    /**
     *
     * @return
     */
    @Override
    public Iterator<T> iterator() {
        return new DLDHDTList<T>.ElementsIterator();
    }

    private class ElementsIterator implements Iterator<T> {

        DLDHDTList<T>.NodesIterator nodesIter = new DLDHDTList<T>.NodesIterator();

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

    /**
     * 
     * @return
     */
    @Override
    public LinkedList<T> clone() {
        LinkedList<T> listClone = new DLDHDTList<>(); //or new DLDHDTList<>();, depends which clone you are implementing

        for (T e : this) {
            //---- Copy the information from each node in this list into a temporary node that will then be added into the clone of this list. ----//
            Node<T> tempNode = listClone.createNewNode();
            tempNode.setElement(e);
            listClone.addLastNode(tempNode);
        }
        return listClone;
    }

    /**
     * 
     */
    private class NodesIterator implements Iterator<Node<T>> {
        private DNode<T> curr = header.getNext();
        private DNode<T> ptntr = null;
        private boolean canRemove = false;

        public boolean hasNext() {
            return curr != null;
        }

        public DLDHDTList.DNode<T> next() {
            if (!hasNext())
                throw new NoSuchElementException("Iterator is completed.");
            if (canRemove)
                ptntr = (ptntr == null ? curr : ptntr.getNext());
            canRemove = true;
            DLDHDTList.DNode<T> ntr = curr;
            curr = curr.getNext();
            return ntr;
        }

        /**
         * 
         */
        public void remove() {
            if (!canRemove)
                throw new IllegalStateException("Not valid to remove.");
            if (ptntr == null)
                curr = curr.getNext();
            else
                ptntr.setNext(ptntr.getNext().getNext());
            length--;
            canRemove = false;
        }
    }
}
