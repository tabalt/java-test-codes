package language.usage.string;

import java.util.StringTokenizer;

public class StringTokenizerDemo {

    public static void main(String[] args) {
        String str = "hello world, ni hao a!";
        StringTokenizer tokenizer = new StringTokenizer(str, " ");

        System.out.println("countTokens: " + tokenizer.countTokens());
        while (tokenizer.hasMoreTokens()) {
            System.out.println(tokenizer.nextToken());
        }
    }
}
