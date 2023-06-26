package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CertificatePag {
    @FindBy(name = "certificate")
    WebElement searchField;
    @FindBy(id = "certificateCheckForm")
    WebElement formCert;

    public CertificatePag(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    WebDriver driver;


    public void sendCertificate(String certNumber) {
        searchField.sendKeys(certNumber);
        searchField.sendKeys(Keys.ENTER);
    }

    public Boolean validationCertificate() throws Exception {
        boolean result = false;
        int i = 0;
        while (true) {
            if (driver.getCurrentUrl().contains("view")) {
                result = true;
                break;
            }
            if (formCert.getAttribute("class").contains("invalid")) {
                result = false;
                break;
            }
            Thread.sleep(1000);
            i++;
            if (i > 10) {
                throw new Exception("Out of time wait certif");
            }
        }
        return result;
    }
}
