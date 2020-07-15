package example.musiweather.app.core.application.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import static example.musiweather.app.core.application.util.AppUtil.*;

/**
 * The enum Error codes enum.
 */
@Getter
public enum ErrorCodesEnum {
    /**
     * City not found error codes enum.
     */
    CITY_NOT_FOUND(MSG_ERROR_CITY_NOT_FOUND, HttpStatus.NOT_FOUND),
    /**
     * Playlist not found error codes enum.
     */
    PLAYLIST_NOT_FOUND(MSG_ERROR_PLAYLIST_NOT_FOUND, HttpStatus.NOT_FOUND),
    /**
     * Internal error error codes enum.
     */
    INTERNAL_ERROR(MSG_ERROR_INTERNAL_ERROR, HttpStatus.INTERNAL_SERVER_ERROR),
    /**
     * Bad request error codes enum.
     */
    BAD_REQUEST(MSG_ERROR_BAD_REQUEST, HttpStatus.BAD_REQUEST);

    /**
     * The Default message.
     */
    private String defaultMessage;

    /**
     * The Http status.
     */
    private HttpStatus httpStatus;

    /**
     * Instantiates a new Error codes enum.
     *
     * @param defaultMessage the default message
     * @param httpStatus     the http status
     */
    ErrorCodesEnum(String defaultMessage, HttpStatus httpStatus) {
        this.defaultMessage = defaultMessage;
        this.httpStatus = httpStatus;
    }
}
