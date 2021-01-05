package language.usage.number;

public class Long {
    public static void main(String[] args) {
        try {
            System.out.println(java.lang.Long.MIN_VALUE);
            System.out.println(java.lang.Long.MAX_VALUE);
            System.out.println(java.lang.Long.MIN_VALUE - 1);
            System.out.println(java.lang.Long.MAX_VALUE + 1);

            java.lang.Long gb = java.lang.Long.MAX_VALUE / 1024 / 1024 / 1024;
            java.lang.Long tb = gb / 1024;
            java.lang.Long pb = tb / 1024;
            java.lang.Long eb = pb / 1024;

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
