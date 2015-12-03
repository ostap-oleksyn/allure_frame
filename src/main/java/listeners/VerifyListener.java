package listeners;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import runner.TestRunner;

import java.lang.reflect.Field;


public class VerifyListener implements IInvokedMethodListener {
    @Override
    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
    }

    @Override
    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
        Field result;
        if (iInvokedMethod.getTestMethod().isTest()) {
            try {
                result = TestRunner.class.getDeclaredField("result");
                if (result.equals("fail")) {
                    iTestResult.setStatus(1);
                }
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
    }
}
