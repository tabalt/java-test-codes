package language.usage.number;

import java.util.Date;

import org.apache.commons.lang3.time.FastDateFormat;

public class Intger {
    public static void main(String[] args) {
        try {
            String value = "";
            //String value = "abcd";
//            String value = "1s";
            //String value = "1111";
            int intValue = Integer.parseInt(value.trim());
            System.out.println(value);
            System.out.println(intValue);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
