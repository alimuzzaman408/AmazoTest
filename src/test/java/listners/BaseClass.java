package listners;
import command_providers.ActOn;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import utilities.ReadConfigFiles;

public class BaseClass {
	public static WebDriver driver;
    Logger LOGGER = LogManager.getLogger(this.getClass().getName());
    String testCaseName = String.format("--------Test: %s------------", this.getClass().getName());
    String endTestCase = String.format("--------Test End: %s------------", this.getClass().getName());

    @BeforeClass
    public void addThread() {
        ThreadContext.put("threadName", this.getClass().getName());
    }

    @BeforeMethod
    public void openBrowser() {
        String url = ReadConfigFiles.getPropertyValues("Url");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();       
        LOGGER.info(testCaseName);
        LOGGER.debug("Open the URL: " + url);
        ActOn.browser(driver).openBrowser(url);
       
    }

    @AfterMethod
    public void closeBrowser() {
       ActOn.browser(driver).closeBrowser();
        LOGGER.info(endTestCase);
    }
}
