package example.musiweather.app.infrastructure.configuration;

import example.musiweather.app.core.application.port.out.LoggingPort;
import example.musiweather.app.infrastructure.spotify.SpotifyFeignErrorDecoder;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The type Spotify feign configuration.
 */
@Configuration
public class SpotifyFeignConfiguration {
    /**
     * Spotify error decoder error decoder.
     *
     * @param loggingPort the logging port
     * @return the error decoder
     */
    @Bean
    public ErrorDecoder spotifyErrorDecoder(LoggingPort loggingPort) {
        return new SpotifyFeignErrorDecoder(loggingPort);
    }
}
