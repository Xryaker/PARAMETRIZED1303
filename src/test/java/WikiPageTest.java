import data.Language;
import data.WikitestDATA;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.support.PageFactory;
import pages.WIKIPage;

import java.util.Arrays;
import java.util.Collection;
import java.util.ResourceBundle;

@RunWith(Parameterized.class)
public class WikiPageTest extends WikitestDATA {

    @Parameterized.Parameters
    public static Collection options() {
        return Arrays.asList(Language.values());
    }

    public WikiPageTest(Language lang) {
        wikibundle= ResourceBundle.getBundle(lang.getLang());
        if(!driver.getCurrentUrl().contains("https://"+wikibundle.getString("language")+".wikipedia.org")){
            driver.get("https://"+wikibundle.getString("language")+".wikipedia.org");
            wiki= PageFactory.initElements(driver, WIKIPage.class);
        }
    }

    @Test
    public void testTab1() {
        Assert.assertEquals(wikibundle.getString("tab1"),wiki.tab1Test());
    }

    @Test
    public void testTab2() {
        Assert.assertEquals(wikibundle.getString("tab2"),wiki.tab2Test());
    }

    @Test
    public void testTab3() {
        Assert.assertEquals(wikibundle.getString("tab3"),wiki.tab3Test());
    }
}
