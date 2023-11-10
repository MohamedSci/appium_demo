import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import io.appium.java_client.MobileElement;


public class GmailAppiumTest {
WebDriver driver;

@BeforeMethod
@BeforeClass
public void setUp() throws MalformedURLException{
	//Set up desired capabilities and pass the Android app-activity and app-package to Appium
	DesiredCapabilities capabilities = new DesiredCapabilities();
	capabilities.setCapability("BROWSER_NAME", "Android");
	capabilities.setCapability("VERSION", "4.4.2"); 
	capabilities.setCapability("deviceName","emulator-5554");
	capabilities.setCapability("platformName","Android");
    capabilities.setCapability("appPackage", "com.google.android.gm");
// This package name of your app (you can get it from apk info app)
	capabilities.setCapability("appActivity","com.google.android.gm.ui.MailActivityGmail"); // This is Launcher activity of your app (you can get it from apk info app)
//Create RemoteWebDriver instance and connect to the Appium server
 //It will launch the Calculator App in Android Device using the configurations specified in Desired Capabilities
   driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
}

@Test
public void testApp() throws Exception {
   //locate the Text on the calculator by using By.name()
	MobileElement el3 = (MobileElement) driver.findElement(By.id("com.google.android.gm:id/welcome_tour_got_it"));
	el3.click();
	MobileElement el4 = (MobileElement) driver.findElement(By.id("com.google.android.gm:id/action_done"));
	el4.click();
	MobileElement el5 = (MobileElement) driver.findElement(By.id("android:id/button1"));
	el5.click();
	MobileElement el6 = (MobileElement) driver.findElement(By.id("com.google.android.gm:id/setup_addresses_add_another"));
	el6.click();
	MobileElement el7 = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout"));
	el7.click();
	
	//Check the value on the edit box
System.out.println("The First Appium test is done");
}

@AfterClass
public void teardown(){
	//close the app
	driver.quit();
}
}