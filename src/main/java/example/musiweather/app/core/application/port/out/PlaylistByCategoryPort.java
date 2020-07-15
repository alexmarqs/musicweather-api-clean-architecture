package example.musiweather.app.core.application.port.out;

import example.musiweather.app.core.domain.Playlist;
import example.musiweather.app.core.domain.PlaylistCategory;


/**
 * The interface Playlist by category port.
 */
public interface PlaylistByCategoryPort {

    /**
     * Gets playlist by category.
     *
     * @param category the category
     * @return the playlist by category
     */
    Playlist getPlaylistByCategory(PlaylistCategory category);

}
