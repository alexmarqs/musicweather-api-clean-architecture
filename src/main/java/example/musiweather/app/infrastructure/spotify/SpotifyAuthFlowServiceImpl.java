package example.musiweather.app.infrastructure.spotify;

import example.musiweather.app.infrastructure.spotify.dto.SpotifyAuthTokenDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Base64;

/**
 * The type Spotify auth flow service.
 */
@Service
@RequiredArgsConstructor
public class SpotifyAuthFlowServiceImpl implements SpotifyAuthFlowService {

    /**
     * The Client id.
     */
    @Value("${app.api-client.spotify.client-id}")
    private String clientId;

    /**
     * The Client secret.
     */
    @Value("${app.api-client.spotify.client-secret}")
    private String clientSecret;

    /**
     * The Spotify auth feign client.
     */
    private final SpotifyAuthFeignClient spotifyAuthFeignClient;

    @Override
    public SpotifyAuthTokenDTO getToken() {
        MultiValueMap<String, String> paramMap = new LinkedMultiValueMap<>();
        paramMap.add("grant_type", "client_credentials");
        SpotifyAuthTokenDTO spotifyAuthTokenResponse = spotifyAuthFeignClient.generateAuthToken(generateAuthorizationHeader(), paramMap);
        return spotifyAuthTokenResponse;
    }

    /**
     * Generate authorization header string.
     *
     * @return the string
     */
    private String generateAuthorizationHeader() {
        String encodedCredentials = Base64.getEncoder().encodeToString((clientId + ":" + clientSecret).getBytes());
        return "Basic " + encodedCredentials;
    }
}
