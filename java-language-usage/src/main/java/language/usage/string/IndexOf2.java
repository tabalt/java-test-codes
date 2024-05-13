package language.usage.string;

public class IndexOf2 {
    public static void main(String[] args) {
        System.out.println(("----"));
        System.out.println(hasBR("\n"));
        System.out.println(hasBR("\\n"));
        System.out.println(hasBR("\\\n"));
        System.out.println(("----"));
    }

    private static boolean hasBR(Object valueObj) {
        System.out.print(valueObj + ": ");
        if (((String) valueObj).indexOf('\n') != -1) {
            return false;
        }
        return true;
    }
}