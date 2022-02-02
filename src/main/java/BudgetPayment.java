import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.Keys.ENTER;

public class BudgetPayment {
    /** Ввести сумму **/
    public static void typeSum(String amount){
        WebElement sumField = Login.driver.findElement(By.cssSelector("input[name=\"amount\"]"));
        sumField.sendKeys(amount);
    }

    /** Выбрать плательщика **/
    public static void selectPayer(){
        WebElement payerField = Login.driver.findElement(By.cssSelector("input[aria-activedescendant=\"react-select-5--value\"]"));
        payerField.sendKeys(ENTER);
    }

    /** Создать получателя **/
    public static void createPayee(){
        WebElement createPayeeButton = Login.driver.findElement(By.xpath("//button[text()='Создать нового']"));
        createPayeeButton.click();
        WebElement payeeNameField = Login.driver.findElement(By.cssSelector("input[placeholder='Наименование контрагента']"));
        payeeNameField.sendKeys("Бюджет");
        WebElement innField = Login.driver.findElement(By.cssSelector("input[placeholder='Введите ИНН или КИО']"));
        innField.sendKeys("7806000792");
        WebElement kppField = Login.driver.findElement(By.cssSelector("input[placeholder='Введите КПП']"));
        kppField.sendKeys("780601001");
        WebElement accountNumberField = Login.driver.findElement(By.cssSelector("input[name='accountNumber']"));
        accountNumberField.sendKeys("40101810523456789101");
        WebElement bicField = Login.driver.findElement(By.cssSelector("input[placeholder='Введите несколько цифр']"));
        bicField.sendKeys("041946000");
        WebElement submitButton = Login.driver.findElement(By.xpath("//button[text()='Добавить']"));
        new WebDriverWait(Login.driver, Duration.ofSeconds(5)).
                until(ExpectedConditions.elementToBeClickable(submitButton));
        submitButton.click();
    }

    /** Выбрать статус плательщика **/
    public static void selectPayerStatus(){
        WebElement payerStatusField = Login.driver.findElement(By.xpath("//span[text() = 'Выберите значение']"));
        payerStatusField.click();
        WebElement payerStatusOption = Login.driver.findElement(By.cssSelector("div[title*='01 - налогоплательщик']"));
        payerStatusOption.click();
    }

    /** Ввести КБК **/
    public static void typeKbk(String kbk){
        WebElement kbkField = Login.driver.findElement(By.cssSelector("input[placeholder='Введите значение КБК']"));
        kbkField.sendKeys(kbk);
    }

    /** Ввести ОКТМО **/
    public static void typeOktmo(String oktmo){
        WebElement kbkField = Login.driver.findElement(By.cssSelector("input[placeholder='Введите значение ОКТМО']"));
        kbkField.sendKeys(oktmo);
    }

    /** Выбрать основание платежа **/
    public static void selectPaymentReason(String paymentReason){
        WebElement paymentReasonField = Login.driver.findElement(By.cssSelector("input[aria-activedescendant='react-select-6--value']"));
        paymentReasonField.sendKeys(paymentReason + ENTER);
    }

    /** Выбрать налоговый период **/
    public static void selectTaxPeriod(){
        WebElement taxPeriodList = Login.driver.findElement(By.cssSelector("div[data-test-id='TaxPeriod__period--selectDropDown']"));
        taxPeriodList.click();
        WebElement taxPeriodOption = Login.driver.findElement(By.cssSelector("div[title='0 - не определено']"));
        taxPeriodOption.click();
    }

    /** Ввести номер документа **/
    public static void typeTaxDocNumber(String taxDocNumber){
        WebElement docNumberField = Login.driver.findElement(By.cssSelector("input[placeholder='Введите номер документа']"));
        docNumberField.sendKeys(taxDocNumber);
    }

    /** Указать дату **/
    public static void selectDate(){
        WebElement dateRadioButton = Login.driver.findElement(By.cssSelector("label[for='id-4-16']"));
        dateRadioButton.click();
    }

    /** Ввести УИН **/
    public static void typeUin(String uin){
        WebElement uinField = Login.driver.findElement(By.cssSelector("input[placeholder='УИН']"));
        uinField.sendKeys(uin);
    }

    /** Нажать на кнопку "Создать" **/
    public static void clickCreateButton(){
        WebElement createPaymentButton = Login.driver.findElement(By.cssSelector("button[data-analytics-label=\"Action.CREATE\"]"));
        createPaymentButton.click();
    }

    /** Нажать на кнопку "Всё равно сохранить" **/
    public static void clickSaveButton(){
        WebElement saveButton = Login.driver.findElement(By.xpath("//button[text()='Всё равно сохранить']"));
        saveButton.click();
    }

    /** Создать платёж в бюджет **/
    public static void createBudgetPayment(String amount, String kbk, String oktmo, String paymentReason, String taxDocNumber, String uin){
        typeSum(amount);
        selectPayer();
        createPayee();
        selectPayerStatus();
        typeKbk(kbk);
        typeOktmo(oktmo);
        selectPaymentReason(paymentReason);
        selectTaxPeriod();
        typeTaxDocNumber(taxDocNumber);
        selectDate();
        typeUin(uin);
        clickCreateButton();
        clickSaveButton();
    }
}
