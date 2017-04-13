package exercise.chapter01;

import utils.Utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by tailiang on 17/4/11.
 */
public class GetGenericsInfo {
    public static void main(String[] args) {
//        GenericsSonClass sonClass=new GenericsSonClass();
        GenericsClass<Integer> genericsClass=new GenericsClass<Integer>();
//        Utils.println(sonClass.getGenericsArguments());
        Utils.println(genericsClass.getGenericsArguments());
    }
}
class GenericsSonClass extends GenericsClass<String>{

}
class GenericsClass<T>{
    private Class<T> mClazz;
    public GenericsClass(){
        Class clazz = getClass();
        if (clazz == GenericsClass.class) {
            //CommonDao类
            getActualTypeArguments(clazz);
        } else {
            //CommonDao的子类
            while (clazz != Object.class) {
                Type superType = clazz.getGenericSuperclass();
                if (superType instanceof ParameterizedType) {
                    getActualTypeArguments(superType);
                    break;
                }
                clazz = clazz.getSuperclass();
            }
        }
    }
    public Class<T> getGenericsArguments(){
        return mClazz;
    }
    private void getActualTypeArguments(Type type) {
        Type[] actualTypes = ((ParameterizedType) type).getActualTypeArguments();
        if (actualTypes.length != 0 && actualTypes[0] instanceof Class) {
            mClazz = (Class<T>) actualTypes[0];
        }
    }

}