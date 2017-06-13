package exercise.linkedlist;

import java.util.ArrayList;

import exercise.common.Node;
import utils.Utils;

/**
 * Created by zhoutailiang on 2017/6/13.
 */
public class DeleteNode {
    public static void main(String[] args) {
        ArrayList<Integer> values = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            values.add(i);
        }
        Node head = Utils.generateLinkedList(values);
        Utils.println(head);
        deleteNode(head.next.next.next);
        Utils.println(head);
    }

    private static boolean deleteNode(Node node) {
        if (node == null || node.next == null) {
            return false;
        }
        Node current = node;
        current.value = current.next.value;
        current.next = current.next.next;
        return true;
    }
}
