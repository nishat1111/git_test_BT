import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class listner extends commonSetup implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("hello");
        DateFormat dateFormat = new SimpleDateFormat(("yyyy/MM/dd/HH-mm-ss"));
        Date date = new Date();
        String name =dateFormat.format(date);
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(file, new File("src/test/java/screenshots/" + name + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
    }

}
