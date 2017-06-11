package designpattern.visitor;

import utils.Utils;

/**
 * Created by zhoutailiang on 2017/6/11.
 */
public class ConcreteElementC implements Element {
    @Override
    public void accept(Visitor visitor) {
        operationC();
        visitor.visit(this);
    }
    public void operationC()
    {
        Utils.println("ConcreteElementC operationC");
    }
}
