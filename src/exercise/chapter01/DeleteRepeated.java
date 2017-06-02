package exercise.chapter01;

import java.util.ArrayList;
import java.util.HashSet;

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
        Node head = generateLinkedList(values);
        Utils.println(head);
        deleteRepeated(head);
        Utils.println(head);
    }

    private static void deleteRepeated(Node head) {
        HashSet<Integer> hashSet = new HashSet<>();
        Node current = head;
        Node preivous = null;
        while (current != null) {
            if (hashSet.contains(head.value)) {
                preivous.next = current.next;
            } else {
                hashSet.add(head.value);
                preivous = current;
            }
            current = current.next;
        }
    }

    private static Node generateLinkedList(ArrayList<Integer> values) {
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

    static class Node {
        Node next;
        int value;

        public Node(int value) {
            this.next = next;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "next=" + next +
                    ", value=" + value +
                    '}';
        }
    }
}

