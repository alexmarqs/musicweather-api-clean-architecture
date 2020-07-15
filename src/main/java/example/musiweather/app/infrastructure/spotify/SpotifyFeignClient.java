package example.musiweather.app.infrastructure.spotify;


import example.musiweather.app.infrastructure.configuration.SpotifyFeignConfiguration;
import example.musiweather.app.infrastructure.spotify.dto.SpotifyPlaylistCategoryDTO;
import example.musiweather.app.infrastructure.spotify.dto.SpotifyTracksDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * The interface Spotify feign client.
 */
@FeignClient(name = "spotify-client", url = "${app.api-client.spotify.url}",
        configuration = {SpotifyFeignConfiguration.class})
public interface SpotifyFeignClient {

    /**
     * Gets playlist by category.
     *
     * @param authorizationToken the authorization token
     * @param categoryId         the category id
     * @return the playlist by category
     */
    @GetMapping(value = "/browse/categories/{category_id}/playlists")
    SpotifyPlaylistCategoryDTO getPlaylistByCategory(@RequestHeader("Authorization") String authorizationToken,
                                                     @PathVariable("category_id") String categoryId);

    /**
     * Gets tracks by playlist id.
     *
     * @param authorizationToken the authorization token
     * @param playlistId         the playlist id
     * @return the tracks by playlist id
     */
    @GetMapping(value = "/playlists/{playlist_id}/tracks")
    SpotifyTracksDTO getTracksByPlaylistId(@RequestHeader("Authorization") String authorizationToken,
                                           @PathVariable("playlist_id") String playlistId);
}
