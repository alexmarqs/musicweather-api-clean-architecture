package example.musiweather.app.core.application.util;

import example.musiweather.app.core.domain.PlaylistCategory;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * The type App util.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class AppUtil {

    /**
     * The constant MSG_ERROR_CITY_NOT_FOUND.
     */
    public static final String MSG_ERROR_CITY_NOT_FOUND = "City not found";

    /**
     * The constant MSG_ERROR_PLAYLIST_NOT_FOUND.
     */
    public static final String MSG_ERROR_PLAYLIST_NOT_FOUND = "Playlist not found";

    /**
     * The constant MSG_ERROR_INTERNAL_ERROR.
     */
    public static final String MSG_ERROR_INTERNAL_ERROR = "Unexpected error";

    /**
     * The constant MSG_ERROR_BAD_REQUEST.
     */
    public static final String MSG_ERROR_BAD_REQUEST = "Bad request - invalid parameters";

    /**
     * Convert playlist category from temperature playlist category.
     *
     * @param temperature the temperature
     * @return the playlist category
     */
    public static PlaylistCategory convertPlaylistCategoryFromTemperature(Double temperature) {
        if(temperature > 26) { // > 26
            return PlaylistCategory.PARTY;
        } else if(temperature > 19) { // between 20 - 26
            return PlaylistCategory.REGGAE;
        } else if(temperature > 14) { // between 15 - 19
            return PlaylistCategory.INDIE;
        } else { // < 15
            return PlaylistCategory.JAZZ;
        }
    }

}
