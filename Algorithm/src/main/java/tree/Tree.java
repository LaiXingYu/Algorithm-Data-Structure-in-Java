package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author DebugMouse
 * @date 2020/6/20 17:27
 */
public abstract class Tree<T extends Comparable<T>> {
    private Node<T> root;


    /**
     * 前序遍历树
     *
     * @return 返回前序遍历序列
     */
    public List<T> preOrder() {
        List<T> preOrderList = new ArrayList<T>();
        preOrder(this.root, preOrderList);
        return preOrderList;
    }

    private void preOrder(Node<T> root, List<T> record) {
        if (root == null) {
            return;
        }
        record.add(root.getValue());
        if (root.getLeft() != null) {
            preOrder(root.getLeft(), record);
        }
        if (root.getRight() != null) {
            preOrder(root.getRight(), record);
        }
    }

    /**
     * 中序遍历树
     *
     * @return 返回中序遍历序列
     */
    public List<T> inOrder() {
        List<T> record = new ArrayList<>();
        inOrder(this.root, record);
        return record;
    }

    private void inOrder(Node<T> root, List<T> record) {
        if (root == null) {
            return;
        }
        if (root.getLeft() != null) {
            inOrder(root.getLeft(), record);
        }
        record.add(root.getValue());
        if (root.getLeft() != null) {
            inOrder(root.getRight(), record);
        }
    }

    /**
     * 后续遍历树
     *
     * @return 返回后续遍历序列
     */
    public List<T> postOrder() {
        List<T> record = new ArrayList<>();
        postOrder(this.root, record);
        return record;
    }

    private void postOrder(Node<T> root, List<T> record) {
        if (root == null) {
            return;
        }
        if (root.getLeft() != null) {
            postOrder(root.getLeft(), record);
        }
        if (root.getRight() != null) {
            postOrder(root.getRight(), record);
        }
        record.add(root.getValue());
    }
    /**
     * 打印树
     */
    public abstract void printTree();

    /**
     * @return 返回树的高度
     */
    public int getHeight() {
        return getHeight(this.root);
    }

    private int getHeight(Node root) {
        if (root == null) {
            return 0;
        }
        int left = getHeight(root.getLeft());
        int right = getHeight(root.getRight());
        return Math.max(left, right) + 1;
    }

    /**
     * 创建树
     *
     * @param values 树节点的值
     */
    public void build(T[] values) {
        this.root = buildTree(this.root, values);
    }
    /**
     * 根据数组值创建树
     *
     * @param values 树节点值集合
     * @param root 树的根节点
     * @return 返回树的根节点
     */
    public abstract Node<T> buildTree(Node<T> root, T[] values);
}
