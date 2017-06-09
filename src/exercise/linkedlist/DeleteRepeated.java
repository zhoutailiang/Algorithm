package exercise.linkedlist;

import java.util.ArrayList;
import java.util.HashSet;

import exercise.common.Node;
import utils.Utils;

/**
 * Created by zhoutailiang on 2017/6/2.
 */
public class DeleteRepeated {
    public static void main(String[] args) {
        ArrayList<Integer> values = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            values.add(i);
        }
        for (int i = 0; i < 20; i++) {
            values.add(i);
        }
        Node head = Utils.generateLinkedList(values);
        Utils.println(head);
        deleteRepeated(head);
        Utils.println(head);
    }

    private static void deleteRepeated(Node head) {
        HashSet<Integer> hashSet = new HashSet<>();
        Node current = head;
        Node preivous = null;
        while (current != null) {
            if (hashSet.contains(current.value)) {
                preivous.next = current.next;
            } else {
                hashSet.add(current.value);
                preivous = current;
            }
            current = current.next;
        }
    }


}

