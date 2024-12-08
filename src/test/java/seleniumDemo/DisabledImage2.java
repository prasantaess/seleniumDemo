package seleniumDemo;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v127.network.Network;
import org.openqa.selenium.devtools.v127.network.Network.GetResponseBodyResponse;
import org.openqa.selenium.devtools.v127.network.model.Response;
import org.openqa.selenium.devtools.v127.network.model.Request;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.errorprone.annotations.ThreadSafe;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DisabledImage2 {

	WebDriver driver ;
	
	@BeforeTest
	public void beforetest() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--blink-settings=imagesEnabled=false");		
		driver= new ChromeDriver(op);
		driver.manage().window().fullscreen();
		
		
	}
@Test
public void imageDisabled() throws InterruptedException {
	
    driver.navigate().to("https://www.amazon.in/");
    Thread.sleep(5000);
   
}
	


	
@AfterTest
public void afterTest() {
	
	driver.quit();
	
}
	
	
	
}
