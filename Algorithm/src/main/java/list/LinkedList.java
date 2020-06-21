package list;

/**
 * @author DebugMouse
 * @date 2020/6/21 13:59
 */
public class LinkedList<T> {
    Node<T> head;

    public LinkedList(T[] values) {
        head = buildList(values);
    }

    private Node<T> buildList(T[] values) {
        Node<T> headNode = new Node<>();
        Node<T> currentNode = headNode;
        for (T value : values) {
            currentNode.setNext(new Node<T>(value));
            currentNode = currentNode.getNext();
        }
        return headNode;
    }

    public String printList() {
        Node<T> currentNode = head.getNext();
        if (currentNode == null) {
            System.out.println("List is Empty!");
            return "List is Empty!";
        }
        StringBuilder listValue = new StringBuilder();
        while (currentNode != null) {
            if (currentNode != head.getNext()) {
                listValue.append("->");
            }
            listValue.append(currentNode.getValue());
            currentNode = currentNode.getNext();
        }
        System.out.println(listValue.toString());
        return listValue.toString();
    }
}
