package example.musiweather.app.core.application.usecase;

import example.musiweather.app.core.application.port.out.LoggingPort;
import example.musiweather.app.core.application.port.out.PlaylistByCategoryPort;
import example.musiweather.app.core.application.port.out.WeatherByCoordinatesPort;
import example.musiweather.app.core.application.util.AppUtil;
import example.musiweather.app.core.domain.Playlist;
import example.musiweather.app.core.domain.PlaylistCategory;
import example.musiweather.app.core.domain.PlaylistWeather;
import example.musiweather.app.core.domain.Weather;
import lombok.RequiredArgsConstructor;

/**
 * The type Get playlist by coordinates use case.
 */
@RequiredArgsConstructor
public class GetPlaylistByCoordinatesUseCaseImpl implements GetPlaylistByCoordinatesUseCase {

    /**
     * The Playlist by category port.
     */
    private final PlaylistByCategoryPort playlistByCategoryPort;

    /**
     * The Weather by coordinates port.
     */
    private final WeatherByCoordinatesPort weatherByCoordinatesPort;

    /**
     * The Logging port.
     */
    private final LoggingPort loggingPort;

    @Override
    public PlaylistWeather getPlaylistByCoordinates(CoordinatesQuery query) {
        Weather weather = weatherByCoordinatesPort.getWeatherByCoordinates(query.getLat(), query.getLon());
        loggingPort.debug(() -> "Retrieved temperature " + weather.getCurrentTemperature() + " for coordinates " + query.getLat() + "," + query.getLon());

        PlaylistCategory playlistCategory = AppUtil.convertPlaylistCategoryFromTemperature(weather.getCurrentTemperature());
        Playlist playlist = playlistByCategoryPort
                .getPlaylistByCategory(playlistCategory);
        loggingPort.debug(() -> "Retrieved playlist with " + playlist.getTrackList().size() + " tracks for category " + playlistCategory.name());

        return PlaylistWeather.builder()
                .weather(weather)
                .playlist(playlist)
                .build();
    }
}
