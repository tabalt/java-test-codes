package language.usage.except;

import org.apache.commons.lang3.exception.ExceptionUtils;

import java.io.PrintWriter;
import java.io.StringWriter;

public class RootCauseDemo {
    public static void main(String[] args) {

        try {
            level1();
        } catch (Exception e) {
            System.out.println(ExceptionUtils.getRootCause(e));
            System.out.println(ExceptionUtils.getRootCauseMessage(e));
        }
    }

    public static void level1() {
        try {
            level2();
        } catch (Exception e) {
            throw new RuntimeException("test runtime exception from level1", e);
        }
    }

    public static void level2() {
        try {
            level3();
        } catch (Exception e) {
            throw new RuntimeException("test runtime exception from level2", e);
        }
    }

    public static void level3() {
        throw new RuntimeException("test runtime exception from level3");
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