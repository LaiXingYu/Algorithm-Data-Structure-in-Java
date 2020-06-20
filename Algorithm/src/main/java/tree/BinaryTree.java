package tree;

import java.util.List;

/**
 * @author DebugMouse
 * @date 2020/6/20 17:27
 */
public class BinaryTree <T extends Comparable<T>> extends Tree<T>{
    public BinaryTree() {

    }

    public BinaryTree(T[] values){
        build(values);
    }
    @Override
    public void printTree() {

    }

    @Override
    public Node<T> buildTree(Node<T> root, T[] values) {
        for (T value : values) {
            root = buildTree(root, value);
        }
        return root;
    }

    private Node<T> buildTree(Node<T> root, T value) {
        if (root == null) {
            return new Node<>(value);
        }
        if (root.getValue().compareTo(value) >= 0) {
            root.setLeft(buildTree(root.getLeft(), value));
        } else {
            root.setRight(buildTree(root.getRight(), value));
        }
        return root;
    }

    public static void main(String[] args) {
        Integer[] values = {4, 2, 1, 3, 6, 5, 7};
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.build(values);
        List<Integer> preOrder = tree.inOrder();
        preOrder.forEach(row-> System.out.print(row + " "));
    }
}
