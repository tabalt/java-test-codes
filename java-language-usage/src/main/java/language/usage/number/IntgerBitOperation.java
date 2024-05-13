package language.usage.number;

public class IntgerBitOperation {
    public static void main(String[] args) {
        try {
            System.out.println("0 | 0 = " + (0 | 0));
            System.out.println("0 | 1 = " + (0 | 1));
            System.out.println("0 | 2 = " + (0 | 2));

            System.out.println("-------");

            System.out.println("1 | 0 = " + (1 | 0));
            System.out.println("1 | 1 = " + (1 | 1));
            System.out.println("1 | 2 = " + (1 | 2));

            System.out.println("-------");

            System.out.println("2 | 0 = " + (2 | 0));
            System.out.println("2 | 1 = " + (2 | 1));
            System.out.println("2 | 2 = " + (2 | 2));

            System.out.println("-------");

            System.out.println("0 & 0 = " + (0 & 0));
            System.out.println("1 & 0 = " + (1 & 0));
            System.out.println("1 & 1 = " + (1 & 1));
            System.out.println("1 & 2 = " + (1 & 2));
            System.out.println("2 & 1 = " + (2 & 1));
            System.out.println("2 & 2 = " + (2 & 2));
            System.out.println("3 & 1 = " + (3 & 1));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
