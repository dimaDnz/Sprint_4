package praktikum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import praktikum.pages.MainPage;

import java.time.Duration;


import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AccordionClickerTest {

    private final String locator;
    private final boolean expectedResult;
    private WebDriver driver;

    public AccordionClickerTest(String locator, boolean expectedResult) {
        this.locator = locator;
        this.expectedResult = expectedResult;
    }
    @Parameterized.Parameters
    public static Object[][] getLocatorParam() {

        return new Object[][]{
                {"0", true},
                {"1", true},
                {"2", true},
                {"3", true},
                {"4", true},
                {"5", true},
                {"6", true},
                {"7", true},
                {"8", false},
        };
    }


    @Before
    public void startFirefox(){
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new FirefoxDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void checkAccordion() {
        MainPage main =new MainPage(driver);

        //open web-page
        main.open();

        //click on accept cookies button
        main.acceptCookies();

        boolean result = main.hasAccordion(this.locator);
        assertEquals("error not found", expectedResult, result);
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }
}
