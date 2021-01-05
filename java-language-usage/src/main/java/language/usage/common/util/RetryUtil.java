package language.usage.common.util;

import java.util.Optional;
import java.util.concurrent.Callable;

import org.apache.commons.lang3.exception.ExceptionUtils;

public class RetryUtil {

    public static <R> R retry(Callable<R> tryCallable, Optional<Runnable> finallyRunnable, Exception exception
        , int retryTimes, long retryIntervalTime) throws Exception {
        int retryNum = 0;
        while (retryNum <= retryTimes) {
            try {
                R result = tryCallable.call();
                finallyRunnable.ifPresent(runnable -> runnable.run());
                return result;
            } catch (Exception e) {
                try {
                    Thread.sleep(retryIntervalTime);
                } catch (Exception sleepException) {
                    System.out.println(sleepException.getMessage());
                }
                if (retryNum == retryTimes) {
                    finallyRunnable.ifPresent(runnable -> runnable.run());
                    throw new Exception(exception.getMessage() + "：" + ExceptionUtils.getRootCauseMessage(e), e);
                }
            }
            retryNum++;
        }
        return null;
    }
}
