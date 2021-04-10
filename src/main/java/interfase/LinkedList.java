package interfase;

/**
 * LinkedList ADT, from which this whole project is about
 * @param <T>
 */
public interface LinkedList<T>  extends Iterable<T> {

    int length();

    Node<T> getFirstNode();

    Node<T> getLastNode();


}
