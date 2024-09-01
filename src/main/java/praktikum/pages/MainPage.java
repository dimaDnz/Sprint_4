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
    private By mainOrderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_UltraBig__UU3Lp']");

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

    public boolean hasAccordion(String locator){
        String heading = String.format("accordion__heading-%s", locator);
        WebElement accordionHeader = driver.findElement(By.id(heading));

        //print accordion header text
        String accordionHeaderText = accordionHeader.getText();
        System.out.println("Текст заголовка аккордеона: \""+ accordionHeaderText + "\"");

        //scroll to element
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", accordionHeader);

        //click on element
        accordionHeader.click();

        String panel = String.format("accordion__panel-%s",locator);
        WebElement accordionPanel = driver.findElement(By.id(panel));

        //print accordeon panel text
        String accordionPanelText = accordionPanel.getText();
        System.out.println("Текст панели аккордеона: \""+accordionPanelText+"\"");

        return accordionPanel.isDisplayed();
    }

}
