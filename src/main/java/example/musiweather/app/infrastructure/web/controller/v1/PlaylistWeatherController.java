package example.musiweather.app.infrastructure.web.controller.v1;

import example.musiweather.app.core.application.port.out.LoggingPort;
import example.musiweather.app.core.application.usecase.GetPlaylistByCityNameUseCase;
import example.musiweather.app.core.application.usecase.GetPlaylistByCoordinatesUseCase;
import example.musiweather.app.core.domain.PlaylistWeather;
import example.musiweather.app.infrastructure.web.dto.ErrorDTO;
import example.musiweather.app.infrastructure.web.dto.PlaylistWeatherDTO;
import example.musiweather.app.infrastructure.web.mapper.PlaylistWeatherDomainMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static example.musiweather.app.core.application.usecase.GetPlaylistByCityNameUseCase.*;
import static example.musiweather.app.core.application.usecase.GetPlaylistByCoordinatesUseCase.*;

/**
 * The type Playlist weather controller.
 */
@RestController
@Validated
@RequestMapping("/api/v1/playlist-weather")
@Api("Musiweather API")
public class PlaylistWeatherController {

    /**
     * The Get playlist by city name use case.
     */
    @Autowired
    private GetPlaylistByCityNameUseCase getPlaylistByCityNameUseCase;

    /**
     * The Get playlist by coordinates use case.
     */
    @Autowired
    private GetPlaylistByCoordinatesUseCase getPlaylistByCoordinatesUseCase;

    /**
     * The Logging.
     */
    @Autowired
    private LoggingPort logging;

    /**
     * Gets playlist weather by city.
     *
     * @param cityName the city name
     * @return the playlist weather by city
     */
    @ApiOperation(value = "Get the playlist based on weather by city name")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the playlist suggestion"),
            @ApiResponse(code = 404, message = "Resource not found", response = ErrorDTO.class),
            @ApiResponse(code = 400, message = "Bad request / Invalid Parameters", response = ErrorDTO.class),
            @ApiResponse(code = 500, message = "Internal server error", response = ErrorDTO.class)
    })
    @RequestMapping(value = "", params = "city", method = RequestMethod.GET)
    public ResponseEntity<PlaylistWeatherDTO> getPlaylistWeatherByCity(@RequestParam("city") String cityName) {
        logging.debug(() -> "Entering in getPlaylistWeatherByCity rest endpoint with parameter " + cityName);
        PlaylistWeather playlistWeather = getPlaylistByCityNameUseCase.getPlaylistByCityName(new CityQuery(cityName));
        PlaylistWeatherDTO playlistWeatherDTO = PlaylistWeatherDomainMapper.INSTANCE.toDTO(playlistWeather);
        return ResponseEntity.ok(playlistWeatherDTO);
    }

    /**
     * Gets playlist weather by coordinates.
     *
     * @param lat the lat
     * @param lon the lon
     * @return the playlist weather by coordinates
     */
    @ApiOperation(value = "Get the playlist based on weather by coordinates")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the playlist suggestion"),
            @ApiResponse(code = 404, message = "Resource not found", response = ErrorDTO.class),
            @ApiResponse(code = 400, message = "Bad request / Invalid parameters", response = ErrorDTO.class),
            @ApiResponse(code = 500, message = "Internal server error", response = ErrorDTO.class)
    })
    @RequestMapping(value = "", params = {"lat", "lon"}, method = RequestMethod.GET)
    public ResponseEntity<PlaylistWeatherDTO> getPlaylistWeatherByCoordinates(@RequestParam("lat") Double lat,
                                                                              @RequestParam("lon")  Double lon) {
        logging.debug(() -> "Entering in getPlaylistWeatherByCoordinates rest endpoint with parameters " + lat + "," + lon);
        PlaylistWeather playlistWeather = getPlaylistByCoordinatesUseCase.getPlaylistByCoordinates(new CoordinatesQuery(lat, lon));
        PlaylistWeatherDTO playlistWeatherDTO = PlaylistWeatherDomainMapper.INSTANCE.toDTO(playlistWeather);
        return ResponseEntity.ok(playlistWeatherDTO);
    }

}
