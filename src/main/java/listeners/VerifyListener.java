package listeners;

import exceptions.TestFailedException;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import utils.TestResult;

import java.lang.reflect.Field;


public final class VerifyListener implements IInvokedMethodListener {
    @Override
    public void beforeInvocation(final IInvokedMethod iInvokedMethod, final ITestResult iTestResult) {
    }

    @Override
    public void afterInvocation(final IInvokedMethod iInvokedMethod, final ITestResult iTestResult) {
        Field result;
        final Throwable testException = iTestResult.getThrowable();
        if (iInvokedMethod.getTestMethod().isTest()) {
            try {
                final Object object = iInvokedMethod.getTestMethod().getInstance();
                result = iInvokedMethod.getTestMethod().getRealClass().getSuperclass().getDeclaredField("result");
                result.setAccessible(true);
                final TestResult isVerificationFailed = (TestResult) result.get(object);

                if (isVerificationFailed.getResult()) {
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
