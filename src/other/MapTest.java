package other;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by tailiang on 2017/4/6.
 */
public class MapTest {
    public static void main(String[] args) {
        HashMap<String,Integer> map=new HashMap<>();
        map.put("1",1000);
        map.put("2",2000);
        Set<Map.Entry<String,Integer>> entrySet=map.entrySet();
        Iterator iterator=entrySet.iterator();
        iterator.next();
        iterator.remove();
        System.out.println(map);
    }
}
