package seleniumDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShadowElement {
	
	WebDriver driver ; 
	@BeforeTest
	
	public void beforetest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		
	}
	
	@Test
	public void shadowElementTest() throws InterruptedException {

		driver.navigate().to("https://books-pwakit.appspot.com/");
		Thread.sleep(5000);
		System.out.println("The page title is "+driver.getTitle());		
		WebElement shadowHost = driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement appHeader = (WebElement) js.executeScript("return arguments[0].shadowRoot.querySelector('app-header')", shadowHost);
		WebElement bookInputDecorator = appHeader.findElement(By.tagName("book-input-decorator"));
		WebElement searchBox = (WebElement) js.executeScript("return arguments[0].querySelector(\"input[aria-label='Search Books']\")", bookInputDecorator);
		searchBox.sendKeys("Automation Testing");
		Thread.sleep(5000);
		
	}
	
	@AfterTest
	public void afterTest() {
		
		driver.quit();
		
	}

}
