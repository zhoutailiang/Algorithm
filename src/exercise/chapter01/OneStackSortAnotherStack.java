package exercise.chapter01;

/**
 * Created by zhoutailiang on 2017/4/13.
 * [题目]
 * 用一个栈实现另一个栈的排序
 * 一个栈中的元素类型为整型，现在想将该栈从顶到底按从大到小的顺序排序，
 * 只允许申请一个栈。除此之外，可以申请新的变量，但不能申请额外的数据结构。如何完成排序？
 * [难度]
 * *
 * [思路]
 * 1.假设待排序栈记为dataStack，辅助排序栈记为helpStack。
 * 2.从dataStack中弹出元素到helpStack中，每次弹出操作检查helpStack中的元素是否满足从顶到底是从小到大排序的。
 * （1）如果满足，则从dataStack中弹出压入helpStack。
 */
public class OneStackSortAnotherStack {
}
