package example.musiweather.app.infrastructure.spotify.dto;

import lombok.Data;

import java.util.List;

/**
 * The type Spotify tracks dto.
 */
@Data
public class SpotifyTracksDTO {

    /**
     * The Items.
     */
    private List<SpotifyTrackDTO> items;

}


