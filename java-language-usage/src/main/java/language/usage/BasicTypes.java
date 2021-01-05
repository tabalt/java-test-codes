package language.usage;

public class BasicTypes {
    public static void main(String[] args) {
        // 基本类型用法

        boolean boolVal = true; // true|false

        char charA = 'A'; //

        byte byteMax = 127; // -2^7 ~ 2^7-1
        short shortMax = 32767; // -2^15 ~ 2^15-1

        // 直接书写的整数是int类型，如超过int最大值会报错
        int intMax = 2147483647; // -2^31 ~ 2^31-1
        long longMax = Long.MAX_VALUE; // -2^63 ~ 2^63-1

        // 直接书写的浮点数是double类型
        float floatMin = Float.MIN_VALUE;
        double doubleVal = 1000.200;

        // void 空类型，不能用于定义变量

        System.out.printf("%b, %c, %d, %d, %d, %d, %f, %f\n",
                boolVal, charA, byteMax, shortMax, intMax, longMax, floatMin, doubleVal);


        // 包装器类型用法, 自Java 9开始已废弃
        // Boolean boolVal = new Boolean(true);
    }
}
