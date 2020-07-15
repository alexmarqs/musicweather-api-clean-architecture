package example.musiweather.app.infrastructure.configuration;

import example.musiweather.app.core.application.port.out.LoggingPort;
import example.musiweather.app.infrastructure.openweathermap.OpenWeatherFeignErrorDecoder;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The type Open weather feign configuration.
 */
@Configuration
public class OpenWeatherFeignConfiguration {
    /**
     * Open weather error decoder error decoder.
     *
     * @param loggingPort the logging port
     * @return the error decoder
     */
    @Bean
    public ErrorDecoder openWeatherErrorDecoder(LoggingPort loggingPort) {
        return new OpenWeatherFeignErrorDecoder(loggingPort);
    }
}
