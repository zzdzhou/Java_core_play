package jack.javacore.exercise;

import org.junit.Test;

import java.util.LinkedList;

public class Sort {

    //冒泡排序法
    @Test
    public void sort() {
        int[] array = new int[]{2, 9,3,0,1,6,7,5,7,9,21};
        int temp = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                temp = array[j];
                if (temp > array[j + 1]) {
                    array[j] = array[j + 1];
                    array[j+1] = temp;
                }
            }
        }
        for (Integer item : array) {
            System.out.println(item);
        }
    }

    public void sortByMe() {
        int[] array = new int[]{2, 9,3,0,1,6,7,5};
        LinkedList<Integer> sorted = new LinkedList<>();
        for (Integer item : array) {
            if (sorted.size() == 0) {
                sorted.add(item);
                continue;
            }
            for (int i = 0; i < sorted.size(); i++) {

            }
        }

    }


}
