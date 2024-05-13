package language.usage.extend;

public class CastParentCallChildOverrideMethod {
    public static void main(String[] args) {
        Person person1 = new GrandChild();
        person1.hello();
        ((GrandChild) person1).hello();
        ((Child) person1).hello();
        ((Parent) person1).hello();

        System.out.println("===================");
        Person person2 = new Child();
        person2.hello();
        ((Child) person2).hello();
        ((Parent) person2).hello();

        System.out.println("===================");
        Person person3 = new Parent();
        person3.hello();
        ((Parent) person3).hello();
    }

    public interface Person {
        void hello();
    }

    public static class Parent implements Person {
        public void hello() {
            System.out.println("Hello Parent");
        }
    }

    public static class Child extends Parent {
        public void hello() {
            System.out.println("Hello Child");
        }
    }

    public static class GrandChild extends Child {
        public void hello() {
            System.out.println("Hello GrandChild");
        }
    }
}