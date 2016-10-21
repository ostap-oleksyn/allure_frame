package listeners;

import exceptions.TestFailedException;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import utils.TestResult;

import java.lang.reflect.Field;


public class VerifyListener implements IInvokedMethodListener {
    @Override
    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
    }

    @Override
    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
        Field result;
        Throwable testException = iTestResult.getThrowable();
        if (iInvokedMethod.getTestMethod().isTest()) {
            try {
                Object object = iInvokedMethod.getTestMethod().getInstance();
                result = iInvokedMethod.getTestMethod().getRealClass().getSuperclass().getDeclaredField("result");
                result.setAccessible(true);
                TestResult isVerificationFailed = (TestResult) result.get(object);

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
