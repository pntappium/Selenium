package remote.browsers;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

//sauce labs username is pntselenium
public class LoginToPNTOnCloud {
	
	WebDriver driver;
	@Before
	public void setUp() throws MalformedURLException{
		DesiredCapabilities caps = DesiredCapabilities.chrome();
		caps.setCapability("platform", "Windows 7");
		caps.setCapability("version", "38.0");
//		DesiredCapabilities caps = DesiredCapabilities.firefox();
//		caps.setCapability("platform", "Windows 7");
//		caps.setCapability("version", "33.0");
		//Setup env req for your test case
		driver=new RemoteWebDriver(new URL("http://pntselenium:8cd6ba99-674e-4d7b-a5ea-5e5085e71d9b@ondemand.saucelabs.com:80/wd/hub"), caps);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	
	@Test
	public void LoginToPNT(){
		//Test Script
		driver.get("http://peoplentech.com/forum2/");
		driver.findElement(By.xpath("//*[@id='frmLogin']/div/div[3]/dl/dd[1]/input")).sendKeys("qtptestuser1");
		driver.findElement(By.xpath("//*[@id='frmLogin']/div/div[3]/dl/dd[2]/input")).sendKeys("abcd1234");
		driver.findElement(By.xpath("//*[@id='frmLogin']/div/div[3]/p[1]/input")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id='button_logout']/a")).isDisplayed());
	}
	
	@After
	public void tearDown(){
		//release the env
		driver.quit();
	}

}
