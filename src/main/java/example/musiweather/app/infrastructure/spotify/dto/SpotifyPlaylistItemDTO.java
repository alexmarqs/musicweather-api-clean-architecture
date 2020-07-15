package example.musiweather.app.infrastructure.spotify.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * The type Spotify playlist item dto.
 */
@Data
public class SpotifyPlaylistItemDTO {
    /**
     * The Playlist id.
     */
    @JsonProperty("id")
    private String playlistId;

    /**
     * The Description.
     */
    private String description;
}
