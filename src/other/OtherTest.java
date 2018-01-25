package other;

/**
 * Created by tailiang on 2017/4/10.
 */
public class OtherTest {

    public static void main(String[] args) {
        Node head = generateLinkedList();

        if (head != null) {
            int currentValue = head.value;
            Node currentNode = head.next;
            while (currentNode!=null) {
                if (currentValue==currentNode.next.value) {
                    currentNode.next = currentNode.next.next;
                }

            }
        }
    }

    public static Node generateLinkedList() {
        Node head = null;
        Node currentTail = null;
        for (int i = 0; i < 20; i++) {
            if (i == 0 && head == null) {
                head = new Node();
                head.value = i;
                currentTail = head;
            } else {
                Node node = new Node();
                node.value = i;
                currentTail.next = node;
                currentTail = node;
            }
        }
        for (int i = 0; i < 20; i++) {
            if (i == 0 && head == null) {
                head = new Node();
                head.value = i;
                currentTail = head;
            } else {
                Node node = new Node();
                node.value = i;
                currentTail.next = node;
                currentTail = node;
            }
        }
        return head;
    }

    static class Node {
        int value;
        Node next;

    }
}