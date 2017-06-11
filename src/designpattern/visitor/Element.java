package designpattern.visitor;

/**
 * Created by zhoutailiang on 2017/6/11.
 */
public  interface Element {
    void accept(Visitor visitor);
}
