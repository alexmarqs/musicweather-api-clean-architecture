package example.musiweather.app.core.application.port.out;


import example.musiweather.app.core.domain.Weather;

/**
 * The interface Weather by coordinates port.
 */
public interface WeatherByCoordinatesPort {

    /**
     * Gets weather by coordinates.
     *
     * @param lat the lat
     * @param lon the lon
     * @return the weather by coordinates
     */
    Weather getWeatherByCoordinates(Double lat, Double lon);

}
