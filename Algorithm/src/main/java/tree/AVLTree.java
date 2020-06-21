package tree;

import java.util.List;

/**
 * @author DebugMouse
 * @date 2020/6/21 10:21
 */
public class AVLTree <T extends Comparable<T>> extends Tree<T> {
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


    public AVLTree() {

    }

    public AVLTree(T[] values) {
       buildTree(values);
    }

    public Node<T> buildTree(Node<T> root, T value) {
        if (root == null) {
            return new Node<>(value);
        }
        if (root.getValue().compareTo(value) >= 0) {
            root.setLeft(buildTree(root.getLeft(), value));
            if (getHeight(root.getLeft()) - getHeight(root.getRight()) > 1) {
                if (getHeight(root.getLeft().getLeft()) > getHeight(root.getLeft().getRight())) {
                    root = rightRotate(root);
                } else {
                    root = leftRightRotate(root);
                }
            }
        } else {
            root.setRight(buildTree(root.getRight(), value));
            if (getHeight(root.getRight()) - getHeight(root.getLeft()) > 1) {
                if (getHeight(root.getRight().getRight()) > getHeight(root.getRight().getLeft())) {
                    root = leftRotate(root);
                } else {
                    root = rightLeftRotate(root);
                }
            }
        }
        return root;
    }

    private Node<T> leftRotate(Node<T> root) {
        Node<T> right = root.getRight();
        root.setRight(right.getLeft());
        right.setLeft(root);
        return right;
    }

    private Node<T> rightRotate(Node<T> root) {
        Node<T> left = root.getLeft();
        root.setLeft(left.getRight());
        left.setRight(root);
        return left;
    }

    private Node<T> rightLeftRotate(Node<T> root) {
        root.setRight(rightRotate(root.getRight()));
        return leftRotate(root);
    }

    private Node<T> leftRightRotate(Node<T> root) {
        root.setLeft(leftRotate(root.getLeft()));
        return rightRotate(root);
    }

    public static void main(String[] args) {
        Integer[] values = {10, 12};
        AVLTree<Integer> demo = new AVLTree<>(values);
        List<Integer> preOrder = demo.preOrder();
        demo.preOrder().forEach(ele -> System.out.print(ele + " "));
        System.out.println();
        demo.inOrder().forEach(ele -> System.out.print(ele + " "));
        System.out.println();
        demo.postOrder().forEach(ele -> System.out.print(ele + " "));
        System.out.println();
        preOrder.forEach(ele -> System.out.print(ele + " "));
    }
}
