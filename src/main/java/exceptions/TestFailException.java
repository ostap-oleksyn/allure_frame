package exceptions;


public class TestFailException extends AssertionError {

    public TestFailException() {
    }

    public TestFailException(String message) {
        super(message);
    }

    public TestFailException(String message, Throwable cause) {
        super(message, cause);
    }

    public TestFailException(Throwable cause) {
        super(cause);
    }

}
