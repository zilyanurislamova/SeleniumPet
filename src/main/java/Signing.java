import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.*;

public class Signing {
    /** Нажать кнопку "Получить СМС-код" **/
    public void clickSignButton(){
        WebElement signButton = Login.driver.findElement(By.cssSelector("button[data-analytics-label='action.get_sms_code']"));
        signButton.click();
    }

    /** Ввести код **/
    public void typeCode(String code){
        WebElement codeField = new WebDriverWait(Login.driver, Duration.ofSeconds(5)).
                until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[placeholder='Введите код']")));
        codeField.sendKeys(code);
    }

    /** Нажать на стрелку вправо **/
    public void clickArrowButton(){
        WebElement arrowButton = new WebDriverWait(Login.driver, Duration.ofSeconds(3)).
                until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btnSubmit__qDMKQg svg")));
        arrowButton.click();
    }

    /** Подписать платёжку  **/
    public static void signPayment(Signing createdPayment, String code){
        createdPayment.clickSignButton();
        createdPayment.typeCode(code);
        createdPayment.clickArrowButton();
    }
}