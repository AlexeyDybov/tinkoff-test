package ru.tinkoff.pages.payments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import qa.abstracts.Pages;
import ru.tinkoff.data.Region;
import ru.tinkoff.data.payments.PaymentCategory;
import ru.tinkoff.data.payments.categories.Payment;

public class PaymentsCategoryPage extends Pages {

    private String paymentPage = "//div[contains(text(),'%s')]";
    private String regionLocator = "//*[contains(@class,'payment-page__title_inner')][text()='%s']";
    private String paymentSelector = "[href*='%s']";

    public PaymentsCategoryPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened(PaymentCategory paymentCategory) {
        return waitForElementPresent(By.xpath(String.format(paymentPage, paymentCategory.getName())));
    }

    public boolean isRegionSelected(Region region) {
        return waitForElementPresent(By.xpath(String.format(regionLocator, region.getDeclensionName())));
    }

    public void openPayment(Payment payment) {
        element(By.cssSelector(String.format(paymentSelector, payment.getLinkName()))).click();
    }
}
