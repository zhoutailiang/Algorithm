package exercise.chapter01;

import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

import utils.Utils;

/**
 * Created by zhoutailiang on 2017/4/27.
 */
public class GenerateWindowMaxValue {
    public static void main(String[] args) {
        int[] arr = {4, 3, 5, 4, 3, 3, 6, 7, 8, 9, 3, 6, 8, 1, 2, 1, 1, 1, 1, 1, 1, 7, 9, 90, 43, 654, 21, 54, 76, 43, 76, 98, 1};
        int windowSize = 1;
        Utils.println(Arrays.toString(generateWindowMaxValue(arr, windowSize)));
    }

    private static int[] generateWindowMaxValue(int[] arr, int windowSize) {
        int resultSize = arr.length - windowSize + 1;
        int[] result = new int[resultSize];
        int resultIndex = 0;
        Deque<Integer> deque = new LinkedList<>();
        for (int index = 0; index < arr.length; index++) {
            if (deque.size() == 0) {
                deque.addLast(index);
                //1.判断是否满足最大窗口
                if (index >= windowSize - 1) {
                    result[resultIndex++] = arr[deque.getFirst()];
                }
            } else {
                //1.去掉过时的元素
                if (deque.peekFirst() == index - windowSize) {
                    deque.removeFirst();
                }
                //2.入队列
                if (arr[index] <= arr[deque.peekLast()]) {
                    deque.addLast(index);
                } else {
                    Iterator<Integer> iterator = deque.descendingIterator();
                    while (iterator.hasNext()) {
                        Integer next = iterator.next();
                        if (arr[index] > next) {
                            iterator.remove();
                        } else {
                            break;
                        }
                    }
                    deque.addLast(index);
                }
                //3.判断是否满足最大窗口
                if (index >= windowSize - 1) {
                    result[resultIndex++] = arr[deque.getFirst()];
                }
            }
        }
        return result;
    }
}
