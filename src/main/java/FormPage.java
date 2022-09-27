import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormPage extends PageBase {
    //Constructor
    public FormPage(WebDriver drv){ super(drv);}

    //elements
    public By lastNameField = By.id("input-11");
    final By firstNameField = By.id("input-14");
    final By emailField = By.id("input-17");
    final By userNameField = By.id("input-20");
    final By passwordField = By.id("input-23");
    final By passwordRepeatField = By.id("input-26");
    final By birthPlaceField = By.id("input-29");
    final By birthDayField = By.id("input-33");
    final By phoneNumberField = By.id("input-37");
    final By languageField = By.id("input-40");


    final By nextButton = By.xpath("//*[@class=\"v-card__text button\"]/button");


}
