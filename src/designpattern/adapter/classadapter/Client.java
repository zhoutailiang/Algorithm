package designpattern.adapter.classadapter;


/**
 * Created by zhoutailiang on 2017/6/11.
 */
public class Client {
    public static void main(String[] args) {
        Target target=new Adapter();
        target.request();
    }
}
