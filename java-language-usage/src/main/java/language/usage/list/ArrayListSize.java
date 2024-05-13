package language.usage.list;

import java.util.ArrayList;
import java.util.List;

public class ArrayListSize {
    public static void main(String[] args) {

        int initialCapacity = 10;
        System.out.println("initialCapacity: " + initialCapacity);

        List<Object> objectList = new ArrayList<>(initialCapacity);

        objectList.add(1);
        objectList.add(2);

        System.out.println("objectList: " + objectList + ", size: " + objectList.size());

        objectList.add(3);
        objectList.add(4);
        objectList.add(5);
        objectList.add(6);
        objectList.add(7);
        objectList.add(8);
        objectList.add(9);
        objectList.add(10);
        objectList.add(11);
        objectList.add(12);

        System.out.println("objectList: " + objectList + ", size: " + objectList.size());
    }
}