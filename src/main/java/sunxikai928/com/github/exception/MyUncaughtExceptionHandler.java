package sunxikai928.com.github.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 线程异常处理
 * Created by sunxikai on 18/6/27.
 */
public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    private static Logger logger = LoggerFactory.getLogger(MyUncaughtExceptionHandler.class);

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        if (e instanceof NonFatalException) {
            logger.error("线程[{}],发生异常了", t.getName(), e);
        } else if (e instanceof FatalException) {
            logger.error("线程[{}],发生异常了", t.getName(), e);
        } else
            logger.error("线程[{}],发生异常了", t.getName(), e);
    }
}