package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SecondFormPage {
    final WebDriver driver;

    public SecondFormPage(WebDriver driver) {
        this.driver=driver;
    }

    private static final By DATE_OF_ORDER_CLICK = By.cssSelector("input[placeholder='* Когда привезти самокат'");
    private static final By DATE_OF_ORDER_SELECT = By.className("react-datepicker__day--023");
    private static final By DAYS_OF_RENT_CLICK = By.className("Dropdown-placeholder");
    private static final By DAYS_OF_RENT_SELECT = By.className("Dropdown-option");
    private static final By PICK_DE_COLOR = By.xpath(".//input[@id='grey']");

    private static final By ORDER_BUTTON = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");
    private static final By CONFIRM_BUTTON = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");
    private static final By HEADER_OF_SUCCESS = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ' and text()='Заказ оформлен']");

    public void pickDeDate() throws InterruptedException {

        driver.findElement(DATE_OF_ORDER_CLICK).click();
        driver.findElement(DATE_OF_ORDER_SELECT).click();


    }
    //todo можно вкорячить параметризацию
    public void pickDaysOfRent(){
        driver.findElement(DAYS_OF_RENT_CLICK).click();
        driver.findElements(DAYS_OF_RENT_SELECT).get(0).click();
    }

    public void pickColor(){
        driver.findElement(PICK_DE_COLOR).click();
    }

    public void pressOrder(){
        driver.findElement(ORDER_BUTTON).click();
    }

    public void pressConfirm(){
        driver.findElement(CONFIRM_BUTTON).click();
    }

    public String getTextOfHeader() {
        new WebDriverWait(this.driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(this.driver.findElement(HEADER_OF_SUCCESS)));
        WebElement headerOfSuccessForm = driver.findElement(HEADER_OF_SUCCESS);
        return headerOfSuccessForm.getText();
    }
}
