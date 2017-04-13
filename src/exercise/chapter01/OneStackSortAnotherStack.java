package exercise.chapter01;

import utils.Utils;

import java.util.Stack;

/**
 * Created by zhoutailiang on 2017/4/13.
 * [题目]
 * 用一个栈实现另一个栈的排序c
 * 一个栈中的元素类型为整型，现在想将该栈从顶到底按从大到小的顺序排序，
 * 只允许申请一个栈。除此之外，可以申请新的变量，但不能申请额外的数据结构。如何完成排序？
 * [难度]
 * *
 * [思路]
 * 1.假设待排序栈记为dataStack，辅助排序栈记为helpStack。
 * 2.从dataStack中弹出元素到helpStack中，每次弹出操作时检查待弹出的元素toPop与helpStack中栈顶元素top的大小。
 * （1）如果toPop<top，则从dataStack中弹出压入helpStack。
 * （2）否则
 * （2.1）则把toPop保存在临时变量temp中
 * （2.2）从helpStack中弹出所有比temp小的元素到dataStack中
 * （2.3）然后将temp压入helpStack中
 * 3.重复2直到dataStack中的元素全部压入helpStack中
 * 4.依次将helpStack中的数据弹出并压入dataStack中。
 */
public class OneStackSortAnotherStack {

    public static void main(String[] args) {
        Stack<Integer> dataStack = new Stack<>();
        Stack<Integer> helpStack = new Stack<>();
        dataStack.push(7);
        dataStack.push(4);
        dataStack.push(3);
        dataStack.push(1);
        dataStack.push(6);
        dataStack.push(5);
        dataStack.push(2);
        Utils.println(dataStack);
        sort(dataStack, helpStack);
        Utils.println(dataStack);
    }

    private static void sort(Stack<Integer> dataStack, Stack<Integer> helpStack) {
        int temp;
        while (!dataStack.isEmpty()) {
            if (helpStack.isEmpty() || dataStack.peek() < helpStack.peek()) {
                helpStack.push(dataStack.pop());
            } else {
                temp = dataStack.pop();
                while (!helpStack.isEmpty()) {
                    if (helpStack.peek() < temp) {
                        dataStack.push(helpStack.pop());
                    } else {
                        break;
                    }
                }
                helpStack.push(temp);
            }
        }

        while (!helpStack.isEmpty()) {
            dataStack.push(helpStack.pop());
        }
    }
}