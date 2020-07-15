package example.musiweather.app.core.application.usecase;

import example.musiweather.app.core.application.validation.SelfValidating;
import example.musiweather.app.core.domain.PlaylistWeather;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

/**
 * The interface Get playlist by city name use case.
 */
public interface GetPlaylistByCityNameUseCase {


    /**
     * Gets playlist by city name.
     *
     * @param query the city query
     * @return the playlist by city name
     */
    PlaylistWeather getPlaylistByCityName(CityQuery query);

    /**
     * The type City query.
     */
    @Getter
    @ToString
    class CityQuery extends SelfValidating<CityQuery> {

        /**
         * The City name.
         */
        @NotEmpty(message = "The city must contain a non empty value")
        private final String cityName;

        /**
         * Instantiates a new City query.
         *
         * @param cityName the city name
         */
        public CityQuery(String cityName) {
            this.cityName = cityName;
            this.validate();
        }

    }

}
