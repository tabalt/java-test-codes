package language.usage.string;

import java.util.Arrays;

public class StringSplit {
    public static void main(String[] args) {
        String str = "a,b,c,d,e,f,g";
        System.out.println("\n--------\n" + str);
        System.out.println(Arrays.toString((str.split(","))));
        System.out.println(Arrays.toString(str.split(",", -1)));
        System.out.println(Arrays.toString(str.split(",", 2)));
        System.out.println(Arrays.toString(str.split(",", 8)));

        str = "a,b,c,d,e,f,g,";
        System.out.println("\n--------\n" + str);
        System.out.println(Arrays.toString((str.split(","))));
        System.out.println(Arrays.toString(str.split(",", -1)));
        System.out.println(Arrays.toString(str.split(",", 2)));
        System.out.println(Arrays.toString(str.split(",", 9)));
    }
}