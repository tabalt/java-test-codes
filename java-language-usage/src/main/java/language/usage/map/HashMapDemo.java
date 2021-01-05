package language.usage.map;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
    public static void main(String[] args) {
        try {
            Map<String, String> hashMap = new HashMap<String, String>();
            hashMap.put("123", "456");

            System.out.println(hashMap.get("123"));
            System.out.println(hashMap.get("456"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
