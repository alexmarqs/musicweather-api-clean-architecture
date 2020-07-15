package example.musiweather.app.infrastructure.spotify.dto;

import lombok.Data;

import java.util.List;

/**
 * The type Spotify playlist dto.
 */
@Data
public class SpotifyPlaylistDTO {

    /**
     * The Items.
     */
    private List<SpotifyPlaylistItemDTO> items;

}
