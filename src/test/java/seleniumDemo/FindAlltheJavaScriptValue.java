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

public class FindAlltheJavaScriptValue {

	WebDriver driver ;
	
	@BeforeTest
	public void beforetest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		
	}


@Test
public void findAlltheJavaScriptValue() {
	
	 // Enable DevTools Protocol
    DevTools devTools = ((ChromeDriver) driver).getDevTools();
    devTools.createSession();

    // Enable network tracking
    devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

    // Add a listener to capture network responses
    
        // Filter responses with MIME type for JavaScript
    	// Add a listener to capture network responses
        devTools.addListener(Network.responseReceived(), response -> {
            // Filter responses with MIME type for JavaScript
            String mimeType = response.getResponse().getMimeType();
            if (mimeType.contains("javascript")) {
                System.out.println("JavaScript Response URL: " + response.getResponse().getUrl());

                // Fetch the body of the response
                try {
                    Network.GetResponseBodyResponse responseBody = devTools.send(Network.getResponseBody(response.getRequestId()));
                    if (responseBody != null) {
                        System.out.println("JavaScript Response Body: " + responseBody.getBody());
                    } else {
                        System.out.println("No response body available for: " + response.getResponse().getUrl());
                    }
                } catch (Exception e) {
                    System.err.println("Error fetching response body: " + e.getMessage());
                }
            }
        });

    // Navigate to a website
    driver.get("https://www.amazon.in/");

    // Perform actions
    System.out.println("Page Title: " + driver.getTitle());
}


	
@AfterTest
public void afterTest() {
	
	driver.quit();
	
}
	
	
	
}
