package language.usage;

public class Extend {
    public static class Person {
        public String jobName() {
            return "Person jobName";
        }

        public void printJobName() {
            System.out.println("-------" + jobName() + "-----");
        }
    }

    public static class Teacher extends Person {
        @Override
        public String jobName() {
            return "Teacher";
        }
    }

    public static class Farmer extends Person {
        @Override
        public String jobName() {
            return "Farmer";
        }
    }

    public static void main(String[] args) {
        Person p1 = new Teacher();
        p1.printJobName();

        Person p2 = new Farmer();
        p2.printJobName();

    }
}
