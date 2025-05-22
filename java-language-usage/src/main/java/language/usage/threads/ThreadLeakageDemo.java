package language.usage.threads;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadLeakageDemo {

    private static ThreadPoolExecutor refreshWorkers;
    private static List<Thread> workerThreads = new Vector<>();

    private static volatile long refreshBatch = 0;;

    public static void main(String[] args) {

        refreshWorkers = new ThreadPoolExecutor(2, Integer.MAX_VALUE, 10L, TimeUnit.SECONDS,
                new SynchronousQueue<>(), r -> {
            Thread worker = new Thread(r, "MVRefreshJob-NO_JOB");
            worker.setDaemon(true);
            workerThreads.add(worker);
            return worker;
        });


        while (true) {
            refreshBatch ++;
            int batchCount = 10;
            if (refreshBatch > 150) {
                batchCount = 1;
            } else if (refreshBatch > 100) {
                batchCount = 2;
            } else if (refreshBatch > 50) {
                batchCount = 5;
            }
            for (int i = 0; i < batchCount; i++) {
                refreshWorkers.submit(() -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }

            System.out.println("\n======================");
            System.out.println("refreshBatch:" + refreshBatch);
            System.out.println("workerThreads size:" + workerThreads.size());
            System.out.println("refreshWorkers getPoolSize:" + refreshWorkers.getPoolSize());
            System.out.println("refreshWorkers getActiveCount:" + refreshWorkers.getActiveCount());
            System.out.println("refreshWorkers getTaskCount:" + refreshWorkers.getTaskCount());
            System.out.println("refreshWorkers getCorePoolSize:" + refreshWorkers.getCorePoolSize());
            System.out.println("refreshWorkers getLargestPoolSize:" + refreshWorkers.getLargestPoolSize());
            System.out.println("refreshWorkers getMaximumPoolSize:" + refreshWorkers.getMaximumPoolSize());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
