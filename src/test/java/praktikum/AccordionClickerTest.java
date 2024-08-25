package praktikum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    public static Object[][] getCities() {

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
    public void firstTest() {
        MainPage main =new MainPage(driver);

        //open web-page
        main.open();

        //click on accept cookies button
        main.acceptCookies();


        String heading = String.format("accordion__heading-%s",this.locator);
        WebElement accordionHeader = driver.findElement(By.id(heading));

        //print accordion header text
        String accordionHeaderText = accordionHeader.getText();
        System.out.println("Текст заголовка аккордеона: \""+ accordionHeaderText + "\"");

        //scroll to element
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", accordionHeader);

        //click on element
        accordionHeader.click();

        String panel = String.format("accordion__panel-%s",this.locator);
        WebElement accordionPanel = driver.findElement(By.id(panel));

        //print accordeon panel text
        String accordionPanelText = accordionPanel.getText();
        System.out.println("Текст панели аккордеона: \""+accordionPanelText+"\"");

        assertEquals("error not found", expectedResult, accordionPanel.isDisplayed());
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }
}
