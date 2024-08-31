package praktikum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import praktikum.pages.FirstFormPage;
import praktikum.pages.MainPage;
import praktikum.pages.SecondFormPage;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class ScooterOrderTestFirefox {

    private WebDriver driver;
    private  String firstName;
    private  String secondName;
    private String address;
    private String phone;
    private int station;


    public ScooterOrderTestFirefox(String firstName, String secondName, String address, String phone, int station){
        this.firstName = firstName;
        this.secondName = secondName;
        this.address = address;
        this.phone = phone;
        this.station = station;
    }
    @Parameterized.Parameters
    public static Object[][] getFormData() {

        return new Object[][]{
                {"Иван", "Иванов", "Москва ул.Пушкина д.Колотушкина", "+78005553535", 19},
                {"Авдотья", "Никитишна", "Антарктида, ст.Биполярная", "+78881239876", 15},
        };
    }

    @Before
    public void startFirefox(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }



    @Test
    public void orderTestSuccessMainPage() throws InterruptedException {
        MainPage main =new MainPage(driver);

        main.open();
        main.acceptCookies();

        FirstFormPage firstFormPage = main.pressHeaderOrderButton();
        firstFormPage.typeFirstName(this.firstName);
        firstFormPage.typeSecondName(this.secondName);
        firstFormPage.typeAddress(this.address);
        firstFormPage.chooseStation(this.station);
        firstFormPage.printPhone(this.phone);

        SecondFormPage secondFormPage = firstFormPage.clickNextButton();

        secondFormPage.pickDeDate();
        secondFormPage.pickDaysOfRent();
        secondFormPage.pickColor();
        secondFormPage.pressOrder();
        secondFormPage.pressConfirm();
        String result = secondFormPage.getTextOfHeader();
        boolean hasSuccess = result.contains("Заказ оформлен");

        assertTrue(hasSuccess);
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }
}
