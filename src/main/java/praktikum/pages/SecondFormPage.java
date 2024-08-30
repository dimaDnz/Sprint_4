package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SecondFormPage {
    final WebDriver driver;
    public SecondFormPage(WebDriver driver) {
        this.driver=driver;
    }

    //TODO - локаторы
    private static final By DATE_OF_ORDER_CLICK = By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/div/div/input");
    private static final By DATE_OF_ORDER_SELECT = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div[4]");
    private static final By DAYS_OF_RENT_CLICK = By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div[1]/div[1]");
    private static final By DAYS_OF_RENT_SELECT = By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div[2]/div[4]");
    private static final By PICK_DE_COLOR = By.xpath("/html/body/div/div/div[2]/div[2]/div[3]/label[1]/input");

    private static final By ORDER_BUTTON = By.xpath(".//div[starts-with(@class, 'Order_Buttons')]/button[not(contains(@class,'Button_Inverted'))]");
    private static final By CONFIRM_BUTTON = By.xpath(".//div[starts-with(@class, 'Order_Modal')]//button[not(contains(@class,'Button_Inverted'))]");
    private static final By HEADER_OF_SUCCESS = By.xpath(".//div[starts-with(@class, 'Order_Modal')]//div[(starts-with(@class,'Order_ModalHeader'))]");

    public void pickDeDate() throws InterruptedException {

        driver.findElement(DATE_OF_ORDER_CLICK).click();
        driver.findElement(DATE_OF_ORDER_SELECT).click();
    }

    public void pickDaysOfRent(){
        driver.findElement(DAYS_OF_RENT_CLICK).click();
        driver.findElement(DAYS_OF_RENT_SELECT).click();
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

    public String getTextOfHeader() throws InterruptedException {
//        Thread.sleep(500);
        WebElement headerOfSuccessForm = driver.findElement(HEADER_OF_SUCCESS);
        return headerOfSuccessForm.getText();
    }
}
