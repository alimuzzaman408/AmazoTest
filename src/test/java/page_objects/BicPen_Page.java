package page_objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import command_providers.ActOn;
import command_providers.AssertThat;
import utilities.ReadConfigFiles;

public class BicPen_Page {
	public  WebDriver driver;
	Logger LOGGER = LogManager.getLogger(BicPen_Page.class);

	private static final By search_box=By.id("twotabsearchtextbox");
	private static final By click_searchbtn=By.id("nav-search-submit-button");
	private static final By amazon_choicelabel=By.xpath("//span/span[contains(text(),\"Amazon's\")]/../span[contains(text(),\"Choice\")]");
	private static final By cammelsearch_box=By.xpath("//input[@name='sq']");	
	private static final By cammelsearch_btn=By.xpath("//input[@type='submit']");

	public BicPen_Page(WebDriver driver) {
		this.driver=driver;
	}

	public BicPen_Page setValue(String value) {
		LOGGER.debug("searc value entered");
		ActOn.element(driver, search_box).setValue(value);
		return this;

	}

	public BicPen_Page searchBtn() {
		LOGGER.debug("Search btn clicked");
		ActOn.element(driver, click_searchbtn).click();
		return this;
	}

	public BicPen_Page verifyResult() {
		LOGGER.debug("Result page verified");
		ActOn.browser(driver).scrollDown("window.scrollBy(0,1000)");
		AssertThat.elementAssertions(driver, amazon_choicelabel).elementExist();		
		return this;
	}

	public BicPen_Page bicpenlinkclick() {
		LOGGER.debug("Bic pen item clicked");
		ActOn.element(driver, amazon_choicelabel).click();		
		return this;
	}

	public BicPen_Page navigatecamel() {
		String cu_url=ActOn.browser(driver).current_Url();
		ActOn.browser(driver).navigateCamelPage(ReadConfigFiles.getPropertyValues("camelurl"));
		ActOn.element(driver, cammelsearch_box).setValue(cu_url);
		return this;
	}


	public BicPen_Page camelsearchBtn() {
		LOGGER.debug("Search btn clicked");
		ActOn.element(driver, cammelsearch_btn).click();
		return this;

	}

	public BicPen_Page pricecompare() {

		return this;

	}
}
