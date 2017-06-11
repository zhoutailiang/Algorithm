package designpattern.visitor;

import utils.Utils;

/**
 * Created by zhoutailiang on 2017/6/11.
 */
public class ConcreteVistorA extends Visitor {
    @Override
    public void visit(ConcreteElementA elementA) {
        Utils.println("ConcreteVistorA visit ConcreteElementA");
    }

    @Override
    public void visit(ConcreteElementB elementB) {
        Utils.println("ConcreteVistorA visit ConcreteElementB");
    }
}
