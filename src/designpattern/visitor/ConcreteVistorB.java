package designpattern.visitor;

import utils.Utils;

/**
 * Created by zhoutailiang on 2017/6/11.
 */
public class ConcreteVistorB extends Visitor {
    @Override
    public void visit(ConcreteElementA elementA) {
        Utils.println("ConcreteVistorB visit ConcreteElementA");
    }

    @Override
    public void visit(ConcreteElementB elementB) {
        Utils.println("ConcreteVistorB visit ConcreteElementB");
    }
}
