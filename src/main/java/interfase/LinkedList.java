package interfase;

import java.util.NoSuchElementException;

/**
 * LinkedList ADT, from which this whole project is about
 * @param <T>
 */
public interface LinkedList<T>  extends Iterable<T> {

    /**
     * Returns the size of the linked list (the amount of nodes linked)
     * @return amount of nodes in list
     */
    int length();

    /**
     *
     * @return The first Node in the list
     * @throws NoSuchElementException There's no first node... its either empty or simply non-existent
     */
    Node<T> getFirstNode() throws NoSuchElementException;

    /**
     *
     * @return The last Node in the list
     * @throws NoSuchElementException There's no last node... its either empty or simply non-existent
     */
    Node<T> getLastNode() throws NoSuchElementException;


}
