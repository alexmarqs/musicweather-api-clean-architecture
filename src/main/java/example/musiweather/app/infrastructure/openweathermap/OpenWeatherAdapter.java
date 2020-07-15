package example.musiweather.app.infrastructure.openweathermap;

import example.musiweather.app.core.application.port.out.LoggingPort;
import example.musiweather.app.core.application.port.out.WeatherByCityPort;
import example.musiweather.app.core.application.port.out.WeatherByCoordinatesPort;
import example.musiweather.app.core.domain.Weather;
import example.musiweather.app.infrastructure.openweathermap.dto.OpenWeatherDTO;
import example.musiweather.app.infrastructure.openweathermap.mapper.OpenWeatherDTODomainMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * The type Open weather adapter / service.
 */
@Service
@RequiredArgsConstructor
public class OpenWeatherAdapter implements WeatherByCityPort, WeatherByCoordinatesPort {

    /**
     * The Open weather map api client.
     */
    private final OpenWeatherFeignClient openWeatherMapApiClient;

    /**
     * The Logging.
     */
    private final LoggingPort logging;

    @Cacheable(value = "weather", key = "#cityName")
    @Override
    public Weather getWeatherByCity(String cityName) {
        OpenWeatherDTO openWeatherDTO = openWeatherMapApiClient.getWeatherByCity(cityName);
        logging.debug(() -> "Returned weather from OpenWeather API");
        return OpenWeatherDTODomainMapper.INSTANCE.toDomain(openWeatherDTO);
    }

    @Cacheable(value = "weather", key = "#lat + ',' + #lon")
    @Override
    public Weather getWeatherByCoordinates(Double lat, Double lon) {
        OpenWeatherDTO openWeatherDTO = openWeatherMapApiClient.getWeatherByCoordinates(lat, lon);
        logging.debug(() -> "Returned weather from OpenWeather API");
        return OpenWeatherDTODomainMapper.INSTANCE.toDomain(openWeatherDTO);
    }
}
