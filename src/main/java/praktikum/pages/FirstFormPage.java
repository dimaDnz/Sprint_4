package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import praktikum.EnvConfig;

import java.time.Duration;

public class FirstFormPage {
    final WebDriver driver;

    public FirstFormPage(WebDriver driver) {
        this.driver=driver;
    }

    private static final By firstName = By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/input");
    private static final By secondName = By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/input");
    private static final By address = By.xpath("/html/body/div/div/div[2]/div[2]/div[3]/input");
    private static final By metroSelector = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/div/div[1]/input");
    private static final By selectStation = By.xpath("/html/body/div/div/div[2]/div[2]/div[4]/div/div[2]/ul/li[6]/button");
    private static final By phone = By.xpath("/html/body/div/div/div[2]/div[2]/div[5]/input");
    private static final By nextButton = By.xpath("/html/body/div/div/div[2]/div[3]/button");



    public void typeFirstName(String fName) throws InterruptedException {
        Thread.sleep(500);
        driver.findElement(firstName).sendKeys(fName);
    }

    public void typeSecondName(String sName){
        driver.findElement(secondName).sendKeys(sName);
    }

    public void typeAddress(String myAddress){
        driver.findElement(address).sendKeys(myAddress);
    }

    public void chooseStation(){
        driver.findElement(metroSelector).click();
        driver.findElement(selectStation).click();
    }

    public void printPhone(String userPhone){
        driver.findElement(phone).sendKeys(userPhone);

    }

    public SecondFormPage clickNextButton(){
        driver.findElement(nextButton).click();
        return new SecondFormPage(driver);
    }

}
