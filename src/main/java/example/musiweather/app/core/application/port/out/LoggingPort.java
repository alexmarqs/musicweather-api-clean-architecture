package example.musiweather.app.core.application.port.out;

import java.util.function.Supplier;

/**
 * The interface Logging port.
 */
public interface LoggingPort {

    /**
     * Info.
     *
     * @param message the message
     */
    void info(Supplier<String> message);

    /**
     * Debug.
     *
     * @param message the message
     */
    void debug(Supplier<String> message);

    /**
     * Warn.
     *
     * @param message the message
     */
    void warn(Supplier<String> message);

    /**
     * Trace.
     *
     * @param message the message
     */
    void trace(Supplier<String> message);

    /**
     * Error.
     *
     * @param message the message
     */
    void error(Supplier<String> message);

}
