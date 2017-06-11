package designpattern.adapter.objectadapter;

import utils.Utils;

/**
 * Created by zhoutailiang on 2017/6/11.
 */
public class Adapter extends Target {
    private Adaptee mAdaptee;

    public Adapter(Adaptee adaptee) {
        mAdaptee = adaptee;
    }

    @Override
    public void request() {
        Utils.println("Object Adapter");
        mAdaptee.specificRequest();
    }
}
