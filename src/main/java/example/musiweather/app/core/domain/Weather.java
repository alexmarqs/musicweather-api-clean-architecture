package example.musiweather.app.core.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * The type Weather.
 */
@Data
public class Weather implements Serializable {

    /**
     * The constant serialVersionUID.
     */
    private static final long serialVersionUID = -2167782169733819672L;

    /**
     * The Current temperature.
     */
    private Double currentTemperature;

}
