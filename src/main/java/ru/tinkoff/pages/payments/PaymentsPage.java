package ru.tinkoff.pages.payments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import qa.abstracts.Pages;
import ru.tinkoff.data.payments.PaymentCategory;
import ru.tinkoff.data.payments.PaymentField;
import ru.tinkoff.elements.payments.Card2CardPaymentElement;
import ru.tinkoff.elements.payments.SearchPaymentElement;

public class PaymentsPage extends Pages {

    private String paymentSelector = "[href*='%s']";

    @FindBy(xpath = "//div[contains(text(),'Платежи')]")
    private WebElement paymentPage;

    private SearchPaymentElement searchPaymentBlock;
    private Card2CardPaymentElement card2CardPaymentElement;

    public PaymentsPage(WebDriver driver) {
        super(driver);
        searchPaymentBlock = PageFactory.initElements(driver, SearchPaymentElement.class);
        card2CardPaymentElement = PageFactory.initElements(driver, Card2CardPaymentElement.class);
    }

    public void selectPaymentCategory(PaymentCategory paymentCategory) {
        element(By.cssSelector(String.format(paymentSelector, paymentCategory.getLinkName()))).click();
    }

    public boolean isOpened() {
        return waitForElementPresent(paymentPage);
    }

}
