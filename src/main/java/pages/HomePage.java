package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.CSS, using = "button[onclick=\"myFunctionSky()\"]")
	WebElement SkyBlue_Button_Location;
	@FindBy(how = How.CSS, using = "body[style = 'background-color: skyblue;']")
	WebElement SkyBlue_Background_Color;
	@FindBy(how = How.CSS, using = "button[onclick=\"myFunctionWhite()\"]")
	WebElement White_Button_Location;
	@FindBy(how = How.CSS, using = "body[style = 'background-color: white;']")
	WebElement White_Background_Color;

	public String ButtonExists(String button) {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (button.equalsIgnoreCase("Set SkyBlue Background")) {
			return SkyBlue_Button_Location.getText();
		} else {
			return White_Button_Location.getText();
		}
	}

	public void clickOnButton(String button) {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (button.equalsIgnoreCase("Set SkyBlue Background")) {
			SkyBlue_Button_Location.click();
		}else{
			White_Button_Location.click();}

	}

	public String backgroundColor(String color) {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(color.equalsIgnoreCase("sky blue")) {
			return SkyBlue_Background_Color.getText();
		}else {
			return White_Background_Color.getText();
		}
		 
	}


}
