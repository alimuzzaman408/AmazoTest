package command_providers;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
public class BrowserActions {

	public WebDriver driver;
	public BrowserActions(WebDriver driver) {
		this.driver = driver;
	}

	public BrowserActions openBrowser(String url) {
		driver.manage().deleteAllCookies();
		driver.get(url);
		driver.manage().window().maximize();
		return this;
	}

	public BrowserActions closeBrowser() {
		driver.quit();
		return this;
	}

	public String captureTitle() {
		return driver.getTitle();
	}
	
	public String current_Url() {
		return driver.getCurrentUrl();
	}
	
	public String navigateCamelPage(String urllink) {
		driver.navigate().to(urllink);
		return urllink;
		
	}
	
	public BrowserActions scrollDown(String script) {
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		   js.executeScript(script);

		return this;
	}
	
}
