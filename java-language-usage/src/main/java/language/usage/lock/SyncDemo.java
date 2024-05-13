package language.usage.lock;

public class SyncDemo {
    public static class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return name + "-" + age;
        }
    }

    public static final String LABEL = "name-1";
    public static void tryLockThenPrint(String threadName, String lockName) {
//        Person person = new Person("name", 1);
//        synchronized ("name-1") {
//        String label = person.toString();
        synchronized (lockName) {
            for (long c=0; c<Long.MAX_VALUE; c++) {
                System.out.println(threadName + ", lockName=> " + lockName);
                try {
                    Thread.sleep(2*1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {

        final String tn1 = "Thread-1";
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
//                String lockName = "lock-name-1";
                Person person = new Person("name", 1);
                tryLockThenPrint(tn1, person.toString());
            }
        }, tn1);
        System.out.println("start " + tn1);
        thread1.start();

        final String tn2 = "Thread-2";
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
//                String lockName = "lock-name-1";
                Person person = new Person("name", 1);
                tryLockThenPrint(tn2, person.toString());
            }
        }, tn2);
        System.out.println("start " + tn2);
        thread2.start();

    }
}