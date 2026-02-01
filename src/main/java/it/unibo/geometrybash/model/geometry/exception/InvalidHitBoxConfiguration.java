package it.unibo.geometrybash.model.geometry.exception;


public class InvalidHitBoxConfiguration extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "Invalid HitBox configuration.";
    private static final long serialVersionUID = 1L;

    public InvalidHitBoxConfiguration(final String message) {
        super(DEFAULT_MESSAGE + " " + message);
    }

    public InvalidHitBoxConfiguration() {
        super(DEFAULT_MESSAGE);
    }
}