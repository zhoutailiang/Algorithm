package designpattern.proxy;

/**
 * Created by zhoutailiang on 2017/6/11.
 */
public class RealSubject extends Subject{
    @Override
    public void request() {
        System.out.println("RealSubject");
    }
}
