package language.usage.number;

public class LongTest2 {
    private static Long value;
    public static void main(String[] args) {
        try {
            System.out.println(value);
            System.out.println(value == null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
