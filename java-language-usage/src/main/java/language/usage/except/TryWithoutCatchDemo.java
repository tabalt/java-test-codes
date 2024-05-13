package language.usage.except;

public class TryWithoutCatchDemo {
    public static void main(String[] args) {

        try {
            try {
                if (true) {
                    throw new RuntimeException("test runtime exception from inner try without catch");
                }
            } finally {
                System.out.println("finally from inner try without catch");
            }
        } catch (Exception e) {
            System.out.println("==========\ncatch exection in outer try:");
            e.printStackTrace();
        }
    }
}