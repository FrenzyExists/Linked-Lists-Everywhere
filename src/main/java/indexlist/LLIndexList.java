package indexlist;

import interfase.IndexList;
import interfase.LinkedList;
import interfase.Node;

public class LLIndexList<T> implements IndexList<T> {

    private LinkedList<T> internalLL;

    /**
     Creates an empty instance of a list. 
     **/
    public LLIndexList(LinkedList<T> theList) {
        internalLL = theList;
    }

    /**
     Determines the size of the list. 
     @return size of the list � number of elements. 
     **/
    public int size() {
        return internalLL.length();
    }

    /**
     Determines if the list is empty. 	
     @return true if empty, false if not. 
     **/
    public boolean isEmpty() {
        return this.size() == 0;
    }

    /**
     Private method to access the data node at the
     position given in the internal linked list. 
     If the list is not empty, he first data node 
     has position 0, the following data node (if any)
     has position 1, and so on. 
     @param posIndex the index of the position being 
     accessed. 
     @return reference to the data node in the given
     position of the internal linked list. 
     **/
    private Node<T> getDataNodeAtPosition(int posIndex)
    {

        Node<T> target = internalLL.getFirstNode();
        for (int p=1; p<= posIndex; p++)
            target = internalLL.getNodeAfter(target);
        return target;
    }

    /**
     * Adds a new element to the list.
     * @param index - the index of the position where the new element is to be inserted.
     * @param e the new element to insert.
     * @throws IndexOutOfBoundsException if the index i does not corresponds to the index of a valid
     * position to insert
     **/
    public void add(int index, T e)
            throws IndexOutOfBoundsException
    {
        if (index < 0  ||  index > internalLL.length())
            throw new IndexOutOfBoundsException("add: index=" + index + " is out of bounds. size = " +
                    internalLL.length());

        Node<T> newNode = internalLL.createNewNode();
        newNode.setElement(e);
        if (index==0)
            internalLL.addFirstNode(newNode);
        else {
            Node<T> previousNode = getDataNodeAtPosition(index-1);
            internalLL.addNodeAfter(previousNode, newNode);
        }
    }

    public void add(T e) {
        Node<T> newNode = internalLL.createNewNode();
        newNode.setElement(e);
        Node<T> previousNode = internalLL.getLastNode();
        internalLL.addNodeAfter(previousNode, newNode);

    }

    public T get(int index) throws IndexOutOfBoundsException {
        if (index < 0  ||  index >= internalLL.length())
            throw new IndexOutOfBoundsException("get: index=" + index + " is out of bounds.");

        Node<T> targetINode = this.getDataNodeAtPosition(index);
        return targetINode.getElement();
    }

    public T remove(int index) throws IndexOutOfBoundsException {
        if (index < 0  ||  index >= internalLL.length())
            throw new IndexOutOfBoundsException("remove: index=" + index + " is out of bounds.");

        Node<T> ntr = this.getDataNodeAtPosition(index);
        T etr = ntr.getElement();
        this.internalLL.removeNode(ntr);

        return etr;
    }

    public T set(int index, T e) throws IndexOutOfBoundsException {
        if (index < 0  ||  index >= internalLL.length())
            throw new IndexOutOfBoundsException("set: index=" + index + " is out of bounds.");

        Node<T> ntc = this.getDataNodeAtPosition(index);
        T etr = ntc.getElement();
        ntc.setElement(e);
        return etr;
    }
    
}
