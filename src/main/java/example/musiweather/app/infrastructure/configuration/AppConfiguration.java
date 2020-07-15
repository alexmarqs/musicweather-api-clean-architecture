package example.musiweather.app.infrastructure.configuration;

import example.musiweather.app.core.application.port.out.LoggingPort;
import example.musiweather.app.core.application.port.out.PlaylistByCategoryPort;
import example.musiweather.app.core.application.port.out.WeatherByCityPort;
import example.musiweather.app.core.application.port.out.WeatherByCoordinatesPort;
import example.musiweather.app.core.application.usecase.GetPlaylistByCityNameUseCase;
import example.musiweather.app.core.application.usecase.GetPlaylistByCityNameUseCaseImpl;
import example.musiweather.app.core.application.usecase.GetPlaylistByCoordinatesUseCase;
import example.musiweather.app.core.application.usecase.GetPlaylistByCoordinatesUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The type App configuration.
 */
@Configuration
public class AppConfiguration {

    /**
     * Gets playlist by city name use case.
     *
     * @param weatherByCityPort      the weather by city port
     * @param playlistByCategoryPort the playlist by category port
     * @return the playlist by city name use case
     */
    @Bean
    public GetPlaylistByCityNameUseCase getPlaylistByCityNameUseCase(WeatherByCityPort weatherByCityPort, PlaylistByCategoryPort playlistByCategoryPort, LoggingPort loggingPort) {
        return new GetPlaylistByCityNameUseCaseImpl(playlistByCategoryPort, loggingPort, weatherByCityPort);
    }

    /**
     * Gets playlist by coordinates use case.
     *
     * @param weatherByCoordinatesPort the weather by coordinates port
     * @param playlistByCategoryPort   the playlist by category port
     * @return the playlist by coordinates use case
     */
    @Bean
    public GetPlaylistByCoordinatesUseCase getPlaylistByCoordinatesUseCase(WeatherByCoordinatesPort weatherByCoordinatesPort, PlaylistByCategoryPort playlistByCategoryPort, LoggingPort loggingPort) {
        return new GetPlaylistByCoordinatesUseCaseImpl(playlistByCategoryPort, weatherByCoordinatesPort, loggingPort);
    }

}
