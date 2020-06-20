package list;

/**
 * @author DebugMouse
 * @date 2020/6/20 17:23
 */
public class Node<T> {
    private T value;
    private Node next;

    public Node(T value) {
        this.value = value;
    }

    public Node() {
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }
}
