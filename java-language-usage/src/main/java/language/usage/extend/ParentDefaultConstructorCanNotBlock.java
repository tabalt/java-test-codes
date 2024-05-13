package language.usage.extend;

public class ParentDefaultConstructorCanNotBlock {
    public static void main(String[] args) {
        new Child();
        System.out.println("===================");
        new GrandChild();
    }

    public static class Parent {
        public Parent() {
            System.out.println("Hello Parent");
        }
    }

    public static class Child extends Parent {
        public Child() {
            System.out.println("Hello Child");
        }
    }

    public static class GrandChild extends Child {
        public GrandChild() {
            System.out.println("Hello GrandChild");
        }
    }
}