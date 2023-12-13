package it.konvergence.myproject.domain;

import org.jetbrains.annotations.NotNull;

/**
 * @author Gianluca Ferruzzi
 * @version 1.0
 * @since 12/13/23
 */
public class CustomValidationException extends RuntimeException {
    private final String errorMessage;

    public CustomValidationException(@NotNull("errorMessage was NUll") String errorMessage) {
        super("Validation error");
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
