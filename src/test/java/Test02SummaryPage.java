import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Test02SummaryPage extends Test00Base {

    @Test
    @Epic("Last Name Field")
    @Feature("Summary page data validation")
    @Story("Last name data validation on Summary Page")
    @Description("Vezetéknév mezőbe beírt adat megjelenése az összegző felületen.")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("CYTC_47")
    @Issue("BUG_27")
    public void testLastNameOnSummary() throws IOException {
            //PAGEFACTORY
        FormPage formPage = (FormPage) PageFactory.Create("FormPage", driver);
        SummaryPage summaryPage = (SummaryPage) PageFactory.Create("SummaryPage", driver);
        Tools tools = (Tools) PageFactory.Create("Tools", driver);

            //TEST

        //Szükséges adatok kitöltése
        tools.requiredDataFiller();
        driver.findElement(formPage.nextButton).click();

            //ASSERT

        //Vezetéknév adat kinyerése
        String exceptData = tools.readJsonObject(PageBase.fillerDataFilePath).getString("lName");

        String actualData = driver.findElement(summaryPage.lastNameFieldSumm).getText();

        Assertions.assertEquals(exceptData,actualData);
    }

    @Test
    @Epic("First Name Field")
    @Feature("Summary page data validation")
    @Story("First name data validation on Summary Page")
    @Description("Keresztnév mezőbe beírt adat megjelenése az összegző felületen.")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("CYTC_48")
    @Issue("BUG_28")
    public void testFirstNameOnSummary() throws IOException {
        //PAGEFACTORY
        FormPage formPage = (FormPage) PageFactory.Create("FormPage", driver);
        SummaryPage summaryPage = (SummaryPage) PageFactory.Create("SummaryPage", driver);
        Tools tools = (Tools) PageFactory.Create("Tools", driver);

        //TEST

        //Szükséges adatok kitöltése
        tools.requiredDataFiller();
        driver.findElement(formPage.nextButton).click();

        //ASSERT

        //Vezetéknév adat kinyerése
        String exceptData = tools.readJsonObject(PageBase.fillerDataFilePath).getString("fName");

        String actualData = driver.findElement(summaryPage.firstNameFieldSumm).getText();

        Assertions.assertEquals(exceptData,actualData);
    }
}
