package language.usage.map;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class MapAndBytes {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<String,String>();
        map.put("name","aaa");
        map.put("age","11");

        Map<String,String> map2 = new HashMap<String,String>();
        map2.put("name2","aaa2");
        map2.put("age2","112");

        System.out.println(map);
        System.out.println(map2);
        System.out.println("-------");

        try {
            ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(byteOut);

            out.writeObject(map);
            //byte[] bt = byteOut.toByteArray();


            out.writeObject(map2);
            byte[] bt2 = byteOut.toByteArray();

            //System.out.println(bt);

            out.close();
            byteOut.close();

            ByteArrayInputStream byteIn = new ByteArrayInputStream(bt2);
            ObjectInputStream in = new ObjectInputStream(byteIn);
            Map<String, String> mapRe = (Map<String, String>) in.readObject();

            in.close();
            byteIn.close();

            System.out.println(mapRe);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
