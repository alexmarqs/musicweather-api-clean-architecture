package example.musiweather.app.infrastructure.web.dto;

import lombok.Builder;
import lombok.Data;

/**
 * The type Error dto.
 */
@Data
@Builder
public class ErrorDTO {

    /**
     * The Error code.
     */
    private String errorCode;

    /**
     * The Message.
     */
    private String message;

}
