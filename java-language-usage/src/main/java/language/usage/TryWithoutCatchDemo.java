package language.usage;

public class TryWithoutCatchDemo {
    public static void main(String[] args) {
        try {
            tryWithoutCatch();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("-----------");
            e.printStackTrace();
        }
    }

    // RuntimeException 可以不强制 throws Exception
    // Exception 强制要 throws Exception
//    public static void tryWithoutCatch() throws Exception
    public static void tryWithoutCatch()
    {
        try {
//            throw newException("Exception throw from tryWithoutCatch");
            throw newRuntimeException("Exception throw from tryWithoutCatch");
        } finally {
            System.out.println("---finally --- tryWithoutCatch---");
        }
    }

    public static RuntimeException newRuntimeException(String msg)
    {
        return new RuntimeException(msg);
    }

    public static Exception newException(String msg)
    {
        return new Exception(msg);
    }
}