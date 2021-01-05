package language.usage.map;

import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.SerializationUtils;

public class Map2ByteArray {
    public static void main(String[] args) {

        Map<String, String> rowMap = new HashMap<String, String>(){{
            put("k1", "v1");
            put("k2", "v2");
        }};

        System.out.println(rowMap);
        System.out.println("\n-------nativeTransform------");
        nativeTransform(rowMap);
        System.out.println("\n-------utilsTransform------");
        utilsTransform(rowMap);
        System.out.println("\n-------classUtilsTransform------");
        classUtilsTransform(rowMap);
    }

    private static void nativeTransform(Map<String, String> rowMap) {
        try {
            ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(byteOut);
            out.writeObject(rowMap);
            byte[] rowBytes = byteOut.toByteArray();
            out.close();
            byteOut.close();

            System.out.println(new String(rowBytes));

            ByteArrayInputStream byteIn = new ByteArrayInputStream(rowBytes);
            ObjectInputStream in = new ObjectInputStream(byteIn);

            Map<String, String> msgMap = (Map<String, String>) in.readObject();

            in.close();
            byteIn.close();

            System.out.println(msgMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void utilsTransform(Map<String, String> rowMap) {
        try {
            byte[] rowBytes = SerializationUtils.serialize((Serializable) rowMap);
            System.out.println(new String(rowBytes));

            Map<String, String> msgMap = (Map<String, String>) SerializationUtils.deserialize(rowBytes);

            System.out.println(msgMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static class Data implements Serializable {
        Map<String, String> map = new HashMap<String, String>();

        public Data(Map<String, String> map) {
            this.map = map;
        }
    }
    private static void classUtilsTransform(Map<String, String> rowMap) {
        try {
            Data data = new Data(rowMap);
            byte[] rowBytes = SerializationUtils.serialize(data);
            System.out.println(new String(rowBytes));

            Data rowData = (Data) SerializationUtils.deserialize(rowBytes);

            System.out.println(rowData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
