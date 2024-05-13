package language.usage.number;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IsNumeric {

    private static Pattern numberPattern = Pattern.compile("^\\d+$");

    private static boolean isNumeric1(String s)
    {
        Matcher matcher = numberPattern.matcher(s);
        if (matcher.find()) {
            return true;
        }
        return false;
    }

    private static boolean isNumeric(String s)
    {
        try {
            Long.parseLong(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static void printIsNumeric(String s)
    {
        System.out.println("String: " + s + ", isNumeric: " + isNumeric(s));
    }

    public static void main(String[] args) {

        printIsNumeric("0");
        printIsNumeric("1");
        printIsNumeric("2021");
        printIsNumeric("20210918");
        printIsNumeric("a20210918");
        printIsNumeric("20210918b");
        printIsNumeric("");
        printIsNumeric("-");

    }

}