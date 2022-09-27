import org.openqa.selenium.WebDriver;

public class PageBase {

    static WebDriver driver;

    //Constructor
    public PageBase(WebDriver drv) {driver=drv;}

    // File locations

    public static String fillerDataFilePath = "fillerData.json";

}
