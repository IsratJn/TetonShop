package israt.PageObjectModel;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import israt.AbstractComponents.AbstractComponent;

public class ShippingPage extends AbstractComponent{
	
	WebDriver driver;	
	
	public ShippingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(id = "homeDeliveryRadio")
	WebElement radio;
	
	@FindBy(css = "h4[class='text-center']")
	WebElement newAddress;
	
	
	public CreateAddressPage createNewAddress() throws InterruptedException {
		
		homeDelivery();
		newAddress.click();
		CreateAddressPage createAddress = new CreateAddressPage(driver);
		return createAddress;
	}
	
	

	

}
