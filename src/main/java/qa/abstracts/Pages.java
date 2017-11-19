package qa.abstracts;

import org.apache.http.client.utils.URIBuilder;
import org.openqa.selenium.WebDriver;
import qa.annotations.At;

import java.net.URISyntaxException;

/**
 * Общий класс страниц, общие методы
 * Created by Alexey Dybov on 27.10.16.
 */
public class Pages extends AbstractPage {

    public Pages(WebDriver driver) {
        super(driver);
    }

    public void openAt(String... params) {
        String path = "";
        if (this.getClass().isAnnotationPresent(At.class)) {
            path = String.format(this.getClass().getAnnotation(At.class).value(), params);
        }
        openUrl(path);
    }

    private void openUrl(String path) {
        String pageUrl;
        String baseUrl = System.getProperty("webdriver.base.url");
        try {
            URIBuilder pageUrlBuilder = new URIBuilder(baseUrl);
            pageUrlBuilder.setPath(path);
            pageUrl = pageUrlBuilder.build().toString();
        } catch (URISyntaxException e) {
            throw new Error("Incorrect Url to open");
        }
        driver.get(pageUrl);
    }
}
