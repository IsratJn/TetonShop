package israt.PageObjectModel;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import israt.AbstractComponents.AbstractComponent;

public class EditOrdersPage extends AbstractComponent{
	
	WebDriver driver;

	public EditOrdersPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement cancel;
	
	public void cancelOrder() {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", cancel);
	}
	

}
