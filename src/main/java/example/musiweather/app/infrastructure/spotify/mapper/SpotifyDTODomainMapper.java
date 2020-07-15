package example.musiweather.app.infrastructure.spotify.mapper;

import example.musiweather.app.core.domain.Playlist;
import example.musiweather.app.core.domain.Track;
import example.musiweather.app.infrastructure.spotify.dto.SpotifyPlaylistItemDTO;
import example.musiweather.app.infrastructure.spotify.dto.SpotifyTrackArtistDTO;
import example.musiweather.app.infrastructure.spotify.dto.SpotifyTrackDTO;
import example.musiweather.app.infrastructure.spotify.dto.SpotifyTracksDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The interface Spotify dto domain mapper.
 */
@Mapper // use componentModel="spring" to use DI (dependency injection) for inject bean in spring context
public interface SpotifyDTODomainMapper {
    /**
     * The constant INSTANCE.
     */
    SpotifyDTODomainMapper INSTANCE = Mappers.getMapper(SpotifyDTODomainMapper.class); // if not using DI

    /**
     * To domain playlist.
     *
     * @param spotifyTracksDTO       the spotify tracks dto
     * @param spotifyPlaylistItemDTO the spotify playlist item dto
     * @return the playlist
     */
    @Mapping(source = "spotifyPlaylistItemDTO.description", target = "description")
    @Mapping(source = "spotifyTracksDTO.items", target = "trackList")
    Playlist toDomain(SpotifyTracksDTO spotifyTracksDTO, SpotifyPlaylistItemDTO spotifyPlaylistItemDTO);

    /**
     * To domain track.
     *
     * @param spotifyTrackDTO the spotify track dto
     * @return the track
     */
    @Mapping(source = "spotifyTrackDTO.track.name", target = "name")
    @Mapping(source = "spotifyTrackDTO.track.artists", target = "artists", qualifiedByName = "convertArtistList")
    Track toDomain(SpotifyTrackDTO spotifyTrackDTO);

    /**
     * Convert artist list string.
     *
     * @param spotifyTrackArtistDTOList the spotify track artist dto list
     * @return the string
     */
    @Named("convertArtistList")
    static String convertArtistList(List<SpotifyTrackArtistDTO> spotifyTrackArtistDTOList) {
        return spotifyTrackArtistDTOList != null ? spotifyTrackArtistDTOList.stream()
                .map(artistDTO -> artistDTO.getName()).collect(Collectors.joining(",")) : "";
    }
}
