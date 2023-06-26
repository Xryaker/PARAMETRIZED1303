import configuratio.BaseClass;
import data.DataProvider;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.support.PageFactory;
import pages.CertificatePag;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CertificatetTEST extends BaseClass {
    final String url="https://certificate.ithillel.ua/";
    String certNumber;
    CertificatePag certificatePage;


    @Parameterized.Parameters
    public static Collection options() {
        return DataProvider.getNoValidCerts();
    }

    public CertificatetTEST(String certNumber) {
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
