package language.usage.stream;

import java.util.ArrayList;
import java.util.List;

public class ListAddDemo {

    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            integerList.add(i);
        }

        System.out.println(integerList);

        addByIndex(integerList, 0, 10);
        addByIndex(integerList, integerList.size()-1, 11);
        addByIndex(integerList, integerList.size(), 12);
        addByIndex(integerList, integerList.size()+1, 13); // out of range
    }

    public static void addByIndex(List<Integer> integerList, int index, int num) {
        integerList.add(index, num);
        System.out.println("------ add(" + index + ", " + num + ") ------");
        System.out.println(integerList);
    }
}