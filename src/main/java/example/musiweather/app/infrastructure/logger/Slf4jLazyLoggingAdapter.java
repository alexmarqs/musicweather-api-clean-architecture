package example.musiweather.app.infrastructure.logger;

import example.musiweather.app.core.application.port.out.LoggingPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Supplier;

/**
 * The type Slf4j lazy logging adapter.
 */
public class Slf4jLazyLoggingAdapter implements LoggingPort {

    /**
     * The Logger.
     */
    private final Logger logger;

    /**
     * Instantiates a new Slf4j logging adapter.
     *
     * @param clazz the clazz
     */
    public Slf4jLazyLoggingAdapter(Class<?> clazz) {
        logger = LoggerFactory.getLogger(clazz);
    }

    @Override
    public void info(Supplier<String> message) {
        if(logger.isInfoEnabled()) {
            logger.info(message.get());
        }
    }

    @Override
    public void debug(Supplier<String> message) {
        if(logger.isDebugEnabled()) {
            logger.debug(message.get());
        }
    }

    @Override
    public void warn(Supplier<String> message) {
        if(logger.isWarnEnabled()) {
            logger.warn(message.get());
        }
    }

    @Override
    public void trace(Supplier<String> message) {
        if(logger.isTraceEnabled()) {
            logger.trace(message.get());
        }
    }

    @Override
    public void error(Supplier<String> message) {
        if(logger.isErrorEnabled()) {
            logger.error(message.get());
        }
    }
}
