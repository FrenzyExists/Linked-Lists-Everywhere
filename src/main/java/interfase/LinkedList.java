package interfase;

import java.util.NoSuchElementException;

/**
 * LinkedList ADT, from which this whole project is about
 * @param <T>
 */
public interface LinkedList<T> extends Iterable<T>, Cloneable {

    /**
     * Returns the size of the linked list (the amount of nodes linked)
     * @return amount of nodes in list, i>=0
     */
    int length();

    /**
     * It will return the first in the linked list, but if if the list is empty it will return null.
     * The operation won't alter the data reference in the affected node, nor any other node in the
     * list
     * @return The first Node in the list.
     * @throws NoSuchElementException There's no first node... its either empty or simply non-existent
     */
    Node<T> getFirstNode() throws NoSuchElementException;

    /**
     *
     * @return The last Node in the list
     * @throws NoSuchElementException There's no last node... its either empty or simply non-existent
     */
    Node<T> getLastNode() throws NoSuchElementException;

    /**
     * Returns a reference to de Node that precedes the Node referenced by target in the list. It is assumed
     * that target corresponds to a Node in the list
     * @param target
     * @return
     */
    Node<T> getNodeBefore(Node<T> target);

    /**
     * Returns a reference to the Node that follows the Node referenced by target in the list. It is assumed
     * that the target Node corresponds to a valid Node in the list
     * @param target
     * @return
     */
    Node<T> getNodeAfter(Node<T> target);

    /**
     *
     * @param newNode
     */
    void addFirstNode(Node<T> newNode);

    /**
     * Insets a node newNode at the end of the list, making the newNode the last node in the list. Its assumed
     * that newNode is a valid node for the current implementation and not an existing node in any list.
     * @param newNode
     */
    void addLastNode(Node<T> newNode);

    /**
     * Inserts a node newNode immediately after the node referenced by target. It is assumed that target
     * corresponds to a node currently in the list. It is also assumed that newNode is a valid node for
     * the current implementation and no an existing node in any list. If valid, the size of the list
     * increases by 1.
     * @param target
     * @param newNode
     */
    void addNodeAfter(Node<T> target, Node<T> newNode);

    /**
     * Inserts a node newNode that will be immediately before the Node being referenced by Target.
     * Its assumed that the target corresponds to a Node in the list. Its also assumed that newNode
     * is a valid node for the current implementation and is not an existing node in  any list.
     * @param target
     * @param newNode
     */
    void addNodeBefore(Node<T> target, Node<T> newNode);

    /**
     * Removes the Node referenced by target in the current instance of the linked list. Size of
     * the list decreases by 1, and relative order of all nodes maintain the same. All nodes are
     * simply shifted depending on where the target is located within the list.
     * @param target - the Node desired to remove from the list, assuming it exists in the list
     */
    void removeNode(Node<T> target);

    /**
     * Creates a new node instance of the type of nodes that the linked list
     * uses. The new node will have all its instance fields initialized to
     * null. The new node is not linked to the list in any way.
     * @return reference to the new node instance.
     */
    Node<T> createNewNode();


    /**
     * Returns an Iterable<Node<E>> object that allows iteration over the
     * nodes in the linked list.
     */
    Iterable<Node<T>> nodes();
}
