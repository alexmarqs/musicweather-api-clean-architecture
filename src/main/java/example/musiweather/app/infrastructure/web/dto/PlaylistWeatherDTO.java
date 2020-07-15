package example.musiweather.app.infrastructure.web.dto;

import lombok.Data;

/**
 * The type Playlist weather dto.
 */
@Data
public class PlaylistWeatherDTO {

    /**
     * The Current temperature.
     */
    private Double currentTemperature;

    /**
     * The Playlist suggested.
     */
    private PlaylistDTO playlistSuggested;

}
