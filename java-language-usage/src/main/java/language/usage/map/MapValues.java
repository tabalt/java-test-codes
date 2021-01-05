package language.usage.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MapValues {

    public static void main(String[] args){
        Map<String, String> map = new HashMap();
        map.put("apple","apple");
        map.put("computer","computer");
        map.put("book","book");
        Collection values = map.values();
        for(Object object: values){
            System.out.println("KV:"+object.toString());
        }

        long mapLength = map.values().stream().mapToInt(v -> v == null ? 0 : v.getBytes().length).sum();
        System.out.println(mapLength);
    }
}
