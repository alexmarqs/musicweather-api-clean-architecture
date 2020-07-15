package example.musiweather.app.infrastructure.web;

import example.musiweather.app.core.application.exception.AppException;
import example.musiweather.app.core.application.exception.ErrorCodesEnum;
import example.musiweather.app.core.application.port.out.LoggingPort;
import example.musiweather.app.infrastructure.web.dto.ErrorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.UnsatisfiedServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Spliterator;
import java.util.stream.StreamSupport;

/**
 * The type Global exception handler.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * The Logging.
     */
    @Autowired
    private LoggingPort logging;

    /**
     * Handle app exception response entity.
     *
     * @param e the e
     * @return the response entity
     */
    @ExceptionHandler(AppException.class)
    public ResponseEntity<ErrorDTO> handleAppException(AppException e) {
        logging.error(() -> "Handling application error: " + e.getMessage());
        return buildErrorResponseEntity(e.getErrorCode(), e.getMessage(), e.getStatus());
    }

    /**
     * Handle constraint exception response entity.
     *
     * @param e the e
     * @return the response entity
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorDTO> handleConstraintException(ConstraintViolationException e) {
        logging.error(() -> "Handling constraint violation error: " + e);
        StringBuilder customMessage = new StringBuilder();
        Spliterator<ConstraintViolation<?>> spliterator = e.getConstraintViolations().spliterator();
        StreamSupport.stream(spliterator, false).forEach(constraintViolation ->
                customMessage.append(constraintViolation.getMessage() + ";"));
        return buildErrorResponseEntity(ErrorCodesEnum.BAD_REQUEST.name(), customMessage.toString(), ErrorCodesEnum.BAD_REQUEST.getHttpStatus());
    }

    /**
     * Handle request parameter exception response entity.
     *
     * @param e the e
     * @return the response entity
     */
    @ExceptionHandler(UnsatisfiedServletRequestParameterException.class)
    public ResponseEntity<ErrorDTO> handleRequestParameterException(UnsatisfiedServletRequestParameterException e) {
        logging.error(() -> "Handling unsatisfied request parameter error: " + e);
        return buildErrorResponseEntity(ErrorCodesEnum.BAD_REQUEST.name(), e.getMessage(), ErrorCodesEnum.BAD_REQUEST.getHttpStatus());
    }

    /**
     * Handle generic exception response entity.
     *
     * @param e the e
     * @return the response entity
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleGenericException(Exception e) {
        logging.error(() -> "Handling unexpected error: " + e.getCause());
        return buildErrorResponseEntity(ErrorCodesEnum.INTERNAL_ERROR);
    }

    /**
     * Build error response entity response entity.
     *
     * @param errorCode the error code
     * @param message   the message
     * @param status    the status
     * @return the response entity
     */
    private ResponseEntity<ErrorDTO> buildErrorResponseEntity(String errorCode, String message, HttpStatus status) {
        ErrorDTO errorDTO = ErrorDTO.builder()
                .errorCode(errorCode)
                .message(message)
                .build();
        return new ResponseEntity(errorDTO, status);
    }

    /**
     * Build error response entity response entity.
     *
     * @param errorCodesEnum the error codes enum
     * @return the response entity
     */
    private ResponseEntity<ErrorDTO> buildErrorResponseEntity(ErrorCodesEnum errorCodesEnum) {
        ErrorDTO errorDTO = ErrorDTO.builder()
                .errorCode(errorCodesEnum.name())
                .message(errorCodesEnum.getDefaultMessage())
                .build();
        return new ResponseEntity(errorDTO, errorCodesEnum.getHttpStatus());
    }

}
