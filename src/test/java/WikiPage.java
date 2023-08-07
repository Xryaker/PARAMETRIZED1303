import data.Language;
import data.WikitestDATA;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.support.PageFactory;
import pages.WIKIPage;
import utilS.ScreenS;
import watchers.WikiPaggeWatcher;

import java.util.Arrays;
import java.util.Collection;
import java.util.ResourceBundle;

@RunWith(Parameterized.class)
@Epic("Allure examples")
@Feature("Junit 4 support")
public class WikiPage extends WikitestDATA {

    @Parameterized.Parameters
    public static Collection options() {
        return Arrays.asList(Language.values());
    }

    public WikiPage(Language lang) {
        wikibundle = ResourceBundle.getBundle(lang.getLang());
        if (!driver.getCurrentUrl().contains("https://" + wikibundle.getString("language") + ".wikipedia.org")) {
            driver.get("https://" + wikibundle.getString("language") + ".wikipedia.org");
            wiki = PageFactory.initElements(driver, WIKIPage.class);
        }
    }


    @Test
    @Story("Base support for bdd annotations")
    @Story("Advanced support for bdd annotations")
    public void testTab1() {
        ScreenS.takeScreenShot( "dd");
        Assert.assertEquals(wikibundle.getString("tab1"), wiki.tab1Test());

    }

    @Test
    public void testTab2() {
        Assert.assertEquals(wikibundle.getString("tab2"), wiki.tab2Test());
    }

    @Test
    public void testTab3() {
        Assert.assertEquals(wikibundle.getString("tab3"), wiki.tab3Test());
    }
}
