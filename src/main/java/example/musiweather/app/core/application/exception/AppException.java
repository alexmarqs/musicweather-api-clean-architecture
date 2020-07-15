package example.musiweather.app.core.application.exception;

import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

/**
 * The type App exception.
 */
@Getter
@ToString
public class AppException extends RuntimeException {

    /**
     * The Error code.
     */
    private String errorCode;

    /**
     * The Status.
     */
    private HttpStatus status;

    /**
     * Instantiates a new App exception.
     *
     * @param errorCodesEnum the error codes enum
     */
    public AppException(ErrorCodesEnum errorCodesEnum) {
        super(errorCodesEnum.getDefaultMessage());
        this.errorCode = errorCodesEnum.name();
        this.status = errorCodesEnum.getHttpStatus();
    }

    /**
     * Instantiates a new App exception.
     *
     * @param errorCodesEnum the error codes enum
     * @param customMessage  the custom message
     */
    public AppException(ErrorCodesEnum errorCodesEnum, String customMessage) {
        super(customMessage);
        this.errorCode = errorCodesEnum.name();
        this.status = errorCodesEnum.getHttpStatus();
    }
}
