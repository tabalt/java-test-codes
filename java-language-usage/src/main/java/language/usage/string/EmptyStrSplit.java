package language.usage.string;

public class EmptyStrSplit {
    protected String abc;
    public static void main(String[] args) {
        EmptyStrSplit emptyStrSplit = new EmptyStrSplit();
        System.out.println(emptyStrSplit.abc.split(":")[0]);
        System.out.println("".split(":")[0]);
        System.out.println("111".split(":")[0]);
        System.out.println("111:222".split(":")[0]);
    }
}