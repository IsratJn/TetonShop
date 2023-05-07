package israt.PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import israt.AbstractComponents.AbstractComponent;

public class CreateAddressPage extends AbstractComponent{
	
	WebDriver driver;
	
public CreateAddressPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

    @FindBy(css = "select[name='division']")
    WebElement division;
    
    @FindBy(css = "select[name='district']")
    WebElement district;
    
    @FindBy(css = "select[name='area']")
    WebElement area;
    
    @FindBy(id = "address")
    WebElement address;
    
    @FindBy(id = "phone")
    WebElement phone;
    
    @FindBy(id = "pincode")
    WebElement zipCode;
    
    @FindBy(id = "useMyLocationBtn")
    WebElement myLocation;
    
    @FindBy(xpath = "//button[contains(text(),'Create')]")
    WebElement create;
    
   
    
    
    
    
    
    public void selectDropdown(String Div, String Dist, String Area) {
    	dropDown(division, Div);
    	dropDown(district, Dist);
    	dropDown(area, Area);
    }
    
    public void addressValues(String Address, String Phone, String ZipCode) {
    	address.sendKeys(Address);
    	phone.sendKeys(Phone);
    	zipCode.sendKeys(ZipCode);
    }
    
    public void useCurrentLocation() {
    	myLocation.click();
    }
    
    public AllAddress goToAddress() {
    	create.click();
    	AllAddress allAddress = new AllAddress(driver);
    	return allAddress;
    }

}
