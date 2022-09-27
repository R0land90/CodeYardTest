import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SummaryPage extends PageBase{
    //Constructor
    public SummaryPage(WebDriver drv){ super(drv);}

    //elements
    final By lastNameFieldSumm = By.xpath("//*[@id=\"summary\"]/div/div[2]/div[2]/div[1]");
    final By firstNameFieldSumm = By.xpath("//*[@id=\"summary\"]/div/div[2]/div[2]/div[2]");
    final By emailFieldSumm = By.xpath("//*[@id=\"summary\"]/div/div[3]/div[2]/div[1]");
    final By userNameFieldSumm = By.xpath("//*[@id=\"summary\"]/div/div[3]/div[2]/div[2]");
    final By birthPlaceFieldSumm = By.xpath("//*[@id=\"summary\"]/div/div[4]/div[2]/div[1]");
    final By birthDayFieldSumm = By.xpath("//*[@id=\"summary\"]/div/div[4]/div[2]/div[2]");
    final By phoneNumberFieldSumm = By.xpath("//*[@id=\"summary\"]/div/div[5]/div[2]/div");
    final By languageFieldSumm = By.xpath("//*[@id=\"summary\"]/div/div[6]/div[2]/div");
}
