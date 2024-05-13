package language.usage;

import java.util.Optional;

public class OptionalUsage {
    public static void main(String[] args) {
        Optional<String> optionalStr1 = Optional.empty();
        Optional<String> optionalStr2 = Optional.empty();

        System.out.println("optionalStr1.equals(optionalStr2)");
        System.out.println(optionalStr1.equals(optionalStr2));
        System.out.println("optionalStr1.equals(Optional.of(\"\"))");
        System.out.println(optionalStr1.equals(Optional.of("")));
    }
}