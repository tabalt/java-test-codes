package language.usage.stream;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class RandomGetDemo {


    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
//        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        map.put("D", 4);
        map.put("E", 5);

        Random random = new Random();
        Map.Entry<String, Integer> randomEntry = map.entrySet()
                .stream()
//                .skip(random.nextInt(map.size()))
                .skip(4)
                .findFirst()
                .orElse(null);

        if (randomEntry != null) {
            System.out.println("Random Entry: " + randomEntry.getKey() + " - " + randomEntry.getValue());
        } else {
            System.out.println("Map is empty.");

        }


        System.out.println("any value => " + map.values().stream().findAny().orElse(null));
        System.out.println("skip => " + random.nextInt(map.size()));
        System.out.println("random 1 => " + random.nextInt(1));
        System.out.println("random 2 => " + random.nextInt(2));
    }
}