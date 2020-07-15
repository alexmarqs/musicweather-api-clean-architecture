package example.musiweather.app.infrastructure.spotify.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


/**
 * The type Spotify auth token dto.
 */
@Data
public class SpotifyAuthTokenDTO {

    /**
     * The Access token.
     */
    @JsonProperty("access_token")
    private String accessToken;

    /**
     * The Token type.
     */
    @JsonProperty("token_type")
    private String tokenType;

    /**
     * Gets authorization header.
     *
     * @return the authorization header
     */
    public String getAuthorizationHeader() {
        return tokenType + " " + accessToken;
    }

}
