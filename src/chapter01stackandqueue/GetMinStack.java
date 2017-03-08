package chapter01stackandqueue;

import java.util.Stack;

/**
 * Created by zhoutailiang on 2017/3/7.
 *【题目】
 * 实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作。
 *【要求】
 * 1.pop、push、getMin操作的时间复杂度都是O(1)。
 * 2.设计的类型可以使用现成的栈结构
 *【难度】
 * *
 *【思路】
 * 1.可以用现有的栈结构，所以对于push和pop操作很容易实现，借用现有的Stack类即可，就算不借助Stack类自己实现也很容易。
 * 2.对与getMin功能，可以用一个辅助栈，用于记录每次入栈时最小元素的索引。
 * 具体步骤如下：
 * 在每次push时判断这个元素是否小于等于栈中最小元素，如果是的话，push的同是将这个元素的索引入栈到索引栈，如果不是只push元素本身到数据栈中。
 * 每次pop出栈的时候判断是否是索引栈栈顶元素，如果是的话同时pop索引栈，不是只pop数据本身。
 * 这样始终保证索引栈中的栈顶元素是数据栈中的最小值的索引，每次getMin的时候直接随机访问，时间复杂度O(1)。
 */
public class GetMinStack {
    public static void main(String[] args) {
        //Test
        MyStack<Integer> stack = new MyStack<>();
        stack.push(89);
        stack.push(67);
        stack.push(77);
        stack.push(7);
        stack.push(16);
        stack.push(3);
        stack.push(96);
        stack.push(4);
        stack.push(19);
        stack.push(1);
        System.out.println(stack.getMin());
    }
}

class MyStack<T extends Comparable<T>> {
    private int mCapacity;
    private Object[] mElements;
    private int mSize;
    private static final int DEFAULT_CAPACITY = 12;
    private Stack<Integer> mIndexStack;

    public MyStack() {
        mCapacity = DEFAULT_CAPACITY;
        mElements = new Object[mCapacity];
        mSize = 0;
        mIndexStack = new Stack();
    }

    /**
     * 这里暂时不考虑扩容问题
     *
     * @param element
     */
    public void push(T element) {

        if (mSize < mCapacity) {
            mElements[mSize++] = element;
            int index = mSize - 1;
            if (mIndexStack.isEmpty()) {
                //索引栈中没元素，说明是第一次插入元素，则直接将该索引入栈。
                mIndexStack.push(index);
            } else {
                //索引栈中已经有元素，要将该入栈元素与索引栈中栈顶元素所指的元素进行比较。
                T currentMin = (T) mElements[mIndexStack.peek()];
                if (element.compareTo((currentMin)) <= 0) {
                    mIndexStack.push(index);
                }
            }
        } else {
            throw new RuntimeException("Stackoverflow!");
        }
    }

    /**
     * 只查看不弹出栈顶元素
     *
     * @return
     */
    public T peek() {
        if (!isEmpty()) {
            int index = mSize - 1;
            return (T) mElements[index];
        } else {
            throw new RuntimeException("Stack is null!");
        }
    }

    public T pop() {
        if (!isEmpty()) {
            int index = --mSize;
            T element = (T) mElements[index];
            mElements[index] = null;
            //每次pop出栈的时候判断是否是索引栈栈顶元素，如果是的话同时pop索引栈。
            if (index == mIndexStack.peek()) {
                mIndexStack.pop();
            }
            return element;
        } else {
            throw new RuntimeException("Stack is null!");
        }
    }

    public T getMin() {
        if (!isEmpty()) {
            return (T) mElements[mIndexStack.peek()];
        } else {
            throw new RuntimeException("Stack is null!");
        }
    }

    public int size() {
        return mSize;
    }

    public boolean isEmpty() {
        return mSize == 0;
    }
}

