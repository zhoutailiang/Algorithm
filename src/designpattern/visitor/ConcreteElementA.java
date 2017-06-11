package designpattern.visitor;

import utils.Utils;

/**
 * Created by zhoutailiang on 2017/6/11.
 */
public class ConcreteElementA implements Element {
    @Override
    public void accept(Visitor visitor) {
        operationA();
        visitor.visit(this);
    }

    public void operationA() {
        Utils.println("ConcreteElementA operationA");
    }
}
