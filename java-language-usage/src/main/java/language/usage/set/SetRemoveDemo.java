package language.usage.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetRemoveDemo
{
    public static void main(String[] args)
    {
        try {
            wrongUsage1();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            wrongUsage2();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            rightUsage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void wrongUsage1()
    {
        Set<String> set= newHashSet();
        System.out.println("Wrong usage 1 for set remove: " + set.toString());

        // 错误示范，在foreach循环里删除元素
        for (String str : set){
            if(str.equals("Java")){
                set.remove(str);
            }
        }
    }

    private static void wrongUsage2()
    {
        Set<String> set= newHashSet();
        System.out.println("Wrong usage 2 for set remove: " + set.toString());


        // 错误示范，用Iterator迭代器遍历时用Set自带remove方法删除元素
        Iterator<String> iterator = set.iterator();
        while(iterator.hasNext()){
            String str = iterator.next();
            if(str != null && str.equals("Java")){
                set.remove(str);
            }
        }
    }

    private static void rightUsage()
    {
        Set<String> set= newHashSet();
        System.out.println("Right usage for set remove: " + set.toString());

        // 正确示范，用Iterator迭代器本身的remove方法删除元素
        Iterator<String> iterator = set.iterator();
        while(iterator.hasNext()){
            String str = iterator.next();
            if(str.equals("C++")){
                iterator.remove();
            }
        }

        System.out.println("Set after remove: " + set.toString());
    }

    private static Set<String> newHashSet()
    {
        Set<String> set = new HashSet<>();
        set.add("Java");
        set.add("C++");
        set.add("Python");

        return set;
    }
}