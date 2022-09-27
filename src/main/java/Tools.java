import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Tools extends PageBase{
    //Constructor
    public Tools(WebDriver drv){super(drv);}

    // Tools

    // Attribute tools
    public boolean isCssPresent(WebElement element, String cssvalue){
        boolean result = false;
        try{
            String value = element.getCssValue(cssvalue);
            if (!value.isBlank()){
                result = true;
            }
        } catch (Exception e){}
        return result;
    }

    // Filler tools
    public void dataFiller(By[] elements, String[] data) throws IOException {
        for (int i = 0; i < elements.length; i++) {
            driver.findElement(elements[i]).sendKeys(Keys.LEFT_CONTROL,"A");
            driver.findElement(elements[i]).sendKeys(readJsonObject(PageBase.fillerDataFilePath).getString(data[i]));
        }
    }

    public void requiredDataFiller() throws IOException {
        FormPage formPage = (FormPage) PageFactory.Create("FormPage", driver);
        Tools tools = (Tools) PageFactory.Create("Tools", driver);
        By[] elements ={
                formPage.firstNameField,
                formPage.lastNameField,
                formPage.emailField,
                formPage.userNameField,
                formPage.passwordField,
                formPage.passwordRepeatField,
                formPage.birthPlaceField};
        String[] dataSelector = {
                "fName",
                "lName",
                "email",
                "uName",
                "password",
                "passwordRep",
                "birthPlace"};
        tools.dataFiller(elements,dataSelector);
    }

    // JSON object-file methods

    public JSONObject readJsonObject(String filePath) throws IOException {
        String jsonDataAsString;
        jsonDataAsString = new String(Files.readAllBytes(Paths.get(filePath)));
        JSONObject jsonData = new JSONObject(jsonDataAsString);
        return jsonData;
    }

}
