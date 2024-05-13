package language.usage.number;

public class LongTest {
    public static void main(String[] args) {
        try {
            System.out.println(Long.MIN_VALUE);
            System.out.println(Long.MAX_VALUE);
            System.out.println(Long.MIN_VALUE - 1);
            System.out.println(Long.MAX_VALUE + 1);

            Long gb = Long.MAX_VALUE / 1024 / 1024 / 1024;
            Long tb = gb / 1024;
            Long pb = tb / 1024;
            Long eb = pb / 1024;

            System.out.println("");
            System.out.println(gb + " GB");
            System.out.println(tb + " TB");
            System.out.println(pb + " PB");
            System.out.println(eb + " EB");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
