package exercise.linkedlist;

import java.util.ArrayList;

import exercise.common.Node;
import utils.Utils;

/**
 * Created by zhoutailiang on 2017/6/9.
 */
public class FindTheReciprocalKNode {
    public static void main(String[] args) {
        ArrayList<Integer> values = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            values.add(i);
        }
        Node head = Utils.generateLinkedList(values);
        Utils.println(head);
        Utils.println(findTheReciprocalKNode(head,19).value);
    }

    private static Node findTheReciprocalKNode(Node head, int k) {
        Node first = head;
        Node second = head;
        int currentElement = 1;
        while (first != null && currentElement < k) {
            first = first.next;
            currentElement++;
        }
        while (first.next != null && second.next != null) {
            first = first.next;
            second = second.next;
        }
        return second;
    }
}
