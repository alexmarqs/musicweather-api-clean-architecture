package example.musiweather.app.infrastructure.openweathermap;

import example.musiweather.app.core.application.exception.AppException;
import example.musiweather.app.core.application.exception.ErrorCodesEnum;
import example.musiweather.app.core.application.port.out.LoggingPort;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.RequiredArgsConstructor;

/**
 * The type Open weather feign error decoder.
 */
@RequiredArgsConstructor
public class OpenWeatherFeignErrorDecoder implements ErrorDecoder {

    /**
     * The Logging.
     */
    private final LoggingPort logging;

    //private ErrorDecoder defaultDecoder = new ErrorDecoder.Default();

    @Override
    public Exception decode(String s, Response response) {
        logging.error(() -> "OpenWeatherMap Client Response Error: Got response " + response.status() + " from " + s + " with body: " + response.body());

        switch (response.status()) {
            case 404:
                throw new AppException(ErrorCodesEnum.CITY_NOT_FOUND);
            case 400:
                throw new AppException(ErrorCodesEnum.INTERNAL_ERROR, "Bad request for OpenWeatherMap API");
            case 401:
                throw new AppException(ErrorCodesEnum.INTERNAL_ERROR, "Unauthorized to access OpenWeatherMap API");
            default:
                return new Exception(response.reason());
        }
        //return defaultDecoder.decode(s, response); // will throw FeignException
    }
}
