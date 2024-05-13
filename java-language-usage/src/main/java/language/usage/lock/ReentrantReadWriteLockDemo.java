package language.usage.lock;

import java.util.Date;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockDemo {

    private static ReentrantReadWriteLock GLOBAL_LOCK = new ReentrantReadWriteLock(true);
    private static ReentrantReadWriteLock.WriteLock GLOBAL_WRITE_LOCK = GLOBAL_LOCK.writeLock();
    private static ReentrantReadWriteLock.ReadLock GLOBAL_READ_LOCK = GLOBAL_LOCK.readLock();

    public static void main(String[] args) {

        final String tn1 = "Thread-1";
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("try read lock in " + tn1);
                GLOBAL_READ_LOCK.lock();
                int i = 0;
                while (i++ < 10) {
                    System.out.println(new Date() + " still read lock in " + tn1);
                    try {
                        Thread.sleep(10*1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                GLOBAL_READ_LOCK.unlock();
                System.out.println("unlock read lock in " + tn1);
            }
        }, tn1);
        System.out.println("start " + tn1);
        thread1.start();

        final String tn2 = "Thread-2";
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("try write lock in " + tn2);
                GLOBAL_WRITE_LOCK.lock();
                int i = 0;
                while (i++ < 10) {
                    System.out.println(new Date() + " still write lock in " + tn2);
                    try {
                        Thread.sleep(10*1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                GLOBAL_WRITE_LOCK.unlock();
                System.out.println("unlock write lock in " + tn2);
            }
        }, tn2);
        System.out.println("start " + tn2);
        thread2.start();


        final String tn3 = "Thread-3";
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {

                int i = 0;
                while (i++ < 10) {
                    System.out.println("try read lock in " + tn3);
                    GLOBAL_READ_LOCK.lock();
                    System.out.println(new Date() + " still read lock in " + tn3);
                    try {
                        Thread.sleep(10*1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    GLOBAL_READ_LOCK.unlock();
                    System.out.println("unlock read lock in " + tn3);
                }
            }
        }, tn2);
        System.out.println("start " + tn3);
        thread3.start();

    }
}