package language.usage.except;

import java.io.PrintWriter;
import java.io.StringWriter;

public class StringifyExceptionDemo {
    public static void main(String[] args) {

        try {
            level1();
        } catch (Exception e) {
            System.out.println(stringifyException(e));
        }
    }

    public static void level1() {
        level2();
    }

    public static void level2() {
        level3();
    }

    public static void level3() {
        throw new RuntimeException("test runtime exception");
    }


    public static String stringifyException(Throwable e) {
        if (e == null) {
            return "(null)";
        } else {
            try {
                StringWriter stm = new StringWriter();
                PrintWriter wrt = new PrintWriter(stm);
                e.printStackTrace(wrt);
                wrt.close();
                return stm.toString();
            } catch (Throwable var3) {
                return e.getClass().getName() + " (error while printing stack trace)";
            }
        }
    }
}