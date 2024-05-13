package language.usage.scale;

public class Scale16to10 {
    public static void main(String[] args) {
        System.out.print("Expected: 16777215, Actually: ");
        System.out.println(0x0FFFFFF);
        System.out.println(4 + 0x0FFFFFF);
    }
}