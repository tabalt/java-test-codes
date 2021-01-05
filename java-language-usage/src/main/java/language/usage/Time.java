package language.usage;

import java.sql.Timestamp;
import java.util.Date;

import org.apache.commons.lang3.time.FastDateFormat;

public class Time {
    public static void main(String[] args) {
        try {
            //String value = "";
            //String value = "0000-00-00 00:00:00";
            String value = "2020-07-14 11:57:04";
            Date utilDate = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss").parse(value.trim());
            System.out.println(utilDate.toString());
            System.out.println(utilDate.getTime());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
