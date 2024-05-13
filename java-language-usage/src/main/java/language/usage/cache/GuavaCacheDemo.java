package language.usage.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.TimeUnit;

public class GuavaCacheDemo {
    private static final Value DEFAULT_VALUE = new Value("__default__value__");
    private static class Value {
        private String name;

        public Value(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Value{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    private static LoadingCache<String, Value> TEST_CACHE = CacheBuilder.newBuilder().initialCapacity(64)
            .refreshAfterWrite(10, TimeUnit.SECONDS).build(new CacheLoader<String, Value>() {
                @Override
                public Value load(final String key) throws Exception {
                    Value value = null;
//                    value = new Value("value");

                    if (value == null) {
                        value = DEFAULT_VALUE;
                    }
                    System.out.println("load value: " + value + " for key: " + key);

                    return value;
                }
            });

    private static String getValueFromCache(String key) {
        try {
            Value value = TEST_CACHE.get("key");
            if (value == DEFAULT_VALUE) {
                value = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
        try {
            System.out.println(getValueFromCache("key"));
            System.out.println(getValueFromCache("key"));
            System.out.println(getValueFromCache("key"));

            System.out.println("---sleep 10s----");
            Thread.sleep(10000);
            System.out.println(getValueFromCache("key"));
            System.out.println(getValueFromCache("key"));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}