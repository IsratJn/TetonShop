package israt.PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import israt.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent{
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}	
	@FindBy(xpath = "//a[@class='auth-link']")
	WebElement login;
	
	@FindBy(id = "name")
	WebElement userEmail;
	 
	@FindBy(id = "password")
	WebElement userPassword;
	
	@FindBy(css = "label[class='form-check-label']")
	WebElement checkbox;
	
	@FindBy(css = "button[type='submit']")
	WebElement loginBtn;
	
	@FindBy(css = "div.main-menu ul li:nth-child(3)")
	WebElement productBtn;
	
	@FindBy(css="[class*='flyInOut']")
    WebElement errorMessage;
	
	@FindBy(xpath = "//span[@role='alert']")
	WebElement wrongEmail;

	public ProductCatalogue loginApplication(String email, String pass) {
		// TODO Auto-generated method stub
		login.click();
		userEmail.sendKeys(email);
		userPassword.sendKeys(pass);
		checkbox.click();
		loginBtn.click();
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		return productCatalogue;
		
	}
	
	public void goToProduct() {
		productBtn.click();
	}
	
	public void goTo() {
		driver.get("https://shop.tetonelectronics.com/");
	}
	
	public String getErrorMessage() {
		return wrongEmail.getText();
	}


}
