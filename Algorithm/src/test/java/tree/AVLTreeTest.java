package tree;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * @author DebugMouse
 * @date 2020/6/21 11:18
 */
public class AVLTreeTest {
    private List<Integer> values = new ArrayList<>();
    private List<Integer> preOrder = new ArrayList<>();
    private List<Integer> inOrder = new ArrayList<>();
    private List<Integer> postOrder = new ArrayList<>();

    @Test
    public void test1() {
        test("src/test/resources/avlTreeTestCase/case1.txt");
    }

    @Test
    public void test2() {
        test("src/test/resources/avlTreeTestCase/case2.txt");
    }

    @Test
    public void test3() {
        test("src/test/resources/avlTreeTestCase/case3.txt");
    }

    @Test
    public void test4() {
        test("src/test/resources/avlTreeTestCase/case4.txt");
    }

    @Test
    public void test5() {
        test("src/test/resources/avlTreeTestCase/case5.txt");
    }

    @Test
    public void test6() {
        test("src/test/resources/avlTreeTestCase/case6.txt");
    }

    @Test
    public void test7() {
        test("src/test/resources/avlTreeTestCase/case7.txt");
    }

    @Test
    public void test8() {
        test("src/test/resources/avlTreeTestCase/case7.txt");
    }

    private void test(String path) {
        loadTestCase(path);
        Integer[] numbers = new Integer[values.size()];
        for (int i = 0; i < values.size(); i++) {
            numbers[i] = values.get(i);
        }
        AVLTree<Integer> demo = new AVLTree<>(numbers);
        assertTrue(isEqual(demo.preOrder(), this.preOrder));
        assertTrue(isEqual(demo.inOrder(), this.inOrder));
        assertTrue(isEqual(demo.postOrder(), this.postOrder));
    }


    private void loadTestCase(String path) {
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(new File(path)), "utf-8");
            BufferedReader reader = new BufferedReader(inputStreamReader);
            readLine(reader, this.values);
            readLine(reader, this.preOrder);
            readLine(reader, this.inOrder);
            readLine(reader, this.postOrder);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readLine(BufferedReader reader, List<Integer> list) throws IOException {
        String line = reader.readLine();
        String[] numbers = line.split(",");
        for (String number : numbers) {
            list.add(Integer.parseInt(number));
        }
    }

    private boolean isEqual(List<Integer> list1, List<Integer> list2) {
        if (list1 == null && list2 == null) {
            return true;
        }
        if (list1 == null || list2 == null || list1.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i) != list2.get(i)) {
                return false;
            }
        }
        return true;
    }
}