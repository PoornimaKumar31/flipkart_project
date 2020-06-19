package flipkart_project;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Flipkart_shopping {
	
 
  @Test
  public void shop() throws IOException, InterruptedException {
	  Properties prop = new Properties();
	  FileInputStream ip = new FileInputStream("C:\\Intellipat_March 22\\flipkart_project\\src\\test\\java\\flipkart_project\\config.properties");
	  prop.load(ip);
	  WebDriver driver = null;
	 // System.out.println("BROWSER is"+ prop.getProperty("browser"));
	//  System.out.println("test URL is"+ prop.getProperty("testURL"));
	  if(prop.getProperty("browser").equals("chrome"))
	  {
		  System.setProperty("webdriver.chrome.driver","C:\\Intellipat_March 22\\chromedriver.exe");
		  driver = new ChromeDriver();
	  }
	  
	  // Navigating to the test URL
	  driver.get(prop.getProperty("testURL"));
	  Thread.sleep(5000);
	  
	  // Maximizing the window
	  driver.manage().window().maximize();
	  
	  // Creating the object for FlipkartModules class
	  FlipkartModules fm = new FlipkartModules(driver, prop);
	  
	  // Calling the login module to input the username and password.
	  fm.login();
	  
	  // Calling the search() to search for the product Realme 5 Pro (Sparkling Blue, 64 GB)(6BG ROM)
	  fm.search();
	  
	  // Calling the filter() to filter the search further
	  fm.filter();
	  
	  // Calling the shopProduct() to select the required product
	  fm.shopProduct();
	  
	  //driver.close();
	  
	  
	  
	  
	 
  }
}
