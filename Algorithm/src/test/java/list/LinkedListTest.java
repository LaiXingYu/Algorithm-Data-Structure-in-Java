package list;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * @author DebugMouse
 * @date 2020/6/21 14:08
 */
public class LinkedListTest extends TestCase {
    @Test
    public void test1() {
        Integer[] values = {1, 2, 3, 4, 5};
        LinkedList<Integer> demo = new LinkedList<Integer>(values);
        assertEquals(demo.printList(), "1->2->3->4->5");
    }

    @Test
    public void test2() {
        Integer[] values = {};
        LinkedList<Integer> demo = new LinkedList<>(values);
        assertEquals(demo.printList(), "List is Empty!12q");
    }
}