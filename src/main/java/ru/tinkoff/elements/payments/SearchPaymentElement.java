package ru.tinkoff.elements.payments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.abstracts.Pages;

public class SearchPaymentElement extends Pages {

    @FindBy(xpath = "//div[./label/*[text()='Что оплатить или куда перевести?']]")
    private WebElement paymentSearchBlock;

    public SearchPaymentElement(WebDriver driver) {
        super(driver);
    }

    public boolean isPresent() {
        return waitForElementPresent(paymentSearchBlock);
    }
}
