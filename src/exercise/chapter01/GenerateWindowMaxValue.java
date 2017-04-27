package exercise.chapter01;

import utils.Utils;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by zhoutailiang on 2017/4/27.
 */
public class GenerateWindowMaxValue {
    public static void main(String[] args) {
        ArrayDeque<Integer> deque=new ArrayDeque<>();
        for (int i = 0; i < 10; i++) {
            deque.addLast(i);
        }
        Utils.println(deque);
    }
    private int [] generateWindowMaxValue(int [] arr,int windowSize){
        int resultSize=arr.length-windowSize+1;
        int [] result=new int[resultSize];
        Deque<Integer> deque=new LinkedList<>();
        for (int index = 0; index < arr.length; index++) {
            if(deque.size()==0){
                deque.addLast(index);
            }else {
                //1.去掉过时的元素
                if (deque.peekFirst()==index-windowSize){
                    deque.removeFirst();
                }
                //2.入队列
                if (arr[index]<=deque.peekLast()){
                    deque.addLast(arr[index]);
                }else {
                    Iterator<Integer> iterator= deque.descendingIterator();
                    while (iterator.hasNext()){
                        Integer next=iterator.next();
                        if (arr[index]>next){
                            iterator.remove();
                        }else {
                            break;
                        }
                    }
                    deque.addLast(arr[index]);
                }
            }
        }
        return result;
    }
}
