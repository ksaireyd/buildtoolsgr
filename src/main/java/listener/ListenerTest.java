package listener;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ITestContext;
import org.apache.log4j.Logger;
import sender.Sender;

import java.util.ArrayList;


public class ListenerTest implements ITestListener {
    private static final Logger LOGGER = Logger.getLogger(ListenerTest.class);
    private ArrayList<String> passedTests = new ArrayList<>();
    private ArrayList<String> failedTests = new ArrayList<>();
    @Override
    public void onFinish(ITestContext arg0) {
        LOGGER.info("The name of the testcase passed is :" + passedTests.toString() );
        LOGGER.error("The name of the testcase failed is :"+ failedTests.toString());
        Sender.sendletter();
        Sender.sendletter();
        Sender.sendletter();
    }


    @Override
    public void onTestFailure(ITestResult Result)
    {
        failedTests.add(Result.getName());
        LOGGER.error("TEST FAILED " + Result.getName());

    }


    @Override
    public void onTestStart(ITestResult Result)
    {
        LOGGER.info(Result.getName()+" test case started");
    }


    @Override
    public void onTestSuccess(ITestResult Result)
    {
        String name = Result.getName();
        passedTests.add(name);
    }


}
