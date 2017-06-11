package designpattern.proxy;

/**
 * Created by zhoutailiang on 2017/6/11.
 */
public class Client {
    public static void main(String[] args) {
        Subject realSubject=new RealSubject();
        Subject subject=new Proxy(realSubject);
        subject.request();
    }
}
