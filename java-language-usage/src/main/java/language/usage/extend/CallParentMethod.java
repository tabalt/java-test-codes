package language.usage.extend;

public class CallParentMethod {
    public static void main(String[] args) {
        Parent parent = new Parent();
        Child child = new Child();
        System.out.println(parent.getName());
        System.out.println(child.getName());
        System.out.println("===================");

        Person parentPerson = parent;
        Person childPerson = child;

        System.out.println(parentPerson.getName());
        System.out.println(childPerson.getName());
        System.out.println("===================");

        System.out.println(((Parent) parentPerson).getName());
        System.out.println(((Child) childPerson).getName());
    }

    public static interface Person {
        public String getName();
    }

    public static class Parent implements Person {
        private String name = "p-name";

        public String getName() {
            return name;
        }
    }

    public static class Child extends Parent {
        private String name = "c-name";

        public String getName() {
            return name;
        }
    }

}