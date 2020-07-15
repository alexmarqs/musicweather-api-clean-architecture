package example.musiweather.app.core.application.usecase;

import example.musiweather.app.core.application.port.out.LoggingPort;
import example.musiweather.app.core.application.port.out.PlaylistByCategoryPort;
import example.musiweather.app.core.application.port.out.WeatherByCityPort;
import example.musiweather.app.core.application.util.AppUtil;
import example.musiweather.app.core.domain.Playlist;
import example.musiweather.app.core.domain.PlaylistCategory;
import example.musiweather.app.core.domain.PlaylistWeather;
import example.musiweather.app.core.domain.Weather;
import lombok.RequiredArgsConstructor;

/**
 * The type Get playlist by city name use case.
 */
@RequiredArgsConstructor
public class GetPlaylistByCityNameUseCaseImpl implements GetPlaylistByCityNameUseCase {

    /**
     * The Playlist by category port.
     */
    private final PlaylistByCategoryPort playlistByCategoryPort;

    /**
     * The Logging port.
     */
    private final LoggingPort loggingPort;

    /**
     * The Weather by city port.
     */
    private final WeatherByCityPort weatherByCityPort;

    @Override
    public PlaylistWeather getPlaylistByCityName(CityQuery query) {
        Weather weather = weatherByCityPort.getWeatherByCity(query.getCityName());
        loggingPort.debug(() -> "Retrieved temperature " + weather.getCurrentTemperature() + " for city " + query.getCityName());

        PlaylistCategory playlistCategory = AppUtil.convertPlaylistCategoryFromTemperature(weather.getCurrentTemperature());
        Playlist playlist = playlistByCategoryPort.getPlaylistByCategory(playlistCategory);
        loggingPort.debug(() -> "Retrieved playlist with " + playlist.getTrackList().size() + " tracks for category " + playlistCategory.name());

        return PlaylistWeather.builder()
                .weather(weather)
                .playlist(playlist)
                .build();
    }
}
