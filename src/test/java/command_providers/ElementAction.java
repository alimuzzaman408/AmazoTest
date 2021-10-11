package command_providers;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementAction {
	private By locator;
	private WebDriver driver;
	private static final Logger LOGGER = LogManager.getLogger(ElementAction.class);

	public ElementAction(WebDriver driver, By locator) {
		this.locator = locator;
		this.driver = driver;
	}

	public WebElement getElement() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement element = null;
		try{
			element = driver.findElement(locator);

		} catch (Exception e) {
			LOGGER.error("Element Exception for the locator " + locator + " and exception is: " + e);
		}
		return element;
	}

	public ElementAction click() {
		getElement().click();
		return this;
	}

	public ElementAction setValue(String value) {
		getElement().clear();
		getElement().sendKeys(value);
		return this;
	}

	
	public boolean amazonBadgepresent() {
		return getElement().isDisplayed();
	}
	

	public String getTextValue() {
		return getElement().getText();
	}
}
