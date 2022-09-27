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
        Boolean result = false;
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

    // JSON object-file methods

    public JSONObject readJsonObject(String filePath) throws IOException {
        String jsonDataAsString;
        jsonDataAsString = new String(Files.readAllBytes(Paths.get(filePath)));
        JSONObject jsonData = new JSONObject(jsonDataAsString);
        return jsonData;
    }

}
