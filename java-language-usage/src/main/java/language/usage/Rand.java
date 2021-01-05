package language.usage;

import java.util.Random;

public class Rand {
    public static void main(String[] args) {
        int count = 0;
        for (int i= 0; i < 10000; i++) {
            if (hitTracingDelay()) {
                count ++;
                System.out.println(i);
            }
        }
        System.out.println("------" + count);
    }

    private static boolean hitTracingDelay() {
        int maxInt = 10000;
        double ratio = 0.01;
        Random r = new Random();
        int randInt = r.nextInt(maxInt);
        if (randInt < (int)(maxInt * ratio)) {
            return true;
        }

        return false;
    }
}
