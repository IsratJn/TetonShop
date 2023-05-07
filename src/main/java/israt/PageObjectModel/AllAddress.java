package israt.PageObjectModel;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import israt.AbstractComponents.AbstractComponent;

public class AllAddress extends AbstractComponent{
	
	WebDriver driver;
	
public AllAddress(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		goToCartPage();
		goToCheckout();
		homeDelivery();
		
		
		
	}

@FindBy(id ="paymentOption")
WebElement paymentBtn;


public PaymentMethodPage payment() {
	 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", paymentBtn);
	PaymentMethodPage paymentMethodPage = new PaymentMethodPage(driver);
	return paymentMethodPage;
	
}

   

}
