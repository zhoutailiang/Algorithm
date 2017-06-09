package utils;

import java.util.ArrayList;

import exercise.common.Node;

/**
 * Created by zhoutailiang on 2017/3/8.
 */
public class Utils {
    public static void println(Object obj){
        System.out.println(obj);
    }
    public static void printTwoDimensionArray(int [][] arr){
        for (int i = 0; i < arr.length; i++) {
            int [] oneDimensionArray=arr[i];
            System.out.print("[");
            for (int j = 0; j < oneDimensionArray.length; j++) {
                System.out.print(oneDimensionArray[j]);
                if (j!=oneDimensionArray.length-1){
                    System.out.print(",");
                }
            }
            System.out.println("]");
        }
    }
    public static Node generateLinkedList(ArrayList<Integer> values) {
        Node head = null;
        Node current = null;
        for (int i = 0; i < values.size(); i++) {
            Node node = new Node(values.get(i));
            if (i == 0) {
                head = node;
                current = head;
            } else {
                current.next = node;
                current = current.next;
            }
        }
        return head;
    }
}
