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

public class DisabledImage {

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
public void imageDisabled() throws InterruptedException {
	
    // Navigate to a website
    driver.navigate().to("https://www.flipkart.com/");

    // Perform actions
    System.out.println("Page Title: " + driver.getTitle());
    
    Thread.sleep(5000);

    // Quit the driver
    driver.quit();
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
    driver.get("https://www.flipkart.com/");

    // Perform actions
    System.out.println("Page Title: " + driver.getTitle());
}

    
  @Test
  public void printDomDetails() {
	 
	// Navigate to a website
      driver.get("https://www.flipkart.com/");

      // Use JavascriptExecutor to fetch the entire DOM
      JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
      String dom = (String) jsExecutor.executeScript("return document.documentElement.outerHTML;");

      // Print the DOM
      System.out.println("DOM Details via JavaScript: ");
      System.out.println(dom);
	  
      String pageSource = driver.getPageSource();
      System.out.println("DOM Details: ");
      System.out.println(pageSource);
      
   // Get all elements in the DOM using XPath to find all elements
      List<WebElement> allElements = driver.findElements(By.xpath("//*"));

      // Iterate through all elements and re-locate them inside the loop to avoid stale reference
      for (int i = 0; i < allElements.size(); i++) {
          try {
              WebElement element = allElements.get(i);
              // Print the entire HTML of the element (including tag and content)
              System.out.println("Element HTML: ");
              System.out.println(element.getAttribute("outerHTML"));
              System.out.println("---------------------------------------------");
          } catch (org.openqa.selenium.StaleElementReferenceException e) {
              System.out.println("Stale element detected, skipping.");
          }
      }
	  
  }
    
    
  @Test
  public void printAPIValue() {
  	
	  DevTools devTools = ((ChromeDriver) driver).getDevTools();
      devTools.createSession();

      // Enable network events
      devTools.send(Network.enable(Optional.of(10000), Optional.of(10000), Optional.empty()));

      // Set up listener to capture network requests and responses
      devTools.addListener(Network.requestWillBeSent(), request -> {
          Request req = request.getRequest();
          System.out.println("Request URL: " + req.getUrl());
          System.out.println("Request Method: " + req.getMethod());
          System.out.println("Request Headers: " + req.getHeaders());
      });

      devTools.addListener(Network.responseReceived(), response -> {
          Response resp = response.getResponse();
          System.out.println("Response URL: " + resp.getUrl());
          System.out.println("Response Status: " + resp.getStatus());
          System.out.println("Response Headers: " + resp.getHeaders());
      });

      // Navigate to a website (e.g., any API-driven page)
      driver.get("https://www.flipkart.com/");

      // You can perform actions here like clicking buttons, submitting forms, etc.
      // For example: driver.findElement(By.id("submitButton")).click();

      // Wait for a while to let the network logs capture
      try {
          Thread.sleep(5000);  // Adjust the wait time as needed for network requests
      } catch (InterruptedException e) {
          e.printStackTrace();
      }

     

      // Perform actions
      System.out.println("Page Title: " + driver.getTitle());
  }   
    
@Test
public void getAllCookieValue() {
	// Navigate to the website where the cookie is set
    driver.get("https://www.flipkart.com/");

 // Capture all cookies
    Set<Cookie> cookies = driver.manage().getCookies();

    // Print all cookie names and their values
    for (Cookie cookie : cookies) {
        System.out.println("Cookie Name: " + cookie.getName() + " | Cookie Value: " + cookie.getValue());
    }

    // If you want to print a specific cookie's value by its name
    String cookieName = "Network-Type"; // Replace with your specific cookie's name
    Cookie specificCookie = driver.manage().getCookieNamed(cookieName);
    if (specificCookie != null) {
        System.out.println("Value of specific cookie (" + cookieName + "): " + specificCookie.getValue());
    } else {
        System.out.println("Cookie not found: " + cookieName);
    }
}

	
@AfterTest
public void afterTest() {
	
	driver.quit();
	
}
	
	
	
}
