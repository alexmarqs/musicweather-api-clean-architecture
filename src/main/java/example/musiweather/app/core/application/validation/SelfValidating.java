package example.musiweather.app.core.application.validation;

import javax.validation.*;
import java.util.Set;

/**
 * The type Self validating.
 *
 * @param <T> the type parameter
 */
public abstract class SelfValidating<T> {

    /**
     * The Validator.
     */
    private Validator validator;

    /**
     * Instantiates a new Self validating.
     */
    public SelfValidating() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    /**
     * Validate.
     */
    protected void validate() {
        Set<ConstraintViolation<T>> violations = validator.validate((T) this);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }

}
