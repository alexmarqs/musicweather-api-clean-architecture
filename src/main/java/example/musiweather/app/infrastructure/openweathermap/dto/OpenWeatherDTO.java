package example.musiweather.app.infrastructure.openweathermap.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


/**
 * The type Open weather response.
 */
@Data
public class OpenWeatherDTO {

    /**
     * The Temp.
     */
    @JsonProperty("main")
    private OpenWeatherTemperatureDTO temp;

}


