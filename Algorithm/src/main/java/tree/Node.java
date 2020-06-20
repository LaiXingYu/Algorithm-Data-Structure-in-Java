package tree;

/**
 * @author DebugMouse
 * @date 2020/6/20 17:25
 */
public class Node <T extends Comparable<T>>{
    private T value;
    private Node<T> left;
    private Node<T> right;
    public Node(T value) {
        this.value = value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public Node() {}

    public T getValue() {
        return value;
    }

    public Node<T> getLeft() {
        return left;
    }

    public Node<T> getRight() {
        return right;
    }
}
