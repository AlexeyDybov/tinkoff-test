package qa.listeners;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import qa.driver.WebDriverFactory;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.junit.AllureRunListener;
import ru.yandex.qatools.ashot.AShot;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author Alexey Dybov
 * @created 23.08.17
 */
public class TestListener extends AllureRunListener {

    private Logger LOGGER = LoggerFactory.getLogger(TestListener.class);
    private ThreadLocal<Boolean> failed = new ThreadLocal<>();

    private static final String TEST_STARTED_HEADING =
        "\n" +
            " _____          _         _             _           _ \n" +
            "/__   \\___  ___| |_   ___| |_ __ _ _ __| |_ ___  __| |\n" +
            "  / /\\/ _ \\/ __| __| / __| __/ _` | '__| __/ _ \\/ _` |\n" +
            " / / |  __/\\__ \\ |_  \\__ \\ || (_| | |  | ||  __/ (_| |\n" +
            " \\/   \\___||___/\\__| |___/\\__\\__,_|_|   \\__\\___|\\__,_|\n" +
            "                                                      \n.";

    private static final String TEST_PASSED_HEADING =
        "\n" +
            " _____          _                                  _ \n" +
            "/__   \\___  ___| |_   _ __   __ _ ___ ___  ___  __| |\n" +
            "  / /\\/ _ \\/ __| __| | '_ \\ / _` / __/ __|/ _ \\/ _` |\n" +
            " / / |  __/\\__ \\ |_  | |_) | (_| \\__ \\__ \\  __/ (_| |\n" +
            " \\/   \\___||___/\\__| | .__/ \\__,_|___/___/\\___|\\__,_|\n" +
            "                     |_|                             \n.";

    private static final String TEST_FAILED_HEADING =
        "\n" +
            " _____          _      __       _ _          _ \n" +
            "/__   \\___  ___| |_   / _| __ _(_) | ___  __| |\n" +
            "  / /\\/ _ \\/ __| __| | |_ / _` | | |/ _ \\/ _` |\n" +
            " / / |  __/\\__ \\ |_  |  _| (_| | | |  __/ (_| |\n" +
            " \\/   \\___||___/\\__| |_|  \\__,_|_|_|\\___|\\__,_|\n" +
            "                                               \n.";

    public void testRunStarted(Description description) throws Exception {
        super.testRunStarted(description);
    }

    public void testRunFinished(Result result) {
        super.testRunFinished(result);
    }

    public void testStarted(Description description) {
        super.testStarted(description);
        failed.set(false);
        LOGGER.info(TEST_STARTED_HEADING);
    }

    public void testFinished(Description description) {
        super.testFinished(description);
        if (failed.get()) LOGGER.info(TEST_FAILED_HEADING);
        else LOGGER.info(TEST_PASSED_HEADING);
    }

    public void testFailure(Failure failure) {
        super.testFailure(failure);
        failScreenshot();
        failed.set(true);
    }

    public void testAssumptionFailure(Failure failure) {
        super.testAssumptionFailure(failure);
        failScreenshot();
        failed.set(true);
    }

    @Attachment
    private byte[] failScreenshot() {
        BufferedImage image = new AShot().takeScreenshot(WebDriverFactory.getDriverInstance()).getImage();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, "png", baos);
        } catch (IOException e) {
            LOGGER.error("Error when take screenshot", e);
        }
        return baos.toByteArray();
    }
}
