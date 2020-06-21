package sort;

/**
 * @author DebugMouse
 * @date 2020/6/21 14:16
 */
public class BubbleSort{
    public static <T extends Comparable<T>> void sort(T[] values) {
        int valueLength = values.length;
        for (int i = 0; i < valueLength; i++) {
            boolean flag = true;
            for (int j = 0; j < valueLength - i - 1; j++) {
                if (values[j].compareTo(values[j+1]) > 0) {
                    flag = false;
                    T temp = values[j+1];
                    values[j+1] = values[j];
                    values[j] = temp;
                }
            }
            if (flag) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] values = {4, 1, 5, 2, 6};
        BubbleSort.sort(values);
        for (Integer value : values) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
