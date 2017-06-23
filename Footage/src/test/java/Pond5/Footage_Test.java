package Pond5;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import org.testng.AssertJUnit;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;


public class Footage_Test {


public WebDriver driver;


  @BeforeTest
  public void beforeTest() {
 		String os = System.getProperty("os.name").toLowerCase();
		System.out.println("OS = " + os);		
		if (os.contains("win")) {
			/* Set paths for geckodriver (FF) and chromedriver. 
			 * Remember to use // in windows path folder 
			 */
			//System.setProperty("webdriver.gecko.driver","C://path_to_geckodriver//");
	        //System.setProperty("webdriver.chrome.driver","C://path_to_chromedriver//");
			System.out.println ("Windows");
			// Maximize Chrome window on Windows
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--start-maximized");
			driver = new ChromeDriver(chromeOptions);

		}
		else if (os.contains("mac")) {
			/* Set paths for geckodriver (FF) and chromedriver for Mac*/ 	
			System.setProperty("webdriver.gecko.driver","/usr/local/bin/geckodriver");
			System.setProperty("webdriver.firefox.bin","/Applications/IBM Firefox.app/Contents/MacOS/firefox-bin");
	        System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
			
			// Maximize Chrome window on MAC
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--kiosk");
			driver = new ChromeDriver(chromeOptions);
	    }
		        
		driver.get("http://www.pond5.com/stock-video-footage/1/car.html#1/2063/resolutions:WEB,car");

  }
/* Test 1
  Test connection to website
*/

  @Test(priority=1,description="Test if we can connect to website")
  public void websiteload() {
		String currentURL=driver.getCurrentUrl();
		AssertJUnit.assertTrue(currentURL.contains("WEB,car"));
	  
  }

/* Test 2
  Select Resolution 4k+, FPS 24 with Loops
*/  
  @Test(priority=2,description="Select Resolution 4k+, FPS 24 with Loops")
  public void selectitems1() {

	    WebElement element = driver.findElement(By.xpath("//*[@id=\"main\"]/div[4]/div/div[3]/div[2]/div[3]/div[1]/label"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().perform();	    

		WebElement element1 = driver.findElement(By.xpath("//*[@id=\"main\"]/div[4]/div/div[3]/div[2]/div[4]/div[2]/label"));
		// The element is not visible to click so must use actions
		Actions actions1 = new Actions(driver);
		actions1.moveToElement(element1).click().perform();

		WebElement element2 = driver.findElement(By.xpath("//*[@id=\"main\"]/div[4]/div/div[3]/div[2]/div[6]/div[7]/label"));
		// The element is not visible to click so must use actions
		Actions actions2 = new Actions(driver);
		actions2.moveToElement(element2).click().perform();
		  		
   }
 
/* Test 3
  Select 2 people
*/ 
  @Test(priority=3,description="Select 2 people")
  public void selectitems2() {
	
	  WebElement element = driver.findElement(By.xpath("//*[@id=\"main\"]/div[4]/div/div[3]/div[2]/div[7]/div[2]/label"));
	  Actions actions = new Actions(driver);
	  actions.moveToElement(element).click().perform();
	  													
  }

/* Test 4
  Select 'Popular' with 2 people
*/  
  @Test(priority=4,description="Select 'Popular' with 2 people")
//  public void selectitems3() throws InterruptedException {
  public void selectitems3() {
	
	  WebElement element = driver.findElement(By.xpath("//*[@id=\"main\"]/div[3]/div/div[3]/div/div[2]/div/a/div"));
	  Actions actions1 = new Actions(driver);
	  actions1.moveToElement(element).sendKeys("Popular").perform();
	  
	  
	  WebElement element1 = driver.findElement(By.xpath("html/body/div[2]/div[4]/div/div[3]/div[2]/div[7]/div[2]/label"));	  
	  Actions actions = new Actions(driver);
	  actions.moveToElement(element1).click().perform();
	  													
  }

/* Test 5
  Select Core Library
*/ 
  @Test(priority=5,description="Core Library")
  public void selectitems4() {
	
	  WebElement element = driver.findElement(By.xpath("//*[@id=\"main\"]/div[4]/div/div[3]/div[2]/div[1]/div[2]/label"));
	  Actions actions = new Actions(driver);
	  actions.moveToElement(element).click().perform();
	  													
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
	    }

}
