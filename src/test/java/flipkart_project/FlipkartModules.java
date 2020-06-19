package flipkart_project;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlipkartModules {
	
	WebDriver driver;
	Properties prop;
	
	public  FlipkartModules(WebDriver driver, Properties property) {
		this.driver = driver;
		this.prop = property;		
	}
	
	public void login() throws InterruptedException {
		String usernamePath = prop.getProperty("usernamepath");
		String username = prop.getProperty("username");
		String passwordPath = prop.getProperty("passwordpath");
		String password = prop.getProperty("password");
		String loginPath = prop.getProperty("loginpath");
		String Title = prop.getProperty("title");
		
		driver.findElement(By.xpath(usernamePath)).sendKeys(username);
		Thread.sleep(3000);
		driver.findElement(By.xpath(passwordPath)).sendKeys(password);
		Thread.sleep(3000);
		driver.findElement(By.xpath(loginPath)).click();
		Thread.sleep(3000);
		if(driver.getTitle().contains(Title)) {
			System.out.println("Login Successful");
		}
		else {
			System.out.println("Something went worng!! Check Username or Password");
		}
		
	}
	
	public void search() throws InterruptedException {
		
		String searchPath, searchContent, searchButton ;
		searchPath = prop.getProperty("searchpath");
		searchContent = prop.getProperty("searchContent");
		searchButton = prop.getProperty("searchButton");
		
		// Performing the search of the product on the search window
		driver.findElement(By.xpath(searchPath)).sendKeys(searchContent);
		driver.findElement(By.xpath(searchButton)).click();
		Thread.sleep(5000);
		
	}
	
	public void filter () throws InterruptedException {
		String filterROM, filterROM64, filterColor, filterRAM;
		filterROM = prop.getProperty("filterROM");
		filterROM64 = prop.getProperty("filterROM64");
		filterColor = prop.getProperty("filterColor");
		filterRAM = prop.getProperty("filterRAM");
		
		driver.findElement(By.xpath(filterROM)).click();
		driver.findElement(By.xpath(filterROM64)).click();
		Thread.sleep(3000);
		if (driver.findElement(By.xpath(filterColor)).isDisplayed() &&
			driver.findElement(By.xpath(filterRAM)).isDisplayed()) {
			driver.findElement(By.xpath(filterColor)).click();
		}
	}
	
	public void shopProduct() throws InterruptedException {
		
		String confirmProductname, confrimProductRAM, addpincode, checkpincode, Addtocart, pincode;
		// Getting the array of tabs
		ArrayList<String> wins = new ArrayList<String>(driver.getWindowHandles());
		// wins.
		
		// Moving to tab1
		driver.switchTo().window(wins.get(1));
		confirmProductname = prop.getProperty("ConfirmProductname");
		confrimProductRAM = prop.getProperty("confirmProductRAM");
		addpincode = prop.getProperty("addpincode");
		checkpincode = prop.getProperty("checkpincode");
		Addtocart = prop.getProperty("Addtocart");
		pincode = prop.getProperty("pincode");

		// Check if the required product is the one which is selected
		if(driver.findElement(By.xpath(confirmProductname)).isDisplayed())
		{
			// Check if the product with the specified RAM is chosen
			if(driver.findElement(By.xpath(confrimProductRAM)).isSelected()) {
				
				System.out.println("ONE is PRINTED");
				// Adding the pincode to check availability
				driver.findElement(By.xpath(addpincode)).clear();
				driver.findElement(By.xpath(addpincode)).click();
				driver.findElement(By.xpath(addpincode)).sendKeys(pincode);
				driver.findElement(By.xpath(checkpincode)).click();
				Thread.sleep(5000);
				
				if (driver.findElement(By.xpath(Addtocart)).isEnabled()) {
					driver.findElement(By.xpath(Addtocart)).click();
				}
				
			    // If 'Add To cart button is not enabled
				else {
					System.out.println("The product is not available currently");
				}
				
			}
			
			// Select the product with the specified RAM
			else {
				driver.findElement(By.xpath(confrimProductRAM)).click();
				Thread.sleep(3000);
				
				// Adding the pincode to check availability
				driver.findElement(By.xpath(checkpincode)).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath(addpincode)).clear();  
				Thread.sleep(5000);
				System.out.println("TWO is PRINTED");
				driver.findElement(By.xpath(addpincode)).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath(addpincode)).sendKeys(pincode);
				Thread.sleep(3000);
				driver.findElement(By.xpath(checkpincode)).click();
				Thread.sleep(5000);
				System.out.println("TWO is PRINTED");
				
				// Adding the product to the cart
				if (driver.findElement(By.xpath(Addtocart)).isEnabled()) {
					
					driver.findElement(By.xpath(Addtocart)).click();
				}
				
				// If 'Add To cart button is not enabled
				else {
					System.out.println("The product is not available currently+++++++++++");
				}
			}
		}
		
		// Print error if the selected product is not chosen
		else {
			System.out.println("REquired product not selected");
		}
		
		/*driver.findElement(By.xpath(addtocart)).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(placeorder)).click();*/
		
		
	}
	
	
	
	

}
