package language.usage.map;

import java.util.HashMap;
import java.util.Map;

public class HashMapEquals {
    public static void main(String[] args) {
        try {
            Map<String, String> hashMap1 = new HashMap<String, String>();
            hashMap1.put("123", "123");
            hashMap1.put("456", "456");

            Map<String, String> hashMap2 = new HashMap<String, String>();
            hashMap2.put("123", "123");
            hashMap2.put("456", "456");

            System.out.println(hashMap1);
            System.out.println(hashMap2);
            System.out.println(hashMap1.equals(hashMap2));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
