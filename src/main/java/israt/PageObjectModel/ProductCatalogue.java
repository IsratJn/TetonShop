package israt.PageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import israt.AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent{
	
	WebDriver driver;

	public ProductCatalogue(WebDriver driver) {
		// initialization
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "div[class='features-product-content']")
	List<WebElement> products;
	
	@FindBy(css = "div[class='features-product-thumb']")
	WebElement hover;
	
	@FindBy(id = "addToCart")
	WebElement addToCart;
	
	@FindBy(css = ".ng-animating")
	WebElement spinner;
	
	@FindBy(css = "div[class='toast-body'] div")
	WebElement toast;

	By productsBy = By.cssSelector("div[class='features-product-content']");
	By viewDetails = By.cssSelector("div[class = 'features-product-cart'] a");
	
	public List<WebElement> getProductList() {
		waitForElementToAppear(productsBy);
		return products;
	}
	
	public WebElement getProductByName(String productName)
	{
		WebElement prod = getProductList().stream().filter(product->
		product.findElement(By.tagName("h5")).getText().equals(productName)).findFirst().orElse(null);
		System.out.println(prod);
		return prod;
	}
	
	
	public String addProductToCart(String productName) throws InterruptedException
	{
		WebElement prod = getProductByName(productName);
		prod.findElement(By.tagName("a")).click();;
		addToCart.click();
		return toast.getText();
		

	}
	
}
