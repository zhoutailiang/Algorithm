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
        for (int i = 8; i >= 1; i--) {
            values.add(i);
        }
        Node head = Utils.generateLinkedList(values);
        Utils.println(head);
        Utils.println(findTheReciprocalKNodeByIteration(head, 5).value);
        findTheReciprocalKNodeByRecursion1(head, 5);
        Utils.println(findTheReciprocalKNodeByRecursion2(head, 5, new IntWrapper()).value);

    }


    private static Node findTheReciprocalKNodeByIteration(Node head, int k) {
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

    private static int findTheReciprocalKNodeByRecursion1(Node head, int k) {
        if (head == null) {
            return 0;
        }
        int i = findTheReciprocalKNodeByRecursion1(head.next, k) + 1;
        if (i == k) {
            Utils.println(head.value);
        }
        return i;
    }

    private static Node findTheReciprocalKNodeByRecursion2(Node head, int k, IntWrapper i) {
        if (head == null) {
            return null;
        }
        Node node = findTheReciprocalKNodeByRecursion2(head.next, k, i);
        i.value = i.value + 1;
        if (i.value == k) {
            return head;
        }
        return node;
    }

    static class IntWrapper {
        int value = 0;
    }
}
