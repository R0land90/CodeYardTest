import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.io.IOException;


public class Test01LastName extends Test00Base {



    @Test
    @Epic("Last Name Field")
    @Feature("Character Validation")
    @Story("EMPTY")
    @Description("Üres Vezetéknév mező validálása")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("CYTC_00")
    public void testLastNameFieldEmpty(){
            //PAGEFACTORY
        FormPage formPage = (FormPage) PageFactory.Create("FormPage", driver);
        Tools tools = (Tools) PageFactory.Create("Tools", driver);

            //TEST

        driver.findElement(formPage.nextButton).click();

            //ASSERT

        Boolean result = tools.isCssPresent(driver.findElement(formPage.lastNameField),"caret-color");

        takeScreenShot("AFTER NEXT BUTTON");

        Boolean expectedErrorMessage = true;
        Assertions.assertEquals(expectedErrorMessage,result);
    }

    @Test
    @Epic("Last Name Field")
    @Feature("Character Validation")
    @Story("NUMBER")
    @Description("Vezetéknév mező szám típusú karakter elfogadásának ellenőrzése")
    @Severity(SeverityLevel.NORMAL)
    @Tag("CYTC_03")
    @Issue("BUG_01")
    public void testLastNameFieldNumber() throws IOException, InterruptedException {
            //PAGEFACTORY
        FormPage formPage = (FormPage) PageFactory.Create("FormPage", driver);
        Tools tools = (Tools) PageFactory.Create("Tools", driver);

            //TEST

        String testData = "4BCDEF";

        driver.findElement(formPage.lastNameField).sendKeys(testData);
        By[] elements ={
                formPage.firstNameField,
                formPage.emailField,
                formPage.userNameField,
                formPage.passwordField,
                formPage.passwordRepeatField,
                formPage.birthPlaceField};
        String[] dataSelector = {
                "fName",
                "email",
                "uName",
                "password",
                "passwordRep",
                "birthPlace"};

        tools.dataFiller(elements,dataSelector);
        driver.findElement(formPage.nextButton).click();

            //ASSERT

        Thread.sleep(1000);

        //Hibaüzenet megjelenésének ellenőrzése
        if(driver.findElements(formPage.lastNameField).size()>0){
            Boolean result = tools.isCssPresent(driver.findElement(formPage.lastNameField),"caret-color");
            Boolean expectedErrorMessage = true;
            Assertions.assertEquals(expectedErrorMessage,result);
        }
        //Oldal továbblépésének ellenőrzése
        String expectedURL = "https://test.codeyard.eu/";
        Assertions.assertEquals(expectedURL,driver.getCurrentUrl());

        takeScreenShot("Az oldal továbblépett és elfogadta a számot");
    }

    @Test
    @Epic("First Name Field")
    @Feature("Character Long Validation")
    @Story("MAX CHARACTER +1")
    @Description("\"Keresztnév mező maximális karakter hossz ellenőrzése. \n" +
            "Maximálisan megengedett 32 karakter.\n" +
            "Tesztelés 33 karakterrel.\"")
    @Severity(SeverityLevel.NORMAL)
    @Tag("CYTC_11")
    @Issue("BUG_03")
    public void testFirstNameFieldMaxChar1() throws IOException, InterruptedException {
            //PAGEFACTORY
        FormPage formPage = (FormPage) PageFactory.Create("FormPage", driver);
        Tools tools = (Tools) PageFactory.Create("Tools", driver);

            //TEST

        String testData = "ABCDEFGHIKLMNOPQRSTVXYZABCDEFGHIA";

        driver.findElement(formPage.firstNameField).sendKeys(testData);

        By[] elements ={
                formPage.lastNameField,
                formPage.emailField,
                formPage.userNameField,
                formPage.passwordField,
                formPage.passwordRepeatField,
                formPage.birthPlaceField};
        String[] dataSelector = {
                "lName",
                "email",
                "uName",
                "password",
                "passwordRep",
                "birthPlace"};

        tools.dataFiller(elements,dataSelector);
        driver.findElement(formPage.nextButton).click();

            //ASSERT

        Thread.sleep(1000);

        //Hibaüzenet megjelenésének ellenőrzése
        if(driver.findElements(formPage.firstNameField).size()>0){
            Boolean result = tools.isCssPresent(driver.findElement(formPage.firstNameField),"caret-color");
            Boolean expectedErrorMessage = true;
            Assertions.assertEquals(expectedErrorMessage,result);
        }
        //Oldal továbblépésének ellenőrzése
        String expectedURL = "https://test.codeyard.eu/";
        Assertions.assertEquals(expectedURL,driver.getCurrentUrl());

        takeScreenShot("Az oldal továbblépett és elfogadta a specifikáltnál hosszabb karakterláncot");
    }

    @Test
    @Epic("Email Field")
    @Feature("Email address validation")
    @Story("Missing @ char")
    @Description("Az email címben @ szimbólum validációja")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("CYTC_21")
    @Issue("BUG_10")
    public void testEmailFieldMissingAt() throws IOException, InterruptedException {
            //PAGEFACTORY
        FormPage formPage = (FormPage) PageFactory.Create("FormPage", driver);
        Tools tools = (Tools) PageFactory.Create("Tools", driver);

            //TEST

        String testData = "tesztemail.hu";

        driver.findElement(formPage.emailField).sendKeys(testData);

        By[] elements ={
                formPage.lastNameField,
                formPage.firstNameField,
                formPage.userNameField,
                formPage.passwordField,
                formPage.passwordRepeatField,
                formPage.birthPlaceField};
        String[] dataSelector = {
                "lName",
                "fName",
                "uName",
                "password",
                "passwordRep",
                "birthPlace"};

        tools.dataFiller(elements,dataSelector);
        driver.findElement(formPage.nextButton).click();

            //ASSERT

        Thread.sleep(1000);

        //Hibaüzenet megjelenésének ellenőrzése
        if(driver.findElements(formPage.emailField).size()>0){
            Boolean result = tools.isCssPresent(driver.findElement(formPage.emailField),"caret-color");
            Boolean expectedErrorMessage = true;
            Assertions.assertEquals(expectedErrorMessage,result);
        }
        //Oldal továbblépésének ellenőrzése
        String expectedURL = "https://test.codeyard.eu/";
        Assertions.assertEquals(expectedURL,driver.getCurrentUrl());

        takeScreenShot("Az oldal továbblépett és elfogadta a hibát tartalmazó tesztadatot");
    }

}
