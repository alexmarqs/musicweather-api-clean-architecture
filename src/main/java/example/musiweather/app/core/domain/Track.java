package example.musiweather.app.core.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * The type Track.
 */
@Data
public class Track implements Serializable {

    /**
     * The constant serialVersionUID.
     */
    private static final long serialVersionUID = -8261787110168600914L;

    /**
     * The Name.
     */
    private String name;

    /**
     * The Artists.
     */
    private String artists;

}
