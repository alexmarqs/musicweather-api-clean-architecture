package example.musiweather.app.infrastructure.web.mapper;

import example.musiweather.app.core.domain.PlaylistWeather;
import example.musiweather.app.infrastructure.web.dto.PlaylistWeatherDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * The interface Playlist weather domain mapper.
 */
@Mapper // use componentModel="spring" to use DI (dependency injection) for inject bean in spring context
public interface PlaylistWeatherDomainMapper {
    /**
     * The constant INSTANCE.
     */
    PlaylistWeatherDomainMapper INSTANCE = Mappers.getMapper(PlaylistWeatherDomainMapper.class); // if not using DI

    /**
     * To dto playlist weather dto.
     *
     * @param playlistWeather the playlist weather
     * @return the playlist weather dto
     */
    @Mapping(source = "playlistWeather.weather.currentTemperature", target = "currentTemperature")
    @Mapping(source = "playlistWeather.playlist", target = "playlistSuggested")
    @Mapping(source = "playlistWeather.playlist.trackList", target = "playlistSuggested.tracks")
    PlaylistWeatherDTO toDTO(PlaylistWeather playlistWeather);

}
