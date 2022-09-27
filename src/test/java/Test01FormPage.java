import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import java.io.IOException;



public class Test01FormPage extends Test00Base {



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

        takeScreenShot("Az oldal továbblépett és elfogadta a számot");

        //Oldal továbblépésének ellenőrzése
        String expectedURL = "https://test.codeyard.eu/";
        Assertions.assertEquals(expectedURL,driver.getCurrentUrl());


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

        takeScreenShot("Az oldal továbblépett és elfogadta a specifikáltnál hosszabb karakterláncot");

        //Oldal továbblépésének ellenőrzése
        String expectedURL = "https://test.codeyard.eu/";
        Assertions.assertEquals(expectedURL,driver.getCurrentUrl());


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

        takeScreenShot("Az oldal továbblépett és elfogadta a hibát tartalmazó tesztadatot");

        //Oldal továbblépésének ellenőrzése
        String expectedURL = "https://test.codeyard.eu/";
        Assertions.assertEquals(expectedURL,driver.getCurrentUrl());


    }

    @Test
    @Epic("Email Field")
    @Feature("Email address validation")
    @Story("Missing . char")
    @Description("Az email címben . karakter validációja")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("CYTC_22")
    @Issue("BUG_11")
    public void testEmailFieldMissingDot() throws IOException, InterruptedException {
            //PAGEFACTORY
        FormPage formPage = (FormPage) PageFactory.Create("FormPage", driver);
        Tools tools = (Tools) PageFactory.Create("Tools", driver);

            //TEST

        String testData = "teszt@emailhu";

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

        takeScreenShot("Az oldal továbblépett és elfogadta a hibát tartalmazó tesztadatot");

        //Oldal továbblépésének ellenőrzése
        String expectedURL = "https://test.codeyard.eu/";
        Assertions.assertEquals(expectedURL,driver.getCurrentUrl());
    }

    @Test
    @Epic("Password Field")
    @Feature("Password confirmation validation")
    @Story("Different password")
    @Description("Jelszó mező és a jelszó megerősítése mező különböző jelszavak elfogadásának validációja")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("CYTC_36")
    @Issue("BUG_18")
    public void testPasswordFieldConfirmationDifferent() throws IOException, InterruptedException {
            //PAGEFACTORY
        FormPage formPage = (FormPage) PageFactory.Create("FormPage", driver);
        Tools tools = (Tools) PageFactory.Create("Tools", driver);

            //TEST

        String testDataA = "qX98l432“‘`|/\\";
        String testDataB = "qX98lBélaAHegyről";

        driver.findElement(formPage.passwordField).sendKeys(testDataA);
        driver.findElement(formPage.passwordRepeatField).sendKeys(testDataB);

        By[] elements ={
                formPage.lastNameField,
                formPage.firstNameField,
                formPage.emailField,
                formPage.userNameField,
                formPage.birthPlaceField};
        String[] dataSelector = {
                "lName",
                "fName",
                "email",
                "uName",
                "birthPlace"};

        tools.dataFiller(elements,dataSelector);
        driver.findElement(formPage.nextButton).click();

            //ASSERT

        Thread.sleep(1000);

        //Hibaüzenet megjelenésének ellenőrzése
        if(driver.findElements(formPage.passwordField).size()>0){
            Boolean result = tools.isCssPresent(driver.findElement(formPage.passwordField),"caret-color");
            Boolean expectedErrorMessage = true;
            Assertions.assertEquals(expectedErrorMessage,result);
        }

        takeScreenShot("Az oldal továbblépett és elfogadta az egyámstól különböző jelszavakat");

        //Oldal továbblépésének ellenőrzése
        String expectedURL = "https://test.codeyard.eu/";
        Assertions.assertEquals(expectedURL,driver.getCurrentUrl());
    }

    @Test
    @Epic("Password Field")
    @Feature("Password masking validation")
    @Story("Password field masking")
    @Description("Jelszó mező és a jelszó megerősítése mező maszkolása csillag karaktertípusokkal")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("CYTC_37")
    @Issue("BUG_19")
    public void testPasswordFieldMasking() throws InterruptedException {
            //PAGEFACTORY
        FormPage formPage = (FormPage) PageFactory.Create("FormPage", driver);
        Tools tools = (Tools) PageFactory.Create("Tools", driver);

            //TEST

        String testDataA = "qX98l432“‘`|/\\";
        String testDataB = "qX98lBélaAHegyről";

        driver.findElement(formPage.passwordField).sendKeys(testDataA);
        driver.findElement(formPage.passwordRepeatField).sendKeys(testDataB);

            //ASSERT

        Thread.sleep(1000);

        takeScreenShot("Az oldal nem maszkolja a Jelszó mezőt");

        //Maszkolás ellenőrzése
        //Az ellenőrzés alapja az input mező "type" attribútuma ami jelen esetben "password" kellene hogy legyen.
        String exceptedType = "password";
        String actualType = driver.findElement(formPage.passwordField).getAttribute("type");
        Assertions.assertEquals(exceptedType,actualType);
    }

    @Test
    @Epic("Birth Date Field")
    @Feature("Birth Date Validation")
    @Story("Back to the Future")
    @Description("Születési Dátum mező\n" +
            "ez itt egy jövőmenő.")
    @Severity(SeverityLevel.NORMAL)
    @Tag("CYTC_40")
    @Issue("BUG_21")
    public void testBirthDateFutureMan() throws InterruptedException, IOException {
            //PAGEFACTORY
        FormPage formPage = (FormPage) PageFactory.Create("FormPage", driver);
        Tools tools = (Tools) PageFactory.Create("Tools", driver);

            //TEST

        /*
        Nem szép, de a kevés rendelkezésre álló időbe most ez fért bele :) Jelenlegi formájában is működik!
        A helyes és stabil megoldás az lenne ha a tesztadatban szereplő dátumot String splitterrel feldarabolnám, tömbösíteném
        majd az évre, hónapra, napra lebontott elemeket külön változókba tenném.
        Ezután az adott változó nevét kikeresném a DOM-ból és a hozzátartozó DIV-et clickelném le.
        A rendszer idejével összehasonlítanám az így kinyert dátumot és ha a rendszer időnél későbbi dátumot kapnék keresném
        a hibaüzenetre vonatkozó piros színt a stíluslapból.

        Alternatív megoldásként még az is opció lenne ha az adott mai dátumnál későbbi dátum nem kiválaszható.
        Ez esetben még egyszerűbb lenne a teszt automatizálás, hisz csak a dátum kiválaszhatóságát kellene ellenőrizni.
         */
        driver.findElement(formPage.birthDayField).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div/div[1]/div/div/button")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div/div[1]/div/div/button")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div/ul/li[98]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div/div[2]/table/tbody/tr[4]/td[1]/button")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div/div[2]/table/tbody/tr[4]/td[3]/button")).click();
        Thread.sleep(1000);

        tools.requiredDataFiller();

        driver.findElement(formPage.nextButton).click();
        Thread.sleep(1000);

            //ASSERT

        //Hibaüzenet megjelenésének ellenőrzése

        if(driver.findElements(formPage.birthDayField).size()>0){
            Boolean result = tools.isCssPresent(driver.findElement(formPage.birthDayField),"caret-color");
            Boolean expectedErrorMessage = true;
            Assertions.assertEquals(expectedErrorMessage,result);
        }

        takeScreenShot("Az oldal továbblépett és elfogadta a nem elfogadható dátumot");

        //Oldal továbblépésének ellenőrzése
        String expectedURL = "https://test.codeyard.eu/";
        Assertions.assertEquals(expectedURL,driver.getCurrentUrl());
    }
}
