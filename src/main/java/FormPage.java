import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormPage extends PageBase {
    //Constructor
    public FormPage(WebDriver drv){ super(drv);}

    //elements
    final By lastNameField = By.id("input-11");
    final By firstNameField = By.id("input-14");
    final By emailField = By.id("input-17");
    final By nextButton = By.xpath("//*[@class=\"v-card__text button\"]/button");


}
