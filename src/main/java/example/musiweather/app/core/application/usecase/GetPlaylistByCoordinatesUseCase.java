package example.musiweather.app.core.application.usecase;

import example.musiweather.app.core.application.validation.SelfValidating;
import example.musiweather.app.core.domain.PlaylistWeather;
import lombok.Getter;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

/**
 * The interface Get playlist by coordinates use case.
 */
public interface GetPlaylistByCoordinatesUseCase {

    /**
     * Gets playlist by coordinates.
     *
     * @param query the query
     * @return the playlist by coordinates
     */
    PlaylistWeather getPlaylistByCoordinates(CoordinatesQuery query);

    /**
     * The type Coordinates query.
     */
    @Getter
    @ToString
    class CoordinatesQuery extends SelfValidating<CoordinatesQuery> {

        /**
         * The Lat.
         */
        @NotNull(message = "Latitude cannot be null")
        @Range(min = -90, max = 90, message = "Latitude must be between -90 and 90 degrees")
        private final Double lat;

        /**
         * The Lon.
         */
        @NotNull(message = "Longitude cannot be null")
        @Range(min = -180, max = 180, message = "Longitude must be between -180 and 180 degrees")
        private final Double lon;

        /**
         * Instantiates a new Coordinates query.
         *
         * @param lat the lat
         * @param lon the lon
         */
        public CoordinatesQuery(Double lat, Double lon) {
            this.lat = lat;
            this.lon = lon;
            this.validate();
        }

    }

}
