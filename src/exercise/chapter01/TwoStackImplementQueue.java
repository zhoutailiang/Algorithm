package exercise.chapter01;

import utils.Utils;

import java.util.Stack;

/**
 * Created by zhoutailiang on 2017/3/8.
 * 【题目】
 * 编写一个类，用两个栈实现队列，支持队列的基本操作（add、poll、peek）。
 * 【难度】
 * **
 * 【思路】
 * 1.假设两个栈记为stack1和stack2。
 * 2.入队规则
 * 直接入栈stack1
 * 3.出队规则
 * （1）挨个将元素从stack1弹到stack2，返回stack2的栈顶元素。
 * （2）挨个将stack2中的元素弹出到stack1。
 * 4.通过以上出队规则，保证了队列的FIFO原则。
 * 5.若果队列add了很多元素，这个时候如果依次poll出去，如果按照步骤三中的实现方式，每取一次元素会先挨个将元素从stack1弹到
 * stack2，取出栈底元素后再将元素全部弹入stack1，这样效率很低。
 * 可以进一步优化，在做步骤3时，只做第一小步骤，如果下次是出队列，则直接从stack2中弹出即可。这一步优化会大大提高连续
 * 的poll操作的效率。
 */
public class TwoStackImplementQueue {
    public static void main(String[] args) {
        //Test
        MyQueue<Integer> myQueue = new MyQueue<>();
        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(3);
        myQueue.add(4);
        myQueue.add(5);
        myQueue.add(6);
        myQueue.add(7);
        myQueue.add(8);
        Utils.println(myQueue.peek());
        Utils.println(myQueue.poll());
        Utils.println(myQueue.poll());
        Utils.println(myQueue.poll());
        Utils.println(myQueue.peek());
        Utils.println(myQueue.poll());
        Utils.println(myQueue.poll());
        Utils.println(myQueue.peek());
        Utils.println(myQueue.poll());
    }
}

class MyQueue<E> {
    private Stack<E> mStack1;
    private Stack<E> mStack2;

    public MyQueue() {
        this.mStack1 = new Stack();
        this.mStack2 = new Stack();
    }

    public void add(E element) {
        if (!mStack2.isEmpty()) {
            popElement(mStack2, mStack1);
        }
        mStack1.push(element);
    }

    public E poll() {
        if (!isEmpty()) {
            if (mStack2.isEmpty()) {
                //从stack1挨个弹到stack2
                popElement(mStack1, mStack2);
            }
            return mStack2.pop();

        }
        return null;
    }

    public E peek() {
        if (!isEmpty()) {
            if (mStack2.isEmpty()) {
                //从stack1挨个弹到stack2
                popElement(mStack1, mStack2);
            }
            return mStack2.peek();

        }
        return null;
    }

    private void popElement(Stack<E> from, Stack<E> to) {
        if (!from.isEmpty()) {
            //从from挨个弹到to
            int fromSize = from.size();
            for (int i = 0; i < fromSize; i++) {
                to.push(from.pop());
            }
        }

    }


    public boolean isEmpty() {
        return mStack1.isEmpty() && mStack2.isEmpty();
    }
}