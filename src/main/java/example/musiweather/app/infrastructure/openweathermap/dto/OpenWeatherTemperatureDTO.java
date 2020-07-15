package example.musiweather.app.infrastructure.openweathermap.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * The type Open weather temperature dto.
 */
@Data
public class OpenWeatherTemperatureDTO {
    /**
     * The Current.
     */
    @JsonProperty("temp")
    private Double current;

}
