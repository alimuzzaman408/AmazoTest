package automation_test;

import org.testng.Assert;
import org.testng.annotations.Test;

import command_providers.ActOn;
import listners.BaseClass;
import page_objects.BicPen_Page;

public class BicPen_Test extends BaseClass {

	@Test
	public void validate_Bicpentest(){
		String expected_title="Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
		String actual_title=ActOn.browser(driver).captureTitle();
		Assert.assertEquals(actual_title, expected_title);
		new BicPen_Page(driver)
		.setValue("Bic Pen")
		.searchBtn()
		.verifyResult()
		.bicpenlinkclick()
		.navigatecamel()
		.camelsearchBtn();









	}

}
