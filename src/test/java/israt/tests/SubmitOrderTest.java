package israt.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import israt.PageObjectModel.AllAddress;
import israt.PageObjectModel.CartPage;
import israt.PageObjectModel.CheckoutPage;
import israt.PageObjectModel.ConfirmationPage;
import israt.PageObjectModel.CreateAddressPage;
import israt.PageObjectModel.EditOrdersPage;
import israt.PageObjectModel.LandingPage;
import israt.PageObjectModel.OrdersPage;
import israt.PageObjectModel.PaymentMethodPage;
import israt.PageObjectModel.ProductCatalogue;
import israt.PageObjectModel.ShippingPage;
import israt.TestComponents.BaseTest;

public class SubmitOrderTest extends BaseTest {

	
	    @Test(dataProvider="getData")
	    public void submitOrder(HashMap<String,String> input) throws IOException, InterruptedException {
		
		
		ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));
		landingPage.goToProduct();
		
		
		productCatalogue.getProductList();
		String toastMessage = productCatalogue.addProductToCart(input.get("product"));
		System.out.println(toastMessage);
		CartPage cartPage = productCatalogue.goToCartPage();
		
		ShippingPage shippingPage = cartPage.goToCheckout();
		CreateAddressPage createAddressPage =shippingPage.createNewAddress();
		createAddressPage.selectDropdown(input.get("division"), input.get("district"), input.get("area"));
		createAddressPage.addressValues(input.get("address"),input.get("phone"),input.get("zipcode"));
		createAddressPage.useCurrentLocation();
		
		AllAddress allAddress = createAddressPage.goToAddress();
		PaymentMethodPage paymentMethodPage = allAddress.payment();
		OrdersPage ordersPage = paymentMethodPage.placeOrder();	
		EditOrdersPage editOrdersPage = ordersPage.getOrdersId();
		
		editOrdersPage.cancelOrder();	
        

	}
	    
	    @DataProvider
		  public Object[][] getData() throws IOException
			  {
			  
			List<HashMap<String, String>> data  = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//israt//data//variables.json"); 
			
			return new Object[][] {{data.get(0)}, {data.get(1)}};
		  }
		
	}

