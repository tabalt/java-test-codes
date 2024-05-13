package language.usage.string;

import java.util.HashMap;
import java.util.Map;

public class IndexOf {
    public static void main(String[] args) {
        String str = "Hello World 2021 Hello World";
        System.out.println(str.indexOf("ll"));
        System.out.println(str.contains("ll"));

        System.out.println("-------");

        // Remove SQL comments
        String originSql = "/* hehe */ /* dada */ /*+ abc=def */ select * from t1 where f1 = 1";

        String noCommentsSql = originSql.trim();
        while (noCommentsSql.startsWith("/*") && noCommentsSql.charAt(2) != '+') {
            int commendEnd = noCommentsSql.indexOf("*/");
            noCommentsSql = noCommentsSql.substring(commendEnd + 2).trim();
        }

        // Parse SQL hints
        String hintStr = "";
        String noHintsSql = noCommentsSql;
        if (noHintsSql.startsWith("/*")) {
            int hintEnd = noHintsSql.indexOf("*/");
            if (noHintsSql.charAt(2) == '+') {
                hintStr = noHintsSql.substring(3, hintEnd).trim();
            }
            noHintsSql = noHintsSql.substring(hintEnd + 2).trim();
        } else {
            noHintsSql = noHintsSql.trim();
        }

        System.out.println(originSql);
        System.out.println(noCommentsSql);
        System.out.println(noHintsSql);
        System.out.println(hintStr);
    }
}