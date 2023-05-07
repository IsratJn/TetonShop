package israt.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import israt.PageObjectModel.CartPage;
import israt.PageObjectModel.ShippingPage;

public class AbstractComponent {
	
	WebDriver driver;
	
	
	
	
	public AbstractComponent(WebDriver driver) {
	   this.driver = driver;
	   PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "cartStatus")
	WebElement cartHeader;
	
	@FindBy(xpath = "//button[@class='btn']")
	WebElement checkoutEle;
	
	@FindBy(id = "homeDeliveryRadio")
	WebElement radio;
	
	public void waitForElementToAppear(By findBy) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitForElementToDisappear(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));	
	}
	
	
	public void waitForWebElementToAppear(WebElement ele) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(ele));

	}
	
	public CartPage goToCartPage() {

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", cartHeader);
		CartPage cartPage = new CartPage(driver);
		return cartPage;

		
	}
	
	public void mouseHover(WebElement action) {
		Actions a = new Actions(driver);
		a.moveToElement(action).build().perform();
	}
	
	public void dropDown(WebElement dropD, String dropText) {
		Select obj = new Select(dropD);
		obj.selectByVisibleText(dropText);
	}

public ShippingPage goToCheckout() {
		
		checkoutEle.click();
		ShippingPage shippingPage = new ShippingPage(driver);
		return shippingPage;
	}
    public void homeDelivery() {
    	((JavascriptExecutor) driver).executeScript("arguments[0].click();", radio);
    }
    
    public void paymentMethod(WebElement ele) {
    	((JavascriptExecutor) driver).executeScript("arguments[0].click();", ele);
    	
    }

}
