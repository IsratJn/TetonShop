package israt.PageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import israt.AbstractComponents.AbstractComponent;

public class OrdersPage extends AbstractComponent{
	

	WebDriver driver;
	String orderIdNo;
	
	public OrdersPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//tbody/tr/td[1]")
	List<WebElement> ordersId;
	
	@FindBy(xpath = "//tbody/tr[1]/td[1]")
	WebElement firstOrderId;
	
	
	
	
	
	public EditOrdersPage getOrdersId() {
		
		String firstOrderIdName = firstOrderId.getText();
		
		for(int i =0;i<ordersId.size();i++) {
			orderIdNo =ordersId.get(i).getText();
			if(orderIdNo.equalsIgnoreCase(firstOrderIdName)) {
				driver.findElement(By.xpath("//tbody/tr/td[6]")).click();
				break;
				
				
			}
		}
		
		EditOrdersPage editOrdersPage = new EditOrdersPage(driver);
		return editOrdersPage;
		
	}



}
