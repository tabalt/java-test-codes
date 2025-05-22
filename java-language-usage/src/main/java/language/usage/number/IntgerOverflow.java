package language.usage.number;

public class IntgerOverflow {
    public static void main(String[] args) {
        try {
            int intValue = Integer.MAX_VALUE/2 + 1000;
            long longValue = intValue * 2;
            long longValue2 = (long)intValue * 2;

            System.out.println(intValue);
            System.out.println(longValue);
            System.out.println(longValue2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
