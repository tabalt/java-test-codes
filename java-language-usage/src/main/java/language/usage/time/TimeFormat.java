package language.usage.time;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.time.FastDateFormat;

public class TimeFormat {
    public static void main(String[] args) {
        try {
            SimpleDateFormat datetimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            datetimeFormat.parse("CURRENT_TIMESTAMP");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            //String value = "";
            //String value = "0000-00-00 00:00:00";
            //String value = "2020-07-14 11:57:04";
            String value = "2020-07-14 11:57:04.456";
            Date utilDate = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss").parse(value.trim());
            System.out.println(utilDate.toString());
            System.out.println(utilDate.getTime());

            System.out.println("\n--------");

            Date utilDate2 = parseDate("2020-07-14 11:57:04");
            System.out.println(utilDate2.toString() + "\t" + utilDate2.getTime());

            utilDate2 = parseDate("2020-07-14 11:57:04.123");
            System.out.println(utilDate2.toString() + "\t" + utilDate2.getTime());

            utilDate2 = parseDate("2021-01-06 13:51:17.788");
            System.out.println(utilDate2.toString() + "\t" + utilDate2.getTime());

            utilDate2 = parseDate("2021-01-06 13:51:17.7");
            System.out.println(utilDate2.toString() + "\t" + utilDate2.getTime());

            utilDate2 = parseDate("2021-01-06 13:51:17");
            System.out.println(utilDate2.toString() + "\t" + utilDate2.getTime());

            utilDate2 = parseDate("2021-01-07 16:29:22.006");
            System.out.println(utilDate2.toString() + "\t" + utilDate2.getTime());
            Timestamp sqlTimestamp = new Timestamp(utilDate2.getTime());
            System.out.println("sqlTimestamp: " + sqlTimestamp + ", nanos:" + sqlTimestamp.getNanos());
            Boolean serverSupportsFracSecs = true;
            System.out.println("formatNanos: " + formatNanos(sqlTimestamp.getNanos(), serverSupportsFracSecs, true));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static String formatNanos(int nanos, boolean serverSupportsFracSecs, boolean usingMicros) {
        if (nanos > 999999999) {
            nanos %= 100000000;
        }

        if (usingMicros) {
            nanos /= 1000;
        }

        if (serverSupportsFracSecs && nanos != 0) {
            int digitCount = usingMicros ? 6 : 9;
            String nanosString = Integer.toString(nanos);
            String zeroPadding = usingMicros ? "000000" : "000000000";
            nanosString = zeroPadding.substring(0, digitCount - nanosString.length()) + nanosString;

            int pos;
            for(pos = digitCount - 1; nanosString.charAt(pos) == '0'; --pos) {
            }

            nanosString = nanosString.substring(0, pos + 1);
            return nanosString;
        } else {
            return "0";
        }
    }

    private static Date parseDate(String value) throws ParseException {
        String pattern = "yyyy-MM-dd HH:mm:ss";
        if (value.contains(".")) {
            pattern += ".SSS";
        }
        return FastDateFormat.getInstance(pattern).parse(value);
    }
}
