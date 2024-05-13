package language.usage.extend;

public class ParentDefaultConstructorHackBlock {
    public static void main(String[] args) {
        System.out.println("\nNormal:\n");
        new Child();
        System.out.println("===================");
        new GrandChild();

        System.out.println("\nHacked:\n");

        new Child2();
        System.out.println("===================");
        new GrandChild2();
    }

    public static class Parent {
        public Parent() {
            this(true);
        }

        public Parent(boolean init) {
            if (init) {
                System.out.println("Hello Parent");
            }
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

    public static class Child2 extends Parent {
        public Child2() {
            super(false);
            System.out.println("Hello Child2");
        }
    }

    public static class GrandChild2 extends Child2 {
        public GrandChild2() {
            System.out.println("Hello GrandChild2");
        }
    }
}