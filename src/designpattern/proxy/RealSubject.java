package designpattern.proxy;

import utils.Utils;

/**
 * Created by zhoutailiang on 2017/6/11.
 */
public class RealSubject extends Subject{
    @Override
    public void request() {
        Utils.println("RealSubject");
    }
}
