package example.musiweather.app.infrastructure.spotify;

import example.musiweather.app.core.application.exception.AppException;
import example.musiweather.app.core.application.exception.ErrorCodesEnum;
import example.musiweather.app.core.application.port.out.LoggingPort;
import example.musiweather.app.core.application.port.out.PlaylistByCategoryPort;
import example.musiweather.app.core.domain.Playlist;
import example.musiweather.app.core.domain.PlaylistCategory;
import example.musiweather.app.infrastructure.spotify.dto.*;
import example.musiweather.app.infrastructure.spotify.mapper.SpotifyDTODomainMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

/**
 * The type Spotify adapter / service.
 */
@Service
@RequiredArgsConstructor
public class SpotifyAdapter implements PlaylistByCategoryPort {

    /**
     * The Spotify feign client.
     */
    private final SpotifyFeignClient spotifyFeignClient;

    /**
     * The Spotify auth flow service.
     */
    private final SpotifyAuthFlowService spotifyAuthFlowService;

    /**
     * The Logging.
     */
    private final LoggingPort logging;

    @Cacheable(value = "playlists", key = "#category.value")
    @Override
    public Playlist getPlaylistByCategory(PlaylistCategory category) {
        SpotifyAuthTokenDTO spotifyAuthTokenDTO = spotifyAuthFlowService.getToken();
        String authorizationHeader = spotifyAuthTokenDTO.getAuthorizationHeader();
        logging.debug(() -> "Returned authorization header to invoke Spotify API");

        SpotifyPlaylistCategoryDTO spotifyPlaylistCategoryDTO = spotifyFeignClient.getPlaylistByCategory(authorizationHeader, category.getValue());
        SpotifyPlaylistDTO spotifyPlaylistDTO = spotifyPlaylistCategoryDTO.getPlaylists();

        if (spotifyPlaylistDTO == null || spotifyPlaylistDTO.getItems() == null || spotifyPlaylistDTO.getItems().isEmpty()) {
            throw new AppException(ErrorCodesEnum.PLAYLIST_NOT_FOUND);
        }

        List<SpotifyPlaylistItemDTO> spotifyPlaylistItems = spotifyPlaylistDTO.getItems();
        int randomIdx = getRandomNumberForPlaylistItem(0, spotifyPlaylistItems.size());
        SpotifyPlaylistItemDTO spotifyPlaylistItemDTO = spotifyPlaylistItems.get(randomIdx);

        SpotifyTracksDTO spotifyTracksDTO = spotifyFeignClient.getTracksByPlaylistId(authorizationHeader, spotifyPlaylistItemDTO.getPlaylistId());
        logging.debug(() -> "Returned Spotify tracks for item index " + randomIdx);

        return SpotifyDTODomainMapper.INSTANCE.toDomain(spotifyTracksDTO, spotifyPlaylistItemDTO);
    }

    /**
     * Gets random number for playlist item.
     *
     * @param min the min
     * @param max the max
     * @return the random number for playlist item
     */
    private int getRandomNumberForPlaylistItem(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

}
