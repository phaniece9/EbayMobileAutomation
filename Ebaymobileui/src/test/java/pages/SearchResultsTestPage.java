package pages;

import io.appium.java_client.android.AndroidDeviceActionShortcuts;
import io.appium.java_client.android.AndroidKeyCode;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import pages.LoginTestPage;

import pages.SearchResultPage;
import com.basesetup.BaseSetup;





public class SearchResultsTestPage extends BaseSetup{

	BasePage basepage;
	LoginTestPage loginTest;
	SearchResultPage searchResult;
	
	BaseSetup bs;
	
	
	@Test
	public void searchAProduct() throws Exception{
		loginTest.login();
		
		
		
		
		String Filepath = "E:\\Projects\\Ebaymobileui\\src\\main\\resources\\Properties\\object.properties";
		FileInputStream Locator = new FileInputStream(Filepath);
		
		Properties obj=new Properties();
		
		obj.load(Locator);
		
		basepage.searchFld.isDisplayed();
		basepage.searchFld.sendKeys(obj.getProperty("tvsearch"));
		
		//moving down
		
		((AndroidDeviceActionShortcuts) bs).pressKeyCode(AndroidKeyCode.ACTION_DOWN);
		Thread.sleep(1000);
		
		((AndroidDeviceActionShortcuts) bs).pressKeyCode(AndroidKeyCode.ENTER);
		//select sort
		searchResult.sortby.click();
		//Thread.sleep(1000);
		bs.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//select filter
		searchResult.filter.click();
		bs.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Thread.sleep(1000);
		//select price range
		searchResult.pricerange.click();
		bs.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Thread.sleep(1000);
		bs.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		searchResult.done.click();
		bs.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		searchResult.select.click();
		
		
}
	
	@Test
	public void searchAProductAndPurchase() throws Exception{
		searchAProduct();
		
		searchResult.review.click();
		
		searchResult.buyNowBtn.isDisplayed();
		searchResult.buyNowBtn.click();
		searchResult.proceedToPayBtn.isDisplayed();
		searchResult.proceedToPayBtn.click();
}
	
}
