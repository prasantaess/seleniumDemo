package seleniumDemo;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShadowElement2 {
	
	WebDriver driver ; 
	@BeforeTest
	
	public void beforetest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		
	}
	
	@Test
	public void shadowElementTest() throws InterruptedException {

		driver.navigate().to("https://selectorshub.com/xpath-practice-page/");
		Thread.sleep(2000);
		//SearchContext shadow = driver.findElement(By.cssSelector("#userName")).getShadowRoot();
		SearchContext shadow = driver.findElement(By.xpath("//*[@id=\"userName\"]")).getShadowRoot();

		Thread.sleep(1000);
		WebElement link = shadow.findElement(By.cssSelector("a[href='https://selectorshub.com/iframe-in-shadow-dom/']"));

		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",link);
		js.executeScript("arguments[0].click();", link);
		System.out.println("Click on the "+link);
		Thread.sleep(1000);
	}
	
	@AfterTest
	public void afterTest() {
		
		driver.quit();
		
	}

}
