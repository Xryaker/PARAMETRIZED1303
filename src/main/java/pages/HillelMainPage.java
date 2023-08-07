package pages;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilS.ScreenS;

import java.util.ArrayList;
import java.util.List;

public class HillelMainPage {
    @FindBy(xpath = "//button[@data-dropdown-trigger=\"coursesMenu\"]")
    WebElement courseButton;
    @FindBy(xpath = "//div[@id=\"coursesMenuSearchField\"]//input[@class=\"search-field_input\"]")
    WebElement searchField;
    @FindBy(xpath = "//div[@id=\"coursesMenuDesktop\"]//div[@class=\"courses-nav \"]//ul[@class=\"course-list\"]//p[@class=\"course-label_name\"]")
    List<WebElement> lableNames;

    @Step("Open Course Frame")
    public void openCourseFrame() {
        courseButton.click();
    }

    @Step("Search step : {searchVariable}")
    public List<String> getVariablesSearch(String searchVariable) throws InterruptedException {
        List<String> list = new ArrayList<>();
        searchField.clear();
        searchField.sendKeys(searchVariable);
        Thread.sleep(4000);
        for (WebElement l : lableNames) {
            list.add(l.getText());
        }
        atachResult(list);

        Allure.addAttachment("My attachment", "My attachment content");

        return list;
    }

    @Attachment
    public String atachResult(List<String> list) {
        System.out.println(list);
        return list.toString();
    }
}
