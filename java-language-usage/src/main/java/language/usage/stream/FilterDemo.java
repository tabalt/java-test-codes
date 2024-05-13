package language.usage.stream;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterDemo {

    public static class Person {
        private String name;//姓名
        private Integer age;//年龄
        private String gender;//性别

        public Person(String name, Integer age, String gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        public String getGender() {
            return gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", gender='" + gender + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        Collection<Person> collection = new ArrayList();
        collection.add(new Person("张三", 22, "男"));
        collection.add(new Person("李四", 19, "女"));
        collection.add(new Person("王五", 34, "男"));
        collection.add(new Person("赵六", 30, "男"));
        collection.add(new Person("田七", 25, "女"));

        Stream<Person> personStream = collection.stream().filter(person -> "男".equals(person.getGender()));

        collection = personStream.collect(Collectors.toList());//将Stream转化为List
        System.out.println(collection.toString());//查看结果
    }
}