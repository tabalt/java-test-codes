package language.usage.string;

public class WhiteSpaceChar {
    public static void main(String[] args) {
        System.out.println(Character.isWhitespace('c'));
        System.out.println(Character.isWhitespace(' '));
        System.out.println(Character.isWhitespace('\t'));
        System.out.println(Character.isWhitespace('\r'));
        System.out.println(Character.isWhitespace('\n'));
    }
}