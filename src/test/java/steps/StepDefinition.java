package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pages.HomePage;
import pages.TestBase;

public class StepDefinition extends TestBase {

	HomePage homePage;

	@Before
	public void beforeRun() {
		initDriver();
		homePage = PageFactory.initElements(driver, HomePage.class);
	}

	@Given("{string} button exists")
	public void button_exists(String button) {
		driver.get("http://techfios.com/test/101/");

		switch (button) {
		case "skyblue":
			String actualButton = homePage.ButtonExists("sky blue");

			String expectedButton = "Set SkyBlue Background";
			Assert.assertEquals(expectedButton, actualButton);
			break;
		case "white":
			String actualButton2 = homePage.ButtonExists("white");

			String expectedButton2 = "Set White Background";
			Assert.assertEquals(expectedButton2, actualButton2);
			break;
		}
	}

	@When("I click on the {string}")
	public void i_click_on_the(String button) {
		homePage.clickOnButton(button);
	}

	@Then("the background color will change to {string}")
	public void the_background_color_will_change_to(String colorName) {
		String bgColor = driver.findElement(By.tagName("body")).getCssValue("background-color");
		switch (colorName) {
			case "skyblue":
				assert(bgColor.equals("rgba(135, 206, 235, 1)"));
				break;
			case "white":
				assert(bgColor.equals("rgba(255, 255, 255, 1)"));
				break;

				}}

	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
