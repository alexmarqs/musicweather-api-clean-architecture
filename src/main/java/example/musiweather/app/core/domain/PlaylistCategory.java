package example.musiweather.app.core.domain;

import lombok.Getter;

/**
 * The enum Playlist category.
 */
@Getter
public enum PlaylistCategory {
    /**
     * Party playlist category.
     */
    PARTY("party"),
    /**
     * Jazz playlist category.
     */
    JAZZ("jazz"),
    /**
     * Indie playlist category.
     */
    INDIE("indie_alt"),
    /**
     * Reggae playlist category.
     */
    REGGAE("reggae");

    /**
     * The Value.
     */
    private String value;

    /**
     * Instantiates a new Playlist category.
     *
     * @param value the value
     */
    PlaylistCategory(String value) {
        this.value = value;
    }
}
