package ru.tinkoff.pages.payments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.abstracts.Pages;
import qa.annotations.At;
import ru.tinkoff.data.payments.PaymentField;
import ru.tinkoff.data.payments.categories.Payment;

@At("%s")
public class ExtraPaymentPage extends Pages {

    @FindBy(xpath = "//*[@class='ui-page-frame']")
    private WebElement page;
    @FindBy(css = ".ui-button_provider-pay")
    private WebElement payButton;
    private String payTabSelector = "[href='/%s/oplata/'";
    private String payFieldLocator = "//*[@class='ui-page-frame']//*[contains(@class,'ui-form__field')][.//*[@id='%s']]";
    private String payFieldErrorLocator = payFieldLocator + "/div[contains(@class,'input_error')]";
    private String payFieldErrorTextLocator = payFieldLocator + "/div[contains(@class,'error-message')]";

    public ExtraPaymentPage(WebDriver driver) {
        super(driver);
    }

    public boolean isExtraPageOpened() {
        return waitForElementPresent(page);
    }

    public void selectPayTab(Payment payment) {
        element(By.cssSelector(String.format(payTabSelector, payment.getLinkName()))).click();
    }

    public boolean isPayFormPresent() {
        return waitForElementPresent(payButton);
    }

    public boolean isPayTabPresent(Payment payment) {
        return waitForElementPresent(By.cssSelector(String.format(payTabSelector, payment.getLinkName())));
    }


    public void setField(PaymentField field, String fieldValue) {
        element(By.id(field.name())).sendKeys(fieldValue + Keys.TAB);
    }

    public boolean isErrorPresent(PaymentField field) {
        String locator = String.format(payFieldErrorLocator, field.name());
        return waitForElementPresent(By.xpath(locator));
    }

    public String getErrorText(PaymentField field) {
        String locator = String.format(payFieldErrorTextLocator, field.name());
        return element(By.xpath(locator)).getText();
    }
}
