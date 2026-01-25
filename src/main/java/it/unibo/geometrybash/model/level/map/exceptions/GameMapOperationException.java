package it.unibo.geometrybash.model.level.map.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.unibo.geometrybash.model.exceptions.RunTimeModelInitializationException;

/**
 * Exception thrown when an invalid operation is performed on the game map.
 */
public class GameMapOperationException extends Exception {

    private static final String DEFAULT_MESSAGE = "Error during an operation using a game map ";
    private static final Logger LOGGER = LoggerFactory.getLogger(RunTimeModelInitializationException.class);

    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new exception with a custom message appended to the default one.
     *
     * @param message the detail message.
     */
    public GameMapOperationException(final String message) {
        super(DEFAULT_MESSAGE + " " + message);
        LOGGER.debug("GameMapOperationException thrown: {} ", message);
    }

    /**
     * Constructs a new exception with the default message.
     *
     * <p>Uses the default message.
     */
    public GameMapOperationException() {
        super(DEFAULT_MESSAGE);
    }
}
