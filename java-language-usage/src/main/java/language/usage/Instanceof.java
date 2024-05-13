package language.usage;

public class Instanceof {
    private static abstract class Base {}

    private static class First extends Base {}
    private static class Second extends First {}
    private static class Third extends Second {}

    public static void main(String[] args) {
        First first = new First();
        Second second = new Second();
        Third third = new Third();
        if (third instanceof Third) {
            System.out.println("third instanceof Third");
        }
        if (third instanceof Second) {
            System.out.println("third instanceof Second");
        }
        if (third instanceof First) {
            System.out.println("third instanceof First");
        }
        if (third instanceof Base) {
            System.out.println("third instanceof Base");
        }

        Class<?> thirdClass = third.getClass();
        System.out.println("\n\nthirdClass.getName " + thirdClass.getName());

        if (thirdClass.isInstance(first)) {
            System.out.println("thirdClass.isInstance first");
        }

        if (thirdClass.isInstance(second)) {
            System.out.println("thirdClass.isInstance second");
        }

        if (thirdClass.isInstance(third)) {
            System.out.println("thirdClass.isInstance third");
        }
    }
}