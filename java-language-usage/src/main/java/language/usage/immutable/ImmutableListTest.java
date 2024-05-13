package language.usage.immutable;

import com.google.common.collect.ImmutableList;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class ImmutableListTest {
    public static void main(String[] args) {
        ImmutableList.Builder builder = ImmutableList.<String>builder();
        builder.add("1");
        builder.add("2");
        builder.add("3");
        builder.add("1");
        builder.add("2");
        builder.add("3");

        List<String> ids = new ArrayList<String>(){{
            add("4");
            add("5");
            add("6");
        }};
        builder.addAll(ids);
        builder.addAll(ids);

        System.out.println(builder.build());
        System.out.println(builder.build().stream().distinct().collect(toList()));
    }
}