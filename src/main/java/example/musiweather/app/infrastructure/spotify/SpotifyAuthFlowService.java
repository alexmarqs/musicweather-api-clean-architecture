package example.musiweather.app.infrastructure.spotify;

import example.musiweather.app.infrastructure.spotify.dto.SpotifyAuthTokenDTO;

/**
 * The interface Spotify auth flow service.
 */
public interface SpotifyAuthFlowService {

    /**
     * Gets token.
     *
     * @return the token
     */
    SpotifyAuthTokenDTO getToken();

}
