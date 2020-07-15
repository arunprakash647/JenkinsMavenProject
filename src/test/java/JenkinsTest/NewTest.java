package JenkinsTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewTest {
	public WebDriver driver;
    @BeforeClass
    public void launchApplication() {
    	WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://demowebshop.tricentis.com/login");
    }
    @Test(priority = 1)
    public void Login() {
        driver.findElement(By.id("Email")).sendKeys("manipal822@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("manipal123");
        driver.findElement(By.xpath("//input[@type='submit'and @value='Log in']")).click();
    }
    @Test(priority = 2)
    public void Logout() {
        driver.findElement(By.linkText("Log out")).click();
    }
    @AfterClass
    public void closeApplication() {
        driver.close();
    }

}
