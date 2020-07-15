package example.musiweather.app.core.application.port.out;

import example.musiweather.app.core.domain.Weather;

/**
 * The interface Weather by city port.
 */
public interface WeatherByCityPort {

    /**
     * Gets weather by city.
     *
     * @param cityName the city name
     * @return the weather by city
     */
    Weather getWeatherByCity(String cityName);

}
