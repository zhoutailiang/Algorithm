package exercise.common;

/**
 * Created by zhoutailiang on 2017/6/9.
 */
public class Node {
    public Node next;
    public int value;

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
