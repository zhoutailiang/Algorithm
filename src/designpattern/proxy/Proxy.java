package designpattern.proxy;

/**
 * Created by zhoutailiang on 2017/6/11.
 */
public class Proxy extends Subject {
    private Subject realSubject;

    private void preRequest() {
    }

    @Override
    public void request() {
        preRequest();
        realSubject.request();
        postRequest();
    }

    private void postRequest() {

    }
}
