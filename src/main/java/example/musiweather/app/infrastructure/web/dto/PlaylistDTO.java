package example.musiweather.app.infrastructure.web.dto;

import lombok.Data;

import java.util.List;

/**
 * The type Playlist dto.
 */
@Data
public class PlaylistDTO {

    /**
     * The Description.
     */
    private String description;

    /**
     * The Tracks.
     */
    private List<TrackDTO> tracks;

}
