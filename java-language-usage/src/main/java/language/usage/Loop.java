package language.usage;

public class Loop {
    public static void main(String[] args) {
        testNestedLoopBreak();
    }

    //test nested loop break
    private static void testNestedLoopBreak() {
        for (int i=1; i<= 3; i++) {
            for (int j=1; j<=3; j++) {
                if (j >= 3) {
                    break;
                }
                System.out.println(i + "\t" + j);
            }
            System.out.println("");
        }
    }
}