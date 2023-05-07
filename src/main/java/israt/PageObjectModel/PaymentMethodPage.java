package israt.PageObjectModel;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import israt.AbstractComponents.AbstractComponent;

public class PaymentMethodPage extends AbstractComponent {

	WebDriver driver;

	public PaymentMethodPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
   @FindBy(id = "CODPaymentRadio")
   WebElement COD;
   
   @FindBy(id = "sslcommerzPaymentRadio")
   WebElement onlinePayment;
   
   @FindBy(id = "terms")
   WebElement terms;
   
   @FindBy(id = "placeOrderBtn")
   WebElement placeOrderBtn;
   
   
   
   
   
   public OrdersPage placeOrder() {
	   paymentMethod(COD);
	   ((JavascriptExecutor) driver).executeScript("arguments[0].click();", terms);
	   ((JavascriptExecutor) driver).executeScript("arguments[0].click();", placeOrderBtn);
	   OrdersPage ordersPage = new OrdersPage(driver);
	   return ordersPage;
   }
   
   
}
