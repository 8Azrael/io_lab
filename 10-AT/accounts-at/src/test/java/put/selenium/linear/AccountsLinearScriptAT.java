package put.selenium.linear;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import put.selenium.utils.ScreenshotAndQuitOnFailureRule;

import static org.junit.Assert.*;


public class AccountsLinearScriptAT {

    private WebDriver driver;

    @Rule
    public ScreenshotAndQuitOnFailureRule screenshotOnFailureAndWebDriverQuitRule =
            new ScreenshotAndQuitOnFailureRule();


    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "chromedriver-win-108.exe");
        this.driver = new ChromeDriver();
        screenshotOnFailureAndWebDriverQuitRule.setWebDriver(driver);
        driver.get("http://localhost:8080/accounts/controller?action=db_reset");
    }

    @Test
    public void successfulUserRegistration() throws Exception {
        driver.get("http://localhost:8080/accounts/controller/accounts/controller?action=db_reset");
        driver.manage().window().setSize(new Dimension(550, 693));
        driver.findElement(By.linkText("Register")).click();
        assertThat(driver.findElement(By.cssSelector("h3")).getText(), is("Register"));
        driver.findElement(By.name("username")).click();
        driver.findElement(By.name("username")).sendKeys("User123");
        driver.findElement(By.name("password")).sendKeys("Pass123");
        driver.findElement(By.name("repeat_password")).sendKeys("Pass123");
        driver.findElement(By.name("name")).sendKeys("Jan Kowalski");
        driver.findElement(By.name("addressData")).sendKeys("ul. Brzozowa 1 Poznań");
        driver.findElement(By.name("submit")).click();
        assertThat(driver.findElement(By.cssSelector("h3")).getText(), is("Login"));
    }


}
