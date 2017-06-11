package designpattern.adapter.classadapter;


import utils.Utils;

/**
 * Created by zhoutailiang on 2017/6/11.
 */
public class Adapter extends Adaptee implements Target {
    @Override
    public void request() {
        Utils.println("Class Adapter");
        specificRequest();
    }
}
