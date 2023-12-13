package it.konvergence.myproject.domain;

/**
 * @author Gianluca Ferruzzi
 * @version 1.0
 * @since 12/13/23
 */
public class CustomValidationException extends RuntimeException {
    private final String errorMessage;

    public CustomValidationException(String errorMessage) {
        super("Validation error");
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
