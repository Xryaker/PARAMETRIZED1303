import configuratio.BaseClass;
import io.qameta.allure.*;
import jdk.jfr.Description;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.support.PageFactory;
import pages.HillelMainPage;
import watchers.WikiPaggeWatcher;

import java.util.*;

@Feature("Search")
@RunWith(Parameterized.class)

public class MainPageTest extends BaseClass {
    public static HillelMainPage hillelMainPage;
    List<String> list;
    String search;
    @Rule
    public WikiPaggeWatcher watcher = new WikiPaggeWatcher();

    @Parameterized.Parameters
    public static Object[][] options() {
        return new Object[][]{
                {"QA", Arrays.asList("QA Manual", "QA Automation — Java", "QA Technical Pro")},
                {"DevOps", Arrays.asList("DevOps", "Project Management", "Full-Stack — PHP")}};
    }

    public MainPageTest(String serch, List<String> list) {
        this.list = list;
        this.search = serch;
    }

    @BeforeClass
    public static void before() {
        driver.get("https://dnipro.ithillel.ua/");
        hillelMainPage = PageFactory.initElements(driver, HillelMainPage.class);
        hillelMainPage.openCourseFrame();
    }

    @Test
    @Description("Test search field")
    @Story("Main")
    @Link(name = "HILLEL", type = "hillel")
    @Severity(SeverityLevel.CRITICAL)
    public void test1() throws InterruptedException {
        List<String> stringList = hillelMainPage.getVariablesSearch(search);
        Assert.assertEquals(stringList, list);

    }

    @Test
    @Severity(SeverityLevel.MINOR)
    public void test() {
        System.out.println("hellow");
    }
}
