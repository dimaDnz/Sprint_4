package praktikum.pages;

import org.openqa.selenium.By;
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

    private static final By dateOfOrderClick = By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/div/div/input");
    private static final By dateOfOrderSelect = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div[4]");
    private static final By daysOfRentClick = By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div[1]/div[1]");
    private static final By daysOfRentSelect = By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div[2]/div[4]");
    private static final By pickDeColor = By.xpath("/html/body/div/div/div[2]/div[2]/div[3]/label[1]/input");
    private static final By orderButton = By.xpath("/html/body/div/div/div[2]/div[3]/button[2]");
    private static final By confirmButton = By.xpath("/html/body/div/div/div[2]/div[5]/div[2]/button[2]");

    private static final By headerOfSuccess = By.xpath("/html/body/div/div/div[2]/div[5]/div[1]");

    public void pickDeDate() throws InterruptedException {
        Thread.sleep(500);
        driver.findElement(dateOfOrderClick).click();
        driver.findElement(dateOfOrderSelect).click();
    }

    public void pickDaysOfRent(){
        driver.findElement(daysOfRentClick).click();
        driver.findElement(daysOfRentSelect).click();
    }

    public void pickColor(){
        driver.findElement(pickDeColor).click();
    }

    public void pressOrder(){
        driver.findElement(orderButton).click();
    }

    public void pressConfirm(){
        driver.findElement(confirmButton).click();
    }

    public String getTextOfHeader() throws InterruptedException {
        Thread.sleep(500);
        WebElement headerOfSuccessForm = driver.findElement(headerOfSuccess);
        return headerOfSuccessForm.getText();
    }
}
