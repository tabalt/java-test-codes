package language.usage.time;

public class SleepInterruptedDemo {
    public static void main(String[] args) {

        try {
            Thread.sleep(60*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException("SleepInterruptedDemo is interrupted", e);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}