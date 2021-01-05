package language.usage.number;

import org.apache.commons.lang3.time.FastDateFormat;

import java.util.Date;

public class Plusplus {

    public static void main(String[] args) {
        int a = 1;
        int b = 1;
        int total = 10;
        for (int i = 1; i<= total; i++ ) {
            System.out.println(i + "\t"+ a++ + "\t"+ ++b);
        }

        System.out.println("---------------");

        for (int i = 0; i < 10; ++i) {
            System.out.println(i);
        }

        System.out.println("---------------");

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

    }
}
