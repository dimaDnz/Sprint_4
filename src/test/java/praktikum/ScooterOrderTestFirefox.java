package praktikum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import praktikum.pages.FirstFormPage;
import praktikum.pages.MainPage;
import praktikum.pages.SecondFormPage;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class ScooterOrderTestFirefox {

    private WebDriver driver;

    @Before
    public void startFirefox(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void orderTestSuccess() throws InterruptedException {
        MainPage main =new MainPage(driver);

        main.open();
        main.acceptCookies();

        FirstFormPage FFP = main.pressHeaderOrderButton();
        FFP.typeFirstName("Иван");
        FFP.typeSecondName("Иванов");
        FFP.typeAddress("Москва");
        FFP.chooseStation();
        FFP.printPhone("+78005553535");
        SecondFormPage ssp = FFP.clickNextButton();

        ssp.pickDeDate();
        ssp.pickDaysOfRent();
        ssp.pickColor();
        ssp.pressOrder();
        ssp.pressConfirm();
        String result = ssp.getTextOfHeader();
        boolean hasSuccess = result.contains("Заказ оформлен");

        assertEquals(hasSuccess,true);
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }
}
