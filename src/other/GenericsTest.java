package other;

import utils.Utils;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhoutailiang on 2017/5/4.
 */
public class GenericsTest<T> {
    public List<T> mList=new ArrayList();
    public static void main(String[] args) {
        GenericsTest<String> test=new GenericsTest();
        try {
            Field field=test.getClass().getField("mList");
            Type type=field.getGenericType();
            if (type instanceof ParameterizedType){
                ParameterizedType parameterizedType= (ParameterizedType) type;
                Utils.println(parameterizedType.getActualTypeArguments()[0]);
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
class Son extends GenericsTest<String>{

}