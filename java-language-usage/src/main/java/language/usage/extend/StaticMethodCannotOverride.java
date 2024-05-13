package language.usage.extend;

public class StaticMethodCannotOverride {
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

        System.out.println("===================");
        System.out.println(parent.getBirthday());
        System.out.println(child.getBirthday());
    }

    public static class Parent {
        private String name = "p-name";

        public String getName() {
            return name;
        }

        public void setName() {
            name = "p-name-2";
        }

        public String getBirthday() {
            return findBirthday();
        }

        public static String findBirthday() {
            return "2022-02-02";
        }
    }

    public static class Child extends Parent {
        private String name = "c-name";

        public String getName() {
            return name;
        }

        public static String findBirthday() {
            return "2023-03-03";
        }
    }

}