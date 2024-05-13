package language.usage.number;

public class ModDemo {
    public static void main(String[] args) {
        System.out.println(65535 % 65536);
        System.out.println(65536 % 65536);
        System.out.println(65537 % 65536);
        System.out.println(0 % 65536);
        System.out.println(1 % 65536);
        System.out.println(1000 % 65536);
    }
}