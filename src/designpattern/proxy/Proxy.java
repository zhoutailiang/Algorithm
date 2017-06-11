package designpattern.proxy;

import utils.Utils;

/**
 * Created by zhoutailiang on 2017/6/11.
 */
public class Proxy extends Subject {
    private Subject mRealSubject;

    public Proxy(Subject realSubject) {
        mRealSubject = realSubject;
    }

    private void preRequest() {
        Utils.println("Proxy preRequest()");
    }

    @Override
    public void request() {
        preRequest();
        mRealSubject.request();
        postRequest();
    }

    private void postRequest() {
        Utils.println("Proxy postRequest()");
    }
}
