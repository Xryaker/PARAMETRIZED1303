import configuratio.BaseClass;
import data.DataProvider;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.support.PageFactory;
import pages.CertificatePag;
import watchers.WikiPaggeWatcher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public final class Certificatet extends BaseClass {

    final String url="https://certificate.ithillel.ua/";
    String certNumber;
    CertificatePag certificatePage;


    @Parameterized.Parameters
    public static Collection options() {
        return Arrays.stream(new String[]{
                "USD",
                "AUD"}).toList();
    }

    public Certificatet(String certNumber) {
        this.certNumber = certNumber;
        driver.get(url);
        certificatePage= PageFactory.initElements(driver, CertificatePag.class);
    }

    @Test
    public void testCert() throws Exception {
        certificatePage.sendCertificate(certNumber);
        Assert.assertEquals(false,certificatePage.validationCertificate());
    }

}
