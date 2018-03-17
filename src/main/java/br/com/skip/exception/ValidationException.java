package br.com.skip.exception;



/**
 * Kind of exception to be thrown in the application business layer.
 * 
 * @author Erik Oliveira
 */
public class ValidationException extends Exception {
    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = -2445199305101467563L;

    /**
     * Constructs a new exception with null as its detail message.
     */
    public ValidationException() {
        super();
    }

    /**
     * Constructs a new exception with the specified detail message and cause.
     * 
     * @param message
     *            the detail message (which is saved for later retrieval by the
     *            {@link Throwable#getMessage()} method).
     * @param cause
     *            the cause (which is saved for later retrieval by the {@link Throwable#getCause()}
     *            method). (A null value is permitted, and indicates that the cause is nonexistent
     *            or unknown.)
     */
    public ValidationException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new exception with the specified detail message.
     * 
     * @param message
     *            the detail message. The detail message is saved for later retrieval by the
     *            {@link Throwable#getMessage()} method.
     */
    public ValidationException(final String message) {
        super(message);
    }

    /**
     * Constructs a new exception with the specified cause and a detail message of (cause==null ?
     * null : cause.toString()) (which typically contains the class and detail message of cause).
     * This constructor is useful for exceptions that are little more than wrappers for other
     * throwables (for example, {@link java.security.PrivilegedActionException}).
     * 
     * @param cause
     *            cause - the cause (which is saved for later retrieval by the
     *            {@link Throwable#getCause()} method). (A null value is permitted, and indicates
     *            that the cause is nonexistent or unknown.)
     */
    public ValidationException(final Throwable cause) {
        super(cause);
    }
}