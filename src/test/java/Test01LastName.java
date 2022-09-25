import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


public class Test01LastName extends Test00Base {

    @Test
    @Epic("Last Name Field")
    @Feature("Character Validation")
    @Story("EMPTY")
    //@ParameterizedTest(name = "CYTC_00 - Vezetéknév hosszúság EMPTY {0}")
    @Description("Üres Vezetéknév mező validálása")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("CYTC_00")
    public void testLastNameFieldEmpty(){
            //PAGEFACTORY
        FormPage formPage = (FormPage) PageFactory.Create("FormPage", driver);

            //TEST
        driver.findElement(formPage.lastNameField).sendKeys("Béla");
        driver.findElement(formPage.nextButton).click();

    //

        //ASSERT



    }

}
