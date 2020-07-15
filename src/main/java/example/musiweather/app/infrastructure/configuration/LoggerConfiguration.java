package example.musiweather.app.infrastructure.configuration;

import example.musiweather.app.core.application.port.out.LoggingPort;
import example.musiweather.app.infrastructure.logger.Slf4jLazyLoggingAdapter;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * The type Logger configuration.
 */
@Configuration
public class LoggerConfiguration {

    /**
     * Logging logging.
     *
     * @param injectionPoint the injection point
     * @return the logging
     */
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public LoggingPort logging(InjectionPoint injectionPoint) {
        return new Slf4jLazyLoggingAdapter(injectionPoint.getMember().getDeclaringClass());
    }

}
