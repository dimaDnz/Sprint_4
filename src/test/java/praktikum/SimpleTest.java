package praktikum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import praktikum.pages.MainPage;

import java.time.Duration;

public class SimpleTest {
    private WebDriver driver;

   @Before
   public void startFirefox(){
       WebDriverManager.firefoxdriver().setup();
       driver = new FirefoxDriver();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
   }

    @Test
    public void firstTest() throws InterruptedException {
        MainPage main =new MainPage(driver);

        main.open();
        Thread.sleep(2000);
        main.acceptCookies();
        Thread.sleep(2000);
        main.pressHeaderOrderButton();
        Thread.sleep(2000);
    }

    @Test
    public void mainOrder() throws InterruptedException {
        MainPage main =new MainPage(driver);

        main.open();
        Thread.sleep(2000);
        main.acceptCookies();
        Thread.sleep(2000);
        main.pressMainOrderButton();
        Thread.sleep(2000);
    }

    @After
    public void closeBrowser(){
       driver.quit();
    }

}
