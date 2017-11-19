package ru.tinkoff.steps.main;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import qa.abstracts.Steps;
import ru.tinkoff.data.MainMenuItem;
import ru.tinkoff.pages.main.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MainSteps extends Steps {

    private MainPage mainPage;

    public MainSteps(WebDriver driver) {
        super(driver);
        mainPage = PageFactory.initElements(driver, MainPage.class);
    }

    @Step
    public void openPage() {
        mainPage.openAt();
        mainPageShouldBeOpened();
    }

    @Step
    public void mainPageShouldBeOpened() {
        Assert.assertTrue("Не открылась главная страница", mainPage.isOpened());
    }

    @Step
    public void clickMenuItem(MainMenuItem item) {
        mainPage.clickMenuItem(item);
    }
}
