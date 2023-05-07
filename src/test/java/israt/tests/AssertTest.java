package israt.tests;

import org.testng.Assert;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import israt.PageObjectModel.CartPage;
import israt.PageObjectModel.ProductCatalogue;
import israt.TestComponents.BaseTest;

public class AssertTest extends BaseTest {
	

	@Test(dataProvider="getData")
	public void loginSuccess(HashMap<String,String> input) throws IOException, InterruptedException {
					
		landingPage.loginApplication(input.get("email"),input.get("password"));
		landingPage.goToProduct();
		
		
	}
	
	
	@Test(groups = {"fail"}, dataProvider="getData")
	public void loginErrorValidation(HashMap<String,String> input) throws IOException, InterruptedException {
					
		landingPage.loginApplication(input.get("wrongemail"),input.get("wrongpass"));
		Assert.assertEquals("This email is not registered", landingPage.getErrorMessage());
		
		
	}
	
	@DataProvider
	  public Object[][] getData() throws IOException
		  {
		  
		List<HashMap<String, String>> data  = getJsonDataToMap(System.getProperty("user.dir")
				+"//src//test//java//israt//data//variables.json"); 
		return new Object[][] {{data.get(0)}, {data.get(1)}};
	  }
	
	
     @Test(dataProvider="getData" )
     public void ProdAdd(HashMap<String,String> input) throws InterruptedException {
        
    	ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));
    	landingPage.goToProduct();
    	productCatalogue.getProductList();
 		String toastMessage = productCatalogue.addProductToCart(input.get("product"));
 		Assert.assertEquals("Product added to cart", toastMessage);
    	 
     }
     
     
     @Test(groups = {"fail"}, dataProvider="getData" )
     public void wrongProdAdd(HashMap<String,String> input) throws InterruptedException {
        
    	ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));
    	landingPage.goToProduct();
    	productCatalogue.getProductList();
 		String toastMessage = productCatalogue.addProductToCart(input.get("wrongprod"));
 		Assert.assertEquals("Product added to cart", toastMessage);
    	 
     }
	
	
	



}
