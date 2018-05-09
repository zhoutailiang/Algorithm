package generics;

/**
 * Created by zhoutailiang on 2018/5/6.
 */
public class Pair<T> {
    private T mFirst;
    private T mSecond;

    public T getFirst() {
        return mFirst;
    }

    public void setFirst(T first) {
        mFirst = first;
    }

    public T getSecond() {
        return mSecond;
    }

    public void setSecond(T second) {
        mSecond = second;
    }
}
