package language.usage.random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class RandomOutofBounds {
    public static void main(String[] args) {
//        System.out.println("test1\n");
//        test1();
        System.out.println("\n\ntest2\n");
        test2();
    }

    public static void test1() {
        Map<String, Boolean> allRc = new HashMap<String, Boolean>(){{
            put("rc1", true);
            put("rc2", true);
        }};

        Set<String> rcUrls = allRc.keySet();

        int rcCnt = rcUrls.size();
        int ranPos = new Random().nextInt(rcCnt);
        ArrayList<String> arr = new ArrayList<>(rcUrls);

        try {
            System.out.println("rcUrls=> " + rcUrls);
            System.out.println("rcCnt=> " + rcCnt);
            System.out.println("ranPos=> " + ranPos + ", value=> " + arr.get(ranPos));

            System.out.println("ranPos+1=> " + (ranPos + 1) + ", value=> ");
            System.out.println(arr.get(ranPos + 1));
//        System.out.println(arr.get(ranPos));
//        System.out.println(arr.get(ranPos+1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public static void test2() {
        Map<String, Boolean> allRc = new HashMap<String, Boolean>(){{
            put("rc1", true);
            put("rc2", true);
            put("rc3", true);
        }};

        Set<String> rcUrls = allRc.keySet();

        int rcCnt = rcUrls.size();
        int ranPos = new Random().nextInt(rcCnt);

        System.out.println("rcUrls=> " + rcUrls);
        System.out.println("rcCnt=> " + rcCnt);
        System.out.println("ranPos=> " + ranPos);
        allRc.remove("rc3");
        ArrayList<String> arr = new ArrayList<>(rcUrls);

        try {
            System.out.println("\n-----\n");
            System.out.println("rcUrls=> " + rcUrls);
            System.out.println("arr=> " + arr);
            System.out.println("rcUrls size=> " + rcUrls.size());
            System.out.println("ranPos=> " + ranPos + ", value=> " + arr.get(ranPos));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}