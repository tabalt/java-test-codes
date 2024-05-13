package language.usage;

public class WhileForBreak {
    public static void main(String[] args) {
        int i = 0;
        while (i < 10) {
            i++;
            System.out.println("------while--" + i);
            for (int j = 1; j< 10; j++) {
                System.out.println("------for--" + j);
                if( j == 2) {
                    break;
                }
            }
        }
    }
}