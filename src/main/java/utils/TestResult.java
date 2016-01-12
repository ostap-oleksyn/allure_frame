package utils;


public final class TestResult {

    private boolean isVerificationFailed;

    public void fail() {
        this.isVerificationFailed = true;
    }

    public boolean getResult() {
        return isVerificationFailed;
    }
}
