package ru.tinkoff.pages.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import qa.abstracts.Pages;
import ru.tinkoff.data.MainMenuItem;

public class MainPage extends Pages {

    private String menu = "#mainMenu";
    private String field = menu + ">li:not([id]) [href*=%s]";

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void clickMenuItem(MainMenuItem item) {
        element(By.cssSelector(String.format(field, item.name()))).click();
    }

    public boolean isOpened() {
        return waitForElementPresent(By.cssSelector(menu));
    }
}
