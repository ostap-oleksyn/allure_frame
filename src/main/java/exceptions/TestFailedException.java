package exceptions;


public final class TestFailedException extends AssertionError {

    public TestFailedException() {
        super();
    }

    public TestFailedException(final String message) {
        super(message);
    }

    public TestFailedException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public TestFailedException(final Throwable cause) {
        super(cause);
    }

}
