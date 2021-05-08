package linkedLists;

import interfase.LinkedList;
import interfase.Node;

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
        return new DNode<T>();
    }

    public Node<T> getFirstNode() throws NoSuchElementException {
        if (length == 0)
            return null;
        return header.getNext();
    }

    public Node<T> getLastNode() throws NoSuchElementException {
        if (length == 0)
            return null;
        return trailer.getPrev();
    }

    public Node<T> getNodeAfter(Node<T> target) {
        // ADD CODE HERE AND MODIFY RETURN ACCORDINGLY
        return null;
    }

    public Node<T> getNodeBefore(Node<T> target) {
        // ADD CODE HERE AND MODIFY RETURN ACCORDINGLY
        return null;
    }

    public int length() {
        return length;
    }

    public void removeNode(Node<T> target) {
        // ADD CODE HERE to disconnect target from the linked list, reduce lent, clean target...
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
            DNode<T> nnode = header.getNext();
            header.clean();
            header = nnode;
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

    @Override
    public Iterable<Node<T>> nodes() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        return null;
    }

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
}
