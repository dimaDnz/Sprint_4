package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FirstFormPage {
    final WebDriver driver;

    public FirstFormPage(WebDriver driver) {
        this.driver=driver;
    }

    private static final By ORDER_FORM_HEADER = By.xpath(".//div[starts-with(@class, 'Order_Form')]");
    private static final By FIRST_NAME = By.xpath(".//div[starts-with(@class, 'Order_Form')]//input[contains(@placeholder,'Имя')]");
    private static final By SECOND_NAME = By.xpath(".//div[starts-with(@class, 'Order_Form')]//input[contains(@placeholder,'Фамилия')]");
    private static final By ADDRESS = By.xpath(".//div[starts-with(@class, 'Order_Form')]//input[contains(@placeholder,'Адрес')]");

    //СТАРЫЕ СЕЛЕКТОРЫ
    private static final By METRO_SELECTOR = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/div/div[1]/input");
    private static final By SELECT_STATION = By.xpath("/html/body/div/div/div[2]/div[2]/div[4]/div/div[2]/ul/li[6]/button");

    private static final By PHONE = By.xpath(".//div[starts-with(@class, 'Order_Form')]//input[contains(@placeholder,'Телефон')]");
    private static final By NEXT_BUTTON = By.xpath(".//div[starts-with(@class, 'Order_NextButton')]/button");


    public void orderFormWaiter(){
        new WebDriverWait(this.driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(this.driver.findElement(ORDER_FORM_HEADER)));
    }

    public void typeFirstName(String fName) throws InterruptedException {
        driver.findElement(FIRST_NAME).sendKeys(fName);
    }

    public void typeSecondName(String sName){
        driver.findElement(SECOND_NAME).sendKeys(sName);
    }

    public void typeAddress(String myAddress){
        driver.findElement(ADDRESS).sendKeys(myAddress);
    }

    public void chooseStation(){
        driver.findElement(METRO_SELECTOR).click();
        driver.findElement(SELECT_STATION).click();
    }

    public void printPhone(String userPhone){
        driver.findElement(PHONE).sendKeys(userPhone);

    }

    public SecondFormPage clickNextButton(){
        driver.findElement(NEXT_BUTTON).click();
        return new SecondFormPage(driver);
    }

}
