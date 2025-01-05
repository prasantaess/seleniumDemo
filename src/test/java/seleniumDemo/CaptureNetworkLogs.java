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


import io.github.bonigarcia.wdm.WebDriverManager;

public class CaptureNetworkLogs {

	WebDriver driver ;
	
	@BeforeTest
	public void beforetest() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		 // Disable image loading
	     options.addArguments("--blink-settings=imagesEnabled=false");
		//options.addArguments("--disable-images");
		driver = new ChromeDriver(options);
		driver.manage().window().fullscreen();
		
	}

	
@Test
public void captureNetworkLogs() {
	
	// Enable DevTools Protocol
    DevTools devTools = ((ChromeDriver) driver).getDevTools();
    devTools.createSession();

    // Enable network tracking
    devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

    // Add a listener to capture network requests
    devTools.addListener(Network.requestWillBeSent(), request -> {
        System.out.println("Request URL: " + request.getRequest().getUrl());
        System.out.println("Request Method: " + request.getRequest().getMethod());
    });

    // Add a listener to capture network responses
    devTools.addListener(Network.responseReceived(), response -> {
        Response res = response.getResponse();
        System.out.println("Response URL: " + res.getUrl());
        System.out.println("Response Status: " + res.getStatus());
    });

    // Navigate to a website
    driver.get("https://www.flipkart.com/");

    // Perform actions
    System.out.println("Page Title: " + driver.getTitle());

	
}
	
@AfterTest
public void afterTest() {
	
	driver.quit();
	
}
	
	
	
}
