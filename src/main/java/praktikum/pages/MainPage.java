package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import praktikum.EnvConfig;

import java.time.Duration;

public class MainPage {
    final WebDriver driver;

    private By cookiesButton = By.className("App_CookieButton__3cvqF");
    private By headerOrderButton = By.xpath(".//button[@class='Button_Button__ra12g']");
    private By mainOrderButton = By.xpath("/html/body/div/div/div/div[4]/div[2]/div[5]/button");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage open() {
        driver.get(EnvConfig.BASE_URL);
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("Button_Button__ra12g")));
        return this;
    }

    public void acceptCookies(){
        driver.findElement(cookiesButton).click();
    }

    public FirstFormPage pressHeaderOrderButton(){
        driver.findElement(headerOrderButton).click();
        return new FirstFormPage(driver);
    }

    public FirstFormPage pressMainOrderButton(){
        WebElement orderButton = driver.findElement(mainOrderButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", orderButton);
        orderButton.click();
        return new FirstFormPage(driver);
    }

}
