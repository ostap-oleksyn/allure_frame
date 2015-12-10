package listeners;

import exceptions.TestFailedException;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import runner.TestRunner;

import java.lang.reflect.Field;

@Deprecated
public class VerifyListener implements IInvokedMethodListener {
    @Override
    public void beforeInvocation(final IInvokedMethod iInvokedMethod, final ITestResult iTestResult) {
    }

    @Override
    public void afterInvocation(final IInvokedMethod iInvokedMethod, final ITestResult iTestResult) {
        Field result;
        final Throwable testException = iTestResult.getThrowable();
        if (iInvokedMethod.getTestMethod().isTest()) {
            try {
                result = TestRunner.class.getDeclaredField("isVerificationFailed");
                result.setAccessible(true);
                final Boolean isVerificationFailed = (Boolean) result.get(null);

                if (isVerificationFailed) {
                    iTestResult.setStatus(ITestResult.FAILURE);
                    if (testException == null) {
                        iTestResult.setThrowable(new TestFailedException("At least 1 verification failed"));
                    } else {
                        iTestResult.setThrowable(testException);
                    }
                }
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
