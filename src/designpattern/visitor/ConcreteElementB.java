package designpattern.visitor;

import utils.Utils;

/**
 * Created by zhoutailiang on 2017/6/11.
 */
public class ConcreteElementB implements Element{
    @Override
    public void accept(Visitor visitor) {
        operationB();
        visitor.visit(this);
    }
    public void operationB()
    {
        Utils.println("ConcreteElementB operationB");
    }
}
