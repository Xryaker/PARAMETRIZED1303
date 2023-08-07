package configuratio;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class DriverFactory {
    public static WebDriver greateDriver(WEBDRIVERS webdrivers) {
        WebDriver driver = null;
        switch (webdrivers) {
            case CHROMECLEAN:
                driver = createCleanChrome();
                break;
            case EDGEDRIVER:
                driver = createEdge();
                break;
        }
        return driver;
    }

    private static WebDriver createEdge() {
        return new EdgeDriver();
    }

    private static WebDriver createCleanChrome() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }
}
