package example.musiweather.app.infrastructure.openweathermap;

import example.musiweather.app.infrastructure.configuration.OpenWeatherFeignConfiguration;
import example.musiweather.app.infrastructure.openweathermap.dto.OpenWeatherDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * The interface Open weather map api client (api gateway).
 *
 * Notes:
 * - When the decode404 is true we receive null ( or Optional) as response
 * for 404 Not Found status responses. When it is false (default) an exception is thrown.
 */
@FeignClient(name = "open-weather-map-client", url = "${app.api-client.open-weather-map.url}",
        configuration = {OpenWeatherFeignConfiguration.class})
public interface OpenWeatherFeignClient {

    /**
     * Gets weather by city.
     *
     * @param city the city
     * @return the weather by city
     */
    @GetMapping
    OpenWeatherDTO getWeatherByCity(@RequestParam("q") String city);

    /**
     * Gets weather by coordinates.
     *
     * @param lat the lat
     * @param lon the lon
     * @return the weather by coordinates
     */
    @GetMapping
    OpenWeatherDTO getWeatherByCoordinates(@RequestParam("lat") Double lat, @RequestParam("lon") Double lon);

}
