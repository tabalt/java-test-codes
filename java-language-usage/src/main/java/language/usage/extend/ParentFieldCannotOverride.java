package language.usage.extend;

public class ParentFieldCannotOverride {
    public static void main(String[] args) {
        Parent parent = new Parent();
        System.out.println(parent.getName());
        System.out.println("===================");
        Child child = new Child();
        System.out.println(child.getName());
        child.setName();
        System.out.println(child.getName());
        System.out.println(parent.getName());
        System.out.println(((Parent) child).getName());
    }

    public static class Parent {
        private String name = "p-name";

        public String getName() {
            return name;
        }

        public void setName() {
            name = "p-name-2";
        }
    }

    public static class Child extends Parent {
        private String name = "c-name";

        public String getName() {
            return name;
        }
    }

}