package language.usage.random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class HelloRandom {
    public static void main(String[] args) {
        System.out.println("Hello Random");

        Set<String> rcUrls = new HashSet<String>(){{
            add("rc1");
            add("rc2");
        }};

        int rcCnt = rcUrls.size();
        int ranPos = new Random().nextInt(rcCnt);
        ArrayList<String> arr = new ArrayList<>(rcUrls);

        System.out.println(ranPos);
        System.out.println(arr.get(ranPos));

        System.out.println(new HashMap<>(2).keySet().size());
    }
}