package designpattern.visitor;

import utils.Utils;

/**
 * Created by zhoutailiang on 2017/6/11.
 */
public abstract class Visitor {
    public abstract void visit(ConcreteElementA elementA);
    public abstract void visit(ConcreteElementB elementB);
    public  void visit(ConcreteElementC elementC){
        Utils.println("在Vistor中访问ConcreteElementC");
    }
}
