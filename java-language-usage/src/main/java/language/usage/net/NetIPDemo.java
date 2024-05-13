package language.usage.net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.util.Random;

public class NetIPDemo {
    public static void main(String[] args) {
        try {
            System.out.println("Local host address: " + InetAddress.getLocalHost().getHostAddress());
            System.out.println("----");
            System.out.println("getAvailablePort: " + getAvailablePort(20000, 30000, 1000));
            System.out.println("----");
//            System.out.println("getAvailablePort: " + getAvailablePort(20000, 20001, 1000));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Get available port, starting from a random port within range [startLeft, startRight], with specified attempts
    private static int getAvailablePort(int startLeft, int startRight, int attempts) throws Exception {
        int availablePort = 0;

        Random random = new Random();
        int randMax = startRight - startLeft + 1;
        int randInt = random.nextInt(randMax);
        int startFrom = startLeft + randInt;
        System.out.println("randMax=" + randMax + "; randInt=" + randInt + "; startFrom=" + startFrom);
        System.out.println("Make starting port as "+ startFrom);

        for (int i = startFrom; i < startFrom + attempts; i++) {
            System.out.println("Checking port " + i + " availability...");
            try {
                new ServerSocket(i).close();
                availablePort = i;
                break;
            } catch (IOException e) {
                System.out.println("Port " + i + " is not available, check next...");
            }
        }
        if (availablePort != 0) {
            System.out.println("Get available port "+  availablePort);
            return availablePort;
        } else {
            throw new Exception(
                    String.format("No available port between [%d, %d) can be used.", startFrom, startFrom + attempts));
        }
    }
}