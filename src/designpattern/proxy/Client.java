package designpattern.proxy;

/**
 * Created by zhoutailiang on 2017/6/11.
 * <p>
 * 代理模式：给某一个对象提供一个代理或占位符，并由代理对象来控制对原对象的访问。
 */
public class Client {
    public static void main(String[] args) {
        Subject realSubject = new RealSubject();
        Subject subject = new Proxy(realSubject);
        subject.request();
    }
}
