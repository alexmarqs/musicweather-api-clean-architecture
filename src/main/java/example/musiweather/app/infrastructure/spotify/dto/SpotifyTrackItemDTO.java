package example.musiweather.app.infrastructure.spotify.dto;

import lombok.Data;

import java.util.List;

/**
 * The type Spotify track item dto.
 */
@Data
public class SpotifyTrackItemDTO {

    /**
     * The Name.
     */
    private String name;

    /**
     * The Artists.
     */
    private List<SpotifyTrackArtistDTO> artists;

}
