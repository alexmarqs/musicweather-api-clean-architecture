package example.musiweather.app.core.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * The type Playlist.
 */
@Data
public class Playlist implements Serializable {

    /**
     * The constant serialVersionUID.
     */
    private static final long serialVersionUID = -3280311534482339059L;

    /**
     * The Description.
     */
    private String description;

    /**
     * The Track list.
     */
    private List<Track> trackList;

}
