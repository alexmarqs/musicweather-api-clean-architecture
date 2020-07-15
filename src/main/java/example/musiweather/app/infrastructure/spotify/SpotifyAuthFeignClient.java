package example.musiweather.app.infrastructure.spotify;


import example.musiweather.app.infrastructure.configuration.SpotifyFeignConfiguration;
import example.musiweather.app.infrastructure.spotify.dto.SpotifyAuthTokenDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * The interface Spotify auth api client.
 */
@FeignClient(name = "auth-spotify-client", url = "${app.api-client.spotify.auth-url}",
        configuration = {SpotifyFeignConfiguration.class})
public interface SpotifyAuthFeignClient {

    /**
     * Generate auth token spotify auth token response.
     *
     * @param credentialsBasicAuthBase64 the authorization (Authorization: Basic < base64 encoded client_id:client_secret >)
     * @param paramMap      the param map
     * @return the spotify auth token response
     */
    @RequestMapping(value = "/token", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    SpotifyAuthTokenDTO generateAuthToken(@RequestHeader("Authorization") String credentialsBasicAuthBase64,
                                          @RequestBody MultiValueMap<String, ?> paramMap);

}
