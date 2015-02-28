package local.browsers;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPNTChrome {
	
	ChromeDriver driver;
	@Before
	public void setUp(){
		System.setProperty("webdriver.chrome.driver","C:\\Users\\srikanthvejendla\\Downloads\\chromedriver_win32\\chromedriver.exe");
		//Setup env req for your test case
		driver=new ChromeDriver();
		//Chrome Executable for Selenium-http://chromedriver.storage.googleapis.com/index.html
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
