import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class commonSetup {
    WebDriver driver;
    void setup(String url){
        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
       // WebDriver driver = new ChromeDriver(options);
         driver = new ChromeDriver(options);
        driver.get(url);
        driver.manage().window().maximize();
    }
    void cleanup(){
        driver.quit();}
}
