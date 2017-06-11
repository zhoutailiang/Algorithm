package designpattern.visitor;

/**
 * Created by zhoutailiang on 2017/6/11.
 * <p>
 * 访问者模式(Visitor Pattern):提供一个作用于某对象结构中的各元素的操作表示，
 * 它使我们可以在不改变各元素的类的前提下定义作用于这些元素的新操作。访问者模式是一种对象行为型模式。
 */
public class Client {
    public static void main(String[] args) {
        Visitor visitor=new ConcreteVistorA();
        ObjectStructure objects=new ObjectStructure();
        objects.addElement(new ConcreteElementA());
        objects.addElement(new ConcreteElementB());
        objects.addElement(new ConcreteElementC());
        objects.accept(visitor);
    }
}
