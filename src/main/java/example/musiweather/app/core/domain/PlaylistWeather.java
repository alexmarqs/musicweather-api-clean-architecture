package example.musiweather.app.core.domain;

import lombok.Builder;
import lombok.Data;

/**
 * The type Playlist weather.
 */
@Data
@Builder
public class PlaylistWeather {

    /**
     * The Weather.
     */
    private Weather weather;

    /**
     * The Playlist.
     */
    private Playlist playlist;

}
