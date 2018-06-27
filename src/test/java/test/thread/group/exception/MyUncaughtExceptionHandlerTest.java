package test.thread.group.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sunxikai928.com.github.exception.MyUncaughtExceptionHandler;
import sunxikai928.com.github.exception.NonFatalException;

/**
 * Created by sunxikai on 18/6/27.
 */
public class MyUncaughtExceptionHandlerTest {

    private static Logger logger = LoggerFactory.getLogger(MyUncaughtExceptionHandlerTest.class);

    /**
     * 测试异常捕捉
     *
     * @param args
     */
    public static void main(String[] args) {
        // 线程的异常处理
        Runnable runnable = () -> {
            logger.info("这里将要发生异常");
            throw new NonFatalException("001", new Object());
        };
        Thread thread = new Thread(runnable, "异常线程");
        thread.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        thread.start();
    }
}